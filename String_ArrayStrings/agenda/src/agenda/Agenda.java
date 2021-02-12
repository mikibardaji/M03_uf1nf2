/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcio;
        String[] agenda = new String[100];
        inicialitzar_agenda_blancs(agenda);
        boolean operacio_correcta;
        do
        {
            menu();
            
            opcio = escollir_opcio(sc);
            sc.nextLine();
            switch(opcio)
            {
                case 1:
                    llistar_agenda(agenda);
                    break;
                case 2:
                    operacio_correcta = afegir_amic(agenda,sc);
                    break;
                case 0: 
                    System.out.println("Adeu");
                    break;
            }
        }while(opcio!=0);
    }

    /**mostra totes les opcions del menú*/
    private static void menu() {
        System.out.println("***********************");
        System.out.println("1.-Llistar Amics");
        System.out.println("2.-Afegir Amic");
        System.out.println("3.-Canviar Amic");
        System.out.println("4.-Borrar Amics");
        System.out.println("5.-Trobar posició amics");
        System.out.println("0.-Sortida");
        System.out.println("***********************");
    }

    /*escull opcio del menu valida*/
    private static int escollir_opcio(Scanner sc) {
        
        int opcio;
        do
        {
            System.out.print("Escull opciò valida: ");
            opcio = sc.nextInt();
        }while(opcio<0 || opcio >5);
        
        return opcio;
    }

    private static void inicialitzar_agenda_blancs(String[] agenda) {
        Arrays.fill(agenda, "");
    }

    private static void llistar_agenda(String[] agenda) {
        
        for (int i = 0; i < agenda.length; i++) {
            if (!agenda[i].isEmpty())
            {
                System.out.println((i+1) + ".-" + agenda[i]);
            }
            else
                break;
        }
        System.out.println("amics llistats" + i);
    }

    private static boolean afegir_amic(String[] agenda, Scanner sc) {
        System.out.println("Dis el nou amic que tens");
        String amic_nou = sc.nextLine();
        
        for (int i = 0; i < agenda.length; i++) {
            if(agenda[i].isEmpty())
            {
                agenda[i]= amic_nou;
                System.out.println("amic afegit a la agenda");
                return true;
            }
        }
        return false;
    }
    
}
