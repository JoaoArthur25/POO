package ap4.dados;

import java.util.ArrayList;

public class Aquario extends Viveiro {

    private float altura;
    private float temperatura;
    
    public Aquario(float altura, float temperatura) {
        super();
        this.animais = new ArrayList<>();
        this.altura = altura;
        this.temperatura = temperatura;
    }

    public Aquario(String nome, float comprimento, float largura, float altura, float temperatura) {
        super(nome, comprimento, largura);
        this.altura = altura;
        this.temperatura = temperatura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    

    @Override
    public float calculaEspaco(){
        return altura * super.calculaEspaco();
    }

    @Override
    public boolean adicionarAnimal(Animal animal){
        if (!(animal instanceof Peixe)) {
            return false; 
        }

        Peixe peixe = (Peixe) animal;

        if((espacoDisponivel() > (peixe.calculaEspacoOcupado() * 0.7)) &&
        this.temperatura > peixe.getTemperaturaIdeal() - 3 &&
        this.temperatura < peixe.getTemperaturaIdeal() + 3){
            
            animais.add(peixe);
            return true;
        } else {
            return false;
        }
}

    @Override
    public String toString() {
        return "Aquario [altura=" + altura + ", temperatura=" + temperatura + ", nome=" + nome + ", comprimento="
                + comprimento + ", largura=" + largura + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Float.floatToIntBits(altura);
        result = prime * result + Float.floatToIntBits(temperatura);
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
        Aquario other = (Aquario) obj;
        if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
            return false;
        if (Float.floatToIntBits(temperatura) != Float.floatToIntBits(other.temperatura))
            return false;
        return true;
    }



}
    

