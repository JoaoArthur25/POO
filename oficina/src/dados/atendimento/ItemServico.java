package dados.atendimento;

import dados.catalogo.Servico;
import dados.cliente.Mecanico;

public class ItemServico {

    private Servico servico;
    private int quantidade;
    private double valorCobrado;
    private Mecanico mecanicoExecutor;

    public ItemServico(Servico servico, int quantidade, double valorCobrado, Mecanico mecanicoExecutor) {
        this.servico = servico;
        this.quantidade = quantidade;
        this.valorCobrado = valorCobrado;
        this.mecanicoExecutor = mecanicoExecutor;
    }

    public double getSubtotal() {
        return valorCobrado * quantidade;
    }

    public double calcularComissao() {
        return getSubtotal() * (mecanicoExecutor.getComissaoPct() / 100.0);
    }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorCobrado() { return valorCobrado; }
    public void setValorCobrado(double valorCobrado) { this.valorCobrado = valorCobrado; }

    public Mecanico getMecanicoExecutor() { return mecanicoExecutor; }
    public void setMecanicoExecutor(Mecanico mecanicoExecutor) { this.mecanicoExecutor = mecanicoExecutor; }

    @Override
    public String toString() {
        return String.format("ItemServico{servico='%s', qtd=%d, valorCobrado=%.2f, mecanico='%s', comissao=%.2f}",
                servico.getDescricao(), quantidade, valorCobrado,
                mecanicoExecutor.getNome(), calcularComissao());
    }
}
