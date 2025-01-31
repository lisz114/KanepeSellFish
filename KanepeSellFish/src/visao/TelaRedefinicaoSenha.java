package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controle.ProdutoDAO;
import modelo.Produto;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.SystemColor;

public class TelaRedefinicaoSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<Produto> produtos;
	ProdutoDAO pDAO = new ProdutoDAO();
	private JTextField txtAtual;
	private JTextField txtNova;
	private JPasswordField passwordField;
	private JButton btSalvar;
	private JButton btCancelar;
	private JLabel lblSubtitulo;
	private JLabel lblSubsubtitulo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio(null, false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaRedefinicaoSenha(Usuario u) {
		setBackground(SystemColor.activeCaption);
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(0, 0));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JLabel lblTitulo = new JLabel("Redefinição de Senha");
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 30));
		panel.add(lblTitulo, "cell 0 0,alignx center,aligny center");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow]", "[50px][][20px][][][][grow]"));
		
		lblSubtitulo = new JLabel("Primeiro, precisamos ter certeza que é você.");
		lblSubtitulo.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblSubtitulo, "cell 0 0,alignx center,aligny center");
		
		txtAtual = new JPasswordField();
		txtAtual.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Atual Senha:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtAtual.setOpaque(false);
		panel_1.add(txtAtual, "flowx,cell 0 1,alignx center,aligny center");
		txtAtual.setColumns(20);
		
		txtNova = new JPasswordField();
		txtNova.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nova Senha:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtNova.setOpaque(false);
		panel_1.add(txtNova, "cell 0 3,alignx center,aligny center");
		txtNova.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setColumns(20);
		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Repita a Senha:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(passwordField, "cell 0 4,alignx center");
		
		lblSubsubtitulo = new JLabel("OBS: Não utilize a mesma senha antes cadastrada.");
		lblSubsubtitulo.setForeground(Color.RED);
		lblSubsubtitulo.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel_1.add(lblSubsubtitulo, "cell 0 5,alignx center,aligny center");
		
		btCancelar = new JButton("Cancelar");
		panel_1.add(btCancelar, "flowx,cell 0 6,alignx right,aligny bottom");
		
		btSalvar = new JButton("Salvar");
		panel_1.add(btSalvar, "cell 0 6,alignx right,aligny bottom");

	}
}