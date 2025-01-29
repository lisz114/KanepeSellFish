package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controle.CarrinhoDAO;
import modelo.ItemCarrinho;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CardProdutoCarrinho extends JPanel {
	private static CarrinhoDAO cDAO = CarrinhoDAO.getInstancia();
	JLabel lblQuantidade = null;

	public CardProdutoCarrinho(ItemCarrinho p) {
		setBorder(new LineBorder(new Color(0, 0, 0)));

		ImageIcon imgMe = new ImageIcon(CardProduto.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon imgM = new ImageIcon(CardProduto.class.getResource("/img/More.png"));
		Image m = imgM.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

		setLayout(new MigLayout("", "[100px][20px,grow]", "[160px]"));

		JLabel imgPeixe = new JLabel("");
		imgPeixe.setIcon(new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg")));
		add(imgPeixe, "flowy,cell 0 0,grow");
		ImageIcon iconFoto = new ImageIcon(CardProduto.class.getResource("/img/ttilapia.jpg"));
		Image foto = iconFoto.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		imgPeixe.setIcon(new ImageIcon(foto));

		JPanel panel = new JPanel();
		add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[grow][]", "[30px,bottom][20px,center][]"));
		JLabel lblNome = new JLabel(p.getProduto().getNome());
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblNome, "flowx,cell 0 0");
	
		
		JLabel btExcluir = new JLabel("");
		btExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		panel.add(btExcluir, "cell 1 0,alignx center,aligny top");
		ImageIcon lixo = new ImageIcon(TelaInicio.class.getResource("/img/lixo.png"));
		Image iconLixo = lixo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btExcluir.setIcon(new ImageIcon(iconLixo));
	

		JLabel lblPreco = new JLabel(String.valueOf(p.getPrecoTotal()));
		lblPreco.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblPreco, "cell 0 1");

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 2,grow");
		panel_1.setLayout(new MigLayout("", "[][][]", "[]"));

		JLabel imgMenos = new JLabel("");
		panel_1.add(imgMenos, "cell 0 0");
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
		imgMenos.setIcon(new ImageIcon(me));
		lblQuantidade = new JLabel(String.valueOf(p.getQuantidade()));
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblQuantidade, "cell 1 0");

		JLabel imgMais = new JLabel("");
		panel_1.add(imgMais, "cell 2 0");
		imgMais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidade.getText());
				if (quantidade >= p.getProduto().getQuantidadeEstoque()) {
					quantidade = p.getProduto().getQuantidadeEstoque();
				} else {
					quantidade++;
				}
				lblQuantidade.setText(Integer.toString(quantidade));
			}
		});
		imgMais.setIcon(new ImageIcon(CardProduto.class.getResource("/img/More.png")));
		imgMais.setIcon(new ImageIcon(m));

	}
}
