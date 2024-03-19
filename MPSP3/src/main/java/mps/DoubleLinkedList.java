package mps;

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
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
