package negocio;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaPassagem {
    private List<Cidade> listaDeCidades;
    private List<Cliente> listaDeClientes;

    public ReservaPassagem() {
        this.listaDeCidades = new ArrayList<>();
        this.listaDeClientes = new ArrayList<>();
    }

    public void cadastrarCidade(Cidade cidade) {
        listaDeCidades.add(cidade);
    }

    public void cadastraCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public List<Reserva> mostrarReservas(String cpfCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                return cliente.getReservas();
            }
        }
        return new ArrayList<>();
    }

    public List<Cliente> mostrarClientes() {
        return listaDeClientes;
    }

    public List<Cidade> mostrarCidades() {
        return listaDeCidades;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Cidade buscarCidadePorNome(String nome) {
        for (Cidade cidade : listaDeCidades) {
            if (cidade.getNome().equalsIgnoreCase(nome)) {
                return cidade;
            }
        }
        return null;
    }
}
