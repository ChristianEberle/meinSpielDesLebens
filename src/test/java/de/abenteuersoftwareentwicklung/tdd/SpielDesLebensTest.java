package de.abenteuersoftwareentwicklung.tdd;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpielDesLebensTest {

    public static final boolean[][] BLINKER_A = {
            {false, false, false},
            {true, true, true},
            {false, false, false},
    };

    public static final boolean[][] BLINKER_B = {
            {false, true, false},
            {false, true, false},
            {false, true, false},
    };

    @Test
    public void startenDesSpielsOhneArgument_ZweiAusgabenWerdenErzeugt() {
        Ausgabe ausgabe = mock(Ausgabe.class);
        InOrder orderVerifier = inOrder(ausgabe);
        Spielbrett anfangsSituation = new Spielbrett(BLINKER_A);
        Spielbrett erwartetesSpielbrett = new Spielbrett(BLINKER_B);
        SpielDesLebens spiel = new SpielDesLebens(anfangsSituation, ausgabe);

        spiel.go();

        orderVerifier.verify(ausgabe, calls(1)).zeige(anfangsSituation);
        orderVerifier.verify(ausgabe).zeige(erwartetesSpielbrett);

    }

}
