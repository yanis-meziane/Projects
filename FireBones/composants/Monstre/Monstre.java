package composants.Monstre;
public class Monstre{

    protected String firstname;
    protected String lastname;
    protected int PV;
    protected int Attaque;
    protected int Defense;
    protected String type_elementaire;
    protected String capacite_special;

    Monstre(){
        this.firstname = "Null";
        this.lastname = "Null";
        this.PV = 0;
        this.Attaque = 0;
        this.Defense = 0;
        this.type_elementaire = "Null";
        this.capacite_special = "Null";
    }

    Monstre(String firstname, String lastname, int PV, int Attaque, int Defense, String type_elementaire, String capacite_special){
        this.firstname = firstname;
        this.lastname = lastname;
        this.PV = PV;
        this.Attaque = Attaque;
        this.Defense = Defense;
        this.type_elementaire = type_elementaire;
        this.capacite_special = capacite_special;
    }

    // Les getter


    public String getFirstname() {
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public int getPV(){
        return PV;
    }

    public int getAttaque(){
        return Attaque;
    }

    public int getDefense(){
        return Defense;
    }

    public String getCapacite_special() {
        return capacite_special;
    }

    public String getType_elementaire() {
        return type_elementaire;
    };


    // Les Setters

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPV(int PV){
        this.PV = PV;
    }

    public void setAttaque(int Attaque){
        this.Attaque = Attaque;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public void setCapacite_special(String capacite_special) {
        this.capacite_special = capacite_special;
    }

    public void setType_elementaire(String type_elementaire){
        this.type_elementaire = type_elementaire;
    }


    // L'Override

    @Override
    public String toString() {
        return "Le monstre s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + "\n" +
                "Attaque : " + Attaque + " | Défense : " + Defense + "\n" +
                "Type élémentaire : " + type_elementaire + "\n" +
                "Capacité spéciale : " + capacite_special;
    }
}