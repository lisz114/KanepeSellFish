package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaCadastro2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro2 frame = new TelaCadastro2();
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
	public TelaCadastro2() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		PicPanel panel = new PicPanel("src//IMG/TelaCadastro.png");
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		panel.add(panelPrincipal);
		panelPrincipal.setLayout(new MigLayout("", "[grow]", "[100px][100px][70px][70px][70px][70px]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panelPrincipal.add(panel_2, "cell 0 0,grow");
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panelPrincipal.add(panel_4, "cell 0 1,grow");
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Crie uma conta");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new EmptyBorder(0, 30, 0, 30));
		panelNome.setOpaque(false);
		panelPrincipal.add(panelNome, "cell 0 2,grow");
		panelNome.setLayout(new MigLayout("", "[grow]", "[10px][30px]"));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panelNome.add(lblNewLabel_1, "cell 0 0");
		
		textField = new JTextField();
		panelNome.add(textField, "cell 0 1,grow");
		textField.setColumns(10);
		
		JPanel panelCpf = new JPanel();
		panelCpf.setOpaque(false);
		panelPrincipal.add(panelCpf, "cell 0 3,grow");
		panelCpf.setLayout(new MigLayout("", "[grow]", "[10px][30px]"));
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		panelCpf.add(lblNewLabel_1_1, "cell 0 0");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panelCpf.add(textField_1, "cell 0 1,grow");
		
		JPanel panelEmail = new JPanel();
		panelEmail.setOpaque(false);
		panelPrincipal.add(panelEmail, "cell 0 4,grow");
		panelEmail.setLayout(new MigLayout("", "[grow]", "[10px][30px]"));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		panelEmail.add(lblNewLabel_1_1_1, "cell 0 0");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panelEmail.add(textField_2, "cell 0 1,grow");
		
		JPanel panelSenha = new JPanel();
		panelSenha.setBorder(new EmptyBorder(0, 40, 0, 40));
		panelSenha.setOpaque(false);
		panelPrincipal.add(panelSenha, "cell 0 5,grow");
		panelSenha.setLayout(new MigLayout("", "[grow]", "[10px][30px]"));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("New label");
		panelSenha.add(lblNewLabel_1_1_2, "cell 0 0");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panelSenha.add(textField_3, "cell 0 1,grow");
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3);
	}

}
