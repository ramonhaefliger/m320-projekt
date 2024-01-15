package m320.projekt.doenerladen;

import m320.projekt.essen.Essen;

import java.util.List;
import java.util.Random;

public class Doenerladen {
    private final List<Doenermann> doenermaenner;
    private final Random randomGenerator;

    public Doenerladen() {
        doenermaenner = List.of(
                new Doenermann("Ali"),
                new Doenermann("Jürg")
        );
        randomGenerator = new Random();
    }

    public Essen bestelle(String essensBezeichnung, List<String> lebensMittel) {
        Doenermann randomDoenermann = getRandomDoenermann();
        return randomDoenermann.bestelle(essensBezeichnung, lebensMittel);
    }

    private Doenermann getRandomDoenermann() {
        return doenermaenner.get(randomGenerator.nextInt(doenermaenner.size()));
    }
}
