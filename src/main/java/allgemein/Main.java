package allgemein;

import koerper.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Aufgabe 1: Einlesen der CSV Datei
//Lesen sie die "geschenke.csv" mithilfe des Stream-API's ein!
//Tipp: BufferedReader.lines() als stream-Quelle

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Fehler bei Argumenteingabe!");
            System.exit(1);
        }

        Baukasten b1 = new Baukasten(3);
        //ArrayList<Bauklotz> tempBauklotzSammlung = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {//TODO Umsetzung mit Stream API
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Bauklotz bauklotz = getBauklotz(line);
                    b1.addBauklotz(bauklotz);
                    //tempBauklotzSammlung.add(bauklotz);
                } catch (RuntimeException e) {
                    System.out.println("FEHLER: (" + e.getMessage() + ") " + line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

// CSV Ausgabe - Alle Einträge
        //for (Bauklotz b : tempBauklotzSammlung) {System.out.println(b);}
        //System.out.println();
        //tempBauklotzSammlung.sort(Bauklotz::compareTo);
        //for (Bauklotz b : tempBauklotzSammlung) {System.out.println(b);}

// Baukasten - Gesamtgewicht
        System.out.println("\nGesamtgewicht des Baukastens: " + b1.berechneGesamtgewicht() + "\n");
// Baukasten - Abteilungen (unsortiert)
        b1.printAbteilungen();
        System.out.println();
// Baukasten - Abteilungen (sortiert)
        b1.printAbteilungenSorted();
        System.out.println();
    }

    private static Bauklotz getBauklotz(String line) {
        BauklotzParameter p = new BauklotzParameter(line);
        return switch (p.getArt()) {
            case "Würfel"   -> new Wuerfel(p.getFarbe(), p.getMaterial(), p.setDichte(), p.getDouble1());
            case "Kugel"    -> new Kugel(p.getFarbe(), p.getMaterial(), p.setDichte(), p.getDouble1());
            case "Zylinder" -> new Zylinder(p.getFarbe(), p.getMaterial(), p.setDichte(), p.getDouble1(), p.getDouble2());
            case "Quader"   -> new Quader(p.getFarbe(), p.getMaterial(), p.setDichte(), p.getDouble1(), p.getDouble2(), p.getDouble3());
            default -> throw new IllegalArgumentException("Unbekannter Bauklotz-Typ: " + p.getArt());
        };
    }
}
