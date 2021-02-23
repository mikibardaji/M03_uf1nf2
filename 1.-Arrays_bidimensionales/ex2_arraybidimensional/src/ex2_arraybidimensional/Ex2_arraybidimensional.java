/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_arraybidimensional;

/**
 *
 * @author mati
 */
public class Ex2_arraybidimensional {

    /**
     * Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas demultiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] multiplicar = new int[10][10];
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiplicar[i][j] = (i+1)*(j+1);
            }
            
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
               // System.out.print(multiplicar[i][j] + " ");
                System.out.printf("%4d", multiplicar[i][j]);
                
            }
            System.out.println(""); /*salto linea*/
        }
        
    }
    
}
