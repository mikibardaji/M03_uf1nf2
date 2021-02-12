# M03_uf2nf2
## Arrays unidimensionales Vectores

**1.** Crea un programa que pida diez números reales por teclado, los almacene en un array, 
y luego muestre todos sus valores.

**2.** Crea un programa que pida diez números reales por teclado, los almacene en un array, 
y luego muestre la suma de todos los valores.

**3.** Crea un programa que pida diez números reales por teclado, los almacene en un array, 
yluego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.

**4.** Crea un programa que pida veinte números enteros por teclado, los almacene en un array 
yluego muestre por separado la suma de todos los valores positivos y negativos.

**5.** Crea un programa que pida veinte números reales por teclado, los almacene en un array 
yluego lo recorra para calcular y mostrar la media: (suma de valores) / nº de valores.

**6.** Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño N,
escriba M en todas sus posiciones y lo muestre por pantalla.

**7.** Crea un programa que pida dos valores enteros P y Q, luego cree un array que contengatodos los valores desde P hasta Q,
y lo muestre por pantalla.

**8.** Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
utilizando Math.random(), y luego le pida al usuario un valor real R. Por último, 
mostrarácuántos valores del array son igual o superiores a R.

**9.** Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores 
enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N 
y mostrará en qué posiciones del array aparece N.

**10.** Crea un programa para realizar cálculos relacionados con la altura (en metros) de personas.
Pedirá un valor N y luego almacenará en un array N alturas introducidas por teclado. 
Luego mostrará la altura media, máxima y mínima así como cuántas personas miden por encima y 
por debajo de la media.

**11.** Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en el
primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores 
delprimer array al segundo array en orden inverso, y mostrar ambos por pantalla.

**12.** Crea un programa que cree un array de 10 enteros y luego muestre el siguiente menú con
distintas opciones:

   a. Mostrar valores.
   
   b. Introducir valor.
   
   c. Salir.
   
   La opción ‘a’ mostrará todos los valores por pantalla. 
   La opción ‘b’ pedirá un valor V y una posición P, luego escribirá V en la posición P del array.
   El menú se repetirá indefinidamente hastaque el usuario elija la opción ‘c’ que terminará el programa.
   
**13.** Crea un programa que permita al usuario almacenar una secuencia aritmética en un array y
 luego mostrarla. Una secuencia aritmética es una serie de números que comienza por un
 valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1 e I=2, la secuencia
 sería 1, 3, 5, 7, 9... Con V=7 e I=10, la secuencia sería 7, 17, 27, 37... El programa solicitará al
 usuario V, I además de N (nº de valores a crear).
 
**14.** Crea un programa que cree un array de enteros e introduzca la siguiente secuencia de
 valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir el 10, unas 10 diez veces, y luego la
 muestre por pantalla.

**18.** Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios entre 0 y 9 (utiliza Math.random()*10). Luego ordena los valores del array y los mostrará por pantalla.

**19.** Necesitamos crear un programa para mostrar el ranking de puntuaciones de un torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que introduzca las puntuaciones de todos los jugadores (habitualmente valores entre 1000 y 2800, de tipo entero) y luego muestre las puntuaciones en orden descendente (de la más alta a la más baja).

