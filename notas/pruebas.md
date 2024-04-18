# Qué es una Prueba unitaria?

Prueba que evalúa una pequeña parte del código para asegurar que cumple su funcionamiento.... una clase... un método...
Prueba sobre un fragmento del código que se hace paso a paso. La vamos corrigiendo hasta obtener el resultado.

---


# Pruebas de software

## Vocabulario en el mundo del testing

- Error     Los humanos cometemos errores. Y al cometer un error (por estar cansados, faltos de concentración, falta de conocimiento)
  introducimos un defecto en el producto.
- Defecto
- Fallo     Un fallo es la manifestación de un defecto al utilizar el producto. No todo defecto se manifiesta en un fallo.

## Para qué sirven las pruebas (de software)?

- Para asegurar el cumplimiento de unos requisitos (funcionales.. de rendimiento.. de estrés, de carga).
- Identificar la mayor cantidad posible de defecto en el producto antes de su paso a producción (de liberarlo)
  Para posteriormente subsanarlos.
  Puedo hacer 2 cosas:
    - Intentar provocar fallos al usar el producto... Una vez identificado un fallo hemos de buscar el defecto que lo ha provocado.
      El proceso de identificar el defecto que provoca un fallo en el mundo de la programación se denomina depuración debuging.
      Ésto (el debugging) tratamos de facilitarlo: *1
    - Buscar defectos directamente en el producto (REVISION)
- Tratar de recopilar la mayor cantidad posible de información para facilitar un rápido debugging. *1
- Para saber cómo va mi proyecto! *2
  Hoy en día, el grado de avance de un proyecto se determina por la cantidad de pruebas que han pasado con éxito en un periodo de tiempo.
- Para hacer un análisis de causas raíces, e identificar los ERRORES que originaron los defectos... para tomar acciones preventivas que eviten nuevos errores > defectos > fallos en el futuro.
- Obtener conocimiento / información del sistema... que poder aplicar a futuro.

RECOMENDACION: Leerse el syllabus de ISTQB: https://es.sstqb.com/_files/ugd/acfdb9_4fdeb98ce10240faab5b63a8fe7f51ac.pdf

## Tipos de pruebas

Toda prueba se centra en una única característica del producto... por qué? FACILITAR EL DEBUUGGING.
Si una prueba falla, quiero saber qué parte del producto es la que falla.
Si la prueba se centra en muchas características, no sabré qué parte del producto falla.

Las pruebas las puedo clasificar de distintas formas (en paralelo entre si):

### En base al objeto de prueba

- Funcionales       Se centran en requisitos funcionales.... el FUNCIONAMIENTO del producto.
- No funcionales:
    - UX (experiencia de usuario)
    - Rendimiento
    - Carga
    - Estrés
    - Seguridad
    - HA
    - ...

### En base al nivel de la prueba: SCOPE

- Unitarias         Prueba que se centra en una característica concreta/única (como toda prueba) de un componente AISLADO del producto.

  Quiero fabricar un TREN:
  Me llega el motor... qué hago con él? Lo monto en el chasis del tren... y lo sueldo o lo atornillo?
  Lo probaré... para ver si funciona.
  Y para probarlo, necesito un banco de pruebas(MOCK).... Un bastidor de hierro (4 hierros soldaos) para sujetarlo...
  Y una fuente de alimentación para darle corriente...Y meterle corriente y ver si gira: FUNCIONA
  Sistema de frenos
  Lo monto en un bastidor... le meto corriente y miro si las pinzas cierran.
  Ruedas
  Asientos
  Y los probaré... los atornillo a una estructura (MOCK)
  - UX. Es cómodo
  - Carga: Un tio de 150 Kgs está bien ahí... o se rompe?
  - Estrés: 500 personas sentandose al día... 365 días al año.. aguanta la tapicería?
  - Seguridad: Un tio sentao en una curva se va a tomar por culo?
  El haber hecho todas estas pruebas me garantiza que el tren funcionará? NO
  Eso si... gano confianza en el camino/producto/diseño... proyecto. VAMOS BIEN! +1 POWER !!!!

- Integración       Prueba que se centra en la COMUNICACION de 2 componentes del producto.

        SISTEMA DE FRENOS + RUEDA
         En el bastidor monto la rueda y el sistema de frenos.. con la rueda en medio de las pinza de freno.
         Le meto corriente y miro si la rueda se frena.
            Yo ya se que las rueda ruedan... y si les meto presión... se frenan
            Yo ya se que si al sistema de frenos le meto corriente las pinzas cierran.
            Cuando pongo todo junto lo que quiero comprobar es la COMUNICACION entre el sistema de frenos y la rueda.
                COÑO ! resulta que la rueda (o el disco de freno) es demasiado delgado y las pinzas, aunque cierran, no cierran lo suficiente para frenar la rueda.
                Las pinzas no llegan a COMUNICAR la energía de rozamiento al disco.

  El haber hecho todas estas pruebas me garantiza que el tren funcionará? NO
  Eso si... gano confianza en el camino/producto/diseño... proyecto. VAMOS BIEN! +1 POWER !!!!

