package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.RoundButton;
import modelo.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaEdiçãoVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdiçãoVendedor frame = new TelaEdiçãoVendedor();
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
	public TelaEdiçãoVendedor() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PicPanel panel = new PicPanel("src//IMG/EdicaoPerfilVendedor.png");
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setOpaque(false);
		
		JLabel lblNewLabel_9 = new JLabel("Descrição:");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel imgBarra = new JLabel("");
		imgBarra.setIcon(new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/menu-hamburguer.png")));
		
		JLabel imgAvatar = new JLabel("");
		imgAvatar.setIcon(new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/Avatar.png")));
		
		JLabel lblNewLabel_11 = new JLabel("Editar foto de Perfil");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser file = new JFileChooser(); 
		          file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		          int i= file.showSaveDialog(null);
		        if (i==1){
		            System.out.println(i);
		        } else {
		            File arquivo = file.getSelectedFile();
		            System.out.println(arquivo);
		            
		            String destino = arquivo.getAbsolutePath();
		            ImageIcon img = new ImageIcon(destino);
		            Image png = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		            imgAvatar.setIcon(new ImageIcon(png));
		        }
				
			}
		});
		
		JLabel imgLapis = new JLabel("");
		imgLapis.setIcon(new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/lapis.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(184)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(imgBarra)))
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(192, Short.MAX_VALUE)
					.addComponent(imgAvatar)
					.addGap(181))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					.addComponent(lblNewLabel_11)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(imgLapis)
					.addGap(215))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(imgBarra)
					.addGap(30)
					.addComponent(imgAvatar)
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_11)
						.addComponent(imgLapis))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
		);
		ImageIcon barras = new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/menu-hamburguer.png"));
		Image imgB = barras.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgBarra.setIcon(new ImageIcon(imgB));
		panel_1.setLayout(gl_panel_1);
		
		ImageIcon lapis = new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/lapis.png"));
		Image imgL = lapis.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgLapis.setIcon(new ImageIcon(imgL));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		JPanel PanelNome = new JPanel();
		PanelNome.setBounds(10, 11, 555, 144);
		panel_2.add(PanelNome);
		PanelNome.setLayout(null);
		PanelNome.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 41, 331, 56);
		PanelNome.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 108, 254, 25);
		PanelNome.add(lblNewLabel_1);
		
		JLabel imgKart = new JLabel("");
		imgKart.setBounds(400, 6, 46, 39);
		panel_2.add(imgKart);
		imgKart.setIcon(new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/carrinho-de-compras.png")));
		ImageIcon car = new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/carrinho-de-compras.png"));
		Image imgC = car.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgKart.setIcon(new ImageIcon(imgC));
		JLabel imgSino = new JLabel("");
		imgSino.setBounds(460, 4, 46, 45);
		panel_2.add(imgSino);
		imgSino.setIcon(new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/sino.png")));
		ImageIcon sino = new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/sino.png"));
		Image imgS = sino.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgSino.setIcon(new ImageIcon(imgS));
		
		JPanel PanelEditor = new JPanel();
		PanelEditor.setBounds(10, 166, 555, 438);
		panel_2.add(PanelEditor);
		PanelEditor.setOpaque(false);
		GridBagLayout gbl_PanelEditor = new GridBagLayout();
		gbl_PanelEditor.columnWidths = new int[]{40, 118, 62, 119, 33, 118, 0};
		gbl_PanelEditor.rowHeights = new int[]{36, 14, 20, 91, 14, 20, 120, 14, 20, 0, 0, 0};
		gbl_PanelEditor.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_PanelEditor.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		PanelEditor.setLayout(gbl_PanelEditor);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		PanelEditor.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 1;
		PanelEditor.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		PanelEditor.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 2;
		PanelEditor.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		PanelEditor.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Bairro:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 4;
		PanelEditor.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		PanelEditor.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		PanelEditor.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CNPJ:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		PanelEditor.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Logadouro:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 7;
		PanelEditor.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Número:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 5;
		gbc_lblNewLabel_8.gridy = 7;
		PanelEditor.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 8;
		PanelEditor.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.NORTH;
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 8;
		PanelEditor.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.anchor = GridBagConstraints.NORTH;
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 8;
		PanelEditor.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new RoundButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				TelaPerfilVendedor frame = new TelaPerfilVendedor(u);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 10;
		PanelEditor.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new RoundButton("Salvar");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(96, 154, 168));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 10;
		PanelEditor.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(TelaEdiçãoVendedor.class.getResource("/img/Voltar.png")));
		lblNewLabel_10.setBounds(520, 4, 46, 45);
		panel_2.add(lblNewLabel_10);
		
	}
}
