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

}
