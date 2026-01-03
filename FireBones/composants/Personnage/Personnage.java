package personnage;
public class Personnage {

    protected String firstname;
    protected String lastname;
    protected int PV;
    protected int PM;
    protected int attaque;
    protected int defense;
    protected String Arme;

    Personnage() {
        this.firstname = "null";
        this.lastname = "null";
        this.PV = 0;
        this.PM = 0;
        this.attaque = 0;
        this.defense = 0;
        this.Arme = "null";
    }

    Personnage(String firstname, String lastname, int PV, int PM, int attaque, int defense, String Arme) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.PV = PV;
        this.PM = PM;
        this.attaque = attaque;
        this.defense = defense;
        this.Arme = Arme;
    }

    // SETTERS

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setArme(String Arme) {
        this.Arme = Arme;
    }

    // GETTERS

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public int getPV() {
        return this.PV;
    }

    public int getPM() {
        return this.PM;
    }

    public int getAttaque() {
        return this.attaque;
    }

    public int getDefense() {
        return this.defense;
    }

    public String getArme() {
        return this.Arme;
    }

    @Override
    public String toString() {
        return "Le personnage s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + " | PM : " + PM + "\n" +
                "Attaque : " + attaque + " | Défense : " + defense + "\n" +
                "Arme : " + Arme;
    }
}
