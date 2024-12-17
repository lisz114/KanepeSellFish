
package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import controle.EnderecoDAO;
import controle.ProdutorDAO;
import controle.UsuarioDAO;
import modelo.Endereco;
import modelo.Produtor;
import modelo.RoundButton;
import modelo.Usuario;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

public class TelaEditarPerfilVendedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtCNPJ;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtLogadouro;
	private JTextField txtNum;
	JTextField txtPesquisar;

	private static UsuarioDAO uDAO = UsuarioDAO.getInstancia();
	private static EnderecoDAO eDAO = EnderecoDAO.getInstancia();
	private static ProdutorDAO pDAO = ProdutorDAO.getInstancia();
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaEditarVendedor frame = new TelaEditarVendedor();
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
	public TelaEditarPerfilVendedor(Usuario u, boolean isVendedor) {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		ImageIcon lapis = new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/lapis.png"));
		Image imgL = lapis.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

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
		panel.setLayout(new MigLayout("", "[][grow][][grow][][]", "[]"));
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
		ImageIcon carrinho = new ImageIcon(TelaInicio.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgCarro = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

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
		imgCarrinho.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/carrinho-de-compras.png")));
		panel.add(imgCarrinho, "flowx,cell 4 0");
		imgCarrinho.setIcon(new ImageIcon(imgCarro));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setOpaque(false);

		JLabel imgAvatar = new JLabel("");
		imgAvatar.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/Avatar.png")));
		panel_1.setLayout(new MigLayout("", "[250][400px][grow]", "[60px][202px][][][][grow]"));

		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNome, "cell 1 1,alignx left,aligny center");
		panel_1.add(imgAvatar, "cell 0 1,alignx center,aligny center");
		lblNome.setText(u.getNome());
		txtCPF = new JTextField();
		panel_1.add(txtCPF, "flowx,cell 1 2");
		txtCPF.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCPF.setOpaque(false);
		txtCPF.setToolTipText("");
		txtCPF.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CPF<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCPF.setBackground(SystemColor.menu);
		txtCPF.setColumns(10);

		txtCidade = new JTextField();
		panel_1.add(txtCidade, "flowx,cell 2 2");
		txtCidade.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCidade.setOpaque(false);
		txtCidade.setToolTipText("");
		txtCidade.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Cidade<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCidade.setBackground(SystemColor.menu);
		txtCidade.setColumns(10);

		txtBairro = new JTextField();
		panel_1.add(txtBairro, "cell 2 2");
		txtBairro.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtBairro.setOpaque(false);
		txtBairro.setToolTipText("");
		txtBairro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Bairro<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtBairro.setBackground(SystemColor.menu);
		txtBairro.setColumns(10);

		txtEmail = new JTextField();
		panel_1.add(txtEmail, "flowx,cell 1 3");
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtEmail.setOpaque(false);
		txtEmail.setToolTipText("");
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Email<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setColumns(10);

		txtLogadouro = new JTextField();
		panel_1.add(txtLogadouro, "flowx,cell 2 3");
		txtLogadouro.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtLogadouro.setOpaque(false);
		txtLogadouro.setToolTipText("");
		txtLogadouro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Logadouro<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		txtLogadouro.setBackground(SystemColor.menu);
		txtLogadouro.setColumns(10);

		txtNum = new JTextField();
		panel_1.add(txtNum, "cell 2 3");
		txtNum.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtNum.setOpaque(false);
		txtNum.setToolTipText("");
		txtNum.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Num<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtNum.setBackground(SystemColor.menu);
		txtNum.setColumns(10);


		txtCNPJ = new JTextField();
		panel_1.add(txtCNPJ, "cell 1 2");
		txtCNPJ.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCNPJ.setOpaque(false);
		txtCNPJ.setToolTipText("");
		txtCNPJ.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CNPJ<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCNPJ.setBackground(SystemColor.menu);
		txtCNPJ.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setToolTipText("");
		txtCelular.setOpaque(false);
		txtCelular.setColumns(10);
		txtCelular.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCelular.setOpaque(false);
		txtCelular.setToolTipText("");
		txtCelular.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Celular<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCelular.setBackground(SystemColor.menu);
		
		panel_1.add(txtCelular, "cell 1 3");

		JButton btnNewButton = new RoundButton("Cancelar");
		panel_1.add(btnNewButton, "flowx,cell 2 5,alignx right,aligny bottom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfilVendedor frame = new TelaPerfilVendedor(u, true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));

		JButton btnNewButton_1 = new RoundButton("Salvar");
		panel_1.add(btnNewButton_1, "cell 2 5,alignx right,aligny bottom");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario user = new Usuario();
				Produtor vend = new Produtor();
				Endereco ende = new Endereco();
				String email = txtEmail.getText();
				String cpf = txtCPF.getText();
				String cnpj = txtCNPJ.getText();
				String city = txtCidade.getText();
				String bar = txtBairro.getText();
				String log = txtLogadouro.getText();
				String num = txtNum.getText();
				int num1 = Integer.parseInt(num);
				
				if(email.isEmpty() || cpf.isEmpty() || cnpj.isEmpty() || city.isEmpty() || bar.isEmpty()
						|| log.isEmpty() || num.isEmpty()){
					
					TelaError erro = new TelaError();
					erro.setLabelText("Imformações inválidas!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {
				user.setEmail(email);
				user.setCpf(cpf);
				vend.setCnpj(cnpj);
				ende.setCidade(city);
				ende.setBairro(bar);
				ende.setLogradouro(log);
				ende.setNumero(num1);
				eDAO.atualizarEndereco(ende);
				uDAO.alterarUsuario(user);
				
				TelaPerfilVendedor tpv = new TelaPerfilVendedor(u, true);
				tpv.setLocationRelativeTo(null);
				tpv.setVisible(true);
				dispose();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(96, 154, 168));
		
			
		ImageIcon conta = new ImageIcon(TelaInicio.class.getResource("/IMG/do-utilizador.png"));
		Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		JLabel imgConta = new JLabel("");
		imgConta.setIcon(new ImageIcon(TelaInicio.class.getResource("/IMG/do-utilizador.png")));
		panel.add(imgConta, "cell 5 0");
		imgConta.setIcon(new ImageIcon(iconConta));

	}
}