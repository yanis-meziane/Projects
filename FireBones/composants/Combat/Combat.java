package composants.Combat;

import composants.Personnage.Personnage;
import composants.Monstre.Monstre;
import java.util.Scanner;
import java.util.Random;

public class Combat {
    private Personnage joueur;
    private Monstre monstre;
    private Scanner scanner;
    private Random random;
    private boolean combatEnCours;

    public Combat(Personnage joueur, Monstre monstre) {
        this.joueur = joueur;
        this.monstre = monstre;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.combatEnCours = true;
    }

    // Méthode principale du combat
    public boolean demarrerCombat() {
        System.out.println("===Début du combat===");
        afficherInfosCombat();

        while (combatEnCours) {
            if (!tourJoueur()) {
                return false;
            }
            if (monstre.getPV() <= 0) {
                victoire();
                return true;
            }

            tourMonstre();

            if (joueur.getPV() <= 0) {
                defaite();
                return false;
            }

            System.out.println("\n" + "=".repeat(50) + "\n");
        }

        return false;
    }

    // Tour du joueur
    private boolean tourJoueur() {
        System.out.println("=== Votre tour ===");
        afficherStatusJoueur();

        int choix = menuAction();

        switch (choix) {
            case 1:
                attaqueNormale();
                break;
            case 2:
                if (joueur.getPM() >= 20) {
                    attaqueSpeciale();
                } else {
                    System.out.println("Vous n'avez plus assez de mana");
                    return tourJoueur();
                }
                break;
            case 3:
                defendre();
                break;
            case 4:
                if (joueur.getPM() >= 30) {
                    soigner();
                } else {
                    System.out.println("Vous n'avez pas assez de mana pour vous soigner");
                    return tourJoueur();
                }
                break;
            case 5:
                fuir();
                return false;
            default:
                System.out.println("Choix invalide");
                return tourJoueur();
        }

        return true;
    }

