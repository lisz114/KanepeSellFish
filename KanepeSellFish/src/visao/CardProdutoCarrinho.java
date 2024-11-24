package visao;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Produto;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CardProdutoCarrinho extends JPanel {

	public CardProdutoCarrinho(Produto p) {
		setLayout(new MigLayout("", "[20px][100px][20px]", "[][200px][][][][][][][][][]"));

		JLabel imgPeixe = new JLabel("");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
		add(imgPeixe, "cell 1 1");
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		imgPeixe.setIcon(new ImageIcon(foto));
		JLabel lblQuantidade = new JLabel("0");
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 2 1,alignx left");

		JLabel lblPreco = new JLabel("0");
		add(lblPreco, "cell 2 2");
		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

		JLabel imgMenos = new JLabel("");
		imgMenos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidade.getText());
				if (quantidade > 0) {
					quantidade = quantidade - 1;
					lblQuantidade.setText(Integer.toString(quantidade));
				} else if (quantidade == 0) {
					quantidade = 0;
				}
			}
		});
		imgMenos.setIcon(new ImageIcon(CardProduto.class.getResource("/img/Menos.png")));
		add(imgMenos, "flowx,cell 2 3");
		imgMenos.setIcon(new ImageIcon(me));

		JLabel imgMais = new JLabel("");
		imgMais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidade.getText());
				quantidade++;
				lblQuantidade.setText(Integer.toString(quantidade));
			}
		});

		add(lblQuantidade, "cell 2 3");
		imgMais.setIcon(new ImageIcon(CardProduto.class.getResource("/img/More.png")));
		add(imgMais, "cell 2 3");
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMais.setIcon(new ImageIcon(m));

	}
}
