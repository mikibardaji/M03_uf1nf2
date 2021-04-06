/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistapp;

import java.util.Objects;

/**
 *
 * @author mati
 */
public class Animales {
    public String nombre;
    public String especie;
    public int edat;

    public Animales(String nombre, String especie, int edat) {
        this.nombre = nombre;
        this.especie = especie;
        this.edat = edat;
    }

    public Animales(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
        this.edat = 1;
    }

    public Animales() {
        edat=1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        if (edat>0)
        {
        this.edat = edat;
        }
        
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
        final Animales other = (Animales) obj;
        if (this.especie.equalsIgnoreCase(other.getEspecie()))
        {
        return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return   "nombre=" + nombre + ", especie=" + especie + ", edat=" + edat ;
    }
    
    
    
}
