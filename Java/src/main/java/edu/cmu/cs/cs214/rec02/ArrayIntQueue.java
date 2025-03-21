package edu.cmu.cs.cs214.rec02;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A resizable-array implementation of the {@link IntQueue} interface. The head of
 * the queue starts out at the head of the array, allowing the queue to grow and
 * shrink in constant time.
 *
 * This implementation contains three bugs! Use your tests to determine the
 * source of the bugs and correct them!
 *
 * @author Alex Lockwood
 * @author Ye Lu
 */
public class ArrayIntQueue implements IntQueue {

    private int[] elementData;
    private int head;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public ArrayIntQueue() {
        elementData = new int[INITIAL_SIZE];
        head = 0;
        size = 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, 0);
        size = 0;
        head = 0;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Integer value = elementData[head];
        head = (head + 1) % elementData.length;
        size--;
        return value;
    }

    @Override
    public boolean enqueue(Integer value) {
        ensureCapacity();
        int tail = (head + size) % elementData.length;
        elementData[tail] = value;
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData[head];
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = 2 * oldCapacity + 1;
            int[] newData = new int[newCapacity];
            for (int i = head; i < oldCapacity; i++) {
                newData[i - head] = elementData[i];
            }
            for (int i = 0; i < head; i++) {
                newData[oldCapacity - head + i] = elementData[i];
            }
            elementData = newData;
            head = 0;
        }
    }
}