package mps;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> lista  =new DoubleLinkedList();
        lista.append(11);
        lista.append(13);
        lista.append(14);
        lista.append(15);
        lista.append(16);
        lista.append(17);

        System.out.println(lista.get(0));
        lista.remove(14);
        System.out.println(lista.contains(14));
        System.out.println(lista.contains(11));
        System.out.println(lista.contains(13));
        System.out.println(lista.contains(15));
        System.out.println(lista.get(5));
        System.out.println(lista.get(15));







    }
}
