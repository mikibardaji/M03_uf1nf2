/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_cubiletes;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Ex_cubiletes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //crear la estructura
        char[] cubiletes = new char[3];
        int puntos=0;
        boolean acierte;
        //ficar la boleta a una posicio i les altres a x
        inicializo_cubiletes(cubiletes);
        muestro_cubiletes(cubiletes);
        do{
            for (int i = 0; i < 10; i++) {
                muevo_posiciones(cubiletes);
            }

        //pedir usuario en que posicion esta la bolita
        int eleccion = posicion_usuario();
        //saber si esta la pelota en el sitio
        acierte=he_acertado(cubiletes,eleccion);
        if(acierte==true)
        {
            System.out.println("has acertado");
            puntos++;
        }
        muestro_cubiletes(cubiletes);
        }while(acierte);
        
        System.out.println("has conseguido " + puntos + " puntos");
        //moure posicions (x10)   
                
    }

    private static void inicializo_cubiletes(char[] cubiletes) {
        for (int i = 0; i < cubiletes.length; i++) {
            cubiletes[i]='X'; //totes les posicions estaran a X
        }//totes les posicions estaran a X
        // o la opcion 2 que es mejor Arrays.fill(cubiletes,'X');
        Random rd = new Random(System.currentTimeMillis());
        int posicio_boleta =  rd.nextInt(3);
        //Math.Random()*3
        cubiletes[posicio_boleta]='0';
    }

    private static void muestro_cubiletes(char[] cubiletes) {
        for (int i = 0; i < cubiletes.length; i++) {
            System.out.print(cubiletes[i]+" ");
        }
        System.out.println("");
    }

    private static void muevo_posiciones(char[] cubiletes) {
        int pos1,pos2;
       Random rd = new Random(System.currentTimeMillis());
       do{
       pos1= rd.nextInt(3);
       pos2= rd.nextInt(3);
       }while(pos1==pos2);
       //posiciones van a ser diferentes seguro
       char aux = cubiletes[pos2];
       cubiletes[pos2] = cubiletes[pos1];
       cubiletes[pos1] = aux;
       System.out.println("intercambio posicion" + pos1 + " por " + pos2);
       
    }

    private static int posicion_usuario() {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        do{
            System.out.println("Donde esta la bolita");
            eleccion = sc.nextInt();
        }while(eleccion<1 || eleccion>3);
        return (eleccion-1);
    }

    private static boolean he_acertado(char[] cubiletes, int eleccion) {
        //if(cubiletes[eleccion]=='0')
           //return true;
           //else
           //return false;
        return cubiletes[eleccion]=='0';
    }
    
}
