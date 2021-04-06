/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokio2020;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Tokio2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Esport[] todos_deportes = new Esport[4];
        int deportes_informados = 0;
        int  menu;
        
        do
        {
             menu = mostrar_opciones_menu();
             switch(menu)
             {
                 case 1:
                     //Afegir un esport, amb tots els atletes que han aconseguit medalles.

                   deportes_informados=afegir_esport_atletes(todos_deportes, deportes_informados);
                     break;
                 case 2:
                     listarTodosDeporte(todos_deportes, deportes_informados);
                     break;
                 case 3:
                      mejorDeportista(todos_deportes, deportes_informados);
                     break;    
                 case 4:
                     mejorDeportistaxDeporte(todos_deportes, deportes_informados);
                     break;
                 case 5:
                     break;                  
                case 0:
                    System.out.println("adios..");
                     break;                 
             }
        }while(menu!=0);
    }
    
    
    
    
     private static int mostrar_opciones_menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.-Introduir dades esport-atletes ");
            System.out.println("2.- Listar todos x Deporte");
            System.out.println("3.- Atleta amb més medalles (classificació general) ");
            System.out.println("4.-Atleta amb més medalles (segons esports)\n"
                    + "5.-Imprimir pòdium esport (1,5 punts)\n"              
                    + "0. Sortir");
            System.out.print("Pon opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 5);
        return opcion;
}

    private static int afegir_esport_atletes(Esport[] todos_deportes, int sport_inf) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que deporte quieres?");
        tipoDeporte anyadir = tipoDeporte.valueOf(sc.nextLine().toUpperCase());
        
        //tengo que buscar si este deporte ya lo tenia añadido
        int indice = encontrarDeporteExiste(todos_deportes, sport_inf, anyadir);

        //hauria de buscar si el esport el tinc ja al array
        if(indice==-1)
        {
        inicializar_posicion(todos_deportes,sport_inf,anyadir);
        sport_inf++;
        indice = encontrarDeporteExiste(todos_deportes, sport_inf, anyadir);
        
        }
        //añadir_atletas y sus medallas
        String seguir;
        do{
            
            todos_deportes[indice].participantes[todos_deportes[indice].cont_participantes]=introduir_atleta(sc);
            //al participanete le asigno medallas
            todos_deportes[indice].medallas[todos_deportes[indice].cont_participantes] = (int) (Math.random()*20);
            //aumento el numero de participantes
            todos_deportes[indice].cont_participantes++;
            
            System.out.println("añadir otro atleta(SI/NO) ");
            seguir = sc.nextLine();
            
        }while(seguir.equalsIgnoreCase("SI"));
            
             return sport_inf;
    }

    private static void inicializar_posicion(Esport[] todos_deportes, int sport_inf, tipoDeporte anyadir) {
        todos_deportes[sport_inf]=new Esport();
        todos_deportes[sport_inf].medallas=new int[40];
        todos_deportes[sport_inf].participantes = new Atleta[40];
         todos_deportes[sport_inf].nom_deporte= anyadir;
    }

    private static Atleta introduir_atleta(Scanner sc) {
        Atleta anyadir = new Atleta();
        
        System.out.println("pon nombre atleta");
        anyadir.nom = sc.nextLine();
        System.out.println("pon pais atleta");
        anyadir.pais = sc.nextLine();
        return anyadir;
    }

    private static int encontrarDeporteExiste(Esport[] todos_deportes, int sport_inf, tipoDeporte anyadir) {
        for (int i = 0; i < sport_inf; i++) {
            if(todos_deportes[i].nom_deporte == anyadir)
            {//lo he encontrado y devuelvo su posicion
                return i;
            }
                
        }
        return -1; //este deporte no estaba
    }

    private static void listarTodosDeporte(Esport[] todos_deportes, int sport_inf) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Que deporte quieres?");
        tipoDeporte deporte_listar = tipoDeporte.valueOf(sc.nextLine().toUpperCase());
        
        int indice = encontrarDeporteExiste(todos_deportes, sport_inf, deporte_listar);
        if (indice!=-1)
        {
            for (int i = 0; i < todos_deportes[indice].cont_participantes; i++) {
     System.out.println(todos_deportes[indice].participantes[i].nom + "-"+ todos_deportes[indice].medallas[i]);
                
            }
        }else
        {
            System.out.println("no hau participantes");
        }
    }

    private static void mejorDeportistaxDeporte(Esport[] todos_deportes, int sport_inf) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Que deporte quieres?");
        tipoDeporte deporte_listar = tipoDeporte.valueOf(sc.nextLine().toUpperCase());
        
        int medallas_max=0,pos_mejor=0;
        
        int indice = encontrarDeporteExiste(todos_deportes, sport_inf, deporte_listar);
        
        if (indice!=-1)
        {
            for (int i = 0; i < todos_deportes[indice].cont_participantes; i++) {
                if(todos_deportes[indice].medallas[i]> medallas_max)
                {
                    medallas_max=todos_deportes[indice].medallas[i];
                    pos_mejor=i;
                }
                
            }
            System.out.println("El mejor atleta es" +
                    todos_deportes[indice].participantes[pos_mejor].nom + " medallas" + todos_deportes[indice].medallas[pos_mejor]);
            
            
            
            
        }else
        {
            System.out.println("no hau participantes");
        }
    }

    private static void mejorDeportista(Esport[] todos_deportes, int deportes_informados) {
        int medallas_max=0;
        Atleta mejor = new Atleta();
        tipoDeporte mejor_deporte=null;
        for (int deporte = 0; deporte < deportes_informados; deporte++) {
            for (int atletas = 0; atletas < todos_deportes[deporte].cont_participantes; atletas++) {
                if(todos_deportes[deporte].medallas[atletas]> medallas_max) 
                {
                    medallas_max = todos_deportes[deporte].medallas[atletas];
                    mejor.nom = todos_deportes[deporte].participantes[atletas].nom;
                    mejor.pais = todos_deportes[deporte].participantes[atletas].pais;
                    mejor_deporte = todos_deportes[deporte].nom_deporte;
                    
                }
            }
            
        }
        System.out.println("El mejor es" + mejor.nom + "medalllas " + medallas_max + " - " + mejor_deporte);
    }
}