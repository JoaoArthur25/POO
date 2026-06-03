package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Gerador implements ISequencia {
    protected List<Integer> sequencia;
    private static final Random random = new Random();

    public Gerador() {
        sequencia = new ArrayList<>();
    }

    public abstract void gerar(int quantidade);

    public List<Integer> getSequencia() {
        return sequencia;
    }

    @Override
    public int sortear() {
        return sequencia.get(random.nextInt(sequencia.size()));
    }

    @Override
    public long somatorio() {
        long soma = 0;
        for (int v : sequencia) soma += v;
        return soma;
    }

    @Override
    public double mediaAritmetica() {
        return (double) somatorio() / sequencia.size();
    }

    @Override
    public double mediaGeometrica() {
        double produto = 1.0;
        for (int v : sequencia) produto *= v;
        return Math.pow(produto, 1.0 / sequencia.size());
    }

    @Override
    public double variancia() {
        double media = mediaAritmetica();
        double soma = 0;
        for (int v : sequencia) soma += Math.pow(v - media, 2);
        return soma / (sequencia.size() - 1);
    }

    @Override
    public double desvioPadrao() {
        return Math.sqrt(variancia());
    }

    @Override
    public long amplitude() {
        return Collections.max(sequencia) - Collections.min(sequencia);
    }
}