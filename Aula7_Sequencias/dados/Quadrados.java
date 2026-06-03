package dados;

public class Quadrados extends Gerador {
    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        for (int i = 1; i <= quantidade; i++) {
            sequencia.add(i * i);
        }
    }
}