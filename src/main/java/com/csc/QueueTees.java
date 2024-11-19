package com.csc;

public class QueueTees {
    private static final int MAX_SIZE = 3;
    private Cutie[] queue;
    private int front, rear, currentSize;

    public QueueTees() {
        queue = new Cutie[MAX_SIZE];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public void enqueue(Cutie cutie) {
        if (currentSize == MAX_SIZE) {
            System.out.println("Queue is full! Cannot add more cuties.");
        } else {
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = cutie;
            currentSize++;
        }
    }

    public Cutie dequeue() {
        if (currentSize == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        } else {
            Cutie dequeuedCutie = queue[front];
            front = (front + 1) % MAX_SIZE;
            currentSize--;
            return dequeuedCutie;
        }
    }

    public int size() {
        return currentSize;
    }

    public boolean isFull() {
        return currentSize == MAX_SIZE;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }
    public static void main(String[] args) {
        Cutie puppy = new Puppy();
        Cutie kitty = new Kitty();
        Cutie marmoset = new PygmyMarmoset();

        QueueTees queue = new QueueTees();

        System.out.println("Queue size (before any enqueue): " + queue.size());

        // Add the cuties to the queue
        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);

        System.out.println("Queue size (after enqueuing 3 cuties): " + queue.size());

        // The first dequeue should return the puppy
        Cutie dequeuedCutie = queue.dequeue();
        System.out.println("Dequeued cutie: " + dequeuedCutie.description() + " with cuteness rating: " + dequeuedCutie.cutenessRating());

        // The second dequeue should return the kitty
        dequeuedCutie = queue.dequeue();
        System.out.println("Dequeued cutie: " + dequeuedCutie.description() + " with cuteness rating: " + dequeuedCutie.cutenessRating());

        // The third dequeue should return the pygmy marmoset
        dequeuedCutie = queue.dequeue();
        System.out.println("Dequeued cutie: " + dequeuedCutie.description() + " with cuteness rating: " + dequeuedCutie.cutenessRating());

        Cutie emptyDequeue = queue.dequeue();
        if (emptyDequeue == null) {
            System.out.println("Queue is empty! No more cuties to dequeue.");
        }
    }
}