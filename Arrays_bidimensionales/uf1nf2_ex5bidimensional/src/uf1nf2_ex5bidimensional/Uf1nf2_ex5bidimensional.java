/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2_ex5bidimensional;

import java.util.Scanner;

/**
 *
 * Necesitamos crear un programa para 
 * registrar sueldos de hombres y mujeres 
 * de una empresa y detectar si existe 
 * brecha salarial entre ambos. 
 * El programa pedirá por teclado la 
 * información de N personas distintas 
 * (valor también introducido por teclado). 
 * Para cada 
 * persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo. 
 * Esta información debe
 * guardarse en una única matriz. 
 * Luego se mostrará por pantalla el sueldo medio de cadagénero.
 */
public class Uf1nf2_ex5bidimensional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos trabajadores tienes?");
        int num_trabajadores = sc.nextInt();
        int[][] sueldos = new int[2][num_trabajadores];
        int homes=0, dones=0;
        int[] homes_dones = new int[2];
        int sexe, sueldo;
        //inclou dades al array pero ordenades per sexe
        incloure_datos(sueldos,homes_dones,num_trabajadores);
        mostrar_array(sueldos);
        calcular_media(sueldos,homes_dones);
        
    }

    private static void incloure_datos(int[][] sueldos, int[] homes_dones, int num_trabajadores) {
        Scanner sc = new Scanner(System.in);
        int sexe,sueldo;
        for (int i = 0; i < num_trabajadores; i++) {
            System.out.println("sexo del trabajador " + (i+1));
            sexe = sc.nextInt();
            System.out.println("sueldo trabajador " + (i+1));
            sueldo = sc.nextInt();
            //incloure array
            if (sexe==1) //dones
            {
               sueldos[sexe][homes_dones[sexe]] = sueldo;
               homes_dones[sexe]++;//aumento la posicio 1
            }
            else
            {
                sueldos[sexe][homes_dones[sexe]] = sueldo;
               homes_dones[sexe]++;
            }
        }
    }

    private static void mostrar_array(int[][] sueldos) {
        for (int i = 0; i < sueldos.length; i++) {
            for (int j = 0; j < sueldos[0].length; j++) {
                System.out.printf("%4d",sueldos[i][j]);
            }
            System.out.println("");
        }
        
    }

    private static void calcular_array(int[][] sueldos, int[] homes_dones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void calcular_media(int[][] sueldos, int[] homes_dones) {
          int hombres= homes_dones[0];
          int dones = homes_dones[1];
          
          int sueldo_h=0, sueldo_m=0;
          //hombres fila 0 es fija
          for (int i = 0; i < hombres; i++) {
            sueldo_h = sueldo_h + sueldos[0][i];
        }
          double media_h = (double) sueldo_h/hombres;
          System.out.println("hombres cobran: " + media_h);
          
           for (int i = 0; i < dones; i++) {
            sueldo_m = sueldo_m + sueldos[1][i];
        }
          double media_d = (double) sueldo_m/dones;
          System.out.println("mujeres cobran: " + media_d);
          
    }
    
}
