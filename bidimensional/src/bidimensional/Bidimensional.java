/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidimensional;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Bidimensional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int filas=2, columnas=3;
        int [][] tabla = new int[filas][columnas];
        tabla[0][0] = 1;
        tabla[0][1] = 4;
        tabla[0][2] = 6;
        tabla[1][0] = 7;
        tabla[1][1] = 3;
        tabla[1][2] = 2;
        
        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) 
            {
            System.out.print(tabla[j][i] + "-");
            }  
            System.out.println("");
        }
        
        for (int j = 0; j < tabla.length; j++) {
            for (int i = 0; i < tabla[j].length; i++) 
            {
            System.out.print(tabla[j][i] + "-");
            }  
            System.out.println("");
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Pon la fila que quieres saber el valor");
        int y = sc.nextInt();
        System.out.println("Pon la columna que quieres saber el valor");
        int x = sc.nextInt();
        
        System.out.println("En la fila " + y  + " columna " + x + "hay el valor " + tabla[y][x]);
        
        
        
        
        
        
        
        
    }
    
}
