/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici4;

import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Exercici4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
         System.out.println("inserte el numero que quieres");
         int array_length=sc.nextInt(); //la cantidad de casillas
         int[]numeros=new int[array_length];
         int positivos=0, negativos=0;

         for (int i = 0; i < numeros.length; i++) {
                System.out.println("inserte un numero");
                numeros[i]=sc.nextInt();
         }
         
         for (int i = 0; i < numeros.length; i++) {
                if(numeros[i] > 0){
                    positivos=positivos+numeros[i];
                }
                if(numeros[i] < 0){
                    negativos=negativos+numeros[i];
                }
        }
         System.out.println("Positivos: " + positivos );
         System.out.println("Negativos: " + negativos);
    }
    
}
