import java.util.LinkedHashMap;
import java.util.Map;

import dados.Abundantes;
import dados.Fatoriais;
import dados.Fibonacci;
import dados.Gerador;
import dados.Naturais;
import dados.NumeroPrimos;
import dados.Perfeitos;
import dados.Quadrados;

public class Main {
    public static void main(String[] args) {
        Map<String, Gerador> geradores = new LinkedHashMap<>();
        geradores.put("Naturais",     new Naturais());
        geradores.put("Abundantes",   new Abundantes());
        geradores.put("Fibonacci",    new Fibonacci());
        geradores.put("Fatoriais",    new Fatoriais());
        geradores.put("NumeroPrimos", new NumeroPrimos());
        geradores.put("Perfeitos",    new Perfeitos());
        geradores.put("Quadrados",    new Quadrados());

        for (Map.Entry<String, Gerador> e : geradores.entrySet())
            e.getValue().gerar(10);

        System.out.println("=".repeat(70));
        System.out.printf("%-15s | %-35s%n", "Classe", "Sequência (10 termos)");
        System.out.println("=".repeat(70));
        for (Map.Entry<String, Gerador> e : geradores.entrySet())
            System.out.printf("%-15s | %s%n", e.getKey(), e.getValue().getSequencia());

        System.out.println("\n" + "=".repeat(70));
        System.out.printf("%-15s | %8s | %10s | %10s | %10s | %10s | %9s%n",
                "Classe", "Somatorio", "Media Ari", "Media Geo", "Variancia", "Desv Pad", "Amplitude");
        System.out.println("=".repeat(70));

        String maiorSomNome = "", maiorMaNome = "", maiorMgNome = "";
        String maiorVarNome = "", maiorDpNome = "", maiorAmpNome = "";
        long maiorSom = Long.MIN_VALUE, maiorAmp = Long.MIN_VALUE;
        double maiorMa = Double.MIN_VALUE, maiorMg = Double.MIN_VALUE;
        double maiorVar = Double.MIN_VALUE, maiorDp = Double.MIN_VALUE;

        for (Map.Entry<String, Gerador> e : geradores.entrySet()) {
            String nome = e.getKey();
            Gerador g = e.getValue();
            long som = g.somatorio();
            double ma  = g.mediaAritmetica();
            double mg  = g.mediaGeometrica();
            double var = g.variancia();
            double dp  = g.desvioPadrao();
            long amp   = g.amplitude();

            System.out.printf("%-15s | %8d | %10.2f | %10.2f | %10.2f | %10.2f | %9d%n",
                    nome, som, ma, mg, var, dp, amp);

            if (som > maiorSom) { maiorSom = som; maiorSomNome = nome; }
            if (ma  > maiorMa)  { maiorMa  = ma;  maiorMaNome  = nome; }
            if (mg  > maiorMg)  { maiorMg  = mg;  maiorMgNome  = nome; }
            if (var > maiorVar) { maiorVar = var;  maiorVarNome = nome; }
            if (dp  > maiorDp)  { maiorDp  = dp;  maiorDpNome  = nome; }
            if (amp > maiorAmp) { maiorAmp = amp;  maiorAmpNome = nome; }
        }

        System.out.println("\nMAIORES:");
        System.out.printf("  1. Somatório         %s (%d)%n",   maiorSomNome, maiorSom);
        System.out.printf("  2. Média Aritmética  %s (%.2f)%n", maiorMaNome,  maiorMa);
        System.out.printf("  3. Média Geométrica  %s (%.2f)%n", maiorMgNome,  maiorMg);
        System.out.printf("  4. Variância         %s (%.2f)%n", maiorVarNome, maiorVar);
        System.out.printf("  5. Desvio Padrão     %s (%.2f)%n", maiorDpNome,  maiorDp);
        System.out.printf("  6. Amplitude         %s (%d)%n",   maiorAmpNome, maiorAmp);
    }
}