

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is where the control JPanel of the 'To Do List' and the panel's buttons are initiated
 * 
 * addNote A JButton that represents the 'Add a Note' button of the control panel
 * 
 * clearNotes A JButton that represents the 'Clear Notes' button of the control panel
 * 
 * saveNotes A JButton that represents the 'Save Notes' button of the control panel
 * 
 * checkIfSaved A JLabel that represents the notification which indicates weather all the tasks of the 'To Do List' are saved or not
 * 
 * @author  Prantik Roy
 * @version 1.0
 * @since   2023 December 22th
 */

public class InitialControls extends JPanel{
	private JButton EnterSchoolName;
	private Inputs EnterSchoolNameInputs;
	JPanel panel = new JPanel();
	private Title title;
	
	// Constructor for initializing the JPanel and its fields
	InitialControls() {
		// Sets the back ground color and size of the Control JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of this JPanel to be orange
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		//this.add(scrollbar);
		title = new Title("Pick a School");
		this.add(title);
		
		setEnterSchoolName();
		panel.setSize(new Dimension(150, 30));
		panel.setPreferredSize(new Dimension(150, 30));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(panel);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// makes sure that the buttons are spaced out horizontally by 20 pixels
		this.add(Box.createHorizontalStrut(20));
	}
	
	public JTextField setTextArea(String text) {
		// makes the JTextArea of this JPanel that holds the string from 'text' of this task
		JTextField note = new JTextField(text);
		// sets the border of this text area to be empty
		note.setBorder(BorderFactory.createLineBorder(Color.black));
		// sets the size of the text area
		note.setSize(new Dimension(150, 20));
		note.setPreferredSize(new Dimension(150, 20));
		// sets the background color of this text area to be a darker yellow that contrasts with the yellow background of the frame
		note.setBackground(new Color(225, 215, 0));
		// adds the JTextArea into the control panel
		return note;
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setEnterSchoolName() {		
		// makes the JButton representing "Add a Note" button.
		EnterSchoolName = new JButton("Enter school name");
		// sets the size of the button
		EnterSchoolName.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		EnterSchoolName.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		EnterSchoolName.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		EnterSchoolNameInputs = new Inputs();
		EnterSchoolNameInputs.add(setTextArea(""));
		
		panel.add(EnterSchoolName);
		panel.add(EnterSchoolNameInputs);
	}
	
	public JButton getEnterSchoolName() {
		return this.EnterSchoolName;
	}
	
	public Inputs getEnterSchoolNameInputs() {
		return this.EnterSchoolNameInputs;
	}
}
