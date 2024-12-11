package visao;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ItemCarrinho;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CardProdCarrinho extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	int quantidade = 1;
	Float preco;

	public CardProdCarrinho(ItemCarrinho p, Usuario u) {
		setLayout(new MigLayout("", "[20px][100px][20px]", "[][][]"));


		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "flowx,cell 1 0,alignx left");
		lblNome.setText(p.getNome());

		JLabel lblQuantidade = new JLabel("1");
//		lblQuantidade.setText();

		JLabel lblCifra = new JLabel("R$");
		add(lblCifra, "flowx,cell 1 1");

		JLabel lblPreco = new JLabel("");
		add(lblPreco, "cell 1 1");
		float preco = p.getPreco() * Integer.parseInt(lblQuantidade.getText());
		lblPreco.setText(String.valueOf(preco));
		

		JLabel imgMenos = new JLabel("");
		imgMenos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				quantidade = Integer.parseInt(lblQuantidade.getText());
				if (quantidade > 0) {
					quantidade--;
					if (quantidade != 0) {

						lblQuantidade.setText(Integer.toString(quantidade));
					} else {
						lblQuantidade.setText("1");
					}
				} else if (quantidade == 0) {
					lblQuantidade.setText("1");
				}
			}
		});
		imgMenos.setIcon(new ImageIcon(CardProduto.class.getResource("/img/Menos.png")));
		add(imgMenos, "flowx,cell 1 2");
		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMenos.setIcon(new ImageIcon(me));

		add(lblQuantidade, "cell 1 2");

		JLabel imgMais = new JLabel("");
		imgMais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				quantidade = Integer.parseInt(lblQuantidade.getText());
				if (quantidade > 0) {
					quantidade++;
					if (quantidade != 0) {

						lblQuantidade.setText(Integer.toString(quantidade));
					} else {
						lblQuantidade.setText("1");
					}
				} else if (quantidade == 0) {
					lblQuantidade.setText("1");
				}
			}
		});
		imgMais.setIcon(new ImageIcon(CardProduto.class.getResource("/img/More.png")));
		add(imgMais, "cell 1 2");
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMais.setIcon(new ImageIcon(m));

		JLabel lblSalinidade = new JLabel("");
		lblSalinidade.setFont(new Font("Tahoma", Font.PLAIN, 9));
		add(lblSalinidade, "cell 1 0");
		if(p.getSalinidade() == true) {
			lblSalinidade.setText("Água doce");
		}else {
			lblSalinidade.setText("Água doce");
		}

	}
}
