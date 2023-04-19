package zTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BorrarUsuarios {

	public void borrarUsuario(String correo) {
		Conexion conexion = new Conexion();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    
	    try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM usuarios  WHERE CorreoElectrónico = ?");
			stm2.setString(1 , correo);
			
			
			stm2.executeUpdate();
			
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
