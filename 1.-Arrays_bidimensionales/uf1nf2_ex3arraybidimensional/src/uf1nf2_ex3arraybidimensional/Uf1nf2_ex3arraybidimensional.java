/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2_ex3arraybidimensional;

import java.util.Scanner;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

/**
 * Crea un programa que cree una matriz 
 * de tamaño NxM (tamaño introducido por teclado) e introduzca en ella NxM valores 
 * (también introducidos por teclado). 
 * Luego deberá recorrer lamatriz 
 * y al final mostrar por pantalla 
 * cuántos valores son mayores que cero, 
 * cuántos sonmenores que cero 
 * y cuántos son igual a cero.
 * 
 * filas?2
 * columnas?3
 * -2
 * -5
 * 4
 * 5
 * 0
 * 3
 * 
 * hay dos negativos
 * hay 3 positivos
 * y ha yun 0
 * 
 * @author mati
 */
public class Uf1nf2_ex3arraybidimensional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int filas,columnas;
        System.out.println("Cuantas filas quieres");
        filas = sc.nextInt();
    System.out.println("Cuantas columnas quieres");
        columnas = sc.nextInt();
        int[][] valores = new int[filas][columnas];
        
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[0].length; j++) {
                System.out.println("Pon el valor para la fila " + i + " y columna " + j);
                valores[i][j] = sc.nextInt();
                
            }
            
        }
        
       int positivos=0,negativos=0, ceros=0;
       for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[0].length; j++) {
                if(valores[i][j]>0)
                {
                    positivos++;
                }
                else if(valores[i][j]<0)
                {
                    negativos++;
                }
                else
                {
                    ceros++;
                }
                    
            }
            
        }
        System.out.println("hay " + positivos + " positivos ");
        System.out.println("hay " + negativos + " negativos ");
        System.out.println("hay " + ceros + " ceros ");
        
        
    }
}
