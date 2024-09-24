package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class TelaInicioVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicioVendedor frame = new TelaInicioVendedor();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicioVendedor() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[]", "[]"));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[300px][grow]", "[150px][150px,grow]"));
		
				JPanel panel_3 = new JPanel();
				panel_1.add(panel_3, "cell 1 0,grow");
				panel_3.setLayout(new MigLayout("", "[][]", "[][]"));
				
				JLabel lblInicio = new JLabel("PEIXES DISPONÍVEIS");
				lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel_3.add(lblInicio, "cell 1 1");

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new MigLayout("", "[][][][][]", "[60px][50px][][][][][][]"));
		
				JLabel lblOrdenar = new JLabel("ORDENAR");
				panel_2.add(lblOrdenar, "cell 3 0");
				lblOrdenar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel imgUp = new JLabel("");
		imgUp.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgUp.png")));
		panel_2.add(imgUp, "cell 2 1,alignx center");
		ImageIcon iconUp = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgUp.png"));
		Image imgU = iconUp.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgUp.setIcon(new ImageIcon(imgU));

		JLabel imgDown = new JLabel("");
		imgDown.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgDown.png")));
		panel_2.add(imgDown, "cell 4 1,alignx center");
		ImageIcon iconDown = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgDown.png"));
		Image imgD = iconDown.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgDown.setIcon(new ImageIcon(imgD));

		JLabel imgAZ = new JLabel("");
		imgAZ.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgA.png")));
		panel_2.add(imgAZ, "cell 2 4,alignx center");
		ImageIcon iconAZ = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgA.png"));
		Image ordemAZ = iconAZ.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgAZ.setIcon(new ImageIcon(ordemAZ));

		JLabel imgZA = new JLabel("");
		imgZA.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgZ.png")));
		panel_2.add(imgZA, "cell 4 4,alignx center");
		ImageIcon iconZA = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgZ.png"));
		Image ordemZA = iconZA.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgZA.setIcon(new ImageIcon(ordemZA));

		JLabel lblMaiorValor = new JLabel("Maior Valor");
		panel_2.add(lblMaiorValor, "cell 2 2,alignx center");
		lblMaiorValor.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblMenorValor = new JLabel("Menor Valor");
		panel_2.add(lblMenorValor, "cell 4 2,alignx center");

		JLabel lblAaZ = new JLabel("De A a Z");
		panel_2.add(lblAaZ, "cell 2 5,alignx center");

		JLabel lblZaA = new JLabel("De Z a A");
		panel_2.add(lblZaA, "cell 4 5,alignx center");

		JRadioButton rbAguaDoce = new JRadioButton("Água Doce");
		panel_2.add(rbAguaDoce, "cell 2 7");

		JRadioButton rbAguaSalgada = new JRadioButton("Água Salgada");
		panel_2.add(rbAguaSalgada, "cell 4 7");

	}

}
