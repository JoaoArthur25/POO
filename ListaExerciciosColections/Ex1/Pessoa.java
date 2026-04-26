class Pessoa implements Comparable<Pessoa> {
    String nome, cpf, cidade;
    int idade;

    public Pessoa(String nome, int idade, String cpf, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public String faixaEtaria() {
        if (idade >= 1 && idade <= 12) return "Crianças";
        if (idade <= 18) return "Adolescentes";
        if (idade <= 25) return "Jovens";
        if (idade <= 59) return "Adultos";
        return "Idosos";
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.nome);
    }

    @Override
    public String toString() {
        return nome + ", " + idade + ", " + cpf + ", " + cidade;
    }
}