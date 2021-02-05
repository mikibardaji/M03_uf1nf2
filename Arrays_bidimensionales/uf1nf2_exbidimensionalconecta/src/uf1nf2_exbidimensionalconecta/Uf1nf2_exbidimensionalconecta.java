/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf1nf2_exbidimensionalconecta;

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
        int columnas=8;
        int[][] tauler = new int[7][8];
        //Demanar noms cada usuari
        //-Triar_inici random escoge entre 1 y 2
        tauler[1][2]=1;
        tauler[2][2]=2;
        mostrar_tauler(tauler);
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
}
