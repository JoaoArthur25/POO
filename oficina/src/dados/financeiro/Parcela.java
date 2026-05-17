package dados.financeiro;

import java.util.Date;

public class Parcela {

    private int numero;
    private double valor;
    private Date vencimento;
    private Date dataRecebimento;
    private String status; 

    public Parcela(int numero, double valor, Date vencimento) {
        this.numero = numero;
        this.valor = valor;
        this.vencimento = vencimento;
        this.status = "PENDENTE";
    }

    public void registrarRecebimento() {
        this.dataRecebimento = new Date();
        this.status = "RECEBIDO";
    }

    public boolean isAtrasada() {
        return status.equals("PENDENTE") && new Date().after(vencimento);
    }

    public int getNumero() { return numero; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Date getVencimento() { return vencimento; }
    public void setVencimento(Date vencimento) { this.vencimento = vencimento; }

    public Date getDataRecebimento() { return dataRecebimento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("Parcela{num=%d, valor=%.2f, vencimento=%s, status='%s'}",
                numero, valor, vencimento, status);
    }
}
