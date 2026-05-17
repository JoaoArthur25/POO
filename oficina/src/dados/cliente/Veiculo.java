package dados.cliente;

public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private String cor;
    private String chassi;
    private int quilometragem;
    private String observacoes;
    private Cliente proprietario;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao,
                   String cor, String chassi, int quilometragem, Cliente proprietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.chassi = chassi;
        this.quilometragem = quilometragem;
        this.proprietario = proprietario;
        this.observacoes = "";
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getChassi() { return chassi; }
    public void setChassi(String chassi) { this.chassi = chassi; }

    public int getQuilometragem() { return quilometragem; }
    public void setQuilometragem(int quilometragem) { this.quilometragem = quilometragem; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Cliente getProprietario() { return proprietario; }
    public void setProprietario(Cliente proprietario) { this.proprietario = proprietario; }

    @Override
    public String toString() {
        return String.format("Veiculo{placa='%s', marca='%s', modelo='%s', ano=%d, cor='%s'}",
                placa, marca, modelo, anoFabricacao, cor);
    }
}
