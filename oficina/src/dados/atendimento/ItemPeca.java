package dados.atendimento;

import dados.catalogo.Peca;

public class ItemPeca {

    private Peca peca;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;

    public ItemPeca(Peca peca, int quantidade, double valorUnitario) {
        this.peca = peca;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorUnitario * quantidade;
    }

    public Peca getPeca() { return peca; }
    public void setPeca(Peca peca) { this.peca = peca; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = this.valorUnitario * quantidade;
    }

    public double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorUnitario * this.quantidade;
    }

    public double getValorTotal() { return valorTotal; }

    @Override
    public String toString() {
        return String.format("ItemPeca{peca='%s', qtd=%d, valorUnitario=%.2f, total=%.2f}",
                peca.getDescricao(), quantidade, valorUnitario, valorTotal);
    }
}
