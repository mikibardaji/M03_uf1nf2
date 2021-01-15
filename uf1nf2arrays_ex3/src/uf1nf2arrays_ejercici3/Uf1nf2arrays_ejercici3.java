/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2arrays_ejercici3;

import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Uf1nf2arrays_ejercici3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("inserte el numero que quieres");
         int array_length=sc.nextInt(); //la cantidad de casillas
         int[]numeros=new int[array_length];
         

         for (int i = 0; i < numeros.length; i++) {
                System.out.println("inserte un numero");
                numeros[i]=sc.nextInt();
         }
         int max=numeros[0], min=numeros[0];
         for (int i = 0; i < numeros.length; i++) {
               
                if(numeros[i]>max){
                max=numeros[i];
                }
                if(numeros[i]<min){
                min=numeros[i];
                }
                
         }
         System.out.println("El numero maximo es " + max);
         System.out.println("El numero minimo es " + min);
         }
}
    
    

