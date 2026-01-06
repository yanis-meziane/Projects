package composants.Personnage;
public class Pretre extends Magicien {

    public Pretre() {
        super();
    }

    public Pretre(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme) {
        super(firstname, lastname, PV, PM, attaque, defense, Arme);
    }

    public static Pretre getPretre(){
        return new Pretre("Benedictus", "Le Guérisseur", 100, 120, 10, 18, "Masse");
    }

    @Override
    public String toString() {
        return "Le Prêtre s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }
}