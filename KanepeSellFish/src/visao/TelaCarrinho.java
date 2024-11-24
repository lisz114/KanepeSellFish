package visao;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCarrinho extends JFrame {

	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCarrinho frame = new TelaCarrinho();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public TelaCarrinho(Usuario u, boolean isVendedor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][]", "[50][576.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 220));
		contentPane.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[30px][grow]", "[30px]"));

		JLabel imgMenu = new JLabel("");
		panel.add(imgMenu, "cell 0 0,alignx left,aligny top");
		imgMenu.setIcon(new ImageIcon(TelaCarrinho.class.getResource("/IMG/menu-hamburguer.png")));
		ImageIcon menu = new ImageIcon(TelaCarrinho.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgMenu.setIcon(new ImageIcon(iconMenu));
		ImageIcon deslogar = new ImageIcon(TelaCarrinho.class.getResource("/img/saida.png"));
		Image imgD = deslogar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		JLabel imgLogoff = new JLabel("");
		imgLogoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastro tela = new TelaCadastro();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);

				dispose();
			}
		});
		imgLogoff.setIcon(new ImageIcon(TelaCarrinho.class.getResource("/img/saida.png")));
		panel.add(imgLogoff, "cell 1 0,alignx right");
		imgLogoff.setIcon(new ImageIcon(imgD));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[][][][grow][grow 10]", "[][grow 90][grow 40][grow 30][]"));
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		
		JLabel imgPeixe = new JLabel("");
		panel_1.add(imgPeixe, "cell 0 1");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
		imgPeixe.setIcon(new ImageIcon(foto));
		
		JLabel lblInfoCompra = new JLabel("Informações da compra: ");
		lblInfoCompra.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_1.add(lblInfoCompra, "cell 0 2 1 2");
		
		JLabel lblNomeProduto = new JLabel("");
		lblNomeProduto.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblNomeProduto, "cell 0 3");
		
		JLabel lblQuantidadeDesej = new JLabel("");
		lblQuantidadeDesej.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblQuantidadeDesej, "cell 3 3,alignx right");
		
		JLabel lblValorProduto = new JLabel("");
		lblValorProduto.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel_1.add(lblValorProduto, "cell 4 3,alignx center");
		
		JButton btnVoltaTela = new JButton("Continuar comprando");
		btnVoltaTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaInicio tela = new TelaInicio(u, isVendedor);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);

				dispose();
			}
		});
		btnVoltaTela.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnVoltaTela.setBackground(new Color(154, 205, 217));
		panel_1.add(btnVoltaTela, "cell 3 4,alignx right");
		
		JButton btnPagamento = new JButton("Concluir compra");
		btnPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TelaPagamento tela = new TelaPagamento();
//				tela.setLocationRelativeTo(null);
//				tela.setVisible(true);
//
//				dispose();
			}
		});
		btnPagamento.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnPagamento.setBackground(new Color(154, 205, 217));
		panel_1.add(btnPagamento, "cell 4 4,alignx center");
		
		
	}
}
