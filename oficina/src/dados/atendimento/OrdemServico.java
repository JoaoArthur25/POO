package dados.atendimento;

import dados.cliente.Mecanico;
import dados.cliente.Veiculo;
import dados.enums.StatusOS;
import dados.financeiro.Orcamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServico {

    private int numero;
    private Date entrada;
    private Date saida;
    private Veiculo veiculo;
    private int kmEntrada;
    private String problema;
    private Mecanico mecanico;
    private StatusOS status;
    private Date previsaoConclusao;
    private List<ItemServico> itensServico;
    private List<ItemPeca> itensPeca;

    public OrdemServico(int numero, Veiculo veiculo, int kmEntrada,
                        String problema, Mecanico mecanico, Date previsaoConclusao) {
        this.numero = numero;
        this.veiculo = veiculo;
        this.kmEntrada = kmEntrada;
        this.problema = problema;
        this.mecanico = mecanico;
        this.previsaoConclusao = previsaoConclusao;
        this.entrada = new Date();
        this.status = StatusOS.EM_EXECUCAO;
        this.itensServico = new ArrayList<>();
        this.itensPeca = new ArrayList<>();
    }

    public void adicionarItemServico(ItemServico item) {
        this.itensServico.add(item);
    }

    public void adicionarItemPeca(ItemPeca item) {
        this.itensPeca.add(item);
    }

    public double calcularTotal() {
        double totalServicos = itensServico.stream()
                .mapToDouble(ItemServico::getSubtotal)
                .sum();
        double totalPecas = itensPeca.stream()
                .mapToDouble(ItemPeca::getValorTotal)
                .sum();
        return totalServicos + totalPecas;
    }

    public Orcamento concluir() {
        this.status = StatusOS.CONCLUIDA;
        this.saida = new Date();

        double subtotalServicos = itensServico.stream()
                .mapToDouble(ItemServico::getSubtotal).sum();
        double subtotalPecas = itensPeca.stream()
                .mapToDouble(ItemPeca::getValorTotal).sum();

        return new Orcamento(this, subtotalPecas, subtotalServicos, 0.0);
    }

    public int getNumero() { return numero; }

    public Date getEntrada() { return entrada; }

    public Date getSaida() { return saida; }
    public void setSaida(Date saida) { this.saida = saida; }

    public Veiculo getVeiculo() { return veiculo; }

    public int getKmEntrada() { return kmEntrada; }

    public String getProblema() { return problema; }
    public void setProblema(String problema) { this.problema = problema; }

    public Mecanico getMecanico() { return mecanico; }
    public void setMecanico(Mecanico mecanico) { this.mecanico = mecanico; }

    public StatusOS getStatus() { return status; }
    public void setStatus(StatusOS status) { this.status = status; }

    public Date getPrevisaoConclusao() { return previsaoConclusao; }
    public void setPrevisaoConclusao(Date previsaoConclusao) { this.previsaoConclusao = previsaoConclusao; }

    public List<ItemServico> getItensServico() { return itensServico; }
    public List<ItemPeca> getItensPeca() { return itensPeca; }

    @Override
    public String toString() {
        return String.format("OrdemServico{numero=%d, veiculo='%s', status=%s, total=%.2f}",
                numero, veiculo.getPlaca(), status, calcularTotal());
    }
}
