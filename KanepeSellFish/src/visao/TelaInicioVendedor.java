package visao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoDAO;
import modelo.Produto;
import net.miginfocom.swing.MigLayout;

public class TelaInicioVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicioVendedor frame = new TelaInicioVendedor();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicioVendedor() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][2000px][][][]", "[grow]"));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[10px][300px][grow][grow]", "[160px,grow][150px,grow]"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.WHITE);
		panel_7.setBorder(null);
		scrollPane.setViewportView(panel_7);
		panel_1.add(scrollPane, "cell 1 0 3 2,grow");
		panel_7.setLayout(new MigLayout("", "[][][][]", "[][][][]"));

		ArrayList<Produto> lista = new ArrayList<Produto>();

		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());
		lista.add(new Produto());

		int linha = 0;
		int coluna = -1;
		for (Produto p : lista) {

			coluna++;
			if (coluna > 3) {
				coluna = 0;
				linha++;
			}
			CardProduto panel_8 = new CardProduto(p);
			panel_7.add(panel_8, "cell " + coluna + " " + linha + "");

		}

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 0 0 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[][][]", "[60px][100px][60px][50px][][][][190px,grow][][]"));
		
				JLabel lblPeixes = new JLabel("PEIXES DISPONÍVEIS");
				panel_2.add(lblPeixes, "cell 0 0 3 1,alignx right");
				lblPeixes.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblOrdenar = new JLabel("ORDENAR");
		panel_2.add(lblOrdenar, "cell 1 1,alignx center");
		lblOrdenar.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 14));
		ImageIcon iconUp = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgUp.png"));
		Image imgU = iconUp.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JLabel imgDown = new JLabel("");
		imgDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// metodo consulta por preco menor
			}
		});

		JLabel imgUp = new JLabel("");
		imgUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// trazer método de pesquisa por maior preço
			}
		});
		imgUp.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgUp.png")));
		panel_2.add(imgUp, "cell 0 2,alignx center");
		imgUp.setIcon(new ImageIcon(imgU));
		imgDown.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgDown.png")));
		panel_2.add(imgDown, "cell 2 2,alignx center");
		ImageIcon iconDown = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgDown.png"));
		Image imgD = iconDown.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgDown.setIcon(new ImageIcon(imgD));

		JLabel lblMaiorValor = new JLabel("Maior Valor");
		panel_2.add(lblMaiorValor, "cell 0 3,alignx center");
		lblMaiorValor.setFont(new Font("Dialog", Font.PLAIN, 12));
		ImageIcon iconAZ = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgA.png"));
		Image ordemAZ = iconAZ.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JLabel imgAZ = new JLabel("");
		imgAZ.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgA.png")));
		panel_2.add(imgAZ, "cell 0 5,alignx center");
		imgAZ.setIcon(new ImageIcon(ordemAZ));

		JLabel imgZA = new JLabel("");
		imgZA.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgZ.png")));
		panel_2.add(imgZA, "cell 2 5,alignx center");
		ImageIcon iconZA = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgZ.png"));
		Image ordemZA = iconZA.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgZA.setIcon(new ImageIcon(ordemZA));

		JLabel lblAaZ = new JLabel("De A a Z");
		panel_2.add(lblAaZ, "cell 0 6,alignx center");
		lblAaZ.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));
		ImageIcon iconMore = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/iconMore.png"));
		Image more = iconMore.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		ButtonGroup grupo = new ButtonGroup();

		JLabel imgMenu = new JLabel("");
		imgMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// if (menu.isVisible) {
				// menu.setVisible(false);
				// }else

			}
		});
		imgMenu.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/menu-hamburguer.png")));
		panel.add(imgMenu, "cell 0 0");
		ImageIcon menu = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgMenu.setIcon(new ImageIcon(iconMenu));

		textField = new JTextField();
		panel.add(textField, "cell 1 0,alignx center");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(245, 245, 245));
		textField.setColumns(50);

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png")));
		panel.add(imgCarrinho, "cell 2 0");
		ImageIcon carrinho = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgCarrinho.setIcon(new ImageIcon(imgC));

		JLabel imgNotificacao = new JLabel("");
		imgNotificacao.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png")));
		panel.add(imgNotificacao, "cell 3 0");
		ImageIcon notificacao = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgNotificacao.setIcon(new ImageIcon(imgN));

		JLabel imgConta = new JLabel("");
		imgConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TelaPerfil telaPerfil = new TelaPerfil();
//				telaPerfil.setVisible(true);
//				dispose();
			}
		});
		imgConta.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/do-utilizador.png")));
		panel.add(imgConta, "cell 4 0");
		ImageIcon conta = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/do-utilizador.png"));
		Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgConta.setIcon(new ImageIcon(iconConta));

		JLabel lblMenorValor = new JLabel("Menor Valor");
		panel_2.add(lblMenorValor, "cell 2 3,alignx center");
		lblMenorValor.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JLabel lblZaA = new JLabel("De Z a A");
		panel_2.add(lblZaA, "cell 2 6,alignx center");
		lblZaA.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JLabel imgMore = new JLabel("");
		imgMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroProduto cadastrar = new TelaCadastroProduto();
				
				cadastrar.setVisible(true);
				cadastrar.setLocationRelativeTo(null);
			}
		});
		imgMore.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/iconMore.png")));
		panel_2.add(imgMore, "cell 0 8,alignx center");
		imgMore.setIcon(new ImageIcon(more));

		JLabel lblAdicionarProduto = new JLabel("Adicionar Produto");
		panel_2.add(lblAdicionarProduto, "cell 0 9,alignx center,aligny center");
		lblAdicionarProduto.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		String[] colunas = { "Nome", "Quantidade", "Preço" };
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
