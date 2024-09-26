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

import modelo.RoundButton2;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEsqueceuSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		setMinimumSize(new Dimension(600, 480));
		setMaximumSize(new Dimension(600, 480));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		PicPanel panel = new PicPanel("src//IMG/TelaEsqueceuSenha2.png");
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][400.00,grow][grow 150]", "[grow][200.00,grow][80px:80.00,grow][480,grow]"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel.add(panel_4, "cell 1 0,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, "cell 1 2,grow");
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, "cell 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[145.00px][329.00px][124px][-21.00px]", "[18px][][][22.00][][][][27.00][][28.00][30.00][]"));
		
		JLabel lblNewLabel_2 = new JLabel(" Recuperação de Senha");
		panel_3.add(lblNewLabel_2, "cell 1 0,alignx center,aligny center");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblApsInserirSeu = new JLabel("Após inserir seu email enviaremos um codigo para acesssar a sua conta.");
		lblApsInserirSeu.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_3.add(lblApsInserirSeu, "cell 1 3,alignx left,aligny center");
		
		JLabel lblNewLabel = new JLabel("Digite seu email no campo a baixo:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		panel_3.add(lblNewLabel, "cell 1 8,alignx left,aligny center");
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.add(textField, "flowx,cell 1 9,grow");
		
		JButton btnEnviar = new RoundButton2 ("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnEnviar, "cell 1 10,alignx right");
		btnEnviar.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnEnviar.setBackground(new Color(2, 73, 89));
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setBorderPainted(false);
		btnEnviar.setBorder(new LineBorder(new Color(2, 73, 89), 2, true));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2, "cell 2 3,grow");

		
	
	}
}
