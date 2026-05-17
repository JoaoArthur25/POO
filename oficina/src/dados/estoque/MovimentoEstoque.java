package dados.estoque;

import dados.catalogo.Peca;
import dados.enums.TipoMovimento;

import java.util.Date;

public class MovimentoEstoque {

    private Peca peca;
    private TipoMovimento tipo;
    private int quantidade;
    private Date dataHora;
    private double valorUnitario;
    private Fornecedor fornecedor;
    private PedidoPeca pedido;

    public MovimentoEstoque(Peca peca, TipoMovimento tipo, int quantidade,
                            double valorUnitario, Fornecedor fornecedor, PedidoPeca pedido) {
        this.peca = peca;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.fornecedor = fornecedor;
        this.pedido = pedido;
        this.dataHora = new Date();
    }

    public Peca getPeca() { return peca; }
    public TipoMovimento getTipo() { return tipo; }
    public int getQuantidade() { return quantidade; }
    public Date getDataHora() { return dataHora; }
    public double getValorUnitario() { return valorUnitario; }
    public Fornecedor getFornecedor() { return fornecedor; }
    public PedidoPeca getPedido() { return pedido; }

    @Override
    public String toString() {
        return String.format("MovimentoEstoque{peca='%s', tipo=%s, qtd=%d, valor=%.2f, data=%s}",
                peca.getDescricao(), tipo, quantidade, valorUnitario, dataHora);
    }
}
