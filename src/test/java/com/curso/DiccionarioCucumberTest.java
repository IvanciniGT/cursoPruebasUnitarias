package com.curso;

import io.cucumber.java.en.Given;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Suite
// Esta clase contiene una suite de prueba (un conjunto) de JUNIT
@IncludeEngines("cucumber")
// "cucumber" nos lo da la dependencia cucumber-junit-platform-engine
// qué motor de pruebas debe ejecutar las pruebas definidas en esta clase
@SelectClasspathResource("features") // Carpeta features
// Le indico a unit ficheros que debe pasar al motor de pruebas: CUCUMBER
public class DiccionarioCucumberTest {

    private Diccionario miDiccionario;
    private boolean existePalabra;
    private Optional<List<String>> significados;

    @Given("que tengo un diccionario de idioma {string}")
    public void que_tengo_un_diccionario_de_idioma(String idioma) {
        this.miDiccionario = SuministradorDeDiccionariosFactory.getInstance().getDiccionario("ES").get();
    }

    @Cuando("le pregunto por la palabra {string}")
    public void le_pregunto_por_la_palabra(String palabra) {
        this.existePalabra = miDiccionario.existe(palabra);
    }

    @Entonces("el diccionario me contesta que {string} existe")
    public void el_diccionario_me_contesta_que_existe(String siExiste) {
        assertEquals(siExiste.equalsIgnoreCase("si"), existePalabra);
    }

    @Cuando("le pido los significados de la palabra {string}")
    public void le_pido_los_significados_de_la_palabra(String palabra) {
        this.significados = miDiccionario.getDefiniciones(palabra);
    }

    @Entonces("el diccionario me devuelve una lista con {int} significados")
    public void el_diccionario_me_devuelve_una_lista_con_significados(int numeroSignificados) {
        assertTrue(significados.isPresent());
        assertEquals(numeroSignificados, significados.get().size());
    }

    @Entonces("el primer significado es {string}")
    public void el_primer_significado_es(String primerSignificado) {
        assertEquals(primerSignificado, significados.get().get(0));
    }

    @Entonces("el diccionario no me devuelve una lista")
    public void elDiccionarioNoMeDevuelveUnaLista() {
        assertFalse(significados.isPresent());
    }
}
