import { useState, useEffect } from "react";
import "./Lutece.css"

export default function Lutece() {
  const [clubId, setClubId] = useState(null);
  const [formData, setFormData] = useState({ date: '', goals: 0 });
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('http://localhost:3001/api/clubs')
      .then(res => res.json())
      .then(data => {
        console.log('Clubs reçus :', data);
        const lutece = data.clubs.find(club => club.club_name === 'Lutèce');
        setClubId(lutece.club_id);
      });
  }, []);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const userId = localStorage.getItem('userId');

    const formattedDate = formData.date.replace(/-/g, '/');

    try {
      const response = await fetch('http://localhost:3001/api/trainings', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ userId, clubId, ...formData, date: formattedDate })
      });

      const data = await response.json();
      setMessage(data.success ? 'Entraînement enregistré !' : data.message);
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    } catch (err) {
      setMessage('Erreur serveur');
    }
  };

  return (
    <div id="luteceContainer">
      <form onSubmit={handleSubmit} className="luteceForm">
        <h1>Lutèce — Ajouter un entraînement</h1>

        <article className="luteceArticle">
          <label>
            <span>Date : </span>
            <input type="date" name="date" value={formData.date} onChange={handleChange} required />
          </label>
        </article>

        <article className="luteceArticle">
          <label>
            <span>Nombre de points : </span>
            <input type="number" name="goals" min="0" value={formData.goals} onChange={handleChange} />
          </label>
        </article>

         <article className="luteceArticle">
          <label>
            <span>Nombre d'assists : </span>
            <input type="number" name="assists" min="0" value={formData.goals} onChange={handleChange} />
          </label>
        </article>

        <article className="luteceArticle">
          <input id="submit" type="submit" defaultValue="Valider" />
        </article>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}