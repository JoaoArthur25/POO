package ap5.persistencia;

import java.util.LinkedList;
import java.util.List;

import ap5.dados.Contato;

public class ArquivoContatoDAO {
    private final String caminho = "../files/contatos.csv";
    private static EditorTexto arquivo = new EditorTexto();

    private String toCSV(Contato contato){
        String c = "";

        c+= contato.getNome() + ",";
        c+= contato.getTelefone() + ",";

        return c;
    }

    private Contato fromCSV(String linhaCSV){
        String[] atributos = linhaCSV.split(",");

        Contato contato = new Contato();
        contato.setNome(atributos[0]);
        contato.setTelefone(atributos[1]);

        return contato;
    }

    private List<String> listaContatoToString(List<Contato> contatos){
        List<String> arquivo = new LinkedList<>();

        for(Contato c : contatos){
            arquivo.add(toCSV(c));
        }

        return arquivo;
    }

    private List<Contato> stringToListContato(List<String> arquivo){
        List<Contato> contatos = new LinkedList<Contato>();

        for(String linha : arquivo){
            contatos.add(fromCSV(linha));
        }

        return contatos;
    }

    public List<Contato> leContatosArquivo(){
        return stringToListContato(arquivo.lerArquivo(caminho));
    }

    public void salvaContatosArquivo(List<Contato> contatos){
        arquivo.gravaTexto(caminho, listaContatoToString(contatos));
    }

    public void salvaContatoArquivo(Contato contato){
        arquivo.gravaTexto(caminho, toCSV(contato));
    }
}
