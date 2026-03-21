import { useState, useEffect } from "react";
import "./Stats.css";

export default function Stats() {
  const [trainingStats, setTrainingStats] = useState([]);
  const [tournamentStats, setTournamentStats] = useState([]);
  const [hatStats, setHatStats] = useState([]);
  const [indoorStats, setIndoorStats] = useState([]);
  const [outdoorStats, setOutdoorStats] = useState([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    const userId = localStorage.getItem('userId');

    // Stats entraînements
    fetch(`http://localhost:3001/api/stats/training/${userId}`)
      .then(res => res.json())
      .then(data => {
        if (data.success) setTrainingStats(data.stats);
        else setMessage('Erreur lors du chargement des stats entraînement');
      })
      .catch(() => setMessage('Erreur serveur'));

    // Stats tournois (compétitions)
    fetch(`http://localhost:3001/api/stats/tournaments/${userId}`)
      .then(res => res.json())
      .then(data => {
        if (data.success) setTournamentStats(data.stats);
        else setMessage('Erreur lors du chargement des stats tournois');
      })
      .catch(() => setMessage('Erreur serveur'));

    // Stats hat
    fetch(`http://localhost:3001/api/stats/hats/${userId}`)
      .then(res => res.json())
      .then(data => {
        if (data.success) setHatStats(data.stats);
        else setMessage('Erreur lors du chargement des stats hat');
      })
      .catch(() => setMessage('Erreur serveur'));

    // Stats indoor
    fetch(`http://localhost:3001/api/stats/indoor/${userId}`)
      .then(res => res.json())
      .then(data => {
        if (data.success) setIndoorStats(data.stats);
        else setMessage('Erreur lors du chargement des stats indoor');
      })
      .catch(() => setMessage('Erreur serveur'));

    // Stats outdoor
    fetch(`http://localhost:3001/api/stats/outdoor/${userId}`)
      .then(res => res.json())
      .then(data => {
        if (data.success) setOutdoorStats(data.stats);
        else setMessage('Erreur lors du chargement des stats outdoor');
      })
      .catch(() => setMessage('Erreur serveur'));
  }, []);

  // Table réutilisable pour les tournois (hat / indoor / outdoor / compétition)
  const TournamentTable = ({ data }) => (
    data.length === 0 ? (
      <p>Aucune donnée disponible</p>
    ) : (
      <table>
        <thead>
          <tr>
            <th>Nom du tournoi</th>
            <th>Lieu</th>
            <th>Année</th>
            <th>Nb matchs</th>
            <th>Goals</th>
            <th>Assists</th>
            <th>Victoires</th>
            <th>Défaites</th>
            <th>Classement final</th>
          </tr>
        </thead>
        <tbody>
          {data.map((row, index) => (
            <tr key={index}>
              <td>{row.tournament_name}</td>
              <td>{row.location}</td>
              <td>{row.annee}</td>
              <td>{row.nb_matchs}</td>
              <td>{row.goals}</td>
              <td>{row.assists}</td>
              <td>{row.wins}</td>
              <td>{row.losses}</td>
              <td>{row.final_ranking ?? '—'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    )
  );

  return (
    <div id="statsContainer">
      {message && <p className="errorMessage">{message}</p>}

      {/* Entraînements */}
      <div className="statsCard">
        <h1>Entraînement</h1>
        {trainingStats.length === 0 ? (
          <p>Aucune donnée disponible</p>
        ) : (
          <table>
            <thead>
              <tr>
                <th>Club</th>
                <th>Total goals</th>
                <th>Moyenne</th>
                <th>Moyenne assists</th>
              </tr>
            </thead>
            <tbody>
              {trainingStats.map((row, index) => (
                <tr key={index}>
                  <td>{row.club_name}</td>
                  <td>{row.total_goals}</td>
                  <td>{row.moyenne_par_semaine}</td>
                  <td>{row.assists_par_semaine}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>

      {/* Tournois (compétitions) */}
      <div className="statsCard">
        <h1>Tournois</h1>
        <TournamentTable data={tournamentStats} />
      </div>

      {/* Hat */}
      <div className="statsCard">
        <h1>Hat</h1>
        <TournamentTable data={hatStats} />
      </div>

      {/* Indoor */}
      <div className="statsCard">
        <h1>Indoor</h1>
        <TournamentTable data={indoorStats} />
      </div>

      {/* Outdoor */}
      <div className="statsCard">
        <h1>Outdoor</h1>
        <TournamentTable data={outdoorStats} />
      </div>
    </div>
  );
}