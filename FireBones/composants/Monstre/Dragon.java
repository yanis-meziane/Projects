package composants.Monstre;
public class Dragon extends Monstre{
    public Dragon(){
        super();
    }

    public Dragon(String firstname, String lastname, int PV, int Attaque, int Defense, String capacite_special, String type_elementaire){
        super(firstname,lastname,PV,Attaque,Defense,capacite_special,type_elementaire);
    };

    public static Dragon getDragon(){
        return  new Dragon("Smog","Le gardien", 78,27,33,"Feu","Souffle");
    }

    @Override
    public String toString(){
        return "Le dragon s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + "\n" +
                "Attaque : " + Attaque + " | Défense : " + Defense + "\n" +
                "Type élémentaire : " + type_elementaire + "\n" +
                "Capacité spéciale : " + capacite_special + "\n ±" +
                "Cette capacité permet de faire descendre les points de vie du joueur jusqu'à 1 PV";
    }

}