- End2End(sistema)  Prueba el comportamiento del sistema en su conjunto
  Cojo el tren, lo pongo en la vía, le doy al PLAY... y va pa'trás... Que no va pa'lante! CAGADA ! RUINA GIGANTE !!
  Tengo un problema con el comportamiento del sistema en su conjunto.
    - Aceptación      Subconjunto de las pruebas de sistema.

      LA MISMA PRUEBA, dependiendo de las condiciones de ejecución puede ser unitaria, de integración, de sistema, de aceptación...
      El mismo CODIGO... la misma PRUEBA... la misma EJECUCION... puede ser de distintos niveles de prueba.
      Es más... a veces solo es cuestión de PERSPECTIVA !
      Para mi (Oh yo, fabricador del tren que compra un motor), el poner un motor en un bastidor y meterle corriente a ver si gira es una prueba UNITARIA.
      Y para él (fabricante del motor), el poner un motor en un bastidor y meterle corriente a ver si gira es una prueba SISTEMA.

### En base al conocimiento previo/interno del producto

- Caja blanca       Cuando conozco el código fuente.
- Caja negra        Cuando no conozco el código fuente.

### En base al procedimiento de ejecución

- Estáticas         Las que no necesitan ejecutar el código. REVISION (sonarqube)   ---->   Buscan defectos
- Dinámicas         Las que necesitan ejecutar el código                            ---->   Buscan fallos... y luego requieren de debugging.

Estamos malacostumbrados a relacionar bajo el concepto prueba unitaria a las pruebas dinámicas de caja blanca funcionales.
Pero una prueba unitaria puede ser de caja negra, de caja blanca, estática, dinámica, funcional, no funcional,...

> EJEMPLO 1: REQUISITO: No funcional de rendimiento.
El sistema debe dar unos tiempos de respuesta adecuados al usuario. PM de requisito. TOTALMENTE AMBIGUO. Lo puedo comprobar?
Puedo hacer una prueba para este requisito? NO ES AMBIGUO.
> EJEMPLO MEJORADO:
El sistema debe responder en menos de 100ms a las peticiones de los usuarios. IGUAL DE MIERDA.
> CASO REAL DE REQUISITO... lo que debe ser: REQUISITO NO FUNCIONAL DE RENDIMIENTO. NIVEL: ACEPTACION = SISTEMA
El sistema montado en un entorno con tal configuración de hardware debe ofrecer cuando está siendo sometido a X carga de trabajo el 95% de las peticiones en menos de 100ms (Percetil 95%) = GUAY !
Y si miro el tiempo medio de latencia de red en ir a la BBDD: RENDIMIENTO / UNITARIA : 50ms
---

# Metodologías ágiles

## Cuál es la característica principal de las metodologías ágiles?

Hacer una entrega incremental del producto.

# Uno de los puntos del manifiesto ágil es:

> El software funcionando es la MEDIDA principal de progreso. -> Esto define un indicador para un cuadro de mando. *2

la MEDIDA principal de progreso es el "software funcionando"
Cómo mido (que voy a usar para medir) el grado de avance (progreso) en un proyecto de software? SOFTWARE FUNCIONANDO

Software funcionado: Software que cumple con los requisitos que se le han definido.

Quién dice que el software funciona, es decir, que cumple con los requisitos que se le han definido? LAS PRUEBAS !!!!

HITO 1
Conjunto de requisitos que debían implementarse     R1, R2, R3, R7, R14
Fecha                                               10-Junio        ------> 15-Junio VAMOS CON RETRASO.
HITO 2
Conjunto de requisitos que debían implementarse     R4, R5, R6, R8, R9
Fecha                                               20-Junio

SPRINT1
Conjunto de requisitos que debían implementarse     R1, R2, R3, R7, R14.        R7---> Se pasa a la siguiente iteración.
Fecha                                               10-Junio


Sprint 1    R1, R2, R3      10% funcionalidad del sistema
  Pruebas R1, R2, R3, 10% de la funcionalidad
Sprint 2   R4, R5, R6       +8% de la funcionalidad
  Pruebas R4, R5, R6    8% de la funcionalidad
  He tocado código... puedo haber jodido lo que estaba:
  Pruebas R1, R2, R3, 10% de la funcionalidad   *** Las pruebas de arriba se han convertido en pruebas DE REGRESIÓN
  EN TOTAL PRUEBO el 18% de la funcionalidad
Spring 3    R7, R8, R9      +7% de la funcionalidad
  Pruebas R7, R8, R9    7% de la funcionalidad
  Pruebas R1, R2, R3, 10% de la funcionalidad
  Pruebas R4, R5, R6    8% de la funcionalidad
  EN TOTAL PRUEBO el 25% de la funcionalidad







---
# DEV--->OPS

Es una cultura, una filosofía, un movimiento...en pro de la AUTOMATIZACION.

Hay distintos pasos /Actividades que puedo hacer en pro de automatizar trabajo en el mundo de IT.
- Puedo montar un pipeline de CI: Integración continua.
- Puedo montar un pipeline de CD: Entrega continuo.
- Puedo montar un pipeline de CD: Despliegue continuo.

