package koerper;

public class Quader extends Bauklotz {

    private final double a, b, c;

    public Quader(String farbe, String material, double dichte,  double a, double b, double c) {
        super(farbe, material, dichte);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double volumen () {
        return a * b * c;
    }
}
