package composants.Monstre;
public class Vampire extends Monstre{
    public Vampire(){
        super();
    }

    public Vampire(String firstname,String lastname, int PV, int Attaque, int Defense,String type_elementaire,String capacite_special){
        super(firstname,lastname,PV,Attaque,Defense,type_elementaire,capacite_special);
    }

    public static Vampire getVampire(){
        return new Vampire("Vlad","Imir",35,12,12,"Feu","Absorption");
    }
    @Override
    public String toString() {
        return "Le Vampire s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + "\n" +
                "Attaque : " + Attaque + " | Défense : " + Defense + "\n" +
                "Type élémentaire : " + type_elementaire + "\n" +
                "Capacité spéciale : " + capacite_special + "\n ±" +
                "Cette capacité permet de récupérer 33% des PV par rapport aux dégâts infligés";
    }
}