package dados.cliente;

import dados.atendimento.OrdemServico;
import dados.enums.TipoCliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpfCnpj;
    private TipoCliente tipo;
    private String endereco;
    private String email;
    private List<String> telefones;
    private List<Veiculo> veiculos;
    private List<OrdemServico> historicoOS;

    public Cliente(String nome, String cpfCnpj, TipoCliente tipo, String endereco, String email) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
        this.endereco = endereco;
        this.email = email;
        this.telefones = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.historicoOS = new ArrayList<>();
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void adicionarOS(OrdemServico os) {
        this.historicoOS.add(os);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }

    public TipoCliente getTipo() { return tipo; }
    public void setTipo(TipoCliente tipo) { this.tipo = tipo; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getTelefones() { return telefones; }
    public List<Veiculo> getVeiculos() { return veiculos; }
    public List<OrdemServico> getHistoricoOS() { return historicoOS; }

    @Override
    public String toString() {
        return String.format("Cliente{nome='%s', cpfCnpj='%s', tipo=%s, email='%s'}",
                nome, cpfCnpj, tipo, email);
    }
}
