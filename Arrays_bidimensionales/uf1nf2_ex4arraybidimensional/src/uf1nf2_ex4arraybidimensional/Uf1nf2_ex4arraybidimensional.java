/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2_ex4arraybidimensional;

import java.util.Random;

/**
 * Necesitamos crear un programa 
 * para almacenar las notas de 4 alumnos 
 * (llamados “Alumno1”, “Alumno 2”, etc.) 
 * y 3 asignaturas. 
 * El usuario introducirá las notas 
 * por teclado y luego el programa 
 * mostrará la nota mínima, máxima y 
 * media de cada alumno.
 * 3 5 7   min 3 max 7 media (3+5+7)/3 = 5
 * 2 4 6 min 2 max 6 media (2+4+6)/3 = 4
 * 8 8 8
 * 
 * @author mati
 */
public class Uf1nf2_ex4arraybidimensional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int alumnos=4;
        int notas_alumno=3;
        int[][] notas_alumnos = new int[alumnos][notas_alumno];
        Random rd = new Random(System.currentTimeMillis());
        
         /*filas*/
        for (int i = 0; i < notas_alumnos.length; i++) {
            /*notas_alumnos[0].length num columnas*/
            System.out.print("Nota alumno " + (i+1));
            for (int j = 0; j < notas_alumnos[0].length; j++) {
                System.out.print(" nota " + (j+1) + ": " );
                notas_alumnos[i][j] = rd.nextInt(11);
                System.out.print(notas_alumnos[i][j]);
            }
            System.out.println("");
            
        }
        
        int min, max, media;
        
        for (int alumno = 0; alumno < notas_alumnos.length; alumno++)          {
            //min=0
            //max=10
            min = notas_alumnos[alumno][0];
            max = notas_alumnos[alumno][0];
            media=0;
            for (int notas = 0; notas < notas_alumnos[0].length; notas++) 
            {
                if(min>notas_alumnos[alumno][notas])
                {
                    min = notas_alumnos[alumno][notas];
                }
                if (max<notas_alumnos[alumno][notas])
                {
                   max=notas_alumnos[alumno][notas];  
                }
                media = media + notas_alumnos[alumno][notas];
            }/*termino notas alumno y paso al siguiente*/
            /* hago los calculos*/
            System.out.println("Minima alumno" + alumno + " es " + min );
            System.out.println("Maxima alumno" + alumno + " es " + max );
            //double media_double = //(double) /
            System.out.println("media alumno" + alumno + " es " + ((double)(media)/notas_alumnos[alumno].length) );
         }
        
        
    }
    
}
