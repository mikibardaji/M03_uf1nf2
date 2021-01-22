/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex19_arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Necesitamos crear un programa para mostrar el ranking de puntuaciones 
 * de un torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que 
 * introduzca las puntuaciones de todos los jugadores (habitualmente 
 * valores entre 1000 y 2800, de tipo entero) y luego muestre
las puntuaciones en orden descendente (de la más alta a la más baja).
 * @author usuari
 */
public class Ex19_arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] puntuaciones = new int[4];
        int[] descendientes = new int[4];
        int i=0;
            do{
            System.out.println("pon la puntuacion del jugador enre 1000 y 2800 " + (i+1));
            puntuaciones[i] = sc.nextInt();
            if (puntuaciones[i]>=1000 && puntuaciones[i]<=2800)
            {
                i++;
            }
            //no aumento la i i tornare a demanar ala mateixa posicio
            }while(i<puntuaciones.length);
        Arrays.sort(puntuaciones);
        System.out.println("==========");
       /* for (int j = puntuaciones.length-1; j >=0 ; j--) {
            System.out.println(puntuaciones[j]);
        }*/
        i=0;
        //ordena descendiente
        for (int j = puntuaciones.length-1; j >=0 ; j--) {
            descendientes[i] = puntuaciones[j];
            i++;
        }
        
        //muestra por pantalla
        for (int j = 0; j < puntuaciones.length; j++) {
            System.out.println(puntuaciones[i]);
        }
    }
    
}
