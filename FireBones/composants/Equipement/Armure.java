package  composants.Equipement;

public class Armure{
  protected  String name;
  protected  int protection;
  protected String typeElementaire;

  public Armure(){
      this.name = "Vêtements";
      this.protection = 0;
      this.typeElementaire = "Neutre";
  }

  public Armure(String name, int protection, String typeElementaire){
      this.name = name;
      this.protection = protection;
      this.typeElementaire = typeElementaire;
  }

  // Les Setters

    public void setName(String name){this.name = name};
    public void setProtection(int protection){this.protection = protection};
    public void setTypeElementaire(String typeElementaire){this.typeElementaire = typeElementaire};

    // Les getters


    public String getName() {return name;};
    public int getProtection(){return protection;};
    public String getTypeElementaire() {return typeElementaire;};

    @Override
    public String toString() {
        return name + " (Défense: +" + protection + ", Type: " + typeElementaire + ")";
    };

    // Armures prédéfinies
    public static Armure getArmureLegere() {
        return new Armure("Armure de cuir", 3, "Terre");
    };

    public static Armure getArmureMoyenne() {
        return new Armure("Cotte de mailles", 6, "Metal");
    };

    public static Armure getArmureLourde() {
        return new Armure("Armure de plaques", 10, "Feu");
    };

    public static Armure getRobeMagique() {
        return new Armure("Robe enchantée", 2, "Eau");
    };
}