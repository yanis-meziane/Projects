public class testPersonnage {
    public static void main(String[] args) {
        Personnage p1 = new Personnage();
        System.out.println("=== Personnage sans paramètres ===");
        System.out.println(p1);

        Personnage p2 = new Personnage("Yanis", "Meziane", 10, 10, 10, 10, "Arbalète");
        System.out.println("\n=== Personnage avec paramètres ===");
        System.out.println(p2);
    }
}