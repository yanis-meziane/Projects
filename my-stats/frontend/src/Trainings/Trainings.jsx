import { useNavigate } from "react-router-dom"

export default function Trainings(){
    const navigate = useNavigate();
    return(
        <div>
            <h1>Je suis la page trainings</h1>

            <div id="trainingContainer">
                <section id="trainings">
                    <article className="trainingsBlocks">
                        <button onClick={() => navigate('/trainings/fauv')}>Les Fauv</button>
                    </article>

                    <article className="trainingsBlocks">
                        <button onClick={()=> navigate('/trainings/lutece')}>Les Lutèces</button>
                    </article>

                    <article className="trainingsBlocks">
                        <button onClick={()=>navigate('/trainings/phoenix')}>Les Phœnix</button>
                    </article>
                </section>
            </div>
        </div>
    )
}