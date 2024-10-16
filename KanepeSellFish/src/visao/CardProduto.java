package visao;

import javax.swing.JPanel;

import modelo.Produto;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;

@SuppressWarnings("serial")
public class CardProduto extends JPanel {

	/**
	 * Create the panel.
	 */
	public CardProduto(Produto p) {
		setLayout(new MigLayout("", "[20px][100px][20px]", "[][200px][][][][][]"));

		JLabel imgPeixe = new JLabel("");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
		add(imgPeixe, "cell 1 1");
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		imgPeixe.setIcon(new ImageIcon(foto));

		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "flowx,cell 1 2,alignx left");

		JLabel lblQuantidade = new JLabel("0");

		JLabel lblQuantidadeEstoque = new JLabel("Quantidade Estoque");
		lblQuantidadeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblQuantidadeEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblQuantidadeEstoque, "cell 1 2,alignx right");
		
		
		

		JLabel lblPreco = new JLabel("R$0,00 kg");
		add(lblPreco, "cell 1 4");

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
		add(imgMenos, "flowx,cell 1 6");
		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMenos.setIcon(new ImageIcon(me));

		add(lblQuantidade, "cell 1 6");

		JLabel imgMais = new JLabel("");
		imgMais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidade.getText());
				quantidade++;
				lblQuantidade.setText(Integer.toString(quantidade));
			}
		});
		imgMais.setIcon(new ImageIcon(CardProduto.class.getResource("/img/More.png")));
		add(imgMais, "cell 1 6");
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMais.setIcon(new ImageIcon(m));

		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidadeEstoque.getText());
				
				 //CarrinhoDAO c = new CarrinhoDAO();
				// c.adicionarProduto();
			}
		});
		btAdicionar.setForeground(Color.WHITE);
		btAdicionar.setBackground(new Color(2, 73, 89));
		add(btAdicionar, "cell 1 6");

	}
}
