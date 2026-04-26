import java.util.*;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.print("Nome (-1 para sair): ");
            String nome = sc.nextLine();

            if (nome.equals("-1")) break;

            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            System.out.print("CPF: ");
            String cpf = sc.nextLine();

            System.out.print("Cidade: ");
            String cidade = sc.nextLine();

            pessoas.add(new Pessoa(nome, idade, cpf, cidade));
            Collections.sort(pessoas);

            exibirPorFaixaEtaria(pessoas);
        }

        sc.close();
    }

    public static void exibirPorFaixaEtaria(List<Pessoa> pessoas) {
        String[] faixas = {"Crianças", "Adolescentes", "Jovens", "Adultos", "Idosos"};

        for (String faixa : faixas) {
            System.out.println("\n" + faixa + ":");
            for (Pessoa p : pessoas) {
                if (p.faixaEtaria().equals(faixa)) {
                    System.out.println("- " + p);
                }
            }
        }
        System.out.println();
    }
}