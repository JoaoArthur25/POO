package ap6.dados;

import java.util.ArrayList;
import java.util.List;

public abstract class Gerador {
    protected List<Integer> sequencia;
    
    public Gerador() {
        this.sequencia = new ArrayList<>();
    }
    
    public abstract void gerar(int n);
    
    public List<Integer> getSequencia() {
        return sequencia;
    }
}