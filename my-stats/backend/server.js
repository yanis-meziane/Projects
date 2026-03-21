const express = require('express');
const cors = require('cors');
const { Pool } = require('pg');
const bcrypt = require('bcrypt');
require('dotenv').config();

const app = express();
const PORT = 3001;

app.use(cors({
  origin: 'http://localhost:3000',
  credentials: true
}));

app.use(express.json());

const pool = new Pool({
  user: process.env.DB_USER,       
  host: process.env.DB_HOST,
  database: process.env.DB_NAME,
  password: process.env.DB_PASSWORD,
  port: process.env.DB_PORT
});

pool.connect((err, client, release) => {
  if (err) {
    console.log('Erreur de connexion à la Base de Données :', err);
  } else {
    console.log('Connexion avec la Base de données établie !');
    release();
  }
});

const checkAdminRole = async (req, res, next) => {
  const userId = req.body.userId;

  if (!userId) {
    return res.status(401).json({ success: false, message: 'Utilisateur non authentifié' });
  }

  try {
    const userCheck = await pool.query('SELECT role FROM users WHERE user_id = $1', [userId]);

    if (userCheck.rows.length === 0) {
      return res.status(404).json({ success: false, message: 'Utilisateur non trouvé.' });
    }
    if (userCheck.rows[0].role.trim() !== 'admin') {
      return res.status(403).json({ success: false, message: 'Accès refusé' });
    }
    next();
  } catch (error) {
    console.error('Erreur middleware checkAdminRole:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur.' });
  }
};

app.get('/api/test', (req, res) => {
  res.json({ message: 'API fonctionne correctement' });
});

