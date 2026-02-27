import { useNavigate } from "react-router-dom"
import "./Trainings.css"

export default function Trainings(){
    const navigate = useNavigate();
    return(
        <div id="trainingContainer">
            <h1> Trainings</h1>
           
                <section id="trainings">
                    <article className="trainingsBlocks">
                        <button onClick={() => navigate('/trainings/fauv')} className="trainingsButton">Les Fauv</button>
                    </article>

                    <article className="trainingsBlocks">
                        <button onClick={()=> navigate('/trainings/lutece')} className="trainingsButton">Les Lutèces</button>
                    </article>

                    <article className="trainingsBlocks">
                        <button onClick={()=>navigate('/trainings/phoenix')} className="trainingsButton">Les Phœnix</button>
                    </article>

                    <article className="trainingsBlocks">
                        <button onClick={()=>navigate('/trainings/revo')} className="trainingsButton">Les Revo</button>
                    </article>
                </section>
        </div>
    )
}