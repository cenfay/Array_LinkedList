package org.example.linkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Никита");
        list.add("Егор");
        list.add("Александр");

        System.out.println(list);

        list.add(1, "Денис");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println("Размер: " + list.size());

        list.clear();
        System.out.println(list);
    }
}
