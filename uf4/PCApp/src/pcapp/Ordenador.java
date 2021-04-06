/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcapp;

import java.util.Calendar;

/**
 *
 * @author mati
 */
public class Ordenador {
    String pantalla;
    int RAM;
    String procesador;
    boolean encendido;
    String programa;

    public Ordenador() {
        pantalla = "Tubo";
        RAM = 2;
        procesador = "8086";
        encendido=false;
        //programa=null;
    }
    
    

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String Programa) {
        this.programa = Programa;
    }
    
    public void encender(){
        if(encendido==true)
        {
            System.out.println("Ya estoy encendido!!!!");
        }
        else
        {
            System.out.println("arrancando");
            encendido=true;
        }
    }
    
    public void apagar(){
        if(encendido==false)
        {
            System.out.println("Ya estoy apagado!!!!");
        }
        else
        {
            System.out.println("apagando...");
            encendido=false;
        }
    }
    
    public void reinicia() throws InterruptedException
    {
        if(encendido==true)
        {
        encendido = false;
        Thread.sleep(1000);
        System.out.println("reiniciando ordenador");
        encendido = true;
        }
        else
        {
            System.out.println("estoy apagado");
        }
    }
    
    public void arrancarPrograma(String aplicacion)
    {
         if(encendido==true)
        {
           System.out.println("arrancando programa " + aplicacion);
           this.programa = aplicacion;
        }
    }
    
    public void pararPrograma(String aplicacion)
    {
         if(encendido==true && aplicacion.equalsIgnoreCase(programa))
        {
           System.out.println("parando programa " + aplicacion);
           this.programa = "No hay programa";
        }
         else
         {
             System.out.println("el programa no esta encendido");
         }
             
    }
    
    public void darHora()
    {
        if(encendido==true )
        {
        Calendar calendario = Calendar.getInstance();
       int hora =calendario.get(Calendar.HOUR_OF_DAY);
       int minutos = calendario.get(Calendar.MINUTE);
       int segundos = calendario.get(Calendar.SECOND);
       System.out.println(hora + ":" + minutos + ":" + segundos);
        }
        else
        {
            System.out.println("estoy apagado");
        }
    }
}
