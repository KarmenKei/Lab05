package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the {@link IntQueue} implementation.
 * Tests are for ArrayIntQueue class.
 * Write your own unit tests for the methods of ArrayIntQueue.
 */
public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        // Use ArrayIntQueue for testing
        mQueue = new ArrayIntQueue();

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        // The queue should be empty initially
        assertTrue(mQueue.isEmpty());
        mQueue.enqueue(1);  // Add an element
        assertFalse(mQueue.isEmpty());  // The queue shouldn't be empty after enqueue
    }

    @Test
    public void testPeekEmptyQueue() {
        try {
            mQueue.peek();  // Attempting to peek into an empty queue
            fail("Expected exception for empty queue");  // Test should fail if no exception is thrown
        } catch (EmptyQueueException e) {
            // Expected exception, test passes
        }
    }

    @Test
    public void testPeekNonEmptyQueue() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        assertEquals(Integer.valueOf(1), mQueue.peek());  // Peek should return the front element (1)
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), mQueue.peek());  // Peek should return the first element
            assertEquals(i + 1, mQueue.size());  // The size should increment with each enqueue
        }
    }

    @Test
    public void testDequeue() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        assertEquals(Integer.valueOf(1), mQueue.dequeue());  // Dequeue should return the front element (1)
        assertEquals(1, mQueue.size());  // Size should be 1 after one dequeue
    }

    @Test
    public void testClear() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        mQueue.clear();
        assertTrue(mQueue.isEmpty());  // Queue should be empty after clear
        assertEquals(0, mQueue.size());  // Size should be 0
    }
}