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

        LinkedNode<T> aux = this.first;
        int auxNumber = 1;

        if(index <= 0 ){
            throw new DoubleLinkedQueueException("Se ha intentado obtener un elemento con un indice incorrecto");
        }

        while(aux != null && auxNumber < index){

            auxNumber++;
            aux = aux.getNext();
        }
        if(aux == null){
            throw new DoubleLinkedQueueException("Se ha intentado obtener un elemento que no existe en la lista");
        }
        return aux.getItem();
    }

    @Override
    public boolean contains(T value) {

        LinkedNode<T> aux = this.first;

        while(aux != null && aux.getItem() != value){

            aux = aux.getNext();
        }
       return (aux != null);
    }

    @Override
    public void remove(T value) {

        LinkedNode<T> aux = this.first;
        LinkedNode<T> preAux = null;

        while(aux != null && aux.getItem() != value){

            preAux = aux;
            aux = aux.getNext();

        }
        if(aux == null){
         throw new DoubleLinkedQueueException("Se ha intentado eliminar un elemento que no existe en la lista");
        }
        preAux.setNext(aux.getNext());
        aux.getNext().setPrevious(preAux);
    }

    @Override
    public void sort(Comparator<? super T> comparator) {



    }
}
