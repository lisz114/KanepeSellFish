package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controle.UsuarioDAO;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import modelo.RoundButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

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
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		PicPanel panel = new PicPanel("src//IMG/Background2.0.png");
		panel.setForeground(SystemColor.desktop);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow 10][100px,grow 1]", "[70px][80px][30px][][30px][10px][30px][25][10px][30px][60px][][][]"));

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

		RoundButton rndbtnConfirma = new RoundButton(" Confirmar ");
		rndbtnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(txtSenha.getText());
				String email = String.valueOf(txtEmail.getText());

				if (senha.isEmpty() || email.isEmpty()) {
					TelaError erro = new TelaError();
					erro.setVisible(true);
					erro.setLocationRelativeTo(null);

				} else {
					udao.alterarSenha(senha, email);
					TelaVoltarLogin voltar = new TelaVoltarLogin();
					voltar.setVisible(true);
					voltar.setLocationRelativeTo(null);

				}
			}
		});
		rndbtnConfirma.setText(" Confirmar ");
		rndbtnConfirma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rndbtnConfirma.setForeground(Color.WHITE);
		rndbtnConfirma.setFont(new Font("Dialog", Font.PLAIN, 22));
		rndbtnConfirma.setBorderPainted(false);
		rndbtnConfirma.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rndbtnConfirma.setBackground(new Color(2, 73, 89));
		panel.add(rndbtnConfirma, "cell 1 10,alignx center");

		lblCriarConta.setForeground(SystemColor.desktop);
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
		lblVoltarLogin.setForeground(SystemColor.desktop);
		panel.add(lblVoltarLogin, "cell 1 13,alignx center");
		lblVoltarLogin.setFont(new Font("Dialog", Font.ITALIC, 14));

		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtEmail.setOpaque(false);
		panel.add(txtEmail, "cell 1 6,grow");
		txtEmail.setColumns(10);

	}
}