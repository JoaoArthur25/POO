package dados.financeiro;

import dados.atendimento.ItemPeca;
import dados.atendimento.ItemServico;
import dados.atendimento.OrdemServico;

import java.util.Date;

public class Orcamento {

    private OrdemServico os;
    private double subtotalPecas;
    private double subtotalMaoObra;
    private double desconto;
    private double total;
    private Date data;

    public Orcamento(OrdemServico os, double subtotalPecas, double subtotalMaoObra, double desconto) {
        this.os = os;
        this.subtotalPecas = subtotalPecas;
        this.subtotalMaoObra = subtotalMaoObra;
        this.desconto = desconto;
        this.data = new Date();
        this.total = subtotalPecas + subtotalMaoObra - desconto;
    }

    public void gerar() {
        this.total = subtotalPecas + subtotalMaoObra - desconto;

        System.out.println("=== ORCAMENTO OS #" + os.getNumero() + " ===");
        System.out.println("Veiculo : " + os.getVeiculo().getPlaca()
                + " | " + os.getVeiculo().getMarca()
                + " " + os.getVeiculo().getModelo());
        System.out.println("Cliente : " + os.getVeiculo().getProprietario().getNome());
        System.out.println("Data    : " + data);

        System.out.println("\n--- Servicos executados ---");
        double totalComissoes = 0;
        for (ItemServico is : os.getItensServico()) {
            System.out.printf("  %-35s qtd=%-2d  R$ %7.2f  (comissao %s: R$ %.2f)%n",
                    is.getServico().getDescricao(),
                    is.getQuantidade(),
                    is.getSubtotal(),
                    is.getMecanicoExecutor().getNome(),
                    is.calcularComissao());
            totalComissoes += is.calcularComissao();
        }

        System.out.println("\n--- Pecas utilizadas ---");
        for (ItemPeca ip : os.getItensPeca()) {
            System.out.printf("  %-35s qtd=%-2d  unit=R$ %6.2f  total=R$ %7.2f%n",
                    ip.getPeca().getDescricao(),
                    ip.getQuantidade(),
                    ip.getValorUnitario(),
                    ip.getValorTotal());
        }

        System.out.println();
        System.out.printf("Subtotal pecas    : R$ %8.2f%n", subtotalPecas);
        System.out.printf("Subtotal mao obra : R$ %8.2f%n", subtotalMaoObra);
        System.out.printf("Desconto          : R$ %8.2f%n", desconto);
        System.out.printf("TOTAL             : R$ %8.2f%n", total);
        System.out.printf("Total comissoes   : R$ %8.2f%n", totalComissoes);
    }

    public void aplicarDesconto(double desconto) {
        this.desconto = desconto;
        this.total = subtotalPecas + subtotalMaoObra - desconto;
    }

    public OrdemServico getOs() { return os; }

    public double getSubtotalPecas() { return subtotalPecas; }
    public void setSubtotalPecas(double subtotalPecas) { this.subtotalPecas = subtotalPecas; }

    public double getSubtotalMaoObra() { return subtotalMaoObra; }
    public void setSubtotalMaoObra(double subtotalMaoObra) { this.subtotalMaoObra = subtotalMaoObra; }

    public double getDesconto() { return desconto; }
    public void setDesconto(double desconto) { this.desconto = desconto; }

    public double getTotal() { return total; }

    public Date getData() { return data; }

    @Override
    public String toString() {
        return String.format("Orcamento{os=%d, pecas=%.2f, maoObra=%.2f, desconto=%.2f, total=%.2f}",
                os.getNumero(), subtotalPecas, subtotalMaoObra, desconto, total);
    }
}
