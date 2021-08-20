package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {

    Connection Conexion;
    public Requerimiento_3Dao() {
        try {
            Conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        
        ArrayList<Requerimiento_3> lista = new ArrayList<>();
            String sql = "SELECT UPPER(SUBSTRING(Nombre_Material,1,1)) || ' ' || LOWER(Importado)"
                    + "FROM MaterialConstruccion";
            Statement stmt = Conexion.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                Requerimiento_3 prod = new Requerimiento_3();
                prod.setNombre_Material(resultado.getString(1));
                prod.setImportado(resultado.getString(1));
                lista.add(prod);
            }
        return lista;
    }
}
