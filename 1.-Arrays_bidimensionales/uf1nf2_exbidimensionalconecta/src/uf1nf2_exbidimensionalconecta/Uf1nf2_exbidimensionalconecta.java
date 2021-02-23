/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2_exbidimensionalconecta;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Uf1nf2_exbidimensionalconecta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int filas=7;
        int columnas=7;
        Scanner sc = new Scanner(System.in);
        int[][] tauler = new int[filas][columnas];
        String[] usuaris = new String[2]; //per guardar els noms dels 2 usuaris
        //Demanar noms cada usuari
        for (int i = 0; i < usuaris.length; i++) {
           usuaris[i]= pedir_nombre();    
        }
       
        
        int turno=triar_inici();
        //System.out.println("turno" + turno);
        
        
        //-Triar_inici random escoge entre 1 y 2
        
        mostrar_tauler(tauler);
        do{
            if(turno==1)
            {
                turno=0;
            }
            else
            {
                turno=1;
            }
            //ir cambiando turno
            //turno = (turno+1)%2;
            System.out.println("turno de " + usuaris[turno]);
            System.out.println("En que columnas quieres colocar ficha");
            int columna = sc.nextInt();

            tirada(tauler,columna,turno);
            mostrar_tauler(tauler);
   
        }while(!tauler_ple(tauler) && !has_ganado(tauler,turno));
        
        if(tauler_ple(tauler)==false)
        {
            System.out.println("ganador " + usuaris[turno]);
        }
        else
        {
            System.out.println("has llenado el tablero empate");
        }
    }

    private static void mostrar_tauler(int[][] tauler) {
        for (int fila = 0; fila < tauler.length; fila++) {
            for (int columna = 0; columna < tauler[fila].length; columna++) {
               System.out.print(Mostrar_casella_usuari(fila,columna,tauler)+"|");
                
            }
            System.out.println("");
           
        }
    }
    
    //Mostrar_casella_usuari tiene que devolver un char si la posicion es 0 devuelve - , si es un 1 devuelve una X y si es 2 devuelve un 0

    private static char Mostrar_casella_usuari(int fila, int columna, int[][] tauler) {
        if(tauler[fila][columna]==0)
            return '_';
        else if (tauler[fila][columna]==1)
            return 'X';
        else
            return 'O';
    }

    private static String pedir_nombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("como te llamas?");
        String nombre = sc.nextLine();
        return nombre;
    }

    private static int triar_inici() {
        int num = (int) (Math.random()*2) ;
        return num;
    }

    private static void tirada(int[][] tauler, int columna, int turno) {
        //buscar la primera posicion vacia o sea que es 0
        //en la columna elegida
        //cuando la encuentre pone su fica (1 o 2)
        //turno 0 coloca ficha con un 1
        //turno 1 coloca ficha con un 2
        int i;
        for ( i = tauler.length-1; i >= 0; i--) {
            if(tauler[i][columna]==0)
            {//es que esta vacia y puedo colocar mi ficha
                tauler[i][columna]=(turno+1);
                break; //no recorrer mas el bucle por que 
                //ya he colocado la ficha
            }
            
        }
        //columna llena o has colocado
        if(i<0)
        {
            System.out.println("columna llena");
        }
        //si no entro en el if es que he colocado ficha
        
        
    }

    private static boolean tauler_ple(int[][] tauler) {
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[0].length; j++) {
                if(tauler[i][j]==0)
                {
                    return false; //hay una vacia
                }
            }
        }
        return true;
    }

    private static boolean has_ganado(int[][] tauler, int turno) {
        //a partir turno tengo que mirar si en horizontal hay 4 en linea
        //turno es 0 o 1
        //jugador 0 las fichas son el 1
        //jugador 1 las fichas son el 2
        int ficha = turno+1; //con esto convierto a la ficha
        //variable ficha va a tener el valor del jugador que toque
        int contar=0;
        
        //horizontal
        for (int filas = 0; filas < tauler.length; filas++) {
            for (int columnas = 0; columnas < tauler[0].length; columnas++) {
                if(tauler[filas][columnas]==ficha)
                {
                    contar++;
                    if(contar==4)
                    {
                        return true; //he ganado
                    }
                }
                else
                {
                    contar=0; //inicializo por que no estan seguidas
                }
                
            }
            //he terminado la fila en horizonta
            contar=0;//terminado linea
        }
        
        for (int columnas = 0; columnas < tauler.length; columnas++) {
            for (int filas = 0; filas < tauler[0].length; filas++) {
                if(tauler[filas][columnas]==ficha)
                {
                    contar++;
                    if(contar==4)
                    {
                        return true; //he ganado
                    }
                }
                else
                {
                    contar=0; //inicializo por que no estan seguidas
                }
                
            }
            //he terminado la fila en horizonta
            contar=0;//terminado linea
        }
        
        return false; //no he ganado
        
    }
}
