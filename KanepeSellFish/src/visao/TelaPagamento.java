package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.UsuarioDAO;
import modelo.CarrinhoCompras;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class TelaPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioDAO uDAO = new UsuarioDAO();
	private JButton btSalvar;
	private JButton btCancelar;
	private JLabel lblSubtitulo;
	private TelaPagamento estajanela = this;
	private JLabel lblquantidade;
	private JLabel lblValorTotal;
	private JLabel lblpreco;
	private JPanel panel_2;
	private JLabel lblChave;
	private JLabel lblpix;
	private JLabel imgPix;

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

	public TelaPagamento(Usuario u, boolean isVendedor, CarrinhoCompras carrinho) {
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
		panel.setBackground(new Color(154, 205, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[grow]", "[]"));

		JLabel lblTitulo = new JLabel("Pagamento");
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 30));
		panel.add(lblTitulo, "cell 0 0,alignx center,aligny center");

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new MigLayout("", "[grow][grow]", "[grow][20px][grow]"));

		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaError aviso = new TelaError();
				aviso.setLabelText("Pagamento cancelado.");
				aviso.setLocationRelativeTo(null);
				aviso.setVisible(true);
				dispose();

			}
		});

		panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_1.add(panel_2, "cell 0 0 2 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));

		lblChave = new JLabel("Chave pix:");
		lblChave.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_2.add(lblChave, "flowx,cell 0 0 1 2,alignx left,aligny center");

		imgPix = new JLabel("");
		imgPix.setIcon(new ImageIcon(TelaPagamento.class.getResource("/img/qrcode.png")));
		panel_2.add(imgPix, "cell 1 0 1 2,alignx center");

		ImageIcon pix = new ImageIcon(TelaInicio.class.getResource("/img/qrcode.png"));
		Image iconpix = pix.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		imgPix.setIcon(new ImageIcon(iconpix));

		lblpix = new JLabel("0");
		lblpix.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_2.add(lblpix, "cell 0 0,growx,aligny center");

		lblSubtitulo = new JLabel("Total de itens:");
		lblSubtitulo.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblSubtitulo, "flowx,cell 0 1,alignx left,aligny center");

		lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblValorTotal, "flowx,cell 1 1,alignx left,aligny center");
		btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCancelar.setBackground(new Color(205, 92, 92));

		panel_1.add(btCancelar, "flowx,cell 1 2,alignx right,aligny bottom");

		btSalvar = new JButton("Pagar");
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.setBackground(new Color(154, 205, 217));
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaError aviso = new TelaError();
				aviso.setLabelText("Pagamento concluído com sucesso!");
				aviso.setLocationRelativeTo(null);
				aviso.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btSalvar, "cell 1 2,alignx right,aligny bottom");

		lblquantidade = new JLabel("0");
		lblquantidade.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblquantidade, "cell 0 1,alignx left");
		lblquantidade.setText(String.valueOf(carrinho.getQuantidadeProdutos()));

		lblpreco = new JLabel("0");
		lblpreco.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblpreco, "cell 1 1,alignx left,aligny center");
		lblpreco.setText(String.valueOf(carrinho.getValorTotal()));

	}
}