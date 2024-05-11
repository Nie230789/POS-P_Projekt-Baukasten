package koerper;

//Aufgabe 5: compareTo in "Koerper"
//Wie in der Einleitung erwähnt, sind innerhalb der Abteilungen des Baukastens die Körper nach Farbe zu sortieren (alphabetisch)
// und bei Gleichheit nach Gewicht (absteigend)

public abstract class Bauklotz implements Comparable<Bauklotz> {

    private final double dichte;
    private final String farbe, material;

    public Bauklotz(String farbe, String material, double dichte) {
        this.farbe = farbe;
        this.material = material;
        this.dichte = dichte;
    }

//METHODEN
    abstract double volumen();

    public double gewicht() {
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
    public String toString() { //TODO Runden auf 2 Nachkommastellen
        return this.getClass().getName().split("\\.")[1] + " (Volumen: " + this.volumen() + ", Gewicht: " + this.gewicht() + ")";
        //return this.getClass().getName().split("\\.")[1] + " (" + this.farbe +  " Volumen: " + Math.round(this.volumen()) + ", Gewicht: " + Math.round(this.gewicht()) + ")";
    }
}
