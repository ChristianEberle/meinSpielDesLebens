package de.abenteuersoftwareentwicklung.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class LebensfunkeTest {

    @Test
    public void toteZelle_genau3LebendeNachbarn_wirdGeboren() {

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  true,   false,  false,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertFalse(neuerZustand);
    }

    @Test
    public void lebendeZelle_weniger2LebendeNachbarn_stirbt_keineLebendeNachbarn() {

        Lebensfunke spiel = new Lebensfunke();

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

        Lebensfunke spiel = new Lebensfunke();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  true,   true,   false,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertTrue(neuerZustand);
    }

    @Test
    public void lebendeZelle_mit3LebendeNachbarn_bleibtLeben() {

        Lebensfunke spiel = new Lebensfunke();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  true,   true,   true,
                                false,          false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertTrue(neuerZustand);
    }

    @Test
    public void lebendeZelle_mitMehrAls3LebendeNachbarn_stirbt() {

        Lebensfunke spiel = new Lebensfunke();

        final boolean lebendeZelle = true;

        boolean[] nachbarn = {  true,   true,   true,
                                true,           false,
                                false,  false,  false
        };

        boolean neuerZustand = spiel.neuerZustand(lebendeZelle, nachbarn);

        assertFalse(neuerZustand);

    }
  
}
