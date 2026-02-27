import { useNavigate } from "react-router-dom";
import { useState } from "react";
import "./addClub.css"

export default function AddClub() {
    const [formData, setFormData] = useState({
        club_name: '',
        city: '',
        user_id: ''
    });
    const [error, setError] = useState('');
    const [success, setSuccess] = useState('');

    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setSuccess('');

        try {
            const response = await fetch('http://localhost:3001/api/addClub', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData)
            });

            const data = await response.json();

            if (data.success) {
                setSuccess('Ajout du club réussi ! Redirection...');
                setTimeout(() => {
                    navigate('/trainings');
                }, 1000);
            } else {
                setError(data.message || 'Erreur lors de l\'ajout du club');
            }
        } catch (error) {
            console.error('Erreur:', error);
            setError('Erreur de connexion au serveur');
        }
    };

    return (
        <div id="containerAdd">
            <form onSubmit={handleSubmit} id="formAdd">

                <span className="input-span">
                    <label htmlFor="firstname">Nom du club :</label>
                    <input
                        type="text"
                        name="clubName"
                        id="clubName"
                        placeholder="Nom du club"
                        minLength={1}
                        maxLength={30}
                        value={formData.firstname}
                        onChange={handleChange}
                        required
                    />
                </span>

                <span className="input-span">
                    <label htmlFor="lastname">Lieu :</label>
                    <input
                        type="text"
                        name="city"
                        id="city"
                        placeholder="Lieu..."
                        minLength={1}
                        maxLength={30}
                        value={formData.lastname}
                        onChange={handleChange}
                        required
                    />
                </span>

                {error && <p style={{ color: 'red' }}>{error}</p>}
                {success && <p style={{ color: 'green' }}>{success}</p>}

                <input className="submit" type="submit" defaultValue="Valider" />

            </form>
        </div>
    );
}