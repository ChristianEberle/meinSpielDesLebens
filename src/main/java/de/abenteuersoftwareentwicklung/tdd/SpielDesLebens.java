package de.abenteuersoftwareentwicklung.tdd;

public class SpielDesLebens {

    public boolean neuerZustand(boolean aktuellerZustand, boolean[] nachbarn) {
        int lebendeNachbarn = anzahlLebenderZellen(nachbarn);
        return lebendeNachbarn > 2;
    }

    private int anzahlLebenderZellen(boolean[] nachbarn) {
        int anzahl = 0;
        for (boolean zustand : nachbarn) {
            if(zustand) anzahl++;
        }
        return anzahl;
    }
}
