import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This class is where the list JPanel of the 'To Do List' and all the panel's buttons are initiated.
 * 
 */

public class Inputs extends JPanel{
	
	// Constructor for initializing the JPanel and its fields 
	Inputs() {
		// sets the back ground color of the JPanel
		this.setBackground(Color.yellow);
		// sets the JPanel to have not border
		this.setBorder(BorderFactory.createEmptyBorder());
		/* Creates a GridLayout object that specifies that the components of this JPanel should be arranged in a grid with 1 
		 * column and any number of rows to make sure the tasks are stacked vertically 1 by 1 */
		GridLayout layout = new GridLayout(0, 1);
		// sets the space between the notes to be 5 pixels
		layout.setVgap(5);
		// adds the specifications for the grid layout specified in 'layout' to this JPanel
		this.setLayout(layout);
	}
}