**HeadBall 2.** El joc es senzill 4 targetes, una aleatoria te una tarjeta vermella, les altres premis que van variant. Jugues fins que et plantes o fins que et surt una tarjeta vermella.
Podeu mirar el video següent [link](https://www.youtube.com/watch?v=nQh-xJQsXoc&feature=youtu.be)
Simularem que a totes et toca diners random de 1 al 20, menys a 1 que tindra que valer -1, que si la elegeixes, et retorna -1 que tu traduiras (al main) com targeta vermella.
Plenar el array amb una funció apart.
Retornar el valor a partir de la elecció usuario, funcio apart.

**Cubiletes trileros.** Crearem el joc de los trileros.
El nostre joc sera mes senzill , crearem un array de tipus lletra on hi haurà una boleta , O (o mayuscula) i dues X.
Inicialment es ficara aleatoriament i ha de mostrar on te la 0.
Llavors, ha de fer 10 canvi de posicions.
Un canvi de posicio, es intercanviar el valor de 2 cubiletes.
Per exemple canvia el valor del 0 per la posició 2, IMPORTANT: HAN DE CANVIAR ELS DOS VALORS I NO PERDRE EL VALOR.
Com que no es visual, apart de fer el canvi ha de mostrar la frase **"Intercanvio posicions 0 y 2"**. S'ha de mostrar les 10 frases del canvi i despres demanar-te a on esta la pilota.
Si encertes acumules un punt i tornes a jugar.
Fins que falles, que llavors s'acaba el joc i et mostra els punts aconseguits.
Es programarà amb funcions principalment i abans de començar a codificar, al main, amb linees de comentaris // haure de escriure els passos a seguir i avisar al professor que els revisi.

## Strings

**3.** Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos. Luego
mostrará un código de usuario (en mayúsculas) formado por la concatenación de las tres
primeras letras de cada uno de ellos. Por ejemplo si se introduce “Lionel”, “Tarazón” y
“Alcocer” mostrará “LIOTARALC”.

**4.** Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas ‘a’,
cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
mayúsculas y minúsculas. Por ejemplo dada la frase “Mi mama me mima” dirá que hay:
Nº de A's: 3
Nº de E's: 1
Nº de I's: 2
Nº de O's: 0
Nº de U's: 0

**Verificar mail y password.** uf1nf2Strings_mail_password Realiza un programa que solicite un nombre de usuario (que obligatoriamente será un email) y un password.
La validación es:
- El nombre de usuario tiene que ser formato email o sea contener una @.
- El password tiene que tener mínimo 8 caracteres.
- El password no debe contener espacios

Tras la validación, informar al usuario de los posibles errores o si no hay:
- "Usuario incorrecto"
- "Password incorrecto"
- Si tiene espacios debe informar "formato incorrecto no debe dejar espacios"
- Solo debe aceptar si el dominio es "proven.cat", sino informar "dominio mail incorrecto" 
- si todo es correcto debe mostrar "Usuario i password correcto"

**Penjat.** Jugar al típic joc del ahorcado

**Alexa.** Ver documento pdf adjunto
## Arrays Strings

**Draft Clash Royale.** Ver documento pdf adjunto

**Agenda contactes.**
Crea una llista de noms que gestionarem amb un menú, amb les seguents opcions:

1- Llistar noms (mostrarà tots els noms fins al moment i al final del llistat mostrara quants n'ha mostrat)
2- Afegir nom(Afegira a la part final el nom que afegeixis)
Modificar nom(Buscara el nom i el substituira pel nou que introdueixis)
Cerca en quina posició nom(Posaras el nom a buscar i retornar la posició en que es troba a la llista)
Esborrar nom(opció fàcil, quant trobes la posició la deixes en blanc, i despres llistar noms , no te que mostrar les posicions en blanc. 2ona opcioó mes correcta quant troba el nom, va copiant les posicions segunts de tal manera que es mouen totes una posició cap a la esquerra la 3 passa a la 2, la 4 a la 3.)

## Arrays multidimensionales.

**1.** Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25 y luego muestre la matriz por pantalla.

**2.** Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas de multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla.

**3.** Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por teclado) e introduzca en ella NxM valores (también introducidos por teclado). Luego deberá recorrer la matriz y al final mostrar por pantalla cuántos valores son mayores que cero, cuántos son menores que cero y cuántos son igual a cero.

**4.** Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por teclado y luego el programa mostrará la nota mínima, máxima y media de cada alumno.

**5.** Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una empresa y detectar si existe brecha salarial entre ambos. El programa pedirá por teclado la información de N personas distintas (valor también introducido por teclado). Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo. Esta información debe guardarse en una única matriz. Luego se mostrará por pantalla el sueldo medio de cada género.

**Conecta4.** Enunciado en PDF.
