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
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;

public class RecuperacionContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblIntroduceTuEmail_1_1;
	static RecuperacionContraseña recuperar_contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recuperar_contraseña = new RecuperacionContraseña();
					recuperar_contraseña.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RecuperacionContraseña() {
		setTitle("MUNDO ANIME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(0, 0, 572, 117);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RecuperacionContraseña.class.getResource("/Images/logo-removebg-preview (2) (1).png")));
		lblNewLabel.setBounds(192, -28, 195, 172);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RecuperacionContraseña.class.getResource("/Images/23231-5-one-piece-chibi-image-thumb.png")));
		lblNewLabel_1.setBounds(384, 0, 200, 200);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(60, 0, 83, 117);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon(RecuperacionContraseña.class.getResource("/Images/titan (4).png")));
		
		JLabel lblIntroduceTuEmail_1 = new JLabel("• Modifique su Contraseña •");
		lblIntroduceTuEmail_1.setForeground(Color.BLACK);
		lblIntroduceTuEmail_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblIntroduceTuEmail_1.setBounds(132, 128, 319, 30);
		contentPane.add(lblIntroduceTuEmail_1);
		
		JTextPane txtpnIntroduceLaDireccin = new JTextPane();
		txtpnIntroduceLaDireccin.setEditable(false);
		txtpnIntroduceLaDireccin.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		txtpnIntroduceLaDireccin.setBackground(new Color(255, 250, 205));
		txtpnIntroduceLaDireccin.setText("Introduzca la dirección de correo electrónico vinculada a su cuenta de Mundo Anime y le enviaremos un enlace para restablecerla.");
		txtpnIntroduceLaDireccin.setBounds(32, 169, 519, 75);
		contentPane.add(txtpnIntroduceLaDireccin);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Introduzca su Correo Electrónico")) {
					textField.setText("");
					textField.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("")) {
					textField.setText("Introduzca su Correo Electrónico");
					textField.setForeground(new Color(71,75,78));
				}
			}
		});
		textField.setToolTipText("");
		textField.setText("Introduzca su Correo Electrónico");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 128, 0));
		textField.setBounds(100, 280, 376, 30);
		contentPane.add(textField);
		
		JLabel lblEmail = new JLabel("Correo Electrónico:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblEmail.setBounds(100, 239, 164, 30);
		contentPane.add(lblEmail);
		
		lblIntroduceTuEmail_1_1 = new JLabel("Volver a Iniciar Sesión");
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
				lblIntroduceTuEmail_1_1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 0)));		
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIntroduceTuEmail_1_1.setBorder(null);
			}
		});
		lblIntroduceTuEmail_1_1.setForeground(new Color(255, 128, 0));
		lblIntroduceTuEmail_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIntroduceTuEmail_1_1.setBounds(100, 375, 132, 24);
		contentPane.add(lblIntroduceTuEmail_1_1);
		
		JButton btnObtenerEnlace = new JButton("OBTENER ENLACE");
		btnObtenerEnlace.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnObtenerEnlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText().trim();
				if (email.equals("Introduzca su Correo Electrónico")) {
		            JOptionPane.showMessageDialog(contentPane, "Por favor, introduzca su correo electrónico.","MUNDO ANIME",JOptionPane.ERROR_MESSAGE);
				}else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
		            JOptionPane.showMessageDialog(contentPane, "Por favor, ingrese un correo electrónico válido.","MUNDO ANIME",JOptionPane.ERROR_MESSAGE);
				}else {
		            boolean existeUsuario = VerificarUsuario.verificarUsuario2(email);
					if(existeUsuario) {
						JOptionPane.showMessageDialog(contentPane, "Correo electrónico enviado. Revise su bandeja de entrada.","MUNDO ANIME",JOptionPane.INFORMATION_MESSAGE);
					}else {
		                JOptionPane.showMessageDialog(contentPane, "Lo sentimos, el correo electrónico no existe.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
		            }
				}
			}
		});
		btnObtenerEnlace.setForeground(new Color(255, 255, 255));
		btnObtenerEnlace.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnObtenerEnlace.setBackground(new Color(0, 0, 0));
		btnObtenerEnlace.setBounds(100, 334, 376, 30);
		contentPane.add(btnObtenerEnlace);
	}
}