# Integración continua

Tener CONTINUAmente la última versión del código que han hecho los desarrolladores instalada en el entorno de INTEGRACION, sometida a pruebas automatizadas.
Cual es el producto de un proceso de integración continua: INFORME DE PRUEBAS en tiempo real *2

- Entorno de desarrollo
- Entorno de pruebas, testing,Q&A (ENTORNO DE INTEGRACION)
- Entorno de producción

--- 
# JUNIT

Framework de pruebas.

----

## JAVA

En los albores de los 2000 todo el mundo quería aprender JAVA... y todo se hacía en JAVA.
App web: JAVA
App de escritorio: JAVA (SWING)
Software embebido: JAVA (J2ME)
Android: JAVA

Hoy en día
Apps web:
FrontEnd: El html se genera en cliente : JAVASCRIPT
Backend: Servicios REST JAVA: Spring/Springboot
Android: Kotlin
Escritorio: C# / VB / JS (NODE es la JVM de JS)
Software embebido: C / C++ / Python

## SOLID

5 principios para desarrollar software fácil de mantener, fácil de extender, fácil de probar.

    S - Single Responsability Principle
    O - Open/Closed Principle
    L - Liskov Substitution Principle
    I - Interface Segregation Principle
    D - Dependency Inversion Principle ** CRUCIAL PARA PODER HACER PRUEBAS UNITARIAS

## Principio de inversión de la dependencia

Los módulos de alto nivel (app consola) no deberían depender de implementaciones de módulos de bajo nivel (implementación del diccionario).
Ambos deberían depender de abstracciones (diccionario-api)

## Spring

Es un contenedor de Inversión de control para JAVA.

## Contenedor de inversión de control:

Un framework que al que delego el control del flujo de mi aplicación... en lugar de ser yo el que controle el flujo de mi aplicación.
Para que? Para facilitar la inyección de dependencias.... y por ende respetar el principio de inversión de dependencias.

## PATRON DE DISEÑO: Inyección de dependencias

Es un patrón de diseño por el que las clases no crean los objetos que necesitan... sino que le son suministrados.
Al aplicar este patrón, respeto el principio de inversión de la dependencia.
Hay otros patrones que nos ayudan: Factory, Singleton, Facade.

# App que por consola me pida una palabra, y un idioma y me de si la palabra existe en el diccionario de ese idioma y sus definiciones.

1º Cuantos repos de git...y cuantos pom.xml (proyectos de maven) voy a tener?

x 1 repo de git y 1 pom.xml RUINA... si estuviera haciendo software como hace 20 años.. colaría (SISTEMA MONOLITICO que no hay un dios que lo mantenga en el tiempo)
√ 3 repos de git y 3 pom.xml

## FRONTAL (app consola)

import com.diccionarios.api.SuministradorDeDiccionarios;
import com.diccionarios.api.Diccionario;
//import com.diccionarios.fichero.SuministradorDeDiccionariosDesdeFichero; // LA ACABO DE GACAR!
// HE DESTROZADO LA MANTENIBILIDAD DEL SISTEMA ESTE IMPORT DESTROZA EL SISTEMA
// ME ACABO DE CAGAR EN EL TIO BOB y en el PP de inversión de dependencias
AHce que en el pom.xml del proyecto tenga:
<dependency>
<groupId>com.diccionarios</groupId>
<artifactId>diccionario-fichero</artifactId>
<version>1.0.0</version>
</dependency>
<dependency>
<groupId>com.diccionarios</groupId>
<artifactId>diccionario-api</artifactId>
<version>1.0.0</version>
</dependency>

public class App {

    ...

    private void procesarPeticion(String idioma, String palabra, SuministradorDeDiccionarios suministrador){
        // ... Mierdas de UI
        //SuministradorDeDiccionarios suministrador = new SuministradorDeDiccionariosDesdeFichero();
        Optional<Diccionario> diccionario = suministrador.getDiccionario(idioma);
        if(diccionario.isPresent()){
            Diccionario diccionario = diccionario.get();
            if(diccionario.existe(palabra)){
                Optional<List<String>> definiciones = diccionario.getDefiniciones(palabra);
                // Las muestro por pantalla
            } else {
                // Digo que no existe
            }
        } else {
            // Digo que no tengo diccionarios de ese idioma.
        }
    }

}

