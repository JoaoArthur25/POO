package ex1;

public class Vaca extends Animal {

    public Vaca(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return nome + ": Muuu";
    }
}
