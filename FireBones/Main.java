import composants.Personnage.*;
import composants.Monstre.*;
import composants.Combat.Combat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===Bienvenue à Firebones===\n");
        System.out.println("Sur les terres d'Arcus, vous devrez terrasser différents monstres pour libérer les villageois en détresse.\n");
        System.out.println("Au cours de votre aventure vous combatrez différents monstres de plus en plus dur ! Donc soyez sur vos gardes et bonne chance\n");

        // Initialisation du jeu
        System.out.println("Comment t'appelles-tu ?\n");
        String firstname = scanner.nextLine();

        System.out.println("Bienvenue " + firstname + " dans ces terres sacrées ! Votre objectif est de battre trois monstres qui sont venus envahir nos saintes terres ! Es-tu prêt.e.s à te lancer dans cette formidable aventure ?");

        int choix = 0;
        boolean saisieValide = false;

        do {
            System.out.println("Possibilité : ");
            System.out.println("1. Oui");
            System.out.println("2. Non");
            System.out.println("Veuillez choisir une option :");

            try {
                choix = scanner.nextInt();
                scanner.nextLine();

                if (choix == 1 || choix == 2) {
                    saisieValide = true;

                    switch(choix) {
                        case 1:
                            System.out.println("Très bon choix !\n");
                            System.out.println("L'objectif est le suivant : Je vais te présenter tous les personnages jouables ! Tu pourras en choisir qu'un seul pour toute l'aventure!\n");
                            System.out.println("Une fois ton personnage choisi, tu devras affronter en tout 3 monstres sous le système de tour par tour ! Chaque fois que tu battras un monstre, tu passeras au suivant\n");
                            System.out.println("Le système de jeu est qu'à chaque tour, tu auras la possibilité de soit Attaquer, utiliser ta capacité spéciale, te défendre, te soigner ou fuir ! Chaque action vaut pour un tour et ça passera automatiquement au tour des Monstres ! Bon courage !\n");

                            // Présentation des personnages
                            Amazone amazone = Amazone.getAmazone();
                            System.out.println("1. " + amazone + "\n");

                            Barbare barbare = Barbare.getBarbare();
                            System.out.println("2. " + barbare + "\n");

                            Mage mage = Mage.getMage();
                            System.out.println("3. " + mage + "\n");

                            Paladin paladin = Paladin.getPaladin();
                            System.out.println("4. " + paladin + "\n");

                            Pretre pretre = Pretre.getPretre();
                            System.out.println("5. " + pretre + "\n");

                            // Choix du personnage
                            Personnage joueur = null;
                            boolean personnageChoisi = false;

                            while (!personnageChoisi) {
                                System.out.println("Choisissez votre héro (1-5)");
                                try {
                                    int choixPersonnage = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (choixPersonnage) {
                                        case 1:
                                            joueur = amazone;
                                            System.out.println("Vous avez choisi : " + amazone.getFirstname());
                                            personnageChoisi = true;
                                            break;
                                        case 2:
                                            joueur = barbare;
                                            System.out.println("Vous avez choisi : " + barbare.getFirstname());
                                            personnageChoisi = true;
                                            break;
                                        case 3:
                                            joueur = mage;
                                            System.out.println("Vous avez choisi : " + mage.getFirstname());
                                            personnageChoisi = true;
                                            break;
                                        case 4:
                                            joueur = paladin;
                                            System.out.println("Vous avez choisi : " + paladin.getFirstname());
                                            personnageChoisi = true;
                                            break;
                                        case 5:
                                            joueur = pretre;
                                            System.out.println("Vous avez choisi : " + pretre.getFirstname());
                                            personnageChoisi = true;
                                            break;
                                        default:
                                            System.out.println("Choisissez un nombre valide entre 1 et 5");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erreur de saisie ! Veuillez entrer un nombre.\n");
                                    scanner.nextLine();
                                }
                            }

                            // Début des combats
                            System.out.println("\n=== Que l'aventure commence ! ===\n");

                            // Combat 1 : Gobelin
                            System.out.println("\n=== COMBAT 1/3 ===");
                            Gobelin gobelin = Gobelin.getGobelin();
                            System.out.println("Un Gobelin apparaît !");
                            System.out.println(gobelin + "\n");

                            Combat combat1 = new Combat(joueur, gobelin);
                            boolean victoire1 = combat1.demarrerCombat();

                            if (!victoire1) {
                                System.out.println("\nFin du jeu...");
                                scanner.close();
                                return;
                            }

                            System.out.println("\nVous récupérez de l'énergie avant le prochain combat !");

                            // Combat 2 : Vampire
                            System.out.println("\n=== COMBAT 2/3 ===");
                            Vampire vampire = Vampire.getVampire();
                            System.out.println("Un Vampire apparaît !");
                            System.out.println(vampire + "\n");

                            Combat combat2 = new Combat(joueur, vampire);
                            boolean victoire2 = combat2.demarrerCombat();

                            if (!victoire2) {
                                System.out.println("\nFin du jeu...");
                                scanner.close();
                                return;
                            }

                            System.out.println("\nPréparez-vous pour le combat final !");

                            // Combat 3 : Dragon
                            System.out.println("\n=== COMBAT FINAL 3/3 ===");
                            Dragon dragon = Dragon.getDragon();
                            System.out.println("Le Dragon apparaît !");
                            System.out.println(dragon + "\n");

                            Combat combat3 = new Combat(joueur, dragon);
                            boolean victoire3 = combat3.demarrerCombat();

                            if (victoire3) {
                                System.out.println("\n FÉLICITATIONS " + firstname + " !");
                                System.out.println("Vous avez vaincu tous les monstres et libéré les terres d'Arcus !");
                            } else {
                                System.out.println("\nLe Dragon était trop puissant... Fin du jeu.");
                            }

                            break;

                        case 2:
                            System.out.println("N'hésites pas à venir tenter l'aventure quand le courage sera entre vos mains");
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

        scanner.close();
    }
}