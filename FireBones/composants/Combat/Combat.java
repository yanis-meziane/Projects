package composants.Combat;

import composants.Personnage.Personnage;
import composants.Monstre.Monstre;
import java.util.Scanner;
import java.util.Random;


public class Combat{
    private Personnage joueur;
    private Monstre monstre;
    private Scanner scanner;
    private Random random;
    private boolean combatEnCours;

    public Combat(Personnage joueur, Monstre monstre){
        this.joueur = joueur;
        this.monstre = montre;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.combatEnCours = true;
    }

    // Méthodes de combat

    private boolean demarrerCombat(){
        System.out.println("===Début du combat===");
    }

    afficherInfoCombat();

    while(combatEnCours){
        if(!tourJoueur){
            return false; // Le joueur a perdu
        } if(monstre.getPV()<= 0){
            victoire();
            return true;
        }

        // Tour du monstre

        tourDuMonstre();

        if(joueur.getPV() <= 0){
            defaite();
            return false;
        }

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    return false;
}

// Tour du joueur

private boolean tourJoueur(){
    System.out.println("== Votre tour ===");
    afficherStatusJoueur();

    int choix = menuAction();

    switch (choix){
        case 1:
            attaqueNormale();
            break;
        case 2:
            if(joueur.getPM()>=20){
                attaqueSpeciale();
            }else{
                System.out.println("Vous n'avez plus assez de mana");
                return tourJoueur();
            };
            break;
        case 3:
            defendre();
            break;
        case 4:
            if(joueur.getPM()>=30){
                soigner();
            }else{
                System.out.println("Vous n'avez pas assez de mana pour vous soigner");
                return tourJoueur();
            }
            break;
        case 5:
            fuir();
            return false;
        default :
            System.out.println("Choix invalide");
            return tourJoueur();
    }

    return true;
}


// Menu des actions possibles de faire

private int menuAction(){
    System.out.println("1. Attaque normale");
    System.out.println("2. Attaque spéciale (20 PM)");
    System.out.println("3. Défendre");
    System.out.println("4. Se soigner");
    System.out.println("5. Fuire")

    try {
        return scanner.nextInt();
    } catch(Exception e){
        scanner.nextLine();
        return 0;
    }
}

// Attaque normale

private void attaqueNormale(){
    int degats = calculerDegats(joueur.getAttaque(),monstre.getDefense());
    degat += joueur.getArme().getDamage();

    System.out.println("Le joueur " + joueur.getFirstname() + " attaque " + monstre.getFirstname());

    monstre.setPV(monstre.getPV() - degats);
    System.out.println("Le monstre perd : " + degats + "PV");
}

// Attaque spéciale

private void attaqueSpeciale(){
    int degats = calculerDegats(joueur.getAttaque(),monstre.getDefense());
    degat += joueur.getArme().getDamage()*2;

    System.out.println("Le joueur " + joueur.getFirstname() + " attaque spéciale " + monstre.getFirstname());
    joueur.setPM(joueur.getPM()-=20);

    monstre.setPV(monstre.getPV() - degats);
    System.out.println("Le monstre perd : " + degats + "PV");
    System.out.println("Vous perdez 20PM")
}

// Se défendre

private void defendre(){
    joueur.setDefense(joueur.getDefense() + 5);
    System.out.println("Durant ce tour, le joueur à +5 de défense et a donc " + joueur.getDefense());
}

// Se soigner

private void soigner(){
    int soin = 30 + (joueur.getPM()/10);
    joueur.setPV(Math.min(joueur.getPV() + soin,getMaxPV()));
    joueur.setPM(joueur.getPM() - 30);

    System.out.println("Vous récupérez " + soint + "PV");
    System.out.println("Vous perdez 30PM");
}

// Fuite

private void fuir(){
    if(random.nextInt(100)<40){
        System.out.println("Vous avez réussi à vous enfuir");
        combatEnCours = false;
    }else{
        system.out.println("Vous n'avez pas réussi à fuir :/");
    }
}


// Tour du monstre

private tourMonstre(){
    System.out.println("Début du tour du monstre");

    afficherStatusMontre();

    int action = random.nextInt(100);
    if(action < 60){
        attaqueMonstre();
    }else if(action < 85){
        attaqueSpecialeMonstre();
    }else{
        defenseMonstre();
    }
}

// Attaque Monstre


private void attaqueMonstre(){
    inf degats = calculerDegats(monstre.getAttaque(),joueur.getDefense());
    System.out.println(monstre.getFirstname() + " attaque !");
    joueur.setPV(joueur.getPV() - degats);

    if(joueur.getDefense() > getDefenseBase()){
        joueur.setDefense(getDefenseBase());
    }
}

// Attaque spéciale

private void attaqueSpecialeMonstre(){
    System.out.println(monstre.getFirstname() + "fait une attaque spéciale");

    String capacite = monstre.getCapacite_special();

    if(capacite.equals("Souffle")){
        int degats = calculerDegats(monstre.getAttaque()*3, joueur.getDefense());
            joueur.setPV(Math.max(1,joueur.getPV()-degats));
            System.out.println("Vous avez été attaqué par le souffle du Dragon");
    } else if(capacite.equalts("Empaler")){
        int degat = calculerDegats(monstre.getAttaque()+10, joueur.getDefense());
            joueur.setPV(joueur.getPV - degats);
            System.out.println("Vous avez été empalé");
    } else if(capacite.equals("Absorption")){
        int degats = calculerDegats(monstre.getAttaque(),joueur.getDefense());
            joueur.setPV(joueur.getPV() - degats);
        int soin = (int)(degat*0.33);
            monstre.setPV(monstre.getPV + soin);
            System.out.println("Le vampire aspire votre énergie vitale");
    }
}

// Défense Monstre

public void defenseMonstre(){
    monstre.setDefense(monstre.getDefense() + 3);
    System.out.println("Le monstre monte temporairement sa défense");
}

// Calculer les dégats

private int calculerDegats(int attaque, int defense){
    int degats = attaque - (defense/2);
    return Math.max(1,degats);
}

// Afficher les informations du combat

private void afficherInfosCombat(){
    System.out.println("Le combat oppose " + joueur.getFirstname() + joueur.getLastname() + "contre " + monstre.getFirstname() + monstre.getLastname());
}

// Afficher status Monstre

private void afficherStatusMontre(){
    System.out.println("Son nom : " + monstre.getFirstname());
    System.out.println("Ses PV : " + monstre.getPV());
    System.out.println("Son attaque : " + monstre.getAttaque());
    System.out.println("Sa défense : " + monstre.getDefense());
}

// Afficher status Monstre

private void afficherStatusJoueur(){
    System.out.println("Son nom : " + joueur.getFirstname());
    System.out.println("Ses PV : " + joueur.getPV());
    System.out.println("Son attaque : " + joueur.getAttaque());
    System.out.println("Sa défense : " + joueur.getDefense());
    System.out.println("Ses PM : " + joueur.getPM());
    System.out.println("Son arme est : " + joueur.getArme());
    System.out.println("Son armure est : " + joueur.getArmure());
}

// Victoire

private void victoire(){
    System.out.println("Félicitation vous avez gagné !");
    joueur.setPM(Math.min(joueur.getPM() + 20));
    System.out.println(" Vous récupérez 20 PM !");
}

private void defaite(){
    System.out.println("Vous avez été vaincu !");
}

private int getDefenseBase() {
    // Retourner la défense de base sans les bonus temporaires
    return joueur.getDefense() - joueur.getArmure().getProtection();
}

