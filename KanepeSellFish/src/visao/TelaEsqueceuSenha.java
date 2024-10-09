package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import modelo.EnvioDeEmail;
import modelo.RoundButton2;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;



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

	/**
	 * Create the frame.
	 */
	public TelaEsqueceuSenha() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(500, 600));
		setMaximumSize(new Dimension(500, 600));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		PicPanel panel = new PicPanel("src//IMG/TelaEsqueceuSenha2.png");
		panel.setForeground(new Color(60, 60, 60));
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 38, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 105, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, -105, SpringLayout.EAST, panel);
		panel_3.setOpaque(false);
		panel.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Recuperação de senha");
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, panel_3);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		panel_3.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 185, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -28, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel_3);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -105, SpringLayout.EAST, panel);
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][][grow][][]", "[][][][][][]"));
		
		JLabel label = new JLabel("       ");
		panel_1.add(label, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel(" Informe o e-mail para o qual deseja ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1, "cell 2 0,alignx center");
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 242, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_3);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel_3);
		panel_2.setOpaque(false);
		
		JLabel lblNewLabel_1_1 = new JLabel(" redefinir sua senha.");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1_1, "cell 2 1,alignx center");
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 54, 254, 30);
		panel_2.add(txtEmail);
		txtEmail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtEmail.setOpaque(false);
		txtEmail.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -107, SpringLayout.NORTH, panel_1_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel_1_1);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1_1, 343, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1_1, -99, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1_1, 0, SpringLayout.WEST, panel_3);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1_1, 0, SpringLayout.EAST, panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Email<span style='color: red;'>*</span></html>");
		lblNewLabel_2.setBounds(10, 32, 36, 16);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2.add(lblNewLabel_2);
		panel_1_1.setOpaque(false);
		panel.add(panel_1_1);
		SpringLayout sl_panel_1_1 = new SpringLayout();
		panel_1_1.setLayout(sl_panel_1_1);
		
		RoundButton2 btnCadastrar = new RoundButton2("Enviar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			EnvioDeEmail enviar = new EnvioDeEmail();
				
			
			}
		});
		sl_panel_1_1.putConstraint(SpringLayout.NORTH, btnCadastrar, 10, SpringLayout.NORTH, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.WEST, btnCadastrar, 85, SpringLayout.WEST, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.EAST, btnCadastrar, -85, SpringLayout.EAST, panel_1_1);
		btnCadastrar.setText("Enviar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setBorder(new LineBorder(new Color(2, 73, 89), 2, true));
		btnCadastrar.setBackground(new Color(2, 73, 89));
		panel_1_1.add(btnCadastrar);
		
		JLabel lblNoPossuiUma = new JLabel("Não Possui uma conta?");
		sl_panel_1_1.putConstraint(SpringLayout.SOUTH, btnCadastrar, -6, SpringLayout.NORTH, lblNoPossuiUma);
		sl_panel_1_1.putConstraint(SpringLayout.NORTH, lblNoPossuiUma, 47, SpringLayout.NORTH, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.WEST, lblNoPossuiUma, 35, SpringLayout.WEST, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.EAST, lblNoPossuiUma, 174, SpringLayout.WEST, panel_1_1);
		lblNoPossuiUma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoPossuiUma.setForeground(Color.BLACK);
		lblNoPossuiUma.setFont(new Font("Dialog", Font.PLAIN, 13));
		panel_1_1.add(lblNoPossuiUma);
		
		JLabel lblCadastrese = new JLabel(" Cadastre-se");
		sl_panel_1_1.putConstraint(SpringLayout.WEST, lblCadastrese, -99, SpringLayout.EAST, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.EAST, lblCadastrese, -25, SpringLayout.EAST, panel_1_1);
		lblCadastrese.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrese.setForeground(new Color(0, 92, 214));
		lblCadastrese.setFont(new Font("Dialog", Font.PLAIN, 13));
		panel_1_1.add(lblCadastrese);
		
		JLabel lblLembraDaSenha = new JLabel("Lembra da senha?");
		sl_panel_1_1.putConstraint(SpringLayout.SOUTH, lblNoPossuiUma, -6, SpringLayout.NORTH, lblLembraDaSenha);
		sl_panel_1_1.putConstraint(SpringLayout.NORTH, lblLembraDaSenha, -48, SpringLayout.SOUTH, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.SOUTH, lblLembraDaSenha, -30, SpringLayout.SOUTH, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.WEST, lblLembraDaSenha, 68, SpringLayout.WEST, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.EAST, lblLembraDaSenha, 175, SpringLayout.WEST, panel_1_1);
		lblLembraDaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLembraDaSenha.setForeground(Color.BLACK);
		lblLembraDaSenha.setFont(new Font("Dialog", Font.PLAIN, 13));
		panel_1_1.add(lblLembraDaSenha);
		
		JLabel lblLogin = new JLabel(" Login");
		sl_panel_1_1.putConstraint(SpringLayout.NORTH, lblLogin, 71, SpringLayout.NORTH, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.NORTH, lblCadastrese, -24, SpringLayout.NORTH, lblLogin);
		sl_panel_1_1.putConstraint(SpringLayout.WEST, lblLogin, 175, SpringLayout.WEST, panel_1_1);
		sl_panel_1_1.putConstraint(SpringLayout.SOUTH, lblCadastrese, -6, SpringLayout.NORTH, lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setForeground(new Color(0, 92, 214));
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 13));
		panel_1_1.add(lblLogin);

		
	
	}
}
