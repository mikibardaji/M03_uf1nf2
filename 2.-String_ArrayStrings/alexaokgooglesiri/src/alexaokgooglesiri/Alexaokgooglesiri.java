/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexaokgooglesiri;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Alexaokgooglesiri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = pide_nombre();
        boolean no_terminar = false;
        do {
            String instruccion = pide_instruccion();
            //comprobar alexa esta al principio

            if (instruccion.startsWith("ALEXA")) {

                String orden = instruccion.substring(6);
                
                /* System.out.println("." + orden + ".");
            orden= orden.trim();//eliminar espacios delante y atras elimino alexa instruccion elimino espacio delante */
                System.out.println("." + orden + ".");
                no_terminar = instrucciones(orden, nombre);
            } else {
                System.out.println("no has dicho alexa");
            }
        } while (no_terminar == true);
        //

    }

    private static String pide_nombre() {
        Scanner sc = new Scanner(System.in);
        String paraula;
        do {
            System.out.println("Com et dius?");
            paraula = sc.nextLine();//elimina ja els espais
        } while (paraula.isEmpty());
        return paraula;
    }

    private static String pide_instruccion() {
        Scanner sc = new Scanner(System.in);
        String instruccion;
        do {
            System.out.println("Esperando instruccion");
            instruccion = sc.nextLine();//elimina ja els espais
        } while (instruccion.isEmpty());
        return instruccion.toUpperCase();
    }

    private static boolean es_alexa(String instruccion) {
        String alexa = instruccion.substring(0, 4);
        //instruccion.startsWith("ALEXA")
        //if(alexa.indexOf("ALEXA")==0)
        if (alexa.equals("ALEXA")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean instrucciones(String orden, String nombre) {
        //escoger la instruccio
        if (orden.contains("BUENOS DIAS")) {
            System.out.println("Buenos dias " + nombre);
            return true;
        }
        if (orden.contains("BUENAS NOCHES")) {
            System.out.println("BuenAS NOCHES " + nombre);
            return false;
        }
        if (orden.contains("CANTA UNA CANCION")) {
            cantar();
        }
        if (orden.contains("HABLA CON LA")) {
            habla(orden);
        }
        if (orden.contains("TABLAS DE MULTIPLICAR")){
            multiplicar();
        }
        if (orden.contains("DIME MI EDAD")){
            calcular_edad();
        }

        return true;
    }

    private static void cantar() {
        for (int i = 2; i <= 10; i++) {
            System.out.println(i + " elefantes se balanceaban...");
        }
    }

    private static void habla(String orden) {
        char letra = orden.charAt(13);
        System.out.println(letra);
        String fraseFound = orden.substring(20);
        System.out.println(fraseFound);
        
        fraseFound = fraseFound.replace('A', letra);
        fraseFound = fraseFound.replace('E', letra);
        fraseFound = fraseFound.replace('I', letra);
        fraseFound = fraseFound.replace('O', letra);
        fraseFound = fraseFound.replace('U', letra);
        System.out.println("frase cambiada");
        System.out.println(fraseFound);
/*
        for (int i = 0; i < fraseFound.length(); i++) {
            if ('A' == fraseFound.charAt(i)) {
                fraseFound.charAt(i) = letra;
            }
        }
*/
    }

    private static void multiplicar() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int v1,v2;
        
        v1 = r.nextInt(10)+1;
        v2 = r.nextInt(10)+1;
        
        long inicio = System.currentTimeMillis(); /*temps en ms*/
        System.out.println("Cuanto es "+v1+" x "+v2);
        int respuesta = sc.nextInt();
        long fin = System.currentTimeMillis(); /*temps en ms*/
        
        long tiempo = (fin-inicio)/1000;
        
        if (respuesta==(v1*v2) && tiempo<5)
        {
            System.out.println("Piruleta para ti");
        }
        else
        {
            System.out.println("Piensa mas");
        }
    }

    private static void calcular_edad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que año nacieste?");
        int birth = sc.nextInt();
        
        Calendar calc = Calendar.getInstance();
        int year = calc.get(Calendar.YEAR);
        int edad = year - birth;
        
        System.out.println("Tienes " + edad + "años");
        
        
        
    }

}
