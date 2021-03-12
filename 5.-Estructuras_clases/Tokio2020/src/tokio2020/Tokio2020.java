/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokio2020;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class Tokio2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deporte[] todosDeportes = new Deporte[4];
        int deportes_informados=0;
        int menu;

        
         do {
            //mostrar el nombre del jugador

            menu = mostrar_opciones_menu();
            switch (menu) {
                case 1:
                    deportes_informados=introducir_deporte_atletas(todosDeportes,deportes_informados);
                    break;
                case 2:
                    listar_todos(todosDeportes,deportes_informados);
                    break;
                case 3:
                    atleta_mas_medallas(todosDeportes,deportes_informados);
                    break;
                case 4:
                    
                   
                    break;
                case 5:
                    
                    break;
            }
        } while (menu != 0);
        
        
    }
    
    
     private static int mostrar_opciones_menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.-Introduir dades esport-atletes ");
            System.out.println("2.-Listar todos");
            System.out.println("3.-Atleta amb més medalles (classificació general)");
            System.out.println("4.-Atleta amb més medalles (segons esports)\n"
                    + "5.-Imprimir pòdium esport\n"
                    + "0. Sortir");
            System.out.print("Pon opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 11);
        sc.nextLine();//borra el return que no es un entero
        return opcion;

    }

     /** Pedira nombre de deporte, si no existe y es valido (enum) añadiras todos los atletas
      * de ese deporte y sus medallas
      * @param todosDeportes 
      */
    private static int introducir_deporte_atletas(Deporte[] todosDeportes, int deportes_informados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pon el deporte");
        TipoDeporte anyadir = TipoDeporte.valueOf(sc.nextLine().toUpperCase());
        //añado deporte al final
        String seguir;
        
        int existe = encontrarDeporte(todosDeportes, deportes_informados, anyadir);
        if (existe==-1 && deportes_informados<todosDeportes.length)
        {
            inicializar_deporte(todosDeportes, deportes_informados,anyadir);
            existe=deportes_informados;
            deportes_informados++;
        }
        
        

        //añadir atletas
        do{
            //datos del atleta o recorro para encontrar la posición vaci
            //num_atleta_participan me dejara que añada mas atletas
            todosDeportes[existe].participants[todosDeportes[existe].num_atletas_participan] = introduir_dades_atleta(sc);
            
            //random de medallas
            todosDeportes[existe].medalles[todosDeportes[existe].num_atletas_participan]= (int) (Math.random()*10);
            
            todosDeportes[existe].num_atletas_participan++;
            System.out.println("Quieres añadir otro atleta(SI/NO)");
            seguir = sc.nextLine();
            
            //sigo mientras diga que si y también no haya superado el tope.
        }while(seguir.equalsIgnoreCase("SI") && todosDeportes[existe].num_atletas_participan< todosDeportes[existe].participants.length);
        
 
        
        return deportes_informados;
    }

    private static Atleta introduir_dades_atleta(Scanner sc) {
       Atleta anyadir = new Atleta();
        System.out.println("pon su nombre");
        anyadir.nom = sc.nextLine();
        System.out.println("pon su pais");
        anyadir.pais = sc.nextLine();
        return anyadir;
    }

    private static void listar_todos(Deporte[] todosDeportes,int deportes_informados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pon el deporte");
        TipoDeporte anyadir = TipoDeporte.valueOf(sc.nextLine());
        int posicion_array = encontrarDeporte(todosDeportes, deportes_informados, anyadir);
        if (posicion_array!=-1)
        {
            for (int i = 0; i < todosDeportes[posicion_array].num_atletas_participan; i++) 
            {
            System.out.println("Participante" + todosDeportes[posicion_array].participants[i].nom + " medallas: " +  todosDeportes[posicion_array].medalles[i]);
            }
            System.out.println("Participanetes " + todosDeportes[posicion_array].num_atletas_participan);
        }
        
    }

    private static int encontrarDeporte(Deporte[] todosDeportes, int deportes_informados, TipoDeporte anyadir) {
        for (int i = 0; i < deportes_informados; i++) {
            if (todosDeportes[i].nomEsport==anyadir)
                return i;
        }
        return -1;
    }

    private static void inicializar_deporte(Deporte[] todosDeportes, int deportes_informados, TipoDeporte anyadir) {
                todosDeportes[deportes_informados] = new Deporte();
        todosDeportes[deportes_informados].nomEsport = anyadir;
        todosDeportes[deportes_informados].participants = new Atleta[40];
        todosDeportes[deportes_informados].medalles = new int[todosDeportes[deportes_informados].participants.length];
    }

    private static void atleta_mas_medallas(Deporte[] todosDeportes, int deportes_informados) {
        Atleta mejor = new Atleta();
        int max_medallas= 0;
        //recorro todos los deportes informados
        for (int i = 0; i < deportes_informados; i++) {
            //dentro de cada deporte busco el que tenga más medallas
            for (int j = 0; j < todosDeportes[i].num_atletas_participan; j++) {
                if (todosDeportes[i].medalles[j]> max_medallas)
                {
                    mejor.nom = todosDeportes[i].participants[j].nom;
                    mejor.pais = todosDeportes[i].participants[j].pais;
                    max_medallas = todosDeportes[i].medalles[j];
                }
            }
        }
        System.out.println("El mejor es " + mejor.nom + " pais " + mejor.pais + " medallas" + max_medallas);
    }
}
