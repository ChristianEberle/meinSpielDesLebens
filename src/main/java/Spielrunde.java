import de.abenteuersoftwareentwicklung.tdd.Lebensfunke;
import de.abenteuersoftwareentwicklung.tdd.Spielbrett;

public class Spielrunde {

    private Lebensfunke funke;

    public Spielrunde(Lebensfunke funke) {
        this.funke = funke;
    }

    public Spielbrett naechsteSituation(Spielbrett aktuelleSituation) {
        boolean[][] neueZellen = aktuelleSituation.neueLeereZellen();
        for (int x = 0; x < neueZellen.length; x++) {
            for (int y = 0; y < neueZellen[x].length; y++) {
                boolean aktuelleZelle = aktuelleSituation.statusDerZelle(x, y);
                boolean[] nachbarn = aktuelleSituation.getNachbarnDerZelle(x, y);
                neueZellen[x][y] = funke.neuerZustand(aktuelleZelle, nachbarn);
            }
        }
        return new Spielbrett(neueZellen);
    }
}
