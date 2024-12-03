
package visao;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controle.EnderecoDAO;
import controle.ProdutorDAO;
import controle.UsuarioDAO;
import modelo.Endereco;
import modelo.Produtor;
import modelo.RoundButton;
import modelo.Usuario;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TelaEditarPerfilVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtCNPJ;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtLogadouro;
	private JTextField txtNum;
	
	private static UsuarioDAO uDAO = UsuarioDAO.getInstancia();
	private static EnderecoDAO eDAO = EnderecoDAO.getInstancia();
	private static ProdutorDAO pDAO = ProdutorDAO.getInstancia();

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
	public TelaEditarPerfilVendedor(Usuario u) {
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

		PicPanel panel = new PicPanel("src//IMG/EdicaoPerfilVendedor.png");
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setOpaque(false);

		JLabel imgBarra = new JLabel("");
		imgBarra.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/menu-hamburguer.png")));

		JLabel imgAvatar = new JLabel("");
		imgAvatar.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/Avatar.png")));

		JLabel lblEditarFoto = new JLabel("Editar foto de Perfil");
		lblEditarFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					System.out.println(i);
				} else {
					File arquivo = file.getSelectedFile();
					System.out.println(arquivo);

					String destino = arquivo.getAbsolutePath();
					ImageIcon img = new ImageIcon(destino);
					Image png = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					imgAvatar.setIcon(new ImageIcon(png));
				}

			}
		});

		JLabel imgLapis = new JLabel("");
		imgLapis.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/lapis.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(imgBarra)
					.addContainerGap(193, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(241, Short.MAX_VALUE)
					.addComponent(lblEditarFoto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(imgLapis)
					.addGap(215))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(192, Short.MAX_VALUE)
					.addComponent(imgAvatar)
					.addGap(181))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(imgBarra)
					.addGap(30)
					.addComponent(imgAvatar)
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEditarFoto)
						.addComponent(imgLapis))
					.addContainerGap(310, Short.MAX_VALUE))
		);
		ImageIcon barras = new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/menu-hamburguer.png"));
		Image imgB = barras.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgBarra.setIcon(new ImageIcon(imgB));
		panel_1.setLayout(gl_panel_1);

		ImageIcon lapis = new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/lapis.png"));
		Image imgL = lapis.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgLapis.setIcon(new ImageIcon(imgL));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);

		JPanel PanelNome = new JPanel();
		PanelNome.setBounds(10, 11, 555, 144);
		panel_2.add(PanelNome);
		PanelNome.setLayout(null);
		PanelNome.setOpaque(false);

		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNome.setBounds(10, 41, 331, 56);
		PanelNome.add(lblNome);
		lblNome.setText(u.getNome());

		JLabel lblNomeEmp = new JLabel("New label");
		lblNomeEmp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeEmp.setBounds(20, 108, 254, 25);
		PanelNome.add(lblNomeEmp);
