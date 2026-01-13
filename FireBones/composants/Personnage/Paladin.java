package composants.Personnage;
import composants.Equipement.Arme;
import composants.Equipement.Armure;
public class Paladin extends Combattant {

    public Paladin() {
        super();
    }

    public Paladin(String firstname, String lastname, int PV, int PM, int attaque, int defense, String arme, String armure) {
        super(firstname, lastname, PV, PM, attaque, defense, arme, armure);
    }

    public static Paladin getPaladin(){
        return new Paladin("Luc", "Skywalker", 80, 100, 15, 10, Arme.getMarteau(), Armure.getArmureLourde());
    }

    @Override
    public String toString() {
        return "Le Paladin s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + arme + "\n" +
                "Armure : " + armure;
    }
}