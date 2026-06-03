package ex3;

import java.util.ArrayList;
import java.util.List;

public class Digrafo {
    protected List<List<Integer>> matrizAdjacencia1;

    public Digrafo() {
        matrizAdjacencia1 = new ArrayList<>();
    }

    public void adicionarVertice() {
        for (List<Integer> linha : matrizAdjacencia1) {
            linha.add(0);
        }
        int tamanho = matrizAdjacencia1.size() + 1;
        List<Integer> novaLinha = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            novaLinha.add(0);
        }
        matrizAdjacencia1.add(novaLinha);
    }

    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia1.get(origem).set(destino, 1);
    }

    @Override
    public String toString() {
        int n = matrizAdjacencia1.size();
        StringBuilder sb = new StringBuilder();

        sb.append("   ");
        for (int i = 0; i < n; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(String.format("%3d", i));
            for (int j = 0; j < n; j++) {
                sb.append(String.format("%3d", matrizAdjacencia1.get(i).get(j)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
