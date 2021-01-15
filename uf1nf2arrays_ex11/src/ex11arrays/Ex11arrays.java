/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11arrays;

import java.util.Scanner;

/**
 * 
 * Crea un programa que cree dos arrays de enteros de tamaño 100. 
 * Luego introducirá en elprimer array 
 * todos los valores del 1 al 100. 
 * Por último, deberá copiar todos los valores 
 * delprimer array al segundo array 
 * en orden inverso, y mostrar ambos por pantalla.
 * @author mati
 */
public class Ex11arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[] numero=new int [10];
        int[] numero_inverso=new int[10];
        for (int i = 0; i < numero.length; i++) {
            numero[i]=(int) (1 + Math.random()*100);
            System.out.print(numero[i] + "-");
        }
        System.out.println();
        int j;
        for (int i = numero.length-1; i >= 0; i--)
            
       {
           j=numero.length-i-1;
            numero_inverso[j]=numero[i];
      
        }
        
        j=0;
        for (int i = numero.length-1; i >= 0; i--)         {    
           j++;
           numero_inverso[j]=numero[i];     
        }
        
        
        for (int i = 0; i < numero_inverso.length; i++) {
            System.out.print(numero_inverso[i] + "-"); 
        }
        
    }
    
}
