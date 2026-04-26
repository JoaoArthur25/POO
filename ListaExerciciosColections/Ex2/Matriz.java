package Ex2;
import java.util.*;

public class Matriz<T> {
    private int n, m;
    private Object[][] matriz;

    public Matriz(int n, int m) {
        this.n = n;
        this.m = m;
        this.matriz = new Object[n][m];
    }

    public boolean set(T objeto, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        matriz[i][j] = objeto;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return null;
        return (T) matriz[i][j];
    }

    public List<T> getLinha(int linha) {
        List<T> lista = new ArrayList<>();
        if (linha < 0 || linha >= n) return lista;

        for (int j = 0; j < m; j++) {
            lista.add(get(linha, j));
        }

        return lista;
    }

    public List<T> getColuna(int coluna) {
        List<T> lista = new ArrayList<>();
        if (coluna < 0 || coluna >= m) return lista;

        for (int i = 0; i < n; i++) {
            lista.add(get(i, coluna));
        }

        return lista;
    }

    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> lista = new ArrayList<>();

        int meioLinha = (n + 1) / 2;
        int meioColuna = (m + 1) / 2;

        int inicioLinha = 0, fimLinha = 0, inicioColuna = 0, fimColuna = 0;

        switch (quadrante) {
            case PRIMEIRO:
                inicioLinha = 0;
                fimLinha = meioLinha;
                inicioColuna = 0;
                fimColuna = meioColuna;
                break;

            case SEGUNDO:
                inicioLinha = 0;
                fimLinha = meioLinha;
                inicioColuna = meioColuna;
                fimColuna = m;
                break;

            case TERCEIRO:
                inicioLinha = meioLinha;
                fimLinha = n;
                inicioColuna = 0;
                fimColuna = meioColuna;
                break;

            case QUARTO:
                inicioLinha = meioLinha;
                fimLinha = n;
                inicioColuna = meioColuna;
                fimColuna = m;
                break;
        }

        for (int i = inicioLinha; i < fimLinha; i++) {
            for (int j = inicioColuna; j < fimColuna; j++) {
                lista.add(get(i, j));
            }
        }

        return lista;
    }
}