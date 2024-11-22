package de.abenteuersoftwareentwicklung.tdd;

public class Spielbrett {

    private boolean[][] zellen;

    public Spielbrett(boolean[][] zellen) {
        this.zellen = zellen;
    }

    public boolean statusDerZelle(int x, int y) {
        return zellen[x][y];
    }
}
