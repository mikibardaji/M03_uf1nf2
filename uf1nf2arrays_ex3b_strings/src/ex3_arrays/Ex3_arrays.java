/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3_arrays;

import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Ex3_arrays {

    /**
     * @Crea un programa que pida por teclado tres cadenas de texto:
     * nombre y dos apellidos. Luego
mostrará un código de usuario (en mayúsculas) formado 
* por la concatenación de las tres
primeras letras de cada uno de ellos. Por ejemplo si se introduce “Lionel”, “Tarazón” y
“Alcocer” mostrará “LIOTARALC”.
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1,s2,s3;
        System.out.println("Pon una palabra");
        s1 = sc.nextLine();
        System.out.println("Pon una palabra");
        s2 = sc.nextLine();
        System.out.println("Pon una palabra");
        s3 = sc.nextLine();
        /*opcion1*/
        String s4 = recortar_string(s1);
        String s5 = recortar_string(s2);
        String s6 = recortar_string(s3);
        System.out.println(s4+s5+s6);
        /*opcion2*/
        s1 = s1.substring(0,3);
        s2 = s2.substring(0,3);
        s3 = s3.substring(0,3);
        System.out.println(s1 + s2 + s3);
        /*segunda opcion*/
        int limite=3;
        if (s1.length()<3)
        {
            limite=s1.length();
        }
        for (int i = 0; i < limite; i++) {
            System.out.print(s1.charAt(i));
        }
         if (s2.length()<3)
        {
            limite=s2.length();
        }       
        for (int i = 0; i < limite; i++) {
            System.out.print(s2.charAt(i));
        }
        if (s2.length()<3)
        {
            limite=s2.length();
        }
        for (int i = 0; i < limite; i++) {
            System.out.print(s3.charAt(i));
        }
        
    }

    private static String recortar_string(String s1) {
        return s1.substring(0,3);
    }
    
}
