package ex2;

public class TrianguloEquilatero extends FormaGeometrica {


    public void setLado(int valor) {
        this.medida1 = valor;
    }

    @Override
    public int calculaArea() {
        return (int) ((Math.sqrt(3) / 4) * medida1 * medida1);
    }

    @Override
    public int calculaPerimetro() {
        return 3 * medida1;
    }

    @Override
    public String toString() {
        return "TrianguloEquilatero [lado=" + medida1 + ", area=" + calculaArea() + ", perimetro=" + calculaPerimetro() + "]";
    }
}
