package zTercerTrimestre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FilasTabla {
	
	private JTable tablaUsuarios;
	
	public FilasTabla(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}
	
	public void cargarDatosTabla() {
	    try {
	        Conexion conexion = new Conexion();
	        Connection cn = conexion.conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM usuarios");

	        DefaultTableModel modelo = new DefaultTableModel();
	        modelo.addColumn("Nombre");
	        modelo.addColumn("Apellidos");
	        modelo.addColumn("CorreoElectrónico");
	        modelo.addColumn("Contraseña");
	        modelo.addColumn("NúmeroDeTeléfono");
	        modelo.addColumn("País");

	        while (rs.next()) {
	            Object[] fila = new Object[6];
	            fila[0] = rs.getString("Nombre");
	            fila[1] = rs.getString("Apellidos");
	            fila[2] = rs.getString("CorreoElectrónico");
	            fila[3] = rs.getString("Contraseña");
	            fila[4] = rs.getInt("NúmeroDeTeléfono");
	            fila[5] = rs.getString("País");
	            modelo.addRow(fila);
	        }

	        tablaUsuarios.setModel(modelo);
	        rs.close();
	        cn.close();
	        stm.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

