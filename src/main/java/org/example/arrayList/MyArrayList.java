package org.example.arrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private final Class<T> type;


    public MyArrayList(Class<T> type) {
        this.type = type;
        elements = (T[]) Array.newInstance(type, DEFAULT_CAPACITY);
        size = 0;
    }

    // Добавить в конец
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Добавить по индексу
    public void add(int index, T element) {
        checkIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Получить элемент по индексу
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    // Удалить элемент по индексу
    public void remove(int index) {
        checkIndex(index);
        T removedElement = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    // Размер списка
    public int size() {
        return size;
    }

    // Очистить список
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    // Проверка и расширение массива
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Получение и удаление по индексу
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за рамки допустимого размера " + size);
        }
    }

    // Проверка индекса для вставки
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за рамки допустимого размера " + size);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}
