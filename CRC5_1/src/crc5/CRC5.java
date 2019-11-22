/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crc5;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class CRC5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] unidad_datos;
        int[] dividendo;
        int[] largo_p;
        int[] resto;
        int[] crc;
        int cantdatos, divisor, largo;
        
        String lom=JOptionPane.showInputDialog("Ingrese la unidad de datos");
        char [] values;
        values = lom.toCharArray();
        cantdatos=values.length;
        unidad_datos=new int[cantdatos];

        for(int i=0; i<cantdatos; i++){            
            String auh=Character.toString(values[i]);
            int aux = Integer.parseInt(auh);
            unidad_datos[i]=aux;
        }
        
         String rami=JOptionPane.showInputDialog("Ingrese el polinomio divisor");
        
        char [] ui;
        ui=rami.toCharArray();
        divisor=ui.length;
        largo_p=new int[divisor];
       
        
        for(int i=0; i<divisor; i++){
            String chap = Character.toString(ui[i]);
            int aux = Integer.parseInt(chap);
            largo_p[i]=aux;
        }
        
        
        String jkl="";
        for (int i=largo_p.length-1;i>=0;i--){
           for(int j =0;j<largo_p.length;j++){
            if(largo_p[i]==1){
                jkl=jkl+" + x^"+j;
            }
        }
        }
        System.out.println(jkl);
       
       largo=cantdatos+divisor-1;
        
        dividendo=new int[largo];
        resto=new int[largo];
        crc=new int[largo];
  
   
        for(int i=0;i<unidad_datos.length;i++){
            dividendo[i]=unidad_datos[i];
            
        }
        System.out.println("Dividendo: "+lom);
        System.out.println("Divisor: "+rami);
        System.out.print("Dividendo (despues de agregar lo 0's) es : ");
        for(int i=0; i< dividendo.length; i++)
            System.out.print(dividendo[i]);        
        System.out.println();
        
        for(int j=0; j<dividendo.length; j++){
              resto[j] = dividendo[j];
        }
    
      resto=divide(dividendo, largo_p, resto);
   
        
        for(int i=0;i<dividendo.length;i++)           
        {
            crc[i]=(dividendo[i]^resto[i]);
        }
        
        System.out.println();
        System.out.println("El dividendo al agregarle el CRC quedaria como : ");    
        for(int i=0;i<crc.length;i++)
            System.out.print(crc[i]);

        System.out.println();
        String bitna=JOptionPane.showInputDialog("Ingresa el codigo de CRC de  "+largo+" bits para comprobar: ");
        char [] nm;
        nm = bitna.toCharArray();
        for(int i=0; i<crc.length; i++){
            
              String chap = Character.toString(nm[i]);
            int aux = Integer.parseInt(chap);
            crc[i]=aux;
        }
        System.out.println("el dividendo recibido es: "+bitna);       
       
       resto=divide(crc, largo_p, resto);
        
        for(int i=0; i< resto.length; i++)
        {
            if(resto[i]!=0)
            {
                System.out.println("Error su resto no es cero");
                break;
            }
            if(i==resto.length-1)
                System.out.println("No hay error su resto es igual  a 0");
        }
     }
    
    static int[] divide(int dividendo[],int largo_p[], int resto[])
     {
        int contador=0;
        while(true)
        {
            for(int i=0;i<largo_p.length;i++)
                resto[contador+i]=(resto[contador+i]^largo_p[i]);
            
            while(resto[contador]==0 && contador!=resto.length-1)
                contador++;
    
            if((resto.length-contador)<largo_p.length)
                break;
        }
       
        return resto;
     }
}
        
    
    

