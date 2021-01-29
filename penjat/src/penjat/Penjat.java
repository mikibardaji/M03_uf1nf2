/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjat;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Penjat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String frase = preguntar_frase();
        
        String minuscules=frase.toLowerCase();
        //minuscules.concat(frase);
        //minuscules.toLowerCase();
        System.out.println(minuscules + "-" + frase);
        char[] lletres = new char[frase.length()];
        plenar_guions(lletres);
        mostrar_lletres(lletres);
    }

    private static String preguntar_frase() {
        Scanner sc = new Scanner(System.in);
        String frase;
        do{
        System.out.println("Escriu la frase per ficar al penjat almenos tiene que tener 3 letras");
        frase=sc.next().toUpperCase();
        }while(frase.length()<3);
        return frase;
    }

    private static void plenar_guions(char[] lletres) {
        for (int i = 0; i < lletres.length; i++) {
            lletres[i]='_';
        }
    }

    private static void mostrar_lletres(char[] lletres) {
        for (int i = 0; i < lletres.length; i++) {
            System.out.print(lletres[i] + " ");
        }
        System.out.println("");
    }
    
}
