package ex3;

public class Grafo extends Digrafo {

    public Grafo() {
        super();
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia1.get(origem).set(destino, 1);
        matrizAdjacencia1.get(destino).set(origem, 1);
    }
}
