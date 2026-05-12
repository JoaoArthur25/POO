package treinoProvaLivraria.dados;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private List<Produto> itens;
    private String status;

    public Pedido(int numero, String status) {
        this.numero = numero;
        this.status = status;
        this.itens = new ArrayList<>();
    }

    public double calcularTotal(){
        double total = 0;
        for(Produto p : itens){
            total += p.getSubtotal();
        }
        return total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido [numero=" + numero + ", itens=" + itens + ", status=" + status + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        result = prime * result + ((itens == null) ? 0 : itens.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (numero != other.numero)
            return false;
        if (itens == null) {
            if (other.itens != null)
                return false;
        } else if (!itens.equals(other.itens))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }
}
