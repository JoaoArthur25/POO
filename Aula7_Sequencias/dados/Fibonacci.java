package dados;

public class Fibonacci extends Gerador {
    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        int a = 1, b = 1;
        for (int i = 0; i < quantidade; i++) {
            sequencia.add(a);
            int tmp = a + b;
            a = b;
            b = tmp;
        }
    }
}