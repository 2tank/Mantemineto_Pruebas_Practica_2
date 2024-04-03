//mvn jacoco:prepare-agent test install jacoco:report

package mps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

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

        ///////////// TESTS SEGUNDA PARTE DE LA PRACTICA /////////////
        @Test
        @DisplayName("Obtener un elemento mediante un índice de una lista vacia lanza Excepcion")
        void getElement_newList_returnException(){

            int index = 1;

            assertThrows(RuntimeException.class,()->{
                list.get(index);
            });
        }

        @Test
        @DisplayName("Obtener un elemento mediante un índice menor o igual a cero en una lista lanza Exepcion")
        void getElementLowerIndex_newList_returnException(){

            int index = 0;

            assertThrows(RuntimeException.class,()->{
                list.get(index);
            });
        }

        @Test
        @DisplayName("Comprobar si un elemento está contenido en una lista vacia lanza Excepcion")
        void containsElement_newList_returnException(){

            Integer value = 13;

            assertThrows(RuntimeException.class,()->{
                list.contains(value);
            });
        }

        @Test
        @DisplayName("Eliminar un elemento en una lista vacia lanza Excepcion")
        void removeElement_newList_returnException(){

            Integer value = 13;

            assertThrows(RuntimeException.class,()->{
                list.remove(value);
            });
        }

        @Test
        @DisplayName("Ordenar una lista vacia lanza Excepcion")
        void sortList_newList_returnException(){

            Comparator<? super Object> comparator = new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {

                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return i1.compareTo(i2);
                }
            };

            assertThrows(RuntimeException.class,()->{
                list.sort(comparator);
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

        ///////////// TESTS SEGUNDA PARTE DE LA PRACTICA /////////////

        @Test
        @DisplayName("Obtener correctamente un elemento existente mediante su indice en una lista no vacia")
        void getElement_newWithOneElement_returnsTrue(){
            int index = 1;
            Object expectedValue = 12;

            Object returnValue = list.get(index);

            assertEquals(expectedValue,returnValue);

        }

        @Test
        @DisplayName("Obtener correctamente un elemento existente mediante su indice en una lista no vacia no modifica la misma")
        void getElement_newWithOneElementDoNotModifyTheList_returnsTrue(){
            int index = 1;
            int expectedValue = 1;

            list.get(index);
            int returnValue = list.size();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Comprobar si un elemento que esta contenido en una lista no vacia devuelve True")
        void containElement_newWithOneElement_returnsTrue(){
            Object n = 12;

            boolean returnValue = list.contains(n);

            assertTrue(returnValue);
        }

        @Test
        @DisplayName("Comprobar si un elemento que no esta contenido en una lista no vacia devuelve False")
        void notContainElement_newWithOneElement_returnsFalse(){
            Object n = 13;

            boolean valorObtenido = list.contains(n );

            assertFalse(valorObtenido);
        }
        
        @Test
        @DisplayName("Eliminar elemento existente en una lista no vacia es correcto")
        void removeElement_newWithOneElement_suceed(){
            Object valorAEliminar = 12;

            list.remove(valorAEliminar);

            assertThrows(RuntimeException.class,()->{
                list.get(1);
            });

        }
        
        @Test
        @DisplayName("Eliminar elemento existente en una lista no vacia hace que la lista quede vacia")
        void removeElement_newWithOneElement_isEmptyList(){
            Object valorAEliminar = 12;
            int expectedValue = 0;

            list.remove(valorAEliminar);
            int returnValue = list.size();

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Eliminar elemento inexistente en una lista no vacia es incorrecto")
        void removeNonexistentElement_newWithOneElement_throwsRuntimeException(){
            Object valorAEliminar = 16;

            assertThrows(RuntimeException.class,()->{
                list.remove(valorAEliminar);
            });

        }
    }

    @Nested
    @DisplayName("Cuando se crea la DoubleLinkedList y se añaden dos elementos")
    class WhenNewWithTwoElement {

        @BeforeEach
        void createNewDoubleLinkedList(){
            list = new DoubleLinkedList<>();
            list.append(12);
            list.append(5);
        }

        ///////////// TESTS SEGUNDA PARTE DE LA PRACTICA /////////////
        @Test
        @DisplayName("Obtener correctamente un elemento existente mediante su indice en una lista no vacia con dos elementos")
        void getElement_newWithTwoElement_suceed(){
            int index = 2;
            Object expectedValue = 5;

            Object returnValue = list.get(index);

            assertEquals(expectedValue,returnValue);
        }

        @Test
        @DisplayName("Obtener un elemento mediante un indice erroneo para una lista no vacia con dos elementos lanza Excepcion")
        void getElementSuperiorIndex_newWithTwoElement_throwsRuntimeExcepcion(){
            int index = 3;

            assertThrows(RuntimeException.class,()->{
                list.get(index);
            });
        }

        @Test
        @DisplayName("Comprobar si un elemento que esta contenido en una lista doblemente devuelve True")
        void containDuplicateElement_newWithTwoElement_returnsTrue(){
            Object valor = 5;

            list.append(valor);
            boolean valorObtenido = list.contains(valor);

            assertTrue(valorObtenido);
        }

        @Test
        @DisplayName("Eliminar elemento existente en una lista con dos elementos es correcto")
        void removeElement_newWithTwoElement_isCorrect(){
            int valorAEliminar = 5;

            list.remove(valorAEliminar);
            assertThrows(RuntimeException.class,()->{
                list.get(5);
            });

        }
    }
}
