package ap4.dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public Peixe(float temperaturaIdeal) {
        super();
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public Peixe(String nome, String cor, String especie, int idade, float largura, float comprimento, float altura,
            float temperaturaIdeal) {
        super(nome, cor, especie, idade, largura, comprimento, altura);
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }
    

    @Override
    public String toString() {
        return "Peixe [temperaturaIdeal=" + temperaturaIdeal + ", largura=" + largura + ", comprimento=" + comprimento
                + ", altura=" + altura + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Float.floatToIntBits(temperaturaIdeal);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Peixe other = (Peixe) obj;
        if (Float.floatToIntBits(temperaturaIdeal) != Float.floatToIntBits(other.temperaturaIdeal))
            return false;
        return true;
    }
}