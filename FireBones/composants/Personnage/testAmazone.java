public class testAmazone {
    public static void main(String[] args) {
        Amazone a1 = new Amazone();
        System.out.println("=== Amazone sans paramètres ===");
        System.out.println(a1);

        Amazone a2 = new Amazone("Julie", "Harpie", 50, 35, 8, 12, "Arc");
        System.out.println("\n=== Amazone avec paramètres ===");
        System.out.println(a2);
    }
}