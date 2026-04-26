package Ex4;

class Aluno {
    String nome;
    int idade;
    double[] notas = new double[5];

    public Aluno(String nome, int idade, double[] notas) {
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
    }

    public double getMedia() {
        double soma = 0;
        for (double nota : notas) soma += nota;
        return soma / notas.length;
    }

    @Override
    public String toString() {
        return nome + " - média: " + String.format("%.2f", getMedia());
    }
}