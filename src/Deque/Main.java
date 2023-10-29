package Deque.Deque;

public class Main {

    /**
     * Demonstrates the functionalities of the LinkedDeque class.
     * <p>
     * This main method initializes a LinkedDeque of strings and performs
     * various operations such as adding elements to the front and back,
     * removing elements, and displaying elements using an iterator.
     * The results of these operations are printed to the standard output.
     * </p>
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();

        // Displaying initial status
        System.out.println("Is deque empty? " + deque.isEmpty());

        // Adding elements to the deque
        deque.addToFront("Element1");  // Replace `String` with an actual string value, e.g., "Element1"
        deque.addToBack("Element2");
        System.out.println("Front of the deque: " + deque.getFront());
        System.out.println("Back of the deque: " + deque.getBack());


        // Adding more elements
        deque.addToFront("Element1");
        deque.addToBack("Element3");
        System.out.println("Front of the deque after additions: " + deque.getFront());
        System.out.println("Back of the deque after additions: " + deque.getBack());

        // Displaying using iterator
        System.out.println("\nElements in the deque:");
        for (String element : deque) {
            System.out.println(element);
        }

        // Removing elements
        deque.removeFront();
        deque.removeBack();
        System.out.println("\nFront of the deque after removals: " + deque.getFront());
        System.out.println("Back of the deque after removals: " + deque.getBack());

        // Clearing the deque
        deque.clear();
        System.out.println("\nIs deque empty after clear? " + deque.isEmpty());
    }
}
