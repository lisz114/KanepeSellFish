package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardProdCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardProdCarrinho frame = new CardProdCarrinho();
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
	public CardProdCarrinho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JLabel imgPeixe = new JLabel("");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
		getContentPane().add(imgPeixe, "cell 0 0");
		imgPeixe.setIcon(new ImageIcon(foto));
		
		JLabel lblNomeProd = new JLabel("Nome foda d peixe");
		lblNomeProd.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblNomeProd, "flowy,cell 0 1,aligny top");
		
		JLabel lblPreco = new JLabel("R$0,00 kg");
		lblPreco.setFont(new Font("Dialog", Font.PLAIN, 11));
		getContentPane().add(lblPreco, "cell 1 1,aligny center");
		
//		JLabel imgMais = new JLabel("");
//		imgMais.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				int quantidade = Integer.parseInt(lblQuantidadeEst.getText());
//				quantidade++;
//				lblQuantidadeEst.setText(Integer.toString(quantidade));
//			}
//		});
//		imgMais.setIcon(new ImageIcon(CardProduto.class.getResource("/img/More.png")));
//		getContentPane().add(imgMais, "flowx,cell 2 1");
//		imgMais.setIcon(new ImageIcon(m));
//		
		JLabel lblQuantidadeEst = new JLabel("Quantidade no estoque");
		lblQuantidadeEst.setFont(new Font("Dialog", Font.PLAIN, 11));
		contentPane.add(lblQuantidadeEst, "cell 0 1,aligny center");
		
		JLabel imgMenos = new JLabel("");
		imgMenos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidadeEst.getText());
				if (quantidade > 0) {
					quantidade = quantidade - 1;
					lblQuantidadeEst.setText(Integer.toString(quantidade));
				} else if (quantidade == 0) {
					quantidade = 0;
				}
			}
		});
		
		JLabel lblQuantidadeAdc = new JLabel("0");
		contentPane.add(lblQuantidadeAdc, "cell 2 1");
		imgMenos.setIcon(new ImageIcon(CardProduto.class.getResource("/img/Menos.png")));
		getContentPane().add(imgMenos, "cell 2 1");
		imgMenos.setIcon(new ImageIcon(me));
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	}

}
