package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class TelaPerfilCliente extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 1117, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150][grow][][150][200][grow][][][][][][70][][][][][][grow][][][][200][][][][][][][][][][][][grow][grow][][][][][][][][][][]", "[50,grow][][][][][][][][][grow][][][][][][][grow][][][][][][][][][][][50][50][grow][][][][][][50][][50][][][][][][][][][][80][170][][][][][20]"));
		ImageIcon carrinho = new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon notificacao = new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 220));
		contentPane.add(panel, "cell 0 0 45 1,growx");
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][300][][][][][][][][][300][][][][150][][][100][][][][][][][][]", "[][]"));
		ImageIcon menu = new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		JLabel imgMenu = new JLabel("");
		panel.add(imgMenu, "cell 1 0");
		imgMenu.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/menu-hamburguer.png")));
		imgMenu.setIcon(new ImageIcon(iconMenu));
		
		JLabel imgCarrinho = new JLabel("");
		panel.add(imgCarrinho, "cell 33 0");
		imgCarrinho.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png")));
		imgCarrinho.setIcon(new ImageIcon(imgC));
		
		JLabel imgNotificacao = new JLabel("");
		panel.add(imgNotificacao, "cell 34 0");
		imgNotificacao.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/sino.png")));
		imgNotificacao.setIcon(new ImageIcon(imgN));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 9 45 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][][][][][200][][][]", "[][]"));
		
		JLabel lblNome = new JLabel("Maria Querida Souza");
		panel_1.add(lblNome, "cell 15 0");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "cell 0 10 11 44,grow");
		panel_2.setLayout(new MigLayout("", "[][50][120][50][][][][90][][][][][][][]", "[][80][][][][][][][][20][][45][][][20][-14.00][][][][][]"));
		
		JLabel lblFotoDPerfil = new JLabel("Editar foto de perfil");
		lblFotoDPerfil.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblFotoDPerfil, "cell 2 5,alignx left");
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblEmail, "cell 9 5,growx");
		
		JLabel lblEmailCliente = new JLabel("");
		lblEmailCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblEmailCliente, "cell 9 6 5 1");
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblDescricao, "cell 2 10,alignx left");
		
		JLabel lblCPF = new JLabel("CPF: ");
		lblCPF.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblCPF, "cell 9 10,aligny center");
		
		JLabel lblCPFcliente = new JLabel("");
		lblCPFcliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblCPFcliente, "cell 9 11 5 1,alignx left,aligny top");
		
		JLabel lblDescCliente = new JLabel("");
		lblDescCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_2.add(lblDescCliente, "cell 2 11 2 2,alignx left,aligny top");
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "cell 11 10 33 44,grow");
		panel_3.setLayout(new MigLayout("", "[][][][][100][][][][100][][100][50][]", "[][40][][50][][50][][][][100][][80][][][100][]"));
		
		JLabel lblInfoPagamento = new JLabel("Informaçoes de pagamento");
		lblInfoPagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_3.add(lblInfoPagamento, "cell 8 1");
		
		
		JButton bntEditar = new JButton("Editar");
		bntEditar.setBackground(new Color(154, 205, 220));
		bntEditar.setForeground(new Color(0, 0, 0));
		bntEditar.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_3.add(bntEditar, "cell 12 15");
		
	}

}
