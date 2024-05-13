package allgemein;

import koerper.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Klasse für Aufgabe 1

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Fehler bei Argumenteingabe!");
            System.exit(1);
        }

        Baukasten b1 = new Baukasten(4);
        //ArrayList<Bauklotz> tempBauklotzSammlung = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            br.lines().skip(1).forEach(line -> {
                try {
                    Bauklotz bauklotz = getBauklotz(line);
                    b1.addBauklotz(bauklotz);
                    //tempBauklotzSammlung.add(bauklotz);
                } catch (RuntimeException e) {
                    System.err.println("FEHLER (" + e.getMessage() + "): " + line);
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
        b1.printGesamtgewicht();
// Baukasten - Abteilungen unsortiert
        //b1.printAbteilungen();
// Baukasten - Abteilungen sortiert
        b1.printAbteilungenSorted();

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
