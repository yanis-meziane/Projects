import { useNavigate } from "react-router-dom"

export default function Competition(){
    const navigate = useNavigate();

    return(
        <div>
            <h1>Je suis la page Compet</h1>

         <div id="competitionContainer">
                <section id="competitions">
                    <article className="competitionBlocks">
                        <button onClick={() => navigate('/competition/Beach')}>Beach</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={()=> navigate('/competition/Indoor')}>Indoor</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={()=>navigate('/competition/outdoor')}>Outdoor</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={() =>navigate('/competition/tournois')}>Tournois</button>
                    </article>

                    <article className="competitionBlocks">
                        <button onClick={() =>navigate('/competition/hat')}>Hat</button>
                    </article>
                </section>
            </div>

        </div>
    )
}