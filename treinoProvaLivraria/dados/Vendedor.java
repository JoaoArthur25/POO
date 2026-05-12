package treinoProvaLivraria.dados;

public class Vendedor extends Funcionario {
    private double comissaoPercent;
    private int totalVendido;

    public Vendedor(String nome, String cpf, String matricula, double salarioBase, double comissaoPercent, int totalVendido){
        super(matricula, nome, cpf, salarioBase);
        this.totalVendido = totalVendido;
        this.comissaoPercent = comissaoPercent;
    }

    public Vendedor() {
    }

    public double calcularSalario(){
        return (totalVendido * comissaoPercent) + getSalariobase();
    }

    public double getComissaoPercent() {
        return comissaoPercent;
    }

    public void setComissaoPercent(double comissaoPercent) {
        this.comissaoPercent = comissaoPercent;
    }

    public int getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(int totalVendido) {
        this.totalVendido = totalVendido;
    }

    @Override
    public String toString() {
        return "Vendedor [comissaoPercent=" + comissaoPercent + ", totalVendido=" + totalVendido + ", getNome()="
                + getNome() + ", getCpf()=" + getCpf() + ", getMatricula()=" + getMatricula() + ", getSalariobase()="
                + getSalariobase() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(comissaoPercent);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalVendido);
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
        Vendedor other = (Vendedor) obj;
        if (Double.doubleToLongBits(comissaoPercent) != Double.doubleToLongBits(other.comissaoPercent))
            return false;
        if (Double.doubleToLongBits(totalVendido) != Double.doubleToLongBits(other.totalVendido))
            return false;
        return true;
    }


}
