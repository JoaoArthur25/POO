package ex3;

public class MainGrafo {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        for (int i = 0; i < 5; i++) grafo.adicionarVertice();

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 4);

        System.out.println("=== Grafo (nao direcionado) ===");
        System.out.println(grafo);

        Digrafo digrafo = new Digrafo();
        for (int i = 0; i < 5; i++) digrafo.adicionarVertice();

        digrafo.adicionarAresta(0, 1);
        digrafo.adicionarAresta(1, 3);
        digrafo.adicionarAresta(2, 0);
        digrafo.adicionarAresta(2, 1);
        digrafo.adicionarAresta(2, 4);
        digrafo.adicionarAresta(3, 1);
        digrafo.adicionarAresta(4, 2);
        digrafo.adicionarAresta(4, 3);

        System.out.println("=== Digrafo (direcionado) ===");
        System.out.println(digrafo);
    }
}
