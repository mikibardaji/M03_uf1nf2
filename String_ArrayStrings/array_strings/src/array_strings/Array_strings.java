/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_strings;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Array_strings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] noms = new String[5];
        //String[] noms1 = {"IIldar","Pau"};
        String [] acciones= new String[5];
        //array acciones
        plenar_acciones(acciones);
        //llenar acciones
        plenar_noms(noms);
        //passar_llista(noms);
        //String nom_buscat = demanar_nom();
        //asistencia(noms,nom_buscat);
        
        predecir_futuro(noms, acciones);
    }

    private static void plenar_noms(String[] noms)     {
        noms[0]="Ildar";
        noms[1]="Pau";
        noms[2]="Adrian";
        noms[3]="Sohaib";
        noms[4]="Mario";
    }

    private static void passar_llista(String[] noms) {
        for(int i=0;i<noms.length;i++)
        {
            System.out.println(noms[i]);
        }
    }

    private static String demanar_nom() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fica un nom i et dire si esta a classe");
        String nom = sc.nextLine();
        return nom;
    }

    private static void asistencia(String[] noms, String nom_buscat) {
        boolean esta=false;
        for (int i = 0; i < noms.length; i++) {
            if(noms[i].equalsIgnoreCase(nom_buscat))
                    {
                        System.out.println("Ha vingut a classe");
                        esta=true;
                    }
            
        }
        if(esta==false)
        {
            System.out.println("no ha venido a clase cateado!");
        }
    }


    private static void plenar_acciones(String[] acciones) {
        acciones[0]="estudia";
        acciones[1]="canta";
        acciones[2]="juga";
        acciones[3]="programa";
        acciones[4]="baila en la ducha";
    }

    private static void predecir_futuro(String[] noms, String[] acciones) {
        Random r = new Random();
        for (int i = 0; i < acciones.length; i++) {
            System.out.print(noms[i]+ " ");
            int posicion= r.nextInt(acciones.length);          
            System.out.println(acciones[posicion]);
        }
    }
    
}
