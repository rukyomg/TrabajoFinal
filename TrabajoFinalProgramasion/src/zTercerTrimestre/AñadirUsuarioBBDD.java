package zTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.Conexion;

public class AñadirUsuarioBBDD {

	public void agregarUsuario(String nombre, String apellidos, String correoElectronico, String contraseña, String numeroDeTelefono, String país) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO usuarios(Nombre,Apellidos,CorreoElectrónico,Contraseña,NúmeroDeTeléfono,País) VALUES (?,?,?,?,?,?)");
			stm2.setString(1 , nombre);
			stm2.setString(2 , apellidos);
			stm2.setString(3 , correoElectronico);
			stm2.setString(4, contraseña);
			stm2.setString(5, numeroDeTelefono);
			stm2.setString(6, país);
			
			stm2.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
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
