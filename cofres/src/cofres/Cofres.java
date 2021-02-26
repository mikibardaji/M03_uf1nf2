/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofres;

/**
 *
 * @author mati
 */
public class Cofres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carta[] disponibles = new Carta[15];//todas las del juego
        Carta[] tuyas = new Carta[disponibles.length];
        
        cargar_cartas_disponibles(disponibles);
        
        
        
        
        
        
    }

    private static void cargar_cartas_disponibles(Carta[] disponibles) {
        disponibles[0] = new Carta();
        disponibles[0].nombre = "Pekka";
        disponibles[0].elixir = 7;
        disponibles[1] = new Carta();
        disponibles[1].nombre = "Mini Pekka";
        disponibles[1].elixir = 4;
    }
    
}
