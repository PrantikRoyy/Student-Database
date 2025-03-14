

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

public class PersonControls extends JPanel{
	private JButton AddPerson;
	private JButton DeletePerson;
	private JButton ClearAllPersons;
	private JButton UpdatePerson;
	private JButton ShowAllPerson;
	private JButton SelectPerson;
	private JButton GoToContactInfo;
	private JButton GoToSchoolRecord;
	private JButton GoToStudentRecord;
	private JButton GoToInitial;
	private JButton GoToFaculty;
	private Inputs AddPersonInputs;
	private Inputs DeletePersonInputs;
	private Inputs UpdatePersonInputs;
	private Inputs SelectPersonInputs;
	JPanel panel = new JPanel();
	private Title title;
	
	// Constructor for initializing the JPanel and its fields
	PersonControls() {
		// Sets the back ground color and size of the Control JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of this JPanel to be orange
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		//this.add(scrollbar);
		title = new Title("Person Interface");
		this.add(title);
		
		setAddPerson();
		setDeletePerson();
		setUpdatePerson();
		setSelectPerson();
		setShowAllPerson();
		setClearAllPersons();
		setGoToContactInfo();
		setGoToSchoolRecord();
		setGoToStudentRecord();
		setGoToInitial();
		setGoToFaculty();
		panel.setSize(new Dimension(200, 500));
		panel.setPreferredSize(new Dimension(200, 500));
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
		note.setPreferredSize(new Dimension(150, 20));
		// sets the background color of this text area to be a darker yellow that contrasts with the yellow background of the frame
		note.setBackground(new Color(225, 215, 0));
		// adds the JTextArea into the control panel
		return note;
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setAddPerson() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Add a Note" button.
		AddPerson = new JButton("Add Person");
		// sets the size of the button
		AddPerson.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		AddPerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		AddPerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		AddPersonInputs = new Inputs();
		//PersonInputs.add(setTextArea("ID"));
		AddPersonInputs.add(setTextArea("Full Name"));
		AddPersonInputs.add(setTextArea("DOB"));
		AddPersonInputs.add(setTextArea("SIN"));
		AddPersonInputs.add(setTextArea("gender"));
		
		panel.add(AddPerson);
		panel.add(AddPersonInputs);
		//this.add(panel);
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setDeletePerson() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Add a Note" button.
		DeletePerson = new JButton("Delete Person");
		// sets the size of the button
		DeletePerson.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		DeletePerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		DeletePerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		DeletePersonInputs = new Inputs();
		DeletePersonInputs.add(setTextArea("ID"));
		
		panel.add(DeletePerson);
		panel.add(DeletePersonInputs);
		//this.add(panel);		
	}
	
	public void setUpdatePerson() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Clear All Notes" button.
		UpdatePerson = new JButton("Update Person");
		// sets the size of the button
		UpdatePerson.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		UpdatePerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		UpdatePerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		UpdatePersonInputs = new Inputs();
		UpdatePersonInputs.add(setTextArea("ID"));
		UpdatePersonInputs.add(setTextArea("Full Name"));
		UpdatePersonInputs.add(setTextArea("DOB"));
		UpdatePersonInputs.add(setTextArea("SIN"));
		UpdatePersonInputs.add(setTextArea("gender"));
		
