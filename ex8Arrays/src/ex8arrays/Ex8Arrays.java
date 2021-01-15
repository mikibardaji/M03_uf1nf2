/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex8arrays;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Ex8Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double huevera[] = new double [100];
         
        for (int i = 0; i < huevera.length; i++) {
            huevera[i]=Math.random();
        }
        System.out.println("Pon un valor entre 0 y 1:");
        double valor2=sc.nextDouble();
        int cont=0;
        for (int i = 0; i < huevera.length; i++) {
            if (huevera[i]>=valor2) {
                System.out.println("Es igual"); 
                System.out.println(huevera[i]);
                cont++;
            }
        }
        System.out.println("numeros mayores " + cont);
        
        
    }
    
} 
