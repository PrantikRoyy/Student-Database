

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is where the title JPanel of the 'To Do List' and all the panels buttons are initiated.
 * 
 * titleText The JLabel that holds the name of the title for this 'To Do List' application
 */

public class Title extends JPanel{
	private JLabel titleText;
	
	// Constructor for initializing the JPanel and its fields
	public Title(String title) {
		// sets the background color and size of this JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of the title to be orange
		this.setPreferredSize(new Dimension(400, 50));
		
		// sets the JLabel of the title JPanel which contains the text of the Title that displayed
		titleText = new JLabel(title);
		// sets the size of the JLabel
		titleText.setPreferredSize(new Dimension(200, 50));
		// sets the font of the text inside of the JLabel
		titleText.setFont(new Font("Sans-serf", Font.BOLD, 20));
		// sets the JLabel to be located at the center of this JPanel
		titleText.setHorizontalAlignment(titleText.CENTER);
		// adds the JLabel inside of this JPanel
		this.add(titleText);  
	}
}
