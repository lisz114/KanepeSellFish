package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import modelo.Usuario;
import modelo.RoundButton;

import java.awt.Color;

public class TelaPerfil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerfil frame = new TelaPerfil();
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
	public TelaPerfil() {
		
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
		
		PicPanel panel = new PicPanel("src//IMG/Perfil.png");
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JPanel PanelPrincipal = new JPanel();
		PanelPrincipal.setBounds(408, 0, 752, 624);
		panel_1.add(PanelPrincipal);
		PanelPrincipal.setOpaque(false);
		PanelPrincipal.setLayout(null);
		
		JPanel PanelNome = new JPanel();
		PanelNome.setBounds(39, 7, 674, 200);
		PanelPrincipal.add(PanelNome);
		PanelNome.setLayout(null);
		PanelNome.setOpaque(false);
		
		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNome.setBounds(0, 11, 500, 100);
		PanelNome.add(lblNome);
		
		JLabel lblNomeEmpresa = new JLabel("");
		lblNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeEmpresa.setBounds(10, 122, 250, 50);
		PanelNome.add(lblNomeEmpresa);
		
		JPanel Panelinfo = new JPanel();
		Panelinfo.setBorder(null);
		Panelinfo.setBounds(39, 218, 674, 400);
		PanelPrincipal.add(Panelinfo);
		GridBagLayout gbl_Panelinfo = new GridBagLayout();
		gbl_Panelinfo.columnWidths = new int[] {46, 46, 300, 0, 30, 46, 0};
		gbl_Panelinfo.rowHeights = new int[]{39, 14, 14, 14, 1, 14, 14, 14, 1, 14, 14, 0, 0, 0, 0, 0, 0};
		gbl_Panelinfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Panelinfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Panelinfo.setLayout(gbl_Panelinfo);
		Panelinfo.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		Panelinfo.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblCidade = new JLabel("");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 3;
		gbc_lblCidade.gridy = 2;
		Panelinfo.add(lblCidade, gbc_lblCidade);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		Panelinfo.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblTel = new JLabel("");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTel.gridx = 1;
		gbc_lblTel.gridy = 4;
		Panelinfo.add(lblTel, gbc_lblTel);
		
		JLabel lblNewLabel_4 = new JLabel("Bairro:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 6;
		Panelinfo.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblBairro = new JLabel("");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.WEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 3;
		gbc_lblBairro.gridy = 7;
		Panelinfo.add(lblBairro, gbc_lblBairro);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		Panelinfo.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 11;
		Panelinfo.add(lblEmail, gbc_lblEmail);
		
		JLabel lblNewLabel_6 = new JLabel("Rua:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 13;
		Panelinfo.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblRua = new JLabel("");
		GridBagConstraints gbc_lblRua = new GridBagConstraints();
		gbc_lblRua.anchor = GridBagConstraints.WEST;
		gbc_lblRua.insets = new Insets(0, 0, 5, 5);
		gbc_lblRua.gridx = 3;
		gbc_lblRua.gridy = 14;
		Panelinfo.add(lblRua, gbc_lblRua);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(45, 270, 284, 279);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		
		JButton btnNewButton = new RoundButton("Estoque");
		btnNewButton.setBackground(new Color(154, 205, 217));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(67, 80, 143, 34);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new RoundButton("Excluir Conta");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(67, 169, 143, 34);
		panel_2.add(btnNewButton_1);
		
		
		//Usuario user = new Usuario();
		
		//lblNome.setText(user.getNome());
		//lblEmail.setText(user.getEmail());
	}
}