		panel.add(UpdatePerson);
		panel.add(UpdatePersonInputs);
		//this.add(panel);		
	}
	
	public void setSelectPerson() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Clear All Notes" button.
		SelectPerson = new JButton("Select Person");
		// sets the size of the button
		SelectPerson.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		SelectPerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		SelectPerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		SelectPersonInputs = new Inputs();
		SelectPersonInputs.add(setTextArea("ID or Full Name"));
		
		panel.add(SelectPerson);
		panel.add(SelectPersonInputs);
		//this.add(panel);		
	}
	
	public void setShowAllPerson() {		
		// makes the JButton representing "Clear All Notes" button.
		ShowAllPerson = new JButton("Select all Persons");
		// sets the size of the button
		ShowAllPerson.setPreferredSize(new Dimension(200, 30));
		// sets the font of the text in the JButton
		ShowAllPerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ShowAllPerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ShowAllPerson);		
	}
	
	/**
	 * This method generates the clear notes button of this control panel that deletes all the tasks currently shown
	 */
	public void setClearAllPersons() {
		// makes the JButton representing "Clear All Notes" button.
		ClearAllPersons = new JButton("Clear All Persons");
		// sets the size of the button
		ClearAllPersons.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		ClearAllPersons.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ClearAllPersons.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ClearAllPersons);
	}
	
	public void setGoToContactInfo() {
		// makes the JButton representing "Clear All Notes" button.
		GoToContactInfo = new JButton("Go To Contact Information Interface");
		// sets the size of the button
		GoToContactInfo.setPreferredSize(new Dimension(350, 30));
		// sets the font of the text in the JButton
		GoToContactInfo.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToContactInfo.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToContactInfo);
	}
	
	public void setGoToSchoolRecord() {
		// makes the JButton representing "Clear All Notes" button.
		GoToSchoolRecord = new JButton("Go To School Record");
		// sets the size of the button
		GoToSchoolRecord.setPreferredSize(new Dimension(350, 30));
		// sets the font of the text in the JButton
		GoToSchoolRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToSchoolRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToSchoolRecord);
	}
	
	public void setGoToStudentRecord() {
		// makes the JButton representing "Clear All Notes" button.
		GoToStudentRecord = new JButton("Go To Student Records");
		// sets the size of the button
		GoToStudentRecord.setPreferredSize(new Dimension(350, 30));
		// sets the font of the text in the JButton
		GoToStudentRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToStudentRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToStudentRecord);
	}
	
	public void setGoToInitial() {
		// makes the JButton representing "Clear All Notes" button.
		GoToInitial = new JButton("Go To Initial Interface");
		// sets the size of the button
		GoToInitial.setPreferredSize(new Dimension(350, 30));
		// sets the font of the text in the JButton
		GoToInitial.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToInitial.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToInitial);
	}
	
	public void setGoToFaculty() {
		// makes the JButton representing "Clear All Notes" button.
		GoToFaculty = new JButton("Go To Faculty Interface");
		// sets the size of the button
		GoToFaculty.setPreferredSize(new Dimension(350, 30));
		// sets the font of the text in the JButton
		GoToFaculty.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToFaculty.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToFaculty);
	}
	
	public JButton getGoToFaculty() {
		return this.GoToFaculty;
	}
	
	public JButton getGoToInitial() {
		return this.GoToInitial;
	}
		
	// getter method for the addNote JButton
	public JButton getAddPerson() {
		return this.AddPerson;
	}
	
	// getter method for the clearNotes JButton
	public JButton getDeletePerson() {
		return this.DeletePerson;
	}
	
	// getter method for the saveNotes JButton
	public JButton getClearAllPersons() {
		return this.ClearAllPersons;
	}
	
	// getter method for the saveNotes JButton
	public JButton getUpdatePerson() {
		return this.UpdatePerson;
	}
	
	public JButton getSelectPerson() {
		return this.SelectPerson;
	}
	
	public JButton getShowAllPerson() {
		return this.ShowAllPerson;
	}
	
	public JButton getGoToContactInfo() {
		return this.GoToContactInfo;
	}
	
	public JButton getGoToSchoolRecord() {
		return this.GoToSchoolRecord;
	}
	
	public JButton getGoToStudentRecord() {
		return this.GoToStudentRecord;
	}
	
	// getter method for the addNote JButton
	public Inputs getAddPersonInputs() {
		return this.AddPersonInputs;
	}
		
	// getter method for the addNote JButton
	public Inputs getDeletePersonInputs() {
		return this.DeletePersonInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getUpdatePersonInputs() {
		return this.UpdatePersonInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getSelectPersonInputs() {
		return this.SelectPersonInputs;
	}
}
