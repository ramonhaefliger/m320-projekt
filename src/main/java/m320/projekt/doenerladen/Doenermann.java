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
        switch (essensBezeichnung.toLowerCase()) {
            case "döner_fladenbrot" -> {
                if (geldChf < DoenerFladenbrot.getPreisChf()) {
                    throw new ZuWenigGeldException("Zu wenig Geld.");
                }
                bestellung = new DoenerFladenbrot();
            }
            case "döner_taschenbrot" -> {
                if (geldChf < DoenerTaschenbrot.getPreisChf()) {
                    throw new ZuWenigGeldException("Zu wenig Geld.");
                }
                bestellung = new DoenerTaschenbrot();
            }
            case "hamburger" -> {
                if (geldChf < Hamburger.getPreisChf()) {
                    throw new ZuWenigGeldException("Zu wenig Geld.");
                }
                bestellung = new Hamburger();
            }
            default -> {
                if (geldChf < Pizza.getPreisChf()) {
                    throw new ZuWenigGeldException("Zu wenig Geld.");
                }
                bestellung = new Pizza();
            }
        }
        bestellung.setLebensMittel(lebensMittel);
        return bestellung;
    }
}
