/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitdeparidadproyecto;

import static bitdeparidadproyecto.CrearJTable.*;
import static bitdeparidadproyecto.Procedimieto.Lista;

import static bitdeparidadproyecto.Procedimieto.lista;
import static bitdeparidadproyecto.Procedimieto.lrc;
import static bitdeparidadproyecto.Procedimieto.titulo;
import static bitdeparidadproyecto.Procedimieto.vrc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexsandro
 */
public class eventos implements ActionListener{
    public static Integer [][] DataTable;
    public static Integer cambio=0;
    JTable tabl;
    DefaultTableModel model;
    CrearJTable CT = new CrearJTable();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(validar)) {
            ErrorRow =-1;
            ErrorCol =-1;
            FoundError =false;
            
            UpdateTable();
             getMatriz();
             BuscarError();
             SwingUtilities.updateComponentTreeUI(newframe);
        }
        if (e.getSource().equals(Desarollar)) {
            ErrorRow =-1;
            ErrorCol =-1;
            FoundError =false;
            String c = InputCadena.getText();
            Procedimieto p= new Procedimieto();
            p.TransformarCadena(c);
            if (tablaCreada==false){
            newframe.add(new JScrollPane(CT.crearTabla()));
            }else{CT.UpdateTableData();}
            UpdateTable();
            newframe.pack();
            newframe.setVisible(true);
            SwingUtilities.updateComponentTreeUI(newframe);
        
        } 
        if(e.getSource().equals(Corregir)){
            
            if (FoundError==true){
                System.out.println("Corregiendo");
                
                
            lista.get(ErrorCol-1).set(ErrorRow-1,cambio);
            ErrorRow =-1;
            ErrorCol =-1;
            FoundError =false;
            CT.UpdateTableData();
            newframe.pack();
            newframe.setVisible(true);
            SwingUtilities.updateComponentTreeUI(newframe);
            
            }
        
        }
    }
    public void UpdateTable(){
        this.tabl = tabla;
        model = (DefaultTableModel) tabl.getModel();
    }
    public Integer[][] getMatriz(){
        DataTable = new Integer[model.getRowCount()][model.getColumnCount()-1];
        for (int i = 0; i < model.getRowCount()-1; i++) {
            for (int j = 1; j < model.getColumnCount()-1; j++) {
                //System.out.println("-----"+i+" "+j+"------");
                 System.out.print(" "+ model.getValueAt(i, j));
               DataTable[i][j-1]=Integer.parseInt((String) model.getValueAt(i, j)); 
               
            }
            System.out.println("");
        }
        return null;
    }
    Integer unos=0;

    public Boolean BuscarError(){
        FoundError =false;
        for (int j = 0; j < DataTable.length-1; j++) { 
            unos=0;
           for (int i = 0; i < DataTable[0].length-1; i++) {
            if(DataTable[j][i]==1){  
            unos=unos+1;
           }
               
        }
             if(unos%2!=lrc[j]){
                 FoundError = true;
                 ErrorRow = j;
                 System.out.println("ERROR");
             }
        }
       
        for (int j = 0; j < DataTable[0].length-1; j++) { 
            unos=0;
           for (int i = 0; i < DataTable.length-1; i++) {
            if(DataTable[i][j]==1){  
            unos=unos+1;
           }
               
        }
             if(unos%2==vrc[j]){
                 FoundError = true;
                 ErrorCol = j+1;
               
             }
        }
        if (FoundError ==true){
            cambio = Lista.get(ErrorCol-1).get(ErrorRow-1);
            System.out.println("Cambio"+cambio);
            System.out.println("LOCATION "+ErrorRow+"  "+ ErrorCol);}
        return FoundError;
    }
}
