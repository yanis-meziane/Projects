import { Link } from "react-router-dom";

export function Login(){
    return(
        <div>
            <h1> Je suis la page Login </h1>

            <p>
                Si tu n'as pas encore de compte, <Link to={'/'}> crées toi ton compte</Link>
            </p>
        </div>
    )
}