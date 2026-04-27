package ap6.dados;

public class Perfeitos extends Gerador {

    public void gerar(int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        int numero = 2;

        while (sequencia.size() < quantidade) {
            if (ehPerfeito(numero)) {
                sequencia.add(numero);
            }
            numero++;
        }
    }

    private boolean ehPerfeito(int numero) {
        int soma = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                soma += i;
            }
        }

        return soma == numero;
    }
}