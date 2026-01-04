public class testPaladin{
    public static void main(String[] args) {

        Paladin paladin1 = new Paladin();
        System.out.println(" === Paladin sans paramètres === ");
        System.out.println(paladin1);

        Paladin paladin2 = new Paladin("Luc", "Skywalker", 80, 100, 15, 10, "Mains magiques");
        System.out.println(" === Paladin avec paramètres === ");
        System.out.println(paladin2);
    }
}