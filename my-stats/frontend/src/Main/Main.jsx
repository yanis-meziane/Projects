import { useNavigate } from "react-router-dom"

export default function Main(){

    const navigate = useNavigate();
    return(
        <div>
           

            <div id="mainContainer">
                <section id="container">
                    <article id="trainings">
                       <button onClick={() => navigate('/trainings')}>
                            Entraînement
                        </button>
                    </article>

                    <article id="compet">
                        <button onClick={()=> navigate('/competition')}>
                            Competition
                        </button>
                    </article>
                    
                    <article id="stats">
                       <button onClick={() => navigate('/stats')}>Mes stats</button>
                    </article>

                </section>
            </div>
        </div>
    )
}