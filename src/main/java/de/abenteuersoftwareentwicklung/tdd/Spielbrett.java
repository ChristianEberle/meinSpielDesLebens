package de.abenteuersoftwareentwicklung.tdd;

import java.util.Arrays;

public class Spielbrett {

    private boolean[][] zellen;
    private Lebensfunke funke;

    public Spielbrett(boolean[][] zellen) {
        this.zellen = zellen;
        this.funke = new Lebensfunke();
    }

    public Spielbrett(boolean[][] zellen, Lebensfunke funke) {
        this.zellen = zellen;
        this.funke = funke;
    }

    public boolean statusDerZelle(int x, int y) {
        if (x < 0 || y < 0 || x >= zellen.length || y >= zellen.length)
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Spielbrett) {
            Spielbrett s = (Spielbrett) o;
            if(Arrays.deepEquals(zellen, s.zellen))
                return true;
        }
        return super.equals(o);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(zellen);
    }

    public boolean[][] neueLeereZellen() {
        return new boolean[zellen.length][zellen[0].length];
    }

    public Spielbrett naechsteSituation() {
        boolean[][] neueZellen = neueLeereZellen();
        for (int x = 0; x < neueZellen.length; x++) {
            for (int y = 0; y < neueZellen[x].length; y++) {
                boolean aktuelleZelle = statusDerZelle(x, y);
                boolean[] nachbarn = getNachbarnDerZelle(x, y);
                neueZellen[x][y] = funke.neuerZustand(aktuelleZelle, nachbarn);
            }
        }
        this.zellen = neueZellen;
        return this;
    }
}
