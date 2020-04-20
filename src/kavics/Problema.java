package kavics;

import java.util.ArrayList;
import java.util.List;

public class Problema {

    static List<Operator> OPERATOROK = new ArrayList<>();
    static {
        for (int sor = 1; sor < 5; sor++)
            for (int oszlop = 1; oszlop < 5; oszlop++)
                for ( int db = 1; db < 5; db++) {
                    OPERATOROK.add(new Operator(sor, oszlop, db, 'v'));
                    OPERATOROK.add(new Operator(sor, oszlop, db, 'h'));
                }
    }

    public List<Operator> operatorok() {
        return OPERATOROK;
    }
}
