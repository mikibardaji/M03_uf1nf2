/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer13_arrays;

import java.util.Scanner;

/**
 * Crea un programa que permita al usuario almacenar una secuencia aritmética en un array y
luego mostrarla. Una secuencia aritmética es una serie de números que comienza por un
valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1 e I=2, la secuencia
sería 1, 3, 5, 7, 9... Con V=7 e I=10, la secuencia sería 7, 17, 27, 37... El programa solicitará al
usuario V, I además de N (no de valores a crear).
 * @author mati
 */
public class Exer13_arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // preguntar a usuario
        //valor V, I (incremento), N(numeros a crear)
        //definir array amb tamany N
        //posicion 0 poner valor inicial V
        //repetir N veces el incremento
        //en las siguientes posiciones del array
        Scanner sc=new java.util.Scanner(System.in);
        
        int inicial ,incremento, num;
        
        System.out.println("ponga el valor inicial ");
        inicial=sc.nextInt();
        
        System.out.println("ponga la cantidad de numeros");
        num=sc.nextInt();
        
        System.out.println("ponga el incremento");
        incremento=sc.nextInt();
        
        int numeros[]=new int[num];
        numeros[0]= inicial;
        
        for (int i = 1; i < numeros.length; i++) {
            
            numeros[i]=numeros[i-1]+incremento;
            
        }
        mostrar_array(numeros);
    }

    private static void mostrar_array(int[] numeros) {
        
        for (int i = 0; i < numeros.length; i++) {
            
            System.out.println(".... "+numeros[i]);
        }
    }
    
    
    
}
