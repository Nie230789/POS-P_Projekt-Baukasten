package allgemein;

import koerper.Bauklotz;

import java.util.ArrayList;
import java.util.HashMap;

//Klasse für Aufgabe 3 & 4

public class Baukasten {

    private final double eigengewicht;
    private final HashMap<String, ArrayList<Bauklotz>> abteilungen;

    public Baukasten(double eigengewicht) {
        this.eigengewicht = eigengewicht;
        this.abteilungen = new HashMap<>();
    }

//METHODEN
    public void addBauklotz(Bauklotz bauklotz) {
        String abteilung = bauklotz.getClass().getSimpleName();
        // Abteilung existiert noch nicht? → Erstellt neue Abteilung
        if (!abteilungen.containsKey(abteilung)) {
            abteilungen.put(abteilung, new ArrayList<>());
        }
        // Abteilung existiert? → Fügt zu bestehender Abteilung hinzu
        abteilungen.get(abteilung).add(bauklotz);
    }

    public double berechneGesamtgewicht() {
        double gesamtgewicht = 0.0;
        for (ArrayList<Bauklotz> abteilung : abteilungen.values()) {
            for (Bauklotz b : abteilung) {
                gesamtgewicht += b.gewicht();
            }
        }
        return gesamtgewicht + eigengewicht;
    }

//PRINT-METHODEN
    public void printAbteilungen() {
        for (HashMap.Entry<String, ArrayList<Bauklotz>> eintrag : abteilungen.entrySet()) {
            System.out.println("Abteilung: " + eintrag.getKey());
            for (Bauklotz b : eintrag.getValue()) {
                System.out.println(b);
            }
        }
    }

    public void printAbteilungenSorted() {
        for (HashMap.Entry<String, ArrayList<Bauklotz>> eintrag : abteilungen.entrySet()) {
            System.out.println(eintrag.getKey() + "-Abteilung (sortiert):");
            eintrag.getValue().sort(Bauklotz::compareTo);
            for (Bauklotz b : eintrag.getValue()) {
                System.out.println(b);
            }
        }
    }

}

