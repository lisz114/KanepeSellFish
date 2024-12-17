package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Produto;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.Cursor;

public class TelaPerfilCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TelaPerfilCliente estajanela = this; 
	JPanel panelLeft;
	List<Produto> produtos;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPerfilCliente frame = new TelaPerfilCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaPerfilCliente(Usuario u, boolean isVendedor) {
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
		panel_1.setLayout(new MigLayout("", "[300px][grow]", "[grow][grow]"));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[grow]", "[280px][grow]"));

		JLabel lblImagemCliente = new JLabel("");
		lblImagemCliente.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/img/Avatar.png")));
		panel_3.add(lblImagemCliente, "flowy,cell 0 0,alignx center,aligny bottom");

		JLabel lblNewLabel = new JLabel("Alterar foto");
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		panel_3.add(lblNewLabel, "cell 0 0,alignx center,aligny center");

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 1 0,grow");
		panel_2.setLayout(new MigLayout("", "[][]", "[50px][][20px][][20px][][20px][][][][]"));

		JLabel lblNomeCliente = new JLabel(u.getNome());
		panel_2.add(lblNomeCliente, "cell 0 1 2 1");
		lblNomeCliente.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		JLabel lblCPF = new JLabel("CPF: ");
		lblCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCPF.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_2.add(lblCPF, "cell 0 3");

		JLabel lblDynamicCPF = new JLabel(u.getCpf());
		lblDynamicCPF.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_2.add(lblDynamicCPF, "cell 1 3,alignx left,aligny center");

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_2.add(lblEmail, "cell 0 5");

		JLabel lblDynamicEmail = new JLabel(u.getEmail());
		lblDynamicEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_2.add(lblDynamicEmail, "cell 1 5,alignx left,aligny center");

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_2.add(lblTelefone, "cell 0 7");

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "cell 1 1,alignx right,aligny bottom");
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JButton bntEditar = new JButton(" Alterar informações ");
		bntEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaEditarPerfilCliente editar = new TelaEditarPerfilCliente(u, isVendedor);
				editar.setVisible(true);
				editar.setLocationRelativeTo(null);
				dispose();
			}
		});
		bntEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntEditar.setFont(new Font("Dialog", Font.PLAIN, 13));
		bntEditar.setBackground(new Color(2, 73, 89));
		bntEditar.setBackground(new Color(96, 154, 168));
		bntEditar.setBorderPainted(false);
		bntEditar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.add(bntEditar, "cell 4 7,alignx center");
		
		String telefone = u.getTel();
		JLabel lblDynamicTelefone;

		if (telefone == null) {
			lblDynamicTelefone = new JLabel("Nenhum telefone cadastrado");
			lblDynamicTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			panel_2.add(lblDynamicTelefone, "cell 1 7,alignx left,aligny center");
		} else {
			lblDynamicTelefone = new JLabel(telefone);
			lblDynamicTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			panel_2.add(lblDynamicTelefone, "cell 1 7,alignx left,aligny center");
		}

		JLabel imgMenu = new JLabel("");
		imgMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		ImageIcon carrinho = new ImageIcon(TelaInicio.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon notificacao = new ImageIcon(TelaInicio.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(154, 208, 217));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[100px]", "[50px][50px][50px][50px]"));

		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicio tela = new TelaInicio(u, isVendedor);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);

				dispose();
			}
		});
		btnNewButton.setBackground(new Color(154, 205, 217));
		btnNewButton.setBorder(null);
		panelLeft.add(btnNewButton, "cell 0 0,grow");

		JButton btnNewButton_1 = new JButton("Carrinho");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarrinho carrinho = new TelaCarrinho(u, null, isVendedor);
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
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnNewButton_2.setBackground(new Color(64, 128, 128));
		btnNewButton_2.setBorder(null);
		panelLeft.add(btnNewButton_2, "cell 0 2,grow");

		if (isVendedor) {
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
		JLabel imgSair = new JLabel("");
		imgSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaDeLogOff telaLogOff = new TelaDeLogOff(estajanela, u, isVendedor);
				telaLogOff.setLocationRelativeTo(null);
				telaLogOff.setVisible(true);
			}
		});
		
				JLabel imgCarrinho = new JLabel("");
				imgCarrinho.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						TelaCarrinho carrinho = new TelaCarrinho(u, produtos, isVendedor);
						carrinho.setLocationRelativeTo(null);
						carrinho.setVisible(true);
						dispose();
						
					}
				});
				imgCarrinho.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/carrinho-de-compras.png")));
				panel.add(imgCarrinho, "cell 3 0");
				imgCarrinho.setIcon(new ImageIcon(imgC));
		imgSair.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/img/saida.png")));
		panel.add(imgSair, "cell 4 0");
		ImageIcon conta = new ImageIcon(TelaInicio.class.getResource("/img/saida.png"));
		Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgSair.setIcon(new ImageIcon(iconConta));

	}

}
