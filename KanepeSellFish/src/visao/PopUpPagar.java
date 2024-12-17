package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;

import modelo.RoundButton;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopUpPagar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpPagar frame = new PopUpPagar();
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
	public PopUpPagar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 217));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(154, 205, 217));
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Apelido do Cartão:");
		panel_1.add(lblNewLabel_1, "cell 1 3");
		
		JLabel lblApelido = new JLabel("");
		panel_1.add(lblApelido, "cell 2 3");
		
		JLabel lblNewLabel = new JLabel("Total a pagar:");
		panel_1.add(lblNewLabel, "cell 1 4");
		
		JLabel lblTotalaPagar = new JLabel("");
		panel_1.add(lblTotalaPagar, "cell 2 4");
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(50);
		panel.setBackground(new Color(154, 205, 217));
		contentPane.add(panel);
		
		JButton btnComprar = new RoundButton("Comprar");
		btnComprar.setBackground(new Color(8, 127, 144));
		panel.add(btnComprar);
		
		JButton btncancelar = new RoundButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarrinho tc = new TelaCarrinho(null, null, rootPaneCheckingEnabled);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
				dispose();
			}
		});
		btncancelar.setBackground(new Color(255, 0, 0));
		panel.add(btncancelar);
	}

}
