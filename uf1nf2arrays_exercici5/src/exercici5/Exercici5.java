/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici5;

import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Exercici5 {

   public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        System.out.println("Inserte la cantidad de numeros");
        int array_length=sc.nextInt();
        int[]numeros=new int[array_length];
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Inserte numeros");
            numeros[i]=sc.nextInt();
        }
        int suma = 0;
       for (int i = 0; i < numeros.length; i++) {
                suma = suma + numeros[i];
        }
       float media;
       media =(float)suma / numeros.length;
       
             System.out.println("La media es"+media);
    }
    


}
