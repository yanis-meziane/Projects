package composants.Monstre;
public class Gobelin extends Monstre{
    public Gobelin(){
        super();
    }

    public static Gobelin getGobelin(){
        return  new Gobelin("Pierre","Yves",50,4,3,"Terre","Empaler");
    }
    public Gobelin(String firstname,String lastname, int PV, int Attaque, int Defense,String type_elementaire,String capacite_special){
        super(firstname,lastname,PV,Attaque,Defense,type_elementaire,capacite_special);
    }

    @Override
    public String toString(){
        return "Le gobelin s'appelle " + firstname + " " + lastname + "\n" +
                "PV : " + PV + "\n" +
                "Attaque : " + Attaque + " | Défense : " + Defense + "\n" +
                "Type élémentaire : " + type_elementaire + "\n" +
                "Capacité spéciale : " + capacite_special + "\n ±" +
                "Cette capacité permet de rajouter 10 points de dégâts supplémentaires à son attaque";
    }
}