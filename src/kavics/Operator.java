package kavics;

public class Operator {

    int sor;
    int oszlop;
    int db;
    char irany;

    public Operator(int sor, int oszlop, int db, char irany) {
        this.sor = sor;
        this.oszlop = oszlop;
        this.db = db;
        this.irany = irany;
    }

    public boolean alkalmazhato(Allapot allapot) {
        if (sor > 0 && sor < 5 && oszlop > 0 && oszlop < 5 && db > 0 && db < 5) {
            if (allapot.tabla[this.sor][this.oszlop] != 0) {
                switch (this.db) {
                    case 1:
                        return true;
                    case 2:
                        if (this.irany == 'h') {
                            if (this.oszlop + 1 < 5)
                                return allapot.tabla[this.sor][this.oszlop + 1] != 0;
                        } else {
                            if (this.sor + 1 < 5)
                                return allapot.tabla[this.sor + 1][this.oszlop] != 0;
                        }
                    case 3:
                        if (this.irany == 'h') {
                            if (this.oszlop + 2 < 5)
                                return (allapot.tabla[this.sor][this.oszlop + 1] != 0) && (allapot.tabla[this.sor][this.oszlop + 2] != 0);
                        } else {
                            if (this.sor + 2 < 5)
                                return (allapot.tabla[this.sor + 1][this.oszlop] != 0) && (allapot.tabla[this.sor + 2][this.oszlop] != 0);
                        }
                    case 4:
                        if (this.irany == 'h') {
                            if (this.oszlop + 3 < 5)
                                return ((allapot.tabla[this.sor][this.oszlop + 1] != 0) && (allapot.tabla[this.sor][this.oszlop + 2] != 0)) && (allapot.tabla[this.sor][this.oszlop + 3] != 0);
                        } else {
                            if (this.sor + 3 < 5)
                                return ((allapot.tabla[this.sor + 1][this.oszlop] != 0) && (allapot.tabla[this.sor + 2][this.oszlop] != 0)) && (allapot.tabla[this.sor + 3][this.oszlop] != 0);
                        }
                    default:
                        break;
                }
            }
        }
        return false;
    }

    public Allapot alkalmaz(Allapot allapot) {
        Allapot uj = new Allapot(allapot.jatekos);
        int[][] a = allapot.tabla;
        int[][] b = uj.tabla;

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                b[i][j] = a[i][j];

        if (this.irany == 'h') {
            for (int i = 0; i < this.db; i++)
                b[this.sor ][this.oszlop + i] = 0;
            return uj;
        }
        else
        {
            for (int i = 0; i < this.db; i++)
                b[this.sor + i][this.oszlop] = 0;
            return uj;
        }
        //return allapot;
    }


    @Override
    public String toString() {
        return "Operátor : (" + sor + ", " + oszlop + ", " + db + ", " + irany + ")";
    }
}
