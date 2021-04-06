/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonograma;

import java.util.Random;

/**
 *
 * @author 43720186S
 */
public class Nonograma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] nonograma = new int[8][8];
        poner_marcas(nonograma);
        sumar_filas_columnas(nonograma);
        mostrar(nonograma);
    }

    private static void poner_marcas(int[][] nonograma) {
        Random rd = new Random(System.currentTimeMillis());
        int marcas = 0;
        int fila, columna;
        do{
            fila = rd.nextInt(7);
            columna = rd.nextInt(7);
            if(nonograma[fila][columna]==0) //no esta ocupada
            {
             nonograma[fila][columna]=1;
             marcas++;
            }
            
        }while(marcas<20);   
    }

    private static void sumar_filas_columnas(int[][] nonograma) {
        int suma=0;
        for (int fila = 0; fila < nonograma.length-1; fila++) {
            suma=0;
            for (int columna = 0; columna < nonograma[fila].length-1; columna++) {
            suma = suma + nonograma[fila][columna];
           }
        nonograma[fila][nonograma[fila].length-1] = suma; //la posicion 7
        }
        
        for (int columna_V = 0; columna_V < nonograma.length-1; columna_V++) {
            suma=0;
            for (int fila_V = 0; fila_V < nonograma[columna_V].length-1; fila_V++) {
            suma = suma + nonograma[fila_V][columna_V];
           }
        nonograma[nonograma[columna_V].length-1][columna_V] = suma; //la posicion 7
        }      
        
    }

    private static void mostrar(int[][] nonograma) {
        for (int fila = 0; fila < nonograma.length; fila++) {
            for (int columna = 0; columna < nonograma.length; columna++) {
                if (nonograma[fila][columna]==1 && (columna<nonograma.length-1 && (fila <nonograma.length-1) ))
                    System.out.print("X ");
                else
                    System.out.print(nonograma[fila][columna] + " ");
            }
            System.out.println("");
        }
    }
    
}
