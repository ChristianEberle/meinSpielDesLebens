package de.abenteuersoftwareentwicklung.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpielbrettTest {

    @Test
    public void gibStatusEinerZelleZurueck() {
        boolean[][] zellen = {
                {false, false, false},
                {false, true,  false},
                {false, false, false}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);

        assertTrue(spielbrett.statusDerZelle(1,1));
    }

    @Test
    public void gibStatusEinerAnderenZelleZurueck() {
        boolean[][] zellen = {
                {false, false, false},
                {false, true,  false},
                {false, false, false}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);

        assertFalse(spielbrett.statusDerZelle(1,2));
    }

    @Test
    public void gibStatusNochEinerAnderenZelleZurueck() {
        boolean[][] zellen = {
                {false, false, false},
                {false, true,  false},
                {false, false, false}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);

        assertFalse(spielbrett.statusDerZelle(2,1));
    }

    @Test
    public void nachbarnDerMittlerenZelle_AlleAnderenZellen() {
        boolean[][] zellen = {
                {false, false, false},
                {false, true,  false},
                {false, false, false}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);
        boolean[] erwarteteNachbarn = {
                false, false, false,
                false,        false,
                false, false, false
        };

        boolean[] nachbarn = spielbrett.getNachbarnDerZelle(1,1);

        assertArrayEquals(erwarteteNachbarn, nachbarn);
    }

    private int toteZellen(boolean[] nachbarn) {
        int tot = 0;
        for (boolean zellen : nachbarn)
            if (!zellen) tot++;
        return tot;
    }

    private int lebendeZellen(boolean[] nachbarn) {
        int lebend = 0;
        for (boolean zellen : nachbarn)
            if (zellen) lebend++;
        return lebend;
    }

    @Test
    public void nachbarnDerMittlerenZelle_AlleAnderenZellen_2() {
        boolean[][] zellen = {
                {true,  false, false},
                {false, true,  false},
                {false, true,  true}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);
        boolean[] erwarteteNachbarn = {
                true,  false, false,
                false,        false,
                false, true,  true
        };

        boolean[] nachbarn = spielbrett.getNachbarnDerZelle(1,1);

        assertEquals(3, lebendeZellen(nachbarn));
        assertEquals(5, toteZellen(nachbarn));
    }

    @Test
    public void nachbarnEinerSeitenZelle_AlleZellenAussenSindTot() {
        boolean[][] zellen = {
                {true,  false, false},
                {false, true,  false},
                {false, true,  true}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);

        boolean[] nachbarn = spielbrett.getNachbarnDerZelle(0,0);

        assertEquals(1, lebendeZellen(nachbarn));
        assertEquals(7, toteZellen(nachbarn));
    }

    @Test
    public void nachbarnEinerSeitenZelle_AlleZellenAussenSindTot_andereEcke() {
        boolean[][] zellen = {
                {true,  false, false},
                {false, true,  false},
                {false, true,  true}
        };

        Spielbrett spielbrett = new Spielbrett(zellen);

        boolean[] nachbarn = spielbrett.getNachbarnDerZelle(2,2);

        assertEquals(2, lebendeZellen(nachbarn));
        assertEquals(6, toteZellen(nachbarn));

    }

    @Test
    public void leeresFeldBleibtLeer() {
        boolean[][] zellen = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = aktuelleSituation.naechsteSituation();

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
        boolean[][] zellen = {
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = aktuelleSituation.naechsteSituation();

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
        boolean[][] zellen = {
                {false, false, false, false},
                {false, true,  true,  true},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = aktuelleSituation.naechsteSituation();

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
        boolean[][] zellen = {
                {false, false, false, false},
                {false, true,  true,  true},
                {false, false, false, false},
                {false, false, false, false},
        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = aktuelleSituation.naechsteSituation();
        neueSituation = neueSituation.naechsteSituation();

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
        boolean[][] zellen = {
                {false, false, false},
                {true,  true,  true},
                {false, false, false},

        };
        Spielbrett aktuelleSituation = new Spielbrett(zellen);

        Spielbrett neueSituation = aktuelleSituation.naechsteSituation();
        neueSituation = neueSituation.naechsteSituation();

        boolean [][] erwarteteZellen = {
                {false, false, false},
                {true,  true,  true},
                {false, false, false},
        };
        Spielbrett erwarteteSituation = new Spielbrett(erwarteteZellen);
        assertEquals(erwarteteSituation, neueSituation);
    }

}
