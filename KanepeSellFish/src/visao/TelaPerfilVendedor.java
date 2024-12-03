package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.ProdutorDAO;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaPerfilVendedor extends JFrame {

	private JPanel contentPane;
	private ArrayList<Usuario> listaUsuarios;
	JPanel panelLeft;
	private ProdutorDAO pDAO = ProdutorDAO.getInstancia();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPerfilVendedor frame = new TelaPerfilVendedor(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param u
	 * 
	 * @param tela
	 */
	public TelaPerfilVendedor(Usuario u, boolean isVendedor) {

		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 208, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[10px][1120px][10px][10px][10px]", "[30px]"));

		JButton btnMenu = new JButton("");
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLeft.isVisible()) {
					panelLeft.setVisible(false);
				} else {
					panelLeft.setVisible(true);
				}
			}
		});
		btnMenu.setBorder(null);
		btnMenu.setBackground(SystemColor.control);
		btnMenu.setOpaque(false);
		panel.add(btnMenu, "cell 0 0,grow");
		ImageIcon iconMenu = new ImageIcon(TelaPerfilVendedor.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconM = iconMenu.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnMenu.setIcon(new ImageIcon(iconM));

		JButton btnCarrinho = new JButton("");
		btnCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCarrinho.setOpaque(false);
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCarrinho carrinho = new TelaCarrinho(u, null,  isVendedor);
				carrinho.setLocationRelativeTo(null);
				carrinho.setVisible(true);
				dispose();
			}
		});
		btnCarrinho.setBorder(null);
		btnCarrinho.setBackground(SystemColor.control);
		panel.add(btnCarrinho, "cell 2 0,grow");
		ImageIcon iconCarrinho = new ImageIcon(TelaPerfilVendedor.class.getResource("/IMG/carrinho-de-compras.png"));
		Image iconC = iconCarrinho.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnCarrinho.setIcon(new ImageIcon(iconC));

		JButton btnSininho = new JButton("");
		btnSininho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSininho.setOpaque(false);
		btnSininho.setBorder(null);
		btnSininho.setBackground(SystemColor.control);
		panel.add(btnSininho, "cell 3 0,grow");
		ImageIcon iconSininho = new ImageIcon(TelaPerfilVendedor.class.getResource("/IMG/sino.png"));
		Image iconS = iconSininho.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnSininho.setIcon(new ImageIcon(iconS));

		JButton btnFlecha = new JButton("");
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaInicio inicio = new TelaInicio(u, isVendedor);
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
				dispose();
			}
		});
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFlecha.setOpaque(false);
		btnFlecha.setBorder(null);
		btnFlecha.setBackground(SystemColor.control);
		panel.add(btnFlecha, "cell 4 0,grow");
		ImageIcon iconFlecha = new ImageIcon(TelaPerfilVendedor.class.getResource("/IMG/saida.png"));
		Image iconF = iconFlecha.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnFlecha.setIcon(new ImageIcon(iconF));

		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(154, 208, 217));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[100px]", "[50px][50px][50px][50px]"));

		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicio tiv = new TelaInicio(u, isVendedor);
				tiv.setLocationRelativeTo(null);
				tiv.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(154, 205, 217));
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		panelLeft.add(btnNewButton, "cell 0 0,grow");

		JButton btnNewButton_1 = new JButton("Carrinho");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCarrinho carrinho = new TelaCarrinho(u, null,  isVendedor);
				carrinho.setLocationRelativeTo(null);
				carrinho.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(154, 205, 217));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		panelLeft.add(btnNewButton_1, "cell 0 1,grow");

		JButton btnNewButton_2 = new JButton("Perfil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton_2.setBackground(new Color(96, 154, 168));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setOpaque(true);
		panelLeft.add(btnNewButton_2, "cell 0 2,grow");

		JButton btnNewButton_3 = new JButton("Estoque");
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaEstoque frame = new TelaEstoque(u);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();

			}
		});
		btnNewButton_3.setBackground(new Color(154, 205, 217));
		btnNewButton_3.setBorder(null);
		panelLeft.add(btnNewButton_3, "cell 0 3,grow");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[][][][][][][grow][40px]"));
		
		JLabel imgUsuario = new JLabel("");
		imgUsuario.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/Avatar.png")));
		panel_1.add(imgUsuario, "cell 0 2,alignx center,aligny center");
		
		JLabel lblNomeUsuario = new JLabel();
		lblNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeUsuario.setFont(new Font("Dialog", Font.PLAIN, 30));
		panel_1.add(lblNomeUsuario, "flowy,cell 1 2,alignx left,aligny top");
		lblNomeUsuario.setText(u.getNome());
		
		JLabel lblInfoC = new JLabel("Informações sobre  o comércio:");
		lblInfoC.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblInfoC, "cell 2 2,alignx left,aligny bottom");
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblEndereco, "cell 3 2,aligny bottom");
		
		JLabel lblEditarFt = new JLabel("Editar Foto de Perfil");
		lblEditarFt.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblEditarFt.setForeground(SystemColor.textHighlight);
		panel_1.add(lblEditarFt, "cell 0 3,alignx center");
		
		JLabel lblNomeComercio = new JLabel("");
		lblNomeComercio.setFont(new Font("Dialog", Font.PLAIN, 18));
		panel_1.add(lblNomeComercio, "cell 1 2,alignx left,aligny center");
		lblNomeComercio.setText(pDAO.consultaProdutor(u).getNomeComercio());
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblEmail, "flowx,cell 1 3,alignx left,aligny bottom");
		
		JLabel txtEmail = new JLabel("");
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(txtEmail, "cell 1 3,alignx center,aligny bottom");
		txtEmail.setText(u.getEmail());
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblCpf, "flowx,cell 1 4");
		
		JLabel txtCpf = new JLabel("");
		txtCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(txtCpf, "cell 1 4");
		txtCpf.setText(u.getCpf());
		
		JLabel lblInfoComercio = new JLabel("Informações pessoais:");
		lblInfoComercio.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblInfoComercio, "cell 1 2,alignx left,aligny center");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblTelefone, "flowx,cell 1 5");
		
		JLabel txtTelefone = new JLabel("Adicionar Telefone");
		txtTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(txtTelefone, "cell 1 5");
		
		JLabel lblNomeC = new JLabel("Nome do Comércio:");
		lblNomeC.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblNomeC, "flowx,cell 2 3,aligny bottom");
		
		JLabel lblCnpj = new JLabel("Cnpj:");
		lblCnpj.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(lblCnpj, "flowx,cell 2 4,aligny bottom");
		
		JLabel txtCnpj = new JLabel("");
		txtCnpj.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(txtCnpj, "cell 2 4,aligny bottom");
		txtCnpj.setText(pDAO.consultaProdutor(u).getCnpj());
		
		JLabel txtNomeC = new JLabel("");
		txtNomeC.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_1.add(txtNomeC, "cell 2 3,aligny bottom");
		txtNomeC.setText(pDAO.consultaProdutor(u).getNomeComercio());
		
		JButton bntEditar = new JButton(" Alterar informações ");
		bntEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaEditarPerfilVendedor editar = new TelaEditarPerfilVendedor(u);
				editar.setVisible(true);
				editar.setLocationRelativeTo(null);
				dispose();
			}
		});
		bntEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntEditar.setFont(new Font("Dialog", Font.PLAIN, 13));
		bntEditar.setBackground(new Color(2, 73, 89));
		bntEditar.setBackground(new Color(96, 154, 168));
		bntEditar.setBorderPainted(false);
		bntEditar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.add(bntEditar, "cell 4 7,alignx center");

	}
}
