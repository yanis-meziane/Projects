import { Link } from "react-router-dom";

export function Register(){
    return(
        <div>
            <h1> Je suis la page Register </h1>

            <p> Si tu as déjà un compte, <Link to={'/login'}>Connecte toi ici</Link> </p>
        </div>
    )
}