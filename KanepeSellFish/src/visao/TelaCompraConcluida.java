package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaCompraConcluida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaCompraConcluida(JFrame telaC) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(154, 205, 217));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[326px]", "[68px]"));

		JLabel lblLogOff = new JLabel(" Compra concluida com sucesso! ");
		lblLogOff.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOff.setForeground(Color.BLACK);
		lblLogOff.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_1.add(lblLogOff, "flowy,cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel(" Deseja continuar comprando? ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		panel_1.add(lblNewLabel, "cell 0 0,alignx center");

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[100px][50px][50px][100px]", "[20px][30px]"));

		JButton btExcluir = new JButton("Sim");
		btExcluir.setBorderPainted(false);
		btExcluir.setBorder(null);
		btExcluir.setForeground(new Color(0, 0, 0));
		btExcluir.setBounds(100, 100, 50, 20);
		btExcluir.setBackground(new Color(205, 92, 92));
		btExcluir.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 13));
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio tela = new TelaInicio(null, rootPaneCheckingEnabled);
				tela.setLocationRelativeTo(null);
                tela.setVisible(true);
                telaC.dispose();
			}
		});

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBorderPainted(false);
		btCancelar.setBorder(null);
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btCancelar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btCancelar.setBackground(new Color(8, 127, 140));
		panel.add(btCancelar, "cell 0 1,grow");
		panel.add(btExcluir, "cell 3 1,grow");
	}

}