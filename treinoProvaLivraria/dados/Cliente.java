package treinoProvaLivraria.dados;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Pagavel {

    private String email;
    private List<Pedido> pedidos;
    private double saldo;

    public Cliente(String email, double saldo, String nome, String cpf) {
        super(nome, cpf);
        this.email = email;
        this.saldo = saldo;
        this.pedidos = new ArrayList<>();
    }

    public Cliente() {
    }

    public boolean pagar(double valor) {

        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.printf("%s pagou R$%.2f. Saldo restante: R$%.2f%n",
                        getNome(), valor, saldo);
                return true;
            } else {
                System.out.println("Saldo insuficiente!");
                return false;
            }
        } else
            return false;

    }

    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
        System.out.println("Pedido add!");
    }

    public boolean removerPedido(Pedido pedido){
        if(pedidos.contains(pedido)){
            pedidos.remove(pedido);
            System.out.println("Pedido removido");
            return true;
        } else {
            System.out.println("Pedido n existe");
            return false;
        }
    }

    public void getAllPedidos(){
        for(Pedido p : pedidos) {
            System.out.println(p.toString());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
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
        Cliente other = (Cliente) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (pedidos == null) {
            if (other.pedidos != null)
                return false;
        } else if (!pedidos.equals(other.pedidos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [email=" + email + ", pedidos=" + pedidos + ", getNome()=" + getNome() + ", getCpf()="
                + getCpf() + "]";
    }

}
