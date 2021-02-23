/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex12arrays;

import java.util.Scanner;

/**
 * Crea un programa que cree un 
 * array de 10 enteros y luego 
 * muestre el siguiente menú 
 * condistintas opciones:
 * a. Mostrar valores.
 * b. Introducir valor.
 * c. Salir.
 * La opción ‘a’ mostrará todos los valores por pantalla. 
 * La opción ‘b’ pedirá un valor V y unaposición P, luego escribirá V en la posición P del array. 
 * El menú se repetirá indefinidamente hasta que el usuario elija la opción ‘c’ que terminará el programa.
 * 
 * 
 * 
 * @author mati
 */
public class Ex12arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeros[] = new int[10];
        Scanner sc=new Scanner(System.in);
        char opcion;
        do{
            mostrar_menu();
        opcion=sc.nextLine().charAt(0);
        switch(opcion)
        {
            case 'a':
                mostrar_array(numeros);
                break;
            case 'b':
                poner_valor(numeros);
                break;
            case 'c':
                System.out.println("adios...");
                break;
        }
        
        }while (opcion!='c');
    }

    private static void mostrar_array(int[] numeros)    {
        for (int indice = 0; indice < 10; indice++) {
            System.out.println(indice + ":" + numeros[indice]);
        }
    }

        private static void poner_valor(int[] numeros) {
Scanner sc=new Scanner(System.in);
            System.out.println("En que posicion quieres poner un valor");
            int posicion = sc.nextInt();
            System.out.println("Que valor quieres poner");
            int valor = sc.nextInt();
            numeros[posicion]=valor;
        }

    private static void mostrar_menu() {
        System.out.println("a.-Mostrar Array");
        System.out.println("b.-Poner Valor");
        System.out.println("c.- Salir");
        System.out.print("Pon opción: ");
    }
    
}
