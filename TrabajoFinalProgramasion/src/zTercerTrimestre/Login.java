package zTercerTrimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Login extends JFrame {

	private JPanel contentPane;
	static Login login;
	private JTextField txtIntroduceTuCorreo;
	private JPasswordField pwdIntroduceTuContrasea;
	private JLabel VER;
	private JLabel OCULTAR;
	private JLabel lblIntroduceTuEmail_1_1_2;
	private JLabel lblIntroduceTuEmail_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("MUNDO ANIME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(0, 0, 572, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(192, -28, 195, 172);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/logo-removebg-preview (2) (1).png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(384, 0, 200, 200);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/23231-5-one-piece-chibi-image-thumb.png")));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/Images/titan (4).png")));
		lblNewLabel_1_1.setBounds(60, 0, 83, 117);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblIntroduceTuEmail = new JLabel("Correo Electrónico:");
		lblIntroduceTuEmail.setForeground(Color.BLACK);
		lblIntroduceTuEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblIntroduceTuEmail.setBounds(112, 179, 159, 30);
		contentPane.add(lblIntroduceTuEmail);
		
		JLabel lblIntroduceTuContrasea = new JLabel("Contraseña:");
		lblIntroduceTuContrasea.setForeground(Color.BLACK);
		lblIntroduceTuContrasea.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblIntroduceTuContrasea.setBounds(112, 261, 107, 30);
		contentPane.add(lblIntroduceTuContrasea);
		
		JLabel lblIntroduceTuEmail_1 = new JLabel("¡Bienvenido de Nuevo!");
		lblIntroduceTuEmail_1.setForeground(Color.BLACK);
		lblIntroduceTuEmail_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblIntroduceTuEmail_1.setBounds(169, 129, 237, 30);
		contentPane.add(lblIntroduceTuEmail_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8_Email_Sign_30px.png")));
		lblNewLabel_3_1.setBounds(75, 179, 33, 30);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8_password_30px.png")));
		lblNewLabel_3_1_1.setBounds(75, 261, 33, 30);
		contentPane.add(lblNewLabel_3_1_1);
		
		lblIntroduceTuEmail_1_1 = new JLabel("¿Has olvidado la contraseña?");
		lblIntroduceTuEmail_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIntroduceTuEmail_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new RecuperacionContraseña();
				frame.setVisible(true);
				dispose();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIntroduceTuEmail_1_1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 0)));		
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIntroduceTuEmail_1_1.setBorder(null);
			}
		});
		lblIntroduceTuEmail_1_1.setForeground(new Color(255, 128, 0));
		lblIntroduceTuEmail_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIntroduceTuEmail_1_1.setBounds(112, 342, 169, 24);
		contentPane.add(lblIntroduceTuEmail_1_1);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String correo = txtIntroduceTuCorreo.getText();
			    String contrasena = pwdIntroduceTuContrasea.getText();
			    if (correo.equals("Introduzca su Correo Electrónico") || contrasena.equals("Introduzca su Contraseña")) {
			        JOptionPane.showMessageDialog(contentPane, "Por favor, complete ambos campos.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
			    } else if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			        JOptionPane.showMessageDialog(contentPane, "Por favor, ingrese un correo electrónico válido.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
			    } else {
			        VerificarUsuario verificar = new VerificarUsuario();
			        boolean existeUsuario = VerificarUsuario.verificarUsuario2(correo);
			        if (existeUsuario) {
			            if (verificar.verificarUsuario(correo, contrasena)) {
			                JOptionPane.showMessageDialog(contentPane, "Correo electrónico y contraseña válidos. Permitiendo inicio de sesión.", "MUNDO ANIME", JOptionPane.INFORMATION_MESSAGE);
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Contraseña incorrecta.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
			            }
			        } else {
			            JOptionPane.showMessageDialog(contentPane, "Lo sentimos, el usuario no existe.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			}
		});
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnIniciarSesion.setBackground(new Color(0, 0, 0));
		btnIniciarSesion.setBounds(112, 380, 376, 30);
		contentPane.add(btnIniciarSesion);
		
		JLabel lblIntroduceTuEmail_1_1_1 = new JLabel("¿No estás registrado?");
		lblIntroduceTuEmail_1_1_1.setForeground(new Color(0, 0, 0));
		lblIntroduceTuEmail_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIntroduceTuEmail_1_1_1.setBounds(290, 339, 132, 30);
		contentPane.add(lblIntroduceTuEmail_1_1_1);
		
		lblIntroduceTuEmail_1_1_2 = new JLabel("Regístrate");
		lblIntroduceTuEmail_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIntroduceTuEmail_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new VentanaRegistro();
				frame.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIntroduceTuEmail_1_1_2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 0)));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIntroduceTuEmail_1_1_2.setBorder(null);
			}
		});
		lblIntroduceTuEmail_1_1_2.setForeground(new Color(255, 128, 0));
		lblIntroduceTuEmail_1_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIntroduceTuEmail_1_1_2.setBounds(426, 342, 62, 24);
		contentPane.add(lblIntroduceTuEmail_1_1_2);
		
		txtIntroduceTuCorreo = new JTextField();
		txtIntroduceTuCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtIntroduceTuCorreo.getText().equals("Introduzca su Correo Electrónico")) {
					txtIntroduceTuCorreo.setText("");
					txtIntroduceTuCorreo.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtIntroduceTuCorreo.getText().equals("")) {
					txtIntroduceTuCorreo.setText("Introduzca su Correo Electrónico");
					txtIntroduceTuCorreo.setForeground(new Color(71,75,78));
				}
			}
		});
		txtIntroduceTuCorreo.setToolTipText("");
		txtIntroduceTuCorreo.setText("Introduzca su Correo Electrónico");
		txtIntroduceTuCorreo.setForeground(Color.DARK_GRAY);
		txtIntroduceTuCorreo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		txtIntroduceTuCorreo.setColumns(10);
		txtIntroduceTuCorreo.setBackground(new Color(255, 128, 0));
		txtIntroduceTuCorreo.setBounds(112, 220, 376, 30);
		contentPane.add(txtIntroduceTuCorreo);
		
		pwdIntroduceTuContrasea = new JPasswordField();
		pwdIntroduceTuContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdIntroduceTuContrasea.getText().equals("Introduzca su Contraseña")) {
					pwdIntroduceTuContrasea.setText("");
					pwdIntroduceTuContrasea.setEchoChar('•');
					pwdIntroduceTuContrasea.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdIntroduceTuContrasea.getText().equals("")) {
					pwdIntroduceTuContrasea.setText("Introduzca su Contraseña");
					pwdIntroduceTuContrasea.setEchoChar((char)0);
					pwdIntroduceTuContrasea.setForeground(new Color(71,75,78));
				}
			}
		});
		pwdIntroduceTuContrasea.setText("Introduzca su Contraseña");
		pwdIntroduceTuContrasea.setForeground(Color.DARK_GRAY);
		pwdIntroduceTuContrasea.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		pwdIntroduceTuContrasea.setEchoChar(' ');
		pwdIntroduceTuContrasea.setBackground(new Color(255, 128, 0));
		pwdIntroduceTuContrasea.setBounds(112, 302, 376, 30);
		contentPane.add(pwdIntroduceTuContrasea);
		
		VER = new JLabel("");
		VER.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VER.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (!pwdIntroduceTuContrasea.getText().equals("Introduzca su Contraseña")) {
		            VER.setVisible(false);
		            OCULTAR.setVisible(true);
		            pwdIntroduceTuContrasea.setEchoChar((char)0);
		        } else {
		            JOptionPane.showMessageDialog(Login.this, "Introduzca una contraseña para visualizarla.");
		        }
		    }
		});
		VER.setIcon(new ImageIcon(Login.class.getResource("/Images/eye_30px.png")));
		VER.setBounds(492, 299, 30, 33);
		contentPane.add(VER);

		OCULTAR = new JLabel("");
		OCULTAR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OCULTAR.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (!pwdIntroduceTuContrasea.getText().equals("Introduzca su Contraseña")) {
		            VER.setVisible(true);
		            OCULTAR.setVisible(false);
		            pwdIntroduceTuContrasea.setEchoChar('•');
		        } else {
		            JOptionPane.showMessageDialog(Login.this, "Introduzca una contraseña para visualizarla.");
		        }
		    }
		});
		OCULTAR.setIcon(new ImageIcon(Login.class.getResource("/Images/invisible_30px.png")));
		OCULTAR.setBounds(492, 299, 30, 33);
		contentPane.add(OCULTAR);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Login.class.getResource("/Images/luffy gear2.gif")));
		lblNewLabel_1_1_1.setBounds(28, 93, 534, 360);
		contentPane.add(lblNewLabel_1_1_1);
		this.OCULTAR.setVisible(false);

	}
}
