/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex10arrays;

import java.util.Scanner;

/**
 *Crea un programa para realizar cálculos 
 * relacionados con la altura (en metros) 
 * de personas.Pedirá un valor N y 
 * luego almacenará en un array N alturas 
 * introducidas por teclado. 
 * Luego mostrará la altura media, máxima y mínima así como cuántas personas miden por encima ypor debajo de la media.
 * @author mati
 */
public class Ex10arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos alumnos hay?");
        int alumnos=sc.nextInt();
        
        double alturas[]=new double[alumnos];
        for (int i = 0; i < alturas.length; i++) {
            System.out.println("Pon altura");
            alturas[i]=sc.nextDouble();
        }
        double altura_maxima=alturas[0],altura_minima=alturas[0],altura_total = 0;
        
        for (int i = 0; i < alturas.length; i++) {
            if(alturas[i]>altura_maxima){
               altura_maxima=alturas[i]; 
            }
            if(alturas[i]< altura_minima){
                altura_minima=alturas[i];
            }
            altura_total=altura_total+alturas[i];  
        }
        double media=altura_total/alturas.length ;
        System.out.println("La altura maxima es :" + altura_maxima);
        System.out.println("La altura minima es :" + altura_minima);
        System.out.println("La altura media es :" + media);
        int superior=0,inferior=0;
        for (int i = 0; i < alturas.length; i++) {
            if(media<alturas[i]){
                superior++;
            }
            if(media>alturas[i]){
                inferior++;
            }
        }
        System.out.println("Supera " + superior);
        System.out.println("Inferior " + inferior);
    }
    
    
    
}
