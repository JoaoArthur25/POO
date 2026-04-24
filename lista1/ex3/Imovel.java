package ex3;

public class Imovel {
    private float largura;
    private float comprimento;
    private float preco;
    
    public Imovel(float largura, float comprimento, float preco) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.preco = preco;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float calcularArea(float largura, float comprimento){
        return (largura*comprimento);
    }

    @Override
    public String toString() {
        return "Imovel [largura=" + largura + ", comprimento=" + comprimento + ", preco=" + preco + "]";
    }
    
}
