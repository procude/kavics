package kavics;

import java.util.Arrays;

public class Heurisztika {

    private static int ertek;

    public static int h(Allapot allapot) {
        return lehetseges(allapot);
    }

    private static int szamolo(int[] arr){
        return (int) Arrays.stream(arr).filter(value -> value == 1).count();
    }

    private static void ertekeles(int[] resz) {
        if (szamolo(resz) == 4) {
            ertek += 4;
        }else if (szamolo(resz) == 3) {
            ertek += 3;
        }else if (szamolo(resz) == 2) {
            ertek += 2;
        }else if (szamolo(resz) == 1) {
            ertek += 1;
        }
    }

    private static int lehetseges(Allapot allapot) {
        ertek = 0;

        //Vízszintes
        for (int i = 1; i < 5; i++) {
            int[] sor = allapot.tabla[i];
            ertekeles(sor);
        }

        //Függőleges
        for (int i = 1; i < 5; i++) {
            int[] oszlop = new int[4];
            for (int ii = 1; ii < 4; ii++){
                oszlop[ii] = allapot.tabla[ii][i];
            }
            ertekeles(oszlop);

        }
        return ertek;
    }
}