package ap12.apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ap12.dados.Fibonacci;
import ap12.dados.Gerador;
import ap12.dados.Primos;
import ap12.dados.Quadrados;

public class Calculadora extends JFrame {

    private JPanel painel = new JPanel();
    private JPanel painelEntrada = new JPanel();
    private JPanel painelGeradores = new JPanel();

    private JTextField caixaTexto = new JTextField();
    private JButton botaoAdicionar = new JButton("adicionar");
    private JButton botaoLimpar = new JButton("limpar");

    private JTextField caixaQuantidade = new JTextField();
    private JButton botaoPrimos = new JButton("Primos");
    private JButton botaoFibonacci = new JButton("Fibonacci");
    private JButton botaoQuadrados = new JButton("Quadrados");

    private JScrollPane painelScrollTabelaResultados = new JScrollPane();
    private JTable tabelaResultados;
    private TabelaResultados resultados = new TabelaResultados();

    private JScrollPane paineScrollTabelaValores = new JScrollPane();
    private JTable tabelaValores;
    private TabelaValores valores = new TabelaValores();

    public Calculadora() {
        setTitle("Calculadora Estatistica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 300);

        setContentPane(painel);
        painel.setLayout(null);

        painelScrollTabelaResultados.setBounds(10, 10, 880, 50);
        painel.add(painelScrollTabelaResultados);

        tabelaResultados = new JTable(resultados);
        painelScrollTabelaResultados.setViewportView(tabelaResultados);

        painelEntrada.setBounds(15, 80, 280, 173);
        painelEntrada.setLayout(null);
        painel.add(painelEntrada);

        JLabel infoCaixaTexto = new JLabel("Digite um valor:");
        infoCaixaTexto.setBounds(30, 30, 200, 15);
        painelEntrada.add(infoCaixaTexto);

        caixaTexto.setBounds(30, 50, 200, 20);
        painelEntrada.add(caixaTexto);

        botaoAdicionar.setBounds(77, 94, 117, 25);
        painelEntrada.add(botaoAdicionar);

        botaoLimpar.setBounds(77, 136, 117, 25);
        painelEntrada.add(botaoLimpar);

        paineScrollTabelaValores.setBounds(307, 80, 173, 173);
        painel.add(paineScrollTabelaValores);

        tabelaValores = new JTable(valores);
        paineScrollTabelaValores.setViewportView(tabelaValores);

        painelGeradores.setBounds(500, 80, 360, 173);
        painelGeradores.setLayout(null);
        painel.add(painelGeradores);

        JLabel infoQuantidade = new JLabel("Quantidade a gerar:");
        infoQuantidade.setBounds(10, 10, 200, 15);
        painelGeradores.add(infoQuantidade);

        caixaQuantidade.setBounds(10, 30, 340, 20);
        painelGeradores.add(caixaQuantidade);

        botaoPrimos.setBounds(10, 65, 110, 25);
        painelGeradores.add(botaoPrimos);

        botaoFibonacci.setBounds(125, 65, 110, 25);
        painelGeradores.add(botaoFibonacci);

        botaoQuadrados.setBounds(240, 65, 110, 25);
        painelGeradores.add(botaoQuadrados);

        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                valores.adicionaValor(Integer.parseInt(caixaTexto.getText()));
                resultados.atualizar();
                caixaTexto.setText("");
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                valores.limpar();
                resultados.atualizar();
            }
        });

        botaoPrimos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                gerarSequencia(new Primos());
            }
        });

        botaoFibonacci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                gerarSequencia(new Fibonacci());
            }
        });

        botaoQuadrados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                gerarSequencia(new Quadrados());
            }
        });
    }

    private void gerarSequencia(Gerador gerador) {
        try {
            int quantidade = Integer.parseInt(caixaQuantidade.getText());

            gerador.gerar(quantidade);

            for (final int valor : gerador.getSequencia()) {
                valores.adicionaValor(valor);
            }

            resultados.atualizar();
            caixaQuantidade.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Digite um numero inteiro valido na quantidade a gerar.");
        }
    }

    public static void main(String[] args) {
        Calculadora frame = new Calculadora();
        frame.setVisible(true);
    }
}
