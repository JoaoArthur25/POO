package listaEx;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // ===== AUTORES =====
        Autor autor1 = new Autor("Machado de Assis", "Brasileiro");

        Autor autor2 = new Autor();
        autor2.setNome("George Orwell");
        autor2.setNacionalidade("Britânico");

        System.out.println("=== AUTORES ===");
        System.out.println(autor1);
        System.out.println(autor2);


        // ===== LIVROS =====
        Livro livro1 = new Livro("Dom Casmurro", autor1, "111", 1899);
        Livro livro2 = new Livro("Memórias Póstumas", autor1, "222", 1881);

        Livro livro3 = new Livro();
        livro3.setTitulo("1984");
        livro3.setAutor(autor2);
        livro3.setIsbn("333");
        livro3.setAnoPublicacao(1949);

        System.out.println("\n=== LIVROS ===");
        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);

        System.out.println("\nLivros de " + autor1.getNome() + ":");
        System.out.println(autor1.getLivros());

        Usuario usuario1 = new Usuario("João", 1, "9999-1111");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Maria");
        usuario2.setId(2);
        usuario2.setTelefone("8888-2222");

        System.out.println("\n=== USUÁRIOS ===");
        System.out.println(usuario1);
        System.out.println(usuario2);

        Funcionario funcionario1 = new Funcionario("Carlos", 10, "02312321123");

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Ana");
        funcionario2.setId(20);

        System.out.println("\n=== FUNCIONÁRIOS ===");
        System.out.println(funcionario1);
        System.out.println(funcionario2);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        biblioteca.cadastrarUsuario(usuario1);
        biblioteca.cadastrarUsuario(usuario2);

        Emprestimo emp1 = biblioteca.realizarEmprestimo(livro1, usuario1);

        Emprestimo emp2 = new Emprestimo(
                livro3,
                usuario2,
                LocalDate.now(),
                LocalDate.now().plusDays(10)
        );

        System.out.println("\n=== EMPRÉSTIMOS ===");
        System.out.println(emp1);
        System.out.println(emp2);

        System.out.println("\n=== CONSULTAS ===");
        System.out.println("Nome do usuário1: " + usuario1.getNome());
        System.out.println("Título do livro3: " + livro3.getTitulo());
        System.out.println("Autor do livro1: " + livro1.getAutor().getNome());

        usuario1.setNome("João Silva");
        livro1.setTitulo("Dom Casmurro (Edição Revisada)");

        System.out.println("\n=== APÓS ALTERAÇÕES ===");
        System.out.println(usuario1);
        System.out.println(livro1);
    }
}