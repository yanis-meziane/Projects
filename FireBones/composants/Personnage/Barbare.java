package composants.Personnage;
import composants.Equipement.Arme;
import composants.Equipement.Armure;
public class Barbare extends Combattant {

    public Barbare() {
        super();
    }

    public Barbare(String firstname, String lastname, int PV, int PM, int attaque, int defense, Arme arme, Armure armure) {
        super(firstname, lastname, PV, PM, attaque, defense, arme, armure);
    }

    public static Barbare getBarbare(){
        return new Barbare("Conan", "Le Destructeur", 70, 15, 12, 7, Arme.getEpee(), Armure.getArmureMoyenne());
    }

    @Override
    public String toString() {
        return "Le Barbare s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + arme + "\n" +
                "Armure : " + armure;
    }
}