    // Menu des actions
    private int menuAction() {
        System.out.println("1. Attaque normale");
        System.out.println("2. Attaque spéciale (20 PM)");
        System.out.println("3. Défendre");
        System.out.println("4. Se soigner (30 PM)");
        System.out.println("5. Fuir");

        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return 0;
        }
    }

    // Attaque normale
    private void attaqueNormale() {
        int degats = calculerDegats(joueur.getAttaque(), monstre.getDefense());
        degats += joueur.getArme().getDamage();

        System.out.println("Le joueur " + joueur.getFirstname() + " attaque " + monstre.getFirstname());

        monstre.setPV(monstre.getPV() - degats);
        System.out.println("Le monstre perd : " + degats + " PV");
    }

    // Attaque spéciale
    private void attaqueSpeciale() {
        int degats = calculerDegats(joueur.getAttaque(), monstre.getDefense());
        degats += joueur.getArme().getDamage() * 2;

        System.out.println("Le joueur " + joueur.getFirstname() + " fait une attaque spéciale !");
        joueur.setPM(joueur.getPM() - 20);

        monstre.setPV(monstre.getPV() - degats);
        System.out.println("Le monstre perd : " + degats + " PV");
        System.out.println("Vous perdez 20 PM");
    }

    // Se défendre
    private void defendre() {
        joueur.setDefense(joueur.getDefense() + 5);
        System.out.println("Durant ce tour, le joueur a +5 de défense et a donc " + joueur.getDefense());
    }

    // Se soigner
    private void soigner() {
        int soin = 30 + (joueur.getPM() / 10);
        joueur.setPV(Math.min(joueur.getPV() + soin, getMaxPV()));
        joueur.setPM(joueur.getPM() - 30);

        System.out.println("Vous récupérez " + soin + " PV");
        System.out.println("Vous perdez 30 PM");
    }

    // Fuite
    private void fuir() {
        if (random.nextInt(100) < 40) {
            System.out.println("Vous avez réussi à vous enfuir");
            combatEnCours = false;
        } else {
            System.out.println("Vous n'avez pas réussi à fuir :/");
        }
    }

    // Tour du monstre
    private void tourMonstre() {
        System.out.println("\n=== Tour du monstre ===");
        afficherStatusMonstre();

        int action = random.nextInt(100);
        if (action < 60) {
            attaqueMonstre();
        } else if (action < 85) {
            attaqueSpecialeMonstre();
        } else {
            defenseMonstre();
        }
    }

    // Attaque Monstre
    private void attaqueMonstre() {
        int degats = calculerDegats(monstre.getAttaque(), joueur.getDefense());
        System.out.println(monstre.getFirstname() + " attaque !");
        joueur.setPV(joueur.getPV() - degats);
        System.out.println("Vous perdez " + degats + " PV");

        if (joueur.getDefense() > getDefenseBase()) {
            joueur.setDefense(getDefenseBase());
        }
    }

    // Attaque spéciale du monstre
    private void attaqueSpecialeMonstre() {
        System.out.println(monstre.getFirstname() + " fait une attaque spéciale !");

        String capacite = monstre.getCapacite_special();

        if (capacite.equals("Souffle")) {
            int degats = calculerDegats(monstre.getAttaque() * 3, joueur.getDefense());
            joueur.setPV(Math.max(1, joueur.getPV() - degats));
            System.out.println("Vous avez été attaqué par le souffle du Dragon ! Dégâts : " + degats);
        } else if (capacite.equals("Empaler")) {
            int degats = calculerDegats(monstre.getAttaque() + 10, joueur.getDefense());
            joueur.setPV(joueur.getPV() - degats);
            System.out.println("Vous avez été empalé ! Dégâts : " + degats);
        } else if (capacite.equals("Absorption")) {
            int degats = calculerDegats(monstre.getAttaque(), joueur.getDefense());
            joueur.setPV(joueur.getPV() - degats);
            int soin = (int) (degats * 0.33);
            monstre.setPV(monstre.getPV() + soin);
            System.out.println("Le vampire aspire votre énergie vitale ! Dégâts : " + degats + " | Le vampire récupère " + soin + " PV");
        }
    }

    // Défense Monstre
    private void defenseMonstre() {
        monstre.setDefense(monstre.getDefense() + 3);
        System.out.println("Le monstre monte temporairement sa défense de +3");
    }

    // Calculer les dégâts
    private int calculerDegats(int attaque, int defense) {
        int degats = attaque - (defense / 2);
        return Math.max(1, degats);
    }

    // Afficher les informations du combat
    private void afficherInfosCombat() {
        System.out.println("Le combat oppose " + joueur.getFirstname() + " " + joueur.getLastname() + " contre " + monstre.getFirstname() + " " + monstre.getLastname());
    }

    // Afficher status Monstre
    private void afficherStatusMonstre() {
        System.out.println("--- " + monstre.getFirstname() + " ---");
        System.out.println("PV : " + monstre.getPV());
        System.out.println("Attaque : " + monstre.getAttaque() + " | Défense : " + monstre.getDefense());
    }

    // Afficher status Joueur
    private void afficherStatusJoueur() {
        System.out.println("--- " + joueur.getFirstname() + " ---");
        System.out.println("PV : " + joueur.getPV() + " | PM : " + joueur.getPM());
        System.out.println("Attaque : " + joueur.getAttaque() + " | Défense : " + joueur.getDefense());
        System.out.println("Arme : " + joueur.getArme().getName());
        System.out.println("Armure : " + joueur.getArmure().getName());
    }

    // Victoire
    private void victoire() {
        System.out.println("\n🎉 Félicitations vous avez gagné ! 🎉");
        joueur.setPM(Math.min(joueur.getPM() + 20, getMaxPM()));
        System.out.println("Vous récupérez 20 PM !");
    }

    // Défaite
    private void defaite() {
        System.out.println("\n💀 Vous avez été vaincu ! 💀");
    }

    // Obtenir la défense de base
    private int getDefenseBase() {
        return joueur.getDefense() - joueur.getArmure().getProtection();
    }

    // Obtenir les PV max selon le personnage
    private int getMaxPV() {
        String classe = joueur.getClass().getSimpleName();
        switch (classe) {
            case "Amazone": return 50;
            case "Barbare": return 70;
            case "Mage": return 90;
            case "Paladin": return 80;
            case "Pretre": return 100;
            default: return 50;
        }
    }

    // Obtenir les PM max selon le personnage
    private int getMaxPM() {
        String classe = joueur.getClass().getSimpleName();
        switch (classe) {
            case "Amazone": return 35;
            case "Barbare": return 15;
            case "Mage": return 150;
            case "Paladin": return 100;
            case "Pretre": return 120;
            default: return 50;
        }
    }
}