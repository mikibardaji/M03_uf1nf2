/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Agenda_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] agenda = new String[100];//totes posicones estan a null
        inicialitzar_agenda(agenda);
        int opcion;
        boolean correcte;
        do {
            menu();
            opcion = escollir_opcio();
            switch (opcion) {
                case 1: //llistaramics
                    llistar_amics(agenda);
                    break;
                case 2:
                    correcte = afegir_amic(agenda);
                    metodo_burbuja(agenda);
                    break;
                case 3:
                    correcte = canvi_amic(agenda);
                    break;
                case 4:
                    correcte = eliminar_amic(agenda);
                    break;
                case 5:
                    correcte = encontrar_amic(agenda);
                    System.out.println(correcte);
                    break;
                case 0:
                    System.out.println("sortint de la agenda");
                    break;

            }

        } while (opcion != 0);
    }

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

    private static int escollir_opcio() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("Escull opcio valida: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    private static void inicialitzar_agenda(String[] agenda) {
        Arrays.fill(agenda, "");
        //totes les posicions estan a ""
        //sino faig un bucle agenda[i] ="";
    }

    private static void llistar_amics(String[] agenda) {
        int cont = 0;

        for (int i = 0; i < agenda.length; i++) {
            //if (agenda[i]!="")
            //if (agenda[i] != null)
            if (!agenda[i].isEmpty()) {
                System.out.println((i + 1) + "-" + agenda[i]);
                cont++;
            }

        }
        System.out.println("amics llistats: " + cont);
    }

    private static boolean afegir_amic(String[] agenda) {

        String nom;

        Scanner sc = new Scanner(System.in);

        System.out.println("Nom de l'amic:");
        nom = sc.nextLine();

        for (int i = 0; i < agenda.length; i++) {

            if (agenda[i].equals("")) {

                agenda[i] = nom;
                System.out.println("Amic afegit");

                return true;

            }

        }
        System.out.println("L'Array esta ple");

        return false;

    }

    private static boolean canvi_amic(String[] agenda) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nom de l'amic:");
        String nom = sc.nextLine();

        System.out.println("Per que vols canviar el nom: ");
        String edicio = sc.nextLine();

        for (int i = 0; i < agenda.length; i++) {

            if (agenda[i].equalsIgnoreCase(nom)) {

                agenda[i] = edicio;

                System.out.println("Amic editat.");

                return true;

            }

        }
        System.out.println("No tens aquest amic.");

        return false;
    }

    private static boolean encontrar_amic(String[] agenda) {
        Scanner sc = new Scanner(System.in);
        String nom;
        System.out.println("Nom de l'amic");
        nom = sc.nextLine();

        for (int i = 0; i < agenda.length; i++) {
            System.out.println(i + " " + agenda[i]);
            if (agenda[i].equalsIgnoreCase(nom)) {
                System.out.println("esta en la posicio " + i);
                return true;
            }
        }
        return false;
    }

    private static boolean eliminar_amic(String[] agenda) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿A quien quieres eliminar? ");
        String eliminado = sc.nextLine();

        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i].equalsIgnoreCase(eliminado)) {
                agenda[i] = "";
                for (int j = i; j < (agenda.length - 1); j++) {
                    agenda[j] = agenda[j + 1];
                }
                agenda[agenda.length - 1] = "";
                System.out.println("Amigo borrado.");
                return true;
            }
        }

        System.out.println("Ya no era tu amigo.");

        return false;

    }
    
    
    
    
    private static void metodo_burbuja(String[] agenda) {
        //int i,j;
       int ele_ordenados, j;
       String aux;
       
        for (ele_ordenados = 0; ele_ordenados < agenda.length; ele_ordenados++) {
            for(j=0;j<(agenda.length-ele_ordenados-1);j++)
            {
               //(numeros[j]>numeros[j+1])
                //es el mismo metodo de la burbuja
                //adaptando la comparación a Strings
                if(agenda[j].compareTo(agenda[j+1])>0
                        && (!agenda[j+1].equals("")))
                    //&& (!agenda[j+1].equals("")) esta parte esta añadida
                    //porque para java el "" es primero alfabeticament que la A y corre todas las posiciones vacias al principio
                    //y no queremos que estas las cambie
                {//intercambio valores
                   aux=agenda[j];
                   agenda[j]=agenda[j+1];
                   agenda[j+1]= aux;
               
                }
                
            }
            
            
        }
       
    }

}
