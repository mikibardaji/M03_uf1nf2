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
        int amics_alta = 0;
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
                    mostrar_agenda(agenda, amics_alta);
                    break;
                case 2:
                    amics_alta = alta_amigo(agenda, amics_alta, ent);
                    break;
                case 4:
                    amics_alta = borrar_amigo(agenda, amics_alta, ent);
                    break;
                case 5:
                    encontrar_amigo(agenda, amics_alta, ent); //pedir nombre y decir la posicion
                    break;
                case 6:
                    correcte = cambiar_telefono(agenda, amics_alta, ent);
                    break;
                    case 7:
                    encontrar_telefon_amigo(agenda, amics_alta, ent); //pedi
                     break;
                case 8:
                    encontrar_amigo_telefon(agenda, amics_alta, ent); //pedi
                    break;
                case 9:
                    amics_alta = borrar_amigo_telf(agenda, amics_alta, ent);
                    break;
                case 10:
                    ordenar_por_telefono(agenda, amics_alta);
                    break;
            }
        } while (opcion != 0);
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
        System.out.println("6.-Canviar telefon a partir nom");
        System.out.println("7.-Cercar telefon a partir del nom");
        System.out.println("8.-Cercar nom a partir del telèfon");
        System.out.println("9.-Esborrar qmic a partir del telèfon");
        System.out.println("10.- Ordenar per telèfon ");
        System.out.println("0.-Sortida");
        System.out.println("***********************");

    }

    private static int escollir_opcio(Scanner ent) {
        int opcio;
        do {
            System.out.print("Escull opciò valida: ");
            opcio = ent.nextInt();
        } while (opcio < 0 || opcio > 10);

        return opcio;
    }

    private static void mostrar_agenda(Amics[] agenda, int amics_alta) {

        for (int i = 0; i < amics_alta; i++) {
            System.out.println("Amigo " + (i + 1) + " nombre: " + agenda[i].nom);
            System.out.println("Telefono " + agenda[i].telefon + " mail: " + agenda[i].email);
        }
        System.out.println("amigos listados: " + amics_alta);
    }

    private static int alta_amigo(Amics[] agenda, int amics_alta, Scanner ent) {
        
        
        agenda[amics_alta] = crear_nuevo_amigo(ent);
        
/*
        System.out.print("Como se llama tu nuevo amigo? ");
        agenda[amics_alta].nom = ent.nextLine();
        System.out.print("Pon el telefono de tu amigo: ");
        agenda[amics_alta].telefon = ent.nextLong();
        ent.nextLine();//limpiar el enter despues de haber marcado opcion
        System.out.print("Pon el email de tu amigo :");
        agenda[amics_alta].email = ent.nextLine();
*/
        amics_alta++;
        return amics_alta;
    }

    private static void encontrar_amigo(Amics[] agenda, int amics_alta, Scanner ent) {
        String nom_buscat;
        System.out.println("Nom de l'amic");
        nom_buscat = ent.nextLine();

        for (int i = 0; i < amics_alta; i++) {
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

    private static void encontrar_amigo_telefon(Amics[] agenda, int amics_alta, Scanner ent) {

        boolean encontrado = false;

        System.out.print("¿Número del amigo? ");
        long tel = ent.nextLong();

        for (int i = 0; i < amics_alta; i++) {
            if (agenda[i].telefon == tel) {
                System.out.println(agenda[i].nom + " encontrado y su tel es:" + agenda[i].telefon);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Telefono " + tel + " no ha sido encontrado");
        }

    }

    private static boolean cambiar_telefono(Amics[] agenda, int amics_alta, Scanner ent) {
        System.out.println("Introduce el nombre del amigo que quieres editar el telefono: ");
        String amic_buscat = ent.nextLine();
        
        System.out.println("Introduce el nuevo telefono:");
        long telefon_nou = ent.nextLong();
        
        for (int i = 0; i < amics_alta; i++) {
            if(agenda[i].nom.equalsIgnoreCase(amic_buscat)){
                agenda[i].telefon = telefon_nou;
                System.out.println("Telefon canviat.");
                return true;
            }
        }
        System.out.println("Amic no trobat!");
        return false;
    }

    private static void encontrar_telefon_amigo(Amics[] agenda, int amics_alta, Scanner ent) {
        
        boolean encontrado = false;

        System.out.print("¿Nombre del amic? ");
        String amic = ent.nextLine();

        for (int i = 0; i < amics_alta; i++) {
            if (agenda[i].nom.equalsIgnoreCase(amic)) {
                System.out.println(agenda[i].telefon + " encontrado y su nombre es:" + agenda[i].nom);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Amic " + amic + " no ha sido encontrado");
        }
        
        
        
        
    }

    private static int borrar_amigo_telf(Amics[] agenda, int amics_alta, Scanner ent) {
        System.out.print("¿A quien quieres eliminar? (Especifica su telefono): ");
        long telefon_eliminar = ent.nextLong();

        for (int i = 0; i < amics_alta; i++) {
            if (agenda[i].telefon==(telefon_eliminar)) {
                //mover todos los de la derecha una posicion
                for (int j = i; j < (amics_alta - 1); j++) {
                    agenda[j].nom = agenda[j + 1].nom;
                    agenda[j].telefon = agenda[j + 1].telefon;
                    agenda[j].email = agenda[j + 1].email;
                }
                //agenda[amics_alta - 1].nom = "";
                //agenda[amics_alta - 1].email = "";
                //agenda[amics_alta - 1].telefon = 0;
                agenda[amics_alta-1]= new Amics();
                System.out.println("Amigo borrado.");
                amics_alta--;
            }
        }
        return amics_alta;
    }

    private static void ordenar_por_telefono(Amics[] agenda, int amics_alta) {
       
        //int i,j;
       int ele_ordenados, j;
       Amics aux = new Amics();
       
        for (ele_ordenados = 0; ele_ordenados < amics_alta; ele_ordenados++) {
            for(j=0;j<(amics_alta-ele_ordenados-1);j++)
            {//resto ele_ordenados, porque cuando
                //los finales ya estan ordenados 
                //no quiero que llegue a esas posiciones, se podria hacer sin la resta también
            
                if(agenda[j].telefon>agenda[j+1].telefon)
                {//intercambio valores
                   aux.nom=agenda[j].nom;
                   aux.telefon=agenda[j].telefon;
                   aux.email=agenda[j].email;
                   
                   agenda[j].nom=agenda[j+1].nom;
                   agenda[j].telefon=agenda[j+1].telefon;
                   agenda[j].email=agenda[j+1].email;
                   
                  agenda[j+1].nom =  aux.nom;
                  agenda[j+1].telefon = aux.telefon;
                  agenda[j+1].email = aux.email;
                }
            }
        }
        System.out.println("amigos ordenados por telefono");   
    }

    private static Amics crear_nuevo_amigo(Scanner ent) {
        Amics alta = new Amics();
        
        System.out.print("Como se llama tu nuevo amigo? ");
        alta.nom = ent.nextLine();
        System.out.print("Pon el telefono de tu amigo: ");
        alta.telefon = ent.nextLong();
        ent.nextLine();//limpiar el enter despues de haber marcado opcion
        System.out.print("Pon el email de tu amigo :");
        alta.email = ent.nextLine();
        
        return alta;
    }
    
}
