package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import controle.UsuarioDAO;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaEditarPerfilCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	UsuarioDAO udao = UsuarioDAO.getInstancia();
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
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
					TelaPerfilCliente telaPerfil = new TelaPerfilCliente(u, isVendedor);
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

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png")));
		panel.add(imgCarrinho, "cell 5 0");
		imgCarrinho.setIcon(new ImageIcon(imgC));

		JLabel imgLogoff = new JLabel("");
		imgLogoff.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/saida.png")));
		panel.add(imgLogoff, "cell 6 0");
		ImageIcon logoff = new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/saida.png"));
		Image iconLogoff = logoff.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgLogoff.setIcon(new ImageIcon(iconLogoff));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[300px][grow]", "[grow][grow]"));
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "cell 0 0,grow");
		panel_3.setLayout(new MigLayout("", "[grow]", "[280px][]"));

		JLabel imgPerfil = new JLabel("");
		panel_3.add(imgPerfil, "flowy,cell 0 0,alignx center,aligny bottom");
		imgPerfil.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/Avatar.png")));

		JLabel lblEditarFoto = new JLabel("Alterar foto");
		lblEditarFoto.setForeground(SystemColor.textHighlight);
		lblEditarFoto.setFont(new Font("Dialog", Font.ITALIC, 13));
		panel_3.add(lblEditarFoto, "cell 0 0,alignx center,aligny top");

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 1 0,grow");
		panel_2.setLayout(new MigLayout("", "[30px][10px][10px,grow]", "[50px][][50px][][][][][][]"));

		txtNome = new JTextField();
		txtNome.setBorder(null);
		txtNome.setFont(new Font("Dialog", Font.PLAIN, 30));
		txtNome.setOpaque(false);
		panel_2.add(txtNome, "cell 0 1 3 1,grow");
		txtNome.setColumns(10);
		txtNome.setText(u.getNome());

		JLabel lblCpf = new JLabel("");
		lblCpf.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "CPF", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblCpf.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_2.add(lblCpf, "cell 2 3,growx,aligny center");
		lblCpf.setText(u.getCpf());
		lblCpf.setToolTipText("Cpf não pode ser alterado.");

		txtEmail = new JTextField();
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtEmail.setOpaque(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Email", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(txtEmail, "cell 2 5,growx");
		txtEmail.setText(String.valueOf(u.getEmail()));

		txtTelefone = new JTextField();
		txtTelefone.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Telefone", TitledBorder.LEADING,TitledBorder.TOP, null, null));
		panel_2.add(txtTelefone, "cell 2 7,growx");
		txtTelefone.setColumns(10);
		RestrictedTextField validarTel = new RestrictedTextField(txtTelefone);
		validarTel.setOnlyNums(true);
		validarTel.setLimit(11);

		JPanel panel_buttons = new JPanel();
		panel_1.add(panel_buttons, "cell 1 1,grow");
		panel_buttons.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JButton btCancelar = new JButton("Cancelar");
		panel_buttons.add(btCancelar, "flowx,cell 0 0,alignx right,aligny bottom");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopupCancelar cancelar = new PopupCancelar(u, isVendedor);
				cancelar.setVisible(true);
				cancelar.setLocationRelativeTo(null);
			}
		});

		JButton btSalvar = new JButton("Salvar");
		panel_buttons.add(btSalvar, "cell 0 0,alignx right,aligny bottom");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario usuarioNovo = new Usuario();
				usuarioNovo.setNome(txtNome.getText());
				usuarioNovo.setCpf(lblCpf.getText());
				usuarioNovo.setEmail(txtEmail.getText());
				udao.alterarUsuario(usuarioNovo);
			}
		});
		btSalvar.setBackground(new Color(64, 128, 128));

	}

}
