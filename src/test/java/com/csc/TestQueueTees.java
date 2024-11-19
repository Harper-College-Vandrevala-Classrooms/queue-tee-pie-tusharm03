package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQueueTees {

    QueueTees queue;

    @BeforeEach
    void setUp() {
        queue = new QueueTees();
    }

    // Test if the queue is initially empty
    @Test
    void testInitialSize() {
        assertEquals(0, queue.size(), "Queue should be initially empty");
    }

    // Test enqueueing a Cutie and checking the size
    @Test
    void testEnqueue() {
        Cutie puppy = new Puppy();
        queue.enqueue(puppy);
        assertEquals(1, queue.size(), "Queue size should be 1 after enqueuing one cutie");
    }

    // Test dequeuing an item and checking if the correct item is returned
    @Test
    void testDequeue() {
        Cutie puppy = new Puppy();
        queue.enqueue(puppy);
        Cutie dequeued = queue.dequeue();
        assertEquals(puppy, dequeued, "Dequeued cutie should be the one we enqueued");
        assertEquals(0, queue.size(), "Queue size should be 0 after dequeuing");
    }

    // Test if queue is full and does not accept more elements
    @Test
    void testQueueFull() {
        Cutie puppy = new Puppy();
        Cutie kitty = new Kitty();
        Cutie marmoset = new PygmyMarmoset();

        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);

        // Queue is full now, trying to enqueue one more should not change the queue
        queue.enqueue(new Puppy());
        assertEquals(3, queue.size(), "Queue size should not exceed the maximum size of 3");
    }

    // Test dequeueing from an empty queue should return null
    @Test
    void testDequeueEmptyQueue() {
        Cutie dequeued = queue.dequeue();
        assertNull(dequeued, "Dequeuing from an empty queue should return null");
    }
}
