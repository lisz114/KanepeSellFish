package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import controle.UsuarioDAO;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaEditarPerfilCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	UsuarioDAO udao = UsuarioDAO.getInstancia();
	TelaEditarPerfilCliente estajanela = this;
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaEditarPerfilCliente frame = new TelaEditarPerfilCliente();
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
	public TelaEditarPerfilCliente(Usuario u, boolean isVendedor) {
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
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[250][450px,grow][grow]", "[60px][202][][][][grow]"));

		JLabel imgPerfil = new JLabel("");
		panel_1.add(imgPerfil, "flowx,cell 0 1,alignx center,aligny center");
		imgPerfil.setIcon(new ImageIcon(TelaEditarPerfilCliente.class.getResource("/img/Avatar.png")));

		txtNome = new JTextField();
		panel_1.add(txtNome, "flowx,cell 1 1,growx,aligny center");
		txtNome.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Nome", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtNome.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 30));
		txtNome.setOpaque(false);
		txtNome.setColumns(10);
		txtNome.setText(u.getNome());

		txtEmail = new JTextField();
		panel_1.add(txtEmail, "cell 1 2,growx,aligny center");
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtEmail.setOpaque(false);
		txtEmail.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "email", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtEmail.setText(String.valueOf(u.getEmail()));

		JLabel lblCpf = new JLabel("");
		panel_1.add(lblCpf, "cell 1 3,growx,aligny center");
		lblCpf.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "CPF", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblCpf.setFont(new Font("/Fontes/Roboto-Black.ttf", Font.PLAIN, 14));
		lblCpf.setText(u.getCpf());
		lblCpf.setToolTipText("Cpf não pode ser alterado.");

		JTextField txtTelefone = new JTextField();
		txtTelefone.setOpaque(false);
		panel_1.add(txtTelefone, "cell 1 4,growx,aligny center");
		txtTelefone.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "telefone", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		txtTelefone.setColumns(10);

		RestrictedTextField validarTel = new RestrictedTextField(txtTelefone);
		validarTel.setOnlyNums(true);
		validarTel.setLimit(11);

		if (u.getTel() == null || u.getTel().isEmpty()) {
			txtTelefone.setText("");
		} else {
			txtTelefone.setText(u.getTel());
		}

		JButton btCancelar = new JButton("Cancelar");
		panel_1.add(btCancelar, "flowx,cell 2 5,alignx right,aligny bottom");

		JButton btSalvar = new JButton("Salvar");
		panel_1.add(btSalvar, "cell 2 5,alignx right,aligny bottom");
		btSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Usuario usuarioNovo = new Usuario();
//
//				// Consulta do produtor atual
//				Usuario clienteAntigo = udao.consultaUsuarioCadastrado(u.getCpf(), u.getEmail());

				// Validação de campos obrigatórios
				if (txtEmail.getText().isEmpty() || txtNome.getText().isEmpty()) {
				    TelaError tela = new TelaError();
				    tela.setLabelText("Preencha todos os campos obrigatórios.");
				    tela.setLocationRelativeTo(null);
				    tela.setVisible(true);
				    return;
				} 

				// Coleta de dados do formulário
				String email = txtEmail.getText();
				String nome = txtNome.getText();
				String telefone = txtTelefone.getText();

				// **Verifica diretamente se o telefone pertence a outro usuário**
				if (udao.verificarTelefone(telefone, u.getIdUsuario())) {
				    TelaError erro = new TelaError();
				    erro.setLabelText("Telefone já cadastrado por outro usuário.");
				    erro.setVisible(true);
				    erro.setLocationRelativeTo(null);
				    return; // Impede a atualização no banco
				}

				// Populando os objetos
				usuarioNovo.setEmail(email);
				usuarioNovo.setNome(nome);
				usuarioNovo.setTel(telefone);
				usuarioNovo.setIdUsuario(u.getIdUsuario());

				boolean clienteAtualizado = udao.alterarUsuario(usuarioNovo);

				if (clienteAtualizado) {
				    usuarioNovo = udao.consultarUsuarioLoginSenha(usuarioNovo.getEmail(), u.getSenha());

				    TelaPerfilCliente v = new TelaPerfilCliente(usuarioNovo, isVendedor);
				    v.setLocationRelativeTo(null);
				    v.setVisible(true);

				    TelaError tela = new TelaError();
				    tela.setLabelText("Dados atualizados com sucesso!");
				    tela.setLocationRelativeTo(null);
				    tela.setVisible(true);
				    dispose();
				} else {
				    TelaError tela = new TelaError();
				    tela.setLabelText("Erro ao atualizar os dados do cliente.");
				    tela.setLocationRelativeTo(null);
				    tela.setVisible(true);
				}

			}
		});
		btSalvar.setBackground(new Color(64, 128, 128));
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopupCancelar cancelar = new PopupCancelar(estajanela, null, u, isVendedor);
				cancelar.setVisible(true);
				cancelar.setLocationRelativeTo(null);
			}
		});

	}

}
