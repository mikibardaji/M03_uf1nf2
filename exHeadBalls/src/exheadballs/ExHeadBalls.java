/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exheadballs;

import java.util.Scanner;

/**
 * 
 * 
El joc es senzill 4 targetes, una aleatoria te una tarjeta vermella, les altres premis que van variant. Jugues fins que et plantes o fins que et surt una tarjeta vermella.

Si no voleu instal·lar el joc , podeu mirar el video següent link.

Simularem que a totes et toca diners random de 1 al 20, menys a 1 que tindra que valer -1, que si la elegeixes, et retorna -1 que tu traduiras (al main) com targeta vermella.

Plenar el array amb una funció apart.

Retornar el valor a partir de la elecció usuario, funcio apart.
 * @author mati
 */
public class ExHeadBalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int valor[] = new int[4];
       int monedas = 0,ganancia=0;
       String respuesta="";
       Scanner sc = new Scanner(System.in);
       do{
        inicializacion_cartes(valor);
        poner_tarja_roja(valor);
        int eleccion = pedir_posicion();
        monedas = premio(valor, eleccion);
        if (monedas!=-1)/*si no has perdido*/
        { 
            ganancia = ganancia + monedas;
            mostrar_ganancia(ganancia,monedas);   
            System.out.println("quieres plantarte(SI/NO)");
            respuesta=sc.next();
        }
       
       }while (monedas!=-1 && !respuesta.equalsIgnoreCase("si"));
       
       
      System.out.println("Has ganado: " + ganancia);
       

    }
    
    /*
    pongo monedas a todas las cartas
    */
    public static void inicializacion_cartes( int valor[]){
        for(int i = 0; i < valor.length; i++){
            valor[i]= (int)(Math.random()*100) + 1;
        }
    }
    
    /*
    elijo una posición para la tarjeta roja (-1)
    */
    public static void poner_tarja_roja(int valor[]){
    int pos = (int)(Math.random()*4);
    valor[pos] = -1;    
    }

    public static int pedir_posicion(){
        Scanner sc = new Scanner(System.in);
        int eleccion = 0;
        do{
        System.out.println("Elige una carta del 1 al 4");
        eleccion = sc.nextInt();
        }while(eleccion < 1 || eleccion > 4);
        return (eleccion - 1);        
    }
    
    public static int premio(int valor[],int eleccion){
        return valor[eleccion];
    }

    private static void mostrar_ganancia(int ganancia, int monedas) {
        System.out.println("has ganado " + monedas + " acumulado " + ganancia); 
    }
}
