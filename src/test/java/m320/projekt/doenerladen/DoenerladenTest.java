package m320.projekt.doenerladen;

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

        Essen doener = doenerladen.bestelle("döner", lebensMittel);

        assertEquals(lebensMittel, doener.getLebensmittel());
    }

    @Test
    public void bestelleHamburger() {
        List<String> lebensMittel = List.of("salat", "zwiebeln", "fleisch", "ketchup");

        Essen hamburger = doenerladen.bestelle("Hamburger", lebensMittel);

        assertEquals(lebensMittel, hamburger.getLebensmittel());
    }

    @Test
    public void bestellePizza() {
        List<String> lebensMittel = List.of("tomaten", "mozzarella", "zwiebeln", "ananas", "oliven");

        Essen pizza = doenerladen.bestelle("pizza", lebensMittel);

        assertEquals(lebensMittel, pizza.getLebensmittel());
    }

    @Test
    public void bestelleDoenerMitNichtMoeglichenLebensmittel() {
        List<String> lebensMittel = List.of("mozzarella");

        assertThrows(Exception.class, () -> doenerladen.bestelle("döner", lebensMittel));
    }

    @Test
    public void bestelleHamburgerMitNichtMoeglichenLebensmittel() {
        List<String> lebensMittel = List.of("mozzarella");

        assertThrows(Exception.class, () -> doenerladen.bestelle("hamburger", lebensMittel));
    }

    @Test
    public void bestellePizzaMitNichtMoeglichenLebensmittel() {
        List<String> lebensMittel = List.of("cocktail");

        assertThrows(Exception.class, () -> doenerladen.bestelle("pizza", lebensMittel));
    }

}