/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nfarrays_ejercicio2;

import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Uf1nfArrays_ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserte la cantidad de numeros que quieres introducir");
        int array_length=sc.nextInt(); //la cantidad de casillas
        int[]numeros=new int[array_length];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("inserte numeros");
            numeros[i]=sc.nextInt();//el valor de la posicion
        }
        
        int suma=0;
        for (int i = 0; i < numeros.length; i++) {
            suma =suma + numeros[i];
        }
        System.out.println("La suma total es " + suma);
    }
    
}
