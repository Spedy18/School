/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitdeparidadproyecto;

import static bitdeparidadproyecto.Procedimieto.lista;
import static bitdeparidadproyecto.Procedimieto.lrc;
import static bitdeparidadproyecto.Procedimieto.titulo;
import static bitdeparidadproyecto.Procedimieto.varespecial;
import static bitdeparidadproyecto.Procedimieto.vrc;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Alexsandro
 */
public class CrearJTable {
     ColorCelda cc = new ColorCelda();
    public static int ErrorRow=-1;
    public static int ErrorCol=-1;
    public static Boolean FoundError;
     public static String columnNames[];
     public static  String rows[][];
     public static JButton validar;
     public static JTable tabla=new JTable();
    public static JButton Desarollar,Corregir;
    public static  JTextField InputCadena;
    public static JFrame newframe;
    public static Boolean tablaCreada= false;
    public JFrame crearVentana(){
        newframe = new JFrame();
        newframe.setLayout(new MigLayout());
        newframe.setTitle("tabla");
        newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newframe.setLocation(350, 250);
        InputCadena = new JTextField(15);
        Desarollar = new JButton ("Desarollar");
        Desarollar.addActionListener(new eventos());
        validar= new JButton("validar");
        validar.addActionListener(new eventos());
        Corregir= new JButton("Corregir");
        Corregir.addActionListener(new eventos());
        newframe.add(InputCadena,"growx");
        newframe.add(Desarollar);
        newframe.add(validar);
        newframe.add(Corregir,"skip20,wrap");
        newframe.add(tabla);
        
        newframe.pack();
        newframe.setVisible(true); 
        return newframe;
    }
    public void UpdateTableData(){
        rows= new String[lista.get(0).size()+1][titulo.length];
        for (int i = 0; i <lista.get(0).size(); i++) {
            for (int j = 1; j < titulo.length-1; j++) {
                rows[i][j]=String.valueOf(lista.get(j-1).get(i));
            }
        }
        Integer LrcHolder[]=lrc;
            for (int i = 0; i <lrc.length; i++) {
                rows[i][titulo.length-1]=String.valueOf(LrcHolder[i]);
            }
            
            Integer VrcHolder[]=vrc;
            rows[lista.get(0).size()][0]="VRC";
            for (int i = 1; i <vrc.length+1; i++) {   
                rows[lista.get(0).size()][i]=String.valueOf(VrcHolder[i-1]);
            }
        rows[rows.length-1][rows[0].length-1] =String.valueOf(varespecial);
        DefaultTableModel model = new DefaultTableModel(rows,titulo);
        tabla.setModel(model);
    }
    public JTable crearTabla()
    {   
        UpdateTableData();
        tabla.setBounds(30,40,300,400);
        tabla.setDefaultRenderer(tabla.getColumnClass(0), cc);
        JScrollPane nrt = new JScrollPane(tabla);
        nrt.setSize(new Dimension(2,200));
        tablaCreada= true;
        return tabla;
    }  
}
