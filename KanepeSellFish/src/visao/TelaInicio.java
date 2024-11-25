package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoDAO;
import modelo.Produto;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPesquisar;
	JPanel panelLeft;
	List<Produto> produtos;
	JButton btnNewButton_2_1;
	JLabel lblAddProduto;
	JLabel lblAdicionarProduto;
	ProdutoDAO pDAO = new ProdutoDAO();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaInicio frame = new TelaInicio(null, false);
//					frame.setLocationRelativeTo(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public TelaInicio(Usuario u, boolean isVendedor) {
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
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel panel_7 = new JPanel();
		panel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.setForeground(Color.WHITE);
		panel_7.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Peixes Dispon\u00EDveis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setViewportView(panel_7);
		panel_1.add(scrollPane, "cell 1 0 3 2,grow");
		panel_7.setLayout(new MigLayout("", "[][][][]", "[][][][]"));

		ArrayList<Produto> lista = pDAO.addTodosProd();

		int linha = 0;
		int coluna = -1;
		if (lista == null) {
			System.out.println("lista ta Vazia");
		} else {

			for (Produto p : lista) {

				coluna++;
				if (coluna > 3) {
					coluna = 0;
					linha++;
				}
				CardProduto panel_8 = new CardProduto(p);
				panel_7.add(panel_8, "cell " + coluna + " " + linha + "");

			}
		}
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 0 0 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[][][]", "[60px][100px][60px][50px][][][][190px,grow][][]"));

		JLabel lblOrdenar = new JLabel("ORDENAR");
		panel_2.add(lblOrdenar, "cell 1 1,alignx center");
		lblOrdenar.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 14));
		ImageIcon iconUp = new ImageIcon(TelaInicio.class.getResource("/IMG/imgUp.png"));
		Image imgU = iconUp.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JLabel imgDown = new JLabel("");
		imgDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean crescente = true;
				ProdutoDAO dao = new ProdutoDAO();
				dao.ordenarPorPreco(crescente, produtos);
			}
		});

		JLabel imgUp = new JLabel("");
		imgUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean crescente = false;
				ProdutoDAO dao = new ProdutoDAO();
				dao.ordenarPorPreco(crescente, produtos);
			}
		});
		imgUp.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/imgUp.png")));
		panel_2.add(imgUp, "cell 0 2,alignx center");
		imgUp.setIcon(new ImageIcon(imgU));
		imgDown.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/imgDown.png")));
		panel_2.add(imgDown, "cell 2 2,alignx center");
		ImageIcon iconDown = new ImageIcon(TelaInicio.class.getResource("/IMG/imgDown.png"));
		Image imgD = iconDown.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgDown.setIcon(new ImageIcon(imgD));

		JLabel lblMaiorValor = new JLabel("Maior Valor");
		panel_2.add(lblMaiorValor, "cell 0 3,alignx center");
		lblMaiorValor.setFont(new Font("Dialog", Font.PLAIN, 12));
		ImageIcon iconAZ = new ImageIcon(TelaInicio.class.getResource("/IMG/imgA.png"));
		Image ordemAZ = iconAZ.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JLabel imgAZ = new JLabel("");
		imgAZ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean crescente = false;
				ProdutoDAO dao = new ProdutoDAO();
				dao.ordenarNome(crescente, produtos);
			}
		});
		imgAZ.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/imgA.png")));
		panel_2.add(imgAZ, "cell 0 5,alignx center");
		imgAZ.setIcon(new ImageIcon(ordemAZ));

		JLabel imgZA = new JLabel("");
		imgZA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean crescente = true;
				ProdutoDAO dao = new ProdutoDAO();
				dao.ordenarNome(crescente, produtos);
			}
		});
		imgZA.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/imgZ.png")));
		panel_2.add(imgZA, "cell 2 5,alignx center");
		ImageIcon iconZA = new ImageIcon(TelaInicio.class.getResource("/IMG/imgZ.png"));
		Image ordemZA = iconZA.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgZA.setIcon(new ImageIcon(ordemZA));

		JLabel lblAaZ = new JLabel("De A a Z");
		panel_2.add(lblAaZ, "cell 0 6,alignx center");
		lblAaZ.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));
		ImageIcon iconMore = new ImageIcon(TelaInicio.class.getResource("/IMG/iconMore.png"));
		Image more = iconMore.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JRadioButton btDoce = new JRadioButton("Água Doce");
		panel_2.add(btDoce, "cell 0 7");

		JRadioButton btSalgada = new JRadioButton("Água Salgada");
		panel_2.add(btSalgada, "cell 2 7");

		ButtonGroup grupo = new ButtonGroup();

		grupo.add(btSalgada);
		grupo.add(btDoce);

		JLabel imgMenu = new JLabel("");
		imgMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelLeft.isVisible()) {
					panelLeft.setVisible(false);
				} else {
					panelLeft.setVisible(true);
				}
			}
		});
		imgMenu.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/menu-hamburguer.png")));
		panel.add(imgMenu, "cell 0 0");
		ImageIcon menu = new ImageIcon(TelaInicio.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgMenu.setIcon(new ImageIcon(iconMenu));

		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPesquisar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPesquisar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtPesquisar.setDisabledTextColor(new Color(192, 192, 192));
		txtPesquisar.setForeground(new Color(0, 0, 0));
		txtPesquisar.setToolTipText("");
		panel.add(txtPesquisar, "cell 1 0,alignx center");
		txtPesquisar.setHorizontalAlignment(SwingConstants.LEFT);
		txtPesquisar.setBackground(new Color(245, 245, 245));
		txtPesquisar.setColumns(50);

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/carrinho-de-compras.png")));
		panel.add(imgCarrinho, "cell 2 0");
		ImageIcon carrinho = new ImageIcon(TelaInicio.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgCarrinho.setIcon(new ImageIcon(imgC));

		JLabel imgNotificacao = new JLabel("");
		imgNotificacao.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/sino.png")));
		panel.add(imgNotificacao, "cell 3 0");
		ImageIcon notificacao = new ImageIcon(TelaInicio.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgNotificacao.setIcon(new ImageIcon(imgN));

		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(154, 208, 217));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[100px]", "[50px][50px][50px][50px]"));

		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setBorder(null);
		panelLeft.add(btnNewButton, "cell 0 0,grow");

		JButton btnNewButton_1 = new JButton("Carrinho");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarrinho carrinho = new TelaCarrinho(u, produtos, isVendedor);
				carrinho.setLocationRelativeTo(null);
				carrinho.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(154, 205, 217));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		panelLeft.add(btnNewButton_1, "cell 0 1,grow");

		JButton btnNewButton_2 = new JButton("Perfil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isVendedor) {
					TelaPerfilVendedor v = new TelaPerfilVendedor(u, isVendedor);
					v.setLocationRelativeTo(null);
					v.setVisible(true);
					dispose();
				} else {
					TelaPerfilCliente telaPerfil = new TelaPerfilCliente(u, isVendedor);
					telaPerfil.setLocationRelativeTo(null);
					telaPerfil.setVisible(true);
					dispose();
				}
			}
		});

		btnNewButton_2.setBackground(new Color(154, 205, 217));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setOpaque(false);
		panelLeft.add(btnNewButton_2, "cell 0 2,grow");

		if (u.isProdutor()) {
			JButton btnNewButton_3 = new JButton("Estoque");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaEstoque frame = new TelaEstoque(u);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					dispose();

				}
			});

			btnNewButton_3.setBackground(new Color(154, 205, 217));
			btnNewButton_3.setBorder(null);
			btnNewButton_3.setOpaque(false);
			panelLeft.add(btnNewButton_3, "cell 0 3,grow");
		}
		JLabel imgConta = new JLabel("");
		imgConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (u.isProdutor()) {
					TelaPerfilVendedor v = new TelaPerfilVendedor(u, isVendedor);
					v.setLocationRelativeTo(null);
					v.setVisible(true);
					dispose();
				} else {
					TelaPerfilCliente telaPerfil = new TelaPerfilCliente(u, isVendedor);
					telaPerfil.setLocationRelativeTo(null);
					telaPerfil.setVisible(true);
					dispose();
				}
			}
		});
		imgConta.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/do-utilizador.png")));
		panel.add(imgConta, "cell 4 0");
		ImageIcon conta = new ImageIcon(TelaInicio.class.getResource("/IMG/do-utilizador.png"));
		Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgConta.setIcon(new ImageIcon(iconConta));

		JLabel lblMenorValor = new JLabel("Menor Valor");
		panel_2.add(lblMenorValor, "cell 2 3,alignx center");
		lblMenorValor.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JLabel lblZaA = new JLabel("De Z a A");
		panel_2.add(lblZaA, "cell 2 6,alignx center");
		lblZaA.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		btnNewButton_2_1 = new JButton("Estoque");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaEstoque frame = new TelaEstoque(u);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();

			}
		});
		btnNewButton_2_1.setBackground(new Color(154, 205, 217));
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setOpaque(true);
		panelLeft.add(btnNewButton_2_1, "cell 0 3,grow");

		lblAddProduto = new JLabel("");
		lblAddProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroProduto cadastro = new TelaCadastroProduto(null, u);
				cadastro.setLocationRelativeTo(null);
			}
		});
		lblAddProduto.setIcon(new ImageIcon(TelaInicio.class.getResource("/img/More.png")));
		ImageIcon imgM = new ImageIcon(TelaInicio.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblAddProduto.setIcon(new ImageIcon(m));

		panel_2.add(lblAddProduto, "cell 0 8,alignx center,aligny center");

		lblAdicionarProduto = new JLabel("Adicionar Produto");
		panel_2.add(lblAdicionarProduto, "cell 0 9,alignx center,aligny center");
		lblAdicionarProduto.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));
		if (u.isProdutor()) {

			JLabel imgMore = new JLabel("");
			imgMore.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TelaEstoque estoque = new TelaEstoque(u);

					TelaCadastroProduto cadastrar = new TelaCadastroProduto(estoque, u);
					cadastrar.setVisible(true);
					cadastrar.setLocationRelativeTo(null);
				}
			});

			imgMore.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/iconMore.png")));
			panel_2.add(imgMore, "cell 0 8,alignx center");
			imgMore.setIcon(new ImageIcon(more));
		} else {
			btnNewButton_2_1.setVisible(isVendedor);
			lblAddProduto.setVisible(isVendedor);
			lblAdicionarProduto.setVisible(isVendedor);
		}

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
