package ap6.dados;
import java.util.ArrayList;

public class Naturais extends Gerador {

    public void gerar(int n) {
        sequencia = new ArrayList<>();
        if (n <= 0) {
            return;
        }
        
        for (int i = 0; i < n; i++) {
            sequencia.add(i + 1);
        }
    }
}
