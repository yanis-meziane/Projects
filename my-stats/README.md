# MyStats 

## Présentation 

*MyStats* est un projet personnel visant à faire un suivi des performances sportives en rentrant nos performances. Suite à cela, nous pourrons avoir accès à nos statistiques sur l'ensemble de l'année. 

## Technologies ulitisées 

* *Frontend :* React.js (v18.3.1) / npm (v10.8.2)
* *Backend :* Node.js (v18.20.8)
* *Base de données :* PostGreSQL
* *IDE :* VisualStudio Code 

## Comment faire marcher le projet ? 

1. *Initialisation du projet :* 

Ouvrez votre terminal dans votre IDE (e.g : VSCode) et rentrez la commande suivante : 

```bash
git clone https://github.com/yanis-meziane/Projects.git
```

Puis pour avoir la possibilité de modifier le projet en local sur votre machine, faites : 


```bash
git remove remote add origin
git push origin main
```

2. *Installation des dépendances et récupération de la base de données :*

Afin d'installer les dépendances et la base de données pour que le projet puisse fonctionner correctement, faites : 

```bash
npm install
```

```bash
cd my-stats # Pour vérifier d'avoir tous les documents
```

3. *Lancement du projet*

Dans un premier temps, dans le dossier ```./backend```vous retrouver le fichier ```.env.example```afin de créer la connection avec votre base de données. Le fichier devrait ressembler à ça : 

```
DB_USER= <votre_db_username>
DB_HOST=127.0.0.1
DB_NAME=MyStats
DB_PASSWORD=<Votre_mot_de_passe>
DB_PORT=5432
PORT=3001
FRONTEND_URL=http://localhost:3000
```

Ainsi vous mettez vos informations personnelles et vous devriez avoir la possibilité de connecter le projet avec la Base de données.

--- 

Une fois cela effectuée, vous ouvrez un second terminal pour faire ces commandes : 

**Dans le premier terminal :**

```bash
cd frontend 
npm start
```

**Dans le second terminal :**

```bash
cd backend 
npm start
```