package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JButton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("left:max(140dlu;pref)"),
				ColumnSpec.decode("max(132dlu;default)"),
				ColumnSpec.decode("max(714dlu;default)"),
				ColumnSpec.decode("max(126dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "2, 2");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentPane.add(lblNewLabel_1, "2, 4");
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "2, 6, right, default");
		
		JLabel lblNewLabel_2 = new JLabel("     New label");
		contentPane.add(lblNewLabel_2, "2, 8, left, default");
	}

}
