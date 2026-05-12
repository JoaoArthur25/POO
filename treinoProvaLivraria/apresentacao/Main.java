package treinoProvaLivraria.apresentacao;

import java.util.Scanner;

import treinoProvaLivraria.dados.Cliente;


public class Main {
    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n--- Sistema da Livraria ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Gerente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Remover Gerente");
            System.out.println("5 - Ver todos os clientes");
            System.out.println("6 - Ver todos os funcionarios");
            System.out.println("7 - Cadastrar Pedido a cliente");
            System.out.println("8 - Remover pedido de cliente");
            System.out.println
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();

                    Cliente cliente = new Cliente(email, saldo, nome, cpf);
                    livraria.adicionarCliente(cliente);
                    break;

                case 2:
                    System.out.println("Cadastrar Funcionario — implemente aqui");

                    Funcionario funcionario = new Fu
                    break;

                case 3:
                    System.out.print("CPF do cliente a remover: ");
                    String cpfRemover = sc.nextLine();
                    livraria.removerClientePorCpf(cpfRemover);
                    break;

                case 4:
                    System.out.println("Remover Funcionario — implemente aqui");
                    break;

                case 5:
                    livraria.getAllClientes();
                    break;

                case 6:
                    livraria.getAllFuncionarios();
                    break;

                case 7:
                    System.out.println("Cadastrar Pedido — implemente aqui");
                    break;

                case 8:
                    System.out.println("Remover Pedido — implemente aqui");
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida! Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}