import { useNavigate } from "react-router-dom"
import "./Trainings.css"

export default function Trainings() {
    const navigate = useNavigate();

    return (
        <div id="trainingContainer">
            <h1>Trainings</h1>
            <section id="trainings">
                <article className="trainingsBlocks">
                    <button onClick={() => navigate('/trainings/fauv')} className="trainingsButton">
                        Fauv
                    </button>
                </article>

                <article className="trainingsBlocks">
                    <button onClick={() => navigate('/trainings/phoenix')} className="trainingsButton">
                        Phœnix
                    </button>
                </article>

                <article className="trainingsBlocks">
                    <button onClick={() => navigate('/trainings/lutece')} className="trainingsButton">
                        Lutèce
                    </button>
                </article>

                <article className="trainingsBlocks">
                    <button onClick={() => navigate('/trainings/revo')} className="trainingsButton">
                        Révolution'Air
                    </button>
                </article>

                <article className="trainingsBlocks">
                    <button onClick={() => navigate('/trainings/addClub')} className="trainingsButton">
                        + Ajouter un club
                    </button>
                </article>
            </section>
        </div>
    );
}