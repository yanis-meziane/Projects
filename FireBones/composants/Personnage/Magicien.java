package composants.Personnage;
public class Magicien extends Personnage {

    public Magicien() {
        super();
    }

    public Magicien(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme) {
        super(firstname, lastname, PV, PM, attaque, defense, Arme);
    }

    @Override
    public String toString() {
        return "Le Magicien s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }
}