import { useState, useEffect } from "react";

export default function Stats() {
  const [stats, setStats] = useState([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    const userId = localStorage.getItem('userId');

    fetch(`http://localhost:3001/api/stats/${userId}`)
      .then(res => res.json())
      .then(data => {
        if (data.success) {
          setStats(data.stats);
        } else {
          setMessage('Erreur lors du chargement des stats');
        }
      })
      .catch(() => setMessage('Erreur serveur'));
  }, []);

  return (
    <div>
      <h1>Mes statistiques</h1>

      {message && <p>{message}</p>}

      {stats.length === 0 ? (
        <p>Aucune donnée disponible</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Club</th>
              <th>Total goals</th>
              <th>Moyenne par semaine</th>
            </tr>
          </thead>
          <tbody>
            {stats.map((row, index) => (
              <tr key={index}>
                <td>{row.club_name}</td>
                <td>{row.total_goals}</td>
                <td>{row.moyenne_par_semaine}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}