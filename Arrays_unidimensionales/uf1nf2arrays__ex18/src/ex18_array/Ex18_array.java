/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex18_array;

import java.util.Arrays;

/**
 * Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios entre
0 y 99 (utiliza Math.random()*100). Luego ordena los valores del array y los mostrará por
pantalla.

 * @author usuari
 */
public class Ex18_array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros = new int[30];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*100)+ 1;
        }
        Arrays.sort(numeros);
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        
    }
    
}
