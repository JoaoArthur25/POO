package ap6.dados;

public class Fatoriais extends Gerador {

    public void gerar(int n) {
        if (n <= 0) {
            return;
        }

        int numero = 1;

        while (numero <= n) {
            int fatorial = calcularFatorial(numero);
            sequencia.add(fatorial);
            numero++;
        }
    }

    private int calcularFatorial(int numero) {
        int fatorial = 1;

        while (numero > 1) {
            fatorial *= numero;
            numero--;
        }

        return fatorial;
    }
}