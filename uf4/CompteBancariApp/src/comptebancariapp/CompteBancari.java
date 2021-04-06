/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptebancariapp;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class CompteBancari {
    private int numero_cuenta;
    private String titular;
    private double saldo;
    private double tipo_interes;

    public CompteBancari(int numero_cuenta, String titular, double saldo, double tipo_interes) {
        this.numero_cuenta = numero_cuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipo_interes = tipo_interes;
    }

    public CompteBancari(int numero_cuenta, String titular) {
        this.numero_cuenta = numero_cuenta;
        this.titular = titular;
        this.saldo =10;
        this.tipo_interes = 0.1;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTipo_interes() {
        return tipo_interes;
    }

    public void setTitular(String titular) {
      //  Scanner teclado = new Scanner(System.in);
      //  System.out.println("pon el titular ");
      //  this.titular = teclado.nextLine();
        this.titular = titular;
    }

    public void setTipo_interes(double tipo_interes) {
        if(tipo_interes>=0)
        {
            this.tipo_interes = tipo_interes;
        }
        
    }
    
    public void ingresoDinero(double dinero)
    {
        if (dinero>0)
        {
            this.saldo += dinero;
        }
    }
    
    public void sacarDinero(double dinero)
    {
        if (this.saldo>= dinero)
        {
            this.saldo -= dinero; //saldo = saldo - dinero;
        }
        else
        {
            System.out.println("no tienes suficnete");
        }
        
    }
    
    public void transferencia(CompteBancari otra, double dinero)
    {
         if (this.saldo>= dinero)
         {
             
             this.sacarDinero(dinero);
             otra.ingresoDinero(dinero);
             System.out.println("transferencia hecha");
         }
         else
         {
             System.out.println("no tienes dinero");
         }
    }

    @Override
    public String toString() {
        return "CompteBancari{" + "titular=" + titular + ", saldo=" + saldo + '}';
    }
    
    
    
}
