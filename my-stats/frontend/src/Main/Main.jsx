import { useNavigate } from "react-router-dom"
import "./Main.css"
import HamburgerMenu from "../HamburgerMenu/HamburgerMenu"

export default function Main(){

     const firstname = localStorage.getItem("firstname");

    const navigate = useNavigate();
    return(
        <div id="mainContainer">
            <HamburgerMenu />
                <section id="container">                    
                     {firstname && (
                        <p className="userGreeting">Bonjour, {firstname}</p>
                    )}
                    <article id="trainings">
                       <button onClick={() => navigate('/trainings')} className="buttonMain">
                            Entraînement
                        </button>
                    </article>

                    <article id="compet">
                        <button onClick={()=> navigate('/competition')} className="buttonMain">
                            Competition
                        </button>
                    </article>
                    
                    <article id="stats">
                       <button onClick={() => navigate('/stats')} className="buttonMain">Mes stats</button>
                    </article>

                </section>
        </div>
    )
}