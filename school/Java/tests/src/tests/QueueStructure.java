package tests;

import java.util.ArrayList;

public class QueueStructure {

    public static void main(String[] args) {
        
        // Use an ArrayList to act as the Queue
        ArrayList<String> queue = new ArrayList<>();
        
        System.out.println("--- Queue: First-In, First-Out (FIFO) ---");
        
        // 1. ENQUEUE: Add to the "Rear" (end of the line)
        // We use .add() to put items at the back.
        queue.add("Person A (Front)"); // First-In
        queue.add("Person B");
        queue.add("Person C (Rear)");
        
        System.out.println("After ENQUEUE: " + queue);
        
        System.out.println("\n--- Dequeueing Items ---");
        
        // 2. DEQUEUE: Remove from the "Front" (beginning of the line)
        
        // The first item added is the first item removed (FIFO)
        // We use .remove(0) to remove the element at the front.
        String dequeued1 = queue.remove(0); 
        System.out.println("Dequeued: " + dequeued1); 
        
        // The next item in line is the next one removed
        String dequeued2 = queue.remove(0); 
        System.out.println("Dequeued: " + dequeued2); 
        
        System.out.println("\nRemaining Queue: " + queue);
    }
}