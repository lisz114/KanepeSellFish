package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
					frame.setLocationRelativeTo(null);
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
	public TelaCadastroProduto() {
		setTitle("Cadastro de produto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroComercio.class.getResource("/img/logo.png")));
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(0, 0));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(154, 205, 217));
		getContentPane().add(panelBackground, BorderLayout.CENTER);
		panelBackground.setLayout(new MigLayout("", "[grow]", "[100px][300px,grow][100px]"));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelBackground.add(panel, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("Adicionar Produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panelBackground.add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new EmptyBorder(0, 60, 0, 40));
		panel_2.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[grow]", "[50px][30px,grow][50px][30px,grow][50px][30px,grow][50px]"));
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Nome*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBackground(SystemColor.menu);
		panel_3.add(textField, "cell 0 0,grow");
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Nome*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_1.setBackground(SystemColor.menu);
		panel_3.add(textField_1, "cell 0 2,grow");
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setOpaque(false);
		textField_2.setColumns(10);
		textField_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Nome*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_2.setBackground(SystemColor.menu);
		panel_3.add(textField_2, "cell 0 4,grow");
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setOpaque(false);
		textField_4.setColumns(10);
		textField_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Nome*", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_4.setBackground(SystemColor.menu);
		panel_3.add(textField_4, "cell 0 6,grow");
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new EmptyBorder(5, 40, 0, 60));
		panel_2.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[grow]", "[200px][25px][40px]"));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setOpaque(false);
		panel_4.add(panel_5, "cell 0 0,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Mudar imagem");
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		panel_4.add(lblNewLabel_1, "cell 0 1,alignx right");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Água doce");
		rdbtnNewRadioButton.setBorder(null);
		rdbtnNewRadioButton.setOpaque(false);
		rdbtnNewRadioButton.setSelected(true);
		panel_4.add(rdbtnNewRadioButton, "flowx,cell 0 2");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Água salgada");
		rdbtnNewRadioButton_1.setBorder(null);
		rdbtnNewRadioButton_1.setOpaque(false);
		panel_4.add(rdbtnNewRadioButton_1, "cell 0 2");
		
		ButtonGroup g = new ButtonGroup();
		g.add(rdbtnNewRadioButton_1);
		g.add(rdbtnNewRadioButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panelBackground.add(panel_1, "cell 0 2,grow");
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_1.add(panel_6);
		panel_6.setLayout(new MigLayout("", "[230px][130px]", "[5px][30px,grow][5px]"));
		
		JButton btnNewButton = new RoundButton("Adicionar");
		btnNewButton.setBackground(new Color(2, 73, 89));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		panel_6.add(btnNewButton, "cell 1 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_1.add(panel_7);
		panel_7.setLayout(new MigLayout("", "[130px][grow]", "[5px][30px,grow][5px]"));
		
		JButton btnNewButton_1 = new RoundButton("Cancelar");
		btnNewButton_1.setBackground(new Color(200, 0, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		panel_7.add(btnNewButton_1, "cell 0 1,grow");
	}

}
