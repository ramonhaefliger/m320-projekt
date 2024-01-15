package m320.projekt.doenerladen;

import m320.projekt.ZuWenigGeldException;
import m320.projekt.essen.*;

import java.util.List;

public class Doenermann {
    private final String name;

    public Doenermann(String name) {
        this.name = name;
    }

    public Essen bestelle(String essensBezeichnung, List<String> lebensMittel, int geldChf) {
        Essen bestellung;
        if (essensBezeichnung.equalsIgnoreCase("dönerFladenbrot")) {
            if (geldChf < DoenerFladenbrot.getPreisChf()) {
                throw new ZuWenigGeldException("Zu wenig Geld.");
            }
            bestellung = new DoenerFladenbrot();
        } else if (essensBezeichnung.equalsIgnoreCase("dönerTaschenbrot")){
            if (geldChf < DoenerTaschenbrot.getPreisChf()) {
                throw new ZuWenigGeldException("Zu wenig Geld.");
            }
            bestellung = new DoenerTaschenbrot();
        } else if (essensBezeichnung.equalsIgnoreCase("hamburger")){
            if (geldChf < Hamburger.getPreisChf()) {
                throw new ZuWenigGeldException("Zu wenig Geld.");
            }
            bestellung = new Hamburger();
        } else {
            if (geldChf < Pizza.getPreisChf()) {
                throw new ZuWenigGeldException("Zu wenig Geld.");
            }
            bestellung = new Pizza();
        }
        bestellung.setLebensMittel(lebensMittel);
        return bestellung;
    }
}
