package ex2;

public class MainFormas {
    public static void main(String[] args) {
        TrianguloEquilatero t1 = new TrianguloEquilatero();
        t1.setLado(6);

        TrianguloEquilatero t2 = new TrianguloEquilatero();
        t2.setLado(10);

        Losango l1 = new Losango();
        l1.setD(8);
        l1.setd(6);

        Losango l2 = new Losango();
        l2.setD(12);
        l2.setd(10);

        Circulo c1 = new Circulo();
        c1.setRaio(5);

        Circulo c2 = new Circulo();
        c2.setRaio(7);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(c1);
        System.out.println(c2);
    }
}
