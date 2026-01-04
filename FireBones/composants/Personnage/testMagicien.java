public class testMagicien {
    public static void main(String[] args) {
        Magicien m1 = new Magicien();
        System.out.println("=== Magicien sans paramètres ===");
        System.out.println(m1);

        Magicien m2 = new Magicien("Merlin", "L'Enchanteur", 80, 100, 15, 10, "Bâton magique");
        System.out.println("\n=== Magicien avec paramètres ===");
        System.out.println(m2);
    }
}