package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.UsuarioDAO;

import java.awt.Color;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import modelo.RoundButton;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExtra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTel;
	private JTextField txtCity;
	private JTextField txtBar;
	private JTextField txtRua;
	private JTextField txtNE;
	private static UsuarioDAO uDAO = UsuarioDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExtra frame = new TelaExtra(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user 
	 */
	public TelaExtra(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 217));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setOpaque(false);
		panel.setLayout(new MigLayout("", "[][grow][][grow][][]", "[][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		panel.add(lblNewLabel, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		panel.add(lblNewLabel_1, "cell 3 1");
		
		txtTel = new JTextField();
		txtTel.setBackground(new Color(96, 154, 168));
		panel.add(txtTel, "cell 1 2,growx");
		txtTel.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBackground(new Color(96, 154, 168));
		panel.add(txtCity, "cell 3 2,growx");
		txtCity.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nome Empresa:");
		panel.add(lblNewLabel_4, "cell 1 4");
		
		JLabel lblNewLabel_2 = new JLabel("Bairro:");
		panel.add(lblNewLabel_2, "cell 3 4");
		
		txtNE = new JTextField();
		txtNE.setBackground(new Color(96, 154, 168));
		panel.add(txtNE, "cell 1 5,growx");
		txtNE.setColumns(10);
		
		txtBar = new JTextField();
		txtBar.setBackground(new Color(96, 154, 168));
		panel.add(txtBar, "cell 3 5,growx");
		txtBar.setColumns(10);
		
		JButton btnNewButton = new RoundButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tel = txtTel.getText();
				String nomeEmp = txtNE.getText();
				String city = txtCity.getText();
				String bar = txtBar.getText();
				String rua = txtRua.getText();
				
				user.setTel(tel);
				user.setNempresa(nomeEmp);
				user.setCidade(city);
				user.setBairro(bar);
				user.setRua(rua);
				uDAO.atualizarUsuario(user);
				
				TelaPerfil perfil = new TelaPerfil(user);
				perfil.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(2, 73, 89));
		panel.add(btnNewButton, "cell 1 7,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Rua:");
		panel.add(lblNewLabel_3, "cell 3 7");
		
		txtRua = new JTextField();
		txtRua.setBackground(new Color(96, 154, 168));
		panel.add(txtRua, "cell 3 8,growx");
		txtRua.setColumns(10);
		
		JButton btnNewButton_1 = new RoundButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		panel.add(btnNewButton_1, "cell 1 9,alignx center");
	}

}
