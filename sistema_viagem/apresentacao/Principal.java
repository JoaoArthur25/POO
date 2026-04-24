package apresentacao;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;
import negocio.ReservaPassagem;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
    private static ReservaPassagem reservaPassagem = new ReservaPassagem();
    private static int contadorReserva = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE VIAGEM =====");
            System.out.println("1 - Cadastrar cidade");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Fazer reserva");
            System.out.println("4 - Mostrar reservas de um cliente");
            System.out.println("5 - Mostrar clientes");
            System.out.println("6 - Mostrar cidades");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: cadastrarCidade(); break;
                case 2: cadastrarCliente(); break;
                case 3: fazerReserva(); break;
                case 4: mostrarReservas(); break;
                case 5: listarClientes(); break;
                case 6: listarCidades(); break;
                case 0: System.out.println("Encerrando sistema..."); break;
                default: System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void cadastrarCidade() {
        System.out.print("Nome da cidade: ");
        String nome = sc.nextLine();

        System.out.print("Estado: ");
        String estado = sc.nextLine();

        Cidade cidade = new Cidade(nome, estado);
        reservaPassagem.cadastrarCidade(cidade);

        System.out.println("Cidade cadastrada com sucesso.");
    }

    public static void cadastrarCliente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente(cpf, nome, endereco, telefone);
        reservaPassagem.cadastraCliente(cliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    public static void fazerReserva() {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();

        Cliente cliente = reservaPassagem.buscarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Cidade de origem: ");
        Cidade origem = reservaPassagem.buscarCidadePorNome(sc.nextLine());

        System.out.print("Cidade de destino: ");
        Cidade destino = reservaPassagem.buscarCidadePorNome(sc.nextLine());

        if (origem == null || destino == null) {
            System.out.println("Origem ou destino não cadastrados.");
            return;
        }

        System.out.print("Data do voo: ");
        String dataVoo = sc.nextLine();

        System.out.print("Hora do voo: ");
        String horaVoo = sc.nextLine();

        System.out.print("Preço: ");
        float preco = Float.parseFloat(sc.nextLine());

        System.out.print("Classe do voo: ");
        String classe = sc.nextLine();

        System.out.print("Poltrona: ");
        int poltrona = Integer.parseInt(sc.nextLine());

        System.out.print("Ida e volta? (s/n): ");
        boolean idaEVolta = sc.nextLine().equalsIgnoreCase("s");

        Reserva ida = new Reserva(contadorReserva++, dataVoo, horaVoo, preco, classe, idaEVolta, poltrona, origem, destino);

        if (!idaEVolta) {
            reservaPassagem.reservarIda(cliente, ida);
        } else {
            System.out.print("Data volta: ");
            String dataVolta = sc.nextLine();

            System.out.print("Hora volta: ");
            String horaVolta = sc.nextLine();

            System.out.print("Preço volta: ");
            float precoVolta = Float.parseFloat(sc.nextLine());

            System.out.print("Classe volta: ");
            String classeVolta = sc.nextLine();

            System.out.print("Poltrona volta: ");
            int poltronaVolta = Integer.parseInt(sc.nextLine());

            Reserva volta = new Reserva(contadorReserva++, dataVolta, horaVolta, precoVolta, classeVolta, true, poltronaVolta, destino, origem);

            reservaPassagem.reservarVolta(cliente, ida, volta);
        }

        System.out.println("Reserva realizada com sucesso.");
    }

    public static void mostrarReservas() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        List<Reserva> reservas = reservaPassagem.mostrarReservas(cpf);

        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public static void listarClientes() {
        for (Cliente c : reservaPassagem.mostrarClientes()) {
            System.out.println(c);
        }
    }

    public static void listarCidades() {
        for (Cidade c : reservaPassagem.mostrarCidades()) {
            System.out.println(c);
        }
    }
}
