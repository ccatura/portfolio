package tests;
public class SimpleLinkedList {

    // =======================================================
    // STEP 1: DEFINE THE NODE (THE BUILDING BLOCK)
    // =======================================================
    // The Node is the fundamental component of the Linked List.
    // Each Node has two parts: data and a pointer to the next Node.
    private static class Node {
        String data; // 1. Holds the actual data for this position.
        Node next;   // 2. Holds the LINK (reference/pointer) to the next Node object.
        
        public Node(String data) {
            this.data = data;
            this.next = null; // When created, it points to nothing (the end of the list).
        }
    }

    public static void main(String[] args) {
        
        // =======================================================
        // STEP 2: INITIALIZATION (CREATING THE HEAD)
        // =======================================================
        
        // The 'head' is the start of the list. We must always save this reference.
        Node head = new Node("Item A (Head)"); 
        
        // Create the subsequent nodes
        Node secondNode = new Node("Item B");
        Node thirdNode = new Node("Item C (Tail)");
        
        // =======================================================
        // STEP 3: LINKING (INSERTION)
        // =======================================================
        
        // Link A to B: The 'next' pointer of the head node now points to the second node.
        head.next = secondNode; 
        
        // Link B to C: The 'next' pointer of the second node points to the third node.
        secondNode.next = thirdNode;
        
        // The 'next' of the thirdNode is still null, which marks the end of the list.
        
        // =======================================================
        // STEP 4: TRAVERSAL (ITERATING TO ACCESS DATA)
        // =======================================================
        
        // Create a temporary pointer to traverse the list. 
        // We start it at the 'head' so we don't lose the reference to the start.
        Node currentNode = head; 
        
        System.out.println("--- Iterating Through List (Traversal) ---");
        
        // The loop continues AS LONG AS the current node is not null (i.e., not past the end).
        while (currentNode != null) {
            
            // Print the data stored in the current node
            System.out.println("Node Data: " + currentNode.data);
            
            // This is the core movement: move the pointer one step forward in the chain.
            // When currentNode reaches the 'Tail', its .next is null, which ends the loop.
            currentNode = currentNode.next; 
        }
    }
}