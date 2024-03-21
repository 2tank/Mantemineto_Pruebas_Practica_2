package mps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
        void prepend_newList_suceed(){
            int value = 12;
            Object expectedValue = 12;

            list.prepend(value);
            Object returnValue = list.first();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Anyadir un elemento al final de la lista (hacer un apend)")
        void append_newList_suceed(){
            int value = 12;
            Object expectedValue = 12;

            list.append(value);
            Object returnValue = list.last();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Anyadir un elemento al comienzo de la lista debe ser igual que el elemento final")
        void prepend_newList_lastEqualsFirst(){
            int value = 12;

            list.prepend(value);
            Object valorObtenidoPrimeraPosicion = list.first();
            Object valorObtenidoUltimaPosicion = list.last();

            assertEquals(valorObtenidoUltimaPosicion,valorObtenidoPrimeraPosicion);
        }

        @Test
        @DisplayName("Anyadir un elemento al final de la lista debe ser igual que el elemento primero")
        void append_newList_lastEqualsFirst(){
            int value = 12;

            list.append(value);
            Object valorObtenidoPrimeraPosicion = list.first();
            Object valorObtenidoUltimaPosicion = list.last();

            assertEquals(valorObtenidoUltimaPosicion,valorObtenidoPrimeraPosicion);
        }

        @Test
        @DisplayName("Obtener tamanyo de la lista vacia devuelve 0")
        void size_newList_returns0(){
            int expectedValue = 0;

            int returnValue = list.size();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Eliminar el primer elemento de una lista vacia lanza Excepcion")
        void deleteFirst_newList_throwsRuntimeException(){

            assertThrows(RuntimeException.class,()->{
                list.deleteFirst();
            });
        }

        @Test
        @DisplayName("Eliminar el ultimo elemento de una lista vacia lanza Excepcion")
        void deleteLast_newList_throwsRuntimeException(){

            assertThrows(RuntimeException.class,()->{
                list.deleteLast();
            });
        }

        @Test
        @DisplayName("Acceder al primer elemento de una lista vacia lanza Excepcion")
        void first_newList_returnsFirst(){

            assertThrows(RuntimeException.class,()->{
                list.first();
            });

        }

        @Test
        @DisplayName("Acceder al ultimo elemento de una lista vacia lanza Excepcion")
        void last_newList_returnsLast(){

            assertThrows(RuntimeException.class,()->{
                list.last();
            });

        }
    }

    @Nested
    @DisplayName("Cuando se crea la DoubleLinkedList y se añade un elemento")
    class WhenNewWithOneElement{

        @BeforeEach
        void createNewDoubleLinkedList(){
            list = new DoubleLinkedList<>();
            list.append(12);
        }

        @Test
        @DisplayName("Se anyade un elemento en la primera posicion habiendo ya uno en la lista")
        void prepend_newWithOneElement_insertSuceed(){
            int value = 11;
            Object expectedValue = 11;

            list.prepend(value);
            Object returnValue = list.first();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Comrpobar que al introducir un elemento en la primera posicion habiendo ya uno en la lista, el que ya habia pasa a ser el ultimo elemento")
        void prepend_newWithOneElement_firstTurnsLast(){
            int value = 11;
            Object expectedValue = 12;

            list.prepend(value);
            Object returnValue = list.last();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Se anyade un elemento en la ultima posicion habiendo ya uno en la lista")
        void append_newWithOneElement_insertSuceed(){
            int value = 11;
            Object expectedValue = 11;

            list.append(value);
            Object returnValue = list.last();
            
            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Comrpobar que al introducir un elemento en la ultima posicion habiendo ya uno en la lista, el que ya habia pasa a ser el primer elemento")
        void append_newWithOneElement_lastTurnsFirst(){
            int value = 11;
            Object expectedValue = 12;

            list.append(value);
            Object returnValue = list.first();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Eliminar primer elemento de una lista de un elemento")
        void deleteFirst_newWithOneElement_sizeTurns0(){
            int expectedValue = 0;

            list.deleteFirst();
            int returnValue = list.size();
        
            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Eliminar primer elemento de una lista tras haber añadido uno en la primera posicion")
        void deleteFirst_newWithOneElementAndPrepend_firstTurnsLast(){
            int value = 11;
            Object expectedValue = 12;

            list.prepend(value);
            list.deleteFirst();
            Object returnValue = list.first();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Eliminar ultimo elemento de una lista de un elemento")
        void deleteLast_newWithOneElement_sizeTurns0(){
            int expectedValue = 0;

            list.deleteLast();
            int returnValue = list.size();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Eliminar ultimo elemento de una lista tras haber añadido uno en la ultima posicion")
        void deleteLast_newWithOneElementAndAppend_lastTurnsFirst(){
            int value = 11;
            Object expectedValue = 12;

            list.append(value);
            list.deleteLast();
            Object returnValue = list.last();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Obtener el tamaño de una lista no vacia")
        void size_newWithOneElement_returns1(){
            int expectedValue = 1;

            int returnValue = list.size();

            assertEquals(expectedValue,returnValue);
        }
    }


}
