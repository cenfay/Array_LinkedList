package org.example.linkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    // Добавить в конец
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Добавить по индексу
    public void add(int index, T element) {
        checkIndexForAdd(index);
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> previous = getNode(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
    }

    // Получить элемент по индексу
    public T get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    // Удалить элемент по индексу
    public void remove(int index) {
        checkIndex(index);
        Node<T> removed;
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> previous = getNode(index - 1);
            removed = previous.next;
            previous.next = removed.next;
        }
        size--;
    }

    // Очистить список
    public void clear() {
        head = null;
        size = 0;
    }

    // Получить размер
    public int size() {
        return size;
    }

    // Вспомогательный метод: получить узел по индексу
    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс" + index + " выходит за рамки допустимого размера " + size);
        }
    }

    // Проверка индекса для add
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за рамки допустимого размера " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
