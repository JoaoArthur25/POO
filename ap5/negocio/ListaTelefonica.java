package ap5.negocio;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ap5.dados.Contato;
import ap5.persistencia.ContatoDAO;

public class ListaTelefonica {
    private ContatoDAO contatoDAO = new ContatoDAO();

    public ListaTelefonica() {
    }

    public void adicionarContato(Contato contato) {
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));

        if (inicial >= 'A' && inicial <= 'Z') {
            contatoDAO.insert(contato);
        }
    }

    public void removerContato(Contato contato) {
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));

        if (inicial >= 'A' && inicial <= 'Z') {
            contatoDAO.delete(contato);
        }
    }

    public List<Contato> buscarContatos(Character c) {
        char inicial = Character.toUpperCase(c);

        if (inicial >= 'A' && inicial <= 'Z') {
            List<Contato> resultado = new LinkedList<>();

            for (Contato contato : contatoDAO.getAll()) {
                char primeiraLetra = Character.toUpperCase(contato.getNome().charAt(0));
                if (primeiraLetra == inicial) {
                    resultado.add(contato);
                }
            }

            return resultado;
        } else {
            return null;
        }
    }

    public Map<Character, List<Contato>> buscarContatos() {
        Map<Character, List<Contato>> mapa = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            mapa.put(c, new LinkedList<>());
        }

        for (Contato contato : contatoDAO.getAll()) {
            char inicial = Character.toUpperCase(contato.getNome().charAt(0));
            if (inicial >= 'A' && inicial <= 'Z') {
                mapa.get(inicial).add(contato);
            }
        }

        return mapa;
    }
}