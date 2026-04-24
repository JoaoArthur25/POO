package ex3;

import java.util.ArrayList;

public class Imobiliaria {
    private String nome;
    private ArrayList<Imovel> imoveis;

    public Imobiliaria(String nome) {
        this.nome = nome;
        this.imoveis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public void addImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public ArrayList<Imovel> filtrarImoveis(float x){

        ArrayList<Imovel> filtrados = new ArrayList<>();

        for(int i = 0; i < imoveis.size(); i++){

            Imovel imovel = imoveis.get(i);

            float area = imovel.calcularArea(imovel.getLargura(), imovel.getComprimento());

            if(area >= x){
                filtrados.add(imovel);
            }
        }

        for (int i = 0; i < filtrados.size() - 1; i++) {
            for (int j = 0; j < filtrados.size() - 1 - i; j++) {

                if (filtrados.get(j).getPreco() > filtrados.get(j + 1).getPreco()) {

                    Imovel aux = filtrados.get(j);
                    filtrados.set(j, filtrados.get(j + 1));
                    filtrados.set(j + 1, aux);
                }
            }
        }

        return filtrados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imobiliaria: ").append(nome).append("\n");

        for (Imovel imovel : imoveis) {
            sb.append(imovel).append("\n");
        }

        return sb.toString();
    }
}