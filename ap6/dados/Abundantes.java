package ap6.dados;

public class Abundantes extends Gerador{
    
        public void gerar(int n) {
        if (n <= 0) {
            return;
        }
        
        int count = 0;      
        int numero = 1;     
        
        while (count < n) {
            if (isAbundante(numero)) {
                sequencia.add(numero);
                count++;    
            }
            numero++;      
        }
    }
    
    private boolean isAbundante(int numero) {
        int somaDivisores = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                somaDivisores += i;
            }
        }
        return somaDivisores > numero;
    }
}
