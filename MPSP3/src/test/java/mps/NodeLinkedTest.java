package mps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NodeLinkedTest {

    LinkedNode<Integer> lnode;

    @Test
    @DisplayName("Se instancia con new LinkedNode(T,null,null)")
    void isInstantiatedWithNew(){
        lnode = new LinkedNode<Integer>(1, null, null);
    }

    @Nested
    @DisplayName("Cuando se instancia")
    class WhenNew{

        // null <-> 1 <-> null
        
        @BeforeEach
        void createLinkedNode(){
            lnode = new LinkedNode<Integer>(1, null, null);
        }

        @Test
        @DisplayName("Devuelve correctamente el objeto")
        void getItem_suceed(){
            assertEquals(1, lnode.getItem());
        }

        @Test
        @DisplayName("Sustituye correctamente el objeto")
        void setItem_anyValue_suceed(){
            int newValue = 2;

            lnode.setItem(newValue);
            int returnValue = lnode.getItem();

            assertEquals(newValue, returnValue);
        }

        @Test
        @DisplayName("El anterior es nulo")
        void getPrevious_newNode_returnNull(){
            assertNull(lnode.getPrevious());
        }

        @Test
        @DisplayName("El siguiente es nulo")
        void getNext_newNode_returnNull(){
            assertNull(lnode.getNext());
        }

        @Test
        @DisplayName("Es el primer Nodo")
        void isFirstNode_newNode_returnsTrue(){
            boolean expectedValue = true;

            boolean returnValue = lnode.isFirstNode();

            assertEquals(expectedValue, returnValue);
        }

        @Test
        @DisplayName("Es el ultimo Nodo")
        void isLastNode_newNode_returnsTrue(){
            boolean expectedValue = true;

            boolean returnValue = lnode.isLastNode();

            assertEquals(expectedValue, returnValue);
        }

        @Test
        @DisplayName("Es nodo terminal")
        void isNotATerminalNode_newNode_returnFalse(){
            boolean expectedValue = false;

            boolean returnValue = lnode.isNotATerminalNode();

            assertEquals(expectedValue, returnValue);
        }

    }

    @Nested
    @DisplayName("Cuando se instancia con previo")
    class WhenNewWithPrevious{

        // 2 <-> 1 <-> null
        
        LinkedNode<Integer> prev;

        @BeforeEach
        void createLinkedNode(){
            lnode = new LinkedNode<Integer>(1, null, null);
            prev  = new LinkedNode<Integer>(2, null, lnode);
            lnode.setPrevious(prev);
        }

        @Test
        @DisplayName("Devuelve correctamente el objeto previo")
        void getPrevious_newNodeWithPrev_returnsPrev(){
            assertEquals(prev, lnode.getPrevious());
        }

        @Test
        @DisplayName("Sustituye correctamente el objeto previo")
        void setPrevious_newNodeWithPrev_suceed(){
            LinkedNode<Integer> newValue = new LinkedNode<Integer>(3, null, lnode);

            lnode.setPrevious(newValue);
            LinkedNode<Integer> returnValue = lnode.getPrevious();

            assertEquals(newValue, returnValue);
        }

        @Test
        @DisplayName("Ahora no es el primer Nodo")
        void isFirstNode_newNodeWithPrev_returnsTrue(){
            boolean expectedValue = false;

            boolean returnValue = lnode.isFirstNode();

            assertEquals(expectedValue, returnValue);
        }

        @Test
        @DisplayName("Sigue siendo el ultimo Nodo")
        void isLastNode_newNodeWithPrev_returnsTrue(){
            boolean expectedValue = true;

            boolean returnValue = lnode.isLastNode();

            assertEquals(expectedValue, returnValue);
        }

        @Test
        @DisplayName("Sigue siendo nodo terminal")
        void isNotATerminalNode_newNodeWithPrev_returnFalse(){
            boolean expectedValue = false;

            boolean returnValue = lnode.isNotATerminalNode();

            assertEquals(expectedValue, returnValue);
        }

    }

    @Nested
    @DisplayName("Cuando se instancia con siguiente y previo")
    class WhenNewWithNext{
        
        LinkedNode<Integer> next;
        LinkedNode<Integer> prev;

        // 2 <-> 1 <-> 3

        @BeforeEach
        void createLinkedNode(){
            lnode = new LinkedNode<Integer>(1, null, null);
            prev  = new LinkedNode<Integer>(2, null, lnode);
            next  = new LinkedNode<Integer>(3, lnode, null);

            lnode.setPrevious(prev);
            lnode.setNext(next);
        }

        @Test
        @DisplayName("Devuelve correctamente el objeto siguiente")
        void getNext_newNodeWithPrevNext_suceed(){
            assertEquals(next, lnode.getNext());
        }

        @Test
        @DisplayName("Sustituye correctamente el objeto siguiente")
        void setNext_anyValue_suceed(){
            LinkedNode<Integer> newValue = new LinkedNode<Integer>(4, lnode, null);

            lnode.setNext(newValue);
            LinkedNode<Integer> returnValue = lnode.getNext();

            assertEquals(newValue, returnValue);
        }

        @Test
        @DisplayName("No es el primer nodo")
        void isFirstNode_newNodeWithPrevNext_returnsTrue(){
            boolean expectedValue = false;

            boolean returnValue = lnode.isFirstNode();

            assertEquals(expectedValue, returnValue);
        }

        @Test
        @DisplayName("No es el ultimo nodo")
        void isLastNode_newNodeWithPrevNext_returnsTrue(){
            boolean expectedValue = false;

            boolean returnValue = lnode.isLastNode();

            assertEquals(expectedValue, returnValue);
        }

        @Test
        @DisplayName("Sigue siendo nodo terminal")
        void isNotATerminalNode_newNodeWithPrevNext_returnTrue(){
            boolean expectedValue = true;

            boolean returnValue = lnode.isNotATerminalNode();

            assertEquals(expectedValue, returnValue);
        }

    }

}
