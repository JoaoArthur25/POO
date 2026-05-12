package treinoProvaLivraria.dados;

public abstract class Funcionario extends Pessoa{
    
    private String matricula;
    private double salariobase;

    public Funcionario(String matricula, String nome, String cpf, double salarioBase){
        super(nome, cpf);
        this.matricula = matricula;
        this.salariobase = salarioBase;
    }


    public Funcionario() {
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalariobase() {
        return salariobase;
    }

    public void setSalarioBase(double salarioBase){
        this.salariobase = salarioBase;
    }    

    protected abstract double calcularSalario();

    @Override
    public String toString() {
        return "Funcionario [matricula=" + matricula + ", salariobase=" + salariobase + ", getNome()=" + getNome()
                + ", getCpf()=" + getCpf() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        long temp;
        temp = Double.doubleToLongBits(salariobase);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Funcionario other = (Funcionario) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        if (Double.doubleToLongBits(salariobase) != Double.doubleToLongBits(other.salariobase))
            return false;
        return true;
    }
}
