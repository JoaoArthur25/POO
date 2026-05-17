package dados.atendimento;

import dados.catalogo.Servico;

import java.util.Date;

public class Garantia {

    private OrdemServico os;
    private Servico servico;
    private String descricaoPeca;
    private Date prazoFinal;
    private boolean semCusto;

    public Garantia(OrdemServico os, Servico servico, String descricaoPeca, Date prazoFinal) {
        this.os = os;
        this.servico = servico;
        this.descricaoPeca = descricaoPeca;
        this.prazoFinal = prazoFinal;
        this.semCusto = true;
    }

    public boolean estaEmGarantia() {
        return new Date().before(prazoFinal);
    }

    public OrdemServico getOs() { return os; }

    public Servico getServico() { return servico; }

    public String getDescricaoPeca() { return descricaoPeca; }
    public void setDescricaoPeca(String descricaoPeca) { this.descricaoPeca = descricaoPeca; }

    public Date getPrazoFinal() { return prazoFinal; }
    public void setPrazoFinal(Date prazoFinal) { this.prazoFinal = prazoFinal; }

    public boolean isSemCusto() { return semCusto; }
    public void setSemCusto(boolean semCusto) { this.semCusto = semCusto; }

    @Override
    public String toString() {
        return String.format("Garantia{os=%d, servico='%s', prazo=%s, emGarantia=%b}",
                os.getNumero(), servico != null ? servico.getDescricao() : descricaoPeca,
                prazoFinal, estaEmGarantia());
    }
}
