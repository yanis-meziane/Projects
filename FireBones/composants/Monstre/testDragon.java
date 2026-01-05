public class testDragon{
    public static void main(String[] args) {

        Dragon dragon1 = new Dragon();
        System.out.println("=== Dragon sans paramètres");
        System.out.println(dragon1);

        Dragon dragon2 = new Dragon("Smog","Le gardien", 78,27,33,"Feu","Souffle");
        System.out.println("=== Dragon avec paramètres === ");
        System.out.println(dragon2);
    }
}