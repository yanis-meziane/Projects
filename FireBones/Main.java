import composants.Personnage.Amazone;
import composants.Personnage.Barbare;
import composants.Personnage.Mage;
import composants.Personnage.Paladin;
import composants.Personnage.Pretre;
import composants.Monstre.Dragon;
import composants.Monstre.Gobelin;
import composants.Monstre.Vampire;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("===Bienvenue à Firebones===\n");
        System.out.println("Sur les terres d'Arcus, vous devrez terrasser différents monstres pour libérer les villageois en détresse.\n");
        System.out.println("Au cours de votre aventure vous combatrez différents monstres de plus en plus dur ! Donc soyez sur vos gardes et bonne chance \n");

        //Initialisation du jeu

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comment t'appelles-tu ? \n");
        String firstname = scanner.nextLine();

        System.out.println("Bienvenue " + firstname + " dans ces terre sacrées ! Votre objectif est de battre trois monstres qui sont venus envahir nos saintes terres ! Es-tu prêt.e.s à te lancer dans cette formidable aventure ?");

        int choix;
        boolean saisieValide = false;

        do {
            System.out.println("Possibilité : ");
            System.out.println("1. Oui");
            System.out.println("2. Non");
            System.out.println("Veuillez choisir une option :");

            try {
                choix = scanner.nextInt();
                if (choix == 1 || choix == 2) {
                    saisieValide = true;
                    switch(choix) {
                        case 1:
                            System.out.println("Très bon choix ! \n");
                            System.out.println("L'objectif est le suivant : Je vais te présenter tous les personnages jouables ! Tu pourras en choisir qu'un seul pour toute l'aventure!\n");
                            System.out.println("une fois ton personnage choisi, tu devras affronter en tout 4 monstres sous le système de tour par tour ! Chaque fois que tu battras un monstre, tu passeras au suivant\n");
                            System.out.println("Le système de jeu est qu'à chaque tour, tu auras la possibilité de soit Attaquer(A), t'enfuire (E) avec une chance de 2/5 que ça fonctionne, utiliser ta capacité spéciale (CS) ! Chaque action vaut pour un tour et ça passera automatiquement au tour des Monstres ! Bon courage !\n");
                            break;

                        case 2:
                            System.out.println("N'hésites pas à venir tenter l'aventure quand le courage sera entre vos mains");
                            break;

                        default:
                            System.out.println("Choix invalide ! Veuillez choisir une option valide");
                            break;
                    }
                } else {
                    System.out.println("Erreur de saisie ! Mettez 1 ou 2");
                }
            } catch(Exception e) {
                System.out.println("Erreur de saisie de valeur. Entrez une valeur valide !");
                scanner.nextLine();
            }

        } while (!saisieValide);

        /*
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
*/
        /*
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
            System.out.println(vampire);*/


    }
}