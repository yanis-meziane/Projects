public class testVampire{
    public static void main(String[] args) {
        Vampire vampire1 = new Vampire();
        System.out.println(" === Vampire sans paramètres ===");
        System.out.println(vampire1);

        Vampire vampire2 = new Vampire("Vlad","Imir",35,12,12,"Feu","Absorption");
        System.out.println(" === Vampire avec paramètres === ");
        System.out.println(vampire2);
    }
}