## API de comunicación entre ellos: API de la librería de diccionarios
El conjunto de métodos, interfaces, tipos, enumeraciones... para comunicar con la librería de diccionarios.
package com.diccionarios.api;
public interface Diccionario{
String getIdioma();                                 // Me faltaba
boolean existe(String palabra);                     
List<String> getDefiniciones(String palabra);       // ES UNA MIERDA... otra que el sonar me escupe a la cara!
Si hay alguien en el curso que me pueda explicar el comportamiento de esta función SE PUEDE IR.. no tengo nada que enseñarle.
Tengo un diccionario de Español guay. Le pido "manzana": Devuelve una lista con ["Fruto del manzano","..."]
Y si le pido "archilococo"... devuelve? NPI
- Lista vacía   \   (MIRO EL CODIGO? LEO DOCUMENTACION?)
- NULL          / Son ambiguas. Viendo la signatura (definición) de la función, no tengo npi de como responde.
- Excepción     Tiene una cosa guay: No es ambiguo en JAVA (throws NotSuchWordException)
- Las excepciones son caras de cojones! [Me obliga a hacer un volcado de la pila de hilos Del threadStack] LAS DEBO USAR PARA EXCEPCIONES. COSAS QUE NO SE SI VAN A OCURRIR HASTA QUE LO INTENTO.
En JAVA 1,8 aparece la clase Optional<T> Para evitar estos usos PATETICOS del lenguaje.
Optional<List<String>> getDefiniciones(String palabra);       // ME quita la ambigûedad
}

    public interface SuministradorDeDiccionarios {
        boolean tienesDiccionarioDe(String idioma);         // Case Insensitive
        Optional<Diccionario> getDiccionario(String idioma);          // Case Insensitive
    }
    * NOTA
    * Desde JAVA 1.8 esta considerado una MUY MUY MUY MUY ...... y así 100 veces... MUY mala práctica que una función devuelva NULL.
    * NO SE HACE... Es como pegar a un padre con un calcetín sudao!

    PRUEBAS:
    # PRUEBAS DE SISTEMA: Por definición. Las pruebas de un API siempre son DE SISTEMA. Las montaré con JUNIT.
        # PRUEBA 1
            ESCENARIO: Dado que tengo un suministrador de diccionarios que sé que tiene diccionarios de idioma español.
            ACCION: Cuando le pregunto si tiene un diccionario de Español
            COMPRUEBO RESULTADO: Entonces debe contestar que sí.
                Suministrador miSuministrador = ...;
                boolean resultado = miSuministrador.tienesDiccionarioDe("es");
                assertTrue(resultado);
        # PRUEBA 2
            ESCENARIO: Dado que tengo un suministrador de diccionarios que sé que no tiene diccionarios de "idioma de los elfos"
            ACCION: Cuando le pregunto si tiene un diccionario de "idioma de los elfos"
            COMPRUEBO RESULTADO: Entonces debe contestar que no.
                Suministrador miSuministrador = ...;
                boolean resultado = miSuministrador.tienesDiccionarioDe("idioma de los elfos");
                assertFalse(resultado);

        # PRUEBA 3
            ESCENARIO: Dado que tengo un suministrador de diccionarios que sé que tiene diccionarios de idioma español.
            ACCION: Cuando le pido el diccionario de Español
            COMPRUEBO RESULTADO: Entonces me devuelve el Diccionario de Español.
                Suministrador miSuministrador = ...;
                Optional<Diccionario> miDiccionario = miSuministrador.dameDiccionarioDe("es");
                //assertNotNull(miDiccionario);       // Esto, desde JAVA 1.8 ES UNA PM
                                                    // El sonarqube me tira el código a la cara!
                arrestNotEmpty(miDiccionario);      // Esto es lo que me dice el sonarqube que debo hacer.
                assertEquals("es", miDiccionario.get().getIdioma());

        # PRUEBA 4
            ESCENARIO: Dado que tengo un suministrador de diccionarios que sé que tiene diccionarios de idioma español.
            ACCION: Cuando le pido el diccionario de Español
            COMPRUEBO RESULTADO: Entonces me devuelve el Diccionario de Español.
                Suministrador miSuministrador = ...;
                Diccionario miDiccionario = miSuministrador.dameDiccionarioDe("ES");
                assertNotNull(miDiccionario);
                assertEquals("es", miDiccionario.getIdioma().toLowerCase());

        2 tristes interfaces con 3 métodos -> diccionario-api.jar

## BACKEND (librería diccionarios)
De hecho podría tener 3 implementaciones de la librería:
- Una busca las palabras en una BBDD
- Otra en ficheros de texto
- Otra los pregunta al servicio web de la rae

  package com.diccionarios.fichero;

  import com.diccionarios.api.Diccionario;
  import com.diccionarios.api.SuministradorDeDiccionarios;

  public class DiccionarioDesdeFichero implements Diccionario{
  public String getIdioma(){ ... }
  public boolean existe(String palabra){ ... }
  public List<String> getDefiniciones(String palabra){ ... }
  }

  public class SuministradorDeDiccionariosDesdeFichero implements SuministradorDeDiccionarios{
  public boolean tienesDiccionarioDe(String idioma){ ... }
  public Optional<Diccionario> getDiccionario(String idioma){ ... }
  }

  2 tristes fichero... y alguno más de utilidades a otro .jar-> diccionario-fichero.jar
  Y ES QUE EL PROYECTO diccionario-ficheros tiene dependencia de diccionario-api.jar
  Es decir.. en el pom.xml del proyecto tendré:
  <dependency>
  <groupId>com.diccionarios</groupId>
  <artifactId>diccionario-api</artifactId>
  <version>1.0.0</version>
  </dependency>
---


