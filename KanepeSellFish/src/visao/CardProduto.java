package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controle.CarrinhoDAO;
import modelo.CarrinhoCompras;
import modelo.Produto;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CardProduto extends JPanel {

	int quantidade;
	String preco;

	public CardProduto(Produto p, Usuario u) {
		setLayout(new MigLayout("", "[20px][100px][20px]", "[][200px][][][][][]"));

		JLabel imgPeixe = new JLabel("");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
		add(imgPeixe, "cell 1 1");
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		imgPeixe.setIcon(new ImageIcon(foto));

		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "flowx,cell 1 2,alignx left");
		lblNome.setText(p.getNome());

		JLabel lblQuantidade = new JLabel("1");

		JLabel lblQuantidadeEstoque = new JLabel("");
		lblQuantidadeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblQuantidadeEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblQuantidadeEstoque, "cell 1 2,alignx right");
		lblQuantidadeEstoque.setText(Integer.toString(p.getQuantidadeEstoque()));

		JLabel lblCifra = new JLabel("R$");
		add(lblCifra, "flowx,cell 1 4");

		JLabel lblPreco = new JLabel("");
		add(lblPreco, "cell 1 4");
		lblPreco.setText(Float.toString(p.getPreco()));

		JLabel imgMenos = new JLabel("");
		imgMenos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				quantidade = Integer.parseInt(lblQuantidade.getText());
				if (quantidade > 0) {
					quantidade--;
					if (quantidade != 0) {
						preco = lblPreco.getText();
						preco = String.valueOf(Float.parseFloat(preco) * quantidade);
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
		add(imgMenos, "flowx,cell 1 6");
		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMenos.setIcon(new ImageIcon(me));

		add(lblQuantidade, "cell 1 6");

		JLabel imgMais = new JLabel("");
		imgMais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				quantidade = Integer.parseInt(lblQuantidade.getText());
				if (quantidade > 0) {
					quantidade++;
					if (quantidade != 0) {
						preco = lblPreco.getText();
						preco = String.valueOf(Float.parseFloat(preco) * quantidade);
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
		add(imgMais, "cell 1 6");
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgMais.setIcon(new ImageIcon(m));

		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrinhoDAO cdao = new CarrinhoDAO();
				CarrinhoCompras c = cdao.verificarSeExisteCarrinho(u);
				cdao.inserirProduto(p, quantidade, preco, c);
				TelaError erro = new TelaError();
				erro.setLabelText("Produto adicionado ao carrinho");
				erro.setLocationRelativeTo(null);
				erro.setVisible(true);

			}
		});
		btAdicionar.setForeground(Color.WHITE);
		btAdicionar.setBackground(new Color(2, 73, 89));
		add(btAdicionar, "cell 1 6");

		JLabel lblUnidades = new JLabel("un");
		lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 9));
		add(lblUnidades, "cell 1 2");

	}
}
