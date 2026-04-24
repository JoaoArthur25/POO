package dados;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Reserva> reservas;

    public Cliente(String cpf, String nome, String endereco, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.reservas = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void reservarIda(Reserva reserva) {
        reservas.add(reserva);
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        reservas.add(ida);
        reservas.add(volta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", quantidadeReservas=" + reservas.size() +
                '}';
    }
}