//		lblNomeEmp.setText(u.getProd().getNomeComercio());

		JLabel imgKart = new JLabel("");
		imgKart.setBounds(400, 6, 46, 39);
		panel_2.add(imgKart);
		imgKart.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/carrinho-de-compras.png")));
		ImageIcon car = new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/carrinho-de-compras.png"));
		Image imgC = car.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgKart.setIcon(new ImageIcon(imgC));
		JLabel imgSino = new JLabel("");
		imgSino.setBounds(460, 4, 46, 45);
		panel_2.add(imgSino);
		imgSino.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/sino.png")));
		ImageIcon sino = new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/sino.png"));
		Image imgS = sino.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgSino.setIcon(new ImageIcon(imgS));

		JPanel PanelEditor = new JPanel();
		PanelEditor.setBounds(20, 166, 555, 438);
		panel_2.add(PanelEditor);
		PanelEditor.setOpaque(false);
		GridBagLayout gbl_PanelEditor = new GridBagLayout();
		gbl_PanelEditor.columnWidths = new int[] { 40, 118, 62, 119, 33, 118, 0 };
		gbl_PanelEditor.rowHeights = new int[] { 36, 14, 20, 91, 14, 20, 120, 14, 20, 0, 0, 0 };
		gbl_PanelEditor.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_PanelEditor.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		PanelEditor.setLayout(gbl_PanelEditor);

		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtEmail.setOpaque(false);
		txtEmail.setToolTipText("");
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Email<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtEmail.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 2;
		PanelEditor.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCidade.setOpaque(false);
		txtCidade.setToolTipText("");
		txtCidade.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Cidade<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCidade.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.anchor = GridBagConstraints.NORTH;
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridx = 3;
		gbc_txtCidade.gridy = 2;
		PanelEditor.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCPF.setOpaque(false);
		txtCPF.setToolTipText("");
		txtCPF.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CPF<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCPF.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtCPF = new GridBagConstraints();
		gbc_txtCPF.anchor = GridBagConstraints.NORTH;
		gbc_txtCPF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCPF.insets = new Insets(0, 0, 5, 5);
		gbc_txtCPF.gridx = 1;
		gbc_txtCPF.gridy = 5;
		PanelEditor.add(txtCPF, gbc_txtCPF);
		txtCPF.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtBairro.setOpaque(false);
		txtBairro.setToolTipText("");
		txtBairro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Bairro<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtBairro.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtBairro = new GridBagConstraints();
		gbc_txtBairro.anchor = GridBagConstraints.NORTH;
		gbc_txtBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBairro.insets = new Insets(0, 0, 5, 5);
		gbc_txtBairro.gridx = 3;
		gbc_txtBairro.gridy = 5;
		PanelEditor.add(txtBairro, gbc_txtBairro);
		txtBairro.setColumns(10);

		txtCNPJ = new JTextField();
		txtCNPJ.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCNPJ.setOpaque(false);
		txtCNPJ.setToolTipText("");
		txtCNPJ.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CNPJ<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCNPJ.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtCNPJ = new GridBagConstraints();
		gbc_txtCNPJ.anchor = GridBagConstraints.NORTH;
		gbc_txtCNPJ.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCNPJ.insets = new Insets(0, 0, 5, 5);
		gbc_txtCNPJ.gridx = 1;
		gbc_txtCNPJ.gridy = 8;
		PanelEditor.add(txtCNPJ, gbc_txtCNPJ);
		txtCNPJ.setColumns(10);

		txtLogadouro = new JTextField();
		txtLogadouro.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtLogadouro.setOpaque(false);
		txtLogadouro.setToolTipText("");
		txtLogadouro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Logadouro<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtLogadouro.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtLogadouro = new GridBagConstraints();
		gbc_txtLogadouro.anchor = GridBagConstraints.NORTH;
		gbc_txtLogadouro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogadouro.insets = new Insets(0, 0, 5, 5);
		gbc_txtLogadouro.gridx = 3;
		gbc_txtLogadouro.gridy = 8;
		PanelEditor.add(txtLogadouro, gbc_txtLogadouro);
		txtLogadouro.setColumns(10);

		txtNum = new JTextField();
		txtNum.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtNum.setOpaque(false);
		txtNum.setToolTipText("");
		txtNum.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Num<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtNum.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtNum = new GridBagConstraints();
		gbc_txtNum.insets = new Insets(0, 0, 5, 0);
		gbc_txtNum.anchor = GridBagConstraints.NORTH;
		gbc_txtNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNum.gridx = 5;
		gbc_txtNum.gridy = 8;
		PanelEditor.add(txtNum, gbc_txtNum);
		txtNum.setColumns(10);

		JButton btnNewButton = new RoundButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfilVendedor frame = new TelaPerfilVendedor(u, true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 10;
		PanelEditor.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new RoundButton("Salvar");
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
				}else {

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
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 10;
		PanelEditor.add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPerfilVendedor frame = new TelaPerfilVendedor(u, true);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/Voltar.png")));
		lblNewLabel_10.setBounds(520, 4, 46, 45);
		panel_2.add(lblNewLabel_10);

	}
}