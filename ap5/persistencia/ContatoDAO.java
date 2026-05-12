package ap5.persistencia;

import java.util.List;

import ap5.dados.Contato;

public class ContatoDAO {
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();

    public void insert(Contato contato){
        arquivoContatoDAO.salvaContatoArquivo(contato);
    }

    public void delete(Contato contato){
        List<Contato> contatos = arquivoContatoDAO.leContatosArquivo();
        contatos.remove(contato);
        arquivoContatoDAO.salvaContatosArquivo(contatos);
    }

    public List<Contato> getAll(){
        return arquivoContatoDAO.leContatosArquivo();
    }
}
