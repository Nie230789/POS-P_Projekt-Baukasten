package allgemein;

import koerper.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Baukasten baukasten;

    @BeforeEach
    void setUp() {
        baukasten = new Baukasten(3);

        baukasten.addBauklotz(new Wuerfel("gelb", "Buchenholz", 0.6, 3));
        baukasten.addBauklotz(new Kugel("blau", "Eichenholz", 1, 4));
        baukasten.addBauklotz(new Quader("weiß", "Kiefernholz", 2, 5, 5, 5));
        baukasten.addBauklotz(new Zylinder("rot", "Fichtenholz", 0.9, 1, 3));
        baukasten.addBauklotz(new Wuerfel("lila", "Eichenholz", 1, 2));
    }

    @Test
    void testGewicht() {
        baukasten.printAbteilungenSorted();
        assertEquals(550.7648732710214 + 3, baukasten.berechneGesamtgewicht());
    }
}