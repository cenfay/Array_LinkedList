package org.example.arrayList;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>(Integer.class);

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

        list.add(1, 45);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println("Размер: " + list.size());

        list.clear();
        System.out.println(list);
    }
}