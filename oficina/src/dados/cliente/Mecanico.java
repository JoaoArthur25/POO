package dados.cliente;

import dados.enums.Especialidade;
import java.util.Date;

public class Mecanico {

    private String nome;
    private String cpf;
    private Date dataAdmissao;
    private Especialidade especialidade;
    private double comissaoPct;

    public Mecanico(String nome, String cpf, Date dataAdmissao,
                    Especialidade especialidade, double comissaoPct) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.especialidade = especialidade;
        this.comissaoPct = comissaoPct;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Date getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(Date dataAdmissao) { this.dataAdmissao = dataAdmissao; }

    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }

    public double getComissaoPct() { return comissaoPct; }
    public void setComissaoPct(double comissaoPct) { this.comissaoPct = comissaoPct; }

    @Override
    public String toString() {
        return String.format("Mecanico{nome='%s', cpf='%s', especialidade=%s, comissao=%.1f%%}",
                nome, cpf, especialidade, comissaoPct);
    }
}
