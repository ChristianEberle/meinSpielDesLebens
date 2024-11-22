import de.abenteuersoftwareentwicklung.tdd.Lebensfunke;
import de.abenteuersoftwareentwicklung.tdd.Spielbrett;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpielrundeTest {

    @Test
    public void leeresFeldBleibtLeer() {
        Lebensfunke funke = new Lebensfunke();
        Spielrunde runde = new Spielrunde(funke);
        boolean[][] zellen = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = runde.naechsteSituation(aktuelleSituation);

        boolean [][] erwarteteZellen = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett erwarteteSituation = new Spielbrett(erwarteteZellen);
        assertEquals(erwarteteSituation, neueSituation);
    }

    @Test
    public void blockBleibtBlock() {
        Lebensfunke funke = new Lebensfunke();
        Spielrunde runde = new Spielrunde(funke);
        boolean[][] zellen = {
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = runde.naechsteSituation(aktuelleSituation);

        boolean [][] erwarteteZellen = {
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };
        Spielbrett erwarteteSituation = new Spielbrett(erwarteteZellen);
        assertEquals(erwarteteSituation, neueSituation);
    }

    @Test
    public void blinkerBlinkt() {
        Lebensfunke funke = new Lebensfunke();
        Spielrunde runde = new Spielrunde(funke);
        boolean[][] zellen = {
                {false, false, false, false},
                {false, true,  true,  true},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = runde.naechsteSituation(aktuelleSituation);

        boolean [][] erwarteteZellen = {
                {false, false, true,  false},
                {false, false, true,  false},
                {false, false, true,  false},
                {false, false, false, false},
        };
        Spielbrett erwarteteSituation = new Spielbrett(erwarteteZellen);
        assertEquals(erwarteteSituation, neueSituation);
    }

    @Test
    public void blinkerBlinktDoppelt() {
        Lebensfunke funke = new Lebensfunke();
        Spielrunde runde = new Spielrunde(funke);
        boolean[][] zellen = {
                {false, false, false, false},
                {false, true,  true,  true},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = runde.naechsteSituation(aktuelleSituation);
        neueSituation = runde.naechsteSituation(neueSituation);

        boolean [][] erwarteteZellen = {
                {false, false, false, false},
                {false, true,  true,  true},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett erwarteteSituation = new Spielbrett(erwarteteZellen);
        assertEquals(erwarteteSituation, neueSituation);
    }

    @Test
    public void blinkerBlinktDoppelt_inKleinemFeld() {
        Lebensfunke funke = new Lebensfunke();
        Spielrunde runde = new Spielrunde(funke);
        boolean[][] zellen = {
                {false, false, false},
                {true,  true,  true},
                {false, false, false},

        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = runde.naechsteSituation(aktuelleSituation);
        neueSituation = runde.naechsteSituation(neueSituation);

        boolean [][] erwarteteZellen = {
                {false, false, false},
                {true,  true,  true},
                {false, false, false},
        };
        Spielbrett erwarteteSituation = new Spielbrett(erwarteteZellen);
        assertEquals(erwarteteSituation, neueSituation);
    }
}
