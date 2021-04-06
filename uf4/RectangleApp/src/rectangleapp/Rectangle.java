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
public class Rectangle {
    private double base;
    private double altura;

    public Rectangle() {
        this.base = 2;
        this.altura = 3;
    }

    public Rectangle(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        if (base>0)
        {
        this.base = base;
        }
        else
        {
            System.out.println("no puede tener base negativa");
        }
    }

    public void setAltura(double altura) {
        if(altura>0)
        {
            this.altura = altura;
        }
        else
        {
            System.out.println("altura no puede ser negativa");
        }
              
    }
    
    public double getPerimetro()
    {
        return (base*2 + altura*2);
    }
    
    public double getArea()
    {
        return (base*altura);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangle other = (Rectangle) obj;
        if (this.base == other.base
                && this.altura ==other.altura)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    
    @Override
    public String toString() {
        return "Rectangulo->" + "su base es" + base + "y su  altura es " + altura ;
    }


    
    
    
}
