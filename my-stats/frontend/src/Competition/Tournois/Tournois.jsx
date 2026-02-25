export default function Tournois(){
    return(
        <div id="phoenixContainer">
      <form onSubmit={handleSubmit} className="tournoisForm">
        <h1>Tournois — Ajouter un entraînement</h1>

        <article className="ptournoisArticle">
          <label>Date :
            <input type="date" name="date" value={formData.date} onChange={handleChange} required />
          </label>
        </article>

        <article className="tournoisArticle">
          <label>Goals :
            <input type="number" name="goals" min="0" value={formData.goals} onChange={handleChange} />
          </label>
        </article>

        <article className="tournoisArticle">
          <input id="submit" type="submit" defaultValue="Valider" />
        </article>
      </form>

      {message && <p>{message}</p>}
    </div>
    )
}