import { useNavigate } from "react-router-dom"
import "./Competition.css"

export default function Competition(){
    const navigate = useNavigate();

    return(
         <div id="competitionContainer">
                <h1>Competition</h1>
                <section id="competitions">
                    <article className="competitionBlocks">
                        <button onClick={()=> navigate('/competition/Indoor')}className="competitionButton">Indoor</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={()=>navigate('/competition/outdoor')}className="competitionButton">Outdoor</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={() =>navigate('/competition/tournois')}className="competitionButton">Tournois</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={() =>navigate('/competition/hat')}className="competitionButton">Hat</button>
                    </article>
                </section>
            </div>
    )
}