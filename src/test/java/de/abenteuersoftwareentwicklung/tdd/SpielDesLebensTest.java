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
    public void toteZelle_weniger3LebendeNachbarn_bleibtTot_keineLebendeNachbarn() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  false,  false,  false,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void toteZelle_mehr3LebendeNachbarn_bleibtTot() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  true,   false,  false,
                                true,           false,
                                true,   true,   false
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void toteZelle_mehr3LebendeNachbarn_bleibtTot_alleNachbarnLeben() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean toteZelle = false;

        boolean[] nachbarn = {  true,   true,   true,
                                true,           true,
                                true,   true,   true
        };

        boolean neuerZustand = spiel.neuerZustand(toteZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void lebendeZelle_weniger2LebendeNachbarn_stirbt() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  true,   false,  false,
                                false,          false,
                                false,  true,   false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void lebendeZelle_weniger2LebendeNachbarn_stirbt_keineLebendeNachbarn() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  false,  false,  false,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void lebendeZelle_mit2LebendeNachbarn_bleibtLeben() {

        SpielDesLebens spiel = new SpielDesLebens();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  true,   true,   false,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertTrue(neuerZustand);
    }
  
}
