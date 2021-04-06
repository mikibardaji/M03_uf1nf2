/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleapp;

/**
 *
 * @author mati
 */
public class RectangleApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle rectangulo = new Rectangle(3, 5);
        Rectangle rectangulo2 = new Rectangle(4,5);
        
        System.out.println("area del primero " + rectangulo.getArea());
        System.out.println("perimetro del primero " + rectangulo.getPerimetro());
        
        
        System.out.println("area del segundo " + rectangulo2.getArea());
        System.out.println("perimetro del segundo " + rectangulo2.getPerimetro());
        
        if(rectangulo.equals(rectangulo2))
        {
            System.out.println("igual");
        }
        else
        {
            System.out.println("diferentes ");
        }
        
        System.out.println(rectangulo.toString());
        System.out.println(rectangulo2.toString());
    }
    
}
