package ap4.dados;

import java.util.ArrayList;
import java.util.List;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Animal> animais;

    public Viveiro() {
    }

    public Viveiro(String nome, float comprimento, float largura) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
        this.animais = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public boolean adicionarAnimal(Animal animal){
        
        if(espacoDisponivel() > (animal.calculaEspacoOcupado() * 0.7) && !(animal instanceof Peixe)){
            animais.add(animal);
            return true;
        } else {
            return false;
        }
    }

    public float calculaEspaco() {
        return largura * comprimento;
    }

    public float espacoOcupado() {
        float total = 0;

        for(Animal a : animais){
            total += a.calculaEspacoOcupado();
        }

        return total;
    }

    public float espacoDisponivel() {
        return (calculaEspaco() - espacoOcupado());
    }



    @Override
    public String toString() {
        return "Viveiro [nome=" + nome + ", comprimento=" + comprimento + ", largura=" + largura + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + Float.floatToIntBits(comprimento);
        result = prime * result + Float.floatToIntBits(largura);
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
        Viveiro other = (Viveiro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Float.floatToIntBits(comprimento) != Float.floatToIntBits(other.comprimento))
            return false;
        if (Float.floatToIntBits(largura) != Float.floatToIntBits(other.largura))
            return false;
        return true;
    }


}
