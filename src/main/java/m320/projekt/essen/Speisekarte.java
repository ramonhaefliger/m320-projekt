package m320.projekt.essen;

import java.util.List;
import java.util.Map;

public abstract class Speisekarte {

    public static Map<String, List<String>> SPEISEKARTE = Map.of(
            "döner", List.of("fleisch", "tomaten", "zwiebeln", "cocktail", "mais"),
            "hamburger", List.of("fleisch", "tomaten", "zwiebeln", "salat", "ketchup", "gurken", "käse"),
            "pizza", List.of("tomaten", "mozzarella", "oliven", "zwiebeln", "ananas", "schinken", "speck", "salami", "ei", "rucola")
    );

    public static boolean sindLebensmittelMoeglich(List<String> lebensMittel, String essensBezeichnung) {
        List<String> moeglicheLebensmittel = SPEISEKARTE.get(essensBezeichnung);
        for (String lebensMittel1 : lebensMittel) {
            if (!moeglicheLebensmittel.contains(lebensMittel1.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}
