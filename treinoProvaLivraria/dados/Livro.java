package treinoProvaLivraria.dados;

public class Livro extends Produto{

    private String isbn;
    private String autor;

    public Livro(String codigo, int quantidade, double precoUnitario, String isbn, String autor ){
        super(quantidade, precoUnitario, autor, codigo);
        this.isbn = isbn;
        this.autor = autor;
    }

    public Livro() {
    }

    public double getSubtotal(){
        return getQuantidade()*getPrecoUnitario();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Livro [isbn=" + isbn + ", autor=" + autor + ", getCodigo()=" + getCodigo() + ", getSubtotal()="
                + getSubtotal() + ", getQuantidade()=" + getQuantidade() + ", getPrecoUnitario()=" + getPrecoUnitario()
                + ", getNome()=" + getNome() + "]";
    }


    
}
