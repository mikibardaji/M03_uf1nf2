/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici6;

import java.util.Scanner;

/**
 *Crea un programa que pida dos valores enteros N y M, 
 * luego cree un array de tamaño N,escriba M en todas sus posiciones
 * y lo muestre por pantalla.
 * @author usuari
 */
public class Exercici6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Pon el valor de N");
        int N=sc.nextInt();
        int[]valores=new int[N];
        System.out.println("Pon el valor de M");
        int M=sc.nextInt();
        
        for (int i = 0; i < valores.length; i++) {
            valores[i]=M; //inicializo todo a M
        }
        System.out.println("array");
        for (int i = 0; i <  valores.length; i++) {
            System.out.println(valores[i]);
        }
    }
    
}
