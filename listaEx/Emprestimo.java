package listaEx;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.ativo = true;
        livro.emprestar();
    }

    public Emprestimo() {}

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void finalizar() {
        this.ativo = false;
        livro.devolver();
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "livro=" + livro +
                ", usuario=" + usuario +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", ativo=" + ativo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emprestimo)) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(livro, that.livro) &&
               Objects.equals(usuario, that.usuario) &&
               Objects.equals(dataEmprestimo, that.dataEmprestimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, usuario, dataEmprestimo);
    }
}