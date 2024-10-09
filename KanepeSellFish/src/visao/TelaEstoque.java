package visao;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoDAO;
import modelo.Produto;
import net.miginfocom.swing.MigLayout;

public class TelaEstoque extends JFrame {

	private static final long serialVersionUID = 3710277884173399876L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnSMTJAIR;
	private JLabel lblNewLabel;
	private JButton btnAdicionar;
	TelaEstoque estaJanela = this;
	private JButton btnNewButton;
	private static ProdutoDAO pDAO = ProdutoDAO.getInstancia();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEstoque() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Estoque", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[300px,grow]", "[][][][][200px][][][][]"));

		lblNewLabel = new JLabel("ESTOQUE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, "cell 0 1,alignx center");

		btnSMTJAIR = new JButton(" Editar Produtos");
		btnSMTJAIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoSelecionada = -1;
				posicaoSelecionada = table.getSelectedRow();
				if(posicaoSelecionada!=-1) {
				
				Produto produtoSelecionado = ProdutoDAO.listaProdutos.get(posicaoSelecionada);
				TelaAlterarProduto novaJanela = new TelaAlterarProduto();
					novaJanela.mostrarDados(produtoSelecionado);
					novaJanela.setVisible(true);
				}else {
					 TelaError erro = new TelaError();
			            erro.setLabelText("Selecione um produto");
			            erro.setLocationRelativeTo(null);
			            erro.setVisible(true);
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 7,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "QuantidadeEstoque:", "Validade", "Salinidade", "Pre\u00E7o"
			}
		));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Excluir Produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		contentPane.add(btnNewButton, "flowx,cell 0 8,alignx right");

		contentPane.add(btnSMTJAIR, "cell 0 8,alignx right");

		btnAdicionar = new JButton("Adicionar Produto");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroProduto addProd = new TelaCadastroProduto(estaJanela);
				addProd.setLocationRelativeTo(null);
				addProd.setVisible(true);
				
			}
		});
		contentPane.add(btnAdicionar, "cell 0 8,alignx trailing");

		try {
			atualizarTabela();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void atualizarTabela() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {  },
				new String[] { "C\u00F3digo", "Nome", "QuantidadeEstoque:", "Validade", "Salinidade", "Pre\u00E7o" });

		for (Produto produto : ProdutoDAO.listaProdutos) {

			tableModel.addRow(new Object[] { produto.getCodigo(), produto.getNome(), produto.getQuantidadeEstoque(),
					produto.getValidade(), "null", produto.getPreco() });
		}

		table.setModel(tableModel);

	}

}
