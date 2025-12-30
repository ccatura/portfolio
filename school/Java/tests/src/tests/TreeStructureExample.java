package tests;

import java.util.ArrayList;

public class TreeStructureExample {

    // 1. Define the Node Structure: A Tree Node holds data and pointers (links) 
    // to other nodes, often called 'left' and 'right' children.
    private static class TreeNode {
        String data;
        TreeNode left;  // Pointer to the left child
        TreeNode right; // Pointer to the right child

        public TreeNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Tree Structure: Hierarchical (Non-Linear) ---");
        
        // 2. Initialization: Create the ROOT node (the starting point)
        TreeNode root = new TreeNode("Root Node (Start)");
        
        // 3. Linking: Define the branches (children)
        
        // Connect the left child to the root
        TreeNode childA = new TreeNode("Left Child (Branch A)");
        root.left = childA;
        
        // Connect the right child to the root
        TreeNode childB = new TreeNode("Right Child (Branch B)");
        root.right = childB;
        
        // Add a grandchild C to the left branch's RIGHT side
        TreeNode grandchildC = new TreeNode("Grandchild C");
        childA.right = grandchildC;
        
        // ADDED: Add a grandchild D to the left branch's LEFT side
        TreeNode grandchildD = new TreeNode("Grandchild D");
        childA.left = grandchildD;
        
        // 4. Access Demonstration (Access is hierarchical, not sequential)
        System.out.println("\nTree Structure Created:");
        System.out.println("Root: " + root.data);
        System.out.println("Left Child: " + root.left.data);
        System.out.println("Right Child: " + root.right.data);
        
        // Accessing Grandchild C: Root -> Left -> Right
        System.out.println("Grandchild C (Right side of A): " + root.left.right.data); 

        // Accessing Grandchild D: Root -> Left -> Left
        System.out.println("Grandchild D (Left side of A): " + root.left.left.data); 
        
        System.out.println("\n(To find data, you follow a path, not a line.)");
    }
}