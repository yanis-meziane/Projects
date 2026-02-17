const express = require('express');
const cors = require('cors');
const { Pool } = require('pg');
const bcrypt = require('bcrypt');
require('dotenv').config();


const app = express();
const PORT = 3000;

app.use(cors({
  origin: 'http://localhost:3000', 
  credentials: true
}));

// Middleware
app.use(express.json());

// Connexion avec la Base de données 

const pool = new Pool({
  user: 'postgres',
  host: '127.0.0.1',
  database: 'db_boxletter',
  password: '',
  port: 5432
});


// Test de connexion

pool.connect((err,release)=> {
    if(err){
        console.log('Erreur de connexion à la Base de Données :', err);
    }else{
        console.log('La connexion avec la Base de données a bien été établie !');
        release();
    }
});

const checkAdminRole = async (req, res, next) => {
  const userId = req.body.userId; 

  if (!userId) {
    return res.status(401).json({ success: false, message: 'Utilisateur non authentifié' });
  }

  try {
    const userCheck = await pool.query(
      'SELECT role FROM users WHERE user_id = $1',
      [userId]
    );

    if (userCheck.rows.length === 0) {
      return res.status(404).json({ success: false, message: 'Utilisateur non trouvé.' });
    }
    if (userCheck.rows[0].role.trim() !== 'admin') {
      return res.status(403).json({
        success: false,
        message: 'Accès refusé'
      });
    }
    next();

  } catch (error) {
    console.error('Erreur dans le middleware checkAdminRole:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur lors de la vérification des permissions.' });
  }
};

// Route de test
app.get('/api/test', (req, res) => {
  res.json({ message: 'API fonctionne correctement' });
});

app.post('/api/register', async (req, res) => {
  const { firstname, lastname, email, password } = req.body; 
  
  try {
    // Vérifier si l'email existe déjà
    const checkUser = await pool.query(
      'SELECT * FROM users WHERE email = $1',
      [email]
    );

    if (checkUser.rows.length > 0) {
      return res.status(400).json({
        success: false,
        message: 'Cet email est déjà utilisé'
      });
    }
    const userCount = await pool.query('SELECT COUNT(*) FROM users');
    const totalUsers = parseInt(userCount.rows[0].count);
    
    
    const role = totalUsers === 0 ? 'admin' : 'user'; 
    const hashedPassword = await bcrypt.hash(password, 10);

    const result = await pool.query(
      'INSERT INTO users (firstname, lastname, email, password, role) VALUES ($1, $2, $3, $4, $5) RETURNING user_id, firstname, lastname, email, role',
      [firstname, lastname, email, hashedPassword, role]
    );

   res.status(201).json({
  success: true,
  message: 'Utilisateur créé avec succès',
  user: result.rows[0]
});

  } catch (error) {
    console.error('Erreur inscription:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// Route de connexion
app.post('/api/login', async (req, res) => {
  const { email, password } = req.body;

  try {
    const result = await pool.query(
      'SELECT user_id, firstname, lastname, email, password, role FROM users WHERE email = $1',
      [email]
    );

    if (result.rows.length === 0) {
      return res.status(401).json({ success: false, message: 'Email ou mot de passe incorrect' });
    }

    const user = result.rows[0];
    const isPasswordValid = await bcrypt.compare(password, user.mdp);

    if (!isPasswordValid) {
      return res.status(401).json({ success: false, message: 'Email ou mot de passe incorrect' });
    }

    return res.status(200).json({
      success: true,
      type: user.role.trim(),
      userId: user.userid,
      firstname: user.firstname
    });

  } catch (error) {
    console.error('Erreur connexion:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});