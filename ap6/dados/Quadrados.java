package ap6.dados;

public class Quadrados extends Gerador {

    public void gerar(int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        int numero = 1;

        while (sequencia.size() < quantidade) {
            sequencia.add(numero * numero);
            numero++;
        }
    }
}