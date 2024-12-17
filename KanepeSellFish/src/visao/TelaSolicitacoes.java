package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Usuario;

public class TelaSolicitacoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public TelaSolicitacoes() {
		getContentPane().setBackground(new Color(154, 205, 217));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setOpaque(false);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblSolicitas = new JLabel("Solicitações");
		lblSolicitas.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panelTitulo.add(lblSolicitas);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "C\u00F3digo", "Nome", "Quantidade", "Valor", "Data"
			}
		));
		scrollPane.setColumnHeaderView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  800, 500);
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(0, 0));
		setMaximumSize(new Dimension(1920, 1080));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	public TelaSolicitacoes(Usuario u) {
		// TODO Auto-generated constructor stub
	}

}
