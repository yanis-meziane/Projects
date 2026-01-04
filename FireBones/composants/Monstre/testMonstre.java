public class testMonstre{
    public static void main(String[] args) {
        Monstre monstre1 = new Monstre();
        System.out.println(" === Monstre sans paramètres === ");
        System.out.println(monstre1);

        Monstre monstre2 = new Monstre("Clem","Entine",60,5,13,"Feu","Cassage de couilles");
        System.out.println(" === Monstre avec paramètres === ");
        System.out.println(monstre2);
    }
}