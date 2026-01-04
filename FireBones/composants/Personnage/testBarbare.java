public class testBarbare {
    public static void main(String[] args) {
        Barbare b1 = new Barbare();
        System.out.println("=== Barbare sans paramètres ===");
        System.out.println(b1);

        Barbare b2 = new Barbare("Conan", "Le Destructeur", 200, 10, 30, 15, "Hache");
        System.out.println("\n=== Barbare avec paramètres ===");
        System.out.println(b2);
    }
}