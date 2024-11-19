package visao;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoDAO;
import modelo.Produto;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Teste extends JFrame {

    private static final long serialVersionUID = 3710277884173399876L;
    private JPanel contentPane;
    TelaEstoque estaJanela;
    public static ArrayList<Produto> listaProdutos;
    private static ProdutoDAO pDAO = ProdutoDAO.getInstancia();
    private JPanel panelTop;
    private JLabel imgMenu;
    private JTextField textField;
    private JPanel panelTabelaProdutos;
    private JScrollPane scrollPane_1;
    private JTable table_1;
    private JTable table_1_1;
    private JPanel panel_3;
    private JButton btnAdicionar;
    private JButton btnNewButton;
    private JButton btnEditar;
    private JPanel panelMenu;

    public Teste(Usuario u) {
        setResizable(false);
        setLocationByPlatform(true);
        setMinimumSize(new Dimension(1176, 664));
        setMaximumSize(new Dimension(1920, 1080));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 768);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "C\u00F3digo", "Nome", "QuantidadeEstoque:", "Validade", "Salinidade", "Pre\u00E7o" }));
        table_1.setBorder(null);
        scrollPane.setViewportView(table_1);

        panelTop = new JPanel();
        panelTop.setBackground(new Color(154, 205, 217));
        contentPane.add(panelTop, BorderLayout.NORTH);
        panelTop.setLayout(new MigLayout("", "[][2000px][][][]", "[grow]"));

        imgMenu = new JLabel("");
        imgMenu.setIcon(new ImageIcon(Teste.class.getResource("/img/menu-hamburguer.png")));
        panelTop.add(imgMenu, "cell 0 0,alignx trailing");
        ImageIcon menu = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/menu-hamburguer.png"));
        Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        imgMenu.setIcon(new ImageIcon(iconMenu));

        textField = new JTextField();
        panelTop.add(textField, "cell 1 0,alignx center");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBackground(new Color(245, 245, 245));
        textField.setColumns(50);

        JLabel imgCarrinho = new JLabel("");
        imgCarrinho.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png")));
        panelTop.add(imgCarrinho, "cell 2 0");
        ImageIcon carrinho = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png"));
        Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        imgCarrinho.setIcon(new ImageIcon(imgC));

        JLabel imgNotificacao = new JLabel("");
        imgNotificacao.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png")));
        panelTop.add(imgNotificacao, "cell 3 0");
        ImageIcon notificacao = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png"));
        Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        imgNotificacao.setIcon(new ImageIcon(imgN));

        JLabel imgConta = new JLabel("");
        imgConta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        imgConta.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/do-utilizador.png")));
        panelTop.add(imgConta, "cell 4 0");
        ImageIcon conta = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/do-utilizador.png"));
        Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        imgConta.setIcon(new ImageIcon(iconConta));

        panelTabelaProdutos = new JPanel();
        panelTabelaProdutos.setOpaque(false);
        contentPane.add(panelTabelaProdutos, BorderLayout.CENTER);
        panelTabelaProdutos.setLayout(new MigLayout("", "[grow]", "[grow][]"));

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setOpaque(false);
        panelTabelaProdutos.add(scrollPane_1, "cell 0 0,grow");

        table_1_1 = new JTable();
        table_1_1.setBackground(new Color(255, 255, 255));
        table_1_1.setOpaque(false);
        table_1_1.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "C\u00F3digo", "Nome", "Quantidade", "Validade", "Salinidade", "Pre\u00E7o"
            }
        ));
        table_1.getTableHeader().setBackground(Color.BLACK);
        scrollPane_1.setViewportView(table_1_1);

        panel_3 = new JPanel();
        panel_3.setOpaque(false);
        panelTabelaProdutos.add(panel_3, "cell 0 1,alignx right,growy");

        btnEditar = new JButton(" Editar Produtos");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int posicaoSelecionada = -1;
                posicaoSelecionada = table_1.getSelectedRow();
                if (posicaoSelecionada != -1) {

                    Produto produtoSelecionado = ProdutoDAO.listaProdutos.get(posicaoSelecionada);
                    TelaAlterarProduto novaJanela = new TelaAlterarProduto(produtoSelecionado, estaJanela, u);
                    novaJanela.mostrarDados(produtoSelecionado);
                    novaJanela.setVisible(true);
                } else {
                    TelaError erro = new TelaError();
                    erro.setLabelText("Selecione um produto");
                    erro.setLocationRelativeTo(null);
                    erro.setVisible(true);
                }
            }
        });

        btnNewButton = new JButton("Excluir Produto");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int posicaoSelecionada = -1;
                posicaoSelecionada = table_1.getSelectedRow();
                if (posicaoSelecionada != -1) {
                    Produto produtoSelecionado = ProdutoDAO.listaProdutos.get(posicaoSelecionada);

                    TelaExcluirProduto erro = new TelaExcluirProduto(produtoSelecionado, estaJanela, u);
                    erro.setLocationRelativeTo(null);
                    erro.setVisible(true);
                } else {
                    TelaError erro = new TelaError();
                    erro.setLabelText("Selecione um produto");
                    erro.setLocationRelativeTo(null);
                    erro.setVisible(true);
                }

                atualizarTabela(u);
            }
        });
        panel_3.add(btnNewButton, "flowx,cell 0 8,alignx right");

        panel_3.add(btnEditar, "cell 0 8,alignx right");

        btnAdicionar = new JButton("Adicionar Produto");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TelaCadastroProduto addProd = new TelaCadastroProduto(estaJanela, u);
                addProd.setLocationRelativeTo(null);
                addProd.setVisible(true);

            }
        });
        panel_3.add(btnAdicionar, "cell 0 8,alignx trailing");

        panelMenu = new JPanel();
        contentPane.add(panelMenu, BorderLayout.WEST);

        try {
            atualizarTabela(u);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void atualizarTabela(Usuario u) {

        listaProdutos = pDAO.addListaProd(u);

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
                new String[] {"Nome", "QuantidadeEstoque:", "Validade", "Salinidade", "Pre\u00E7o" });

        for (Produto produto : listaProdutos) {
            LocalDate validade = produto.getValidade();
            DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = validade.format(desiredFormatter);
            String salinidade;

            if(produto.getSalinidade()!=null && produto.getSalinidade()==true) {
                salinidade = "Doce";
            } else {
                salinidade = "Salgada";
            }

            tableModel.addRow(new Object[] {produto.getNome(), produto.getQuantidadeEstoque(),
                    formattedDate, salinidade, produto.getPreco() });
        }

        table_1_1.setModel(tableModel);

        // Ajuste da cor do título da coluna
        table_1.getTableHeader().setBackground(new Color(2, 73, 89)); // Cor #024959
        table_1.getTableHeader().setForeground(Color.WHITE); // Cor do texto no título

        // Customização da renderização das células da tabela
        table_1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // Usando a célula padrão para renderizar
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Verifica se a célula está selecionada
                if (isSelected) {
                    // Cor de fundo quando a célula é selecionada
                    cell.setBackground(new Color(96, 154, 168)); // Cor #609AA8
                } else {
                    // Se a célula não está selecionada
                    if (value == null || value.toString().isEmpty()) {
                        // Se a célula estiver vazia, a cor de fundo será branca
                        cell.setBackground(Color.WHITE);
                    } else {
                        // Caso contrário, a célula terá uma cor azul clara
                        cell.setBackground(new Color(154, 205, 217)); // Cor #9ACDD9
                    }
                }

                // Cor do texto em todas as células
                cell.setForeground(Color.BLACK); 

                return cell;
            }
        });
    }
}
