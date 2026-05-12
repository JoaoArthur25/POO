package treinoProvaLivraria.dados;

public abstract class Produto {
    private String codigo;
    private int quantidade;
    private double precoUnitario;
    private String nome;

    public Produto(int quantidade, double precoUnitario, String nome, String codigo) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.nome = nome;
        this.codigo = codigo;
    }

    public Produto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public abstract double getSubtotal();

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto [produto="  + ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario
                + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + quantidade;
        long temp;
        temp = Double.doubleToLongBits(precoUnitario);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (quantidade != other.quantidade)
            return false;
        if (Double.doubleToLongBits(precoUnitario) != Double.doubleToLongBits(other.precoUnitario))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

   
}
