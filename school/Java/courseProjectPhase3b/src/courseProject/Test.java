package courseProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class Test {

public static void main(String[] args) {
        
        // --- BEST PRACTICE: Run GUI setup on the Event Dispatch Thread (EDT) ---
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 1. INSTANTIATE THE FRAME (THE WINDOW)
                JFrame frame = new JFrame("Simple Name Input");

                // Set layout to 2 Rows and 2 Columns
                frame.setLayout(new GridLayout(10, 2, 10, 5)); 
                
                // 2. CONFIGURE THE FRAME 
                frame.setPreferredSize(new Dimension(350, 520)); 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                frame.setLocationRelativeTo(null); 
                
                // 3. CREATE COMPONENTS
                JTextField nameField = new JTextField(15);
                JButton submitButton = new JButton("Submit Name");
                JLabel statusLabel = new JLabel("Status: Ready");

                // 4. ADD ACTION LISTENER 
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        // --- CORE LOGIC: Retrieve and Store the Name ---
                        // This variable now holds the user's input string.
                        String submittedName = nameField.getText().trim();
                        
                        if (submittedName.isEmpty()) {
                            statusLabel.setText("Status: Please enter your name.");
                        } else {
                            // Use the captured variable 'submittedName' for output verification
                            statusLabel.setText("Status: Captured Name: \"" + submittedName + "\"");
                            nameField.setText("");
                        }
                    }
                });

                // 5. ADD COMPONENTS TO THE FRAME 
                
                // Row 1: Name Label and Field
                frame.add(new JLabel("Enter Name:"));
                frame.add(nameField); 
                
                // Row 2: Submit Button and Status Label
                frame.add(submitButton); 
                frame.add(statusLabel); 
                
                // 6. DISPLAY THE FRAME 
                frame.pack();
                frame.setVisible(true); 
                

                
            }
            
        }); 
    }


	
}