## Diseñar un sistema que vamos a montar... OS DARE YO EL CODIGO: Microservicio REST con Springboot

App Web que permita el alta de personas en una BBDD.

Componentes?

JS - WebComponent
<formulario-usuario></formulario-usuario> No la conocéis porque no existe
Pero la puedo crear... esa marca HTML... y asociarle una representación gráfica... y un comportamiento (lógica)

                    ESTO ES UN BUEN DISEÑO DE SISTEMA, que respeta el Principio de Responsabilidad única.

                                FRONTAL                             BACKEND
                    --------------------------------------       ------------------------------------------------------
                    Formulario WEB   >>  Servicio FrontEnd    >>    Controlador REST   >> Servicio    >> Repository   >> BBDD
RESPONSABILIDAD     recoger              comunicación b.end         capturar peticiones   lógica         gestionar      persistir
datos de usuario                                http                  negocio        persistencia
validos                                                                     
altaUsuario(DatosDeNuevoUsuario)
1º Persistir la info
2º Enviar un email

                                                                                         EmailsService
                                                                                            mandarEmail()

                                                                    ^ PRUEBA UNITARIA?
                                                                        A priori no... porque tiene una rueda en medio de las pinzas
                                                                        Si la prueba falla, no tengo npi de que falla...
                                                                            si el código del controlador o el del servicio o el del repository o el de la BBDD
                                                                        Puedo hacerla... pero debo aislar al componente
                                                                            Le monto en el banco de pruebas (MOCK) y le meto corriente... y veo si gira.

    ServicioPersonas >>> Repositorio
                     >>> ServicioEmails

        Puedo hacerla prueba unitaria? SI... si corto las comunicaciones con el exterior: Repositorio y ServicioEmails
        Y una vez hechas, haré pruebas de integración. CUANTAS para la función alta de usuario? 2
            Una cortando comunicaciones con el repo, para mirar la interacción con el servicio de emails
            Otra cortando comunicaciones con el servicio de emails, para mirar la interacción con el repo.
        Y una vez hechas, haré pruebas de sistema. CUANTAS para la función alta de usuario? 1
            Poniendo el sistema en su conjunto : Servicio de Emails de verdad de la buena y el repo de verdad de la buena... y la bbdd de verdad de la buena.
            El sistema en su conjunto!









# Principios FIRST de pruebas de software
F - Fast
I - Independent
R - Repeatable
S - Self-validating : Comprueba TODO lo que debe ocurrir al desencadenar una acción
T - Timely: Oportunas. De nada me vale una prueba unitaria, si ya tengo el sistema funcionando y no me aporta nada.


# Test doubles

## Ejemplo: Pruebas a nuestra app de palabras y diccionarios por consola

Proyecto 1: App consola (frontal, que pregunta a un back por palabras y definiciones)
1 clase
PRUEBAS: Unitarias: SIEMPRE que hay código!
Integración: CLARO... con quién? Con el back! con la implementación del API.
Sistema: SI... pero... en este caso, las pruebas de sistema son = a las de integración.
FRONTAL > BACK
Proyecto 2: Api de una librería de diccionarios
2 interfaces
PRUEBAS: De sistema
Proyecto 3: Implementación de la librería para trabajar con ficheros.
2 clases
PRUEBAS: Unitarias, para sus funciones
Integración?... NO... La librería es autónoma.. no se integra con nadie. No llama a un microservicio.. ni a una BBDD
Sistema? .... SI... pero NO.... Quiero decir... YA ESTÁN HECHAS... SON LAS DEL API!

