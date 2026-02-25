import { useState } from "react";
import "./Hat.css";

export default function Hat() {
  const [formData, setFormData] = useState({
    date: '',
    name: '',
    location: '',
    nb_matchs: 0,
    goals: 0,
    wins: 0,
    losses: 0,
    final_ranking: ''
  });
  const [message, setMessage] = useState('');

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const userId = localStorage.getItem('userId');

    try {
      const response = await fetch('http://localhost:3001/api/hat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ userId, ...formData })
      });

      const data = await response.json();
      setMessage(data.success ? 'Hat enregistré !' : data.message);
      if (data.success) {
        setTimeout(() => window.location.reload(), 1000);
      }
    } catch (err) {
      setMessage('Erreur serveur');
    }
  };

  return (
    <div id="hatContainer">
      <form onSubmit={handleSubmit} className="hatForm">
        <h1>Hat — Ajouter une compétition</h1>

        <article className="hatArticle">
          <label>Nom du hat :
            <input type="text" name="name" value={formData.name} onChange={handleChange} required />
          </label>
        </article>

        <article className="hatArticle">
          <label>Lieu :
            <input type="text" name="location" value={formData.location} onChange={handleChange} />
          </label>
        </article>

        <article className="hatArticle">
          <label>Date :
            <input type="date" name="date" value={formData.date} onChange={handleChange} required />
          </label>
        </article>

        <article className="hatArticle">
          <label>Nombre de matchs :
            <input type="number" name="nb_matchs" min="0" value={formData.nb_matchs} onChange={handleChange} />
          </label>
        </article>

        <article className="hatArticle">
          <label>Goals :
            <input type="number" name="goals" min="0" value={formData.goals} onChange={handleChange} />
          </label>
        </article>

        <article className="hatArticle">
          <label>Victoires :
            <input type="number" name="wins" min="0" value={formData.wins} onChange={handleChange} />
          </label>
        </article>

        <article className="hatArticle">
          <label>Défaites :
            <input type="number" name="losses" min="0" value={formData.losses} onChange={handleChange} />
          </label>
        </article>

        <article className="hatArticle">
          <label>Classement final :
            <input type="number" name="final_ranking" min="1" value={formData.final_ranking} onChange={handleChange} />
          </label>
        </article>

        <article className="hatArticle">
          <input id="submitHat" type="submit" value="Valider" />
        </article>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}