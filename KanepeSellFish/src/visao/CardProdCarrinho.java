package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import modelo.Produto;
import net.miginfocom.swing.MigLayout;

public class CardProdCarrinho extends JPanel {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardProdCarrinho frame = new CardProdCarrinho(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CardProdCarrinho(Produto p) {
		setBounds(100, 100, 504, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout("", "[][50px]", "[][][]"));
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JLabel lblQuantidadeCarrinho = new JLabel("0");
		JLabel imgPeixe = new JLabel("");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
//		getRootPane().add(imgPeixe, "cell 0 0");
		imgPeixe.setIcon(new ImageIcon(foto));
		ImageIcon imgm = new ImageIcon(CardProdCarrinho.class.getResource("/img/More.png"));
		Image a = imgm.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imgMen = new ImageIcon(CardProdCarrinho.class.getResource("/img/Menos.png"));
		Image b = imgMen.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JLabel lblPreco = new JLabel("");
		JButton imgMenos = new JButton("");

		imgMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(lblQuantidadeCarrinho.getText())>= 0) {
				lblQuantidadeCarrinho.setText(String.valueOf(Integer.parseInt(lblQuantidadeCarrinho.getText())-1));
				lblPreco.setText(String.valueOf(Double.parseDouble(lblQuantidadeCarrinho.getText())*p.getPreco()));
			}
			}
		});
		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(lblNome, "flowx,cell 1 1,alignx center,aligny center");
		lblNome.setText(p.getNome());

		JRadioButton btTipoAgua = new JRadioButton("");
		contentPane.add(btTipoAgua, "cell 2 2,aligny bottom");
		if (p.getSalinidade() == true) {
			btTipoAgua.setText("Água Salgada");
		} else {
			btTipoAgua.setText("Água Doce");
		}

		JLabel lblCifra = new JLabel("R$");
		lblCifra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCifra, "flowx,cell 1 3");
		imgMenos.setBorder(null);
		imgMenos.setIcon(new ImageIcon(CardProdCarrinho.class.getResource("/img/Menos.png")));
		contentPane.add(imgMenos, "flowx,cell 2 3,alignx left");
		imgMenos.setIcon(new ImageIcon(b));

		contentPane.add(lblPreco, "cell 1 3");
		lblPreco.setText(Double.toString(p.getPreco()));

		contentPane.add(lblQuantidadeCarrinho, "cell 2 3,alignx center");

		JButton imgMais = new JButton("");
		imgMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblQuantidadeCarrinho.setText(String.valueOf(Integer.parseInt(lblQuantidadeCarrinho.getText())+1));
				lblPreco.setText(String.valueOf(Double.parseDouble(lblQuantidadeCarrinho.getText())*p.getPreco()));
			}
		});

		imgMais.setBorder(null);
		imgMais.setIcon(new ImageIcon(CardProdCarrinho.class.getResource("/img/More.png")));
		contentPane.add(imgMais, "cell 2 3");
		imgMais.setIcon(new ImageIcon(CardProdCarrinho.class.getResource("/img/More.png")));
//		getRootPane().add(imgMais, "cell 1 2");
		imgMais.setIcon(new ImageIcon(a));

		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

}
