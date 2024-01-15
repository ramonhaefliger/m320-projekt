package m320.projekt.doenerladen;

import m320.projekt.LebensmittelNichtMoeglichException;
import m320.projekt.ZuWenigGeldException;
import m320.projekt.essen.Essen;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DoenerladenTest {
    private final Doenerladen doenerladen = new Doenerladen();

    @Test
    public void bestelleDoener() {
        List<String> lebensMittel = List.of("zwiebeln", "mais", "fleisch", "cocktail");

        Essen doener = doenerladen.bestelle("döner_fladenbrot", lebensMittel, 10);

        assertEquals(lebensMittel, doener.getLebensmittel());
    }

    @Test
    public void bestelleHamburger() {
        List<String> lebensMittel = List.of("salat", "zwiebeln", "fleisch", "ketchup");

        Essen hamburger = doenerladen.bestelle("Hamburger", lebensMittel, 8);

        assertEquals(lebensMittel, hamburger.getLebensmittel());
    }

    @Test
    public void bestellePizza() {
        List<String> lebensMittel = List.of("tomaten", "mozzarella", "zwiebeln", "ananas", "oliven");

        Essen pizza = doenerladen.bestelle("pizza", lebensMittel, 13);

        assertEquals(lebensMittel, pizza.getLebensmittel());
    }

    @Test
    public void bestelleDoenerMitNichtMoeglichenLebensmittel() {
        List<String> lebensMittel = List.of("mozzarella");

        assertThrows(LebensmittelNichtMoeglichException.class, () -> doenerladen.bestelle("döner_fladenbrot", lebensMittel, 10));
    }

    @Test
    public void bestelleHamburgerMitNichtMoeglichenLebensmittel() {
        List<String> lebensMittel = List.of("mozzarella");

        assertThrows(LebensmittelNichtMoeglichException.class, () -> doenerladen.bestelle("hamburger", lebensMittel, 8));
    }

    @Test
    public void bestellePizzaMitNichtMoeglichenLebensmittel() {
        List<String> lebensMittel = List.of("cocktail");

        assertThrows(LebensmittelNichtMoeglichException.class, () -> doenerladen.bestelle("pizza", lebensMittel, 13));
    }

    @Test
    public void bestelleDoenerMitZuWenigGeld() {
        List<String> lebensMittel = List.of("zwiebeln", "mais", "fleisch", "cocktail");

        assertThrows(ZuWenigGeldException.class, () -> doenerladen.bestelle("döner_fladenbrot", lebensMittel, 9));
    }

}