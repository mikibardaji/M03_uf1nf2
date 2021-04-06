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
public class CompteBancariApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompteBancari micuenta = new CompteBancari(1, "Miquel angel", 100000, 0.1);
        CompteBancari cuenta_transferencia = new CompteBancari(2, "Ildar");
        CompteBancari[] cuentas_banco = new CompteBancari[2];
        
        
        
        System.out.println(micuenta.toString());
        System.out.println(cuenta_transferencia.toString());
        System.out.println("Cuanto dinero quieres pasar");
        
        Scanner teclado = new Scanner(System.in);
        double money = teclado.nextDouble();
        micuenta.transferencia(cuenta_transferencia, money);
        
        System.out.println(micuenta.toString());
        System.out.println(cuenta_transferencia.toString());
        
    }
    
}
