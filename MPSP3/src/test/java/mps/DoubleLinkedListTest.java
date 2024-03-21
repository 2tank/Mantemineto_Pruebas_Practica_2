package mps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.beans.Transient;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    DoubleLinkedList<Object> list;

    @Nested
    @DisplayName("Cuando se crea la DoubleLinkedList")
    class WhenNew{

        @BeforeEach
        void createNewDoubleLinkedList(){
            list = new DoubleLinkedList<>();
        }
        @Test
        @DisplayName("Anyadir un elemento al comienzo de la lista (hacer un prepend)")
        void anyadirElementoAPrimeraPosicionConListaVacia(){

            list.prepend(12);
            Object resultado = 12;
            Object valorObtenido = list.first();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Anyadir un elemento al final de la lista (hacer un apend)")
        void anyadirElementoAUltimaPosicionConListaVacia(){

            list.append(12);
            Object resultado = 12;
            Object valorObtenido = list.last();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Anyadir un elemento al comienzo de la lista debe ser igual que el elemento final")
        void anyadirElementoAPrimeraPosicionIgualQueUltimaPosicion(){

            list.prepend(12);
            Object valorObtenidoPrimeraPosicion = list.first();
            Object valorObtenidoUltimaPosicion = list.last();
            assertEquals(valorObtenidoUltimaPosicion,valorObtenidoPrimeraPosicion);
        }

        @Test
        @DisplayName("Anyadir un elemento al final de la lista debe ser igual que el elemento primero")
        void anyadirElementoAUltimaPosicionIgualQuePrimeraPosicion(){

            list.append(12);
            Object valorObtenidoPrimeraPosicion = list.first();
            Object valorObtenidoUltimaPosicion = list.last();
            assertEquals(valorObtenidoUltimaPosicion,valorObtenidoPrimeraPosicion);
        }

        @Test
        @DisplayName("Obtener tamanyo de la lista")
        void obtenerTamanyoListaVacia(){

            int resultado = 0;
            int valorObtenido = list.size();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Eliminar el primer elemento de una lista vacia es incorrecto")
        void eliminarPrimerElementoListaVacia(){

            assertThrows(RuntimeException.class,()->{
                list.deleteFirst();
            });
        }

        @Test
        @DisplayName("Eliminar el ultimo elemento de una lista vacia es incorrecto")
        void eliminarUltimoElementoListaVacia(){

            assertThrows(RuntimeException.class,()->{
                list.deleteLast();
            });
        }

        @Test
        @DisplayName("Acceder al primer elemento de una lista vacia es incorrecto")
        void obtenerPrimerElementoListaVaciaEsIncorrecto(){

            assertThrows(RuntimeException.class,()->{
                list.first();
            });

        }

        @Test
        @DisplayName("Acceder al ultimo elemento de una lista vacia es incorrecto")
        void obtenerUltimoElementoListaVaciaEsIncorrecto(){

            assertThrows(RuntimeException.class,()->{
                list.last();
            });

        }
    }

    @Nested
    @DisplayName("Cuando se crea la DoubleLinkedList y se añade un elemento")
    class WhenNotNew{

        @BeforeEach
        void createNewDoubleLinkedList(){
            list = new DoubleLinkedList<>();
            list.append(12);
        }

        @Test
        @DisplayName("Se anyade un elemento en la primera posicion habiendo ya uno en la lista")
        void anyadirElementoAPrimeraPosicionListaNoVacia(){

            list.prepend(11);
            Object resultado = 11;
            Object valorObtenido = list.first();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Comrpobar que al introducir un elemento en la primera posicion habiendo ya uno en la lista, el que ya habia pasa a ser el ultimo elemento")
        void comprobarDesplazamientoDeElementoEnListaAlAnyadirPrepend(){

            list.prepend(11);
            Object resultado = 12;
            Object valorObtenido = list.last();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Se anyade un elemento en la ultima posicion habiendo ya uno en la lista")
        void anyadirElementoAUltimaPosicionListaNoVacia(){

            list.append(11);
            Object resultado = 11;
            Object valorObtenido = list.last();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Comrpobar que al introducir un elemento en la ultima posicion habiendo ya uno en la lista, el que ya habia pasa a ser el primer elemento")
        void comprobarDesplazamientoDeElementoEnListaAlAnyadirAppend(){

            list.append(11);
            Object resultado = 12;
            Object valorObtenido = list.first();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Eliminar primer elemento de una lista de un elemento")
        void eliminarPrimerElementoDeUnaListaDeUnElemento(){

            list.deleteFirst();
            int resultado = 0;
            int valorObtenido = list.size();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Eliminar primer elemento de una lista tras haber añadido uno en la primera posicion")
        void eliminarPrimerElementoDeUnaListaHabiendoAnyadidoUnoEnPrimeraPosicion(){

            list.prepend(11);
            list.deleteFirst();
            Object resultado = 12;
            Object valorObtenido = list.first();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Eliminar ultimo elemento de una lista de un elemento")
        void eliminarUltimoElementoDeUnaListaDeUnElemento(){

            list.deleteLast();
            int resultado = 0;
            int valorObtenido = list.size();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Eliminar ultimo elemento de una lista tras haber añadido uno en la ultima posicion")
        void eliminarUltimoElementoDeUnaListaHabiendoAnyadidoUnoEnPrimeraPosicion(){

            list.append(11);
            list.deleteLast();
            Object resultado = 12;
            Object valorObtenido = list.last();
            assertEquals(resultado,valorObtenido);
        }

        @Test
        @DisplayName("Obtener el tamaño de una lista no vacia")
        void obtenerElementoDeListaNoVacia(){

            int resultado = 1;
            int valorObtenido = list.size();
            assertEquals(resultado,valorObtenido);

        }
    }


}
