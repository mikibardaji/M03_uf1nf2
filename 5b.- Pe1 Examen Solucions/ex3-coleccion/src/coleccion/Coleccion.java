/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleccion;

import java.util.Scanner;

/**
 *
 * @author 43720186S
 */
public class Coleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Album mi_album = new Album();
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre album");
        mi_album.nombre_coleccion = sc.nextLine();
        System.out.println("nombre editorial");
        mi_album.editorial = sc.nextLine();
        //inicializar
        mi_album.coleccion = new Cromos[50];
        inicializar(mi_album.coleccion);
        System.out.println("fin");
        int opcion;
        do
        {
            System.out.println("1. añadir cromo");
            System.out.println("2. borrar cromo");
            System.out.println("3. listar cromo");
             System.out.println("4. repes cromo");
              System.out.println("5. equipos");
            System.out.println("0. listar cromo");
            opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:
                    añadir_cromo(mi_album);
                break;
                case 2:
                    borrar_cromo(mi_album);
                break;
                case 3:
                    listar_cromo(mi_album);
                break;
                case 4:
                    listar_repes(mi_album);
                break;
                
                case 5:
                    listar_equipos(mi_album);
                break;
                default:
                    break;
            }
        }while (opcion!=0);
        
        
    }

    private static void inicializar(Cromos[] coleccion) {
        for (int i = 0; i < coleccion.length; i++) {
            coleccion[i] = new Cromos();
        }
    }

    private static void añadir_cromo(Album mi_album) {
        
        Cromos nuevo = cromo_ponga();
        
        if (mi_album.coleccion[nuevo.numero-1].numero==0) //no estaba el cromo
        {
            mi_album.coleccion[nuevo.numero-1].numero = nuevo.numero;
            mi_album.coleccion[nuevo.numero-1].nombre_equipo = nuevo.nombre_equipo;
                    mi_album.coleccion[nuevo.numero-1].nombre_jugador = nuevo.nombre_jugador;
                    mi_album.coleccion[nuevo.numero-1].repetidas = 0;
                    //mi_album.coleccion[nuevo.numero-1] = nuevo;
        }
        else
        {
            mi_album.coleccion[nuevo.numero-1].repetidas++;
        }
        
    }
    
    
        private static Cromos cromo_ponga() {
            Cromos añadir = new Cromos();
            Scanner sc = new Scanner(System.in);
                    System.out.println("numero de cromo");
        añadir.numero = sc.nextInt();
        sc.nextLine(); //salto el enter y limpio el buffer
        System.out.println("nombre joguador");
        añadir.nombre_jugador = sc.nextLine();
        System.out.println("nombre nombre equipo");
        añadir.nombre_equipo = sc.nextLine();
        añadir.repetidas = 1;
            
            
        

        return añadir;

    }

    private static void borrar_cromo(Album mi_album) {
         Scanner sc = new Scanner(System.in);
         System.out.println("numero de cromo");
        int numero = sc.nextInt();
        
         if (mi_album.coleccion[numero-1].numero==0) //no estaba el cromo
         {
             System.out.println("no esta el cromo");
         }
         else
         {
             if(mi_album.coleccion[numero-1].repetidas>0)
             {
                 mi_album.coleccion[numero-1].repetidas--;
             }
             else //solo tengo uno y lo quito
             {
                  mi_album.coleccion[numero-1].numero = 0;
                  mi_album.coleccion[numero-1].repetidas = 0;
                  mi_album.coleccion[numero-1].nombre_jugador = "";
                   mi_album.coleccion[numero-1].nombre_equipo = "";
                   //mi_album.coleccion[numero-1] = new Cromos();
             }
         }
    }

    private static void listar_cromo(Album mi_album) {
        for (int i = 0; i < mi_album.coleccion.length; i++) {
            if(mi_album.coleccion[i].numero!=0)
            {
                System.out.println(mi_album.coleccion[i].nombre_jugador + " " + mi_album.coleccion[i].numero);
            }
            
        }
    }

    
    private static void listar_repes(Album mi_album) {
        for (int i = 0; i < mi_album.coleccion.length; i++) {
            if(mi_album.coleccion[i].repetidas>0)
            {
                System.out.println(mi_album.coleccion[i].nombre_jugador + " " + mi_album.coleccion[i].repetidas);
            }
            
        }
        System.out.println("fin listado");
    }
    
    
    private static void listar_equipos(Album mi_album) {
        String aux_equipo="";
        for (int i = 0; i < mi_album.coleccion.length; i++) {
            if(mi_album.coleccion[i].numero!=0 )
            {
                if(!mi_album.coleccion[i].nombre_equipo.equals(aux_equipo))
                {
                    System.out.println(mi_album.coleccion[i].nombre_equipo);
                aux_equipo = mi_album.coleccion[i].nombre_equipo; 
                }
               
            }
        }
    }
    
}
