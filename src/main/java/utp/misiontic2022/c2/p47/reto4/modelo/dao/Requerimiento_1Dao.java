package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    Connection Conexion;

    public Requerimiento_1Dao() {
        try {
            Conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        ArrayList<Requerimiento_1> lista = new ArrayList<>();
        String sql = "SELECT Nombre_Material, ID_MaterialConstruccion, Precio_Unidad FROM MaterialConstruccion where Importado = 'Si'";
        Statement stmt = Conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            Requerimiento_1 producto = new Requerimiento_1();
            producto.setID_MaterialConstruccion(resultado.getInt(2));
            producto.setNombre_Material(resultado.getString(1));
            producto.setPrecio_Unidad(resultado.getInt(3));
            lista.add(producto);
        }
        return lista;

    }
}