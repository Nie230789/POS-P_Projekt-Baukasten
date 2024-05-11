package allgemein;

import koerper.Bauklotz;

import java.util.ArrayList;
import java.util.HashMap;

//Aufgabe 3: Konstruktor von "Baukasten" - einordnen in Abteilungen
//Im Konstruktor von `Baukasten` wurde der Code entfernt, welcher die Körper in die jeweilige Abteilung einordnet.
//Die Abteilung eines Körpers wird durch "koerper.getClass().getSimpleName()"`" ermittelt.

//Aufgabe 4: Gesamtgewicht des Baukastens
//Das Gewicht wird aus Eigengewicht + Summe aller Körpergewichte ermittelt.
// Vervollständigen Sie die vorhandene Methode!

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
            System.out.println(eintrag.getKey() + " (sortiert):");
            eintrag.getValue().sort(Bauklotz::compareTo);
            for (Bauklotz b : eintrag.getValue()) {
                System.out.println(b);
            }
        }
    }

}

