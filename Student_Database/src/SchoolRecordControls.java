

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

public class SchoolRecordControls extends JPanel{
	private JButton AddSchoolRecord;
	private JButton DeleteSchoolRecord;
	private JButton ClearAllSchoolRecords;
	private JButton UpdateSchoolRecord;
	private JButton ShowAllSchoolRecord;
	private JButton SelectSchoolRecord;
	private JButton GoToContactInfo;
	private JButton GoToPerson;
	private JButton GoToStudentRecord;
	private JButton GoToInitial;
	private JButton GoToFaculty;
	private Inputs AddSchoolRecordInputs;
	private Inputs DeleteSchoolRecordInputs;
	private Inputs UpdateSchoolRecordInputs;
	private Inputs SelectSchoolRecordInputs;
	private Title title;
	JPanel panel = new JPanel();
	
	// Constructor for initializing the JPanel and its fields
	SchoolRecordControls() {
		// Sets the back ground color and size of the Control JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of this JPanel to be orange
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		title = new Title("School Record Interface");
		title.setSize(new Dimension(600, 50));
		title.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		this.add(title, BorderLayout.NORTH);
		
		setAddSchoolRecord();
		setDeleteSchoolRecord();
		setUpdateSchoolRecord();
		setSelectSchoolRecord();
		setShowAllSchoolRecord();
		setClearAllSchoolRecords();
		setGoToContactInfo();
		setGoToPerson();
		setGoToStudentRecord();
		setGoToInitial();
		setGoToFaculty();
		panel.setSize(new Dimension(200, 700));
		panel.setPreferredSize(new Dimension(200, 700));
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
	public void setAddSchoolRecord() {		
		// makes the JButton representing "Add a Note" button.
		AddSchoolRecord = new JButton("Add School Record");
		// sets the size of the button
		AddSchoolRecord.setPreferredSize(new Dimension(210, 30));
		// sets the font of the text in the JButton
		AddSchoolRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		AddSchoolRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		AddSchoolRecordInputs = new Inputs();
		AddSchoolRecordInputs.add(setTextArea("ID"));
		AddSchoolRecordInputs.add(setTextArea("isStudent"));
		AddSchoolRecordInputs.add(setTextArea("isFaculty"));
		AddSchoolRecordInputs.add(setTextArea("location"));
		AddSchoolRecordInputs.add(setTextArea("dateOfEntry"));
		AddSchoolRecordInputs.add(setTextArea("lastUpdated"));
		
		panel.add(AddSchoolRecord);
		panel.add(AddSchoolRecordInputs);
		//this.add(panel, BorderLayout.SOUTH);
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setDeleteSchoolRecord() {		
		// makes the JButton representing "Add a Note" button.
		DeleteSchoolRecord = new JButton("Delete School Record");
		// sets the size of the button
		DeleteSchoolRecord.setPreferredSize(new Dimension(210, 30));
		// sets the font of the text in the JButton
		DeleteSchoolRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		DeleteSchoolRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		DeleteSchoolRecordInputs = new Inputs();
		DeleteSchoolRecordInputs.add(setTextArea("ID"));
		
		panel.add(DeleteSchoolRecord);
		panel.add(DeleteSchoolRecordInputs);
		//this.add(panel, BorderLayout.SOUTH);		
	}
	
	public void setUpdateSchoolRecord() {		
		// makes the JButton representing "Clear All Notes" button.
		UpdateSchoolRecord = new JButton("Update School Record");
		// sets the size of the button
		UpdateSchoolRecord.setPreferredSize(new Dimension(210, 30));
		// sets the font of the text in the JButton
		UpdateSchoolRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		UpdateSchoolRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		UpdateSchoolRecordInputs = new Inputs();
		UpdateSchoolRecordInputs.add(setTextArea("ID"));
		UpdateSchoolRecordInputs.add(setTextArea("isStudent"));
		UpdateSchoolRecordInputs.add(setTextArea("isFaculty"));
		UpdateSchoolRecordInputs.add(setTextArea("location"));
		UpdateSchoolRecordInputs.add(setTextArea("dateOfEntry"));
		UpdateSchoolRecordInputs.add(setTextArea("lastUpdated"));
		
		panel.add(UpdateSchoolRecord);
		panel.add(UpdateSchoolRecordInputs);
		//this.add(panel, BorderLayout.SOUTH);		
	}
	
	public void setSelectSchoolRecord() {		
		// makes the JButton representing "Clear All Notes" button.
		SelectSchoolRecord = new JButton("Select School Record");
		// sets the size of the button
		SelectSchoolRecord.setPreferredSize(new Dimension(210, 30));
		// sets the font of the text in the JButton
		SelectSchoolRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		SelectSchoolRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		SelectSchoolRecordInputs = new Inputs();
		SelectSchoolRecordInputs.add(setTextArea("ID"));
		
		panel.add(SelectSchoolRecord);
		panel.add(SelectSchoolRecordInputs);
		//this.add(panel, BorderLayout.SOUTH);		
	}
	
	public void setShowAllSchoolRecord() {		
		// makes the JButton representing "Clear All Notes" button.
		ShowAllSchoolRecord = new JButton("Select all School Records");
		// sets the size of the button
		ShowAllSchoolRecord.setPreferredSize(new Dimension(270, 30));
		// sets the font of the text in the JButton
		ShowAllSchoolRecord.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ShowAllSchoolRecord.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ShowAllSchoolRecord);		
	}
	
	/**
	 * This method generates the clear notes button of this control panel that deletes all the tasks currently shown
	 */
	public void setClearAllSchoolRecords() {
		// makes the JButton representing "Clear All Notes" button.
		ClearAllSchoolRecords = new JButton("Clear All School Records");
		// sets the size of the button
		ClearAllSchoolRecords.setPreferredSize(new Dimension(270, 30));
		// sets the font of the text in the JButton
		ClearAllSchoolRecords.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ClearAllSchoolRecords.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ClearAllSchoolRecords);
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
	
	public void setGoToPerson() {
		// makes the JButton representing "Clear All Notes" button.
		GoToPerson = new JButton("Go To Person");
		// sets the size of the button
		GoToPerson.setPreferredSize(new Dimension(200, 30));
		// sets the font of the text in the JButton
		GoToPerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToPerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToPerson);
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
	public JButton getAddSchoolRecord() {
		return this.AddSchoolRecord;
	}
	
	// getter method for the clearNotes JButton
	public JButton getDeleteSchoolRecord() {
		return this.DeleteSchoolRecord;
	}
	
	// getter method for the saveNotes JButton
	public JButton getClearAllSchoolRecords() {
		return this.ClearAllSchoolRecords;
	}
	
	// getter method for the saveNotes JButton
	public JButton getUpdateSchoolRecord() {
		return this.UpdateSchoolRecord;
	}
	
	public JButton getSelectSchoolRecord() {
		return this.SelectSchoolRecord;
	}
	
	public JButton getShowAllSchoolRecord() {
		return this.ShowAllSchoolRecord;
	}
	
	public JButton getGoToContactInfo() {
		return this.GoToContactInfo;
	}
	
	public JButton getGoToPerson() {
		return this.GoToPerson;
	}
	
	public JButton getGoToStudentRecord() {
		return this.GoToStudentRecord;
	}
	
	// getter method for the addNote JButton
	public Inputs getAddSchoolRecordInputs() {
		return this.AddSchoolRecordInputs;
	}
		
	// getter method for the addNote JButton
	public Inputs getDeleteSchoolRecordInputs() {
		return this.DeleteSchoolRecordInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getUpdateSchoolRecordInputs() {
		return this.UpdateSchoolRecordInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getSelectSchoolRecordInputs() {
		return this.SelectSchoolRecordInputs;
	}
}
