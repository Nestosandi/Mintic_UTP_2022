package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    Connection Conexion;

    public Requerimiento_2Dao() {
        try {
            Conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {

        ArrayList<Requerimiento_2> lista = new ArrayList<>();
        String sql = "SELECT ID_MaterialConstruccion, avg(Precio_Unidad) FROM MaterialConstruccion "
                + "GROUP BY Importado";
        Statement stmt = Conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            Requerimiento_2 product = new Requerimiento_2();
            product.setID_MaterialConstruccion(resultado.getInt(1));
            product.setAvgPrecio_Unidad(resultado.getInt(2));
            lista.add(product);
        }
        return lista;
    }
}