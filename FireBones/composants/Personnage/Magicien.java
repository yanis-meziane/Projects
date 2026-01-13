package composants.Personnage;
import composants.Equipement.Arme;
import composants.Equipement.Armure;

public class Magicien extends Personnage {

    public Magicien() {
        super();
    }

    public Magicien(String firstname, String lastname, int PV, int PM, int attaque, int defense, Arme arme, Armure armure) {
        super(firstname, lastname, PV, PM, attaque, defense, arme, armure);
    }

    @Override
    public String toString() {
        return "Le Magicien s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + arme;
    }
}