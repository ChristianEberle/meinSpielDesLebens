package de.abenteuersoftwareentwicklung.tdd;

public class Spielbrett {

    private boolean[][] zellen;

    public Spielbrett(boolean[][] zellen) {
        this.zellen = zellen;
    }

    public boolean statusDerZelle(int x, int y) {
        return zellen[x][y];
    }

    public boolean[] getNachbarnDerZelle(int x, int y) {
        return new boolean[]{
                zellen[x-1][y-1],zellen[x][y-1],zellen[x+1][y-1],
                zellen[x-1][y],                 zellen[x+1][y],
                zellen[x-1][y+1],zellen[x][y+1],zellen[x+1][y+1]
        };
    }
}
