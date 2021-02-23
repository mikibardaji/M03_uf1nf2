/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex9arrays;

import java.util.Scanner;

/**
 *Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valoresenteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N ymostrará en qué posiciones del array aparece N
 * @author mati
 */
public class Ex9arrays {

    /**
     * @param args the command line arguments(int) Math.random()
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int huevera[] = new int[20];
        for (int i = 0; i < huevera.length; i++) {
            huevera[i] = (int) (1 + Math.random()*10);
        }
        for (int i = 0; i < huevera.length; i++) {
            System.out.println("Valores: " + huevera[i]);
            
        }
        System.out.println("Pon un valor N: ");
        int valorN=sc.nextInt();
        for (int i = 0; i < huevera.length; i++) {
            if(huevera[i]==valorN){
                System.out.println("Posicion " + i);
            }
        }
    }
    
}
