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
        int num_cartas_tuyas = 0,menu,monedas=0;
        cargar_cartas_disponibles(disponibles);
        do{
            menu = mostrar_opciones_menu();
            switch(menu)
            {
                case 1:
                    mostrartodascartasJuego(disponibles);
                    break;
                case 2:
                    monedas = monedas + encontrar_monedas(450,50);
                    num_cartas_tuyas= abrir_cofres(disponibles,tuyas,num_cartas_tuyas);
                    break;
            }
        }while(menu!=0);
        
        
        
        
        
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
        do{
        System.out.println("1.-Mostrar totes les cartes disponibles del joc");
        System.out.println("2.- Obrir Cofre");
        System.out.println("3.- Mostrar totes les teves cartes");
        System.out.println("4.-Buscar Carta\n" +
"5.-Consulta saldo monedes\n" +
"6.- Pujar nivell carta\n" +
"0. Sortir");
            System.out.print("Pon opcion: ");
            opcion = sc.nextInt();
        }while (opcion<0 || opcion > 11);
        
        return opcion;
        
    }

    private static void mostrartodascartasJuego(Carta[] disponibles) {
        for (int i = 0; i < disponibles.length; i++) {
            System.out.println("->" + disponibles[i].nombre + " elixir:" + disponibles[i].elixir);
        }
    }

    private static int abrir_cofres(Carta[] disponibles, Carta[] tuyas, int num_cartas_tuyas) {
        
        Carta añadir=new Carta();
        
        for (int j = 0; j < 2; j++) {
            añadir=cartaAleatoria(disponibles);
            boolean comprovador=false;
            for (int i = 0; i < num_cartas_tuyas; i++)        {
               if(tuyas[i].nombre.equals(añadir.nombre)){
                   System.out.println("tienes una carta parecida sumamos los puntos");
                   tuyas[i].puntos_carta=tuyas[i].puntos_carta+añadir.puntos_carta;
                   comprovador=true;
               }}
            if(comprovador==false){
            tuyas[num_cartas_tuyas]=añadir;                   
            System.out.println("hemos añadido la carta porque no la tenias");
           num_cartas_tuyas=num_cartas_tuyas+1;
            }            
        }
        
        
        //abrir_carta * 2;
        return num_cartas_tuyas;
    }

    private static int encontrar_monedas(int quantitat_numeros, int inici) {
        int monedas = (int) (Math.random()*quantitat_numeros) + inici;
        System.out.println("te salen " + monedas + " monedas");
        return monedas;
    }

    private static Carta cartaAleatoria(Carta [] disponibles) {
        
      int random=(int) (Math.random()*disponibles.length); 
      int puntos=(int) (Math.random()*19)+1;
      
      Carta Random=new Carta();
      Random.nombre=disponibles[random].nombre;
      Random.puntos_carta=puntos;
      Random.elixir=disponibles[random].elixir;

        System.out.println("la carta nueva es "+Random.nombre+"\ntiene "+puntos+" puntos");
      
      return Random;
        
    }
    
}
