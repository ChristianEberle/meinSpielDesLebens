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

}
