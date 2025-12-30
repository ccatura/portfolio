package tests;

import java.util.ArrayList;

public class SimpleDataStructure {

    public static void main(String[] args) {
        
        // Use an ArrayList to act as the Stack
        ArrayList<String> stack = new ArrayList<>();
        
        System.out.println("--- Stack: Last-In, First-Out (LIFO) ---");
        
        // 1. PUSH: Add to the "Top" (end of the list)
        stack.add("First Item (Bottom)"); 
        stack.add("Second Item");
        stack.add("Third Item (Top)");
        
        System.out.println("After PUSHES: " + stack);
        
        System.out.println("\n--- Popping Items ---");
        
        // 2. POP: Remove from the "Top" (end of the list)
        
        // The last item added is the first item removed (LIFO)
        String popped1 = stack.remove(stack.size() - 1); 
        System.out.println("Popped: " + popped1); 
        
        // The second-to-last item added is the next one removed
        String popped2 = stack.remove(stack.size() - 1); 
        System.out.println("Popped: " + popped2); 
        
        System.out.println("\nRemaining Stack: " + stack);
    }
}