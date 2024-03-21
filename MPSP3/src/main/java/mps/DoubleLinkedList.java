package mps;

import java.util.Comparator;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void prepend(T value) {

        LinkedNode<T> nodeAux = new LinkedNode<>(value,null,null);
        nodeAux.setItem(value);

        if(this.first==null){
            this.first = nodeAux;
            this.last = nodeAux;
        }else{
            this.first.setPrevious(nodeAux);
            nodeAux.setNext(this.first);
            this.first = nodeAux;
        }
    }

    @Override
    public void append(T value) {

        LinkedNode<T> nodeAux = new LinkedNode<>(value,null,null);
        nodeAux.setItem(value);
        
        if(this.last==null){
            this.first = nodeAux;
            this.last = nodeAux;
        }else{
            this.last.setNext(nodeAux);
            nodeAux.setPrevious(this.last);
            this.last = nodeAux;
        }

    }

    @Override
    public void deleteFirst() {

        if(this.first != null){
            if(this.first == this.last){
                this.last = null;
            }
            this.first = this.first.getNext();
        }else{
            throw new DoubleLinkedQueueException("se ha intentado eliminar el primer elemento con la lista vacia");
        }
    }

    @Override
    public void deleteLast() {

        if(this.last != null){
            if(this.first == this.last){
                this.first = null;
            }
            this.last = this.last.getPrevious();
        }else{
            throw new DoubleLinkedQueueException("se ha intentado eliminar el ultimo elemento con la lista vacia");
        }
    }

    @Override
    public T first() {

        if(this.first == null){
            throw new DoubleLinkedQueueException("se ha intentado obtener el primer elemento con la lista vacia");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        if(this.last == null){
            throw new DoubleLinkedQueueException("se ha intentado obtener el ultimo elemento con la lista vacia");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {

        LinkedNode<T> aux = this.first;
        int tam = 0;
        while(aux != null){
            tam++;
            aux = aux.getNext();
        }
        return tam;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public void remove(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }
}
