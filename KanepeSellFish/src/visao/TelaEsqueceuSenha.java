package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controle.UsuarioDAO;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaEsqueceuSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JTextField txtSenha;
	UsuarioDAO udao = UsuarioDAO.getInstancia();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					 TelaEsqueceuSenha frame = new TelaEsqueceuSenha(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public TelaEsqueceuSenha(Usuario u) {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 487);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		PicPanel panel = new PicPanel("src//IMG/Background2.0.png");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow 10][70px,grow 1]", "[70px][80px][30px][][30px][10px][30px][25][10px][30px][60px][][][]"));
		
		JLabel lblTitulo = new JLabel("Problemas para entrar? ");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 27));
		panel.add(lblTitulo, "cell 1 1,alignx center");

		JLabel lblMsgEmail = new JLabel("Vamos criar uma nova senha!");
		panel.add(lblMsgEmail, "cell 1 3,alignx center");
		lblMsgEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblMsgEmail.setForeground(new Color(0, 0, 0));

		JLabel lblCriarConta = new JLabel("Criar nova conta");
		lblCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setVisible(true);
				cadastro.setLocationRelativeTo(null);
				dispose();
			}
		});
		
				JButton bntCodigo = new JButton("Enviar");
				bntCodigo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String email = txtEmail.getText();
						String senha = txtSenha.getText();
						if (email.isEmpty()) {
							lblFeedback.setText("Por favor, insira um email");
						} else {
							udao.alterarSenha( senha,  email);
							lblFeedback.setText("Senha Alterada com sucesso! Volte ao Login");
						}
					}
				});
		
				JLabel lblEmail = new JLabel("Email: ");
				lblEmail.setForeground(Color.BLACK); // Define a cor do texto principal
				lblEmail.setFont(new Font("Dialog", Font.BOLD, 12)); // Define a fonte
				panel.add(lblEmail, "cell 1 5,alignx left");
		
		JLabel lblNewLabel = new JLabel("Nova Senha:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblNewLabel, "cell 1 8");
		
		txtSenha = new JTextField();
		txtSenha.setOpaque(false);
		txtSenha.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(txtSenha, "cell 1 9,grow");
				
		lblCriarConta.setForeground(new Color(0, 0, 0));
		lblCriarConta.setBackground(new Color(0, 0, 255));
		panel.add(lblCriarConta, "cell 1 11,alignx center");
		lblCriarConta.setFont(new Font("Dialog", Font.ITALIC, 14));

		JLabel lblou = new JLabel("ou");
		lblou.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel.add(lblou, "cell 1 12,alignx center");
	
		JLabel lblVoltarLogin = new JLabel("Voltar ao login");
		lblVoltarLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin login = new TelaLogin();

				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblVoltarLogin.setForeground(new Color(0, 0, 0));
		panel.add(lblVoltarLogin, "cell 1 13,alignx center");
		lblVoltarLogin.setFont(new Font("Dialog", Font.ITALIC, 14));
		
				txtEmail = new JTextField();
				txtEmail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				txtEmail.setOpaque(false);
				panel.add(txtEmail, "cell 1 6,grow");
				txtEmail.setColumns(10);

	}
}