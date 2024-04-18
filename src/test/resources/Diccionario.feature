#language:es
# Podéis poner comentarios
# Este fichero se escribe en el lenguaje humano de vuestra preferencia.
# Gherkin solo son restricciones en el uso de un lenguaje natural (humano)

Característica: Componente Diccionario

  Antecedentes:
    Dado     que tengo un diccionario de idioma "es"

  Escenario: Preguntar por una palabra existente
    Cuando   le pregunto por la palabra "manzana"
    Entonces el diccionario me contesta que "si" existe

  Escenario: Preguntar por una palabra no existente
    Cuando   le pregunto por la palabra "mucjasnkfdkihj"
    Entonces el diccionario me contesta que "no" existe

  Esquema del escenario: Definiciones de palabras existentes
    Cuando   le pido los significados de la palabra "<palabra>"
    Entonces el diccionario me devuelve una lista con "<numeroSignificados>" significados
     Y       el primer significado es "<primerSignificado>"

    Ejemplos:
        | palabra | primerSignificado   | numeroSignificados |
        | perro   | Animal de compañía | 2                 |
        | manzana | Fruta del manzano  | 1                 |
        | Manzana | Fruta del manzano  | 1                 |
