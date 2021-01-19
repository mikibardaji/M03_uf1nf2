/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearrays;

import java.util.Arrays;

/**
 *
 * @author mati
 */
public class ClaseArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] num1 = {2,3,4};
        int[] num2 = {2,3,5,6,4};
        //boolean iguales = Arrays.equals(num1, num2);
        if (Arrays.equals(num1, num2))
        {
            System.out.println("iguales");
        }
        else
        {
            System.out.println("diferentes");
        }
        
        int posicion = Arrays.binarySearch(num2, 4);
        System.out.println("el 3 esta en la opsicion " + posicion);
    }
    
}
