package ap6.dados;

public class Primos extends Gerador {

    public void gerar(int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        int numero = 2;

        while (sequencia.size() < quantidade) {
            if (ehPrimo(numero)) {
                sequencia.add(numero);
            }
            numero++;
        }
    }

    private boolean ehPrimo(int numero) {
        if (numero < 2) return false;

        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}