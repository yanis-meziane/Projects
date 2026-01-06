package composants.Personnage;
public class Amazone extends Combattant {
    public Amazone() {
        super();
    }

    public Amazone(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme) {
        super(firstname, lastname, PV, PM, attaque, defense, Arme);
    }

    public static Amazone getAmazone(){
        return new Amazone("Julie", "Harpie", 50, 35, 8, 12, "Arc");
    }

    @Override
    public String toString() {
        return "L'Amazone s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }

}

