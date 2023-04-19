package zTercerTrimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDatos.Conexion;

import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextField;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword1;
	private JPasswordField txtPassword2;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtSurname;
	private JTextField txtName;
	private JLabel OCULTAR;
	private JLabel VER;
	private JLabel OCULTAR2;
	private JLabel VER2;
	private JComboBox comboBox;
	private JLabel lblIntroduceTuEmail_1_1;
	static VentanaRegistro ventana_registro;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_registro = new VentanaRegistro();
					ventana_registro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Razer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 786);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Name");
		lblNombre.setBounds(87, 161, 65, 30);
		lblNombre.setForeground(Color.GREEN);
		lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(87, 241, 79, 30);
		lblEmail.setForeground(Color.GREEN);
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 480, 86, 30);
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Repeat Password");
		lblConfirmPassword.setBounds(59, 563, 145, 30);
		lblConfirmPassword.setForeground(Color.GREEN);
		lblConfirmPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblConfirmPassword);
		
		JLabel lblPhoneNumber = new JLabel("Phone");
		lblPhoneNumber.setBounds(81, 321, 71, 30);
		lblPhoneNumber.setForeground(Color.GREEN);
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblPhoneNumber);
		
		txtPassword1 = new JPasswordField();
		txtPassword1.setBounds(196, 480, 311, 30);
		txtPassword1.setForeground(Color.DARK_GRAY);
		txtPassword1.setEchoChar((char)0);
		txtPassword1.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword1.getText().equals("Introduzca su Contraseña")) {
					txtPassword1.setText("");
					txtPassword1.setEchoChar('•');
					txtPassword1.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword1.getText().equals("")) {
					txtPassword1.setText("Introduzca su Contraseña");
					txtPassword1.setEchoChar((char)0);
					txtPassword1.setForeground(new Color(71,75,78));
				}
			}
		});
		txtPassword1.setBackground(Color.WHITE);
		txtPassword1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(txtPassword1);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(196, 563, 311, 30);
		txtPassword2.setToolTipText("");
		txtPassword2.setForeground(Color.DARK_GRAY);
		txtPassword2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword2.getText().equals("Confirme su Contraseña")) {
					txtPassword2.setText("");
					txtPassword2.setEchoChar('•');
					txtPassword2.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword2.getText().equals("")) {
					txtPassword2.setText("Confirme su Contraseña");
					txtPassword2.setEchoChar((char)0);
					txtPassword2.setForeground(new Color(71,75,78));
				}
			}
		});
		txtPassword2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		txtPassword2.setBackground(Color.WHITE);
		contentPane.add(txtPassword2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(196, 242, 311, 30);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setText("example@gmail.com");
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmail.getText().equals("example@gmail.com")) {
					txtEmail.setText("");
					txtEmail.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().equals("")) {
					txtEmail.setText("example@gmail.com");
					txtEmail.setForeground(new Color(71,75,78));
				}
			}
		});
		txtEmail.setToolTipText("");
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		contentPane.add(txtEmail);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(196, 322, 311, 30);
		txtPhone.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
			    boolean numeros = key >= 48 && key <= 57;
			    if (!numeros)
			    {
			        e.consume();
			    }
			    if (txtPhone.getText().trim().length() == 9) {
			        e.consume();
			    }
			}
		});
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPhone.getText().equals("Phone Number")) {
					txtPhone.setText("");
					txtPhone.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPhone.getText().equals("")) {
					txtPhone.setText("Phone Number");
					txtPhone.setForeground(new Color(71, 75, 78));
				}
			}
			
		});
		txtPhone.setText("Phone Number");
		txtPhone.setToolTipText("");
		txtPhone.setForeground(Color.DARK_GRAY);
		txtPhone.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		txtPhone.setColumns(10);
		txtPhone.setBackground(Color.WHITE);
		contentPane.add(txtPhone);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(214, 678, 169, 45);
		final AñadirUsuarioBBDD addBBDD = new AñadirUsuarioBBDD();
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if(txtName.getText().equals("Enter your name") || txtSurname.getText().equals("Enter your Last Name") || txtEmail.getText().equals("example@gmail.com") || txtPassword1.getText().equals("Introduzca su Contraseña") || txtPassword2.getText().equals("Confirme su Contraseña") || txtPhone.getText().equals("Phone number")) {
		            JOptionPane.showMessageDialog(contentPane, "Por favor, rellene todos los campos.","Razer",JOptionPane.ERROR_MESSAGE);
		        } else if (!txtEmail.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
		            JOptionPane.showMessageDialog(contentPane, "Por favor, ingrese un correo electrónico válido.","Razer",JOptionPane.ERROR_MESSAGE);
		        } else if (!txtPassword1.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{8,}$")) {
		            JOptionPane.showMessageDialog(contentPane, "La contraseña debe tener al menos 8 caracteres, incluyendo al menos una letra mayúscula, una letra minúscula, un número y un carácter especial (@#$%^&+=*). Por favor, vuelva a intentarlo.","MUNDO ANIME",JOptionPane.ERROR_MESSAGE);
		        } else if (!txtPhone.getText().matches("\\d{9}")) {
		            JOptionPane.showMessageDialog(contentPane, "El número de teléfono debe tener 9 dígitos. Por favor, vuelva a intentarlo.","Razer",JOptionPane.ERROR_MESSAGE);
		        } else if (comboBox.getSelectedItem().equals("Seleccione su País")) {
		            JOptionPane.showMessageDialog(contentPane, "Por favor, seleccione un país.","MUNDO ANIME",JOptionPane.ERROR_MESSAGE);
		        } else if (!txtPassword1.getText().equals(txtPassword2.getText())) {
		            JOptionPane.showMessageDialog(contentPane, "Las contraseñas no coinciden. Por favor, vuelva a intentarlo.","MUNDO ANIME",JOptionPane.ERROR_MESSAGE);
		        } else {
		            String correo = txtEmail.getText();
		            // Verificar si el correo electrónico ya existe en la base de datos
		            boolean correoExistente = VerificarUsuario.verificarUsuario2(correo);
		            if (correoExistente) {
		                JOptionPane.showMessageDialog(contentPane, "El correo electrónico ya está registrado. Por favor, ingrese otro correo electrónico.","Razer",JOptionPane.ERROR_MESSAGE);
		            } else {
		                addBBDD.agregarUsuario(txtName.getText(), txtSurname.getText(), txtEmail.getText(), txtPassword1.getText(), txtPhone.getText(), comboBox.getSelectedItem().toString());
		                JOptionPane.showMessageDialog(contentPane, "¡Registro Completado!","Razer",JOptionPane.INFORMATION_MESSAGE);
		            JFrame frame = new Login();
		            frame.setVisible(true);
		            dispose();
		            }
		        }
		    }
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(0, 0, 0));
		contentPane.add(btnNewButton);
		
		JLabel lblYouAreAlready = new JLabel("Do you already have an account?");
		lblYouAreAlready.setBounds(148, 637, 208, 30);
		lblYouAreAlready.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblYouAreAlready.setForeground(Color.GREEN);
		lblYouAreAlready.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		contentPane.add(lblYouAreAlready);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(352, 162, 153, 30);
		txtSurname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			        e.consume();
			    }
			}
		});
		txtSurname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSurname.getText().equals("Enter your Last Name")) {
					txtSurname.setText("");
					txtSurname.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSurname.getText().equals("")) {
					txtSurname.setText("Enter your Last Name");
					txtSurname.setForeground(new Color(71,75,78));
				}
			}
		});
		txtSurname.setText("Enter your Last Name");
		txtSurname.setToolTipText("");
		txtSurname.setForeground(Color.DARK_GRAY);
		txtSurname.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		txtSurname.setColumns(10);
		txtSurname.setBackground(Color.WHITE);
		contentPane.add(txtSurname);
		
		JLabel lblSelectYourCountry = new JLabel("Select Your Region");
		lblSelectYourCountry.setBounds(59, 411, 164, 30);
		lblSelectYourCountry.setForeground(Color.GREEN);
		lblSelectYourCountry.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblSelectYourCountry);
		
		comboBox = new JComboBox();
		comboBox.setBounds(196, 413, 319, 30);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Your Region", "España", "Francia", "Estados Unidos", "México", "Alemania", "Reino Unido", "Italia"}));
		comboBox.setBackground(Color.WHITE);
		contentPane.add(comboBox);
		
		txtName = new JTextField();
		txtName.setBounds(196, 163, 135, 28);
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			        e.consume();
			    }
			}
		});
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtName.getText().equals("Enter your Name")) {
					txtName.setText("");
					txtName.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals("")) {
					txtName.setText("Enter your Name");
					txtName.setForeground(new Color(71,75,78));
				}
			}
		});
		txtName.setForeground(Color.DARK_GRAY);
		txtName.setBackground(Color.WHITE);
		txtName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		txtName.setText("Enter your Name");
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		lblIntroduceTuEmail_1_1 = new JLabel("Log In");
		lblIntroduceTuEmail_1_1.setBounds(366, 641, 54, 23);
		lblIntroduceTuEmail_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIntroduceTuEmail_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new Login();
				frame.setVisible(true);
				dispose();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			    lblIntroduceTuEmail_1_1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 139)));     
			}
			@Override
			public void mouseExited(MouseEvent e) {
			    lblIntroduceTuEmail_1_1.setBorder(null);           
			}
		});
		lblIntroduceTuEmail_1_1.setForeground(Color.BLUE);
		lblIntroduceTuEmail_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		contentPane.add(lblIntroduceTuEmail_1_1);
		
		VER = new JLabel("");
		VER.setBounds(517, 480, 30, 33);
		VER.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VER.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (!txtPassword1.getText().equals("Password")) {
		            VER.setVisible(false);
		            OCULTAR.setVisible(true);
		            txtPassword1.setEchoChar((char)0);
		        } else {
		            JOptionPane.showMessageDialog(VentanaRegistro.this, "Introduzca una contraseña para visualizarla.");
		        }
		    }
		});
		VER.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/Images/eye_30px.png")));
		contentPane.add(VER);

		OCULTAR = new JLabel("");
		OCULTAR.setBounds(517, 480, 30, 33);
		OCULTAR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OCULTAR.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (!txtPassword1.getText().equals("Introduzca su Contraseña")) {
		            VER.setVisible(true);
		            OCULTAR.setVisible(false);
		            txtPassword1.setEchoChar('•');
		        } else {
		            JOptionPane.showMessageDialog(VentanaRegistro.this, "Introduzca una contraseña para visualizarla.");
		        }
		    }
		});
		OCULTAR.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/Images/invisible_30px.png")));
		contentPane.add(OCULTAR);
		this.OCULTAR.setVisible(false);

		VER2 = new JLabel("");
		VER2.setBounds(517, 563, 30, 33);
		VER2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VER2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (!txtPassword2.getText().equals("Confirme su Contraseña")) {
		            VER2.setVisible(false);
		            OCULTAR2.setVisible(true);
		            txtPassword2.setEchoChar((char)0);
		        } else {
		            JOptionPane.showMessageDialog(VentanaRegistro.this, "Introduzca una contraseña para visualizarla.");
		        }
		    }
		});
		VER2.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/Images/eye_30px.png")));
		contentPane.add(VER2);

		OCULTAR2 = new JLabel("");
		OCULTAR2.setBounds(517, 563, 30, 33);
		OCULTAR2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OCULTAR2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (!txtPassword2.getText().equals("Confirme su Contraseña")) {
		            VER2.setVisible(true);
		            OCULTAR2.setVisible(false);
		            txtPassword2.setEchoChar('•');
		        } else {
		            JOptionPane.showMessageDialog(VentanaRegistro.this, "Introduzca una contraseña para visualizarla.");
		        }
		    }
		});
		OCULTAR2.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/Images/invisible_30px.png")));
		contentPane.add(OCULTAR2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(285, 170, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/Images/HD-wallpaper-black-stylish-background-green-neon-lines-green-light-effects-abstract-black-background (1).jpg")));
		lblNewLabel.setBounds(0, 11, 572, 772);
		contentPane.add(lblNewLabel);
		this.OCULTAR2.setVisible(false);

	}
}

