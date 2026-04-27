package ap6.dados;


public class Fibonacci extends Gerador {
    
    public void gerar(int quantidade){

        if (quantidade <= 0) {
            return;
        }

        sequencia.add(0);

        if (quantidade == 1) {
            return;
        }

        sequencia.add(1);

        for (int i = 2; i < quantidade; i++) {
            sequencia.add(sequencia.get(i - 1) + sequencia.get(i - 2));
        }
    }
}