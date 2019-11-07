package bitdeparidadproyecto;

import java.util.ArrayList;

public class Procedimieto {
    public static Integer[] vrc;
   public static Integer[] lrc;
    public static ArrayList<ArrayList<Integer>> lista = new ArrayList(),Lista;
   public static int varespecial;
   String cadena;
   public static String[] titulo;
   
    public void TransformarCadena(String c) {
        lista = new ArrayList();
        cadena=c;
        char aux[] = new char[cadena.length()];
        int num[] = new int[cadena.length()];
        int i, j;
        //asigna la cadena a una rreglo de char
        titulo = new String[cadena.length()+2];
        titulo[0]="";
        for (j = 0; j < cadena.length(); j++) {
            aux[j] = cadena.charAt(j);
            titulo[j+1] = String.valueOf(aux[j]);
        }
        titulo[(titulo.length)-1]="LRC";
        //transforma cada elemento de aux[] a un entero
        for (i = 0; i < cadena.length(); i++) {
            num[i] = (int) aux[i];
        }
        pasarBinario(num);
    }

    void pasarBinario(int arr[]) {
        short cont = 0;
        int temp;
        while (cont < arr.length) {
            
            String bin = String.format("%7s", Integer.toBinaryString(arr[cont])).replaceAll(" ", "0");
            //System.out.println(bin);
            lista.add(new ArrayList());
            short j = 0;
            for (int i = bin.length() - 1; i >= 0; i--) {
                temp = Integer.parseInt(bin.charAt(i) + "");
                lista.get(cont).add(temp);
                //System.out.println(lista.get(cont).get(j));
                j++;
            }
            cont++;
        }
        Lista =lista;
        agregarBit();
    }

void agregarBit(){
    vrc = new Integer[cadena.length()];
    lrc = new Integer[7];
int cont=0;
 short unos;
 while(cont<cadena.length()){
 unos=0;
    
    for (int i = 0; i <7; i++) {
        if(lista.get(cont).get(i)==1){
       unos++;
        }
    }
    if(unos%2==0){vrc[cont]=1;}
    else {vrc[cont]=0;}
    cont=cont+1;
 }
 cont=0;
 while(cont<7){
 unos=0;
    
    for (int i = 0; i <cadena.length(); i++) {
        if(lista.get(i).get(cont)==1){
       unos++;
        }
    }
    if(unos%2==0)
    {lrc[cont]=0;}
    else {lrc[cont]=1;}
    cont=cont+1;
 }
    unos =0;
   for (int i = 0; i <7; i++) {
            if(lrc[i]==1){
            unos++;}
        }
        if(unos%2==0){
      varespecial=1;}
        else{varespecial=0;}
    }
}
