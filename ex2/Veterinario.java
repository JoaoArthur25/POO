package ex2;

public class Veterinario {
    private String nome;
    private float salario;
    private Endereco endereco;
    private Animal[] animais;
    private int quantidadeAnimais;

    public Veterinario(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
        this.animais = new Animal[50];
        this.quantidadeAnimais = 0;
    }

    public Veterinario(String nome, float salario, Endereco endereco) {
        this(nome, salario);
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Animal[] getAnimais() {
        return animais;
    }

    public boolean adicionarAnimal(Animal animal) {
        if (quantidadeAnimais < animais.length) {
            animais[quantidadeAnimais] = animal;
            quantidadeAnimais++;
            return true;
        }
        return false;
    }

    public Animal getAnimal(int index) {
        if (index >= 0 && index < quantidadeAnimais) {
            return animais[index];
        }
        return null;
    }

    public int getQuantidadeAnimais() {
        return quantidadeAnimais;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veterinário: ").append(nome).append("\n");
        sb.append("Salário: ").append(String.format("%.2f", salario)).append("\n");
        if (endereco != null) {
            sb.append("Endereço: ").append(endereco.toString()).append("\n");
        }
        sb.append("Quantidade de animais atendidos: ").append(quantidadeAnimais);
        return sb.toString();
    }
}