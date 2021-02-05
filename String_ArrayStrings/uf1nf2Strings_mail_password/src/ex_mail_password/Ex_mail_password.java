/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_mail_password;

import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class Ex_mail_password {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email, password;
        System.out.println("Pon tu email");
        email = sc.nextLine();
        System.out.println("Pon tu password");
        password = sc.nextLine();
        boolean valido=true;
        
        /* El nombre de usuario tiene que ser formato email o sea contener una @.*/
        if(!email_arroba(email))
        {
            System.out.println("Email sin @");
            valido=false;
        }
        /*El password tiene que tener mínimo 8 caracteres.*/
        if(!password_longitud_8(password))
        {
            System.out.println("longitud passowrd debe ser 8 o mas");
            valido=false;
        }
        /*password sin espacios*/
        if(!password_sin_espacios(password))
        {
            System.out.println("password no debe contener espacios"); 
            valido=false;
        }
        
        if(!email_proven(email))
        {
            System.out.println("email debe ser del dominio proven.cat");
            valido=false;
        }
        if(valido==true)
        {
        System.out.println("usuario i password correctos");
        }
    }

    /**encontrarme un @*/
    private static boolean email_arroba(String email) {
       /* for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i)=='@')
            {
                return true;
            }
        }
        return false;*/
        /*opcion 2
        if(email.contains("@"))
        {
            return true;
        }
        else
        {
            return false;
        }
        */
        /*opcion 3*/
        if(email.indexOf('@')!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*deveuvle true si es 8 o mas*/
    private static boolean password_longitud_8(String password) {
       return (password.length()>=8);
    }

    private static boolean password_sin_espacios(String password) {
      /* for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i)==' ')
            {
                return true;
            }
        }
        return false;*/
        /*opcion 2
        if(password.contains(" "))
        {
            return false;
        }
        else
        {
            return true;
        }
        */
        /*opcion 3*/
        if(password.indexOf(' ')!=-1)
        {
            return false;
        }
        else
        {
            return true; /* no hay espaios*/
        }
    }

    private static boolean email_proven(String email) {
        int pos_arroba = email.indexOf('@');
        String dominio;
        if(pos_arroba!=-1)
        {//recorto el string con la parte de despues del @
            dominio = email.substring(pos_arroba+1);
         
            if(dominio.equals("proven.cat"))
            {
                return true;
            }
        }
        return false;
    }
    
}
