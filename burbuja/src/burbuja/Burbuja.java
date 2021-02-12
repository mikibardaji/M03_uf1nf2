/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burbuja;

/**
 *
 * @author mati
 */
public class Burbuja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros = {2,8,5,20,1};
        
        mostrar_array(numeros);
        metodo_burbuja(numeros);
        mostrar_array(numeros);
    }

    private static void mostrar_array(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] +" ");
        }
        System.out.println("");
    }

    private static void metodo_burbuja(int[] numeros) {
        //int i,j;
       int ele_ordenados, j;
       int aux;
       
        for (ele_ordenados = 0; ele_ordenados < numeros.length; ele_ordenados++) {
            for(j=0;j<(numeros.length-ele_ordenados-1);j++)
            {//resto ele_ordenados, porque cuando
                //los finales ya estan ordenados 
                //no quiero que llegue a esas posiciones, se podria hacer sin la resta también
             System.out.println("comparo posicion" + j + "con la " + (j+1));
                if(numeros[j]>numeros[j+1])
                {//intercambio valores
                   aux=numeros[j];
                   numeros[j]=numeros[j+1];
                   numeros[j+1]= aux;
                    System.out.println("cambio posicion");
                    mostrar_array(numeros);
                }
                
            }
            System.out.println("Elementos ordenados al terminar el for interno" + ele_ordenados);
            
        }
       
    }
    
}
