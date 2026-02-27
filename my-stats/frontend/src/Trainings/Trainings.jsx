import { useNavigate } from "react-router-dom"
import { useState, useEffect } from "react"
import "./Trainings.css"

export default function Trainings() {
    const navigate = useNavigate();
    const [clubs, setClubs] = useState([]);
    const userId = localStorage.getItem('userId');

    useEffect(() => {
        fetch(`http://localhost:3001/api/clubs?userId=${userId}`)
            .then(res => res.json())
            .then(data => {
                if (data.success) setClubs(data.clubs);
            })
            .catch(err => console.error('Erreur chargement clubs:', err));
    }, []);

    const handleClubClick = (clubId, clubName) => {
        navigate(`/trainings/club/${clubId}`, { state: { clubId, clubName } });
    };

    return (
        <div id="trainingContainer">
            <h1>Trainings</h1>
            <section id="trainings">
                {clubs.map(club => (
                    <article key={club.club_id} className="trainingsBlocks">
                        <button
                            onClick={() => handleClubClick(club.club_id, club.club_name)}
                            className="trainingsButton"
                        >
                            {club.club_name}
                        </button>
                    </article>
                ))}

                <article className="trainingsBlocks">
                    <button onClick={() => navigate('/trainings/addClub')} className="trainingsButton">
                        + Ajouter un club
                    </button>
                </article>
            </section>
        </div>
    );
}