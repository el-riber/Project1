package Deque.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a deque (double-ended queue) implemented using a doubly linked list.
 * @param <T> The type of elements in the deque.
 */
public class LinkedDeque<T> implements DequeInterface<T> {
    public DLNode<T> first;
    public DLNode<T> last;
    private int size = 0;


    /**
     * Initializes an empty LinkedDeque.
     */
    public LinkedDeque() {
        first = null;
        last = null;

    }

    /**
     * Adds a new entry to the front of the deque.
     * @param newEntry The new entry to be added.
     */
    public void addToFront(T newEntry) {
        DLNode<T> newNode = new DLNode<>(null, newEntry, first); // New node's next points to current first

        if (isEmpty()) { // If the deque is empty
            first = newNode;
            last = newNode;
        } else {
            first.previous = newNode;  // Previous first node's previous points to new node
            first = newNode;           // Update first to point to new node
        }

        size++; // Increment the size
    }

    /**
     * Adds a new entry to the back of the deque.
     * @param newEntry The new entry to be added.
     */
    public void addToBack(T newEntry) {
        DLNode<T> newNode = new DLNode<>(last, newEntry, null); // New node's previous points to current last

        if (isEmpty()) { // If the deque is empty
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;  // Previous last node's next points to new node
            last = newNode;       // Update last to point to new node
        }

        size++; // Increment the size
    }
    /**
     * Removes and returns the entry at the front of the deque.
     * @return The entry at the front of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */
    public T removeFront() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty!");
        }

        T frontData = first.data; // Save data to return

        first = first.next; // Move the first pointer

        if (first == null) { // If the deque is now empty
            last = null;
        } else {
            first.previous = null; // New first's previous should be null
        }

        size--; // Decrement the size

        return frontData;
    }
    /**
     * Removes and returns the entry at the back of the deque.
     * @return The entry at the back of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */
    public T removeBack() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty!");
        }

        T backData = last.data; // Save the data from the current last node

        last = last.previous; // Move the last pointer

        if (last == null) { // If the deque is now empty
            first = null;
        } else {
            last.next = null; // New last node's next should be null
        }

        size--; // Decrement the size

        return backData;
    }

    /**
     * Checks whether the deque is empty.
     * @return true if the deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Retrieves the entry at the front of the deque without removing it.
     * @return The entry at the front of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty! Cannot get the front.");
        }
        return first.data;
    }

    /**
     * Retrieves the entry at the back of the deque without removing it.
     * @return The entry at the back of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */
    public T getBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty! Cannot get the back.");
        }
        return last.data;
    }
    /**
     * Removes all entries from the deque.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0; // If you have a size variable
    }
    /**
     * Returns an iterator to the deque.
     * @return An iterator to the deque.
     */
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }

    /**
     * Returns an iterator to the deque.
     * @return An iterator to the deque.
     */
    public Iterator<T> iterator() {
        return getIterator();
    }


    /**
     * Represents a node in the doubly linked list.
     * @param <T> The type of data stored in the node.
     */
    public class DLNode<T> {
        public T data;
        public DLNode next;
        public DLNode previous;

        /**
         * Initializes a new DLNode with the specified data and links.
         * @param previous The previous node in the list.
         * @param data The data to be stored.
         * @param next The next node in the list.
         */
        public DLNode(DLNode previous, T data, DLNode next) {
            this.previous = previous;
            this.data = data;
            this.next = next;

        }

        // Getter for data
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DLNode<T> getNext() {
            return next;
        }

        public void setNext(DLNode<T> next) {
            this.next = next;
        }

        public DLNode<T> getPrevious() {
            return previous;
        }

        public void setPrevious(DLNode<T> previous) {
            this.previous = previous;
        }
    }


    /**
     * Represents an iterator over the LinkedDeque.
     */
    public class IteratorForLinkedList implements Iterator<T> {
        public DLNode<T> currentNode;

        /**
         * Initializes a new IteratorForLinkedList.
         */
        public IteratorForLinkedList() {
            currentNode = first; // Start iterating from the front
        }

        /**
         * Checks whether the iterator has more elements.
         * @return true if there are more elements, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Returns the next element in the deque.
         * @return The next element in the deque.
         * @throws NoSuchElementException if there are no more elements.
         */


        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
}