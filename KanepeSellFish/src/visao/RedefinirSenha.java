package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;

public class RedefinirSenha extends JFrame {

    private JTextField txtCodigo;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    private JPanel painelRedefinicao;

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedefinirSenha frame = new RedefinirSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    public RedefinirSenha() {
    	setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 487);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));

        // Etapa 2: Redefinir a Senha
        painelRedefinicao = new JPanel();
        painelRedefinicao.setBounds(10, 111, 340, 120);
        painelRedefinicao.setVisible(false); // Oculto inicialmente
        getContentPane().add(painelRedefinicao);
        painelRedefinicao.setLayout(new MigLayout("", "[120px][200px]", "[25px][25px][34px]"));

        JLabel lblSenha = new JLabel("Nova Senha:");
        painelRedefinicao.add(lblSenha, "cell 0 0,grow");

        txtSenha = new JPasswordField();
        painelRedefinicao.add(txtSenha, "cell 1 0,grow");

        JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
        painelRedefinicao.add(lblConfirmarSenha, "cell 0 1,grow");

        txtConfirmarSenha = new JPasswordField();
        painelRedefinicao.add(txtConfirmarSenha, "cell 1 1,grow");

        JButton btnConfirmar = new JButton("Confirmar");
        painelRedefinicao.add(btnConfirmar, "cell 1 2,grow");
        
                JLabel lblFeedback = new JLabel("");
                painelRedefinicao.add(lblFeedback, "cell 0 2 2 1,grow");
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 374, 108);
        getContentPane().add(panel, BorderLayout.WEST);
                panel.setLayout(new MigLayout("", "[298px]", "[25px][30px]"));
        
                // Etapa 1: Inserir o Código
                JLabel lblCodigo = new JLabel("Código de Verificação:");
                panel.add(lblCodigo, "cell 0 0,alignx left,aligny center");
                
                        txtCodigo = new JTextField();
                        txtCodigo.setColumns(10);
                        panel.add(txtCodigo, "cell 0 0,alignx center,growy");
                        
                                JButton btnValidarCodigo = new JButton("Validar Código");
                                panel.add(btnValidarCodigo, "cell 0 1,alignx center,aligny center");

        // Evento do botão Validar Código
        btnValidarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String codigo = txtCodigo.getText();
//                if (codigo.isEmpty()) {
//                    lblFeedback.setText("Por favor, insira o código.");
//                } else if (validarCodigo(codigo)) {
//                    lblFeedback.setText("Código válido! Redefina sua senha.");
                    painelRedefinicao.setVisible(true); // Exibe os campos de redefinição
                    panel.setVisible(false);
//                } else {
//                    lblFeedback.setText("Código inválido. Tente novamente.");
//                }
            }
        });

        // Evento do botão Confirmar
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = new String(txtSenha.getPassword());
                String confirmarSenha = new String(txtConfirmarSenha.getPassword());

                if (senha.isEmpty() || confirmarSenha.isEmpty()) {
                    lblFeedback.setText("Preencha todos os campos.");
                } else if (!senha.equals(confirmarSenha)) {
                    lblFeedback.setText("As senhas não coincidem.");
                } else {
                    redefinirSenha(senha); // Chama o método para redefinir a senha no backend
                    lblFeedback.setText("Senha redefinida com sucesso!");
                }
            }
        });
    }

    // Simula a validação do código de verificação
    private boolean validarCodigo(String codigo) {
        return codigo.equals("123456"); // Substitua pela lógica real (ex: validação no banco)
    }

    // Simula a redefinição de senha
    private void redefinirSenha(String novaSenha) {
        // Implemente a lógica para salvar a nova senha no banco de dados
        System.out.println("Senha redefinida para: " + novaSenha);
    }
}

