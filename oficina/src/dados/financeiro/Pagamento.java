package dados.financeiro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pagamento {

    private Orcamento orcamento;
    private String formaPagamento;
    private int numParcelas;
    private double valorParcela;
    private List<Parcela> parcelas;

    public Pagamento(Orcamento orcamento, String formaPagamento,
                     int numParcelas, Date vencimentoPrimeira) {
        this.orcamento = orcamento;
        this.formaPagamento = formaPagamento;
        this.numParcelas = numParcelas;
        this.valorParcela = orcamento.getTotal() / numParcelas;
        this.parcelas = new ArrayList<>();
        gerarParcelas(vencimentoPrimeira);
    }

    private void gerarParcelas(Date vencimentoPrimeira) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(vencimentoPrimeira);
        for (int i = 1; i <= numParcelas; i++) {
            parcelas.add(new Parcela(i, valorParcela, cal.getTime()));
            cal.add(Calendar.MONTH, 1);
        }
    }

    public void registrarRecebimento(int numeroParcela) {
        parcelas.stream()
                .filter(p -> p.getNumero() == numeroParcela)
                .findFirst()
                .ifPresent(Parcela::registrarRecebimento);
    }

    public long totalParcelasRecebidas() {
        return parcelas.stream().filter(p -> p.getStatus().equals("RECEBIDO")).count();
    }

    public long totalParcelasAtrasadas() {
        return parcelas.stream().filter(Parcela::isAtrasada).count();
    }

    public double totalRecebido() {
        return parcelas.stream()
                .filter(p -> p.getStatus().equals("RECEBIDO"))
                .mapToDouble(Parcela::getValor)
                .sum();
    }

    public Orcamento getOrcamento() { return orcamento; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public int getNumParcelas() { return numParcelas; }

    public double getValorParcela() { return valorParcela; }

    public List<Parcela> getParcelas() { return parcelas; }

    @Override
    public String toString() {
        return String.format(
                "Pagamento{forma='%s', parcelas=%d, valorParcela=%.2f, recebidas=%d/%d}",
                formaPagamento, numParcelas, valorParcela,
                totalParcelasRecebidas(), numParcelas);
    }
}
