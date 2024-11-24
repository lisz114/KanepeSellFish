package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaEsqueceuSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 TelaEsqueceuSenha frame = new TelaEsqueceuSenha(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaEsqueceuSenha(Usuario u) {
		setResizable(false);
		setLocationByPlatform(true);
		setMinimumSize(new Dimension(1176, 664));
		setMaximumSize(new Dimension(1920, 1080));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 487);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		PicPanel panel = new PicPanel("src//IMG/Background2.0.png");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][][70px]", "[70px][80px][30px][][30px][][][140px][][][]"));
		
		JLabel lblProblemas = new JLabel("Problemas Para Entrar?  ");
		panel.add(lblProblemas, "cell 1 1");
		lblProblemas.setForeground(Color.BLACK);
		lblProblemas.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblMsgEmail = new JLabel("Insira seu email e enviaremos um código para acessar sua conta.");
		panel.add(lblMsgEmail, "cell 1 3");
		lblMsgEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFeedback = new JLabel("");
		panel.add(lblFeedback, "cell 1 4,alignx center,aligny bottom");
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		panel.add(lblNewLabel_1, "flowx,cell 1 5,alignx center");
		
		JButton bntCodigo = new JButton("Enviar");
		bntCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				String email = txtEmail.getText();
				if(email.isEmpty()) {
					lblFeedback.setText("Por favor, insira um email");
				}else {
					EmailSender(u);
					lblFeedback.setText("Código enviado!");
				}
			}
		});
		bntCodigo.setBackground(new Color(64, 224, 208));
		panel.add(bntCodigo, "cell 1 6,alignx center");
		
		JLabel lblCriarConta = new JLabel("Criar nova conta");
		lblCriarConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				
				cadastro.setVisible(true);
				cadastro.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblCriarConta.setForeground(new Color(0, 0, 0));
		lblCriarConta.setBackground(new Color(0, 0, 255));
		panel.add(lblCriarConta, "cell 1 8,alignx center");
		lblCriarConta.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblou = new JLabel("ou");
		panel.add(lblou, "cell 1 9,alignx center");
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(255, 255, 255));
		panel.add(txtEmail, "cell 1 5,alignx center");
		txtEmail.setColumns(25);
		
		JLabel lblVoltarLogin = new JLabel("Voltar ao login");
		lblVoltarLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin login = new TelaLogin();
				
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblVoltarLogin.setForeground(new Color(0, 0, 0));
		panel.add(lblVoltarLogin, "cell 1 10,alignx center");
		lblVoltarLogin.setFont(new Font("Tahoma", Font.ITALIC, 14));
	}


	protected void EmailSender(Usuario u) {
		 String destinatario = u.getEmail(); // E-mail do usuário
	        String remetente = "vitoriaelisa114@gmail.com"; // Seu e-mail (remetente)
	        String senha = "neekolynx114"; // Senha do e-mail remetente

	        // Gerar um código aleatório
	        String codigoVerificacao = gerarCodigo();

	        // Configurações do servidor SMTP
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        // Autenticação
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(remetente, senha);
	            }
	        });

	        try {

	            Message mensagem = new MimeMessage(session);
	            mensagem.setFrom(new InternetAddress(remetente));
	            mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
	            mensagem.setSubject("Código de Verificação");
	            mensagem.setText("Seu código de verificação é: " + codigoVerificacao);

	            Transport.send(mensagem);

	            System.out.println("E-mail enviado com sucesso!");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String gerarCodigo() {
	        Random random = new Random();
	        int codigo = 1000 + random.nextInt(9000);
	        return String.valueOf(codigo);
	    }
	}
		