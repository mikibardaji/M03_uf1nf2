/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofres;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Cofres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carta[] disponibles = new Carta[5];//todas las del juego
        Carta[] tuyas = new Carta[disponibles.length];
        int num_cartas_tuyas = 0, menu, monedas = 0;
        cargar_cartas_disponibles(disponibles);
        do {
            menu = mostrar_opciones_menu();
            switch (menu) {
                case 1:
                    mostrartodascartasJuego(disponibles);
                    break;
                case 2:
                    monedas = monedas + encontrar_monedas(450, 50);
                    num_cartas_tuyas = abrir_cofres(disponibles, tuyas, num_cartas_tuyas);
                    break;
                case 3:
                    mostrartuscartas(tuyas, num_cartas_tuyas);
                    System.out.println("monedas" + monedas);
                    break;

                case 6:
                    monedas = subir_nivel(tuyas, monedas, num_cartas_tuyas);

                    break;
            }
        } while (menu != 0);

    }

    private static void cargar_cartas_disponibles(Carta[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) {
            disponibles[i] = new Carta();
        }

        disponibles[0].nombre = "Pekka";
        disponibles[0].elixir = 7;
        //disponibles[0].level no hace falta
        //disponibles[0].puntos_carta no hace

        disponibles[1].nombre = "Mini Pekka";
        disponibles[1].elixir = 4;
        disponibles[2].nombre = "Leñador";
        disponibles[2].elixir = 4;
        disponibles[3].nombre = "Globo Bombastico";
        disponibles[3].elixir = 5;
        disponibles[3].nombre = "Ejercito esqueletos";
        disponibles[3].elixir = 3;
        disponibles[4].nombre = "Descarga";
        disponibles[4].elixir = 2;

    }

    private static int mostrar_opciones_menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.-Mostrar totes les cartes disponibles del joc");
            System.out.println("2.- Obrir Cofre");
            System.out.println("3.- Mostrar totes les teves cartes");
            System.out.println("4.-Buscar Carta\n"
                    + "5.-Consulta saldo monedes\n"
                    + "6.- Pujar nivell carta\n"
                    + "0. Sortir");
            System.out.print("Pon opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 11);

        return opcion;

    }

    private static void mostrartodascartasJuego(Carta[] disponibles) {
        for (int i = 0; i < disponibles.length; i++) {
            System.out.println("->" + disponibles[i].nombre + " elixir:" + disponibles[i].elixir);
        }
    }

    private static int abrir_cofres(Carta[] disponibles, Carta[] tuyas, int num_cartas_tuyas) {

        Carta añadir = new Carta();

        for (int j = 0; j < 2; j++) {
            añadir = cartaAleatoria(disponibles);
            boolean comprovador = false;
            for (int i = 0; i < num_cartas_tuyas; i++) {
                if (tuyas[i].nombre.equals(añadir.nombre)) {
                    System.out.println("tienes una carta parecida sumamos los puntos");
                    tuyas[i].puntos_carta = tuyas[i].puntos_carta + añadir.puntos_carta;
                    comprovador = true;
                }
            }
            if (comprovador == false) {
                tuyas[num_cartas_tuyas] = añadir;
                System.out.println("hemos añadido la carta porque no la tenias");
                num_cartas_tuyas = num_cartas_tuyas + 1;
            }
        }

        //abrir_carta * 2;
        return num_cartas_tuyas;
    }

    private static int encontrar_monedas(int quantitat_numeros, int inici) {
        int monedas = (int) (Math.random() * quantitat_numeros) + inici;
        System.out.println("te salen " + monedas + " monedas");
        return monedas;
    }

    private static Carta cartaAleatoria(Carta[] disponibles) {

        int random = (int) (Math.random() * disponibles.length);
        int puntos = (int) (Math.random() * 19) + 1;

        Carta Random = new Carta();
        Random.nombre = disponibles[random].nombre;
        Random.puntos_carta = puntos;
        Random.elixir = disponibles[random].elixir;

        System.out.println("la carta nueva es " + Random.nombre + "\ntiene " + puntos + " puntos");

        return Random;

    }

    private static void mostrartuscartas(Carta[] tuyas, int num_cartas_tuyas) {
        for (int i = 0; i < num_cartas_tuyas; i++) {
            System.out.println("->" + tuyas[i].nombre + " nivel:" + tuyas[i].level + " puntos cartas: " + tuyas[i].puntos_carta);
        }

    }

    /*pregutna la carta
    si la tiene, comprueba si tiene monedas y puntos para subirla un 
    nivel
    
    si es asi lo sube y actualiza monedas
    sino no lo aumnta
     */
    private static int subir_nivel(Carta[] tuyas, int monedas, int num_cartas_tuyas) {

        Scanner sc = new Scanner(System.in);

        String nom_introduit;
        System.out.println("Introdueix el nom de la carta");
        nom_introduit = sc.nextLine();
        int puntos_necesarios, monedas_necesarias;
        
        
        for (int i = 0; i < tuyas.length; i++) {
            
            if (nom_introduit.equalsIgnoreCase(tuyas[i].nombre)) {

                puntos_necesarios = 10 * (tuyas[i].level + 1);
                monedas_necesarias = (1000 * (tuyas[i].level + 1));

                if ((tuyas[i].puntos_carta >= puntos_necesarios) && monedas >= monedas_necesarias) {

                    tuyas[i].level++;
                 System.out.println("Has augmentat al nivell " + tuyas[i].level);
                 tuyas[i].puntos_carta = tuyas[i].puntos_carta - puntos_necesarios;
                 monedas = monedas - monedas_necesarias;
                 metodo_burbuja(tuyas, num_cartas_tuyas);
  
                } else {
                    System.out.println("Et falten monedes o punts");
                }
            }
        }

        return monedas;
    }

    private static void metodo_burbuja(Carta[] tuyas, int num_cartas_tuyas) {
        //int i,j;
       int ele_ordenados, j;
       Carta aux=new Carta();
       
        for (ele_ordenados = 0; ele_ordenados < num_cartas_tuyas; ele_ordenados++) {
            for(j=0;j<(num_cartas_tuyas-ele_ordenados-1);j++)
            {

                if(tuyas[j].level>tuyas[j+1].level)

                {//intercambio valores
                   aux.elixir =  tuyas[j].elixir;
                   aux.nombre =  tuyas[j].nombre;
                   aux.level =  tuyas[j].level;
                   aux.puntos_carta =  tuyas[j].puntos_carta;
                   
                   tuyas[j].elixir =  tuyas[j+1].elixir;
                   tuyas[j].nombre =  tuyas[j+1].nombre;
                   tuyas[j].level =  tuyas[j+1].level;
                   tuyas[j].puntos_carta =  tuyas[j+1].puntos_carta;
                   
                   tuyas[j+1].elixir =  aux.elixir;
                   tuyas[j+1].nombre =  aux.nombre;
                   tuyas[j+1].level =  aux.level;
                   tuyas[j+1].puntos_carta =  aux.puntos_carta;
               
                }
                
            }
            
            
        }
       
    }

    
    
    
    
    
}
