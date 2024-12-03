package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controle.ProdutoDAO;
import modelo.Produto;
import modelo.RoundButton;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValidade;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private static ProdutoDAO pDAO = ProdutoDAO.getInstancia();

	public TelaCadastroProduto(TelaEstoque janelaPrincipal, Usuario u) {
		setTitle("Cadastro de produto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroComercio.class.getResource("/img/logo.png")));
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(0, 0));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(154, 205, 217));
		getContentPane().add(panelBackground, BorderLayout.CENTER);
		panelBackground.setLayout(new MigLayout("", "[grow]", "[100px][300px,grow][100px]"));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setOpaque(false);
		panelBackground.add(panelTitulo, "cell 0 0,grow");

		JLabel lblTitulo = new JLabel("Adicionar Produto");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panelTitulo.add(lblTitulo);

		JPanel panelInformacoes = new JPanel();
		panelInformacoes.setOpaque(false);
		panelBackground.add(panelInformacoes, "cell 0 1,grow");
		panelInformacoes.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelEsquerda = new JPanel();
		panelEsquerda.setOpaque(false);
		panelEsquerda.setBorder(new EmptyBorder(0, 60, 0, 40));
		panelInformacoes.add(panelEsquerda);
		panelEsquerda
				.setLayout(new MigLayout("", "[grow]", "[50px][30px,grow][50px][30px,grow][50px][30px,grow][50px]"));

		txtNome = new JTextField();
		txtNome.setOpaque(false);
		txtNome.setToolTipText("");
		txtNome.setColumns(10);
		txtNome.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Nome<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtNome.setBackground(SystemColor.menu);
		panelEsquerda.add(txtNome, "cell 0 0,grow");

		txtValidade = new JTextField();
		txtValidade.setOpaque(false);
		txtValidade.setToolTipText("");
		txtValidade.setColumns(10);
		txtValidade.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Validade<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtValidade.setBackground(SystemColor.menu);
		panelEsquerda.add(txtValidade, "cell 0 2,grow");

		txtQuantidade = new JTextField();
		txtQuantidade.setToolTipText("");
		txtQuantidade.setOpaque(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Quantidade<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		txtQuantidade.setBackground(SystemColor.menu);
		panelEsquerda.add(txtQuantidade, "cell 0 4,grow");

		txtPreco = new JTextField();
		txtPreco.setToolTipText("");
		txtPreco.setOpaque(false);
		txtPreco.setColumns(10);
		txtPreco.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Preco<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtPreco.setBackground(SystemColor.menu);
		panelEsquerda.add(txtPreco, "cell 0 6,grow");

		JPanel panelDireita = new JPanel();
		panelDireita.setOpaque(false);
		panelDireita.setBorder(new EmptyBorder(5, 40, 0, 60));
		panelInformacoes.add(panelDireita);
		panelDireita.setLayout(new MigLayout("", "[grow]", "[200px][25px][40px]"));

		JPanel panelImage = new JPanel();
		panelImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelImage.setOpaque(false);
		panelDireita.add(panelImage, "cell 0 0,grow");

		JLabel lblAdcImagem = new JLabel("Adicionar Imagem");
		lblAdcImagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Adicionar imagem

			}
		});
		lblAdcImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdcImagem.setBorder(null);
		lblAdcImagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdcImagem.setForeground(new Color(0, 128, 255));
		panelDireita.add(lblAdcImagem, "cell 0 1,alignx right");

		JRadioButton rdbtnDoce = new JRadioButton("Água doce");
		rdbtnDoce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnDoce.setBorder(null);
		rdbtnDoce.setOpaque(false);
		rdbtnDoce.setSelected(true);
		panelDireita.add(rdbtnDoce, "flowx,cell 0 2");

		JRadioButton rdbtnSalgada = new JRadioButton("Água salgada");
		rdbtnSalgada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnSalgada.setBorder(null);
		rdbtnSalgada.setOpaque(false);
		panelDireita.add(rdbtnSalgada, "cell 0 2");

		ButtonGroup g = new ButtonGroup();
		g.add(rdbtnSalgada);
		g.add(rdbtnDoce);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setOpaque(false);
		panelBackground.add(panelBotoes, "cell 0 2,grow");
		panelBotoes.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelAdicionar = new JPanel();
		panelAdicionar.setOpaque(false);
		panelBotoes.add(panelAdicionar);
		panelAdicionar.setLayout(new MigLayout("", "[230px][130px]", "[5px][30px,grow][5px]"));

		JButton btnAdicionar = new RoundButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto prod = new Produto();
				
				String nome = txtNome.getText();
				String validadeStr = txtValidade.getText();
				String precoStr = txtPreco.getText();
				String quantidadeStr = txtQuantidade.getText();
				Boolean salinidade=rdbtnDoce.isSelected();
				

				// Verificação de campos vazios
				if (nome.isEmpty() || validadeStr.isEmpty() || precoStr.isEmpty() || quantidadeStr.isEmpty()) {
					TelaError erro = new TelaError();
					erro.setLabelText("Campos inseridos incorretamente");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				Float preco;
				int quantidade;
				LocalDate validade;
				try {
					preco = Float.parseFloat(precoStr);
					quantidade = Integer.parseInt(quantidadeStr);
					// Converter validadeStr para LocalDate
					validade = LocalDate.parse(validadeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				} catch (NumberFormatException | DateTimeParseException ex) {
					TelaError erro = new TelaError();
					erro.setLabelText("Preço, quantidade ou validade inválidos");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				// Verificação de valores negativos
				if (preco < 0 || quantidade < 0) {
					TelaError erro = new TelaError();
					erro.setLabelText("Preço e quantidade devem ser positivos");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				// Preenchendo os atributos do produto
				prod.setNome(nome);
				prod.setQuantidadeEstoque(quantidade);
				prod.setPreco(preco);
				prod.setValidade(validade); // Descomente se necessário
				prod.setSalinidade(salinidade);

				if (pDAO.inserirProduto(prod, u)) {
					janelaPrincipal.atualizarTabela(u);
					dispose();
					TelaError erro = new TelaError();
					erro.setLabelText("Adicionado com sucesso");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {
					TelaError erro = new TelaError();
					erro.setLabelText("Erro ao adicionar");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
			}
		});

		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBackground(new Color(2, 73, 89));
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setBorderPainted(false);
		panelAdicionar.add(btnAdicionar, "cell 1 1,grow");

		JPanel panelCancelar = new JPanel();
		panelCancelar.setOpaque(false);
		panelBotoes.add(panelCancelar);
		panelCancelar.setLayout(new MigLayout("", "[130px][grow]", "[5px][30px,grow][5px]"));

		JButton btnCancelar = new RoundButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBackground(new Color(200, 0, 0));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBorderPainted(false);
		panelCancelar.add(btnCancelar, "cell 0 1,grow");
	}

}
