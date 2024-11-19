package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import modelo.RoundButton;
import net.miginfocom.swing.MigLayout;

public class TelaPerfilVendedor extends JFrame {

	private JPanel contentPane;
	private ArrayList<Usuario> listaUsuarios;
	JPanel panelLeft;

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
	 * @param u 
	 * 
	 * @param tela
	 */
	public TelaPerfilVendedor(Usuario u) {

		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 208, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[10px][1010px][10px][10px][10px]", "[30px]"));
		
		JButton btnMenu = new JButton("");
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelLeft.isVisible()) {
					panelLeft.setVisible(false);
				}else {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicioVendedor tiv = new TelaInicioVendedor();
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
		btnNewButton_1.setBackground(new Color(154, 205, 217));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		panelLeft.add(btnNewButton_1, "cell 0 1,grow");
		
		JButton btnNewButton_2 = new JButton("Perfil");
		btnNewButton_2.setBackground(new Color(154, 205, 217));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setOpaque(false);
		panelLeft.add(btnNewButton_2, "cell 0 2,grow");
		
		JButton btnNewButton_3 = new JButton("Estoque");
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
		btnNewButton_3.setOpaque(false);
		panelLeft.add(btnNewButton_3, "cell 0 3,grow");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel PanelNome = new JPanel();
		PanelNome.setBounds(315, 0, 721, 133);
		panel_2.add(PanelNome);
		PanelNome.setLayout(null);
		PanelNome.setOpaque(false);

		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNome.setBounds(0, 0, 500, 100);
		PanelNome.add(lblNome);
		lblNome.setText(u.getNome());
		
		JLabel lblNomeEmpresa = new JLabel("");
		lblNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeEmpresa.setBounds(10, 83, 250, 50);
		PanelNome.add(lblNomeEmpresa);
		lblNomeEmpresa.setText(u.getProd().getNomeComercio());
		
		JPanel Panelinfo = new JPanel();
		Panelinfo.setBorder(null);
		Panelinfo.setBounds(315, 132, 721, 566);
		panel_2.add(Panelinfo);
		GridBagLayout gbl_Panelinfo = new GridBagLayout();
		gbl_Panelinfo.columnWidths = new int[] {46, 46, 300, 0, 30, 46, 30, 30, 0, 0};
		gbl_Panelinfo.rowHeights = new int[] { 39, 14, 14, 0, 14, 0, 1, 14, 14, 0, 0, 0, 0, 14, 1, 0, 14, 14, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_Panelinfo.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Panelinfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Panelinfo.setLayout(gbl_Panelinfo);
		Panelinfo.setOpaque(false);

		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		Panelinfo.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 4;
		Panelinfo.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblEmail = new JLabel("pp");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		Panelinfo.add(lblEmail, gbc_lblEmail);
		lblEmail.setText(u.getEmail());

		JLabel lblCidade = new JLabel("cc");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 3;
		gbc_lblCidade.gridy = 5;
		Panelinfo.add(lblCidade, gbc_lblCidade);
		lblCidade.setText(u.getEnd().getCidade());

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 8;
		Panelinfo.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Bairro:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 8;
		Panelinfo.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblCPF = new JLabel("pp");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCPF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCPF.gridx = 1;
		gbc_lblCPF.gridy = 10;
		Panelinfo.add(lblCPF, gbc_lblCPF);
		lblCPF.setText(u.getCpf());

		JLabel lblBairro = new JLabel("bb");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.WEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 3;
		gbc_lblBairro.gridy = 10;
		Panelinfo.add(lblBairro, gbc_lblBairro);
		lblBairro.setText(u.getEnd().getBairro());

		JLabel lblNewLabel_5 = new JLabel("CNPJ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 15;
		Panelinfo.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Logradouro:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 15;
		Panelinfo.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JLabel lblNewLabel_3 = new JLabel("Número:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 15;
		Panelinfo.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblCNPJ = new JLabel("");
		GridBagConstraints gbc_lblCNPJ = new GridBagConstraints();
		gbc_lblCNPJ.anchor = GridBagConstraints.WEST;
		gbc_lblCNPJ.insets = new Insets(0, 0, 5, 5);
		gbc_lblCNPJ.gridx = 1;
		gbc_lblCNPJ.gridy = 16;
		Panelinfo.add(lblCNPJ, gbc_lblCNPJ);
		lblCNPJ.setText(u.getProd().getCnpj());

		JLabel lbllogadouro = new JLabel("ll");
		GridBagConstraints gbc_lbllogadouro = new GridBagConstraints();
		gbc_lbllogadouro.anchor = GridBagConstraints.WEST;
		gbc_lbllogadouro.insets = new Insets(0, 0, 5, 5);
		gbc_lbllogadouro.gridx = 3;
		gbc_lbllogadouro.gridy = 16;
		Panelinfo.add(lbllogadouro, gbc_lbllogadouro);
		lbllogadouro.setText(u.getEnd().getLogradouro());

		JLabel lblNum = new JLabel("oo");
		GridBagConstraints gbc_lblNum = new GridBagConstraints();
		gbc_lblNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum.gridx = 5;
		gbc_lblNum.gridy = 16;
		Panelinfo.add(lblNum, gbc_lblNum);
		String num = String.valueOf(u.getEnd().getNumero());
		lblNum.setText(num);

		RoundButton btnNewButton1 = new RoundButton("Editar");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEditarVendedor editVen = new TelaEditarVendedor(u);
				editVen.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 18;
		Panelinfo.add(btnNewButton1, gbc_btnNewButton);
		btnNewButton1.setText("Editar");
		btnNewButton1.setBackground(new Color(154, 205, 217));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(10, 301, 284, 279);
		panel_2.add(panel_21);
		panel_21.setLayout(null);
		panel_21.setOpaque(false);

		JLabel lblNewLabel_7 = new JLabel("Descrição:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(21, 57, 85, 14);
		panel_21.add(lblNewLabel_7);

		JLabel lblDesc = new JLabel("");
		lblDesc.setBounds(21, 82, 253, 169);
		panel_21.add(lblDesc);
		lblDesc.setText(u.getDesc());
		
		JLabel lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(TelaPerfilVendedor.class.getResource("/img/Avatar.png")));
		lblAvatar.setBounds(48, 52, 202, 202);
		panel_2.add(lblAvatar);
	}
}