app.post('/api/register', async (req, res) => {
  const { firstname, lastname, email, password } = req.body;

  try {
    const checkUser = await pool.query('SELECT * FROM users WHERE email = $1', [email]);

    if (checkUser.rows.length > 0) {
      return res.status(400).json({ success: false, message: 'Cet email est déjà utilisé' });
    }

    const userCount = await pool.query('SELECT COUNT(*) FROM users');
    //const totalUsers = Number.parseInt(userCount.rows[0].count); --> Variable non utilisée
    const role = Number.totalUsers === 0 ? 'admin' : 'user';

    const hashedPassword = await bcrypt.hash(password, 10);

    const result = await pool.query(
      'INSERT INTO users (firstname, lastname, email, password, role) VALUES ($1, $2, $3, $4, $5) RETURNING user_id, firstname, lastname, email, role',
      [firstname, lastname, email, hashedPassword, role]
    );

    const newUserId = result.rows[0].user_id;

    // Créer automatiquement les 4 clubs pour ce nouvel utilisateur
    await pool.query(
      `INSERT INTO clubs (club_name, city, user_id) VALUES
        ('Fauv', 'Vincennes', $1),
        ('Phœnix', 'Montrouge', $1),
        ('Lutèce', 'Paris', $1),
        ('Révolution''Air', 'Paris', $1)`,
      [newUserId]
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
    const isPasswordValid = await bcrypt.compare(password, user.password);

    if (!isPasswordValid) {
      return res.status(401).json({ success: false, message: 'Email ou mot de passe incorrect' });
    }

    return res.status(200).json({
      success: true,
      type: user.role.trim(),
      userId: user.user_id, 
      firstname: user.firstname
    });

  } catch (error) {
    console.error('Erreur connexion:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Ajout club

app.post('/api/addClub', async(req,res)=>{
  const {userId,clubName,city} = req.body;

  if (!userId || !clubName || !city) {
    return res.status(400).json({ success: false, message: 'Champs obligatoires manquants' });
  }

  try {
    const result = await pool.query(
      `INSERT INTO clubs (user_id, club_name, city)
       VALUES ($1, $2, $3)
       RETURNING *`,
      [userId, clubName, city, ]
    );

    res.status(201).json({ success: true, training: result.rows[0] });
  } catch (error) {
    console.error('Erreur ajout entraînement:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
})

// API Clubs 

app.get('/api/clubs', async (req, res) => {
  try {
    const result = await pool.query('SELECT club_id, club_name, city FROM clubs');
    res.status(200).json({ success: true, clubs: result.rows });
  } catch (error) {
    console.error('Erreur récupération clubs:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Trainings

app.post('/api/trainings', async (req, res) => {
  const {userId, clubId, date, goals,assists } = req.body;

  if (!userId || !clubId || !date) {
    return res.status(400).json({ success: false, message: 'Champs obligatoires manquants' });
  }

  try {
    const result = await pool.query(
      `INSERT INTO trainings (user_id, club_id, date, goals, assists)
       VALUES ($1, $2, $3, $4, $5)
       RETURNING *`,
      [userId, clubId, date, goals || 0, assists || 0]
    );

    res.status(201).json({ success: true, training: result.rows[0] });
  } catch (error) {
    console.error('Erreur ajout entraînement:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Competitions (Tournois)

app.post('/api/competitions', async (req, res) => {
  const { userId, name, location, date, nb_matchs, goals, assists, wins, losses, final_ranking } = req.body;

  if (!userId || !name || !date) {
    return res.status(400).json({ success: false, message: 'Champs obligatoires manquants' });
  }

  try {
    const result = await pool.query(
      `INSERT INTO tournois (user_id, name, location, date, nb_matchs, goals, wins, losses, final_ranking)
       VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10)
       RETURNING *`,
      [userId, name, location, date, nb_matchs || 0, goals || 0, assists || 0,  wins || 0, losses || 0, final_ranking || null]
    );

    res.status(201).json({ success: true, competition: result.rows[0] });
  } catch (error) {
    console.error('Erreur ajout compétition:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Hat

app.post('/api/hat', async (req, res) => {
  const { userId, name, location, date, nb_matchs, goals, assists, wins, losses, final_ranking } = req.body;

  if (!userId || !name || !date) {
    return res.status(400).json({ success: false, message: 'Champs obligatoires manquants' });
  }

  try {
    const result = await pool.query(
      `INSERT INTO hats (user_id, name, location, date, nb_matchs, goals, assists, wins, losses, final_ranking)
       VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10)
       RETURNING *`,
      [userId, name, location, date, nb_matchs || 0, goals || 0, assists || 0, wins || 0, losses || 0, final_ranking || null]
    );

    res.status(201).json({ success: true, hat: result.rows[0] });
  } catch (error) {
    console.error('Erreur ajout hat:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Indoor (championnat)

app.post('/api/indoor', async (req, res) => {
  const { userId, name, location, date, nb_matchs, goals, assists, wins, losses, final_ranking } = req.body;

  if (!userId || !name || !date) {
    return res.status(400).json({ success: false, message: 'Champs obligatoires manquants' });
  }

  try {
    const result = await pool.query(
      `INSERT INTO championnat (user_id, name, location, date, nb_matchs, goals, assists, wins, losses, final_ranking)
       VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10)
       RETURNING *`,
      [userId, name, location, date, nb_matchs || 0, goals || 0, assists || 0,  wins || 0, losses || 0, final_ranking || null]
    );

    res.status(201).json({ success: true, indoor: result.rows[0] });
  } catch (error) {
    console.error('Erreur ajout indoor:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Outdoor

app.post('/api/outdoor', async (req, res) => {
  const { userId, name, location, date, nb_matchs, goals, wins, assists, losses, final_ranking } = req.body;

  if (!userId || !name || !date) {
    return res.status(400).json({ success: false, message: 'Champs obligatoires manquants' });
  }

  try {
    const result = await pool.query(
      `INSERT INTO championnat (user_id, name, location, date, nb_matchs, goals, assists, wins, losses, final_ranking)
       VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10)
       RETURNING *`,
      [userId, name, location, date, nb_matchs || 0, goals || 0, assists || 0, wins || 0, losses || 0, final_ranking || null]
    );

    res.status(201).json({ success: true, outdoor: result.rows[0] });
  } catch (error) {
    console.error('Erreur ajout outdoor:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Stats - Entraînements

app.get('/api/stats/training/:userId', async (req, res) => {
  const { userId } = req.params;

  try {
    const result = await pool.query(`
      SELECT club_name, year, nb_sessions, total_goals, moyenne_par_semaine
      FROM stats_training_per_club
      WHERE user_id = $1
    `, [userId]);

    res.status(200).json({ success: true, stats: result.rows });
  } catch (error) {
    console.error('Erreur récupération stats entraînement:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Stats - Tournois (competitions)

app.get('/api/stats/tournaments/:userId', async (req, res) => {
  const { userId } = req.params;

  try {
    const result = await pool.query(`
      SELECT name AS tournament_name, location, year AS annee,
             nb_matchs, goals, assists, wins, losses, final_ranking
      FROM tournois
      WHERE user_id = $1
      ORDER BY year DESC, name
    `, [userId]);

    res.status(200).json({ success: true, stats: result.rows });
  } catch (error) {
    console.error('Erreur récupération stats tournois:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Stats - Hat

app.get('/api/stats/hats/:userId', async (req, res) => {
  const { userId } = req.params;

  try {
    const result = await pool.query(`
      SELECT name AS tournament_name, location, year AS annee,
             nb_matchs, goals, assists, wins, losses, final_ranking
      FROM hats
      WHERE user_id = $1
      ORDER BY year DESC, name
    `, [userId]);

    res.status(200).json({ success: true, stats: result.rows });
  } catch (error) {
    console.error('Erreur récupération stats hat:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Stats - Indoor (championnat)

app.get('/api/stats/indoor/:userId', async (req, res) => {
  const { userId } = req.params;

  try {
    const result = await pool.query(`
      SELECT name AS tournament_name, location, year AS annee,
             nb_matchs, goals, assists, wins, losses, final_ranking
      FROM championnat
      WHERE user_id = $1
      ORDER BY year DESC, name
    `, [userId]);

    res.status(200).json({ success: true, stats: result.rows });
  } catch (error) {
    console.error('Erreur récupération stats indoor:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

// API Stats - Outdoor

app.get('/api/stats/outdoor/:userId', async (req, res) => {
  const { userId } = req.params;

  try {
    const result = await pool.query(`
      SELECT name AS tournament_name, location, year AS annee,
             nb_matchs, goals, assists, wins, losses, final_ranking
      FROM championnat
      WHERE user_id = $1
      ORDER BY year DESC, name
    `, [userId]);

    res.status(200).json({ success: true, stats: result.rows });
  } catch (error) {
    console.error('Erreur récupération stats outdoor:', error);
    res.status(500).json({ success: false, message: 'Erreur serveur' });
  }
});

app.listen(PORT, () => {
  console.log(`Serveur démarré sur le port ${PORT}`);
});