/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2arrays_ex16;

import java.util.Arrays;

/**
 *
 * @author mati
 */
public class Uf1nf2Arrays_ex16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamanyo=0;
        for (int i = 1; i <= 10; i++) {
            tamanyo += i; //tamanyo=tamanyo+i;
        }
        int []numeros = new int[tamanyo];
        
        Arrays.fill(numeros,0,1,1);
        Arrays.fill(numeros,1,3,2);
        Arrays.fill(numeros,3,6,3);
         Arrays.fill(numeros,6,10,4);
         for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]+",");
        }
    }
    
}
