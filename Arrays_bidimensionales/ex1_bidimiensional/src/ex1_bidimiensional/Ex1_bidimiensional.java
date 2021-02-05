/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_bidimiensional;

/**
 *
 * @author mati
 */
public class Ex1_bidimiensional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] multiplicar = new int[5][5];
        int v1=1;
        
        for (int i = 0; i < multiplicar.length; i++) {
            for (int j = 0; j < multiplicar[0].length; j++) {
                multiplicar[i][j] = v1;
                v1++; //v1 = v1 +3;
            }
            
        }
        
        for (int i = 0; i < multiplicar.length; i++) {
            for (int j = 0; j < multiplicar[0].length; j++) {
               // System.out.print(multiplicar[i][j] + " ");
                System.out.printf("%4d", multiplicar[i][j]);
                
            }
            System.out.println(""); /*salto linea*/
        }
    }
    
}
