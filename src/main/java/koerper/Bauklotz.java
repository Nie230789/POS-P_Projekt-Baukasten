package koerper;

//Klasse für Aufgabe 5

public abstract class Bauklotz implements Comparable<Bauklotz> {

    private final double dichte;
    private final String farbe, material;

    public Bauklotz(String farbe, String material, double dichte) {
        this.farbe = farbe;
        this.material = material;
        this.dichte = dichte;
    }

//METHODEN
    abstract double volumen();//Einheit: cm^3

    public double gewicht() {//Einheit: g
        return this.volumen() * this.dichte;
    }

    @Override
    public int compareTo(Bauklotz other) {
        int farbeVergleich = this.farbe.compareTo(other.farbe);
        if (farbeVergleich != 0) {
            return farbeVergleich;
        }
        else {
            double gewichtDifferenz = other.gewicht() - this.gewicht();
            return Double.compare(gewichtDifferenz, 0);
        }
    }

    @Override
    public String toString() {
        double volumenGerundet = Math.round(this.volumen() * 100.0) / 100.0;
        double gewichtGerundet = Math.round(this.gewicht() * 100.0) / 100.0;
        return this.getClass().getName().split("\\.")[1] + " (Volumen: " + volumenGerundet + "cm^3, Gewicht: " + gewichtGerundet + "g)";
    }
}
