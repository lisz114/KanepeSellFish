package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaPerfilCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerfilCliente frame = new TelaPerfilCliente();
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
	public TelaPerfilCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150][][][150][200][][][][][70][][][][grow][][][][][][grow][][][][][][]", "[150][][][][][][][][][][50][50][][][][50][50][80][][][][][170][][][][][20]"));
		
		JLabel lblNome = new JLabel("Maria Querida Souza");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNome, "cell 5 0");
		
		JLabel lblInfoPagamento = new JLabel("Informaçoes de pagamento");
		contentPane.add(lblInfoPagamento, "cell 9 4");
		
		JLabel lblEmail = new JLabel("Email:");
		contentPane.add(lblEmail, "cell 4 10");
		
		JLabel lblFotoDPerfil = new JLabel("Editar foto de perfil");
		contentPane.add(lblFotoDPerfil, "cell 1 11,alignx center");
		
		txtEmail = new JTextField();
		contentPane.add(txtEmail, "cell 4 11,grow");
		txtEmail.setColumns(15);
		
		JLabel lblCPF = new JLabel("CPF: ");
		contentPane.add(lblCPF, "cell 4 13");
		
		txtCPF = new JTextField();
		contentPane.add(txtCPF, "cell 4 15,grow");
		txtCPF.setColumns(15);
		
		JLabel lblDescricao = new JLabel("Descrição");
		contentPane.add(lblDescricao, "cell 1 16");
		
		txtDescricao = new JTextField();
		contentPane.add(txtDescricao, "cell 1 17,growy");
		txtDescricao.setColumns(25);
		
		JButton bntEditar = new JButton("Editar");
		contentPane.add(bntEditar, "cell 20 26");
	}

}
