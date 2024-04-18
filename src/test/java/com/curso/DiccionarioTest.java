package com.curso;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioTest {

    private static Diccionario miDiccionario;

    @BeforeAll
    static void inicializarDiccionario(){
        DiccionarioTest.miDiccionario = SuministradorDeDiccionariosFactory.getInstance().getDiccionario("ES").get();
    }

    @ParameterizedTest
    @DisplayName("Preguntar por palabra existente")
    @ValueSource(strings = {"manzana", "Manzana", "MANZANA"}) // Contexto
    void preguntarPorPalabraExistente(String palabra) {
        // Acción
        boolean existe = miDiccionario.existe(palabra);
        // Comprobación
        assertTrue(existe);
    }
    @ParameterizedTest
    @DisplayName("Preguntar por palabra inexistente")
    @ValueSource(strings = {"federico", "marmota", "cenutrio"}) // Contexto
    void preguntarPorPalabraInexistente(String palabra) {
        // Acción
        boolean existe = miDiccionario.existe(palabra);
        // Comprobación
        assertFalse(existe);
    }
    @ParameterizedTest
    @DisplayName("Obtener significados de una palabra existente")
    @CsvSource({
            "manzana, Fruta del manzano, 1",
            "Manzana, Fruta del manzano, 1",
            "MANZANA, Fruta del manzano, 1",
            "Perro, Animal de compañía, 2"
    })
    void significadosDeUnaPalabraExistente(String palabra, String primerSignificado, int numeroDeSignificados){
        // Acción
        List<String> significados = miDiccionario.getDefiniciones(palabra).get();
        // Comprobación
        assertEquals(primerSignificado, significados.get(0));
        assertEquals(numeroDeSignificados, significados.size());
    }

    @ParameterizedTest
    @DisplayName("Obtener significados de una palabra existente")
    @CsvFileSource(resources = "/palabrasExistentes.csv", numLinesToSkip = 1)
    void significadosDeUnaPalabraExistente2(String palabra, String primerSignificado, int numeroDeSignificados){
        // Acción
        List<String> significados = miDiccionario.getDefiniciones(palabra).get();
        // Comprobación
        assertEquals(primerSignificado, significados.get(0));
        assertEquals(numeroDeSignificados, significados.size());
    }
}
