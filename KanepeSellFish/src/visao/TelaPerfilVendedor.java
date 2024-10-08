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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controle.UsuarioDAO;
import modelo.Usuario;
import modelo.RoundButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPerfilVendedor extends JFrame {

	private JPanel contentPane;
	private ArrayList<Usuario> listaUsuarios;

	
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

		PicPanel panel = new PicPanel("src//IMG/TelaNovadoPerfilVendedor.png");
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
		Panelinfo.setBounds(39, 213, 674, 400);
		PanelPrincipal.add(Panelinfo);
		GridBagLayout gbl_Panelinfo = new GridBagLayout();
		gbl_Panelinfo.columnWidths = new int[] { 46, 46, 300, 0, 30, 46, 0, 0, 0 };
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

		JLabel lblCidade = new JLabel("cc");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 3;
		gbc_lblCidade.gridy = 5;
		Panelinfo.add(lblCidade, gbc_lblCidade);

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

		JLabel lblBairro = new JLabel("bb");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.WEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 3;
		gbc_lblBairro.gridy = 10;
		Panelinfo.add(lblBairro, gbc_lblBairro);

		JLabel lblNewLabel_5 = new JLabel("CNPJ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 15;
		Panelinfo.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Logadouro:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTHEAST;
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

		JLabel lblCNPJ = new JLabel("çç");
		GridBagConstraints gbc_lblCNPJ = new GridBagConstraints();
		gbc_lblCNPJ.anchor = GridBagConstraints.WEST;
		gbc_lblCNPJ.insets = new Insets(0, 0, 5, 5);
		gbc_lblCNPJ.gridx = 1;
		gbc_lblCNPJ.gridy = 16;
		Panelinfo.add(lblCNPJ, gbc_lblCNPJ);

		JLabel lbllogadouro = new JLabel("ll");
		GridBagConstraints gbc_lbllogadouro = new GridBagConstraints();
		gbc_lbllogadouro.anchor = GridBagConstraints.WEST;
		gbc_lbllogadouro.insets = new Insets(0, 0, 5, 5);
		gbc_lbllogadouro.gridx = 3;
		gbc_lbllogadouro.gridy = 16;
		Panelinfo.add(lbllogadouro, gbc_lbllogadouro);

		JLabel lblNum = new JLabel("oo");
		GridBagConstraints gbc_lblNum = new GridBagConstraints();
		gbc_lblNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblNum.gridx = 5;
		gbc_lblNum.gridy = 16;
		Panelinfo.add(lblNum, gbc_lblNum);

		JButton btnNewButton = new RoundButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEdiçãoVendedor editVen = new TelaEdiçãoVendedor();
				editVen.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 18;
		Panelinfo.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setText("Editar");
		btnNewButton.setBackground(new Color(154, 205, 217));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(45, 270, 284, 279);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setOpaque(false);

		JLabel lblNewLabel_7 = new JLabel("Descrição:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(21, 57, 85, 14);
		panel_2.add(lblNewLabel_7);

		JLabel lblDesc = new JLabel("oo");
		lblDesc.setBounds(21, 82, 253, 14);
		panel_2.add(lblDesc);

		String valor = new UsuarioDAO().BuscarUsuario(1);
		lblNome.setText(valor);
		
	}
}
