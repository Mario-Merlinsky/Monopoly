# Monopoly-Morphic
# Creadores:
Mariano Merlinsky
Nicolas De La Torre
Matias Besmedrisnik
Facundo Calderan
# Como ejecutar el programa:
Para ejecutar el programa se debe tener instalada una version de java mayor o igual a la 21.  Recomendamos la JDK 21 de oracle que utilizamos en nuestro proyecto.
Link de descarga: https://www.oracle.com/java/technologies/downloads/

Asegurarse que maven utilize esta version al momento de la compilacion.

Esto se puede verificar con :`mvn -v`
En caso de tenerla instalada, pero que maven no la reconozca seguir estos pasos:

Linux: 
1. Abrir una terminal y ejecutar los siguientes comandos: `ls -la` y luego `code .bashrc`
2. Eso abrira en un editor de texto, el archivo .bashrc, en ese archivo copiar lo siguiente: `export JAVA_HOME=/ruta/a/la/jdk`
3. Reiniciar Maven para aplicar los cambios.
De esta manera Maven cambiará la version actual y usará la de la JDK.
 

Para poder compilar y correr el programa es necesario tener instalado Maven.

Pasos a seguir:
1. Pararse sobre la carpeta raiz del proyecto, y ejecutar el siguiente comando en la consola: `mvn clean install package`
2. Entrar a la carpeta generada "target" y ejecutar el siguiente comando: `java -jar Monopoly-1.0-SNAPSHOT.jar`.
3. Disfrute del juego.
No es necesaria la instalacion de dependencias para ejecutar el programa.

# Aclaraciones del proyecto:
La clase configuracion contiene todos los parametros configurables del juego, todos pueden ser alterados de forma segura. Contamos con una restriccion a la hora de definir la cantidad de casilleros totales, la cantidad seleccionable total (la suma entre los distintos tipos de casilleros) en configuracion + 2 (casillero de carcel y llegada/partida) debe ser divisible por 4 para una vision optima del tablero, de otro modo, los casilleros existiran pero no seran visibles por el usuario.

Los colores disponibles para el jugador son: rojo, verde, azul y amarillo.

Los casilleros de propiedad son los que no poseen imagenes y tienen colores dependiendo del barrio al que pertenecen (aleatorio). Todos las propiedades del barrio tienen el mismo color.

El color del barrio se representa en la parte de arriba de la casilla.

Tanto los casilleros de propiedad como los de estacion de transporte, tienen un color de fondo que representa el color del propietario.


