package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controle.UsuarioDAO;
import modelo.Usuario;
import modelo.RoundButton;

import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class TelaPerfilVendedor extends JFrame {

	private JPanel contentPane;
	private ArrayList<Usuario> listaUsuarios;
	JPanel panelLeft;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerfilVendedor frame = new TelaPerfilVendedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param tela
	 */
	public TelaPerfilVendedor() {

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
		ImageIcon iconMenu = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/menu-hamburguer.png"));
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
		ImageIcon iconCarrinho = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png"));
		Image iconC = iconCarrinho.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnCarrinho.setIcon(new ImageIcon(iconC));
		
		JButton btnSininho = new JButton("");
		btnSininho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSininho.setOpaque(false);
		btnSininho.setBorder(null);
		btnSininho.setBackground(SystemColor.control);
		panel.add(btnSininho, "cell 3 0,grow");
		ImageIcon iconSininho = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png"));
		Image iconS = iconSininho.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnSininho.setIcon(new ImageIcon(iconS));
		
		JButton btnFlecha = new JButton("");
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFlecha.setOpaque(false);
		btnFlecha.setBorder(null);
		btnFlecha.setBackground(SystemColor.control);
		panel.add(btnFlecha, "cell 4 0,grow");
		ImageIcon iconFlecha = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/saida.png"));
		Image iconF = iconFlecha.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		btnFlecha.setIcon(new ImageIcon(iconF));
		
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(154, 208, 217));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[100px]", "[50px][50px][50px][50px]"));
		
		JButton btnNewButton = new JButton("Inicio");
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
		
		JButton btnNewButton_3 = new JButton("Meu negocio");
		btnNewButton_3.setBackground(new Color(154, 205, 217));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setOpaque(false);
		panelLeft.add(btnNewButton_3, "cell 0 3,grow");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		
	}
}
