public class testCombattant{
    public static void main(String[] args) {

        Combattant c1 = new Combattant();
        System.out.println("=== Combattant sans paramètres ===");
        System.out.println(c1);

        Combattant c2 = new Combattant("Max","Phœnix",50,12,5,30,"Lance");
        System.out.println("=== Combattant avec paramètres === ");
        System.out.println(c2);
    }
}