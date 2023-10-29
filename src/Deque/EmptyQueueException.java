package Deque.Deque;

/**
 * Represents an exception that is thrown when an operation
 * is attempted on an empty queue or deque.
 */
public class EmptyQueueException extends RuntimeException {

    /**
     * Constructs a new EmptyQueueException with the specified detail message.
     *
     * @param message The detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EmptyQueueException(String message) {
        super(message);
    }
}