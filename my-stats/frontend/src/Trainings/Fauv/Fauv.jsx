import { useState, useEffect } from "react";

export default function Fauv() {
  const [clubId, setClubId] = useState(null);
  const [formData, setFormData] = useState({ date: '', goals: 0 });
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('http://localhost:3001/api/clubs')
      .then(res => res.json())
      .then(data => {
        console.log('Clubs reçus :', data);
        const fauv = data.clubs.find(club => club.club_name === 'Fauv');
        setClubId(fauv.club_id);
      });
  }, []);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const userId = localStorage.getItem('userId');

     // Transforme YYYY-MM-DD en YYYY/MM/DD
        const formattedDate = formData.date.replace(/-/g, '/');

    try {
      const response = await fetch('http://localhost:3001/api/trainings', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ userId, clubId, ...formData, date :formattedDate})
      });

      const data = await response.json();
      setMessage(data.success ? 'Entraînement enregistré !' : data.message);
      setTimeout(() => {
        window.location.reload();
      },1000)
    } catch (err) {
      setMessage('Erreur serveur');
    }
  };

  return (
    <div>
      <h1>Fauv — Ajouter un entraînement</h1>

      <form onSubmit={handleSubmit}>
        <label>Date :
          <input type="date" name="date" value={formData.date} onChange={handleChange} required />
        </label>

        <label>Goals :
          <input type="number" name="goals" min="0" value={formData.goals} onChange={handleChange} />
        </label>

        <button type="submit">Enregistrer</button>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}