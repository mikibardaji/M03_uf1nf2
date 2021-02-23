/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer14_arrays;

/**
 * Crea un programa que cree un array 
 * de enteros e introduzca la siguiente 
 * secuencia de
valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego la
muestre por pantalla.
 * @author mati
 */
public class Exer14_arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamanyo=0;
        //calcular el tamaño que tiene que tener
        //el array, o sea suma 1+2+3+4+5...10
        for (int i = 1; i <= 10; i++) {
            tamanyo = tamanyo + i;
        }
        
        int valores[] = new int[tamanyo];
        
        int posicion=0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <i ; j++) {
             valores[posicion]=i;
             posicion++;
            }
        }
        
        mostrar_array(valores);
    }
    
    private static void mostrar_array(int[] numeros) {
        
        for (int i = 0; i < numeros.length; i++) {
            
            System.out.print(", "+numeros[i]);
        }
    }
}
