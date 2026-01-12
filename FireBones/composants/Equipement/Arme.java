package composant.Equipement;

public class Arme{
    protected String name;
    protected int damage;
    protected String typeElementaire;

    Arme(){
        this.name = "Poing";
        this.damage = 2;
        this.typeElementaire = "Neutre"
    }

    Arme(String name, int damage, String typeElementaire){
        this.name = name;
        this.damage = damage;
        this.typeElementaire = typeElementaire;
    }

    // Les setters

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTypeElementaire(String typeElementaire){
        this.typeElementaire = typeElementaire;
    }

    // Les getter


    public String getName() {
        return this.name;
    }

    public int getDamage(){
        return this.damage;
    }

    public String getTypeElementaire() {
        return typeElementaire;
    }

    // Armes prédéfinies

    public static Arme getArc(){
        return  new Arme("Arc",5,"Bois");
    }

    public static Arme getEpee(){
        return new Arme("Epée",3,"Metal");
    }

    public static Arme getGrimoire(){
        return Arme("Grimoire",7,"Eau");
    }

    public static Arme getMarteau(){
        return  Arme("Marteau",4,"Feu");
    }

    public  static Arme getDague(){
        return Arme("Dague",7,"Terre");
    }

    @Override
    public String toString() {
        return "L'arme que tu as est : " + name + "\n" +
                "Fait tant : " + damage + " de damage" + "\n" +
                 "\n" +
                "Son type élémentaire est : " + typeElementaire;
    }

}