/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Ahorcado {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String paraula = ficar_paraula();  
        for (int i=0; i < 50; i++)

{

System.out.println("branca1");

}
        char[] lletres = new char[paraula.length()];
        int vides = 7;
        rellenarArraysGuion(lletres);

        do {

            mostrar_lletres(lletres);
            char letra = pedirletra();

            System.out.println("Has escrito:" + letra);

            boolean trobarlletra = encontrarLetra(paraula, lletres, letra);

            System.out.println(trobarlletra);

            if (!trobarlletra) {
                vides--;
                munyeco(vides);
                //System.out.println("Te quedan " + vides);
            }
            else
            {
                System.out.println("has acertado letra");
            }

        } while (vides > 0 && has_ganado(lletres) == false);

    }

    private static String ficar_paraula() {
        Scanner sc = new Scanner(System.in);
        String paraula;
        do {
            System.out.println("Fica una paraula alemhys 3 lletres");
            paraula = sc.next();//elimina ja els espais
        } while (paraula.length() < 3);
        return paraula.toUpperCase();
    }

    private static void rellenarArraysGuion(char[] lletres) {
        for (int i = 0; i < lletres.length; i++) {
            lletres[i] = '_';
        }

        //Arrays.fill(lletres, '_');
    }

    private static void mostrar_lletres(char[] lletres) {
        for (int i = 0; i < lletres.length; i++) {
            System.out.print(lletres[i] + " ");
        }
        System.out.println("");
    }

    private static char pedirletra() {
        Scanner sc = new Scanner(System.in);
        char letra;

        System.out.println("Dime una letra(en mayuscula)");
        letra = sc.next().charAt(0);

        return letra;
    }

    private static boolean encontrarLetra(String paraula, char[] lletres, char letra) {
        boolean check = false;
        for (int i = 0; i < lletres.length; i++) {
            if (paraula.charAt(i) == letra) {
                lletres[i] = letra;
                check = true;
            }
        }

        return check;
    }

    private static boolean has_ganado(char[] lletres) {
        
        for (int i = 0; i < lletres.length; i++) {
            if (lletres[i]=='_') {
                return false;
            }          
        }
        return true;
    }


     private static void munyeco(int intentos) {

        switch (intentos) {
            case 6:
                System.out.println(" ---------------------");
                for (int j = 0; j < 15; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;
            case 5:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                for (int j = 0; j < 10; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;
            case 4:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");
                break;
            case 3:
                System.out.println(" ---------------------");
                System.out.println(" |                     |");
                System.out.println(" |                     |");
                System.out.println(" |                  -------");
                System.out.println(" |                 | -  -  |");
                System.out.println(" |                 |   o   |");
                System.out.println(" |                  -------");
                System.out.println(" |                     |   ");
                System.out.println(" |                   / |   ");
                System.out.println(" |                 /   |   ");
                System.out.println(" |                /    |   ");
                System.out.println(" |                     |   ");
                for (int j = 0; j < 5; j++) {
                    System.out.println(" |");
                }
                System.out.println("__________");

                break;
            case 2:
                System.out.println("                     ,____\n"
                        + "                      |---.\\\n"
                        + "              ___     |    `\n"
                        + "             / .-\\  ./=)\n"
                        + "            |  |\"|_/\\/|\n"
                        + "            ;  |-;| /_|\n"
                        + "           / \\_| |/ \\ |\n"
                        + "          /      \\/\\( |\n"
                        + "          |   /  |` ) |\n"
                        + "          /   \\ _/    |\n"
                        + "         /--._/  \\    |\n"
                        + "         `/|)    |    /\n"
                        + "           /     |   |\n"
                        + "         .'      |   |\n"
                        + "  jgs   /         \\  |\n"
                        + "       (_.-.__.__./  /");
                break;
            case 1:
                System.out.println("               ...\n"
                        + "             ;::::;\n"
                        + "           ;::::; :;\n"
                        + "         ;:::::'   :;\n"
                        + "        ;:::::;     ;.\n"
                        + "       ,:::::'       ;           OOO\\\n"
                        + "       ::::::;       ;          OOOOO\\\n"
                        + "       ;:::::;       ;         OOOOOOOO\n"
                        + "      ,;::::::;     ;'         / OOOOOOO\n"
                        + "    ;:::::::::`. ,,,;.        /  / DOOOOOO\n"
                        + "  .';:::::::::::::::::;,     /  /     DOOOO\n"
                        + " ,::::::;::::::;;;;::::;,   /  /        DOOO\n"
                        + ";`::::::`'::::::;;;::::: ,#/  /          DOOO\n"
                        + ":`:::::::`;::::::;;::: ;::#  /            DOOO\n"
                        + "::`:::::::`;:::::::: ;::::# /              DOO\n"
                        + "`:`:::::::`;:::::: ;::::::#/               DOO\n"
                        + " :::`:::::::`;; ;:::::::::##                OO\n"
                        + " ::::`:::::::`;::::::::;:::#                OO\n"
                        + " `:::::`::::::::::::;'`:;::#                O\n"
                        + "  `:::::`::::::::;' /  / `:#\n"
                        + "   ::::::`:::::;'  /  /   `#");
                break;
            case 0:
                System.out.println("░░░░░░░░░░░░░░░░▓██████▓▓▓░░░░░░░░░░░░░░░\n"
                        + "░░░░░░░░░░░░░█████▓▓█████████▓░░░░░░░░░░░\n"
                        + "░░░░░░░░░░█████▓░░▓█████████████░░░░░░░░░\n"
                        + "░░░░░░░░▓███▓░░░▓█████████████████░░░░░░░\n"
                        + "░░░░░░░███▓░░░░░███████████████████▓░░░░░\n"
                        + "░░░░░░███░░░░░░██████████████████████░░░░\n"
                        + "░░░░░███░░░░░░░███████████████████████░░░\n"
                        + "░░░░███░░░░░░░░███████░░░░██████████▓█▓░░\n"
                        + "░░░███▓░░░░░░░░███████░░░░▓██████████▓█░░\n"
                        + "░░▓███░░░░░░░░░░██████▓░░▓███████████▓██░\n"
                        + "░░████░░░░░░░░░░▓████████████████████▓▓█░\n"
                        + "░▓█░█▓░░░░░░░░░░░░████████████████████░██\n"
                        + "░██░█░░░░░░░░░░░░░░▓██████████████████░██\n"
                        + "░█▓░█░░░░░░░░░░░░░░░░░▓███████████████░▓█\n"
                        + "▓█▓░█▓░░░░░░░░░░░░░░░░░░██████████████░░█\n"
                        + "██░░██░░░░░░░░░░░▓▓░░░░░░▓████████████░░█\n"
                        + "██░▓░█░░░░░░░░░░████▓░░░░░███████████▓░░█\n"
                        + "██░█░██░░░░░░░░▓█████░░░░░░██████████░░▓█\n"
                        + "██░▓█░██░░░░░░░░████▓░░░░░░█████████░░▓▓█\n"
                        + "▓█░░█░░█▓░░░░░░░░▓▓░░░░░░░░████████▓░░▓██\n"
                        + "░█░░█▓░▓██░░░░░░░░░░░░░░░░░███████▓░░█▓█▓\n"
                        + "░██░███████▓░░░░░░░░░░░░░░██████████▓█▓█░\n"
                        + "░▓█░██▓░░░▓███░░░░░░░░░░▓██████▓░░░▓██▓█░\n"
                        + "░░███▓░░░░░░░███████████████▓░░░░░░░░██▓░\n"
                        + "░░░██░░▓▓█▓▓▓░░░▓████████▓░░░░▓▓█▓▓░░██░░\n"
                        + "░░░▓█░████████▓░░░░░░░░░░░░▓████████░▓█░░\n"
                        + "░░░█▓▓███████████░░░░░░░░████████████░█▓░\n"
                        + "░░░█░█████████████░░░░░░█████████████░██░\n"
                        + "░░▓█░▓████████████░░░░░░█████████████░░█░\n"
                        + "░░▓█░▓▓███████████░░░░░░███████████▓▓░░█░\n"
                        + "░░▓█░░░▓█████████░░░░░░░░█████████▓░░░░█░\n"
                        + "░░░█▓░░░████████░░░░░░░░░░████████░░░░██░\n"
                        + "░░░██░░░░░█████░░░░████░░░░█████▓░░░░░█▓░\n"
                        + "░░░░██░░░░░░░░░░░░██████░░░░░░░░░░▓░░██░░\n"
                        + "░░░░▓████▓░░░░░░░░███▓██▓░░░░░░░░█████░░░\n"
                        + "░░░░░▓█▓████▓░░░░░██░▓▓██░░░░▓████░██░░░░\n"
                        + "░░░░░░░░▓█▓██░▓░░░██▓▓▓██░░█▓█████░░░░░░░\n"
                        + "░░░░░░░░▓█░███▓░░░▓▓▓░▓░░░░░█▓██▓█░░░░░░░\n"
                        + "░░░░░░░░▓█░██▓░░▓░░░░░░░░░▓░███▓▓█░░░░░░░\n"
                        + "░░░░░░░░▓█░███▓███▓░░░░░▓███▓██░▓█░░░░░░░\n"
                        + "░░░░░░░░██░░██░▓░█████████░▓▓█▓░▓█░░░░░░░\n"
                        + "░░░░░░░░▓█░░▓██▓▓░░▓░█░█░▓░▓██░░░█░░░░░░░\n"
                        + "░░░░░░░░░█▓░░████░▓░░▓░░▓▓███░░░██░░░░░░░\n"
                        + "░░░░░░░░░▓█▓░░████████▓█████░░░██▓░░░░░░░\n"
                        + "░░░░░░░░░░░██░░▓▓▓▓▓▓▓▓▓▓▓█░░░██░░░░░░░░░\n"
                        + "░░░░░░░░░░░░██░░▓█████▓██▓░░▓██░░░░░░░░░░\n"
                        + "░░░░░░░░░░░░░██░░░░░▓▓░░░░░███░░░░░░░░░░░\n"
                        + "░░░░░░░░░░░░░░██░░░░░░░░░░██▓░░░░░░░░░░░░\n"
                        + "░░░░░░░░░░░░░░▓██░░░░░░░░██░░░░░░░░░░░░░░\n"
                        + "░░░░░░░░░░░░░░░░██████████░░░░░░░░░░░░░░░");

                System.out.println(ANSI_RED + "GAME OVER" + ANSI_RESET);
                break;
            default:
                throw new AssertionError();
        }

    }
    
    
    
    
}
