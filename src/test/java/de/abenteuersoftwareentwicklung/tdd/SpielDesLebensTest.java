package de.abenteuersoftwareentwicklung.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpielDesLebensTest {

    @Test
    public void toteZelle_genau3LebendeNachbarn_wirdGeboren() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  true,   true,   true, //
                                false,          false, //
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertTrue(neuerZustand);
    }

    @Test
    public void toteZelle_genau3LebendeNachbarn_wirdGeboren_andereReihenfolge() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  true,   false,   false, //
                                false,          true, //
                                false,  true,  false
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertTrue(neuerZustand);

    }

    @Test
    public void toteZelle_weniger3LebendeNachbarn_bleibtTot() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  false,  true,   true, //
                                false,          false, //
                                false,  false,  false //
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void toteZelle_weniger3LebendeNachbarn_bleibt_Tot_keineLebendeNachbarn() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  false,  false,  false,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertFalse(neuerZustand);
    }
  
}
