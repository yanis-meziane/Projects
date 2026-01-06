import composants.Personnage.Amazone;
import composants.Personnage.Barbare;
import composants.Personnage.Mage;
import composants.Personnage.Paladin;
import composants.Personnage.Pretre;
import composants.Monstre.Dragon;
import composants.Monstre.Gobelin;
import composants.Monstre.Vampire;


public class Main {
    public static void main(String[] args) {

        System.out.println("===Bienvenue à Firebones===");

        // Les personnages

        // Présentation Amazone

        Amazone amazone = Amazone.getAmazone();
        System.out.println("\n === AMAZONE === ");
        System.out.println(amazone);

        // Présentation Barbare

        Barbare barbare = Barbare.getBarbare();
        System.out.println("\n === BARBARE === ");
        System.out.println(barbare);

        // Présentation Mage

        Mage mage = Mage.getMage();
        System.out.println("\n === MAGE === ");
        System.out.println(mage);

        // Présentation Paladin

        Paladin paladin = Paladin.getPaladin();
        System.out.println("\n === PALADIN === ");
        System.out.println(paladin);

        // Présentation Prêtre

        Pretre pretre = Pretre.getPretre();
        System.out.println("\n === PRETRE === ");
        System.out.println(pretre);

        // Les monstres

            // Présentation dragon

            Dragon dragon = Dragon.getDragon();
            System.out.println("\n === DRAGON === ");
            System.out.println(dragon);

            // Présentation gobelin

            Gobelin gobelin = Gobelin.getGobelin();
            System.out.println("\n === GOBELIN === ");
            System.out.println(gobelin);

            // Présentation vampire

            Vampire vampire = Vampire.getVampire();
            System.out.println("\n === VAMPIRE === ");
            System.out.println(vampire);


    }
}