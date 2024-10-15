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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		contentPane.setLayout(new MigLayout("", "[150][grow]", "[50][grow]"));
		ImageIcon carrinho = new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon notificacao = new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 220));
		contentPane.add(panel, "cell 0 0 2 1,growx");
		panel.setLayout(new MigLayout("", "[][905.00][][][]", "[grow][]"));
		ImageIcon menu = new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		JLabel imgMenu = new JLabel("");
		panel.add(imgMenu, "cell 0 0");
		imgMenu.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/menu-hamburguer.png")));
		imgMenu.setIcon(new ImageIcon(iconMenu));

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TelaCarrinho frame = new TeaCarrinho
				
				//frame.setLocationRelativeTo(null);
				//frame.setVisible(true);
				//dispose();
			}
		});
		panel.add(imgCarrinho, "cell 2 0");
		imgCarrinho.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/carrinho-de-compras.png")));
		imgCarrinho.setIcon(new ImageIcon(imgC));

		JLabel imgNotificacao = new JLabel("");
		panel.add(imgNotificacao, "cell 3 0");
		imgNotificacao.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/sino.png")));
		imgNotificacao.setIcon(new ImageIcon(imgN));

		JLabel imgLogoff = new JLabel("");
		imgLogoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin frame = new TelaLogin();

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		imgLogoff.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/img/saida.png")));
		panel.add(imgLogoff, "cell 4 0");
		ImageIcon deslogar = new ImageIcon(TelaPerfilCliente.class.getResource("/img/saida.png"));
		Image imgD = deslogar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgLogoff.setIcon(new ImageIcon(imgD));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(
				new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][][][][][]"));
				
						JLabel lblNome = new JLabel("Maria Querida Souza");
						panel_1.add(lblNome, "cell 10 1,alignx right");
						lblNome.setFont(new Font("Dialog", Font.PLAIN, 30));
						
								JLabel lblInfoPagamento = new JLabel("Informaçoes de pagamento");
								panel_1.add(lblInfoPagamento, "cell 19 4");
								lblInfoPagamento.setFont(new Font("Dialog", Font.PLAIN, 12));
								
										JLabel lblFotoDPerfil = new JLabel("Editar foto de perfil");
										panel_1.add(lblFotoDPerfil, "cell 1 6");
										lblFotoDPerfil.setFont(new Font("Dialog", Font.PLAIN, 12));
						
								JLabel lblEmail = new JLabel("Email:");
								panel_1.add(lblEmail, "cell 7 7");
								lblEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
				
						JLabel lblDescricao = new JLabel("Descrição");
						panel_1.add(lblDescricao, "cell 1 9");
						lblDescricao.setFont(new Font("Dialog", Font.PLAIN, 12));
						
								JLabel lblCPF = new JLabel("CPF: ");
								panel_1.add(lblCPF, "cell 7 9");
								lblCPF.setFont(new Font("Dialog", Font.PLAIN, 12));

	}

}
