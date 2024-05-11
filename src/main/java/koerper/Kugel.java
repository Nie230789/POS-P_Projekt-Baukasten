package koerper;

public class Kugel extends Bauklotz {

    private final double r;

    public Kugel(String farbe, String material, double dichte, double r) {
        super(farbe, material, dichte);
        this.r = r;
    }

    @Override
    double volumen() {
        return 4.0 / 3.0 * r * r * r * Math.PI;
    }
}
