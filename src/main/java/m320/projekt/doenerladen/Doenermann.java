package m320.projekt.doenerladen;

import m320.projekt.essen.*;

import java.util.List;

public class Doenermann {
    private final String name;

    public Doenermann(String name) {
        this.name = name;
    }

    public Essen bestelle(String essensBezeichnung, List<String> lebensMittel) {
        Essen bestellung;
        if (essensBezeichnung.equalsIgnoreCase("dönerFladenbrot")) {
            bestellung = new DoenerFladenbrot();
        } else if (essensBezeichnung.equalsIgnoreCase("dönerTaschenbrot")){
            bestellung = new DoenerTaschenbrot();
        } else if (essensBezeichnung.equalsIgnoreCase("hamburger")){
            bestellung = new Hamburger();
        } else {
            bestellung = new Pizza();
        }
        bestellung.setLebensMittel(lebensMittel);
        return bestellung;
    }
}
