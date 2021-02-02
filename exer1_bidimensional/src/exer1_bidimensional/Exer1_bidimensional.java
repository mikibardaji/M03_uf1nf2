/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer1_bidimensional;

/**
 *
 * @author mati
 */
public class Exer1_bidimensional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int matriz[][] = new int[5][5];
    int variable1=1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = variable1;
                variable1++;
                
            }
            
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                //System.out.print(matriz[i][j]+ " "); 
                System.out.printf("%4d ",matriz[i][j]);
                //
            }
            System.out.println(" ");
        }
    
    }
    
}
