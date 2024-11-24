package de.abenteuersoftwareentwicklung.tdd;

public class SpielDesLebens {

    private Spielbrett situation;
    private Ausgabe ausgabe;

    public SpielDesLebens(Spielbrett anfangsSituation, Ausgabe ausgabe) {
        this.situation = anfangsSituation;
        this. ausgabe = ausgabe;
    }

    public void go() {
        ausgabe.zeige(situation);
        situation = situation.naechsteSituation();
        ausgabe.zeige(situation);
    }

    public void go(int runden) {
        ausgabe.zeige(situation);
        for (int i = 0; i < runden; i++) {
            situation = situation.naechsteSituation();
            ausgabe.zeige(situation);
        }
    }

}
