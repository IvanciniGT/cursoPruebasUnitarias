package com.curso;

// JUnit 4
// import org.junit.Test;
// import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Assertions;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// JUnit solo genera una instancia de la clase para todas las pruebas
    // SI PUEDO LO EVITO A TODA COSTA.
class AppTest {
    /* OJO
    *   AQUI NO DEFINO PRUEBAS
    *   AQUI DEFINO EL CONTEXTO DE LAS PRUEBAS
    *   O LIMPIEZA DE DATOS
    * */
    @BeforeEach // Se ejecuta antes de cada test
    void federico() {
        // Para limpiar datos... o cosas así.. inicializar valores
        // Inicializar mocks
        System.out.println("Antes de cada test");
    }
    @AfterEach  // Se ejecuta después de cada test
    void menchu() {
        System.out.println("Después de cada test");
    }
    // Estas funciones deben ser obligatoriamente (por defecto) estáticas...
    // lo que es una putada en algunos casos
    @BeforeAll
    static void beforeAll() {
        System.out.println("Antes de que inicien los tests");
    }
    @AfterAll
    void afterAll() { // Para poder hacer que estas 2 funciones: BeforeAll y AfterAll
                        // NO SEAN ESTÁTICAS, hay que añadir la anotación
                        // @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        System.out.println("Después de que acaben todos y cada uno de los test");
    }
    @Test
    @DisplayName("Primer Test")
    //@Order(2) // Para que se procese esas anotaciones, hay que indicar
    // A Junit que los métodos responden a una ordenación establecida manualmente
    // Para ello tenemos que añadir a la clase la anotación @TestMethodOrder
    // ESTO NO SE HACE !!!!
    // Si lo hago ME ESTOY CAGANDO EN EL PPO DE INDEPENDENCIA DE LOS TESTS: fIrst
    void primerTest() {
        System.out.println("PrimerTest");
    }

    @Test
    @DisplayName("Otro Test")
    //@Order(1)
    void otroTest() {
        System.out.println("OtroTest");
    }

    @Test
    @DisplayName("Sumar dos números positivos")
    void sumar2NumerosPositivos() {
        // Contexto
        double a = 2;
        double b = 3;
        double resultadoEsperado = 5;
        // Acción
        double resultado = App.sumar(a, b);
        // Comprobación
        //import org.junit.jupiter.api.Assertions;
        //Assertions.assertEquals(resultadoEsperado, resultado,0);
        assertEquals(resultadoEsperado, resultado,0);
    }

    @Test
    void sumar2NumerosNegativos() {
        // Contexto
        double a = -2;
        double b = -3;
        double resultadoEsperado = -5;
        // Acción
        double resultado = App.sumar(a, b);
        // Comprobación
        assertEquals(resultadoEsperado, resultado,0);
    }

    @Test
    void sumar2NumerosPositivosNegativos() {
        // Contexto
        double a = 2;
        double b = -3;
        double resultadoEsperado = -1;
        // Acción
        double resultado = App.sumar(a, b);
        // Comprobación
        assertEquals(resultadoEsperado, resultado,0);
    }
    @Test
    void sumar0() {
        // Contexto
        double a = 0;
        double b = 0;
        double resultadoEsperado = 0;
        // Acción
        double resultado = App.sumar(a, b);
        // Comprobación
        assertEquals(resultadoEsperado, resultado,0);
    }
    @Test
    void sumarCeroAPositivo() {
        // Contexto
        double a = 0;
        double b = 3;
        double resultadoEsperado = 3;
        // Acción
        double resultado = App.sumar(a, b);
        // Comprobación
        assertEquals(resultadoEsperado, resultado,0);
    }

    @Test
    void sumarCeroANegativo() {
        // Contexto
        double a = 0;
        double b = -3;
        double resultadoEsperado = -3;
        // Acción
        double resultado = App.sumar(a, b);
        // Comprobación
        assertEquals(resultadoEsperado, resultado,0);
    }
}
