package treinoProvaLivraria.dados;

public class Ebook extends Produto{

    private String isbn;
    private String autor;
    private String formato;
    private int tamanhoMB;
    private double descontoPercent;

    public Ebook(String codigo, double descontoPercent, int quantidade, double precoUnitario, String isbn, String autor, String formato, int tamanhoMB){
        super(quantidade, precoUnitario, autor, formato);
        this.isbn = isbn;
        this.autor = autor;
        this.formato = formato;
        this.tamanhoMB = tamanhoMB;
        this.descontoPercent = descontoPercent;
    }
    public Ebook() {
    }
    public double getSubtotal(){
        return getPrecoUnitario()*getQuantidade()*(1-descontoPercent);
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
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public int getTamanhoMB() {
        return tamanhoMB;
    }
    public void setTamanhoMB(int tamanhoMB) {
        this.tamanhoMB = tamanhoMB;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((formato == null) ? 0 : formato.hashCode());
        result = prime * result + tamanhoMB;
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
        Ebook other = (Ebook) obj;
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
        if (formato == null) {
            if (other.formato != null)
                return false;
        } else if (!formato.equals(other.formato))
            return false;
        if (tamanhoMB != other.tamanhoMB)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Ebook [isbn=" + isbn + ", autor=" + autor + ", formato=" + formato + ", tamanhoMB=" + tamanhoMB
                + ", getCodigo()=" + getCodigo() + ", getQuantidade()=" + getQuantidade() + ", getPrecoUnitario()="
                + getPrecoUnitario() + ", getNome()=" + getNome() + "]";
    }
    
}
