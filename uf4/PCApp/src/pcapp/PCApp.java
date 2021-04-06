/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcapp;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class PCApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Scanner sc;
        sc = new Scanner(System.in);
        Ordenador WOPR = new Ordenador();
        do{
        System.out.println("1.-Arrancar");
        System.out.println("2.-Apagar");
        System.out.println("3.-Arrancar Programa");
        System.out.println("4.-Parar Programa");
        System.out.println("5.-Dar la hora");
        System.out.println("0.-salir");
        opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion)
        {
            case 1:
                WOPR.encender();
                break;
            case 2:
                WOPR.apagar();
                break;
            case 3:
                System.out.println("que programa quieres");
                WOPR.arrancarPrograma(sc.nextLine());
                break;    
            case 4:
                System.out.println("que programa quieres apagar");
                WOPR.pararPrograma(sc.nextLine());
                break;    
            case 5:
                WOPR.darHora();
                break; 
            default:
                System.out.println("opcion incorrecta");
                break;
        }
              
        }while(opcion!=0);
    }
    
}
