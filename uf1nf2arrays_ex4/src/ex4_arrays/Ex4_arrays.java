/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4_arrays;

import java.util.Scanner;

/**
 * Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas ‘a’,
cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
mayúsculas y minúsculas. Por ejemplo dada la frase “Mi mama me mima” dirá que hay:
Nº de A's: 3
Nº de E's: 1
Nº de I's: 2
Nº de O's: 0
Nº de U's: 0
 * @author usuari
 */
public class Ex4_arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        System.out.println("Pon una frase");
        frase = sc.nextLine();
        String frase_minuscula = frase.toLowerCase();
        int a=0,e=0,i=0,o=0,u=0;
        for (int j = 0; j < frase_minuscula.length(); j++) {
            if(frase_minuscula.charAt(j) == 'a')
            {
                a++;
            }
            else if(frase_minuscula.charAt(j) == 'e')
            {
                e++;
            } 
            else if(frase_minuscula.charAt(j) == 'i')
            {
                i++;
            } 
            else if(frase_minuscula.charAt(j) == 'o')
            {
                o++;
            } 
            else if(frase_minuscula.charAt(j) == 'u')
            {
                u++;
            } 
        }
        System.out.println("has escrito" + frase);
        System.out.println("a's: " + a);
        System.out.println("e's: " + e);
        System.out.println("i's: " + i);
        System.out.println("o's: " + o);
        System.out.println("u's: " + u);
    }
    
}
