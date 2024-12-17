package visao;

import java.awt.Dimension;
import java.awt.EventQueue;

import modelo.Cartao;
import modelo.RoundButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import controle.CartaoDAO;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class TelaCadastramentodoCartao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumC;
	private JTextField txtValidade;
	private JTextField txtCVV;
	private JTextField txtApelido;
	private JButton btnCancelar;
	private JComboBox comboBox;
	
	private static CartaoDAO cDAO = CartaoDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastramentodoCartao frame = new TelaCadastramentodoCartao();
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
	public TelaCadastramentodoCartao() {
		
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(450, 600));
		setMaximumSize(new Dimension(500, 1000));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 208, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), 
				new Color(160, 160, 160)), 
				"Cadastramento do Cart\u00E3o Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Débito", "Crédito"}));
		
		txtNumC = new JTextField();
		txtNumC.setUI(new HintTextFieldUI("Número do Cartão"));
		txtNumC.setColumns(10);
		
		txtValidade = new JTextField();
		txtValidade.setUI(new HintTextFieldUI("Validade"));
		txtValidade.setColumns(10);
		
		txtCVV = new JTextField();
		txtCVV.setUI(new HintTextFieldUI("CVV"));
		txtCVV.setColumns(10);
		
		txtApelido = new JTextField();
		txtApelido.setUI(new HintTextFieldUI("Apelido do Cartão"));
		txtApelido.setColumns(10);
		
		JButton btnSalvar = new RoundButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cartao c = new Cartao();
				TelaError erro = new TelaError();
				String obj = null;
				String numCartao = txtNumC.getText();
				int numC = Integer.parseInt(numCartao);
				String val = txtValidade.getText();
				String cvv = txtCVV.getText();
				int CVV = Integer.parseInt(cvv);
				String apelido = txtValidade.getText();
				
				if(comboBox.getSelectedItem().equals("Débito")) {
					String opCartao = "Débito";
					opCartao = obj;
				}else if (comboBox.getSelectedItem().equals("Crédito")) {
					String opCartao = "Crédito";
					opCartao = obj;
				}else if(comboBox.getSelectedItem().equals("")) {
					
					erro.setLabelText("Tipo de Cartão não selecionado!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
				if(numCartao.isEmpty() || cvv.isEmpty() || apelido.isEmpty()) {
					erro.setLabelText("Informações Inválidas!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
				
				LocalDate validade;
				try {
					validade = LocalDate.parse(val, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				} catch (DateTimeParseException e2) {
					// TODO: handle exception
					erro.setLabelText("Validade inválida!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}
				c.setTipodoCartao(obj);
				c.setNumdoCartao(numC);
				c.setValidade(validade);
				c.setCVV(CVV);
				c.setApelido(apelido);
				cDAO.inserirCartao(c);
				PopUpPagar pup = new PopUpPagar();
				pup.setLocationRelativeTo(null);
				pup.setVisible(true);
				dispose();
				
			}
		});
		btnSalvar.setBackground(new Color(96, 154, 168));
		
		btnCancelar = new RoundButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarrinho tela = new TelaCarrinho(null, null, rootPaneCheckingEnabled);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtCVV, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNumC, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApelido, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(110)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(7)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(txtNumC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(txtCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(txtApelido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}

}
