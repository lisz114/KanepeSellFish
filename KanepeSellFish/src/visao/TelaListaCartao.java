package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controle.CartaoDAO;
import controle.ProdutoDAO;
import modelo.Cartao;
import modelo.Produto;
import modelo.Usuario;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaListaCartao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnDeletar;
	//private Cartao c;
	
	public static ArrayList<Cartao> listaCartao;
	private static CartaoDAO cDAO = CartaoDAO.getInstancia();
	private JButton btnPagar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListaCartao frame = new TelaListaCartao();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaListaCartao(Usuario u, List<Produto>produto ,boolean isVendedor, Cartao c){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][grow]", "[][][][grow]"));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 2,grow");
				
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idCartao", "TipodoCartao", "NumerodoCartao", "apelido"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastramentodoCartao tcc = new TelaCadastramentodoCartao(u, produto, isVendedor, c);
				tcc.setLocationRelativeTo(null);
				tcc.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAdicionar, "flowx,cell 1 1,alignx center,aligny center");
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posicaoSelecionada = -1;
				posicaoSelecionada = table.getSelectedRow();
				if (posicaoSelecionada != -1) {
					Cartao cartaoSelecionado = CartaoDAO.listaCartao.get(posicaoSelecionada);
					listaCartao.remove(posicaoSelecionada);
					cDAO.deletaCartao(cartaoSelecionado);
					
//					PopupExcluir erro = new PopupExcluir(cartaoselecionado);
//					erro.setLocationRelativeTo(null);
//					erro.setVisible(true);
				} else {
					TelaError erro = new TelaError();
					erro.setLabelText("Selecione um Cartão");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
				atualizarTabela(c);
			}
		});
		contentPane.add(btnDeletar, "cell 1 1,alignx center,aligny center");
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoSelecionado = -1;
				posicaoSelecionado = table.getSelectedRow();
				if(posicaoSelecionado != -1) {
					PopUpPagar pop = new PopUpPagar(u, produto, isVendedor, c);
					pop.setLocationRelativeTo(null);
					pop.setVisible(true);
				}else {
					TelaError erro = new TelaError();
					erro.setLabelText("Selecione um Cartão");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
			}
		});
		contentPane.add(btnPagar, "cell 1 3,alignx center");
		
		atualizarTabela(c);
	}
	
	protected void atualizarTabela(Cartao c) {

		listaCartao = cDAO.addListaCartao(c);

		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "idCartao", "TipodoCartao", "NumerodoCartao", "apelido"});

		for (Cartao cartao : listaCartao) {

			tableModel.addRow(new Object[] { cartao.getIdC(), cartao.getTipodoCartao(), cartao.getNumdoCartao(),
					cartao.getApelido()});
		}

		table.setModel(tableModel);

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, renderer);

		// Alterando a cor do título da coluna
		table.getTableHeader().setBackground(new Color(2, 73, 89)); // Cor #024959
		table.getTableHeader().setForeground(Color.WHITE); // Cor do texto do cabeçalho

		// Alterando a cor do item selecionado
		table.setSelectionBackground(new Color(96, 154, 168)); // Cor #609AA8

		// Alterando a cor de fundo das células não selecionadas
		table.setBackground(new Color(240, 240, 240)); // Cor suave para o fundo das células

		// Cor da grade da tabela
		table.setGridColor(new Color(200, 200, 200)); // Cor da grade (borda das células)
		
	}

}
