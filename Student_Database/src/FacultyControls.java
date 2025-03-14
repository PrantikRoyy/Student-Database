

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

public class FacultyControls extends JPanel{
	private JButton AddFaculty;
	private JButton DeleteFaculty;
	private JButton ClearAllFacultys;
	private JButton UpdateFaculty;
	private JButton ShowAllFaculty;
	private JButton SelectFaculty;
	private JButton GoToContactInfo;
	private JButton GoToSchoolRecord;
	private JButton GoToPerson;
	private JButton GoToInitial;
	private JButton GoToStudentRecord;
	private Inputs AddFacultyInputs;
	private Inputs DeleteFacultyInputs;
	private Inputs UpdateFacultyInputs;
	private Inputs SelectFacultyInputs;
	JPanel panel = new JPanel();
	private Title title;
	
	// Constructor for initializing the JPanel and its fields
	FacultyControls() {
		// Sets the back ground color and size of the Control JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of this JPanel to be orange
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		//this.add(scrollbar);
		title = new Title("Faculty Interface");
		this.add(title);
		
		setAddFaculty();
		setDeleteFaculty();
		setUpdateFaculty();
		setSelectFaculty();
		setShowAllFaculty();
		setClearAllFacultys();
		setGoToContactInfo();
		setGoToSchoolRecord();
		setGoToPerson();
		setGoToInitial();
		setGoToStudentRecord();
		//panel.setSize(new Dimension(200, 500));
		//panel.setPreferredSize(new Dimension(200, 500));
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
	public void setAddFaculty() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Add a Note" button.
		AddFaculty = new JButton("Add Faculty");
		// sets the size of the button
		AddFaculty.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		AddFaculty.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		AddFaculty.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		AddFacultyInputs = new Inputs();
		AddFacultyInputs.add(setTextArea("ID"));
		AddFacultyInputs.add(setTextArea("JobID"));
		AddFacultyInputs.add(setTextArea("Salary"));
		AddFacultyInputs.add(setTextArea("HireDate"));
		AddFacultyInputs.add(setTextArea("JobTittle"));
		AddFacultyInputs.add(setTextArea("JobStatus"));
		
		panel.add(AddFaculty);
		panel.add(AddFacultyInputs);
		//this.add(panel);
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setDeleteFaculty() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Add a Note" button.
		DeleteFaculty = new JButton("Delete Faculty");
		// sets the size of the button
		DeleteFaculty.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		DeleteFaculty.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		DeleteFaculty.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		DeleteFacultyInputs = new Inputs();
		DeleteFacultyInputs.add(setTextArea("ID"));
		DeleteFacultyInputs.add(setTextArea("JobID"));
		
		panel.add(DeleteFaculty);
		panel.add(DeleteFacultyInputs);
		//this.add(panel);		
	}
	
	public void setUpdateFaculty() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Clear All Notes" button.
		UpdateFaculty = new JButton("Update Faculty");
		// sets the size of the button
		UpdateFaculty.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		UpdateFaculty.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		UpdateFaculty.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		UpdateFacultyInputs = new Inputs();
		UpdateFacultyInputs.add(setTextArea("ID"));
		UpdateFacultyInputs.add(setTextArea("JobID"));
		UpdateFacultyInputs.add(setTextArea("Salary"));
		UpdateFacultyInputs.add(setTextArea("HireDate"));
		UpdateFacultyInputs.add(setTextArea("JobTittle"));
		UpdateFacultyInputs.add(setTextArea("JobStatus"));
		
		panel.add(UpdateFaculty);
		panel.add(UpdateFacultyInputs);
		//this.add(panel);		
	}
	
	public void setSelectFaculty() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Clear All Notes" button.
		SelectFaculty = new JButton("Select Faculty");
		// sets the size of the button
		SelectFaculty.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		SelectFaculty.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		SelectFaculty.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		SelectFacultyInputs = new Inputs();
		SelectFacultyInputs.add(setTextArea("ID"));
		SelectFacultyInputs.add(setTextArea("JobID"));
		
		panel.add(SelectFaculty);
		panel.add(SelectFacultyInputs);
		//this.add(panel);		
	}
	
	public void setShowAllFaculty() {		
		// makes the JButton representing "Clear All Notes" button.
		ShowAllFaculty = new JButton("Select all Facultys");
		// sets the size of the button
		ShowAllFaculty.setPreferredSize(new Dimension(200, 30));
		// sets the font of the text in the JButton
		ShowAllFaculty.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ShowAllFaculty.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ShowAllFaculty);		
	}
	
	/**
	 * This method generates the clear notes button of this control panel that deletes all the tasks currently shown
	 */
	public void setClearAllFacultys() {
		// makes the JButton representing "Clear All Notes" button.
		ClearAllFacultys = new JButton("Clear All Facultys");
		// sets the size of the button
		ClearAllFacultys.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		ClearAllFacultys.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ClearAllFacultys.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ClearAllFacultys);
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
	
	public JButton getGoToInitial() {
		return this.GoToInitial;
	}
	
	// getter method for the addNote JButton
	public JButton getAddFaculty() {
		return this.AddFaculty;
	}
	
	// getter method for the clearNotes JButton
	public JButton getDeleteFaculty() {
		return this.DeleteFaculty;
	}
	
	// getter method for the saveNotes JButton
	public JButton getClearAllFacultys() {
		return this.ClearAllFacultys;
	}
	
	// getter method for the saveNotes JButton
	public JButton getUpdateFaculty() {
		return this.UpdateFaculty;
	}
	
	public JButton getSelectFaculty() {
		return this.SelectFaculty;
	}
	
	public JButton getShowAllFaculty() {
		return this.ShowAllFaculty;
	}
	
	public JButton getGoToContactInfo() {
		return this.GoToContactInfo;
	}
	
	public JButton getGoToSchoolRecord() {
		return this.GoToSchoolRecord;
	}
	
	public JButton getGoToPerson() {
		return this.GoToPerson;
	}
	
	public JButton getGoToStudentRecord() {
		return this.GoToStudentRecord;
	}
	
	// getter method for the addNote JButton
	public Inputs getAddFacultyInputs() {
		return this.AddFacultyInputs;
	}
		
	// getter method for the addNote JButton
	public Inputs getDeleteFacultyInputs() {
		return this.DeleteFacultyInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getUpdateFacultyInputs() {
		return this.UpdateFacultyInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getSelectFacultyInputs() {
		return this.SelectFacultyInputs;
	}
}
