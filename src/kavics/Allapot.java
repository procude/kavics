package kavics;

public class Allapot {
    int[][] tabla;
    Jatekos jatekos;

    public Allapot(Jatekos jatekos) {
        this.tabla = new int[][]{{0, 0, 0, 0, 0},
                                 {0, 1, 1, 1, 1},
                                 {0, 1, 1, 1, 1},
                                 {0, 1, 1, 1, 1},
                                 {0, 1, 1, 1, 1}};
        this.jatekos = jatekos;
    }

    @Override
    public String toString() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++)
                System.out.print(this.tabla[i][j] + " ");
            System.out.println();
        }
        return "";
    }

    public void jatekosCsere(){
        if (this.jatekos == Jatekos.Gep)
            this.jatekos = Jatekos.Ember;
        else
            this.jatekos = Jatekos.Gep;
    }


    public boolean cel() {
        int sum = 0;
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++)
                sum += this.tabla[i][j];
        return sum == 0;
    }

    @Override
    public boolean equals(Object o) {
        Allapot a = (Allapot) o;
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++)
                if (a.tabla[i][j] != this.tabla[i][j])
                    return false;
        return true;
    }
}
