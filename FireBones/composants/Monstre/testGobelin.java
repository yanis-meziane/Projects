public class testGobelin{
    public static void main(String[] args) {
        Gobelin gobelin1 = new Gobelin();
        System.out.println("=== Gobelin sans paramètres === ");
        System.out.println(gobelin1);

        Gobelin gobelin2 = new Gobelin("Pierre","Yves",50,4,3,"Terre","Empaler");
        System.out.println("=== Gobelin avec paramètres === ");
        System.out.println(gobelin2);
    }
}