package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaEsqueceuSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 TelaEsqueceuSenha frame = new TelaEsqueceuSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaEsqueceuSenha() {
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
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][][][][][][][][][grow][]", "[][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblProblemas = new JLabel("Problemas Para Entrar?  ");
		lblProblemas.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProblemas.setForeground(Color.BLACK);
		panel_2.add(lblProblemas, "cell 10 2,alignx center");
		
		JLabel lblMsgEmail = new JLabel("Insira seu email e enviaremos um código para acessar sua conta.");
		lblMsgEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblMsgEmail, "cell 10 6,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		panel_2.add(lblNewLabel_1, "cell 10 9");
		
		txtEmail = new JTextField();
		panel_2.add(txtEmail, "cell 10 10,growx");
		txtEmail.setColumns(10);
		
		JButton bntCodigo = new JButton("Enviar código para login ");
		panel_2.add(bntCodigo, "cell 10 12,alignx center");
		
		JLabel lblCriarConta = new JLabel("Criar nova conta");
		lblCriarConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblCriarConta, "cell 10 15,alignx center");
		
		JLabel lblou = new JLabel("ou");
		panel_2.add(lblou, "cell 10 17,alignx center");
		
		JLabel lblVoltarLogin = new JLabel("Voltar ao login");
		lblVoltarLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblVoltarLogin, "cell 10 19,alignx center");
	}
}
		