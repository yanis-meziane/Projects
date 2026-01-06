package composants.Personnage;
public class Paladin extends Combattant {

    public Paladin() {
        super();
    }

    public Paladin(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme) {
        super(firstname, lastname, PV, PM, attaque, defense, Arme);
    }

    public static Paladin getPaladin(){
        return new Paladin("Luc", "Skywalker", 80, 100, 15, 10, "Mains magiques");
    }

    @Override
    public String toString() {
        return "Le Paladin s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }
}