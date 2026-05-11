package ap5.negocio;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ap5.dados.Contato;

public class ListaTelefonica {
    private Map<Character, List<Contato>> contatos;

    public ListaTelefonica() {
        contatos = new HashMap<>();

        for(char chave = 'A'; chave <= 'Z'; chave++){
            contatos.put(chave, new LinkedList<>());
        }
    }

    public void adicionarContato(Contato contato){

        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        contatos.get(inicial).add(contato);
    }

    public void removerContato(Contato contato){

        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        contatos.get(inicial).remove(contato);
    }

    public List<Contato> buscarContatos(Character c){

        if(c >= 'A' && c <= 'Z'){
            return contatos.get(c);
        } else {
            return null;
        }
    }

    public Map<Character, List<Contato>>  buscarContatos(){
        return contatos;
    }
}