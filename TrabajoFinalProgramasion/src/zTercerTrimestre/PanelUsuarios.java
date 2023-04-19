package zTercerTrimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;

public class PanelUsuarios extends JFrame {

	private JPanel contentPane;
	static PanelUsuarios recuperar_contraseña;
	private JTextField txtCorreoElectrnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recuperar_contraseña = new PanelUsuarios();
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
	public PanelUsuarios() {
		setTitle("MUNDO ANIME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 592);
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
		lblNewLabel.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/Images/logo-removebg-preview (2) (1).png")));
		lblNewLabel.setBounds(192, -28, 195, 172);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/Images/23231-5-one-piece-chibi-image-thumb.png")));
		lblNewLabel_1.setBounds(384, 0, 200, 200);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(60, 0, 83, 117);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/Images/titan (4).png")));
		
		 JTable tablaUsuarios = new JTable();
	        tablaUsuarios.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
	        tablaUsuarios.setRowHeight(30);
	        tablaUsuarios.setEnabled(false);
	        tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        tablaUsuarios.setModel(new DefaultTableModel(
	                new Object[][] {},
	                new String[] {"Nombre", "Apellidos", "CorreoElectrónico", "Contraseña", "NúmeroDeTeléfono", "País"}));
	        tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
	        tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(100);
	        tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
	        tablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
	        tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(120);
	        tablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(100);
	        
	        // Color de la tabla
	        tablaUsuarios.setBackground(new Color(255, 204, 153));
	        tablaUsuarios.getTableHeader().setBackground(new Color(255, 128, 0));
	        tablaUsuarios.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0)));
	        tablaUsuarios.setGridColor(new Color(255, 128, 0));

	        JTableHeader header = tablaUsuarios.getTableHeader();
	        header.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
	        header.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 1, true));
	        header.setDefaultRenderer(new DefaultTableCellRenderer() {
	            {
	                setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(255, 128, 0)));
	                setHorizontalAlignment(JLabel.CENTER);
	                setBackground(new Color(255, 128, 0));
	                setOpaque(true);
	            }
	        });

	        // Centramos el texto en las celdas de la tabla
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        tablaUsuarios.setDefaultRenderer(Object.class, centerRenderer);

	        // Ponemos la tabla en un JScrollPane para poder hacer scroll si hace falta
	        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
	        scrollPane.setForeground(new Color(0, 0, 0));
	        scrollPane.getViewport().setBackground(new Color(255, 204, 153));
	        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0)));
	        scrollPane.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
	        scrollPane.setBounds(10, 193, 552, 197);
	        contentPane.add(scrollPane);
	        
	        // Obtenemos los usuarios de la base de datos y los añadimos a la tabla
	        VerUsuarios verUsuarios = new VerUsuarios();
	        verUsuarios.verUsuarios();

	        DefaultTableModel modelo = new DefaultTableModel();
	        modelo.addColumn("Nombre");
	        modelo.addColumn("Apellidos");
	        modelo.addColumn("CorreoElectrónico");
	        modelo.addColumn("Contraseña");
	        modelo.addColumn("NúmeroDeTeléfono");
	        modelo.addColumn("País");
	      
	        FilasTabla filasTabla = new FilasTabla(tablaUsuarios);
	        filasTabla.cargarDatosTabla();
	        
	        JLabel lblIntroduceTuEmail_1 = new JLabel("• Panel de Administrador - Usuarios •");
            lblIntroduceTuEmail_1.setForeground(Color.BLACK);
            lblIntroduceTuEmail_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            lblIntroduceTuEmail_1.setBounds(69, 143, 418, 30);
            contentPane.add(lblIntroduceTuEmail_1);
            
            JLabel lblIntroduceElCorreo = new JLabel("Introduzca el Correo Electrónico del usuario a borrar:");
            lblIntroduceElCorreo.setForeground(Color.BLACK);
            lblIntroduceElCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            lblIntroduceElCorreo.setBounds(83, 401, 423, 30);
            contentPane.add(lblIntroduceElCorreo);
            
            txtCorreoElectrnico = new JTextField();
            txtCorreoElectrnico.addFocusListener(new FocusAdapter() {
    			@Override
    			public void focusGained(FocusEvent e) {
    				if(txtCorreoElectrnico.getText().equals("Correo Electrónico del Usuario")) {
    					txtCorreoElectrnico.setText("");
    					txtCorreoElectrnico.setForeground(new Color(0,0,0));
    				}
    			}
    			@Override
    			public void focusLost(FocusEvent e) {
    				if(txtCorreoElectrnico.getText().equals("")) {
    					txtCorreoElectrnico.setText("Correo Electrónico del Usuario");
    					txtCorreoElectrnico.setForeground(new Color(71,75,78));
    				}
    			}
    		});
            txtCorreoElectrnico.setText("Correo Electrónico del Usuario");
            txtCorreoElectrnico.setToolTipText("");
            txtCorreoElectrnico.setForeground(Color.DARK_GRAY);
            txtCorreoElectrnico.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
            txtCorreoElectrnico.setColumns(10);
            txtCorreoElectrnico.setBackground(new Color(255, 128, 0));
            txtCorreoElectrnico.setBounds(107, 442, 376, 30);
            contentPane.add(txtCorreoElectrnico);
            
            JButton btnBorrarUsuario = new JButton("BORRAR USUARIO");
            btnBorrarUsuario.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String correo = txtCorreoElectrnico.getText();

                    if (correo.isEmpty()) {
                        JOptionPane.showMessageDialog(contentPane, "Por favor, introduce un correo electrónico.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                        JOptionPane.showMessageDialog(contentPane, "Por favor, introduce un correo electrónico válido.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    boolean usuarioExiste = VerificarUsuario.verificarUsuario2(correo);

                    if (usuarioExiste) {
                        BorrarUsuarios borrar = new BorrarUsuarios();
                        borrar.borrarUsuario(correo);
                        JOptionPane.showMessageDialog(contentPane, "El usuario ha sido eliminado de la base de datos.", "MUNDO ANIME", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "El correo electrónico no existe.", "MUNDO ANIME", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            btnBorrarUsuario.setForeground(Color.WHITE);
            btnBorrarUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            btnBorrarUsuario.setBackground(Color.BLACK);
            btnBorrarUsuario.setBounds(107, 492, 376, 30);
            contentPane.add(btnBorrarUsuario);
            
            JLabel lblNewLabel_1_1_1 = new JLabel("");
            lblNewLabel_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblNewLabel_1_1_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/Images/synchronize_30px.png")));
            lblNewLabel_1_1_1.setBounds(532, 128, 30, 30);
            contentPane.add(lblNewLabel_1_1_1);

            lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	JFrame frame = new PanelUsuarios();
		            frame.setVisible(true);
		            dispose();
                }
            });

	}
}
