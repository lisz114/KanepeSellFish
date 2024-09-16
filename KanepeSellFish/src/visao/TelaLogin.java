package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		PicPanel panel = new PicPanel("src//IMG/Background2.0.png");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][grow][][][][][][]", "[100px][50px][][50px][][][][][][][][][][grow][][][grow][][grow][][][][][][]"));
		panel_1.setOpaque(false);
		panel_2.setOpaque(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 60, 0, 50));
		panel_1.add(panel_3, "cell 3 1,alignx center,growy");
		panel_3.setOpaque(false);
		
		
		JLabel lblTelaLogin = new JLabel("Bem Vindo de Volta!");
		lblTelaLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(21)
					.addComponent(lblTelaLogin, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTelaLogin)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 115, 0, 115));
		panel_1.add(panel_4, "cell 3 6,grow"); 
		panel_4.setOpaque(false);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtemail = new JTextField();
		txtemail.setBackground(Color.WHITE);
		txtemail.setColumns(10);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		panel_4.add(lblEmail);
		panel_4.add(txtemail);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 115, 0, 115));
		panel_1.add(panel_5, "cell 3 11,grow");
		panel_5.setOpaque(false);
		
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setVerticalAlignment(SwingConstants.BOTTOM);
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			txtSenha = new JTextField();
			txtSenha.setColumns(10);
			panel_5.setLayout(new GridLayout(0, 1, 0, 0));
			panel_5.add(lblSenha);
			panel_5.add(txtSenha);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 60, 0, 50));
		panel_1.add(panel_6, "cell 3 13,alignx right,growy");
		panel_6.setOpaque(false);
		
		JLabel lblSenhaEsquecida = new JLabel("Esqueceu a senha?");
		lblSenhaEsquecida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEsqueceuSenha frame = new TelaEsqueceuSenha();

				setVisible(false);				 
				frame.setVisible(true);
			}
		});
		panel_6.add(lblSenhaEsquecida);
		lblSenhaEsquecida.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblSenhaEsquecida.setForeground(Color.BLUE);
		lblSenhaEsquecida.setBackground(new Color(0, 0, 255));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, "cell 3 16,grow");
		panel_7.setOpaque(false);
		
		JButton bntEntrar = new JButton("Entrar");
		bntEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//tela dps de logar
			}
		});
		panel_7.add(bntEntrar);
		bntEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntEntrar.setBackground(new Color(0, 139, 139));
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8, "cell 3 17,grow");
		panel_8.setOpaque(false);
		
		JLabel lblCadastrese = new JLabel("Não possui uma conta?  Cadastre-se.");
		lblCadastrese.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastro frame = new TelaCadastro();

				setVisible(false);				 
				frame.setVisible(true);
			}
		});
		panel_8.add(lblCadastrese);
		lblCadastrese.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCadastrese.setForeground(Color.BLUE);
	}
		
}
