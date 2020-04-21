package kavics;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jatek {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Problema p = new Problema();
        Allapot allapot;

        if (random.nextInt() % 2 == 0) {
            allapot = new Allapot(Jatekos.Ember);
            System.out.println("A játékot Ön kezdi.");
        } else {
            allapot = new Allapot(Jatekos.Gep);
            System.out.println("A játékot a számítógép kezdi.");
        }

        while(true) {

            Operator operator = null;

            do {
                switch (allapot.jatekos) {
                    case Gep:
                        operator = MiniMax.lepes(allapot, p, 2);
                        System.out.println(operator);
                        TimeUnit.SECONDS.sleep(5);
                        break;
                    case Ember:
                        System.out.println("A tábla jelenlegi állása:");
                        System.out.println(allapot);
                        System.out.print("Írjon be egy sort: ");
                        int sor = Integer.parseInt(scanner.next());
                        System.out.print("Írjon be egy oszlopot: ");
                        int oszlop = Integer.parseInt(scanner.next());
                        System.out.print("Írja be hány kavicsot akar levenni: ");
                        int db = Integer.parseInt(scanner.next());
                        System.out.print("Írja be milyen irányban akarja levenni a kavicsokat(v/h): ");
                        char irany = scanner.next().charAt(0);
                        operator = new Operator(sor, oszlop, db, irany);
                        break;
                }
            } while (!operator.alkalmazhato(allapot));

            allapot = operator.alkalmaz(allapot);

            allapot.jatekosCsere();
            if (allapot.cel()) {
                System.out.println(allapot.jatekos + " Nyert!");
                System.out.println(allapot);
                break;
            }
        }
    }
}