package ex1;

public class MainAnimal {
    public static void main(String[] args) {
        Cao cao1 = new Cao("Rex");
        Cao cao2 = new Cao("Bolt");

        Gato gato1 = new Gato("Whiskers");
        Gato gato2 = new Gato("Felix");

        Vaca vaca1 = new Vaca("Mimosa");
        Vaca vaca2 = new Vaca("Estrela");

        Animal[] animais = {cao1, cao2, gato1, gato2, vaca1, vaca2};

        for (Animal a : animais) {
            System.out.println(a.emitirSom());
        }
    }
}
