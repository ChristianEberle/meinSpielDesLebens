package de.abenteuersoftwareentwicklung.tdd;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpielDesLebensTest {

    @Test
    public void startenDesSpielsOhneArgument_ZweiAusgabenWerdenErzeugt() {
        Ausgabe ausgabe = mock(Ausgabe.class);
        InOrder orderVerifier = inOrder(ausgabe);
        boolean[][] zellen = {
                {false, false, false},
                {true, true, true},
                {false, false, false},
        };
        Spielbrett anfangsSituation = new Spielbrett(zellen);
        boolean[][] erwarteteZellen = {
                {false, true, false},
                {false, true, false},
                {false, true, false},
        };
        Spielbrett erwartetesSpielbrett = new Spielbrett(erwarteteZellen);
        SpielDesLebens spiel = new SpielDesLebens(anfangsSituation, ausgabe);

        spiel.go();

        orderVerifier.verify(ausgabe, calls(1)).zeige(anfangsSituation);
        orderVerifier.verify(ausgabe).zeige(erwartetesSpielbrett);

    }

}
