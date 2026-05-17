package negocio;

import dados.atendimento.Garantia;
import dados.atendimento.OrdemServico;
import dados.catalogo.Peca;
import dados.catalogo.Servico;
import dados.cliente.Cliente;
import dados.cliente.Mecanico;
import dados.cliente.Veiculo;
import dados.enums.*;
import dados.estoque.Fornecedor;
import dados.estoque.PedidoPeca;
import dados.financeiro.Orcamento;
import dados.financeiro.Pagamento;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        separador("CADASTROS INICIAIS");

        // Clientes
        Cliente joao = new Cliente("Joao Silva", "123.456.789-00",
                TipoCliente.FISICA, "Rua das Flores, 10", "joao@email.com");
        joao.adicionarTelefone("(47) 99999-1111");
        joao.adicionarTelefone("(47) 98888-2222");
        sistema.cadastrarCliente(joao);

        Cliente empresa = new Cliente("Transportes Ltda", "12.345.678/0001-99",
                TipoCliente.JURIDICA, "Av. Industrial, 500", "contato@transportes.com");
        empresa.adicionarTelefone("(47) 3333-4444");
        sistema.cadastrarCliente(empresa);

        // Mecanicos
        Mecanico carlos = new Mecanico("Carlos Oliveira", "987.654.321-00",
                new Date(), Especialidade.GERAL, 10.0);
        Mecanico ana = new Mecanico("Ana Souza", "111.222.333-44",
                new Date(), Especialidade.ELETRICA, 12.0);
        sistema.cadastrarMecanico(carlos);
        sistema.cadastrarMecanico(ana);

        // Veiculos — Joao com 2 veiculos
        Veiculo gol = new Veiculo("ABC-1234", "Volkswagen", "Gol",
                2018, "Prata", "9BWZZZ377VT004251", 85000, joao);
        gol.setObservacoes("Vidro traseiro com trinca, nao precisa trocar");
        Veiculo civic = new Veiculo("DEF-5678", "Honda", "Civic",
                2020, "Preto", "9HGFE2F59LA012345", 42000, joao);
        Veiculo caminhao = new Veiculo("XYZ-9999", "Mercedes", "Atego",
                2020, "Branco", "9BM384074LB123456", 210000, empresa);
        sistema.cadastrarVeiculo(gol);
        sistema.cadastrarVeiculo(civic);
        sistema.cadastrarVeiculo(caminhao);

        System.out.println("\nVeiculos de " + joao.getNome() + ":");
        joao.getVeiculos().forEach(v -> System.out.println("  " + v));
        System.out.println("Observacoes do Gol: " + gol.getObservacoes());

        // Servicos
        Servico trocaOleo     = new Servico("SV001", "Troca de Oleo",               "Manutencao", 30,  80.0, 90);
        Servico alinhamento   = new Servico("SV002", "Alinhamento e Balanceamento",  "Pneus",      60, 120.0, 30);
        Servico revisaoFreios = new Servico("SV003", "Revisao de Freios",            "Seguranca",  90, 200.0, 180);
        sistema.cadastrarServico(trocaOleo);
        sistema.cadastrarServico(alinhamento);
        sistema.cadastrarServico(revisaoFreios);

        // Fornecedor
        Fornecedor autopecas = new Fornecedor("98.765.432/0001-11",
                "AutoPecas Brasil", "(47) 3322-1100",
                "vendas@autopecas.com", "Rua do Comercio, 200", "30 dias");
        sistema.cadastrarFornecedor(autopecas);

        // Pecas
        Peca filtroOleo    = new Peca("PC001", "Filtro de Oleo",              "Bosch",   "FOB-1234", "VW Gol/Polo",      10,  3, 12.0, 25.0,  90);
        Peca oleoMotor     = new Peca("PC002", "Oleo Motor 5W30 1L",          "Castrol", "CM-5W30",  "Universal",        50, 10, 18.0, 35.0,  90);
        Peca pastilhaFreio = new Peca("PC003", "Pastilha de Freio Dianteira", "Fras-le", "FL-4882",  "VW Gol 2015-2022",  2,  4, 45.0, 90.0, 180);
        sistema.cadastrarPeca(filtroOleo);
        sistema.cadastrarPeca(oleoMotor);
        sistema.cadastrarPeca(pastilhaFreio);

        // ── Estoque baixo e pedido de peca 
        separador("ESTOQUE BAIXO E PEDIDO DE PECA");

        System.out.println("Pastilha em estoque baixo? " + pastilhaFreio.estoqueBaixo()
                + " (atual=" + pastilhaFreio.getEstoqueAtual()
                + ", min=" + pastilhaFreio.getEstoqueMinimo() + ")");

        PedidoPeca pedidoPastilha = sistema.realizarPedidoPeca(
                pastilhaFreio, autopecas, dataFutura(7), 45.0 * 10);

        System.out.println("Status pedido antes da entrega: " + pedidoPastilha.getStatus());
        sistema.registrarEntradaEstoque(pastilhaFreio, 10, 45.0, autopecas, pedidoPastilha);
        System.out.println("Status pedido apos entrega:     " + pedidoPastilha.getStatus());
        System.out.println("Pastilha em estoque baixo agora? " + pastilhaFreio.estoqueBaixo()
                + " (atual=" + pastilhaFreio.getEstoqueAtual() + ")");

        // ── Saida manual de estoque
        separador("SAIDA MANUAL DE ESTOQUE");

        sistema.registrarSaidaEstoque(oleoMotor, 2, 35.0);

        // ── Transicoes de status da OS 
        separador("TRANSICOES DE STATUS DA OS");

        OrdemServico os3 = sistema.abrirOrdemServico(civic, 42000,
                "Revisao geral preventiva", carlos, dataFutura(3));
        System.out.println("Status inicial:          " + os3.getStatus());

        os3.setStatus(StatusOS.AGUARDANDO_PECAS);
        System.out.println("Aguardando pecas:        " + os3.getStatus());

        os3.setStatus(StatusOS.AGUARDANDO_APROVACAO);
        System.out.println("Aguardando aprovacao:    " + os3.getStatus());

        os3.setStatus(StatusOS.EM_EXECUCAO);
        System.out.println("Em execucao:             " + os3.getStatus());

        // OS com multiplos servicos e pecas
        sistema.adicionarServicoOS(os3, trocaOleo,     1,  80.0, carlos);
        sistema.adicionarServicoOS(os3, alinhamento,   1, 120.0, carlos);
        sistema.adicionarServicoOS(os3, revisaoFreios, 1, 200.0, carlos);
        sistema.adicionarPecaOS(os3, filtroOleo,    1);
        sistema.adicionarPecaOS(os3, oleoMotor,     4);
        sistema.adicionarPecaOS(os3, pastilhaFreio, 2);

        Orcamento orc3 = sistema.gerarOrcamento(os3, 0.0);

        os3.setStatus(StatusOS.ENTREGUE);
        System.out.println("Entregue ao cliente:     " + os3.getStatus());

        // ── Ordens de servico principais 
        separador("ORDENS DE SERVICO PRINCIPAIS");

        OrdemServico os1 = sistema.abrirOrdemServico(gol, 85000,
                "Oleo vencido e filtro sujo", carlos, dataFutura(1));
        sistema.adicionarServicoOS(os1, trocaOleo, 1, 80.0, carlos);
        sistema.adicionarPecaOS(os1, filtroOleo, 1);
        sistema.adicionarPecaOS(os1, oleoMotor, 4);

        OrdemServico os2 = sistema.abrirOrdemServico(gol, 85010,
                "Barulho ao frear", ana, dataFutura(2));
        sistema.adicionarServicoOS(os2, revisaoFreios, 1, 200.0, ana);
        sistema.adicionarPecaOS(os2, pastilhaFreio, 2);

        // ── Orcamento e pagamento OS 1 
        separador("ORCAMENTO E PAGAMENTO  OS 1");

        Orcamento orc1 = sistema.gerarOrcamento(os1, 10.0);
        Pagamento pag1 = sistema.registrarPagamento(orc1, "Cartao de Credito", 3, dataFutura(30));
        System.out.println(pag1);

        System.out.println("\nParcelas geradas:");
        pag1.getParcelas().forEach(p -> System.out.println("  " + p));

        pag1.registrarRecebimento(1);
        System.out.println("\nApos receber parcela 1:");
        pag1.getParcelas().forEach(p -> System.out.println("  " + p));
        System.out.printf("Total recebido: R$ %.2f | Recebidas: %d/%d%n",
                pag1.totalRecebido(), pag1.totalParcelasRecebidas(), pag1.getNumParcelas());

        // ── Parcela atrasada
        separador("PARCELA ATRASADA");

        Pagamento pagAtrasado = sistema.registrarPagamento(orc3, "Boleto", 2, dataPassada(15));
        System.out.println("Parcelas do pagamento atrasado:");
        pagAtrasado.getParcelas().forEach(p ->
                System.out.println("  " + p + " | atrasada=" + p.isAtrasada()));

        // ── Orcamento e pagamento OS 2 
        separador("ORCAMENTO E PAGAMENTO  OS 2");

        Orcamento orc2 = sistema.gerarOrcamento(os2, 0.0);
        Pagamento pag2 = sistema.registrarPagamento(orc2, "PIX", 1, dataFutura(1));
        pag2.registrarRecebimento(1);
        System.out.println(pag2);

        // ── Listagens
        separador("LISTAGENS");

        System.out.println("-- Clientes cadastrados --");
        sistema.listarClientes().forEach(System.out::println);

        System.out.println("\n-- Mecanicos --");
        sistema.listarMecanicos().forEach(System.out::println);

        System.out.println("\n-- OS concluidas --");
        sistema.listarOSPorStatus(StatusOS.CONCLUIDA).forEach(System.out::println);

        System.out.println("\n-- OS entregues --");
        sistema.listarOSPorStatus(StatusOS.ENTREGUE).forEach(System.out::println);

        // ── Garantia 
        separador("GARANTIA");

        Garantia garantiaServico = new Garantia(os1, trocaOleo, null,
                dataFutura(trocaOleo.getGarantiaDias()));
        sistema.verificarGarantia(garantiaServico);

        Garantia garantiaPeca = new Garantia(os2, null, "Pastilha de Freio Dianteira",
                dataFutura(pastilhaFreio.getGarantiaDias()));
        sistema.verificarGarantia(garantiaPeca);

        Garantia garantiaVencida = new Garantia(os2, revisaoFreios, null,
                dataPassada(10));
        sistema.verificarGarantia(garantiaVencida);

        // ── Busca de OS 
        separador("BUSCA DE OS");

        OrdemServico encontrada = sistema.buscarOS(1);
        if (encontrada != null) {
            System.out.println("OS encontrada: " + encontrada);
            System.out.println("Itens de servico:");
            encontrada.getItensServico().forEach(is -> System.out.println("  " + is));
            System.out.println("Itens de peca:");
            encontrada.getItensPeca().forEach(ip -> System.out.println("  " + ip));
        }

        // ── Historico do cliente
        separador("HISTORICO DO CLIENTE");

        System.out.println("Historico de OS de " + joao.getNome() + " (2 veiculos):");
        joao.getHistoricoOS().forEach(os -> System.out.println("  " + os));


        // -- Comissoes dos mecanicos --
        separador("COMISSOES DOS MECANICOS");

        System.out.println("Comissoes por servico da OS #1 (civic):");
        sistema.buscarOS(1).getItensServico().forEach(is ->
            System.out.printf("  %s | servico: %s | subtotal: R$ %.2f | comissao (%.0f%%): R$ %.2f%n",
                is.getMecanicoExecutor().getNome(),
                is.getServico().getDescricao(),
                is.getSubtotal(),
                is.getMecanicoExecutor().getComissaoPct(),
                is.calcularComissao()));

        double totalComissaoCarlos = sistema.buscarOS(1).getItensServico().stream()
                .mapToDouble(is -> is.calcularComissao()).sum();
        System.out.printf("Total comissao Carlos na OS #1: R$ %.2f%n", totalComissaoCarlos);

        // -- Historico de movimentos por peca --
        separador("HISTORICO DE MOVIMENTOS POR PECA");

        System.out.println("Movimentos do Oleo Motor:");
        sistema.listarMovimentosPorPeca(oleoMotor).forEach(m ->
            System.out.printf("  %s | qtd=%d | valor=R$ %.2f | data=%s%n",
                m.getTipo(), m.getQuantidade(), m.getValorUnitario(), m.getDataHora()));

        System.out.println("\nMovimentos da Pastilha de Freio:");
        sistema.listarMovimentosPorPeca(pastilhaFreio).forEach(m ->
            System.out.printf("  %s | qtd=%d | valor=R$ %.2f | fornecedor=%s%n",
                m.getTipo(), m.getQuantidade(), m.getValorUnitario(),
                m.getFornecedor() != null ? m.getFornecedor().getRazaoSocial() : "-"));

        // ── Codigo fabricante da peca 
        separador("CODIGO FABRICANTE DA PECA");

        System.out.println("Filtro   fabricante: " + filtroOleo.getFabricante()
                + " | cod: " + filtroOleo.getCodigoFabricante()
                + " | compatibilidade: " + filtroOleo.getCompatibilidade());
        System.out.println("Pastilha  fabricante: " + pastilhaFreio.getFabricante()
                + " | cod: " + pastilhaFreio.getCodigoFabricante()
                + " | compatibilidade: " + pastilhaFreio.getCompatibilidade());
    }

    // ── Helpers 
    private static void separador(String titulo) {
        System.out.println("\n==========================================");
        System.out.println("  " + titulo);
        System.out.println("==========================================");
    }

    private static Date dataFutura(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, dias);
        return cal.getTime();
    }

    private static Date dataPassada(int dias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -dias);
        return cal.getTime();
    }
}
