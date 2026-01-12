package composants.Personnage;
import composants.Equipement.Arme;
import composants.Equipement.Armure;
public class Mage extends Magicien {

    public Mage() {
        super();
    }

    public Mage(String firstname, String lastname, int PV, int PM, int attaque, int defense, String arme, String armure) {
        super(firstname, lastname, PV, PM, attaque, defense, arme, armure);
    }

    public static Mage getMage(){
        return new Mage("Gandalf", "Le Gris", 90, 150, 18, 12, Arme.getGrimoire(), Armure.getArmureLourde());
    }

    @Override
    public String toString() {
        return "Le Mage s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + arme + "\n" +
                "Armure :" + armure;
    }
}