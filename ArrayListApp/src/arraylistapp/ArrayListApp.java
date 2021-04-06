/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class ArrayListApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animales uno;
        ArrayList<Animales> arca_noe_singles = new ArrayList();
        Scanner teclado = new Scanner(System.in);
        String si_no;
        do{
        System.out.println("Pon el nombre animal");
        String nombre = teclado.nextLine();
        System.out.println("Pon la especie animal");
        String especie = teclado.nextLine();
        uno = new Animales();
        uno.setEspecie(especie);
        uno.setNombre(nombre);
        
        arca_noe_singles.add(uno);
        System.out.println("Quieres añadir alguna animal mas");
        si_no = teclado.nextLine();
        }while(si_no.equalsIgnoreCase("SI"));
        
        
        for (int i = 0; i < arca_noe_singles.size(); i++) {
            System.out.println(arca_noe_singles.get(i).toString());
        }
        
        
        Animales encontrar = new Animales();
        System.out.println("Pon la especie animal a encontrar");
        String especie_encontrar = teclado.nextLine();
        encontrar.setEspecie(especie_encontrar);
        if (arca_noe_singles.contains(encontrar))
        {
            System.out.println("si esta esta especie");
        }
        else
        {
            System.out.println("no esta esta especie");
        }
        
        int posicion = arca_noe_singles.indexOf(encontrar);
        System.out.println("La posicion donde esta es " + posicion);
    
    }
    
}
