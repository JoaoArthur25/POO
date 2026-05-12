package treinoProvaLivraria.apresentacao;

import java.util.ArrayList;
import java.util.List;

import treinoProvaLivraria.dados.Cliente;
import treinoProvaLivraria.dados.Funcionario;

public class Livraria {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;

    public Livraria() {
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public boolean adicionarCliente(Cliente cliente) {

        if (!(clientes.contains(cliente))) {
            clientes.add(cliente);
            System.out.println("Cliente criado");
            return true;
        } else {
            System.out.println("Esse cliente já existe");
            return false;
        }
    }

    public boolean removerClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                clientes.remove(c);
                System.out.println("Cliente removido: " + c.getNome());
                return true;
            }
        }
        System.out.println("Cliente não encontrado.");
        return false;
    }

    public boolean adicionarFuncionario(Funcionario funcionario) {

        if (!(funcionarios.contains(funcionario))) {
            funcionarios.add(funcionario);
            System.out.println("Funcionario criado");
            return true;
        } else {
            System.out.println("Esse funcionario já existe");
            return false;
        }
    }

    public boolean removerFuncionarioPorMatricula(String matricula) {
        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equals(matricula)) {
                clientes.remove(f);
                System.out.println("Funcionario removido: " + f.getNome());
                return true;
            }
        }
        System.out.println("Funcionario não encontrado.");
        return false;
    }

    public void getAllClientes() {
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    public void getAllFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
        }
    }
}