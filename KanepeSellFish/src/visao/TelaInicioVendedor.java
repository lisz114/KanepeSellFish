package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaInicioVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicioVendedor frame = new TelaInicioVendedor();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicioVendedor() {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 217));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][2000px][][][]", "[grow]"));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[10px][300px][grow][grow]", "[160px,grow][150px,grow]"));

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, "cell 2 0,grow");
		panel_7.setLayout(new MigLayout("", "[300px,grow]", "[][80px][]"));

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBackground(new Color(192, 192, 192));
		panel_7.add(textField, "cell 0 0,grow");
		textField.setColumns(50);

		JLabel lblPeixes = new JLabel("PEIXES DISPONÍVEIS");
		lblPeixes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(lblPeixes, "cell 0 2,alignx left");

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new MigLayout("", "[][][][][][]", "[60px][50px][][][][][10px][][][500px][][]"));

		JLabel lblOrdenar = new JLabel("ORDENAR");
		panel_2.add(lblOrdenar, "cell 4 0,alignx center");
		lblOrdenar.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 14));

		JLabel imgUp = new JLabel("");
		imgUp.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgUp.png")));
		panel_2.add(imgUp, "cell 3 1,alignx center");
		ImageIcon iconUp = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgUp.png"));
		Image imgU = iconUp.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgUp.setIcon(new ImageIcon(imgU));

		JLabel imgDown = new JLabel("");
		imgDown.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgDown.png")));
		panel_2.add(imgDown, "cell 5 1,alignx center");
		ImageIcon iconDown = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgDown.png"));
		Image imgD = iconDown.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgDown.setIcon(new ImageIcon(imgD));

		JLabel imgAZ = new JLabel("");
		imgAZ.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgA.png")));
		panel_2.add(imgAZ, "cell 3 4,alignx center");
		ImageIcon iconAZ = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgA.png"));
		Image ordemAZ = iconAZ.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgAZ.setIcon(new ImageIcon(ordemAZ));

		JLabel imgZA = new JLabel("");
		imgZA.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgZ.png")));
		panel_2.add(imgZA, "cell 5 4,alignx center");
		ImageIcon iconZA = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/imgZ.png"));
		Image ordemZA = iconZA.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imgZA.setIcon(new ImageIcon(ordemZA));

		JRadioButton rbAguaSalgada = new JRadioButton("Água Salgada");
		panel_2.add(rbAguaSalgada, "cell 3 8,alignx center,aligny center");
		rbAguaSalgada.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JRadioButton rbAguaDoce = new JRadioButton("Água Doce");
		panel_2.add(rbAguaDoce, "cell 5 8,alignx center,aligny center");
		rbAguaDoce.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));
		ImageIcon iconMore = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/iconMore.png"));
		Image more = iconMore.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		JLabel imgMenu = new JLabel("");
		imgMenu.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/menu-hamburguer.png")));
		panel.add(imgMenu, "cell 0 0");
		ImageIcon menu = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/menu-hamburguer.png"));
		Image iconMenu = menu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgMenu.setIcon(new ImageIcon(iconMenu));

		JLabel imgCarrinho = new JLabel("");
		imgCarrinho.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png")));
		panel.add(imgCarrinho, "cell 2 0");
		ImageIcon carrinho = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/carrinho-de-compras.png"));
		Image imgC = carrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgCarrinho.setIcon(new ImageIcon(imgC));

		JLabel imgNotificacao = new JLabel("");
		imgNotificacao.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png")));
		panel.add(imgNotificacao, "cell 3 0");
		ImageIcon notificacao = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/sino.png"));
		Image imgN = notificacao.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgNotificacao.setIcon(new ImageIcon(imgN));
		
		/*Ver Perfil Vendedor */
		JLabel imgConta = new JLabel("");
		imgConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TelaPerfilVendedor telaPerfil = new TelaPerfilVendedor();
				//telaPerfil.setVisible(true);
				dispose();
			}
		});
		imgConta.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/do-utilizador.png")));
		panel.add(imgConta, "cell 4 0");
		ImageIcon conta = new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/do-utilizador.png"));
		Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		imgConta.setIcon(new ImageIcon(iconConta));

		JLabel lblMaiorValor = new JLabel("Maior Valor");
		panel_2.add(lblMaiorValor, "cell 3 2,alignx center");
		lblMaiorValor.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblMenorValor = new JLabel("Menor Valor");
		panel_2.add(lblMenorValor, "cell 5 2,alignx center");
		lblMenorValor.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JLabel lblAaZ = new JLabel("De A a Z");
		panel_2.add(lblAaZ, "cell 3 5,alignx center");
		lblAaZ.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JLabel lblZaA = new JLabel("De Z a A");
		panel_2.add(lblZaA, "cell 5 5,alignx center");
		lblZaA.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		JLabel imgMore = new JLabel("");
		imgMore.setIcon(new ImageIcon(TelaInicioVendedor.class.getResource("/IMG/iconMore.png")));
		panel_2.add(imgMore, "cell 1 10,alignx center");
		imgMore.setIcon(new ImageIcon(more));

		JLabel lblAdicionarProduto = new JLabel("Adicionar Produto");
		panel_2.add(lblAdicionarProduto, "cell 1 11,alignx center,aligny center");
		lblAdicionarProduto.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 12));

		ButtonGroup grupo = new ButtonGroup();

		grupo.add(rbAguaDoce);
		grupo.add(rbAguaSalgada);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "cell 3 1,grow");
		panel_3.setLayout(new MigLayout("", "[200px,grow][20px][200px,grow][20px][200px,grow][20px][200px,grow][20px]",
				"[][200px][]"));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(154, 205, 217));
		panel_3.add(panel_8, "cell 0 1,grow");
		panel_8.setLayout(new MigLayout("", "[][][][][][][][][][][]", "[][100px][][][][]"));

		JLabel lblNomeProduto = new JLabel("Nome");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_8.add(lblNomeProduto, "cell 0 3");

		JLabel lblQuantidadeEstoque = new JLabel("Contém X unidades");
		lblQuantidadeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_8.add(lblQuantidadeEstoque, "cell 10 3");

		JLabel lblPreco = new JLabel("R$");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_8.add(lblPreco, "cell 0 4");

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(2, 73, 89));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_8.add(btnNewButton, "cell 10 5");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(154, 205, 217));
		panel_3.add(panel_4, "cell 2 1,grow");
		panel_4.setLayout(new MigLayout("", "[]", "[][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_1, "cell 0 4");

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(154, 205, 217));
		panel_3.add(panel_5, "cell 4 1,grow");
		panel_5.setLayout(new MigLayout("", "[]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_5.add(lblNewLabel, "cell 0 4");

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(154, 205, 217));
		panel_3.add(panel_6, "cell 6 1,grow");
		panel_6.setLayout(new MigLayout("", "[]", "[][][][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_6.add(lblNewLabel_2, "cell 0 4");

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
