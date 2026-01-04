public class testPretre {
    public static void main(String[] args) {
        Pretre p1 = new Pretre();
        System.out.println("=== Prêtre sans paramètres ===");
        System.out.println(p1);

        Pretre p2 = new Pretre("Benedictus", "Le Guérisseur", 100, 120, 10, 18, "Masse");
        System.out.println("\n=== Prêtre avec paramètres ===");
        System.out.println(p2);
    }
}