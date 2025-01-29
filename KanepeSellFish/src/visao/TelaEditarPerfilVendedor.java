
package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.format.DateTimeParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import controle.EnderecoDAO;
import controle.ProdutorDAO;
import controle.UsuarioDAO;
import modelo.Endereco;
import modelo.Produtor;
import modelo.RoundButton;
import modelo.Usuario;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

public class TelaEditarPerfilVendedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtCNPJ;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtLogradouro;
	private JTextField txtNum;

	private static UsuarioDAO uDAO = UsuarioDAO.getInstancia();
	private static EnderecoDAO eDAO = EnderecoDAO.getInstancia();
	private static ProdutorDAO pDAO = ProdutorDAO.getInstancia();
	private JTextField txtCelular;
	private JTextField txtCEP;
	private JTextField txtNomeComercio;
	private JLabel lblImagem;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaEditarVendedor frame = new TelaEditarVendedor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaEditarPerfilVendedor(Usuario u) {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setOpaque(false);

		JLabel imgAvatar = new JLabel("");
		imgAvatar.setIcon(new ImageIcon(TelaEditarPerfilVendedor.class.getResource("/img/Avatar.png")));
		panel_1.setLayout(new MigLayout("", "[250][400px,grow][grow]", "[60px][202px][][][][][grow]"));

		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 30));
		panel_1.add(lblNome, "cell 1 1,alignx left,aligny center");
		panel_1.add(imgAvatar, "cell 0 1,alignx center,aligny center");
		lblNome.setText(u.getNome());

		txtNomeComercio = new JTextField();
		txtNomeComercio.setToolTipText("");
		txtNomeComercio.setText((String) null);
		txtNomeComercio.setOpaque(false);
		txtNomeComercio.setColumns(10);
		txtNomeComercio.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Nome do comercio<span style='color: red;'>*</span></html>", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtNomeComercio.setBackground(SystemColor.menu);
		txtNomeComercio.setText(pDAO.consultaProdutor(u).getNomeComercio());
		panel_1.add(txtNomeComercio, "cell 1 2,grow");

		txtCidade = new JTextField();
		panel_1.add(txtCidade, "flowx,cell 2 2");
		txtCidade.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCidade.setOpaque(false);
		txtCidade.setToolTipText("");
		txtCidade.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Cidade<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCidade.setBackground(SystemColor.menu);
		txtCidade.setColumns(10);
		txtCidade.setText(pDAO.consultaProdutor(u).getEnd().getCidade());

		txtBairro = new JTextField();
		panel_1.add(txtBairro, "cell 2 2");
		txtBairro.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtBairro.setOpaque(false);
		txtBairro.setToolTipText("");
		txtBairro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Bairro<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtBairro.setBackground(SystemColor.menu);
		txtBairro.setColumns(10);
		txtBairro.setText(pDAO.consultaProdutor(u).getEnd().getBairro());

		txtNome = new JTextField();
		txtNome.setOpaque(false);
		txtNome.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Nome", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtNome.setText(u.getNome());
		panel_1.add(txtNome, "cell 1 3,growx");
		txtNome.setColumns(10);
		txtCPF = new JTextField();
		txtCPF.setDisabledTextColor(new Color(0, 0, 0));
		txtCPF.setCaretColor(new Color(0, 0, 0));
		txtCPF.setEnabled(false);
		txtCPF.setEditable(false);
		panel_1.add(txtCPF, "flowx,cell 1 4");
		txtCPF.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCPF.setOpaque(false);
		txtCPF.setToolTipText("");
		txtCPF.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),"CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCPF.setBackground(SystemColor.menu);
		txtCPF.setColumns(10);
		txtCPF.setText(u.getCpf());

		txtCEP = new JTextField();
		txtCEP.setToolTipText("");
		txtCEP.setText("0");
		txtCEP.setOpaque(false);
		txtCEP.setColumns(10);
		txtCEP.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CEP<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCEP.setBackground(SystemColor.menu);
		txtCEP.setText(pDAO.consultaProdutor(u).getEnd().getCep());
		panel_1.add(txtCEP, "flowx,cell 2 4,growy");

		txtEmail = new JTextField();
		panel_1.add(txtEmail, "flowx,cell 1 5,growy");
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtEmail.setOpaque(false);
		txtEmail.setToolTipText("");
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Email<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setColumns(10);
		txtEmail.setText(u.getEmail());

		txtLogradouro = new JTextField();
		panel_1.add(txtLogradouro, "flowx,cell 2 5");
		txtLogradouro.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtLogradouro.setOpaque(false);
		txtLogradouro.setToolTipText("");
		txtLogradouro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Logadouro<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		txtLogradouro.setBackground(SystemColor.menu);
		txtLogradouro.setColumns(10);
		txtLogradouro.setText(pDAO.consultaProdutor(u).getEnd().getLogradouro());

		JButton btnNewButton = new RoundButton("Cancelar");
		panel_1.add(btnNewButton, "flowx,cell 2 6,alignx right,aligny bottom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfilVendedor frame = new TelaPerfilVendedor(u, true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));

		JButton btnNewButton_1 = new RoundButton("Salvar");
		panel_1.add(btnNewButton_1, "cell 2 6,alignx right,aligny bottom");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtor produtorNovo = new Produtor();
				Endereco enderecoNovo = new Endereco();
				Usuario usuarioNovo = new Usuario();

				// Consulta do produtor atual
				Produtor produtorAntigo = pDAO.consultaProdutor(u);

				// Validação de campos obrigatórios
				if (txtCNPJ.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNomeComercio.getText().isEmpty()
						|| txtBairro.getText().isEmpty() || txtCEP.getText().isEmpty() || txtCidade.getText().isEmpty()
						|| txtLogradouro.getText().isEmpty() || txtNum.getText().isEmpty()) {

					TelaError tela = new TelaError();
					tela.setLabelText("Dados preenchidos incorretamente. Preencha todos os campos obrigatórios.");
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
				}

				// Coleta de dados do formulário
				String CNPJ = txtCNPJ.getText();
				String Email = txtEmail.getText();
				String NomeComercio = txtNomeComercio.getText();
				String Telefone = txtCelular.getText();
				String Bairro = txtBairro.getText();
				String CEP = txtCEP.getText();
				String Cidade = txtCidade.getText();
				String Logradouro = txtLogradouro.getText();
				Integer Numero = Integer.valueOf(txtNum.getText());
				String nome = txtNome.getText();

				// Populando os objetos
				enderecoNovo.setBairro(Bairro);
				enderecoNovo.setCep(CEP);
				enderecoNovo.setCidade(Cidade);
				enderecoNovo.setLogradouro(Logradouro);
				enderecoNovo.setNumero(Numero);

				produtorNovo.setCnpj(CNPJ);
				produtorNovo.setEmail(Email);
				produtorNovo.setEnd(enderecoNovo);
				produtorNovo.setNomeComercio(NomeComercio);
				produtorNovo.setTel(Telefone);

				usuarioNovo.setEmail(Email);
				usuarioNovo.setTel(Telefone);
				usuarioNovo.setNome(nome);
				usuarioNovo.setIdUsuario(u.getIdUsuario());

				// Atualização ou inserção
				if (produtorAntigo != null) {
					enderecoNovo.setIdEndereco(produtorAntigo.getEnd().getIdEndereco());
					int enderecoAtualizado = eDAO.atualizarEndereco(enderecoNovo);

					if (enderecoAtualizado > 0) {
						produtorNovo.setIdUsuario(u.getIdUsuario());
						produtorNovo.setEndereco(enderecoNovo.getIdEndereco());
						boolean produtorAtualizado = pDAO.alterarProdutor(produtorNovo, usuarioNovo);

						if (produtorAtualizado) {
							TelaPerfilVendedor v = new TelaPerfilVendedor(u, true);
							v.setLocationRelativeTo(null);
							v.setVisible(true);
							dispose();
							TelaError tela = new TelaError();
							tela.setLabelText("Dados atualizados com sucesso!");
							tela.setLocationRelativeTo(null);
							tela.setVisible(true);
						} else {
							TelaError tela = new TelaError();
							tela.setLabelText("Erro ao atualizar os dados do produtor.");
							tela.setLocationRelativeTo(null);
							tela.setVisible(true);
						}
					} else {
						TelaError tela = new TelaError();
						tela.setLabelText("Erro ao atualizar o endereço.");
						tela.setLocationRelativeTo(null);
						tela.setVisible(true);
					}
				} else {
					int enderecoId = eDAO.inserirEnderecoDoComercio(enderecoNovo);

					if (enderecoId > 0) {
						produtorNovo.setIdUsuario(u.getIdUsuario());
						produtorNovo.setEndereco(enderecoId);
						boolean produtorInserido = pDAO.inserirProdutor(produtorNovo);

						if (produtorInserido) {
							TelaPerfilVendedor v = new TelaPerfilVendedor(u, true);
							v.setLocationRelativeTo(null);
							v.setVisible(true);
							dispose();
							TelaError tela = new TelaError();
							tela.setLabelText("Dados salvos com sucesso!");
							tela.setLocationRelativeTo(null);
							tela.setVisible(true);
						} else {
							TelaError tela = new TelaError();
							tela.setLabelText("Erro ao salvar os dados do produtor.");
							tela.setLocationRelativeTo(null);
							tela.setVisible(true);
						}
					} else {
						TelaError tela = new TelaError();
						tela.setLabelText("Erro ao salvar o endereço.");
						tela.setLocationRelativeTo(null);
						tela.setVisible(true);
					}
				}
			}

		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(96, 154, 168));

		txtCelular = new JTextField();
		txtCelular.setToolTipText("");
		txtCelular.setOpaque(false);
		txtCelular.setColumns(10);
		txtCelular.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCelular.setOpaque(false);
		txtCelular.setToolTipText("");
		txtCelular.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Celular", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtCelular.setBackground(SystemColor.menu);
		txtCelular.setText(u.getTel());

		panel_1.add(txtCelular, "cell 1 5");

		txtCNPJ = new JTextField();
		panel_1.add(txtCNPJ, "cell 1 4");
		txtCNPJ.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtCNPJ.setOpaque(false);
		txtCNPJ.setToolTipText("");
		txtCNPJ.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>CNPJ<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtCNPJ.setBackground(SystemColor.menu);
		txtCNPJ.setColumns(10);
		txtCNPJ.setText(pDAO.consultaProdutor(u).getCnpj());

		txtNum = new JTextField();
		panel_1.add(txtNum, "cell 2 5");
		txtNum.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtNum.setOpaque(false);
		txtNum.setToolTipText("");
		txtNum.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"<html>Num<span style='color: red;'>*</span></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		txtNum.setBackground(SystemColor.menu);
		txtNum.setColumns(10);
		txtNum.setText(String.valueOf(pDAO.consultaProdutor(u).getEnd().getNumero()));

		lblImagem = new JLabel("");
		panel_1.add(lblImagem, "cell 2 4");

		lblImagem.setToolTipText("Procurar CEP");
		lblImagem.setName("");
		lblImagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Endereco endereco = eDAO.buscaCEP(txtCEP.getText());
				txtLogradouro.setText(endereco.getLogradouro());
				txtBairro.setText(endereco.getBairro());
				txtCidade.setText(endereco.getCidade());

			}
		});
		lblImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImagem.setIcon(new ImageIcon(TelaCadastroComercio.class.getResource("/img/procurar.png")));
		ImageIcon iconProcurar = new ImageIcon(TelaCadastroComercio.class.getResource("/IMG/procurar.png"));
		Image iconP = iconProcurar.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		lblImagem.setIcon(new ImageIcon(iconP));

		ImageIcon conta = new ImageIcon(TelaInicio.class.getResource("/IMG/do-utilizador.png"));
		Image iconConta = conta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	}
}