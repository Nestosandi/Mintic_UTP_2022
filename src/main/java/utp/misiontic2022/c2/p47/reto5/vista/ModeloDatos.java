package utp.misiontic2022.c2.p47.reto5.vista;

import javax.swing.table.AbstractTableModel;

public class ModeloDatos extends AbstractTableModel {

    public Object datos[][];

    public ModeloDatos() {
        addTableModelListener(evt -> {
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    System.out.print(datos[i][j] + " ");
                }
                System.out.println();
            }
        });
    }
    @Override
    public int getRowCount() {
        return datos.length;
    }
    @Override
    public int getColumnCount() {
        return datos[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        datos[rowIndex][columnIndex] = aValue;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}