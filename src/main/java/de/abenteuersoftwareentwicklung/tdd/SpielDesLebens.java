package de.abenteuersoftwareentwicklung.tdd;

public class SpielDesLebens {

    private static final int GUTE_LEBENSBEDINGUNG = 3;

    public boolean neuerZustand(boolean aktuelleZelleLebt, boolean[] nachbarn) {
        if (aktuelleZelleLebt)
            return neuerZustandLebenderZelle(nachbarn);
        else
            return neuerZustandToterZelle(nachbarn);
    }

    private boolean neuerZustandLebenderZelle(boolean[] nachbarn) {
        return anzahlLebenderZellen(nachbarn) >= 2;
    }

    private boolean neuerZustandToterZelle(boolean[] nachbarn) {
        return anzahlLebenderZellen(nachbarn) == GUTE_LEBENSBEDINGUNG;
    }

    private int anzahlLebenderZellen(boolean[] nachbarn) {
        int anzahl = 0;
        for (boolean zustand : nachbarn) {
            if (zustand) anzahl++;
        }
        return anzahl;
    }
}
