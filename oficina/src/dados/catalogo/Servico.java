package dados.catalogo;

public class Servico {

    private String codigo;
    private String descricao;
    private String categoria;
    private int tempoMedioMin;
    private double valorMaoObra;
    private int garantiaDias;

    public Servico(String codigo, String descricao, String categoria,
                   int tempoMedioMin, double valorMaoObra, int garantiaDias) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tempoMedioMin = tempoMedioMin;
        this.valorMaoObra = valorMaoObra;
        this.garantiaDias = garantiaDias;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getTempoMedioMin() { return tempoMedioMin; }
    public void setTempoMedioMin(int tempoMedioMin) { this.tempoMedioMin = tempoMedioMin; }

    public double getValorMaoObra() { return valorMaoObra; }
    public void setValorMaoObra(double valorMaoObra) { this.valorMaoObra = valorMaoObra; }

    public int getGarantiaDias() { return garantiaDias; }
    public void setGarantiaDias(int garantiaDias) { this.garantiaDias = garantiaDias; }

    @Override
    public String toString() {
        return String.format("Servico{codigo='%s', descricao='%s', categoria='%s', valorMaoObra=%.2f}",
                codigo, descricao, categoria, valorMaoObra);
    }
}
