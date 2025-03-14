

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

public class StudentControls extends JPanel{
	private JButton AddStudent;
	private JButton DeleteStudent;
	private JButton ClearAllStudents;
	private JButton UpdateStudent;
	private JButton ShowAllStudent;
	private JButton SelectStudent;
	private JButton GoToContactInfo;
	private JButton GoToSchoolRecord;
	private JButton GoToPerson;
	private JButton GoToInitial;
	private JButton GoToFaculty;
	private Inputs AddStudentInputs;
	private Inputs DeleteStudentInputs;
	private Inputs UpdateStudentInputs;
	private Inputs SelectStudentInputs;
	JPanel panel = new JPanel();
	private Title title;
	
	// Constructor for initializing the JPanel and its fields
	StudentControls() {
		// Sets the back ground color and size of the Control JPanel
		this.setBackground(new Color(255, 174, 66)); // sets the background color of this JPanel to be orange
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		//this.add(scrollbar);
		title = new Title("Student Interface");
		this.add(title);
		
		setAddStudent();
		setDeleteStudent();
		setUpdateStudent();
		setSelectStudent();
		setShowAllStudent();
		setClearAllStudents();
		setGoToContactInfo();
		setGoToSchoolRecord();
		setGoToPerson();
		setGoToInitial();
		setGoToFaculty();
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
	public void setAddStudent() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Add a Note" button.
		AddStudent = new JButton("Add Student");
		// sets the size of the button
		AddStudent.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		AddStudent.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		AddStudent.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		AddStudentInputs = new Inputs();
		AddStudentInputs.add(setTextArea("ID"));
		AddStudentInputs.add(setTextArea("StudentID"));
		AddStudentInputs.add(setTextArea("Program"));
		AddStudentInputs.add(setTextArea("Progression"));
		AddStudentInputs.add(setTextArea("Tuition"));
		AddStudentInputs.add(setTextArea("AcademicYear"));
		AddStudentInputs.add(setTextArea("Semester"));
		
		panel.add(AddStudent);
		panel.add(AddStudentInputs);
		//this.add(panel);
	}
	
	/**
	 * This method generates the add note button of this control panel that adds a task
	 */
	public void setDeleteStudent() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Add a Note" button.
		DeleteStudent = new JButton("Delete Student");
		// sets the size of the button
		DeleteStudent.setPreferredSize(new Dimension(150, 30));
		// sets the font of the text in the JButton
		DeleteStudent.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		DeleteStudent.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		DeleteStudentInputs = new Inputs();
		DeleteStudentInputs.add(setTextArea("ID"));
		DeleteStudentInputs.add(setTextArea("StudentID"));
		
		panel.add(DeleteStudent);
		panel.add(DeleteStudentInputs);
		//this.add(panel);		
	}
	
	public void setUpdateStudent() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Clear All Notes" button.
		UpdateStudent = new JButton("Update Student");
		// sets the size of the button
		UpdateStudent.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		UpdateStudent.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		UpdateStudent.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		UpdateStudentInputs = new Inputs();
		UpdateStudentInputs.add(setTextArea("ID"));
		UpdateStudentInputs.add(setTextArea("StudentID"));
		UpdateStudentInputs.add(setTextArea("Program"));
		UpdateStudentInputs.add(setTextArea("Progression"));
		UpdateStudentInputs.add(setTextArea("Tuition"));
		UpdateStudentInputs.add(setTextArea("AcademicYear"));
		UpdateStudentInputs.add(setTextArea("Semester"));
		
		panel.add(UpdateStudent);
		panel.add(UpdateStudentInputs);
		//this.add(panel);		
	}
	
	public void setSelectStudent() {
		//JPanel panel = new JPanel();
		
		// makes the JButton representing "Clear All Notes" button.
		SelectStudent = new JButton("Select Student");
		// sets the size of the button
		SelectStudent.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		SelectStudent.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		SelectStudent.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		
		SelectStudentInputs = new Inputs();
		SelectStudentInputs.add(setTextArea("ID"));
		SelectStudentInputs.add(setTextArea("StudentID"));
		
		panel.add(SelectStudent);
		panel.add(SelectStudentInputs);
		//this.add(panel);		
	}
	
	public void setShowAllStudent() {		
		// makes the JButton representing "Clear All Notes" button.
		ShowAllStudent = new JButton("Select all Students");
		// sets the size of the button
		ShowAllStudent.setPreferredSize(new Dimension(200, 30));
		// sets the font of the text in the JButton
		ShowAllStudent.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ShowAllStudent.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ShowAllStudent);		
	}
	
	/**
	 * This method generates the clear notes button of this control panel that deletes all the tasks currently shown
	 */
	public void setClearAllStudents() {
		// makes the JButton representing "Clear All Notes" button.
		ClearAllStudents = new JButton("Clear All Students");
		// sets the size of the button
		ClearAllStudents.setPreferredSize(new Dimension(160, 30));
		// sets the font of the text in the JButton
		ClearAllStudents.setFont(new Font("Sans-serf", Font.PLAIN, 20));
		// sets the JButton to have not border
		ClearAllStudents.setBorder(BorderFactory.createEmptyBorder());
		// adds the JButton into the control panel
		panel.add(ClearAllStudents);
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
	public JButton getAddStudent() {
		return this.AddStudent;
	}
	
	// getter method for the clearNotes JButton
	public JButton getDeleteStudent() {
		return this.DeleteStudent;
	}
	
	// getter method for the saveNotes JButton
	public JButton getClearAllStudents() {
		return this.ClearAllStudents;
	}
	
	// getter method for the saveNotes JButton
	public JButton getUpdateStudent() {
		return this.UpdateStudent;
	}
	
	public JButton getSelectStudent() {
		return this.SelectStudent;
	}
	
	public JButton getShowAllStudent() {
		return this.ShowAllStudent;
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
	
	// getter method for the addNote JButton
	public Inputs getAddStudentInputs() {
		return this.AddStudentInputs;
	}
		
	// getter method for the addNote JButton
	public Inputs getDeleteStudentInputs() {
		return this.DeleteStudentInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getUpdateStudentInputs() {
		return this.UpdateStudentInputs;
	}
	
	// getter method for the addNote JButton
	public Inputs getSelectStudentInputs() {
		return this.SelectStudentInputs;
	}
}
