package dados;

public class Fatoriais extends Gerador {
    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        int fat = 1;
        for (int i = 1; i <= quantidade; i++) {
            fat *= i;
            sequencia.add(fat);
        }
    }
}