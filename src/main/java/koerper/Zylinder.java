package koerper;

public class Zylinder extends Bauklotz {

    private final double r, h;

    public Zylinder(String farbe, String material, double dichte, double r, double h) {
        super(farbe, material, dichte);
        this.r = r;
        this.h = h;
    }

    @Override
    double volumen() {
        return r * r * Math.PI * h;
    }
}