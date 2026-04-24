package ex4;

public class Sorteador {
    private Pessoa[] pessoas = new Pessoa[5];

    public Sorteador() {
        pessoas[0] = new Pessoa("João", 30, "123.456.789-00");
        pessoas[1] = new Pessoa("Maria", 25, "987.654.321-00");
        pessoas[2] = new Pessoa("Pedro", 40, "111.222.333-44");
        pessoas[3] = new Pessoa("Ana", 35, "555.666.777-88");
        pessoas[4] = new Pessoa("Carlos", 28, "999.888.777-66");
    }

    public Pessoa sortearProximo(){
        int indice = (int) (Math.random() * pessoas.length);
        Pessoa sorteada = pessoas[indice];

        pessoas[indice] = null;
        
        return sorteada;  
    }
}
