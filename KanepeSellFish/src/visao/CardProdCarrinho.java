package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import modelo.Produto;
import net.miginfocom.swing.MigLayout;

public class CardProdCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CardProdCarrinho(Produto p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][50px]", "[][][]"));
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

		JLabel lblQuantidadeCarrinho = new JLabel("0");
		JLabel lblNome = new JLabel("tilápia");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(lblNome, "flowx,cell 1 0,alignx center,aligny center");
		
		JRadioButton btTipoAgua = new JRadioButton("Agua Salgada");
		contentPane.add(btTipoAgua, "cell 1 0,aligny bottom");
		ImageIcon imgm = new ImageIcon(CardProdCarrinho.class.getResource("/img/More.png"));
		Image a = imgm.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JButton imgMenos = new JButton("");

		imgMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantidade = Integer.parseInt(lblQuantidadeCarrinho.getText());
				if (quantidade > 0) {
					quantidade = quantidade - 1;
					lblQuantidadeCarrinho.setText(Integer.toString(quantidade));
				} else if (quantidade == 0) {
					quantidade = 0;
				}
			}
		});
		
		JLabel lblCifra = new JLabel("R$");
		lblCifra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCifra, "flowx,cell 1 1");
		imgMenos.setBorder(null);
		imgMenos.setIcon(new ImageIcon(CardProdCarrinho.class.getResource("/img/Menos.png")));
		contentPane.add(imgMenos, "flowx,cell 1 2,alignx left");
		ImageIcon imgMen = new ImageIcon(CardProdCarrinho.class.getResource("/img/Menos.png"));
		Image b = imgMen.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMenos.setIcon(new ImageIcon(b));

		JLabel lblPreco = new JLabel("0.00");
		lblPreco.setFont(new Font("Dialog", Font.PLAIN, 16));
		getContentPane().add(lblPreco, "cell 1 1,alignx center,aligny center");

		contentPane.add(lblQuantidadeCarrinho, "cell 1 2,alignx center");

		JButton imgMais = new JButton("");
		imgMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantidade = Integer.parseInt(lblQuantidadeCarrinho.getText());
				quantidade++;
				lblQuantidadeCarrinho.setText(Integer.toString(quantidade));
			}
		});

		imgMais.setBorder(null);
		imgMais.setIcon(new ImageIcon(CardProdCarrinho.class.getResource("/img/More.png")));
		contentPane.add(imgMais, "cell 3 3");
		imgMais.setIcon(new ImageIcon(CardProdCarrinho.class.getResource("/img/More.png")));
		getContentPane().add(imgMais, "cell 1 2");
		imgMais.setIcon(new ImageIcon(a));

		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

}
