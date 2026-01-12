package composants.Personnage;
public class Barbare extends Combattant {

    public Barbare() {
        super();
    }

    public Barbare(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme) {
        super(firstname, lastname, PV, PM, attaque, defense, Arme);
    }

    public static Barbare getBarbare(){
        return new Barbare("Conan", "Le Destructeur", 70, 15, 12, 7, "Hache");
    }

    @Override
    public String toString() {
        return "Le Barbare s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }
}