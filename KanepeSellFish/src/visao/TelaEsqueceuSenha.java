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
		panel.setLayout(new MigLayout("", "[grow][][70px]", "[70px][80px][30px][][30px][][][140px][][][]"));
		txtSenha = new JTextField();
		JLabel lblProblemas = new JLabel("Problemas Para Entrar?  ");
		panel.add(lblProblemas, "cell 1 1");
		lblProblemas.setForeground(Color.BLACK);
		lblProblemas.setFont(new Font("Tahoma", Font.BOLD, 30));

		JLabel lblMsgEmail = new JLabel("Vamos criar uma nova senha!");
		panel.add(lblMsgEmail, "cell 1 3,alignx center");
		lblMsgEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblFeedback = new JLabel("");
		panel.add(lblFeedback, "cell 1 4,alignx center,aligny bottom");

		JLabel lblNewLabel_1 = new JLabel("Email: ");
		panel.add(lblNewLabel_1, "flowx,cell 1 5,alignx center");

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
						Usuario u = new Usuario();
						String email = txtEmail.getText();
						String senha = txtSenha.getText();
						if (email.isEmpty()) {
							lblFeedback.setText("Por favor, insira um email");
						} else {
							udao.alterarSenha(senha, email);
							lblFeedback.setText("Senha Alterada com sucesso! Volte ao Login");
						}
					}
				});
				
				JLabel lblNewLabel = new JLabel("Nova Senha:");
				panel.add(lblNewLabel, "flowx,cell 1 6,alignx center");
				bntCodigo.setBackground(new Color(64, 224, 208));
				panel.add(bntCodigo, "cell 1 7,alignx center");
		lblCriarConta.setForeground(new Color(0, 0, 0));
		lblCriarConta.setBackground(new Color(0, 0, 255));
		panel.add(lblCriarConta, "cell 1 8,alignx center");
		lblCriarConta.setFont(new Font("Tahoma", Font.ITALIC, 14));

		JLabel lblou = new JLabel("ou");
		panel.add(lblou, "cell 1 9,alignx center");

		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(255, 255, 255));
		panel.add(txtEmail, "cell 1 5,alignx center");
		txtEmail.setColumns(25);

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
		panel.add(lblVoltarLogin, "cell 1 10,alignx center");
		lblVoltarLogin.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
	
		panel.add(txtSenha, "cell 1 6,alignx center");
		txtSenha.setColumns(25);
	}
}

	