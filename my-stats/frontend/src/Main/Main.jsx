import { useNavigate } from "react-router-dom"

export default function Main(){

    const navigate = useNavigate();
    return(
        <div>
            <h1>Bonjour vous êtes sur la page Main</h1>

            <div id="mainContainer">
                <section id="container">
                    <article id="trainings">
                       <button onClick={() => navigate('/Trainings')}>
                            Entraînement
                        </button>
                    </article>

                    <article id="compet">
                        <button onClick={()=> navigate('/Competition')}>
                            Competition
                        </button>
                    </article>
                </section>
            </div>
        </div>
    )
}