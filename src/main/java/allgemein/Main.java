package allgemein;

import koerper.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.ArrayList;

//Klasse für Aufgabe 1

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Fehler bei Argumenteingabe!");
            System.exit(1);
        }

        Baukasten b1 = new Baukasten(10);
        //ArrayList<Bauklotz> tempBauklotzSammlung = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(args[0]))) {
            lines.skip(1).forEach(line -> {
                try {
                    Bauklotz bauklotz = getBauklotz(line);
                    b1.addBauklotz(bauklotz);
                    //tempBauklotzSammlung.add(bauklotz);
                } catch (RuntimeException e) {
                    System.out.println("FEHLER: (" + e.getMessage() + ") " + line);
                }
            });
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

// CSV - Alle Einträge
        //for (Bauklotz b : tempBauklotzSammlung) {System.out.println(b);}
        //System.out.println();
        //tempBauklotzSammlung.sort(Bauklotz::compareTo);
        //for (Bauklotz b : tempBauklotzSammlung) {System.out.println(b);}
// Baukasten - Gesamtgewicht
        System.out.println("\nGesamtgewicht des Baukastens: " + b1.berechneGesamtgewicht() + "\n");
// Baukasten - Abteilungen unsortiert
        //b1.printAbteilungen();
        //System.out.println();
// Baukasten - Abteilungen sortiert
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
