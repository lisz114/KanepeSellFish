package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaPerfilCliente extends JFrame {

	private JPanel contentPane;
	JPanel panelMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TelaPerfilCliente frame = new TelaPerfilCliente(null);
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
	public TelaPerfilCliente(Usuario u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150,grow][grow]", "[50][grow]"));
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
		imgMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelMenu.isVisible()) {
					panelMenu.setVisible(false);
				}else {
					panelMenu.setVisible(true);
				}
			}
		});
		panel.add(imgMenu, "cell 0 0");
		imgMenu.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/IMG/menu-hamburguer.png")));
		imgMenu.setIcon(new ImageIcon(iconMenu));

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 TelaCarrinho frame = new TelaCarrinho();
				 frame.setLocationRelativeTo(null);
				 frame.setVisible(true);
				 
				 dispose();
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(154, 205, 217));
		contentPane.add(panelMenu, "cell 0 1,grow");
		panelMenu.setLayout(new MigLayout("", "[grow]", "[50px][50px][50px][]"));
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicio tela = new TelaInicio(u, null);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				
				dispose();
			}});
		btnInicio.setBackground(new Color(154, 205, 217));
		btnInicio.setBorder(null);
		btnInicio.setOpaque(false);
		panelMenu.add(btnInicio, "cell 0 0,growx");
		
		JButton btnCarrinho = new JButton("Carrinho");
		btnCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCarrinho tela = new TelaCarrinho();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				
				dispose();
			}
		});
		btnCarrinho.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCarrinho.setBackground(new Color(154, 205, 217));
		btnCarrinho.setBorder(null);
		btnCarrinho.setOpaque(false);
		panelMenu.add(btnCarrinho, "cell 0 1,alignx center,growy");
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPerfil.setBackground(new Color(154, 205, 217));
		btnPerfil.setBorder(null);
		btnPerfil.setOpaque(false);
		panelMenu.add(btnPerfil, "cell 0 2,alignx center,growy");
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][][598.00]", "[100][][][][][][][253.00]"));
		
		ImageIcon perfil = new ImageIcon(TelaPerfilCliente.class.getResource("/img/do-utilizador.png"));
		Image imgFP = perfil.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);

		JLabel lblNome = new JLabel(u.getNome());
		panel_1.add(lblNome, "cell 3 0");

		JLabel imgFotoPerfil = new JLabel("");
		imgFotoPerfil.setIcon(new ImageIcon(TelaPerfilCliente.class.getResource("/img/do-utilizador.png")));
		panel_1.add(imgFotoPerfil, "cell 1 1,alignx center");
		imgFotoPerfil.setIcon(new ImageIcon(imgFP));

		JLabel lblFotoDPerfil = new JLabel("Editar foto de perfil ");
		lblFotoDPerfil.setForeground(SystemColor.textHighlight);
		lblFotoDPerfil.addMouseListener(new MouseAdapter() {
		});

		JLabel lblNewLabel = new JLabel("Informações de contato:");
		panel_1.add(lblNewLabel, "cell 3 1,aligny top");

		lblFotoDPerfil.setFont(new Font("Dialog", Font.ITALIC, 12));
		panel_1.add(lblFotoDPerfil, "cell 1 2,alignx center");

		JLabel lblEmail = new JLabel("Email:");
		panel_1.add(lblEmail, "flowx,cell 3 2,alignx left");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblCPF = new JLabel("CPF: ");
		panel_1.add(lblCPF, "flowx,cell 3 4,alignx left");
		lblCPF.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblEmailvazio = new JLabel(u.getEmail());
		panel_1.add(lblEmailvazio, "cell 3 2");
		
		JLabel lblCPFvazio = new JLabel(u.getCpf());
		panel_1.add(lblCPFvazio, "cell 3 4");
		
		JButton btEditar = new JButton("Editar Perfil");
		btEditar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btEditar.setBackground(new Color(154, 205, 217));
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaEditarPerfil p = new TelaEditarPerfil(null, u);
				p.setVisible(true);
			}
		});
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(lblTelefone, "flowx,cell 3 6");
		panel_1.add(btEditar, "cell 4 7,alignx right,aligny bottom");
		
		JLabel lblTelefonevazio = new JLabel(u.getTel());
		panel_1.add(lblTelefonevazio, "cell 3 6");
		

	}
}
