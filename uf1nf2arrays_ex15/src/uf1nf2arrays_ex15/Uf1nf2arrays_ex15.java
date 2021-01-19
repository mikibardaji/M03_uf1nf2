/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2arrays_ex15;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Uf1nf2arrays_ex15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("cuantos numeros quieres tener");
        int num=sc.nextInt();
        System.out.println("Que numero quieres");
        int M=sc.nextInt();
        
        int[] valores=new int[num];
        Arrays.fill(valores, M);
        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i]+",");
        }
        
    }
    
}
