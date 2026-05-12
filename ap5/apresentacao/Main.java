package ap5.apresentacao;

import ap5.dados.Contato;
import ap5.negocio.ListaTelefonica;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static ListaTelefonica lista = new ListaTelefonica();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = lerInt("Escolha: ");

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> removerContato();
                case 3 -> buscarPorLetra();
                case 4 -> listarTodos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== Lista Telefônica =====");
        System.out.println("1. Adicionar contato");
        System.out.println("2. Remover contato");
        System.out.println("3. Buscar contatos por letra");
        System.out.println("4. Listar todos os contatos");
        System.out.println("0. Sair");
    }

    private static void adicionarContato() {
        System.out.println("\n--- Adicionar Contato ---");
        String nome = lerString("Nome: ");
        String telefone = lerString("Telefone: ");

        Contato contato = new Contato(nome, telefone);
        lista.adicionarContato(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void removerContato() {
        System.out.println("\n--- Remover Contato ---");
        String nome = lerString("Nome: ");
        String telefone = lerString("Telefone: ");

        Contato contato = new Contato(nome, telefone);
        lista.removerContato(contato);
        System.out.println("Contato removido com sucesso!");
    }

    private static void buscarPorLetra() {
        System.out.println("\n--- Buscar por Letra ---");
        String entrada = lerString("Digite uma letra (A-Z): ");

        if (entrada.isEmpty()) {
            System.out.println("Entrada inválida.");
            return;
        }

        char letra = Character.toUpperCase(entrada.charAt(0));
        List<Contato> contatos = lista.buscarContatos(letra);

        if (contatos == null) {
            System.out.println("Letra inválida. Digite entre A e Z.");
        } else if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado para a letra '" + letra + "'.");
        } else {
            System.out.println("\nContatos com '" + letra + "':");
            contatos.forEach(System.out::println);
        }
    }

    private static void listarTodos() {
        System.out.println("\n--- Todos os Contatos ---");
        Map<Character, List<Contato>> mapa = lista.buscarContatos();

        boolean algumContato = false;

        for (char c = 'A'; c <= 'Z'; c++) {
            List<Contato> contatos = mapa.get(c);
            if (contatos != null && !contatos.isEmpty()) {
                System.out.println("\n[" + c + "]");
                contatos.forEach(System.out::println);
                algumContato = true;
            }
        }

        if (!algumContato) {
            System.out.println("Nenhum contato cadastrado.");
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private static int lerInt(String mensagem) {
        System.out.print(mensagem);
        try {
            int valor = Integer.parseInt(scanner.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}