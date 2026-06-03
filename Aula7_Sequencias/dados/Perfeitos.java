package dados;

import java.util.Arrays;
import java.util.List;

public class Perfeitos extends Gerador {
    private static final List<Integer> PERFEITOS_CONHECIDOS =
            Arrays.asList(6, 28, 496, 8128);

    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        for (int i = 0; i < quantidade; i++) {
            sequencia.add(PERFEITOS_CONHECIDOS.get(i % PERFEITOS_CONHECIDOS.size()));
        }
    }
}