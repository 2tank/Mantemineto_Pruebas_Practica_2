package mps;

public class Main {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> lista  =new DoubleLinkedList();
        lista.prepend(11);
        lista.prepend(13);
        lista.prepend(14);
        lista.prepend(15);
        lista.prepend(1);
        lista.prepend(17);
        System.out.println(lista.first());
        System.out.println(lista.last());
        lista.deleteFirst();
        lista.deleteLast();
        System.out.println(lista.first());
        System.out.println(lista.last());

    }
}
