package zTercerTrimestre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerUsuarios {

	public void verUsuarios() {
	    Conexion conexion = new Conexion();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;

	    try {
	        cn = conexion.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM usuarios");

	        while (rs.next()) {
	            String Nombre = rs.getString(1);
	            String Apellidos = rs.getString(2);
	            String CorreoElectrónico = rs.getString(3);
	            String Contraseña = rs.getString(4);
	            int NúmeroDeTeléfono = rs.getInt(5);
	            String País = rs.getString(6);

	            System.out.println(Nombre + " - " + Apellidos + " - " + CorreoElectrónico + " - " + Contraseña + " - " + NúmeroDeTeléfono + " - " + País);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();

	    } finally {
	        try {
	            if (rs!= null) {
	                rs.close();
	            }

	            if (stm != null) {
	                stm.close();
	            }

	            if (cn != null) {
	                cn.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	}

}
