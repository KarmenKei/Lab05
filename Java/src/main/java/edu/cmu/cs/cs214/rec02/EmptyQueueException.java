package edu.cmu.cs.cs214.rec02;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Queue is empty.");
    }
}
