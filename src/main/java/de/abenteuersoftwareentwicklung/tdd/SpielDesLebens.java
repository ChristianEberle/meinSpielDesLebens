package de.abenteuersoftwareentwicklung.tdd;

public class SpielDesLebens {

    private static final int GUTE_LEBENSBEDINGUNG = 3;

    public boolean neuerZustand(boolean aktuellerZustand, boolean[] nachbarn) {
        int lebendeNachbarn = anzahlLebenderZellen(nachbarn);
        return lebendeNachbarn == GUTE_LEBENSBEDINGUNG;
    }

    private int anzahlLebenderZellen(boolean[] nachbarn) {
        int anzahl = 0;
        for (boolean zustand : nachbarn) {
            if(zustand) anzahl++;
        }
        return anzahl;
    }
}
