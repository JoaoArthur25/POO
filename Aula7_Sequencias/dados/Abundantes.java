package dados;

public class Abundantes extends Gerador {
    private boolean isAbundante(int n) {
        int soma = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                soma += i;
                if (i != n / i) soma += n / i;
            }
        }
        return soma > n;
    }

    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        int num = 2;
        while (sequencia.size() < quantidade) {
            if (isAbundante(num)) sequencia.add(num);
            num++;
        }
    }
}