package animalCounter;
import java.awt.Dimension;
import javax.swing.*;

public class AnimalCounterGUI extends JFrame {
	String welcomeMessage = "Welcome to Animal Counter!";
	Alligator allig = new Alligator();
	Sheep sheep = new Sheep();
	
	public AnimalCounterGUI() {
	   	super("Animal Counter");
	    setSize(300, 170);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel 		pane 		= new JPanel();
	   	JLabel 		welcome		= new JLabel(this.welcomeMessage);
	   	JLabel 		alligCountL	= new JLabel("Alligator count: ");
	   	JLabel 		alligCount	= new JLabel("0");
	   	JLabel 		sheepCountL	= new JLabel("Sheep count: ");
	   	JLabel 		sheepCount	= new JLabel("0");
	   	JButton 	addAllig	= new JButton("Add Alligator");
	   	JButton 	addSheep	= new JButton("Add Sheep");
	   	JButton 	alligReset	= new JButton("Reset Alligators");
	   	JButton 	sheepReset	= new JButton("Reset Sheep");
	   	JButton 	exit		= new JButton("Exit");
	   	
        JOptionPane.showMessageDialog(null, welcome);

	    pane.add(alligCountL);
	    pane.add(alligCount);
	    pane.add(sheepCountL);
	    pane.add(sheepCount);
	    pane.add(addAllig);
	    pane.add(addSheep);
	    pane.add(alligReset);
	    pane.add(sheepReset);
	    pane.add(exit);

	    add(pane);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    
	    addAllig.addActionListener(e -> {
	    	allig.incrementCount();
	    	alligCount.setText(String.valueOf(allig.getCount()));
	    	if (allig.getCount() > sheep.getCount()) {
	    		JOptionPane.showMessageDialog(null, "Please add more sheep for the hungry alligators");
	    	}
	    	
	    	if (allig.getCount() >= 1 && sheep.getCount() >= 1) {
	    		 for (int i=0; i < allig.getCount(); i++) {
	    			 sheep.removeSheep();
	    			 sheepCount.setText(String.valueOf(sheep.getCount()));
	    			 JOptionPane.showMessageDialog(null, "A sheep was eaten.");
	    		 }
	    	}
        });

	    addSheep.addActionListener(e -> {
	    	sheep.incrementCount();
	    	sheepCount.setText(String.valueOf(sheep.getCount()));
	    	if (allig.getCount() == 0 && sheep.getCount() > 0) {
	    		JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe");
	    	}
	    	
	    	if (allig.getCount() >= 1 && sheep.getCount() >= 1) {
	    		 for (int i=0; i < allig.getCount(); i++) {
	    			 if (sheep.getCount() >= 1) {
		    			 sheep.removeSheep();
		    			 sheepCount.setText(String.valueOf(sheep.getCount()));
		    			 JOptionPane.showMessageDialog(null, "A sheep was eaten.");
	    			 }
	    		 }
	    	}
	    	
	    	if (allig.getCount() >= 2 && sheep.getCount() == 0) {
	    		JOptionPane.showMessageDialog(null, "You can't add more sheep if there are too many alligators. rest your alligator count.");
	    	}
        });

	    alligReset.addActionListener(e -> {
	    	allig.resetCount();
	    	alligCount.setText(String.valueOf(allig.getCount()));
        });
	    
	    sheepReset.addActionListener(e -> {
	    	sheep.resetCount();
	    	sheepCount.setText(String.valueOf(sheep.getCount()));
        });
	    
	    exit.addActionListener(e -> {
	    	System.exit(0);
	    });
    }
	
	   public static void main(String[] arguments) {
		   AnimalCounterGUI animalCounter = new AnimalCounterGUI();
	   }
	
	
	
	
}
