package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import controle.UsuarioDAO;
import modelo.Produto;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaEditarPerfilCliente extends JFrame {

	private JPanel contentPane;
	JTextField txtPesquisar;
	private JTextField txtCPF;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JLabel lblNome;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaEditarPerfilCliente frame = new TelaEditarPerfilCliente();
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
	public TelaEditarPerfilCliente(Usuario u, boolean isVendedor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(154, 208, 217));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[100px]", "[50px][50px][50px][50px]"));

		JButton btInicio = new JButton("Inicio");
		btInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btInicio.setBackground(new Color(154, 205, 217));
		btInicio.setBorder(null);
		panelLeft.add(btInicio, "cell 0 0,grow");

		JButton btCarrinho = new JButton("Carrinho");
		btCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarrinho carrinho = new TelaCarrinho(u, null, isVendedor);
				carrinho.setLocationRelativeTo(null);
				carrinho.setVisible(true);
				dispose();
			}
		});
		btCarrinho.setBackground(new Color(154, 205, 217));
		btCarrinho.setBorder(null);
		btCarrinho.setOpaque(false);
		panelLeft.add(btCarrinho, "cell 0 1,grow");

		JButton btPerfil = new JButton("Perfil");
		btPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isVendedor) {
					TelaPerfilVendedor v = new TelaPerfilVendedor(u, isVendedor);
					v.setLocationRelativeTo(null);
					v.setVisible(true);
					dispose();
				} else {
					TelaPerfilCliente telaPerfil = new TelaPerfilCliente( u, isVendedor);
					telaPerfil.setLocationRelativeTo(null);
					telaPerfil.setVisible(true);
					dispose();
				}
			}
		});

		btPerfil.setBackground(new Color(64, 128, 128));
		btPerfil.setBorder(null);
		panelLeft.add(btPerfil, "cell 0 2,grow");

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
		JButton btEstoque = new JButton("Estoque");
		btEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEstoque frame = new TelaEstoque(u);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btEstoque.setOpaque(false);
		btEstoque.setBorder(null);
		btEstoque.setBackground(new Color(154, 205, 217));
		panelLeft.add(btEstoque, "cell 0 3,alignx center,aligny center");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][grow][][grow][][][]", "[]"));
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
		ImageIcon menu = new ImageIcon(TelaEditarPerfilCliente.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgMenu.setIcon(new ImageIcon(iconMenu));
		ImageIcon carrinho = new ImageIcon(TelaEditarPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon notificacao = new ImageIcon(TelaEditarPerfilCliente.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPesquisar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPesquisar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtPesquisar.setDisabledTextColor(new Color(192, 192, 192));
		txtPesquisar.setForeground(new Color(0, 0, 0));
		txtPesquisar.setToolTipText("");
		panel.add(txtPesquisar, "cell 2 0,alignx center");
		txtPesquisar.setHorizontalAlignment(SwingConstants.LEFT);
		txtPesquisar.setBackground(new Color(245, 245, 245));
		txtPesquisar.setColumns(50);

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png")));
		panel.add(imgCarrinho, "cell 4 0");
		imgCarrinho.setIcon(new ImageIcon(imgC));

		JLabel imgNotificacao = new JLabel("");
		imgNotificacao.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/IMG/sino.png")));
		panel.add(imgNotificacao, "cell 5 0");
		imgNotificacao.setIcon(new ImageIcon(imgN));
		
		JLabel imgLogoff = new JLabel("");
		imgLogoff.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/saida.png")));
		panel.add(imgLogoff, "cell 6 0");
		ImageIcon logoff = new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/saida.png"));
		Image iconLogoff = logoff.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgLogoff.setIcon(new ImageIcon(iconLogoff));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][25px,grow][25px,grow][25px,grow]", "[][][][][][grow]"));

		JLabel imgPerfil = new JLabel("");
		imgPerfil.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/Avatar.png")));
		panel_1.add(imgPerfil, "cell 0 1");

		lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_1.add(lblNome, "cell 1 1 3 1,alignx left,aligny top");
		lblNome.setText(u.getNome());
		
		txtCPF = new JTextField();
		panel_1.add(txtCPF, "cell 1 2,growx");
		txtCPF.setColumns(10);
		txtCPF.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCPF.setOpaque(false);
		txtCPF.setToolTipText("");
		txtCPF.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CPF<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCPF.setBackground(SystemColor.menu);
		
		txtEmail = new JTextField();
		panel_1.add(txtEmail, "cell 1 3,growx");
		txtEmail.setColumns(10);
		txtEmail.setColumns(10);
		txtEmail.setOpaque(false);
		txtEmail.setToolTipText("");
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Email<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtEmail.setBackground(SystemColor.menu);
		
		txtTel = new JTextField();
		panel_1.add(txtTel, "cell 1 4,growx");
		txtTel.setColumns(10);
		txtTel.setOpaque(false);
		txtTel.setToolTipText("Adicionar Telefone");
		txtTel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Tel</html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtTel.setBackground(SystemColor.menu);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopupCancelar cancelar = new PopupCancelar(u, isVendedor);
				cancelar.setVisible(true);
				cancelar.setLocationRelativeTo(null);
			}
		});
		panel_1.add(btCancelar, "flowx,cell 3 5,alignx right,aligny bottom");
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO udao = new UsuarioDAO();
				udao.alterarUsuario(u);
			}
		});
		btSalvar.setBackground(new Color(64, 128, 128));
		panel_1.add(btSalvar, "cell 3 5,alignx right,aligny bottom");

	}
	public void mostrarDados(Usuario usuarioSelecionado) {
		lblNome.setText(usuarioSelecionado.getNome());
		txtCPF.setText(String.valueOf(usuarioSelecionado.getCpf()));
		txtEmail.setText(String.valueOf(usuarioSelecionado.getEmail()));
		txtTel.setText(String.valueOf(usuarioSelecionado.getTel()));
	}
}
