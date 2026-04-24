package ex1e2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Emprestimo realizarEmprestimo(Livro livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            Emprestimo e = new Emprestimo(
                    livro,
                    usuario,
                    java.time.LocalDate.now(),
                    java.time.LocalDate.now().plusDays(7)
            );
            emprestimos.add(e);
            usuario.adicionarEmprestimo(e);
            return e;
        }
        return null;
    }
}