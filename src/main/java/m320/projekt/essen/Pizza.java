package m320.projekt.essen;

import m320.projekt.LebensmittelNichtMoeglichException;

import java.util.List;

public class Pizza implements Essen {
    private List<String> lebensMittel;

    @Override
    public void setLebensMittel(List<String> lebensMittel) {
        if (!Speisekarte.sindLebensmittelMoeglich(lebensMittel, "pizza")) {
            throw new LebensmittelNichtMoeglichException("Ein oder mehrere Lebensmittel sind nicht möglich");
        }
        this.lebensMittel = lebensMittel;
    }

    @Override
    public List<String> getLebensmittel() {
        return lebensMittel;
    }

}
