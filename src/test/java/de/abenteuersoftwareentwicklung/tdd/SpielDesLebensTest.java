package de.abenteuersoftwareentwicklung.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpielDesLebensTest {

    @Test
    public void toteZelle_genau3Nachbarn_geboren() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = { true, true, true, //
                                false, false, //
                                false, false, false
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertTrue(neuerZustand);
    }
  
}
