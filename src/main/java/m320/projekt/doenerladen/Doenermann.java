package m320.projekt.doenerladen;

import m320.projekt.essen.Doener;
import m320.projekt.essen.Essen;
import m320.projekt.essen.Hamburger;
import m320.projekt.essen.Pizza;

import java.util.List;

public class Doenermann {
    private final String name;

    public Doenermann(String name) {
        this.name = name;
    }

    public Essen bestelle(String essensBezeichnung, List<String> lebensMittel) {
        Essen bestellung;
        if (essensBezeichnung.equalsIgnoreCase("Döner")) {
            bestellung = new Doener();
        } else if (essensBezeichnung.equalsIgnoreCase("Hamburger")){
            bestellung = new Hamburger();
        } else {
            bestellung = new Pizza();
        }
        bestellung.setLebensMittel(lebensMittel);
        return bestellung;
    }
}
