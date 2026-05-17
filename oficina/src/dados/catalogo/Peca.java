package dados.catalogo;

public class Peca {

    private String codigo;
    private String descricao;
    private String fabricante;
    private String codigoFabricante;
    private String compatibilidade;
    private int estoqueAtual;
    private int estoqueMinimo;
    private double precoCusto;
    private double precoVenda;
    private int garantiaDias;

    public Peca(String codigo, String descricao, String fabricante, String codigoFabricante,
                String compatibilidade, int estoqueAtual, int estoqueMinimo,
                double precoCusto, double precoVenda, int garantiaDias) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.codigoFabricante = codigoFabricante;
        this.compatibilidade = compatibilidade;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.garantiaDias = garantiaDias;
    }

    public boolean estoqueBaixo() {
        return estoqueAtual <= estoqueMinimo;
    }

    public void adicionarEstoque(int quantidade) {
        this.estoqueAtual += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade > estoqueAtual) return false;
        this.estoqueAtual -= quantidade;
        return true;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getCodigoFabricante() { return codigoFabricante; }
    public void setCodigoFabricante(String codigoFabricante) { this.codigoFabricante = codigoFabricante; }

    public String getCompatibilidade() { return compatibilidade; }
    public void setCompatibilidade(String compatibilidade) { this.compatibilidade = compatibilidade; }

    public int getEstoqueAtual() { return estoqueAtual; }
    public void setEstoqueAtual(int estoqueAtual) { this.estoqueAtual = estoqueAtual; }

    public int getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(int estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }

    public double getPrecoCusto() { return precoCusto; }
    public void setPrecoCusto(double precoCusto) { this.precoCusto = precoCusto; }

    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }

    public int getGarantiaDias() { return garantiaDias; }
    public void setGarantiaDias(int garantiaDias) { this.garantiaDias = garantiaDias; }

    @Override
    public String toString() {
        return String.format("Peca{codigo='%s', descricao='%s', estoque=%d, precoVenda=%.2f}",
                codigo, descricao, estoqueAtual, precoVenda);
    }
}
