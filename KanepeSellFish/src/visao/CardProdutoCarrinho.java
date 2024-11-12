package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import modelo.Produto;
import modelo.Produtor;
import modelo.RoundButton2;
import modelo.RoundButtonBola;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardProdutoCarrinho extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardProdutoCarrinho frame = new CardProdutoCarrinho();
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
	public CardProdutoCarrinho() {
		Produto produto = new Produto();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("left:max(88dlu;pref):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(86dlu;default):grow"),
				ColumnSpec.decode("86dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(442dlu;default)"),
				ColumnSpec.decode("max(126dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "1, 2, 1, 7, fill, fill");
		Produtor produtor = new Produtor();
		
		JLabel lblNomeProdutor = new JLabel(produtor.getNomeComercio());
		lblNomeProdutor.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(lblNomeProdutor, "4, 2, 1, 2");
		
		JLabel lblNomeProduto = new JLabel(produto.getNome());
		lblNomeProduto.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblNomeProduto, "4, 4");
		
		JLabel lblValorTotal = new JLabel("Valor Total        ");
		contentPane.add(lblValorTotal, "7, 4, right, default");
		
		
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "4, 6, fill, fill");
		panel_1.setLayout(null);
		
		JLabel lblQuantidade = new JLabel("1");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setBounds(16, 13, 16, 14);
		panel_1.add(lblQuantidade);
		
		RoundButton2 btnAdicionar = new RoundButton2("New button");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdicionar.setBounds(55, 6, 73, 23);
		panel_1.add(btnAdicionar);
		btnAdicionar.setText("adicionar");
		
		JLabel lblMenos = new JLabel("");
		lblMenos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int quantidade = Integer.parseInt(lblQuantidade.getText());
				if(quantidade > 0) {
					quantidade = quantidade -1;
					lblQuantidade.setText(Integer.toString(quantidade));
				}else if(quantidade == 0) {
					quantidade = 0;
				}
			}
		});
		lblMenos.setBounds(5, 11, 29, 19);
		lblMenos.setIcon(new ImageIcon(CardProdutoCarrinho.class.getResource("/img/Menos.png")));
		ImageIcon imgMe = new ImageIcon(CardProdutoCarrinho.class.getResource("/img/Menos.png"));
		Image me = imgMe.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
		lblMenos.setIcon(new ImageIcon(me));
		panel_1.add(lblMenos);
		
		
		JLabel lblMais = new JLabel("");
		lblMais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int quantidade = Integer.parseInt(lblQuantidade.getText());
			quantidade++;
			lblQuantidade.setText(Integer.toString(quantidade));
			
			}
		});
		lblMais.setBounds(15, -14, 85, 100);
		lblMais.setIcon(new ImageIcon(CardProdutoCarrinho.class.getResource("/img/More.png")));
		ImageIcon imgMa = new ImageIcon(CardProdutoCarrinho.class.getResource("/img/More.png"));
		Image ma = imgMa.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
		lblMais.setIcon(new ImageIcon(ma));
		panel_1.add(lblMais);
		
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		Float preco = produto.getPreco();	
		String precoString = Float.toString(preco);
		
		JLabel lblPrecoTotal = new JLabel(precoString);
		
		lblPrecoTotal.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPane.add(lblPrecoTotal, "7, 6, right, default");
		
		JLabel lblExcluir = new JLabel("     Excluir");
		lblExcluir.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblExcluir.setForeground(new Color(255, 0, 0));
		contentPane.add(lblExcluir, "4, 8, left, default");
	}
}
