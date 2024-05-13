package allgemein;

//Klasse für Aufgabe 2

public class BauklotzParameter {
    private String art, farbe, material;
    private double double1, double2, double3;//Einheit: cm

    public BauklotzParameter(String line) {
        String[] splitter = line.split(";");
        this.setArt(splitter[0]);
        this.setFarbe(splitter[1]);
        this.setMaterial(splitter[2]);
        this.setDouble1(Double.parseDouble(splitter[3]));
        switch (splitter.length) {
            case 4:
                if (!splitter[0].equals("Würfel") && !splitter[0].equals("Kugel")) {
                    throw new IllegalArgumentException("Ungueltige Art (4)");
                }
                break;
            case 5:
                if (!splitter[0].equals("Zylinder")) {
                    throw new IllegalArgumentException("Ungueltige Art (5)");
                }
                this.setDouble2(Double.parseDouble(splitter[4]));
                break;
            case 6:
                if (!splitter[0].equals("Quader")) {
                    throw new IllegalArgumentException("Ungueltige Art (6)");
                }
                this.setDouble2(Double.parseDouble(splitter[4]));
                this.setDouble3(Double.parseDouble(splitter[5]));
                break;
            default:
                throw new IllegalArgumentException("Ungueltige Parameteranzahl!");
        }
    }

//SETTER
    public void setArt(String art) {
        if (art == null || art.isEmpty()) {
            throw new IllegalArgumentException("Art fehlt!");
        } else {
            this.art = art;
        }
    }
    public void setFarbe(String farbe) {
        if (farbe == null || farbe.isEmpty()) {
            throw new IllegalArgumentException("Farbe fehlt!");
        } else {
            this.farbe = farbe;
        }
    }
    public void setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("Material fehlt!");
        } else {
            this.material = material;
        }
    }
    public void setDouble1(double double1) {
        if (double1 > 0.0) {
            this.double1 = double1;
        } else {
            throw new IllegalArgumentException("Maß 1 ist ungueltig!");
        }
    }
    public void setDouble2(double double2) {
        if (double2 > 0.0) {
            this.double2 = double2;
        } else {
            throw new IllegalArgumentException("Maß 2 ist ungueltig!");
        }
    }
    public void setDouble3(double double3) {
        if (double3 > 0.0) {
            this.double3 = double3;
        } else {
            throw new IllegalArgumentException("Maß 3 ist ungueltig!");
        }
    }

//GETTER
    public String getArt() {
        return this.art;
    }
    public String getFarbe() {
        return this.farbe;
    }
    public String getMaterial() {
        return this.material;
    }
    public double getDouble1() {
        return this.double1;
    }
    public double getDouble2() {
        return this.double2;
    }
    public double getDouble3() {
        return this.double3;
    }

//METHODEN
    public double setDichte() {//Einheit: g/cm^3
        // Setzt die Dichte abhängig vom gegebenen Material
        return switch (this.material) {
            case "Eichenholz" -> 0.67;
            case "Buchenholz" -> 0.68;
            case "Kiefernholz" -> 0.52;
            case "Fichtenholz" -> 0.46;
            default -> throw new IllegalArgumentException("Unbekanntes Material: " + this.material);
        };
    }

}