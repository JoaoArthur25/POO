package Ex3;

import java.util.*;
import Ex2.Matriz;
import Ex2.Quadrante;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matriz<Integer> matriz = new Matriz<>(5, 5);

        System.out.println("Digite os 25 valores da matriz 5x5:");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int valor = sc.nextInt();

                if (valor == -1) {
                    System.out.println("Leitura encerrada.");
                    sc.close();
                    return;
                }

                matriz.set(valor, i, j);
            }
        }

        int menor = Integer.MAX_VALUE;

        for (Quadrante q : Quadrante.values()) {
            for (Integer valor : matriz.getElementosQuadrante(q)) {
                if (valor != null && valor < menor) {
                    menor = valor;
                }
            }
        }

        System.out.println("Menor elemento da matriz: " + menor);

        sc.close();
    }
}