```java
public class AppConsola {
    public static void main(String[] args){

        // Bienvenida a la app
        System.out.println("Bienvenido a la app de diccionarios");
        // Capturo el primer argumento (idioma) y el segundo (palabra) y me aseguro que están guay
        if(args.length != 2){
            System.out.println("Uso: java -jar app.jar <idioma> <palabra>");
            System.exit(1);
        }
        String idioma = args[0];
        String palabra = args[1];
        validarPalabra(palabra);
        // Obtengo un suministrador de diccionarios desde el ServiceLoader (Inyección de dependencias)
        SuministradorDeDiccionarios suministrador = ServiceLoader.load(SuministradorDeDiccionarios.class)
                                                                 .findFirst()
                                                                 .orElseThrow(
                                                                    () -> new RuntimeException("No hay suministrador de diccionarios")
                                                                 );
        // Proceso la petición
        procesarPeticion(idioma, palabra, suministrador);
        // Despedida
        System.out.println("Gracias por usar la app de diccionarios");
    }
    private static void validarPalabra(String palabra){
        if(palabra == null || palabra.trim().isEmpty()){
            System.out.println("La palabra no puede ser nula ni vacía");
            System.exit(1);
        }
        // Que cumpla con una regex.. solo letras mayúsculas y minúsculas
        if(!palabra.matches("[a-zA-Z]+")){
            System.out.println("La palabra solo puede contener letras");
            System.exit(1);
        }
    }
    private static void procesarPeticion(String idioma, String palabra, SuministradorDeDiccionarios suministrador){
        Optional<Diccionario> diccionario = suministrador.getDiccionario(idioma);
        if(diccionario.isPresent()){
            Diccionario diccionario = diccionario.get();
            if(diccionario.existe(palabra)){
                Optional<List<String>> definiciones = diccionario.getDefiniciones(palabra);
                if(definiciones.isPresent()){
                    System.out.println("Definiciones de la palabra " + palabra + " en " + idioma);
                    definiciones.get().forEach(System.out::println);
                } else {
                    System.out.println("No hay definiciones para la palabra " + palabra + " en " + idioma);
                }
            } else {
                System.out.println("La palabra " + palabra + " no existe en el diccionario de " + idioma);
            }
        } else {
            System.out.println("No hay diccionario de " + idioma);
        }
    }
    // Si lo hubiera implementado ASI vvvvvv ¿Cómo le hago una prueba unitaria? NO PUEDO, ES IMPOSIBLE POR DEFINICION.
                                                        // Acaso soy capaz de aislar a este componente de la implemenatción REAL de la librería de diccionarios?
    private static void procesarPeticion(String idioma, String palabra){
        SuministradorDeDiccionarios suministrador = new SuministradorDeDiccionariosDesdeFichero(); // AQUI ESTA DEFINIDO QUE SIEMPRE USE LA REAL.
                            // No hay huevos a hacer una prueba unitaria: POR DEFINICION.
                            // Y por mal diseño del sistema... donde tengo componentes acoplados rígidamente.
        Optional<Diccionario> diccionario = suministrador.getDiccionario(idioma);
        if(diccionario.isPresent()){
            Diccionario diccionario = diccionario.get();
            if(diccionario.existe(palabra)){
                Optional<List<String>> definiciones = diccionario.getDefiniciones(palabra);
                if(definiciones.isPresent()){
                    System.out.println("Definiciones de la palabra " + palabra + " en " + idioma);
                    definiciones.get().forEach(System.out::println);
                } else {
                    System.out.println("No hay definiciones para la palabra " + palabra + " en " + idioma);
                }
            } else {
                System.out.println("La palabra " + palabra + " no existe en el diccionario de " + idioma);
            }
        } else {
            System.out.println("No hay diccionario de " + idioma);
        }
    }
}
```
### PRUEBAS **UNITARIAS** A LA APP DE CONSOLA:
#### PRUEBA 1. Soy un capullo y no paso a la app argumentos
#### PRUEBA 2. Soy un capullo y paso 1 argumento
#### PRUEBA 3. Soy un capullo y paso una palabra de mierda

Para hacer estas pruebas... hasta aquí, necesito una implementación de la interfaz SuministradorDeDiccionarios? NO

#### PRUEBA 4. Paso un idioma que no existe
    procesarPeticion("de los elfos", "XXXX", suministrador);
    Aquí necesito un suministrador. Lo tengo? Me da igual... si lo hay no lo uso. ES UNA PRUEBA UNITARIA (AISLADO, SIN INTEGRACIONES con componentes reales).
    Pero tengo que pasa algo? Me monto un suministrador de Mentirijilla! = BANCO DE PRUEBAS (MOCK)

    ```java
    public class SuministradorDeDiccionariosDeMierda implements SuministradorDeDiccionarios{ 
        public boolean tienesDiccionarioDe(String idioma){ return false; }
        public Optional<Diccionario> getDiccionario(String idioma){ return Optional.empty(); }
    }
    ```
    ESTO SE LLAMA UN STUB
        Un Stub es una implementación de un código que hago para poder hacer una prueba.. Y que luego va a la puñetera basura. No forma parte del código principal del proyecto. No pasa a producción
        Los Stub ofrecen una implementación rígida de una interfaz... Contestan siempre un valor predefinido.

        Igual que para probar el motor de un tren, aisladamente, necesitaba montar un bastidor con 4 hierros solados...
            Que luego no es parte del tren. se tira a la basura.
    
    Uso este y ya no uso el REAL!. ESTE que he creado puede fallar? NO... no hay nada de código ahí!!! es más simple que el mecanismo del chupete!

#### PRUEBA 5. Paso un idioma que si existe y una palabra que no existe

    ```java
    public class SuministradorDeDiccionariosDeMierda2 implements SuministradorDeDiccionarios{
        public boolean tienesDiccionarioDe(String idioma){ return true; }
        public Optional<Diccionario> getDiccionario(final String idioma){ 
            return new Optional<Diccionario>(){
                public Diccionario get(){
                    return new Diccionario(){
                        public String getIdioma(){ return idioma; }
                        public boolean existe(String palabra){ return false; }
                        public Optional<List<String>> getDefiniciones(String palabra){ return Optional.empty(); }
                    };
                }
            };
         }
    }
    ```
    @Test
    void probarPalabraQueNoExiste(){
        // Capturo la salida por consola
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        procesarPeticion("es", "XXXX", new SuministradorDeDiccionariosDeMierda2());
        // Compruebo que la salida por consola es "La palabra XXXX no existe en el diccionario de es"
        assertEquals("La palabra XXXX no existe en el diccionario de es", salida.toString().trim());
    }
    OJO... en lugar de un STUB... podría haber devuelto un FAKE
