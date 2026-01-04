public class testMage {
    public static void main(String[] args) {
        Mage m1 = new Mage();
        System.out.println("=== Mage sans paramètres ===");
        System.out.println(m1);

        Mage m2 = new Mage("Gandalf", "Le Gris", 90, 150, 18, 12, "Bâton");
        System.out.println("\n=== Mage avec paramètres ===");
        System.out.println(m2);
    }
}