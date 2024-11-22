package de.abenteuersoftwareentwicklung.tdd;

public class Spielbrett {

    private boolean[][] zellen;

    public Spielbrett(boolean[][] zellen) {
        this.zellen = zellen;
    }

    public boolean statusDerZelle(int x, int y) {
        if (x < 0 || y < 0)
            return false;
        return zellen[x][y];
    }

    public boolean[] getNachbarnDerZelle(int x, int y) {
        return new boolean[]{
                statusDerZelle(x-1,y-1),statusDerZelle(x,y-1),statusDerZelle(x+1,y-1),
                statusDerZelle(x-1,y),                 statusDerZelle(x+1,y),
                statusDerZelle(x-1,y+1),statusDerZelle(x,y+1),statusDerZelle(x+1,y+1)
        };
    }
}
