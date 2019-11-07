/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitdeparidadproyecto;
import static bitdeparidadproyecto.CrearJTable.columnNames;
import static bitdeparidadproyecto.CrearJTable.*;
import static bitdeparidadproyecto.Procedimieto.titulo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Alexsandro
 */
class ColorCelda extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column)
   {
      Component c = super.getTableCellRendererComponent(table, value,
               isSelected, hasFocus, row, column);
     // setSize(table.getColumnModel().getColumn(column).getWidth(), (int)getPrefferedSize().getHeight());
      TableModel wtm = (TableModel) table.getModel();  
        if (column == (titulo.length-1) || row ==(rows.length-1)) {
         setBackground(Color.LIGHT_GRAY);
        }
      else if((column ==ErrorCol )&& (row == ErrorRow)) {
         setBackground(Color.RED);
      }
      else {
         setBackground(Color.white);
      }
      return c;
   }
}
