/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofres;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Cofres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carta[] disponibles = new Carta[5];//todas las del juego
        Usuarios[] llista_jugador = new Usuarios[4];
        //4 variables preparades per apuntar 
        //a un lloc memoria on hih a usuaris pero no ha reservat memoria
        int  menu;
        int num_jugador = 0, numero_jugadores_actual=0, nivel_j=0;
        cargar_cartas_disponibles(disponibles);
        
        //pedir el nombre del primer jugador
        String nomb = inicializar_nombre();
        //reservo posicion nueva en el array
        inicializar_jugador(llista_jugador,num_jugador, nomb, disponibles.length);
        numero_jugadores_actual++;
        
   
        do {
            //mostrar el nombre del jugador
            System.out.println("Estas jugando con : " + llista_jugador[num_jugador].nom);
            menu = mostrar_opciones_menu();
            switch (menu) {
                case 1:
                    mostrartodascartasJuego(disponibles,llista_jugador[num_jugador].nivel_usuario_arena);
                    break;
                case 2:
                    llista_jugador[num_jugador].monedas = llista_jugador[num_jugador].monedas + encontrar_monedas(450, 50);
                    llista_jugador[num_jugador].num_cartas_tuyas = abrir_cofres(disponibles, llista_jugador[num_jugador].tuyas, llista_jugador[num_jugador].num_cartas_tuyas);
                    //abrir_cofres2(disponibles, llista_jugador[num_jugador]);
                    //void abrir_cofres(disponibles, llista_jugador, num_jugador);
                    break;
                case 3:
                    mostrartuscartas(llista_jugador[num_jugador].tuyas, llista_jugador[num_jugador].num_cartas_tuyas);
                    System.out.println("monedas" + llista_jugador[num_jugador].monedas);
                    break;
                case 4:
                    encontrarCarta(llista_jugador[num_jugador].tuyas, llista_jugador[num_jugador].num_cartas_tuyas);
                   
                    break;
                case 6:
                    llista_jugador[num_jugador].monedas = subir_nivel(llista_jugador[num_jugador].tuyas, llista_jugador[num_jugador].monedas, llista_jugador[num_jugador].num_cartas_tuyas, 
                            llista_jugador[num_jugador]);
                    break;
                case 7: //canviar cuenta
                    num_jugador = canviar_supercellid(llista_jugador,num_jugador);

                    break;
                case 8:
                    transferir_carta(llista_jugador,num_jugador);

                    break;
                case 9: //ordenacion
                    ordenar_cartas(llista_jugador,num_jugador);

                    break;
            }
        } while (menu != 0);

    }

    private static void cargar_cartas_disponibles(Carta[] disponibles) {

        for (int i = 0; i < disponibles.length; i++) {
            disponibles[i] = new Carta();
        }

        disponibles[0].nombre = "Pekka";
        disponibles[0].elixir = 7;
        disponibles[0].tipo = Tipo_carta.EPICA;
        disponibles[0].arena = 0; 
        //System.out.println("tu" + Tipo_carta.EPICA);
        //disponibles[0].level no hace falta
        //disponibles[0].puntos_carta no hace

        disponibles[1].nombre = "Mini Pekka";
        disponibles[1].elixir = 4;
        disponibles[1].tipo = Tipo_carta.RARA;
        disponibles[1].arena = 0;
        disponibles[2].nombre = "Leñador";
        disponibles[2].elixir = 4;
        disponibles[2].tipo = Tipo_carta.RARA;
        disponibles[2].arena = 1;
        disponibles[3].nombre = "Globo Bombastico";
        disponibles[3].elixir = 5;
        disponibles[3].tipo = Tipo_carta.COMUN;
        disponibles[3].arena = 1;
        disponibles[4].nombre = "Descarga";
        disponibles[4].elixir = 2;
        disponibles[4].tipo = Tipo_carta.COMUN;
        disponibles[4].arena = 2;
    }

    private static int mostrar_opciones_menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.-Mostrar totes les cartes disponibles del joc");
            System.out.println("2.- Obrir Cofre");
            System.out.println("3.- Mostrar totes les teves cartes");
            System.out.println("4.-Buscar Carta\n"
                    + "5.-Consulta saldo monedes\n"
                    + "6.- Pujar nivell carta\n"
                    + "7.- Canviar cuenta de juego\n"
                    + "8.- Passar cartes a company\n"
                    + "0. Sortir");
            System.out.print("Pon opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 11);

        return opcion;

    }
    
    /**
     * mostra todas las posibles cartas que te pueden tocar en el ju
     * @param disponibles array con todas las cartas del juego
     */

    private static void mostrartodascartasJuego(Carta[] disponibles, int nivel_usuario_arena) {
        for (int i = 0; i < disponibles.length; i++) {
            if (nivel_usuario_arena >= disponibles[i].arena)
            {
            System.out.println("->" + disponibles[i].nombre + " elixir:" + disponibles[i].elixir);    
            }
            
        }
    }

    /**
     * abre cofres donde tocan monedas y 2 tipos de cartas
     * @param disponibles todas las cartas del juego
     * @param tuyas todas las cartas que tienen el jugador
     * @param num_cartas_tuyas indicador con el numero de cartas que tiene el jugador
     * @return devuelve el numero de cartas actualizado.
     */
    private static int abrir_cofres(Carta[] disponibles, Carta[] tuyas, int num_cartas_tuyas) {

        Carta añadir = new Carta();
        
        for (int j = 0; j < 2; j++) {
            añadir = cartaAleatoria(disponibles);
            boolean comprovador = false;
            for (int i = 0; i < num_cartas_tuyas; i++) {
                if (tuyas[i].nombre.equals(añadir.nombre)) {
                    System.out.println("tienes una carta parecida sumamos los puntos");
                    tuyas[i].puntos_carta = tuyas[i].puntos_carta + añadir.puntos_carta;
                    comprovador = true;
                }
            }
            //si no la tenia la añado y aumento el contador de cartas
            if (comprovador == false) {
                tuyas[num_cartas_tuyas] = añadir;
                System.out.println("hemos añadido la carta porque no la tenias");
                num_cartas_tuyas = num_cartas_tuyas + 1;
            }
        }

        //abrir_carta * 2;
        return num_cartas_tuyas;
    }

    /**
     * random entre inici y quantitat_numeros`+ inici
     * @param quantitat_numeros el abanico de numeros uqe puede salir
     * @param inici el numero mínimo de monedas
     * @return las monedas que han salido random mas el inici
     */
    private static int encontrar_monedas(int quantitat_numeros, int inici) {
        int monedas = (int) (Math.random() * quantitat_numeros) + inici;
        System.out.println("te salen " + monedas + " monedas");
        return monedas;
    }

    /**
     * /**
     * retorna una carta aleatoria de las disponibles, con un numero de puntos 
    de carta informad
    
     * @param disponibles todas las posibles
     * @return objeto carta informado nombre, elixir y puntos carta (level no)
     */
    
    private static Carta cartaAleatoria(Carta[] disponibles) {

        int random = (int) (Math.random() * disponibles.length);
        int puntos = (int) (Math.random() * 19) + 1;

        Carta Random = new Carta();
        Random.nombre = disponibles[random].nombre;
        Random.puntos_carta = puntos;
        Random.elixir = disponibles[random].elixir;

        System.out.println("la carta nueva es " + Random.nombre + "\ntiene " + puntos + " puntos");

        return Random;

    }

    /**
     * mostra todas las cartas
     * @param tuyas todas las del jugador
     * @param num_cartas_tuyas indocador numero cartas
     * 
     */
    private static void mostrartuscartas(Carta[] tuyas, int num_cartas_tuyas) {
        for (int i = 0; i < num_cartas_tuyas; i++) {
            System.out.println("->" + tuyas[i].nombre + " nivel:" + tuyas[i].level + " puntos cartas: " + tuyas[i].puntos_carta);
        }

    }

    /*pregutna la carta
    si la tiene, comprueba si tiene monedas y puntos para subirla un 
    nivel
        si es asi lo sube y actualiza monedas con las gastadas
    sino no lo aumenta 
    devuelve siempre las monedas que le quedan haya auentado nivel o no
     */
    private static int subir_nivel(Carta[] tuyas, int monedas, int num_cartas_tuyas, Usuarios jugador) {

        Scanner sc = new Scanner(System.in);

        String nom_introduit;
        System.out.println("Introdueix el nom de la carta");
        nom_introduit = sc.nextLine();
        int puntos_necesarios, monedas_necesarias;
        
        
        for (int i = 0; i < num_cartas_tuyas; i++) {
            
            if (nom_introduit.equalsIgnoreCase(tuyas[i].nombre)) {

                puntos_necesarios = 10 * (tuyas[i].level + 1);
                monedas_necesarias = (1000 * (tuyas[i].level + 1));

                if ((tuyas[i].puntos_carta >= puntos_necesarios) && monedas >= monedas_necesarias) {

                    tuyas[i].level++;
                 System.out.println("Has augmentat al nivell " + tuyas[i].level);
                 if (jugador.nivel_usuario_arena<tuyas[i].level)
                 {
                     jugador.nivel_usuario_arena=tuyas[i].level;
                 }
                 tuyas[i].puntos_carta = tuyas[i].puntos_carta - puntos_necesarios;
                 monedas = monedas - monedas_necesarias;
                 ordenacionLevelDescendente(tuyas, num_cartas_tuyas);
  
                } else {
                    System.out.println("Et falten monedes o punts");
                }
            }
        }

        return monedas;
    }

    /**
     * ordena las cartas jugaor por nivel de forma descendiente
     * @param tuyas
     * @param num_cartas_tuyas 
     */
    private static void ordenacionLevelDescendente(Carta[] tuyas, int num_cartas_tuyas) {
        //int posicion,j;
       int ele_ordenados, j;
       Carta aux=new Carta();
       
        for (ele_ordenados = 0; ele_ordenados < num_cartas_tuyas; ele_ordenados++) {
            for(j=0;j<(num_cartas_tuyas-ele_ordenados-1);j++)
            {
//ordenacion descendente
                if(tuyas[j].level<tuyas[j+1].level)

                {//intercambio valores
                   aux.elixir =  tuyas[j].elixir;
                   aux.nombre =  tuyas[j].nombre;
                   aux.level =  tuyas[j].level;
                   aux.puntos_carta =  tuyas[j].puntos_carta;
                   
                   tuyas[j].elixir =  tuyas[j+1].elixir;
                   tuyas[j].nombre =  tuyas[j+1].nombre;
                   tuyas[j].level =  tuyas[j+1].level;
                   tuyas[j].puntos_carta =  tuyas[j+1].puntos_carta;
                   
                   tuyas[j+1].elixir =  aux.elixir;
                   tuyas[j+1].nombre =  aux.nombre;
                   tuyas[j+1].level =  aux.level;
                   tuyas[j+1].puntos_carta =  aux.puntos_carta;
               
                }
            }
        }
       
    }

    /**
     * Muestra la carta que busca el usuario
     * @param tuyas
     * @param num_cartas_tuyas 
     */
    private static void encontrarCarta(Carta[] tuyas, int num_cartas_tuyas) {
       Scanner sc = new Scanner(System.in);

        String nom_introduit;
        System.out.println("Quina carta vols veure?");
        nom_introduit = sc.nextLine();
        boolean trobada=false;
        for (int i = 0; i < num_cartas_tuyas; i++) {
            
            if (nom_introduit.equalsIgnoreCase(tuyas[i].nombre)) { 
                System.out.println("Carta " + tuyas[i].nombre);
                System.out.println("Elixir " + tuyas[i].elixir);
                System.out.println("Level " + tuyas[i].level);
                System.out.println("puntos " + tuyas[i].puntos_carta);
                trobada=true;
                } 
            }
        
         if (!trobada)
            {
                System.out.println("No tens aquesta carta " + nom_introduit);
            }
        }

    /**
     * pide nombre de jugador
     * @return nombre de jugador
     */
    private static String inicializar_nombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dis el nom del compte?");
        return sc.nextLine();
    }

    /**
     * reserva espacio e inicializa nombre de jugador
     * @param llista_jugador
     * @param num_jugador
     * @param nomb
     * @param length 
     */
    private static void inicializar_jugador(Usuarios[] llista_jugador, int num_jugador, String nomb, int length) {
        llista_jugador[num_jugador] = new Usuarios(); //variables primitica
        //se inicializan a su valor por defecto aparte de reservar espacio real en memoria
        llista_jugador[num_jugador].nom = nomb;
        llista_jugador[num_jugador].tuyas = new Carta[length]; //reservo espacio
    }

    /**
     * mismo que abrir cofres pero otro metodo con menos 
     * parametros de entrada
     * @param disponibles
     * @param jugador 
     */
    private static void abrir_cofres2(Carta[] disponibles, Usuarios jugador) {
        jugador.monedas = jugador.monedas + encontrar_monedas(450, 50);
        
        
        Carta añadir = new Carta();

        for (int j = 0; j < 2; j++) {
            añadir = cartaAleatoria(disponibles);
            boolean comprovador = false;
            for (int i = 0; i < jugador.num_cartas_tuyas; i++) {
                if (jugador.tuyas[i].nombre.equals(añadir.nombre)) {
                    System.out.println("tienes una carta parecida sumamos los puntos");
                    jugador.tuyas[i].puntos_carta = jugador.tuyas[i].puntos_carta + añadir.puntos_carta;
                    comprovador = true;
                }
            }
            if (comprovador == false) {
                jugador.tuyas[jugador.num_cartas_tuyas] = añadir;
                System.out.println("hemos añadido la carta porque no la tenias");
                jugador.num_cartas_tuyas++;
            }
        }

    }

    /*devolvera la posicion del jugador que tratare a partir del cambio de cuenta*/
    private static int canviar_supercellid(Usuarios[] llista_jugador, int posicion_actual) {
      String nom_buscat = inicializar_nombre();
      int posicion;
        for (posicion = 0; posicion < llista_jugador.length; posicion++) {
            //System.out.println(posicion +  llista_jugador[posicion].nom );
            if(llista_jugador[posicion]==null)//estoy en una posiicon
                //no inicializada, y puedo devolver esta posicion
                //esta posicion es menor que el tope de usuarios
            {
                 System.out.println("Jugador nuevo añado jugador... ");
                inicializar_jugador(llista_jugador,posicion, nom_buscat, llista_jugador[0].tuyas.length);
                return posicion;
            }
            else if(llista_jugador[posicion].nom.equalsIgnoreCase(nom_buscat))
            {
                System.out.println("Cambio al jugador introducido... ");
                return posicion;
            }
            
        }
     
          System.out.println("no hay espacio disponibe para mas usuarios");
          return posicion_actual;
      
    }
    
    /**
     * le pasa puntos de carta a otro jugador , maximo 8 o los que tenga
     * siempre que tenga la carta el mismo jugador y el transferido
     * @param llista_jugador
     * @param num_jugador 
     */

    private static void transferir_carta(Usuarios[] llista_jugador, int num_jugador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pon el nombre jugador a transferir");
        String nom_transferit = sc.nextLine();
        
        //busco el jugador, que debe existir!
        int jugador_new = existe_jugador(llista_jugador,nom_transferit);
        if(jugador_new!=-1)
        {
        //si encuentro el jugador busco la carta
        System.out.println("Pon la carta a transferir");
        String carta_transferir = sc.nextLine();
        boolean tengo=false, tiene=false;
        int pos_mi_mazo=0, pos_su_mazo=0;
            
        //for para saber si yo tengo la carta
        for (int i = 0; i < llista_jugador[num_jugador].num_cartas_tuyas; i++) {
            
            if (carta_transferir.equalsIgnoreCase(llista_jugador[num_jugador].tuyas[i].nombre)) { 
                pos_mi_mazo = i;
                tengo=true; //guardo datos de mi carta
                } 
            }
        //for para saber si mi compañero tiene la carta
        for (int i = 0; i < llista_jugador[jugador_new].num_cartas_tuyas; i++) {
            
            if (carta_transferir.equalsIgnoreCase(llista_jugador[jugador_new].tuyas[i].nombre)) { 
                pos_su_mazo = i;
                tiene=true; //guardo datos de la carta del compañero
                } 
            }       
        //los dos jugadores tienen la carta
        if(tengo && tiene)
        {
            
            if(llista_jugador[num_jugador].tuyas[pos_mi_mazo].puntos_carta>8)
            {
                llista_jugador[num_jugador].tuyas[pos_mi_mazo].puntos_carta=llista_jugador[num_jugador].tuyas[pos_mi_mazo].puntos_carta-8;
                llista_jugador[num_jugador].tuyas[jugador_new].puntos_carta=llista_jugador[jugador_new].tuyas[pos_su_mazo].puntos_carta+8;
            }
            else
            {
              llista_jugador[num_jugador].tuyas[jugador_new].puntos_carta=llista_jugador[jugador_new].tuyas[pos_su_mazo].puntos_carta+llista_jugador[num_jugador].tuyas[pos_mi_mazo].puntos_carta;  
              llista_jugador[num_jugador].tuyas[pos_mi_mazo].puntos_carta=0;
            }
            llista_jugador[num_jugador].monedas += 200;
        }
        else
        {
            System.out.println("alguien no tiene la cartap");
        }
            
        }
        else
        {
            System.out.println("jugador no existe");
        }
        
    }

    /**
     * busca el jugador que tenga nom_transferit
     * @param llista_jugador
     * @param nom_transferit
     * @return devuelve la posición en el array, sino deveuvlete -1
     */
    private static int existe_jugador(Usuarios[] llista_jugador, String nom_transferit) {
        for (int posicion = 0; posicion < llista_jugador.length; posicion++) {
            //System.out.println(posicion +  llista_jugador[posicion].nom );
            if(llista_jugador[posicion]==null)//estoy en una posiicon
                //no inicializadas
            {
                return -1;
            }
            else if(llista_jugador[posicion].nom.equalsIgnoreCase(nom_transferit))
            {
                return posicion;
            }
            
        }
        return -1;
    }

    private static void ordenar_cartas(Usuarios[] llista_jugador, int num_jugador) {
        Scanner sc = new Scanner(System.in);
        int opcion = tipoOrden(sc);
//        if (opcion==1) // ordenacion por nombre
//        {
//            
//        }else 
        if (opcion==2) //ordenacion por elixir
        {
            ordenacion_elixir(llista_jugador[num_jugador].tuyas, llista_jugador[num_jugador].num_cartas_tuyas);
        }else if (opcion==3) //ordenacion por nivell
        {
            ordenacion_level(llista_jugador[num_jugador].tuyas, llista_jugador[num_jugador].num_cartas_tuyas);
        }
        
    }
    
 private static void ordenacion_elixir(Carta[] tuyas, int num_cartas_tuyas) {
        //int posicion,j;
       int ele_ordenados, j;
       Carta aux=new Carta();
       
        for (ele_ordenados = 0; ele_ordenados < num_cartas_tuyas; ele_ordenados++) {
            for(j=0;j<(num_cartas_tuyas-ele_ordenados-1);j++)
            {
//ordenacion descendente
                if(tuyas[j].elixir<tuyas[j+1].elixir)

                {//intercambio valores
                   aux.elixir =  tuyas[j].elixir;
                   aux.nombre =  tuyas[j].nombre;
                   aux.level =  tuyas[j].level;
                   aux.puntos_carta =  tuyas[j].puntos_carta;
                   
                   tuyas[j].elixir =  tuyas[j+1].elixir;
                   tuyas[j].nombre =  tuyas[j+1].nombre;
                   tuyas[j].level =  tuyas[j+1].level;
                   tuyas[j].puntos_carta =  tuyas[j+1].puntos_carta;
                   
                   tuyas[j+1].elixir =  aux.elixir;
                   tuyas[j+1].nombre =  aux.nombre;
                   tuyas[j+1].level =  aux.level;
                   tuyas[j+1].puntos_carta =  aux.puntos_carta;
               
                }
            }
        }
       
    }    
    
 private static void ordenacion_level(Carta[] tuyas, int num_cartas_tuyas) {
        //int posicion,j;
       int ele_ordenados, j;
       Carta aux=new Carta();
       
        for (ele_ordenados = 0; ele_ordenados < num_cartas_tuyas; ele_ordenados++) {
            for(j=0;j<(num_cartas_tuyas-ele_ordenados-1);j++)
            {
//ordenacion descendente
                if(tuyas[j].level<tuyas[j+1].level)

                {//intercambio valores
                   aux.elixir =  tuyas[j].elixir;
                   aux.nombre =  tuyas[j].nombre;
                   aux.level =  tuyas[j].level;
                   aux.puntos_carta =  tuyas[j].puntos_carta;
                   
                   tuyas[j].elixir =  tuyas[j+1].elixir;
                   tuyas[j].nombre =  tuyas[j+1].nombre;
                   tuyas[j].level =  tuyas[j+1].level;
                   tuyas[j].puntos_carta =  tuyas[j+1].puntos_carta;
                   
                   tuyas[j+1].elixir =  aux.elixir;
                   tuyas[j+1].nombre =  aux.nombre;
                   tuyas[j+1].level =  aux.level;
                   tuyas[j+1].puntos_carta =  aux.puntos_carta;
               
                }
            }
        }
       
    }   
    
    
private static int tipoOrden(Scanner sc) {

        int opcion;

        do {
            System.out.println("1-Ordenació per nom\n"
                    + "2-Ordenació per elixir\n"
                    + "3-Ordenació per nivell");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 3);

        return opcion;

    }    
    
    
    }
