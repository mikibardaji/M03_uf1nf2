/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca;

import java.util.Random;

/**
 *
 * @author tarda
 */
public class Oca {

   
    public static void main(String[] args) {
       int[] tablero = new int[30]; //joc de la oca
       int dau;
       int[] casillas_jugadores = new int[2]; //{0,0}
        int tipo_casilla, turno=1;
       IniciarTablero(tablero);
       
       colocar_ocas(tablero);
       Colocar_muerte(tablero);
       mostrar_tablero(tablero);
       do{
           //canvia el turno de jugador 
           //turno++;
           //turno = turno%2;
           if(turno==0)
           {
               turno=1;
           }
           else
           {
               turno=0;
           }    
               
       dau = (int) (Math.random()*6) + 1;
        System.out.println("tirada dado " + dau + " jugador " + (turno+1));
        //mover casilla
        casillas_jugadores[turno] = casillas_jugadores[turno] + dau;
        if(casillas_jugadores[turno]>tablero.length-1)
        {//si se va fuera
            casillas_jugadores[turno]=tablero.length-1;
        }
        else
        {//si no he llegado al final
        
            System.out.println("casilla " + casillas_jugadores[turno]);

            tipo_casilla = que_es_casilla(tablero, casillas_jugadores[turno]);
            if (tipo_casilla==2)
            {
                casillas_jugadores[turno] = 0; //vuelvo a empezar
            }
            else if (tipo_casilla==1)
            {
                casillas_jugadores[turno]=mover_de_oca_a_oca(tablero, casillas_jugadores[turno]);
            }
        }
       }while(casillas_jugadores[turno]<(tablero.length-1));
       
       if(casillas_jugadores[turno]>=(tablero.length-1) && turno==0)
       {
           System.out.println("ha ganado jugador " + (turno+1));
       }
       if(casillas_jugadores[turno]>=(tablero.length-1) && turno==1)
       {
           System.out.println("ha ganado jugador " + (turno+1));
       }
       
       //   System.out.println("ha ganado jugador " + (turno+1));
    }
    
    //Función IniciarTablero(0,25 pts): inicializaremos todas las casillas a 0.

    private static void IniciarTablero(int[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            tablero[i]=0;
            
        }
        
        //Arrays.fill(tablero, 0);
        
    }

    //muestra tablero de juego
    private static void mostrar_tablero(int[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            System.out.printf(" %2d",i);
        }
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            System.out.printf("-%2d" , tablero[i]);
        }
        System.out.println("");
    }
    
    //Colocar_Ocas(0,75 pts): Se distribuirán por el circuito aleatoriamente 6 ocas (casillas 1) , no puede
//colocarse una oca en una posición donde ya se encuentra la oca ni en la casilla 30.
    private static void colocar_ocas(int[] tablero)
    {
        Random rd = new Random(System.currentTimeMillis());
        int oca = 0;
        int casilla;
        do{
            casilla = rd.nextInt(29);
            if(tablero[casilla]==0) //no esta ocupada
            {
             tablero[casilla]=1;
             oca++;
            }
            
        }while(oca<6);
        
    }
    
    //Colocar muerte(0,75 pts): Se col·loca una muerte ( casilla 2
    //la muerte a paritr de la quince 
    private static void Colocar_muerte(int[] tablero)
    {
        Random rd = new Random(System.currentTimeMillis());
    
        int casilla;
        do{
            casilla = rd.nextInt(14)+15; //0,1,2,3,4,5...14 --> 15,16,17
        }while(tablero[casilla]==1);
          
        tablero[casilla]=2;
          
    }
    
    
    //unción: que_es_esa_casilla(0,5 pts), le pasas la casilla 
    //y tiene que devolver de que tipo es la casilla. Aparte
//de si es oca o muerte debe mostrar por pantalla una frase informativa._c

    private static int que_es_casilla(int[] tablero, int casilla) {
        int tipo = tablero[casilla];
        if(tipo==1)
        {
            System.out.println("de oca en oca");
        }
        else if (tipo==2)
        {
            System.out.println("Muerte!!! vuelves al princpio");
        }
        else
        {
            System.out.println("casilla normal");
        }
        
        
        
        return tipo;
        
    }
    
    /**
     * mover_de_oca_a_oca(1,25 pt), se le pasara la casilla en la que esta el jugador, 
     * si es realmente una oca, buscarà la siguiente posición donde se encuentra la oca 
     * y devolvera la nueva casilla, si llega al final, sin encontrar oca, 
     * devolvera la casilla 30.
     */
    
    private static int mover_de_oca_a_oca(int[] tablero, int casilla)
    {
        if (tablero[casilla]!=1) //verifico que es una oca
        {
            return casilla;
        }
        for (int posicion = casilla+1; posicion < tablero.length; posicion++) {
            if(tablero[posicion]==1) //encuentro oca
            {
                return posicion;
            }
        }
        //si no he encontrado una oca casilla final
        return tablero.length-1;
    }
}
