package Ex4;

import java.util.List;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Turma turma = new Turma();

        while (true) {
            System.out.print("Nome do aluno (-1 para sair): ");
            String nome = sc.nextLine();

            if (nome.equals("-1")) break;

            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            double[] notas = new double[5];

            for (int i = 0; i < 5; i++) {
                System.out.print("Nota " + (i + 1) + ": ");
                notas[i] = Double.parseDouble(sc.nextLine());
            }

            turma.adicionarAluno(new Aluno(nome, idade, notas));
        }

        List<Equipe> equipes = turma.separarEmEquipes();

        int contador = 1;
        for (Equipe equipe : equipes) {
            System.out.println("\nEquipe " + contador++);
            equipe.exibir();
        }

        sc.close();
    }
}