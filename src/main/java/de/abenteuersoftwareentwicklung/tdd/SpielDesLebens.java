package de.abenteuersoftwareentwicklung.tdd;

public class SpielDesLebens {

    private static final int GUTE_LEBENSBEDINGUNG = 3;
    private static final int AKZEPTABLE_LEBENSBEDINGUNG = 2;

    public boolean neuerZustand(boolean aktuelleZelleLebt, boolean[] nachbarn) {
        if (aktuelleZelleLebt)
            return neuerZustandLebenderZelle(nachbarn);
        else
            return neuerZustandToterZelle(nachbarn);
    }

    private boolean neuerZustandLebenderZelle(boolean[] nachbarn) {
        int lebendeNachbarn = anzahlLebenderZellen(nachbarn);
        return lebendeNachbarn == AKZEPTABLE_LEBENSBEDINGUNG || lebendeNachbarn == GUTE_LEBENSBEDINGUNG;
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
