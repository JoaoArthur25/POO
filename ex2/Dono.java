package ex2;

public class Dono {
    private String nome;
    private Endereco endereco;
    private String cpf;

    public Dono(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Dono(String nome, Endereco endereco, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dono: ").append(nome).append(" (CPF: ").append(cpf).append(")");
        if (endereco != null) {
            sb.append("\nEndereço: ").append(endereco.toString());
        }
        return sb.toString();
    }
}