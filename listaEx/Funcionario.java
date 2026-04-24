package listaEx;

import java.util.Objects;

public class Funcionario {
    private String nome;
    private int id;
    private String cpf;

    public Funcionario(String nome, int id, String cpf) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
    }

    public Funcionario() {}
        public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void cadastrarLivro(Biblioteca biblioteca, Livro livro) {
        biblioteca.adicionarLivro(livro);
    }

    public void removerLivro(Biblioteca biblioteca, Livro livro) {
        biblioteca.removerLivro(livro);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                "cpf='" + cpf + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}