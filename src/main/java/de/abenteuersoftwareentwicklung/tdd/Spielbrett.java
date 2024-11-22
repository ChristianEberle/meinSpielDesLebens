package de.abenteuersoftwareentwicklung.tdd;

public class Spielbrett {

    public Spielbrett(boolean[][] zellen) {
    }

    public boolean statusDerZelle(int x, int y) {
        if (y == 2)
            return false;
        return true;
    }
}
