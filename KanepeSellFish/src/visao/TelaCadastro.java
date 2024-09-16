package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controle.UsuarioDAO;
import modelo.Usuario;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import com.jgoodies.forms.layout.FormSpecs;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private static UsuarioDAO uDAO = UsuarioDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {

		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		PicPanel panel = new PicPanel("src//IMG/BackgroundCompleto.png");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel PainelKSF = new JPanel();
		panel.add(PainelKSF);

		JPanel PainelCadastro = new JPanel();
		PainelCadastro.setBorder(null);
		panel.add(PainelCadastro);

		PainelCadastro.setOpaque(false);
		PainelCadastro
				.setLayout(new MigLayout("", "[grow][533px][grow]", "[50px][136px][300px][80px][100px][20px][50px]"));

		JPanel painelTitulo = new JPanel();
		painelTitulo.setOpaque(false);
		PainelCadastro.add(painelTitulo, "cell 1 1,grow");
		painelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel("Crie uma conta");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 50));
		lblTitulo.setBounds(10, 11, 513, 114);
		lblTitulo.setForeground(new Color(0, 0, 0));
		painelTitulo.add(lblTitulo);

		JPanel PainelInfo = new JPanel();
		PainelInfo.setBorder(new EmptyBorder(0, 60, 0, 50));
		PainelCadastro.add(PainelInfo, "cell 1 2,grow");
		PainelInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelNome = new JPanel();
		panelNome.setOpaque(false);
		PainelInfo.add(panelNome);
		panelNome.setLayout(new MigLayout("", "[][][]", "[]"));

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.BOLD, 13));
		panelNome.add(lblNome, "cell 0 0");
		lblNome.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		panelNome.add(lblNewLabel_7, "cell 1 0");

		txtNome = new JTextField();
		txtNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setForeground(new Color(0, 0, 0));
		PainelInfo.add(txtNome);
		txtNome.setColumns(10);

		JPanel panelCpf = new JPanel();
		panelCpf.setOpaque(false);
		PainelInfo.add(panelCpf);
		panelCpf.setLayout(new MigLayout("", "[][]", "[]"));

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.BOLD, 13));
		panelCpf.add(lblCpf, "cell 0 0");
		lblCpf.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_7_1 = new JLabel("*");
		lblNewLabel_7_1.setForeground(Color.RED);
		panelCpf.add(lblNewLabel_7_1, "cell 1 0");

		txtCPF = new JTextField();
		txtCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		PainelInfo.add(txtCPF);
		txtCPF.setColumns(10);

		JPanel panelEmail = new JPanel();
		panelEmail.setOpaque(false);
		PainelInfo.add(panelEmail);
		panelEmail.setLayout(new MigLayout("", "[][]", "[]"));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.BOLD, 13));
		panelEmail.add(lblEmail, "cell 0 0");
		lblEmail.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_7_2 = new JLabel("*");
		lblNewLabel_7_2.setForeground(Color.RED);
		panelEmail.add(lblNewLabel_7_2, "cell 1 0");

		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		PainelInfo.add(txtEmail);
		txtEmail.setColumns(10);

		JPanel panelSenha = new JPanel();
		panelSenha.setOpaque(false);
		PainelInfo.add(panelSenha);
		panelSenha.setLayout(new MigLayout("", "[][]", "[]"));

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.BOLD, 13));
		panelSenha.add(lblSenha, "cell 0 0");
		lblSenha.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_7_3 = new JLabel("*");
		lblNewLabel_7_3.setForeground(Color.RED);
		panelSenha.add(lblNewLabel_7_3, "cell 1 0");

		txtSenha = new JTextField();
		txtSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		PainelInfo.add(txtSenha);
		txtSenha.setColumns(10);

		JPanel PainelOpcao = new JPanel();
		PainelOpcao.setBorder(new EmptyBorder(0, 60, 0, 50));
		PainelCadastro.add(PainelOpcao, "cell 1 3,grow");
		PainelOpcao.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelOpcUser = new JPanel();
		panelOpcUser.setOpaque(false);
		PainelOpcao.add(panelOpcUser);
		panelOpcUser.setLayout(new MigLayout("", "[][]", "[][]"));

		JLabel lblOpcUser = new JLabel("Selecione uma opção de usuario");
		lblOpcUser.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.BOLD, 13));
		lblOpcUser.setForeground(new Color(0, 0, 0));
		panelOpcUser.add(lblOpcUser, "cell 0 0,alignx left,aligny bottom");
		lblOpcUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcUser.setVerticalAlignment(SwingConstants.BOTTOM);

		JLabel lblNewLabel_7_3_1 = new JLabel("*");
		lblNewLabel_7_3_1.setForeground(Color.RED);
		panelOpcUser.add(lblNewLabel_7_3_1, "cell 1 0");

		JComboBox cboxOpcUser = new JComboBox();
		cboxOpcUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboxOpcUser.setModel(new DefaultComboBoxModel(new String[] {"Vendedor", "Cliente"}));
		cboxOpcUser.setSelectedIndex(1);
		cboxOpcUser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelOpcUser.add(cboxOpcUser, "cell 0 1");
		cboxOpcUser.setBackground(new Color(154, 205, 217));

		JPanel PainelConfirm = new JPanel();
		PainelConfirm.setBorder(new EmptyBorder(0, 60, 0, 50));
		PainelCadastro.add(PainelConfirm, "cell 1 4,grow");
		PainelConfirm.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel PainelBTN = new JPanel();
		PainelConfirm.add(PainelBTN);

		painelTitulo.setOpaque(false);
		PainelInfo.setOpaque(false);
		PainelOpcao.setOpaque(false);
		PainelConfirm.setOpaque(false);
		PainelBTN.setOpaque(false);

		txtNome.setOpaque(false);
		txtCPF.setOpaque(false);
		txtEmail.setOpaque(false);
		txtSenha.setOpaque(false);

		JButton btnCadastrar = new RoundButton("Cadastrar");
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.BOLD, 13));
		btnCadastrar.setBackground(new Color(8, 127, 140));
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario user = new Usuario();

				String Nome = txtNome.getText();
				String CPF = txtCPF.getText();
				String Email = txtEmail.getText();
				String Senha = txtSenha.getText();

				if (!Nome.isEmpty() || !CPF.isEmpty() || !Email.isEmpty() || !Senha.isEmpty()) {

					user.setNome(Nome);
					user.setCpf(CPF);
					user.setEmail(Email);
					user.setSenha(Senha);
					uDAO.inserirUsuario(user);
					System.out.println("User inserido!");
					TelaPerfil perfil = new TelaPerfil();
					perfil.setLocationRelativeTo(null);
					perfil.setVisible(true);
					dispose();

				} else {
					TelaError erro = new TelaError();

					System.out.println("Campo vazio");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}

			}
		});

		JLabel lblJaTemConta = new JLabel("Já tem uma conta? Acesse Aqui.");
		lblJaTemConta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblJaTemConta.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblJaTemConta.setForeground(new Color(0, 92, 214));
		lblJaTemConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin frame = new TelaLogin();

				setVisible(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
			
		});
		SpringLayout sl_PainelBTN = new SpringLayout();
		sl_PainelBTN.putConstraint(SpringLayout.NORTH, lblJaTemConta, 3, SpringLayout.SOUTH, btnCadastrar);
		sl_PainelBTN.putConstraint(SpringLayout.WEST, lblJaTemConta, 0, SpringLayout.WEST, btnCadastrar);
		sl_PainelBTN.putConstraint(SpringLayout.NORTH, btnCadastrar, 0, SpringLayout.NORTH, PainelBTN);
		sl_PainelBTN.putConstraint(SpringLayout.WEST, btnCadastrar, 97, SpringLayout.WEST, PainelBTN);
		sl_PainelBTN.putConstraint(SpringLayout.SOUTH, btnCadastrar, 57, SpringLayout.NORTH, PainelBTN);
		sl_PainelBTN.putConstraint(SpringLayout.EAST, btnCadastrar, 326, SpringLayout.WEST, PainelBTN);
		PainelBTN.setLayout(sl_PainelBTN);
		PainelBTN.add(btnCadastrar);
		PainelBTN.add(lblJaTemConta);
		PainelKSF.setOpaque(false);
		PainelKSF.setLayout(null);

	}
}
