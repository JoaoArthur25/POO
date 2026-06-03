package ex2;

public class Losango extends FormaGeometrica {

    // medida1 = diagonal maior (D), medida2 = diagonal menor (d)

    public void setD(int valor) {
        this.medida1 = valor;
    }

    public void setd(int valor) {
        this.medida2 = valor;
    }

    @Override
    public int calculaArea() {
        // A = (D * d) / 2
        return (medida1 * medida2) / 2;
    }

    @Override
    public int calculaPerimetro() {
        // P = 4 * sqrt((D/2)^2 + (d/2)^2)
        double lado = Math.sqrt(Math.pow(medida1 / 2.0, 2) + Math.pow(medida2 / 2.0, 2));
        return (int) (4 * lado);
    }

    @Override
    public String toString() {
        return "Losango [D=" + medida1 + ", d=" + medida2 + ", area=" + calculaArea() + ", perimetro=" + calculaPerimetro() + "]";
    }
}
