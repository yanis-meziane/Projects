public class testPersonnage{
    public static void main(String[] args) {
        Personnage p1 = new Personnage();
        System.out.println(p1);

        Personnage p2 = new Personnage("Yanis","Meziane",10,10,10,10,"Arbalette");
        System.out.println(p2);
    }
}

// Pour tester cette classe il sera nécessaire de faire dans le terminal
// javac Personnage.java testPersonnage.java puis java testPersonnage
// Cela permet de compiler avant d'éxécuter

