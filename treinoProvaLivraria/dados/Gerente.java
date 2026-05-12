package treinoProvaLivraria.dados;

public class Gerente extends Funcionario{

    private double bonus;

    public Gerente(double bonus, String nome, String cpf, String matricula, double salariobase){
        super(nome, cpf, matricula, salariobase);
        this.bonus = bonus;
    }

    public Gerente() {
    }

    @Override
    public double calcularSalario(){
        return getSalariobase() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Gerente [bonus=" + bonus + ", getMatricula()=" + getMatricula() + ", getNome()=" + getNome()
                + ", getCpf()=" + getCpf() + ", getSalariobase()=" + getSalariobase() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(bonus);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Gerente other = (Gerente) obj;
        if (Double.doubleToLongBits(bonus) != Double.doubleToLongBits(other.bonus))
            return false;
        return true;
    }
    
}
