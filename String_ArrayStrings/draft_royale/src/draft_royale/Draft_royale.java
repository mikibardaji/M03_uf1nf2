/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draft_royale;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Draft_royale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] todas_cartas = new String[20];
        String[] tu_mazo = new String[8];

        cargar_cartas(todas_cartas);
        
        for (int i = 0; i < tu_mazo.length; i++) {
            mostrar_cartasElegir(todas_cartas);
            int eleccio = escollirCarta(todas_cartas);
            System.out.println("Has elegit " + eleccio);
            tu_mazo[i] = llenar_tu_mazo_carta(todas_cartas, eleccio);
           
        }
        mostrar_mazo(tu_mazo);

    }

    private static void cargar_cartas(String[] todas_cartas) {
        todas_cartas[0] = "Ejército de esqueletos";
        todas_cartas[1] = "Descarga";
        todas_cartas[2] = "El Tronco";
        todas_cartas[3] = "Barril de duendes";
        todas_cartas[4] = "Valquiria";
        todas_cartas[5] = "Bebé dragón";
        todas_cartas[6] = "Bola de fuego";
        todas_cartas[7] = "Flechas";
        todas_cartas[8] = "Mago";
        todas_cartas[9] = "Megacaballero";
        todas_cartas[10] = "Mago eléctrico";
        todas_cartas[11] = "Bruja";
        todas_cartas[12] = "Príncipe";
        todas_cartas[13] = "Caballero";
        todas_cartas[14] = "Globo bombástico";
        todas_cartas[15] = "Princesa";
        todas_cartas[16] = "Murciélagos";
        todas_cartas[17] = "Dragón infernal";
        todas_cartas[18] = "Leñador";
        todas_cartas[19] = "Mosquetera⨪";
    }

    private static void mostrar_cartasElegir(String[] todas_cartas) {

        Random r = new Random();
        int carta = r.nextInt(todas_cartas.length);
        System.out.println("la primera carta es " + todas_cartas[carta] + " de la posicion " + carta);

        carta = r.nextInt(todas_cartas.length);

        System.out.println("la segunda carta es " + todas_cartas[carta] + " de la posicion " + carta);

    }

    private static int escollirCarta(String[] todas_cartas) {

        Scanner sc = new Scanner(System.in);

        int carta;

        do {
            System.out.print("escoge carta: ");
            carta = sc.nextInt();
        } while (carta > todas_cartas.length);

        return carta;

    }

    private static String llenar_tu_mazo_carta(String[] todas_cartas, int eleccio) {
        return todas_cartas[eleccio];
    }

    private static void mostrar_mazo(String[] tu_mazo) {
        for (int i = 0; i < tu_mazo.length; i++) {
            System.out.println(tu_mazo[i]);
        }
        
    }

}
