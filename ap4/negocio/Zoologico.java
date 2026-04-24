package ap4.negocio;

import java.util.ArrayList;
import java.util.List;

import ap4.dados.Animal;
import ap4.dados.Viveiro;
import ap4.dados.Aquario;

public class Zoologico {
    private List<Animal> animais;
    private List<Viveiro> viveiros;

    public Zoologico() {
        this.animais = new ArrayList<>();
        this.viveiros = new ArrayList<>();
    }

    public void cadastrarViveiro(Viveiro viveiro){
        viveiros.add(viveiro);
    }

    public void cadastrarAnimal(Animal animal){
        animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro){
        return viveiro.adicionarAnimal(animal);
    }

    public List<Aquario> getSoAquarios(){
        List<Aquario> listaAquarios = new ArrayList<>();

        for (Viveiro v : viveiros) {
            if (v instanceof Aquario) {
                listaAquarios.add((Aquario) v);
            }
        }

        return listaAquarios;
    }

    public List<Viveiro> getSoViveiros(){
        List<Viveiro> listaViveiros = new ArrayList<>();

        for(Viveiro v : viveiros){
            if(!(v instanceof Aquario)){
                listaViveiros.add(v);
            }
        }

        return listaViveiros;
    }

    public List<Viveiro> getViveiros() {
        return viveiros;
    }

    public List<Animal> getAnimais() {
        return animais;
    }
}