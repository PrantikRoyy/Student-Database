

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

public class ContactInfoControls extends JPanel{
	private JButton AddContactInfo;
	private JButton DeleteContactInfo;
	private JButton ClearAllContactInfos;
	private JButton UpdateContactInfo;
	private JButton ShowAllContactInfo;
	private JButton SelectContactInfo;
	private JButton GoToPerson;
	private JButton GoToSchoolRecord;
	private JButton GoToStudentRecord;
	private JButton GoToInitial;
	private JButton GoToFaculty;
	private Inputs AddContactInfoInputs;
	private Inputs DeleteContactInfoInputs;
	private Inputs UpdateContactInfoInputs;
	private Inputs SelectContactInfoInputs;
	private Title title;
	JPanel panel = new JPanel();
	
	// Constructor for initializing the JPanel and its fields
	ContactInfoControls() {
		// Sets the back ground color and size of the Control JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of this JPanel to be orange
		this.setPreferredSize(new Dimension(400, 40));
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		title = new Title("ContactInfo Interface");
		this.add(title, BorderLayout.NORTH);
		
		setAddContactInfo();
		setDeleteContactInfo();
		setUpdateContactInfo();
		setSelectContactInfo();
		setShowAllContactInfo();
		setClearAllContactInfos();
		setGoToPerson();
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
	public void setAddContactInfo() {		
		// makes the JButton representing "Add a Note" button.
		AddContactInfo = new JButton("Add ContactInfo");
		// sets the size of the button
		AddContactInfo.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		AddContactInfo.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		AddContactInfo.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		AddContactInfoInputs = new Inputs();
		AddContactInfoInputs.add(setTextArea("ID"));
		AddContactInfoInputs.add(setTextArea("HomeAddress"));
		AddContactInfoInputs.add(setTextArea("EmailAddress"));
		AddContactInfoInputs.add(setTextArea("PhoneNumbers"));
		
		panel.add(AddContactInfo);
		panel.add(AddContactInfoInputs);
		//this.add(panel, BorderLayout.SOUTH);
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setDeleteContactInfo() {		
		// makes the JButton representing "Add a Note" button.
		DeleteContactInfo = new JButton("Delete ContactInfo");
		// sets the size of the button
		DeleteContactInfo.setPreferredSize(new Dimension(170, 30));
		// sets the font of the text in the JButton
		DeleteContactInfo.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		DeleteContactInfo.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		DeleteContactInfoInputs = new Inputs();
		DeleteContactInfoInputs.add(setTextArea("ID"));
		
		panel.add(DeleteContactInfo);
		panel.add(DeleteContactInfoInputs);
		//this.add(panel, BorderLayout.SOUTH);		
	}
	
	public void setUpdateContactInfo() {		
		// makes the JButton representing "Clear All Notes" button.
		UpdateContactInfo = new JButton("Update ContactInfo");
		// sets the size of the button
		UpdateContactInfo.setPreferredSize(new Dimension(180, 30));
		// sets the font of the text in the JButton
		UpdateContactInfo.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		UpdateContactInfo.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		UpdateContactInfoInputs = new Inputs();
		UpdateContactInfoInputs.add(setTextArea("ID"));
		UpdateContactInfoInputs.add(setTextArea("HomeAddress"));
		UpdateContactInfoInputs.add(setTextArea("EmailAddress"));
		UpdateContactInfoInputs.add(setTextArea("PhoneNumbers"));
		
		panel.add(UpdateContactInfo);
		panel.add(UpdateContactInfoInputs);
		//this.add(panel, BorderLayout.SOUTH);		
	}
	
	public void setSelectContactInfo() {		
		// makes the JButton representing "Clear All Notes" button.
		SelectContactInfo = new JButton("Select ContactInfo");
		// sets the size of the button
		SelectContactInfo.setPreferredSize(new Dimension(190, 30));
		// sets the font of the text in the JButton
		SelectContactInfo.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		SelectContactInfo.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		SelectContactInfoInputs = new Inputs();
		SelectContactInfoInputs.add(setTextArea("ID or Full Name"));
		
		panel.add(SelectContactInfo);
		panel.add(SelectContactInfoInputs);
		//this.add(panel, BorderLayout.SOUTH);		
	}
	
	public void setShowAllContactInfo() {		
		// makes the JButton representing "Clear All Notes" button.
		ShowAllContactInfo = new JButton("Select all ContactInfos");
		// sets the size of the button
		ShowAllContactInfo.setPreferredSize(new Dimension(210, 30));
		// sets the font of the text in the JButton
		ShowAllContactInfo.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ShowAllContactInfo.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ShowAllContactInfo);		
	}
	
	/**
	 * This method generates the clear notes button of this control panel that deletes all the tasks currently shown
	 */
	public void setClearAllContactInfos() {
		// makes the JButton representing "Clear All Notes" button.
		ClearAllContactInfos = new JButton("Clear All ContactInfos");
		// sets the size of the button
		ClearAllContactInfos.setPreferredSize(new Dimension(210, 30));
		// sets the font of the text in the JButton
		ClearAllContactInfos.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ClearAllContactInfos.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ClearAllContactInfos);
	}
	
	public void setGoToPerson() {
		// makes the JButton representing "Clear All Notes" button.
		GoToPerson = new JButton("Go To Person Interface");
		// sets the size of the button
		GoToPerson.setPreferredSize(new Dimension(250, 30));
		// sets the font of the text in the JButton
		GoToPerson.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		GoToPerson.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(GoToPerson);
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
	public JButton getAddContactInfo() {
		return this.AddContactInfo;
	}
	
	// getter method for the clearNotes JButton
	public JButton getDeleteContactInfo() {
		return this.DeleteContactInfo;
	}
	
	// getter method for the saveNotes JButton
	public JButton getClearAllContactInfos() {
		return this.ClearAllContactInfos;
	}
	
	// getter method for the saveNotes JButton
	public JButton getUpdateContactInfo() {
		return this.UpdateContactInfo;
	}
	
	public JButton getSelectContactInfo() {
		return this.SelectContactInfo;
	}
	
	public JButton getShowAllContactInfo() {
		return this.ShowAllContactInfo;
	}
	
	public JButton getGoToPerson() {
		return this.GoToPerson;
	}
	
	public JButton getGoToSchoolRecord() {
		return this.GoToSchoolRecord;
	}
	
	public JButton getGoToStudentRecord() {
		return this.GoToStudentRecord;
	}
	
	// getter method for the addNote JButton
	public Inputs getAddContactInfoInputs() {
		return this.AddContactInfoInputs;
	}
		
	// getter method for the addNote JButton
	public Inputs getDeleteContactInfoInputs() {
		return this.DeleteContactInfoInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getUpdateContactInfoInputs() {
		return this.UpdateContactInfoInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getSelectContactInfoInputs() {
		return this.SelectContactInfoInputs;
	}
}
