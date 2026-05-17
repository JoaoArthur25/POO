package dados.estoque;

public class Fornecedor {

    private String cnpj;
    private String razaoSocial;
    private String telefone;
    private String email;
    private String endereco;
    private String condicoesPagamento;

    public Fornecedor(String cnpj, String razaoSocial, String telefone,
                      String email, String endereco, String condicoesPagamento) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.condicoesPagamento = condicoesPagamento;
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCondicoesPagamento() { return condicoesPagamento; }
    public void setCondicoesPagamento(String condicoesPagamento) { this.condicoesPagamento = condicoesPagamento; }

    @Override
    public String toString() {
        return String.format("Fornecedor{cnpj='%s', razaoSocial='%s', telefone='%s'}",
                cnpj, razaoSocial, telefone);
    }
}
