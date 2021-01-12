/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copia_array;

/**
 *
 * @author usuari
 */
public class Copia_array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* int origen[] = new int[5];
        origen[0]=3;
        origen[1]=4;*/
        int origen[] = {3,4,5,6,7};
        int desti[] = new int[5];
        //NO SE COPIA UN ARRAY ASI
        desti=origen; //no es copia el origen apunta a la memoria desti
        System.out.println("origen=desti");
        for (int i = 0; i < origen.length; i++) {
            System.out.println("desti: " + desti[i] + " origen" + origen[i]);
        }
        cambio_valor(desti);
        System.out.println("desti[0]=10");
        for (int i = 0; i < origen.length; i++) {
            System.out.println("desti: " + desti[i] + " origen" + origen[i]);
        }
        desti=new int[5]; /*inicializo array nuevo*/
        System.out.println("system.arraycopy");
        origen[0]=3;
        //System.arraycopy(origen, 0, desti, 0, origen.length);
        for (int i = 0; i < origen.length; i++) {
            desti[i]=origen[i];
        }
        for (int i = 0; i < origen.length; i++) {
            System.out.println("desti: " + desti[i] + " origen" + origen[i]);
        }
        System.out.println("desti[0]=10");
        cambio_valor(desti);
        for (int i = 0; i < origen.length; i++) {
            System.out.println("desti: " + desti[i] + " origen" + origen[i]);
        }
    }

    private static void cambio_valor(int[] desti) {
        desti[0]=10;
    }
    
}
