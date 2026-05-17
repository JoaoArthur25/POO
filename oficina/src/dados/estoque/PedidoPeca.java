package dados.estoque;

import dados.catalogo.Peca;
import dados.enums.StatusPedido;

import java.util.Date;

public class PedidoPeca {

    private Peca peca;
    private Fornecedor fornecedor;
    private Date dataPedido;
    private Date previsaoEntrega;
    private StatusPedido status;
    private double valor;

    public PedidoPeca(Peca peca, Fornecedor fornecedor, Date previsaoEntrega, double valor) {
        this.peca = peca;
        this.fornecedor = fornecedor;
        this.dataPedido = new Date();
        this.previsaoEntrega = previsaoEntrega;
        this.valor = valor;
        this.status = StatusPedido.PENDENTE;
    }

    public void registrarEntrega() {
        this.status = StatusPedido.RECEBIDO;
    }

    public Peca getPeca() { return peca; }

    public Fornecedor getFornecedor() { return fornecedor; }

    public Date getDataPedido() { return dataPedido; }

    public Date getPrevisaoEntrega() { return previsaoEntrega; }
    public void setPrevisaoEntrega(Date previsaoEntrega) { this.previsaoEntrega = previsaoEntrega; }

    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return String.format("PedidoPeca{peca='%s', fornecedor='%s', status=%s, valor=%.2f}",
                peca.getDescricao(), fornecedor.getRazaoSocial(), status, valor);
    }
}
