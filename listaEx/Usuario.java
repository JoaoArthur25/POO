package listaEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nome;
    private int id;
    private String telefone;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome, int id, String telefone) {
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
    }

    public Usuario() {
        this.emprestimos = new ArrayList<>();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarEmprestimo(Emprestimo e) {
        emprestimos.add(e);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}