package zTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BaseDatos.Conexion;

public class VerificarUsuario {

    public boolean verificarUsuario(String email, String password) {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            cn = conexion.conectar();
            stm = cn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE CorreoElectrónico = ? AND Contraseña = ?");
            stm.setString(1 , email);
            stm.setString(2 , password);

            rs = stm.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }

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
        return false;
    }
    
    public static boolean verificarUsuario2(String email) {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            cn = conexion.conectar();
            stm = cn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE CorreoElectrónico = ?");
            stm.setString(1 , email);

            rs = stm.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }

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
        return false;
    }
}

