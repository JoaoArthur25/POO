package negocio;

import dados.atendimento.*;
import dados.catalogo.*;
import dados.cliente.*;
import dados.enums.*;
import dados.estoque.*;
import dados.financeiro.*;

import java.util.*;
import java.util.stream.Collectors;

public class Sistema {

    private List<Cliente> clientes;
    private List<Veiculo> veiculos;
    private List<Mecanico> mecanicos;
    private List<Servico> servicos;
    private List<Peca> pecas;
    private List<OrdemServico> ordensServico;
    private List<Fornecedor> fornecedores;
    private List<PedidoPeca> pedidos;
    private List<MovimentoEstoque> movimentos;

    private int proximoNumeroOS = 1;

    public Sistema() {
        this.clientes      = new ArrayList<>();
        this.veiculos      = new ArrayList<>();
        this.mecanicos     = new ArrayList<>();
        this.servicos      = new ArrayList<>();
        this.pecas         = new ArrayList<>();
        this.ordensServico = new ArrayList<>();
        this.fornecedores  = new ArrayList<>();
        this.pedidos       = new ArrayList<>();
        this.movimentos    = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome());
    }

    public Cliente buscarCliente(String cpfCnpj) {
        return clientes.stream()
                .filter(c -> c.getCpfCnpj().equals(cpfCnpj))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> listarClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.getProprietario().adicionarVeiculo(veiculo);
        System.out.println("Veículo cadastrado: " + veiculo.getPlaca());
    }

    public Veiculo buscarVeiculo(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public void cadastrarMecanico(Mecanico mecanico) {
        mecanicos.add(mecanico);
        System.out.println("Mecânico cadastrado: " + mecanico.getNome());
    }

    public List<Mecanico> listarMecanicos() {
        return Collections.unmodifiableList(mecanicos);
    }

    public void cadastrarServico(Servico servico) {
        servicos.add(servico);
        System.out.println("Serviço cadastrado: " + servico.getDescricao());
    }

    public void cadastrarPeca(Peca peca) {
        pecas.add(peca);
        System.out.println("Peça cadastrada: " + peca.getDescricao());
    }

    public Peca buscarPeca(String codigo) {
        return pecas.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor cadastrado: " + fornecedor.getRazaoSocial());
    }

    public OrdemServico abrirOrdemServico(Veiculo veiculo, int kmEntrada,
                                          String problema, Mecanico mecanico,
                                          Date previsaoConclusao) {
        OrdemServico os = new OrdemServico(proximoNumeroOS++, veiculo,
                kmEntrada, problema, mecanico, previsaoConclusao);
        ordensServico.add(os);
        veiculo.getProprietario().adicionarOS(os);
        System.out.println("OS #" + os.getNumero() + " aberta para veículo " + veiculo.getPlaca());
        return os;
    }

    public void adicionarServicoOS(OrdemServico os, Servico servico,
                                   int quantidade, double valorCobrado, Mecanico executor) {
        ItemServico item = new ItemServico(servico, quantidade, valorCobrado, executor);
        os.adicionarItemServico(item);
        System.out.println("Serviço '" + servico.getDescricao() + "' adicionado à OS #" + os.getNumero());
    }

    public void adicionarPecaOS(OrdemServico os, Peca peca, int quantidade) {
        if (!peca.removerEstoque(quantidade)) {
            System.out.println("Estoque insuficiente para: " + peca.getDescricao());
            return;
        }
        ItemPeca item = new ItemPeca(peca, quantidade, peca.getPrecoVenda());
        os.adicionarItemPeca(item);
        movimentos.add(new MovimentoEstoque(peca, TipoMovimento.SAIDA, quantidade,
                peca.getPrecoVenda(), null, null));
        System.out.println("Peça '" + peca.getDescricao() + "' adicionada à OS #" + os.getNumero());
    }

    public Orcamento concluirOrdemServico(OrdemServico os) {
        Orcamento orc = os.concluir();
        System.out.println("OS #" + os.getNumero() + " concluída. Total: R$ " + orc.getTotal());
        return orc;
    }

    public OrdemServico buscarOS(int numero) {
        return ordensServico.stream()
                .filter(os -> os.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    public List<OrdemServico> listarOSPorStatus(StatusOS status) {
        return ordensServico.stream()
                .filter(os -> os.getStatus() == status)
                .collect(Collectors.toList());
    }

    public void registrarEntradaEstoque(Peca peca, int quantidade,
                                        double valorUnitario, Fornecedor fornecedor,
                                        PedidoPeca pedido) {
        peca.adicionarEstoque(quantidade);
        movimentos.add(new MovimentoEstoque(peca, TipoMovimento.ENTRADA,
                quantidade, valorUnitario, fornecedor, pedido));
        if (pedido != null) pedido.registrarEntrega();
        System.out.printf("Entrada: %dx '%s' | Estoque atual: %d%n",
                quantidade, peca.getDescricao(), peca.getEstoqueAtual());
    }

    public boolean registrarSaidaEstoque(Peca peca, int quantidade, double valorUnitario) {
        if (!peca.removerEstoque(quantidade)) {
            System.out.println("Estoque insuficiente para: " + peca.getDescricao());
            return false;
        }
        movimentos.add(new MovimentoEstoque(peca, TipoMovimento.SAIDA,
                quantidade, valorUnitario, null, null));
        System.out.printf("Saida: %dx '%s' | Estoque atual: %d%n",
                quantidade, peca.getDescricao(), peca.getEstoqueAtual());
        return true;
    }

    public PedidoPeca realizarPedidoPeca(Peca peca, Fornecedor fornecedor,
                                         Date previsaoEntrega, double valor) {
        PedidoPeca pedido = new PedidoPeca(peca, fornecedor, previsaoEntrega, valor);
        pedidos.add(pedido);
        System.out.println("Pedido realizado: " + peca.getDescricao()
                + " → " + fornecedor.getRazaoSocial());
        return pedido;
    }

    public Orcamento gerarOrcamento(OrdemServico os, double desconto) {
        Orcamento orc = os.concluir();
        orc.aplicarDesconto(desconto);
        orc.gerar();
        return orc;
    }

    public Pagamento registrarPagamento(Orcamento orcamento, String forma,
                                        int parcelas, Date vencimento) {
        Pagamento pagamento = new Pagamento(orcamento, forma, parcelas, vencimento);
        System.out.printf("Pagamento registrado: %s em %dx R$ %.2f%n",
                forma, parcelas, pagamento.getValorParcela());
        return pagamento;
    }

    public boolean verificarGarantia(Garantia garantia) {
        boolean emGarantia = garantia.estaEmGarantia();
        System.out.println("Garantia OS #" + garantia.getOs().getNumero()
                + ": " + (emGarantia ? "VÁLIDA" : "EXPIRADA"));
        return emGarantia;
    }

    public List<MovimentoEstoque> listarMovimentosPorPeca(Peca peca) {
        return movimentos.stream()
                .filter(m -> m.getPeca().getCodigo().equals(peca.getCodigo()))
                .collect(Collectors.toList());
    }
}
