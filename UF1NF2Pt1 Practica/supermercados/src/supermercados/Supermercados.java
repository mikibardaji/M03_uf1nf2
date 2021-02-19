/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercados;

import java.util.Scanner;

/**
 *
 * @author tarda
 */
public class Supermercados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] supermercados = new int[4][4];
        int opcio;
        inicializar_precio(supermercados);
        do{
         opcio = menu();
         switch(opcio)
         {
             case 1:
                 listar_supermercado(supermercados);
                 break;
             case 2:
                 media_precios_supermercado(supermercados);
                 break;
             case 3:
                 media_precios_producto(supermercados);
                 break;
             case 4:
                 diferencia_productos(supermercados);
             case 0:
                 System.out.println("adios");
                 break;
                 
         }
        }while(opcio!=0);
    }
 
    
    public static int menu()
    {
         int opcion;
        do{
        System.out.println("1-Listar precios");
        System.out.println("2-Media precio supermercado");
        System.out.println("3-Media precio producto");
        System.out.println("4-Diferencia de precio");
        System.out.println("0-Salir");
        System.out.print("Opción: ");
        Scanner sc;
        sc = new Scanner(System.in);
        opcion= sc.nextInt();
        }while(opcion<0 || opcion > 4);
        return opcion;
    }

    /* pone precios a todos los productos y supermercados*/
    
    private static void inicializar_precio(int[][] supermercados) {
        for (int i = 0; i < supermercados.length; i++) {
            for (int j = 0; j < supermercados[0].length; j++) {
                supermercados[i][j] = (int) (Math.random()*100) + 1;
            }
        }
    }
    
    
    
    /* pone precios a todos los productos y supermercados*/
    
    private static void listar_supermercado(int[][] supermercados) {
        System.out.println("                Producto1 Producto2 Producto3 Producto4");
        for (int i = 0; i < supermercados.length; i++) {
            System.out.print("Supermercado " + (i+1) + "- ");
            for (int j = 0; j < supermercados[0].length; j++) {
                System.out.printf("%9d ", supermercados[i][j]);
            }
            System.out.println("");
        }
    }

    private static void media_precios_supermercado(int[][] supermercados) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("De que supermercado quieres saber la media de precios: ");
        int fila= sc.nextInt();
        fila--;
        int suma_acum=0;
        for (int columnas = 0; columnas < supermercados[fila].length; columnas++) {
            suma_acum = suma_acum + supermercados[fila][columnas];
        }
        double media = (double) suma_acum/supermercados[fila].length;
        System.out.println("la media del supermercado es :" + media);
  
    }

    private static void media_precios_producto(int[][] supermercados) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("De que producto quieres saber la media de precios: ");
        int columna= sc.nextInt();
        columna--;
         int suma_acum=0;
        for (int filas = 0; filas < supermercados.length; filas++) {
            suma_acum = suma_acum + supermercados[filas][columna];
            System.out.println(supermercados[filas][columna]);
        }
        double media = (double) suma_acum/supermercados.length;
        System.out.println("la media del producto es :" + media);
    }

    private static void diferencia_productos(int[][] supermercados) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("De que producto quieres saber la diferencia de precios: ");
        int producto= sc.nextInt();
        producto--;
        int max, min, diferencia;
        max = supermercados[0][producto];
        min = supermercados[0][producto];
        for (int superm = 0; superm < supermercados.length; superm++) {
            if(max<supermercados[superm][producto])
            {
                max = supermercados[superm][producto];
            }
            if(min>supermercados[superm][producto])
            {
                min = supermercados[superm][producto];
            } 
        }
        diferencia = max-min;
        System.out.println("la diferencia de precio es " + diferencia);
    }
}
