package ap4.dados;

public class Animal {
    private String nome;
    private String cor;
    private String especie;
    private int idade;
    protected float largura;
    protected float comprimento;
    protected float altura;

    public Animal() {
    }

    public Animal(String nome, String cor, String especie, int idade, float largura, float comprimento, float altura) {
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.idade = idade;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculaEspacoOcupado() {
        return (altura * comprimento * largura);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        result = prime * result + ((especie == null) ? 0 : especie.hashCode());
        result = prime * result + idade;
        result = prime * result + Float.floatToIntBits(largura);
        result = prime * result + Float.floatToIntBits(comprimento);
        result = prime * result + Float.floatToIntBits(altura);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        if (especie == null) {
            if (other.especie != null)
                return false;
        } else if (!especie.equals(other.especie))
            return false;
        if (idade != other.idade)
            return false;
        if (Float.floatToIntBits(largura) != Float.floatToIntBits(other.largura))
            return false;
        if (Float.floatToIntBits(comprimento) != Float.floatToIntBits(other.comprimento))
            return false;
        if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Animal [nome=" + nome + ", cor=" + cor + ", especie=" + especie + ", idade=" + idade + ", largura="
                + largura + ", comprimento=" + comprimento + ", altura=" + altura + "]";
    }

}
