package dados;

public class NumeroPrimos extends Gerador {
    private boolean isPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public void gerar(int quantidade) {
        sequencia.clear();
        int num = 2;
        while (sequencia.size() < quantidade) {
            if (isPrimo(num)) sequencia.add(num);
            num++;
        }
    }
}