#### PRUEBA 6. Paso un idioma que si existe y una palabra que si existe


    ```java
    public class SuministradorDeDiccionariosGuayDeMierda implements SuministradorDeDiccionarios{ // STUB
        public boolean tienesDiccionarioDe(String idioma){ return idioma.equalsIgnoreCase("ES"); }
        public Optional<Diccionario> getDiccionario(final String idioma){ 
            return new Optional<Diccionario>(){
                public Diccionario get(){
                    return new Diccionario(){
                        public String getIdioma(){ return idioma; }
                        public boolean existe(String palabra){ return palabra.equalsIgnoreCase("manzana"); }
                        public Optional<List<String>> getDefiniciones(String palabra){ 
                            return palabra.equalsIgnoreCase("manzana")? 
                                Optional.of(Arrays.asList("Fruto del manzano")) :
                                Optional.empty(); 
                        }
                    };
                }
            };
         }
    }
    @Test
    void probarPalabraQueExiste(){
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        procesarPeticion("es", "manzana", new SuministradorDeDiccionariosGuayDeMierda());
        assertEquals("Definiciones de la palabra manzana en es\nFruto del manzano", salida.toString().trim());
    }
    ```
    El FAKE es como un stub... pero con más logica dentro para contemplar varios escenarios... ES REUTILIZABLE

    ```java
    public class SuministradorDeDiccionariosGuayDeMierda implements SuministradorDeDiccionarios{ // FAKE
        public boolean tienesDiccionarioDe(String idioma){ return idioma.equalsIgnoreCase("ES")||idioma.equalsIgnoreCase("EN"); }
        public Optional<Diccionario> getDiccionario(final String idioma){ 
            return new Optional<Diccionario>(){
                public Diccionario get(){
                    return new Diccionario(){
                        public String getIdioma(){ return idioma; }
                        public boolean existe(String palabra){ return palabra.equalsIgnoreCase("manzana") && idioma.equalsIgnoreCase("ES") || palabra.equalsIgnoreCase("apple") && idioma.equalsIgnoreCase("EN"); }
                        public Optional<List<String>> getDefiniciones(String palabra){ 
                            if(palabra.equalsIgnoreCase("manzana") && idioma.equalsIgnoreCase("ES")){
                                return Optional.of(Arrays.asList("Fruto del manzano"));
                            } else if(palabra.equalsIgnoreCase("apple") && idioma.equalsIgnoreCase("EN")){
                                return Optional.of(Arrays.asList("Frui of the apple tree"));
                            } else {
                                return Optional.empty();
                            }
                        }
                    };
                }
            };
         }
    }
    ```

    SI AL FAKE le empiezo a meter lógica... y más lógica... y más lógica se acaba convirtiendo en la implementación REAL...



### Pruebas de Integracion

    @Test
    void probarPalabraQueNoExisteIntegracion(){ // STUB
        // Capturo la salida por consola
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        procesarPeticion("es", "archilococo", new SuministradorDeDiccionariosDesdeFichero());
        // Compruebo que la salida por consola es "La palabra XXXX no existe en el diccionario de es"
        assertEquals("La palabra archilococo no existe en el diccionario de es", salida.toString().trim());
    }

---
SonarQube cuando analiza un código ofrece ciertas métricas de él.
- Complejidad ciclomática? ES UN NUMERO ABSOLUTO, CALCULABRE. Toda funcion tiene su complejidad ciclomática.
  Es el número de camnimos que puede tomar una función al ejecutarse
  Al menos necesito hacer una prueba unitaria de cada camino.
- Complejidad cognitiva?   Como de complejo es para un ser humano entender un código.
  Si tengo funciones con muchos if anidados, condiciones de if complejas, bucles anidados... la complejidad cognitiva es alta.




---

## Microservicios


    public interface PersonasRepository{
        long guardar(DatosDeNuevaPersona datos);
    }
    public interface EmailsService{
        void enviarEmail(String email, String mensaje);
    }

    public class PersonasService{

        public long altaPersona(DatosDeNuevaPersona datos, PersonasRepository repo, EmailsService emailService){
            // 1º Validar los datos
                // METERE UNOS CUANTOS IF
            // 2º Persistir los datos
                // Llamare a un REPOSITOPRIO para que guarde los datos
                long id=repo.guardar(datos);
            // 3º Solicitar el envio de un email
                // Llamare a un SERVICIO DE EMAILS para que envie un email
                //emailService.enviarEmail(datos.getEmail(), "Bienvenido a la app");
            return id;
        }
    }

