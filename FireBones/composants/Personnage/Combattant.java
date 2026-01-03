package personnage;
public class Combattant extends Personnage{

    public Combattant(){
        super();
    }

    public Combattant(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme){
        super (firstname, lastname, PV, PM, attaque, defense, Arme);
    }

    @Override
    public String toString() {
        return "Le Combattant s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }
}