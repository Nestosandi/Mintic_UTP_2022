package utp.misiontic2022.c2.p47.reto5;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import utp.misiontic2022.c2.p47.reto5.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p47.reto5.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto5.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto5.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p47.reto5.vista.ModeloDatos;

public class Main {
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void main(String[] args) {
        ModeloDatos modelo = new ModeloDatos();
        int opt = 0;
        do{
        opt = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter a option:\n" + "1. Requerimiento 1\n" + "2. Requerimiento 2\n" 
                + "3. Requerimiento 3\n" + "4. Salir"));
        switch (opt) {
            case 1:
                try {
                    ArrayList<Requerimiento_1> lista = controlador.consultarRequerimiento1();
                    Object matriz[][] = new Object[lista.size()][3];
                    for (int i = 0; i < lista.size(); i++) {
                        matriz[i][0] = lista.get(i).getID_MaterialConstruccion();
                        matriz[i][1] = lista.get(i).getNombre_Material();
                        matriz[i][2] = lista.get(i).getPrecio_Unidad();
                    }

                    modelo.datos = matriz;
                    JTable tabla = new JTable(modelo);
                    JScrollPane scroll = new JScrollPane(tabla);
                    JOptionPane.showMessageDialog(null, scroll, "Requerimiento 1", 1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    ArrayList<Requerimiento_2> lista = controlador.consultarRequerimiento2();
                    Object matriz[][] = new Object[lista.size()][2];
                    for (int i = 0; i < lista.size(); i++) {
                        matriz[i][0] = lista.get(i).getID_MaterialConstruccion();
                        matriz[i][1] = lista.get(i).getAvgPrecio_Unidad();
                    }
                    modelo.datos = matriz;
                    JTable tabla = new JTable(modelo);
                    JScrollPane scroll = new JScrollPane(tabla);
                    JOptionPane.showMessageDialog(null, scroll, "Requerimiento 2", 1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
                case 3:
                try {
                    ArrayList<Requerimiento_3> lista = controlador.consultarRequerimiento3();
                    Object matriz[][] = new Object[lista.size()][1];
                    for (int i = 0; i < lista.size(); i++) {
                        matriz[i][0] = lista.get(i).getNombre_Material();
                        matriz[i][0] = lista.get(i).getImportado();
                    }
                    modelo.datos = matriz;
                    JTable tabla = new JTable(modelo);
                    JScrollPane scroll = new JScrollPane(tabla);
                    JOptionPane.showMessageDialog(null, scroll, "Requerimiento 3", 1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }while(opt != 4);
    }
}


