package de.abenteuersoftwareentwicklung.tdd;

public class SpielDesLebens {

    public static void main(String[] args) {
        boolean[][] anfangsSituation = {
                {false, false, false, false, false,false, false, false,false, false, false,false, false, false, false, false},
                {false, false, false, false, false,false, false, false,false, false, false,false, false, false, false, false},
                {false, false, false, false, false,false, false, false,false, false, false,false, false, false, false, false},
                {false, false, false, false, false,true , false, false,false, false, true ,false, false, false, false, false},
                {false, false, false, true , true ,false, true , true ,true , true , false,true , true , false, false, false},
                {false, false, false, false, false,true , false, false,false, false, true ,false, false, false, false, false},
                {false, false, false, false, false,false, false, false,false, false, false,false, false, false, false, false},
                {false, false, false, false, false,false, false, false,false, false, false,false, false, false, false, false},
                {false, false, false, false, false,false, false, false,false, false, false,false, false, false, false, false}
        };
        Spielbrett anfangsSpielbrett = new Spielbrett(anfangsSituation);
        SpielDesLebens spiel = new SpielDesLebens(anfangsSpielbrett, new Konsolenausgabe());
        if (args.length > 0) {
            int runden = Integer.parseInt(args[0]);
            spiel.go(runden);
        } else {
            spiel.go();
        }
    }

    private Spielbrett situation;
    private Ausgabe ausgabe;

    public SpielDesLebens(Spielbrett anfangsSituation, Ausgabe ausgabe) {
        this.situation = anfangsSituation;
        this. ausgabe = ausgabe;
    }

    public void go() {
        go(1);
    }

    public void go(int runden) {
        ausgabe.zeige(situation);
        for (int i = 0; i < runden; i++) {
            situation = situation.naechsteSituation();
            ausgabe.zeige(situation);
        }
    }

}
