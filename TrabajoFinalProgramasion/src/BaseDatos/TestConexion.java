package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
	public static void main(String[] args) {
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
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO usuarios(Nombre,Apellidos,CorreoElectrónico,Contraseña,NúmeroDeTeléfono,País) VALUES (?,?,?,?,?,?)");
			stm2.setString(1 , "Jorge");
			stm2.setString(2 , "Fernández Cea");
			stm2.setString(3 , "jorge@gmail.com");
			stm2.setString(4, "contraseña");
			stm2.setString(5, "657543213");
			stm2.setString(6, "Spain");
			
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
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("UPDATE usuarios SET CorreoElectrónico = ?  WHERE Contraseña = ?");
			stm2.setString(1 , "jorge2@gmail.com");
			stm2.setString(2 , "contraseña2");
			
			
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
		
		
//		try {
//			cn = conexion.conectar();
//			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM usuarios  WHERE CorreoElectrónico = ?");
//			stm2.setString(1 , "jorge@gmail.com");
//			
//			
//			stm2.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		} finally {
//			try {
//				if (rs!= null) {
//					rs.close();
//				}
//				
//				if (stm != null) {
//					stm.close();
//				}
//				
//				if (cn != null) {
//					cn.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
	}
}
