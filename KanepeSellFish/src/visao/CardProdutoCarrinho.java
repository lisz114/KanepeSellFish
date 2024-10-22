package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(16, 13, 16, 14);
		panel_1.add(lblNewLabel);
		
		RoundButtonBola  btnAdicionar1 = new RoundButtonBola("New button");
		btnAdicionar1.setHorizontalAlignment(SwingConstants.TRAILING);
		btnAdicionar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar1.setText("+");
		btnAdicionar1.setFont(new Font("Dialog", Font.PLAIN, 5));
		btnAdicionar1.setBounds(35, 11, 16, 16);
		panel_1.add(btnAdicionar1);
		
		RoundButtonBola btnRemover = new RoundButtonBola("New button");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setText("-");
		btnRemover.setHorizontalAlignment(SwingConstants.TRAILING);
		btnRemover.setFont(new Font("Dialog", Font.PLAIN, 5));
		btnRemover.setBounds(0, 11, 16, 16);
		panel_1.add(btnRemover);
		
		RoundButton2 btnAdicionar = new RoundButton2("New button");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdicionar.setBounds(55, 6, 73, 23);
		panel_1.add(btnAdicionar);
		btnAdicionar.setText("adicionar");
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
