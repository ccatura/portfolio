package tests;

import javax.swing.*;
import java.awt.*;

/**
 * GUI01 demonstrates a simple two-window Swing application.
 * It follows the pattern: Collect input -> Dispose window -> Show results.
 */
public class GUI01 {

    public static void main(String[] args) {
        // Entry point: Initialize and display the first window.
        showInputWindow();
    }

    /**
     * Creates and displays the first window (Input Phase).
     */
    private static void showInputWindow() {
        // 1. Setup the Frame (The Window Container)
        JFrame inputFrame = new JFrame("Input Info");
        
        // GridLayout(rows, cols, hgap, vgap) organizes components in a grid.
        inputFrame.setLayout(new GridLayout(3, 2, 5, 5));
        
        // Ensures the application closes completely when the 'X' is clicked.
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Create UI Components
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JButton submitButton = new JButton("Submit");

        // 3. Add Components to the Frame
        // Order matters in GridLayout: it fills Row 1 Left to Right, then Row 2, etc.
        inputFrame.add(new JLabel("First Name:")); // Row 1, Col 1
        inputFrame.add(firstNameField);            // Row 1, Col 2
        inputFrame.add(new JLabel("Last Name:"));  // Row 2, Col 1
        inputFrame.add(lastNameField);             // Row 2, Col 2
        inputFrame.add(new JLabel(""));            // Row 3, Col 1 (Empty spacer)
        inputFrame.add(submitButton);              // Row 3, Col 2

        // 4. Define Behavior (The 'Action')
        // This code runs only when the user clicks the 'Submit' button.
        submitButton.addActionListener(e -> {
            // Retrieve text entered by the user
            String fullInfo = firstNameField.getText() + " " + lastNameField.getText();
            
            // Close the current window to free memory
            inputFrame.dispose(); 
            
            // Launch the second window, passing the captured data
            showResultWindow(fullInfo); 
        });

        // 5. Finalize Window Display
        inputFrame.pack();                  // Resizes the window to fit the components
        inputFrame.setLocationRelativeTo(null); // Centers the window on the screen
        inputFrame.setVisible(true);        // Makes the window appear
    }

    /**
     * Creates and displays the second window (Result Phase).
     * @param data The string to display in the result window.
     */
    private static void showResultWindow(String data) {
        // 1. Setup the Result Frame
        JFrame resultFrame = new JFrame("Results");
        
        // FlowLayout simply places components in a row.
        resultFrame.setLayout(new FlowLayout());
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Create Components
        JLabel infoLabel = new JLabel("You entered: " + data);
        JButton closeButton = new JButton("Close App");

        // 3. Define Behavior
        // System.exit(0) shuts down the entire Java Virtual Machine.
        closeButton.addActionListener(e -> System.exit(0));

        // 4. Add Components
        resultFrame.add(infoLabel);
        resultFrame.add(closeButton);

        // 5. Finalize Window Display
        resultFrame.setSize(300, 150);      // Explicitly set dimensions
        resultFrame.setLocationRelativeTo(null); // Center window
        resultFrame.setVisible(true);        // Display
    }
}