## Prueba unitaria:
Necesito aislar al componente de: PersonasRepository y EmailsService

    public class PersonasRepositoryStub implements PersonasRepository{
        public long guardar(DatosDeNuevaPersona datos){ return 3930948757393947583938475; }
    }
    public class EmailsServiceSpy implements EmailsService{
        public String email=null;
        public String mensaje=null;
        public void enviarEmail(String email, String mensaje){
            this.email=email;
            this.mensaje=mensaje;
        }
    }
    public class EmailsServiceMock implements EmailsService{
        public boolean meHanLlamado=false;
        private String email=null;
        private String mensaje=null;
        public EmailsServiceMock(String email, String mensaje){
            this.email=email;
            this.mensaje=mensaje;
        }
            
        public void enviarEmail(String email, String mensaje){
            if(!email.equals(this.email)) throws new RuntimeException("El email no es el esperado");
            if(!mensaje.equals(this.mensaje)) throws new RuntimeException("El mensaje no es el esperado");
            meHanLlamado=true;
        }
    }

    public class EmailsServiceDummy implements EmailsService{
        public void enviarEmail(String email, String mensaje){ }
    }

    Llamo a la función, con los datos de una persona guay... y se que tiene que devolver 33. Si no devuelve 33 es que está mal el código.
        DatosDeNuevaPersona misDatos = new DatosDeNuevaPersona("Federico", "fede@rico.es", "102928373");

        EmailsServiceSpy emailServiceSpy = new EmailsServiceSpy();
        long respuesta = altaPersona(misDatos, new PersonasRepositoryStub(),emailServiceSpy );
        assertEquals(3930948757393947583938475, respuesta);
        assertEquals("fede@rico.es", emailServiceSpy.email);
        assertEquals("Bienvenido a la app", emailServiceSpy.mensaje);

        EmailsServiceMock emailServiceMock = new EmailsServiceMock( "fede@rico.es", "Bienvenido a la app");
        long respuesta = altaPersona(misDatos, new PersonasRepositoryStub(),emailServiceMock );
        assertEquals(3930948757393947583938475, respuesta);
        assertTrue(emailServiceMock.meHanLlamado);

        EmailsServiceDummy emailServiceDummy = new EmailsServiceDummy(); // Los dummies los uso en pruebas de integración y sistema... para que las pruebas vayan más rápido

        long respuesta = altaPersona(misDatos, repoDeVerdad ,emailServiceDummy ); // Integración entre el servicio de personas y el repo REAL de personas
        assertEquals(3930948757393947583938475, respuesta);
        


    // En el sistema real.. en algun sitio se hará algo como:
        long respuesta=altaPersona(misDatos, repoDeVerdadDeLaBuena, emailsServiceDeVerdadDeLaBuena);

---







Dobles de pruebas: Mal llamados por muchos Mocks... Culpa del gran y maravillo framework de test-doubles que existe en java: Mockito:
- Stubs: Es una implementación que devuelve valores fijos
- Fakes: Es una implementación que devuelve valores fijos acordes a una mini-lógica
- Spies: Es una implementación que no devuelve nada... pero que anota la llamada a sus métodos para posteriormente poder comprobar que se han llamado.
- Mocks: Es una versión más evolucionada de un Spy... Donde la lógica de validación la hace el propio mock... y no el test.
- Dummies: Es la mínima implementación que se puede hacer de una interfaz

En muchas ocasiones nos ponemos como benditos a escribir este tipo de objetos (estas clases)... son muy sencillas... o muy complejas... y me las curro.
En la mayoria de escenarios, intentaré usar un Mockeador: como Mockito... que me permite hacer esto de forma automática.


Metodología de desarrollo de SOFTWARE: Test-First, TDD, BDD, ATDD

# Test-First

Diseño primero las pruebas y luego el código... y al final ejecuto las pruebas.

# TDD: Test Driven Development

Test-First + Refactorización en cada iteración

REFACTORIZACION: La refactorización es una técnica de la ingeniería de software para reestructurar un código fuente, alterando su estructura interna sin cambiar su comportamiento externo.

--- 
# De cara a definir pruebas

Siempre:
- Planteo un escenario          GIVEN
- Ejecuto una acción            WHEN
- Compruebo el resultado        THEN    <- ASERCIONES (Asserts)

----
# QUE ES MAVEN?
Es una herramienta de AUTOMATIZACION de trabajo habituales en un projecto java:
- Compilación
- Empaquetado
- Ejecutar las pruebas
- Generar el javadoc
- Mandarlo a git
- Mandarlo al sonar
- Meterlo en una imagen de contenedor
- Gestionar dependencias

---


Eclipse  \   Que llamen a JUnit > Instancie mi clase de pruebas e invoque todos los metodos que tengan la anotación @Test
IntelliJ /

Mientras trabajo en el día a día... es cómodo.
Pero antes de entregar, he de asegurarme que MAVEN también lo hace.

Eclipse o IntelliJ
v
Maven > Plugin Surefire > Junit > Instancie mi clase de pruebas e invoque todos los metodos que tengan la anotación @Test

---

# Versiones de software

1.2.3

            Cuando cambian?
1: MAJOR    Breaking changes (Cambios que no respetan retrocompatibilidad)
Básicamente si se quitan cosas del API
2: MINOR    Nueva funcionalidad retrocompatible
Métodos marcados como obsoletos (deprecated)
+ Pueden venir bugs arreglados
+ También pueden venir nuevos bugs
3: PATCH    Arreglos de bugs