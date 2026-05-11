package ap5.apresentacao;

import java.util.List;
import java.util.Scanner;

import ap5.negocio.ListaTelefonica;
import ap5.dados.Contato;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ListaTelefonica lista = new ListaTelefonica();
        int opcao;

        do {
            System.out.println("\n===== LISTA TELEFÔNICA =====");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar por letra");
            System.out.println("4 - Mostrar todos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarContato(lista);
                    break;
                case 2:
                    removerContato(lista);
                    break;
                case 3:
                    System.out.print("Digite a letra: ");
                    char letra = sc.nextLine().toUpperCase().charAt(0);
                    exibirContatos(lista, letra);
                    break;
                case 4:
                    exibirContatos(lista);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static Contato cadastrarContato() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        return new Contato(nome, telefone);
    }

    public static void adicionarContato(ListaTelefonica lista) {
        Contato c = cadastrarContato();
        lista.adicionarContato(c);
        System.out.println("Contato adicionado!");
    }

    public static void removerContato(ListaTelefonica lista) {
        System.out.println("Informe o contato a remover:");
        Contato c = cadastrarContato();
        lista.removerContato(c);
        System.out.println("Contato removido!");
    }

    public static void exibirContatos(ListaTelefonica lista) {
        for (char c = 'A'; c <= 'Z'; c++) {
            List<Contato> listaLetra = lista.buscarContatos(c);

            if (listaLetra != null && !listaLetra.isEmpty()) {
                System.out.println("\n" + c + ":");
                for (Contato contato : listaLetra) {
                    System.out.println(contato);
                }
            }
        }
    }

    public static void exibirContatos(ListaTelefonica lista, char letra) {
        List<Contato> listaLetra = lista.buscarContatos(letra);

        if (listaLetra != null && !listaLetra.isEmpty()) {
            for (Contato contato : listaLetra) {
                System.out.println(contato);
            }
        } else {
            System.out.println("Nenhum contato encontrado.");
        }
    }
}