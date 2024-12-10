package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controle.ProdutoDAO;
import modelo.Produto;
import modelo.Usuario;

public class TelaCarrinho extends JFrame {

	private JPanel contentPane;
	ProdutoDAO pDAO = new ProdutoDAO();
	JPanel panelLeft;
	JButton btnEstoque;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCarrinho frame = new TelaCarrinho(null, null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public TelaCarrinho(Usuario u, List<Produto> produtos, boolean isVendedor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 220));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[30px][grow][]", "[30px]"));

		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(154, 208, 217));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[100px]", "[50px][50px][50px][50px]"));

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicio tiv = new TelaInicio(u, isVendedor);
				tiv.setLocationRelativeTo(null);
				tiv.setVisible(true);
				dispose();
			}
		});
		btnInicio.setBackground(new Color(154, 205, 217));
		btnInicio.setBorder(null);
		btnInicio.setOpaque(false);
		panelLeft.add(btnInicio, "cell 0 0,grow");

		JButton btnCarrinho = new JButton("Carrinho");
		btnCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrinho.setBackground(new Color(96, 154, 168));
		btnCarrinho.setBorder(null);
		panelLeft.add(btnCarrinho, "cell 0 1,grow");

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPerfil.addActionListener(new ActionListener() {
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
		btnPerfil.setBackground(new Color(154, 205, 217));
		btnPerfil.setBorder(null);
		btnPerfil.setOpaque(true);
		panelLeft.add(btnPerfil, "cell 0 2,grow");

		btnEstoque = new JButton("Estoque");
		btnEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaEstoque frame = new TelaEstoque(u);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();

			}
		});
		btnEstoque.setBackground(new Color(154, 205, 217));
		btnEstoque.setBorder(null);
		btnEstoque.setVisible(isVendedor);
		panelLeft.add(btnEstoque, "cell 0 3,grow");

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
		imgMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(imgMenu, "cell 0 0,alignx left,aligny top");
		imgMenu.setIcon(new ImageIcon(TelaCarrinho.class.getResource("/IMG/menu-hamburguer.png")));
		ImageIcon menu = new ImageIcon(TelaCarrinho.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgMenu.setIcon(new ImageIcon(iconMenu));
		ImageIcon perfil = new ImageIcon(TelaCarrinho.class.getResource("/img/do-utilizador.png"));
		Image imgp = perfil.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		JLabel imgLogoff = new JLabel("");
		imgLogoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastro tela = new TelaCadastro();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);

				dispose();
			}
		});
		imgLogoff.setIcon(new ImageIcon(TelaCarrinho.class.getResource("/img/do-utilizador.png")));
		panel.add(imgLogoff, "cell 2 0,alignx right");
		imgLogoff.setIcon(new ImageIcon(imgp));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][][][grow][grow 10]", "[][grow][grow 40][grow 30][]"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel panel_7 = new JPanel();
		panel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.setForeground(Color.WHITE);
		panel_7.setBorder(null);
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
				CardProdCarrinho panel_8 = new CardProdCarrinho(p);
				panel_7.add(panel_8, "cell " + coluna + " " + linha + "");

			}
		}
		JLabel lblInfoCompra = new JLabel("Informações da compra: ");
		lblInfoCompra.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblInfoCompra, "cell 0 2 1 2");

		JLabel lblNomeProduto = new JLabel("");
		lblNomeProduto.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblNomeProduto, "cell 0 3");

		JLabel lblQuantidadeDesej = new JLabel("");
		lblQuantidadeDesej.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblQuantidadeDesej, "cell 3 3,alignx right");

		JLabel lblValorProduto = new JLabel("");
		lblValorProduto.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblValorProduto, "cell 4 3,alignx center");

		JButton btnVoltaTela = new JButton("Continuar comprando");
		btnVoltaTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaInicio tela = new TelaInicio(u, isVendedor);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltaTela.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnVoltaTela.setBackground(new Color(154, 205, 217));
		panel_1.add(btnVoltaTela, "cell 3 4,alignx right");

		JButton btnPagamento = new JButton("Concluir compra");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TelaPagamento tela = new TelaPagamento();
//				tela.setLocationRelativeTo(null);
//				tela.setVisible(true);
//
//				dispose();
			}
		});
		btnPagamento.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnPagamento.setBackground(new Color(154, 205, 217));
		panel_1.add(btnPagamento, "cell 4 4,alignx center");

	}
}
