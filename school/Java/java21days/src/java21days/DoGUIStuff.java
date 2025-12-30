package java21days;
import java.awt.Dimension;

import javax.swing.*;

public class DoGUIStuff extends JFrame {
	

	public DoGUIStuff() {
		super("Some GUI Stuff");
	    setSize(300, 150);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel 		pane1 		= new JPanel();
	   	JLabel 		nameLabel	= new JLabel("Name: ");
	   	JLabel 		result		= new JLabel("Result: ");
	   	JLabel 		result2		= new JLabel();
	   	JTextField 	name		= new JTextField(20);
	   	JButton 	ok			= new JButton("Enter");
	   	ok.setPreferredSize(new Dimension(250, 20));

	    pane1.add(nameLabel);
	    pane1.add(name);
	    pane1.add(ok);
	    pane1.add(result);
	    pane1.add(result2);

	    add(pane1);
	    setVisible(true);
	    
	    
	    ok.addActionListener(e -> {
	    	result2.setText(name.getText());
	    	JOptionPane.showConfirmDialog(null,
	    			name.getText(),
	    		     "You pressed a button!",
	    		     JOptionPane.YES_NO_OPTION,
	    		     JOptionPane.PLAIN_MESSAGE);

        });
        
    }


	
	   public static void main(String[] arguments) {
		   DoGUIStuff auth = new DoGUIStuff();
	   }

}
