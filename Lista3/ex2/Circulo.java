package ex2;

public class Circulo extends FormaGeometrica {


    public void setRaio(int valor) {
        this.medida1 = valor;
        this.medida2 = 2 * valor;
    }

    @Override
    public int calculaArea() {
        return (int) (Math.PI * medida1 * medida1);
    }

    @Override
    public int calculaPerimetro() {
        return (int) (Math.PI * medida2);
    }

    @Override
    public String toString() {
        return "Circulo [raio=" + medida1 + ", diametro=" + medida2 + ", area=" + calculaArea() + ", perimetro=" + calculaPerimetro() + "]";
    }
}
