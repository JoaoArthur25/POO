package ex2;

public class Animal {
    private String nome;
    private Dono dono;
    private String especie;
    private String descricao;

    public Animal(String nome, String especie, String descricao) {
        this.nome = nome;
        this.especie = especie;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animal: ").append(nome).append("\n");
        sb.append("Espécie: ").append(especie).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        if (dono != null) {
            sb.append(dono.toString()).append("\n");
        }
        return sb.toString();
    }
}