/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda_amigos_clases;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Agenda_amigos_clases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Amics[] agenda = new Amics[10];
        inicialitzar_agenda(agenda);
        int amics_alta=0;
//todas las posiciones se pongan con su new
        int opcion;
        boolean correcte;
        Scanner ent = new Scanner(System.in);
        
   
        do {
            menu();
            opcion = escollir_opcio(ent);
            ent.nextLine();//limpiar el enter despues de haber marcado opcion
            switch (opcion) {
                case 1: 
                    mostrar_agenda(agenda,amics_alta);
                    break;
                case 2: 
                    amics_alta=alta_amigo(agenda,amics_alta, ent);
                    break;
                case 4: 
                    amics_alta=borrar_amigo(agenda,amics_alta, ent);
                    break;    
                case 5:
                    encontrar_amigo(agenda,amics_alta,ent); //pedir nombre y decir la posicion
             }
    }while(opcion!=0);
        }

    private static void inicialitzar_agenda(Amics[] agenda) {
        for (int i = 0; i < agenda.length; i++) {
            agenda[i] = new Amics();//inicializamos
        }
        //Arrays.fill(agenda,new Amics());
    }

    private static void menu() {

        System.out.println("\n\n***********************");
        System.out.println("1.-Llistar Amics");
        System.out.println("2.-Afegir Amic");
        System.out.println("3.-Canviar Amic");
        System.out.println("4.-Borrar Amics");
        System.out.println("5.-Trobar posició amics");
        System.out.println("0.-Sortida");
        System.out.println("***********************");
        
 
    }

    private static int escollir_opcio(Scanner ent) {
        int opcio;
        do {
            System.out.print("Escull opciò valida: ");
            opcio = ent.nextInt();
        } while (opcio < 0 || opcio > 5);

        return opcio;
    }

    private static void mostrar_agenda(Amics[] agenda, int amics_alta) {
        
        for (int i = 0; i < amics_alta; i++) {
            System.out.println("Amigo " + (i+1) + " nombre: " + agenda[i].nom);
            System.out.println("Telefono " + agenda[i].telefon + " mail: " + agenda[i].email);
        }
        System.out.println("amigos listados: " + amics_alta);
    }

    private static int alta_amigo(Amics[] agenda, int amics_alta, Scanner ent) {
        
        System.out.print("Como se llama tu nuevo amigo? ");
        agenda[amics_alta].nom = ent.nextLine();
        System.out.print("Pon el telefoo de tu amigo: ");
        agenda[amics_alta].telefon = ent.nextLong();
        ent.nextLine();//limpiar el enter despues de haber marcado opcion
        System.out.print("Pon el email de tu amigo :");
        agenda[amics_alta].email = ent.nextLine();
        amics_alta++;
        return amics_alta;
    }

    private static void encontrar_amigo(Amics[] agenda, int amics_alta, Scanner ent) {
         String nom_buscat;
        System.out.println("Nom de l'amic");
        nom_buscat = ent.nextLine();

        for (int i = 0; i < amics_alta ; i++) {
            //System.out.println(i + " " + agenda[i]);
            if (agenda[i].nom.equalsIgnoreCase(nom_buscat)) {
                System.out.println("El teu amic esta a la posicio " + i);
                System.out.println("El seu telefon es " + agenda[i].telefon);
                
            }
        }
        
    }

    private static int borrar_amigo(Amics[] agenda, int amics_alta, Scanner ent) {
          System.out.print("¿A quien quieres eliminar? ");
        String nombre_eliminar = ent.nextLine();

            for (int i = 0; i < amics_alta; i++) {
                if (agenda[i].nom.equalsIgnoreCase(nombre_eliminar)) {
                    //mover todos los de la derecha una posicion
                    for (int j = i; j < (amics_alta - 1); j++) {
                        agenda[j].nom = agenda[j + 1].nom;
                        agenda[j].telefon = agenda[j + 1].telefon;
                        agenda[j].email = agenda[j + 1].email;
                    }
                    agenda[amics_alta - 1].nom = "";
                    agenda[amics_alta - 1].email = "";
                    agenda[amics_alta - 1].telefon = 0;
                    System.out.println("Amigo borrado.");
                    amics_alta--;
                }
            }
            return amics_alta;
    }
    
    
}
