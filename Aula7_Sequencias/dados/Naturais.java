package dados;

public class Naturais extends Gerador {
    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        for (int i = 1; i <= quantidade; i++) {
            sequencia.add(i);
        }
    }
}