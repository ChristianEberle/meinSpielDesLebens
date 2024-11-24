package de.abenteuersoftwareentwicklung.tdd;

public class Konsolenausgabe implements Ausgabe {

    @Override
    public void zeige(Spielbrett situation) {
        System.out.println("       ");
        System.out.println(situation);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
