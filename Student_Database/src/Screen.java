import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Screen extends JFrame{
	
	private Screen screen = this;
	private Title title; 
	private InitialControls initialController = new InitialControls();
	private PersonControls personController = new PersonControls();
	private ContactInfoControls contactInfoController = new ContactInfoControls();
	private SchoolRecordControls schoolRecordController = new SchoolRecordControls();
	private StudentControls studentController = new StudentControls();
	private FacultyControls facultyController = new FacultyControls();
	private ArrayList<String> result;
	private JScrollPane controlInterface;
	private boolean student = false, faculty = false;
	private String SchoolName = "None";
//	private JScrollPane personController = new JScrollPane(new PersonControls());
//	private JScrollPane contactInfoController = new JScrollPane(new ContactInfoControls());
//	private JScrollPane schoolRecordController = new JScrollPane(new SchoolRecordControls());
	
	public static void main(String[] args) throws IOException {
		Screen start = new Screen();
	}
	
	// Constructor for initializing the JFrame and its fields
	public Screen() throws IOException {
		DeleteFrom.setSafeUpdateOff();
		// Setting the size of the frame
		this.setSize(700, 700);
		//this.setPreferredSize(new Dimension(700, 700)); 
		
		// Sets the program to be terminated once the upper right close button is clicked
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Tells the frame to show all its components
		this.setVisible(true);
		
		// Tells the frame that it can be resized
		this.setResizable(true);
		
		// Initializes the title of the "To Do List" and puts it at the top of the frame
		title = new Title("Student Database");
		this.add(title, BorderLayout.NORTH);
		
		// Initializes the control panels and puts it on the bottom of the frame
		controlInterface = new JScrollPane(initialController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(controlInterface, BorderLayout.CENTER);		
		ActionListener();
		
		revalidate();          // Recalculate layout
        repaint();
	}
	
	/**
	 * This class gives functionality to all the buttons of the control panel
	 * 
	 * @throws IOException Thrown when a JSON file isn't found
	 */
	public void ActionListener() throws IOException {
		initialController.getEnterSchoolName().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs EnterSchoolNameInputs = initialController.getEnterSchoolNameInputs();
				SchoolName = ((JTextField) EnterSchoolNameInputs.getComponent(0)).getText();				
				System.out.println(SchoolName);
				
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		////////////////// Person Portion
		personController.getAddPerson().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs AddPersonInputs = personController.getAddPersonInputs();
				String FullName = ((JTextField) AddPersonInputs.getComponent(0)).getText();
				String DOB = ((JTextField) AddPersonInputs.getComponent(1)).getText();
				String SIN = ((JTextField) AddPersonInputs.getComponent(2)).getText();
				String gender = ((JTextField) AddPersonInputs.getComponent(3)).getText();
				
				System.out.println(FullName + " " + DOB + SIN + gender);
				
				ArrayList<String> tempArray = InsertTo.InsertPerson(FullName, DOB, SIN, gender);
				result = tempArray;
				UpdateInterface(controlInterface);
				
				if (!tempArray.get(0).equals("One of the input values is wrong or this spefic instance already exists")) {
					screen.remove(controlInterface);
					controlInterface = new JScrollPane(contactInfoController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					screen.add(controlInterface, BorderLayout.CENTER);
				}
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getDeletePerson().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs DeletePersonInputs = personController.getDeletePersonInputs();
				String ID = ((JTextField) DeletePersonInputs.getComponent(0)).getText();
				
				result = DeleteFrom.DeletePerson(Integer.parseInt(ID));
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getUpdatePerson().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs UpdatePersonInputs = personController.getUpdatePersonInputs();
				String ID = ((JTextField) UpdatePersonInputs.getComponent(0)).getText();
				String FullName = ((JTextField) UpdatePersonInputs.getComponent(1)).getText();
				String DOB = ((JTextField) UpdatePersonInputs.getComponent(2)).getText();
				String SIN = ((JTextField) UpdatePersonInputs.getComponent(3)).getText();
				String gender = ((JTextField) UpdatePersonInputs.getComponent(4)).getText();
				
				result = UpdateFrom.UpatePerson(Integer.parseInt(ID), FullName, DOB, SIN, gender);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		 
		personController.getClearAllPersons().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				result = DeleteFrom.ClearTable("Person");
				UpdateInterface(controlInterface);
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getSelectPerson().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs SelectPersonInputs = personController.getSelectPersonInputs();
				String input = ((JTextField) SelectPersonInputs.getComponent(0)).getText();
				
				try {
					result = SelectFrom.SelectPerson(Integer.parseInt(input));
				}
				catch(Exception e1) {
					result = SelectFrom.SelectPerson(input);
				}
				
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getShowAllPerson().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				
				result = SelectFrom.SelectAll("Person");
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getGoToContactInfo().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(contactInfoController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getGoToSchoolRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(schoolRecordController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getGoToStudentRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(studentController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getGoToInitial().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(initialController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		personController.getGoToFaculty().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(facultyController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		/////////////////////////////////////////////////////// ContactInfo Portion
		
		contactInfoController.getAddContactInfo().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs AddContactInfoInputs = contactInfoController.getAddContactInfoInputs();
				String ID = ((JTextField) AddContactInfoInputs.getComponent(0)).getText();
				String HomeAddress = ((JTextField) AddContactInfoInputs.getComponent(1)).getText();
				String EmailAddress = ((JTextField) AddContactInfoInputs.getComponent(2)).getText();
				String PhoneNumbers = ((JTextField) AddContactInfoInputs.getComponent(3)).getText();
				
				System.out.println(ID + " " + HomeAddress + EmailAddress + PhoneNumbers);
				
				ArrayList<String> tempArray = InsertTo.InsertContactInfo(Integer.parseInt(ID), HomeAddress, EmailAddress, PhoneNumbers);
				result = tempArray; 
				UpdateInterface(controlInterface);
				
				if (!tempArray.get(0).equals("One of the input values is wrong or this spefic instance already exists")) {
					screen.remove(controlInterface);
					controlInterface = new JScrollPane(schoolRecordController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					screen.add(controlInterface, BorderLayout.CENTER);
				}
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		contactInfoController.getDeleteContactInfo().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs DeleteContactInfoInputs = contactInfoController.getDeleteContactInfoInputs();
				String ID = ((JTextField) DeleteContactInfoInputs.getComponent(0)).getText();
				
				result = DeleteFrom.DeleteContactInfo(Integer.parseInt(ID));
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getUpdateContactInfo().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs UpdateContactInfoInputs = contactInfoController.getUpdateContactInfoInputs();
				String ID = ((JTextField) UpdateContactInfoInputs.getComponent(0)).getText();
				String HomeAddress = ((JTextField) UpdateContactInfoInputs.getComponent(1)).getText();
				String EmailAddress = ((JTextField) UpdateContactInfoInputs.getComponent(2)).getText();
				String PhoneNumbers = ((JTextField) UpdateContactInfoInputs.getComponent(3)).getText();
				
				result = UpdateFrom.UpdateContactInfo(Integer.parseInt(ID), HomeAddress, EmailAddress, PhoneNumbers);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		contactInfoController.getClearAllContactInfos().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				result = DeleteFrom.ClearTable("ContactInfo");
				UpdateInterface(controlInterface);
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getSelectContactInfo().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs SelectContactInfoInputs = contactInfoController.getSelectContactInfoInputs();
				String input = ((JTextField) SelectContactInfoInputs.getComponent(0)).getText();
				
				try {
					result = SelectFrom.SelectContactInfo(Integer.parseInt(input));
				}
				catch(Exception e1) {
					result = SelectFrom.SelectContactInfo(input);
				}
				
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getShowAllContactInfo().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				
				
				result = SelectFrom.SelectAll("ContactInfo");
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getGoToPerson().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				System.out.println("Pressed");
				controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getGoToSchoolRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface); 
				controlInterface = new JScrollPane(schoolRecordController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getGoToStudentRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface); 
				controlInterface = new JScrollPane(studentController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getGoToInitial().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(initialController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		contactInfoController.getGoToFaculty().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(facultyController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		/////////////////////////////////////////////////////// SchoolRecord Portion
		schoolRecordController.getAddSchoolRecord().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs AddContactInfoInputs = schoolRecordController.getAddSchoolRecordInputs();
				String ID = ((JTextField) AddContactInfoInputs.getComponent(0)).getText();
				String isStudent = ((JTextField) AddContactInfoInputs.getComponent(1)).getText();
				String isFaculty = ((JTextField) AddContactInfoInputs.getComponent(2)).getText();
				String location = ((JTextField) AddContactInfoInputs.getComponent(3)).getText();
				String dateOfEntry = ((JTextField) AddContactInfoInputs.getComponent(4)).getText();
				String lastUpdated = ((JTextField) AddContactInfoInputs.getComponent(5)).getText();
				
				System.out.println(ID + " " + SchoolName + isStudent + isFaculty + location + dateOfEntry + lastUpdated);
				
				student = Boolean.parseBoolean(isStudent);
				faculty = Boolean.parseBoolean(isFaculty);
				
				ArrayList<String> tempArray = InsertTo.InsertSchoolRecord(Integer.parseInt(ID), SchoolName, student, faculty, location, dateOfEntry, lastUpdated);
				result = tempArray; 
				UpdateInterface(controlInterface);
				
				if (!tempArray.get(0).equals("One of the input values is wrong or this spefic instance already exists")) {
					screen.remove(controlInterface);
					
					if (student) {
						controlInterface = new JScrollPane(studentController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					}
					else {
						controlInterface = new JScrollPane(facultyController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					}
					screen.add(controlInterface, BorderLayout.CENTER);
				}
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		schoolRecordController.getDeleteSchoolRecord().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs DeleteSchoolRecordInputs = schoolRecordController.getDeleteSchoolRecordInputs();
				String ID = ((JTextField) DeleteSchoolRecordInputs.getComponent(0)).getText();
				
				result = DeleteFrom.DeleteSchoolRecord(Integer.parseInt(ID), SchoolName);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getUpdateSchoolRecord().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs UpdateContactInfoInputs = schoolRecordController.getUpdateSchoolRecordInputs();
				String ID = ((JTextField) UpdateContactInfoInputs.getComponent(0)).getText();
				String isStudent = ((JTextField) UpdateContactInfoInputs.getComponent(1)).getText();
				String isFaculty = ((JTextField) UpdateContactInfoInputs.getComponent(2)).getText();
				String location = ((JTextField) UpdateContactInfoInputs.getComponent(3)).getText();
				String dateOfEntry = ((JTextField) UpdateContactInfoInputs.getComponent(4)).getText();
				String lastUpdated = ((JTextField) UpdateContactInfoInputs.getComponent(5)).getText();
				
				result = UpdateFrom.UpdateSchoolRecord(Integer.parseInt(ID), SchoolName, student, faculty, location, dateOfEntry, lastUpdated);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		schoolRecordController.getClearAllSchoolRecords().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				result = DeleteFrom.ClearTable("SchoolRecord", SchoolName);
				UpdateInterface(controlInterface);
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getSelectSchoolRecord().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs SelectSchoolRecordInputs = schoolRecordController.getSelectSchoolRecordInputs();
				String input = ((JTextField) SelectSchoolRecordInputs.getComponent(0)).getText();
				
				result = SelectFrom.SelectSchoolRecord(Integer.parseInt(input), SchoolName);
				
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getShowAllSchoolRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				
				System.out.println(SchoolName);
				result = SelectFrom.SelectAll("SchoolRecord", SchoolName);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getGoToPerson().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getGoToContactInfo().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(contactInfoController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getGoToStudentRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(studentController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getGoToInitial().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(initialController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		schoolRecordController.getGoToFaculty().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(facultyController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		/////////////////////////////////////////////////////// Student Portion
		studentController.getAddStudent().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs AddStudentInputs = studentController.getAddStudentInputs();
				String ID = ((JTextField) AddStudentInputs.getComponent(0)).getText();
				String StudentID = ((JTextField) AddStudentInputs.getComponent(1)).getText();
				String Program = ((JTextField) AddStudentInputs.getComponent(2)).getText();
				String Progression = ((JTextField) AddStudentInputs.getComponent(3)).getText();
				String Tuition = ((JTextField) AddStudentInputs.getComponent(4)).getText();
				String AcademicYear = ((JTextField) AddStudentInputs.getComponent(5)).getText();
				String Semester = ((JTextField) AddStudentInputs.getComponent(6)).getText();
				
				System.out.println(ID + " " + SchoolName + StudentID + Program + Progression + Tuition + AcademicYear + Semester);
				
				String temp = SelectFrom.SelectSchoolRecord(Integer.parseInt(ID), SchoolName).get(0);
				
				student = false;
				
				if (temp.contains("isStudent = 1")) {
					ArrayList<String> tempArray = InsertTo.InsertStudent(Integer.parseInt(ID), SchoolName, StudentID, Program, Progression, Double.parseDouble(Tuition), Integer.parseInt(AcademicYear), Semester);
					result  = tempArray;
					
					if (!tempArray.get(0).equals("One of the input values is wrong or this spefic instance already exists")) {
						if (temp.contains("isFaculty = 1")) {
							screen.remove(controlInterface);
							controlInterface = new JScrollPane(facultyController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
							screen.add(controlInterface, BorderLayout.CENTER);
						}
						else {
							screen.remove(controlInterface);
							controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
							screen.add(controlInterface, BorderLayout.CENTER);
						}
					}
				}
				else {
					result = new ArrayList<String>();
					result.add("The School Record of User with ID = " + ID + ", School Name = " + SchoolName + ", & StudentID = " + StudentID + " isn't labeled as a student.");
				}
				UpdateInterface(controlInterface);
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		studentController.getDeleteStudent().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs DeleteStudentInputs = studentController.getDeleteStudentInputs();
				String ID = ((JTextField) DeleteStudentInputs.getComponent(0)).getText();
				String StudentID = ((JTextField) DeleteStudentInputs.getComponent(1)).getText();
				
				result = DeleteFrom.DeleteStudent(Integer.parseInt(ID), SchoolName, StudentID);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getUpdateStudent().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs UpdateStudentInputs = studentController.getUpdateStudentInputs();
				String ID = ((JTextField) UpdateStudentInputs.getComponent(0)).getText();
				String StudentID = ((JTextField) UpdateStudentInputs.getComponent(1)).getText();
				String Program = ((JTextField) UpdateStudentInputs.getComponent(2)).getText();
				String Progression = ((JTextField) UpdateStudentInputs.getComponent(3)).getText();
				String Tuition = ((JTextField) UpdateStudentInputs.getComponent(4)).getText();
				String AcademicYear = ((JTextField) UpdateStudentInputs.getComponent(5)).getText();
				String Semester = ((JTextField) UpdateStudentInputs.getComponent(6)).getText();
				
				result = UpdateFrom.UpdateStudent(Integer.parseInt(ID), SchoolName, StudentID, Program, Progression, Double.parseDouble(Tuition), Integer.parseInt(AcademicYear), Semester);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		studentController.getClearAllStudents().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				result = DeleteFrom.ClearTable("Student", SchoolName);
				UpdateInterface(controlInterface);
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getSelectStudent().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs SelectstudentInputs = studentController.getSelectStudentInputs();
				String ID = ((JTextField) SelectstudentInputs.getComponent(0)).getText();
				String StudentID = ((JTextField) SelectstudentInputs.getComponent(1)).getText();
				
				result = SelectFrom.SelectStudent(Integer.parseInt(ID), StudentID, SchoolName);
				
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getShowAllStudent().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				
				
				result = SelectFrom.SelectAll("Student", SchoolName);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getGoToPerson().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				student = false;
				faculty = false;
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getGoToContactInfo().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(contactInfoController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				student = false;
				faculty = false;
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getGoToSchoolRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(schoolRecordController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				student = false;
				faculty = false;
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getGoToInitial().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(initialController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				student = false;
				faculty = false;
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		studentController.getGoToFaculty().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(facultyController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				student = false;
				faculty = false;
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		/////////////////////////////////////////////////////// Faculty Portion
		facultyController.getAddFaculty().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs AddFacultyInputs = facultyController.getAddFacultyInputs();
				String ID = ((JTextField) AddFacultyInputs.getComponent(0)).getText();
				String JobID = ((JTextField) AddFacultyInputs.getComponent(1)).getText();
				String Salary = ((JTextField) AddFacultyInputs.getComponent(2)).getText();
				String HireDate = ((JTextField) AddFacultyInputs.getComponent(3)).getText();
				String JobTittle = ((JTextField) AddFacultyInputs.getComponent(4)).getText();
				String JobStatus = ((JTextField) AddFacultyInputs.getComponent(5)).getText();
				
				System.out.println(ID + " " + JobID + Salary + HireDate + JobTittle + JobStatus);
				
				String temp = SelectFrom.SelectSchoolRecord(Integer.parseInt(ID), SchoolName).get(0);
				
				student = false;
				
				if (temp.contains("isFaculty = 1")) {
					ArrayList<String> tempArray = InsertTo.InsertFaculty(Integer.parseInt(ID), SchoolName, Integer.parseInt(JobID), Double.parseDouble(Salary), HireDate, JobTittle, JobStatus);
					result  = tempArray;
					
					if (!tempArray.get(0).equals("One of the input values is wrong or this spefic instance already exists")) {
						if (temp.contains("isStudent = 1")) {
							screen.remove(controlInterface);
							controlInterface = new JScrollPane(studentController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
							screen.add(controlInterface, BorderLayout.CENTER);
						}
						else {
							screen.remove(controlInterface);
							controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
							screen.add(controlInterface, BorderLayout.CENTER);
						}
					}
				}
				else {
					result = new ArrayList<String>();
					result.add("The School Record of User with ID = " + ID + ", School Name = " + SchoolName + ", & JobID = " + JobID + " isn't labeled as a student.");
				}
				
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		facultyController.getDeleteFaculty().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs DeleteFacultyInputs = facultyController.getDeleteFacultyInputs();
				String ID = ((JTextField) DeleteFacultyInputs.getComponent(0)).getText();
				String JobID = ((JTextField) DeleteFacultyInputs.getComponent(1)).getText();
				
				result = DeleteFrom.DeleteFaculty(Integer.parseInt(ID), SchoolName, Integer.parseInt(JobID));
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getUpdateFaculty().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs UpdateFacultyInputs = facultyController.getUpdateFacultyInputs();
				String ID = ((JTextField) UpdateFacultyInputs.getComponent(0)).getText();
				String JobID = ((JTextField) UpdateFacultyInputs.getComponent(1)).getText();
				String Salary = ((JTextField) UpdateFacultyInputs.getComponent(2)).getText();
				String HireDate = ((JTextField) UpdateFacultyInputs.getComponent(3)).getText();
				String JobTittle = ((JTextField) UpdateFacultyInputs.getComponent(4)).getText();
				String JobStatus = ((JTextField) UpdateFacultyInputs.getComponent(5)).getText();
				
				result = UpdateFrom.UpdateFaculty(Integer.parseInt(ID), SchoolName, Integer.parseInt(JobID), Double.parseDouble(Salary), HireDate, JobTittle, JobStatus);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
		});
		
		facultyController.getClearAllFacultys().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				result = DeleteFrom.ClearTable("Faculty", SchoolName);
				UpdateInterface(controlInterface);
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getSelectFaculty().addMouseListener(new MouseAdapter () {
			
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				Inputs SelectfacultyInputs = facultyController.getSelectFacultyInputs();
				String ID = ((JTextField) SelectfacultyInputs.getComponent(0)).getText();
				String JobID = ((JTextField) SelectfacultyInputs.getComponent(1)).getText();
				
				result = SelectFrom.SelectFaculty(Integer.parseInt(ID), SchoolName, Integer.parseInt(JobID));
				
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getShowAllFaculty().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Clicked!");
				
				
				result = SelectFrom.SelectAll("Faculty", SchoolName);
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getGoToPerson().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(personController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getGoToContactInfo().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(contactInfoController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getGoToSchoolRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(schoolRecordController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getGoToInitial().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(initialController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
		
		facultyController.getGoToStudentRecord().addMouseListener(new MouseAdapter () {
			/**
			 * This method gives the "Add Person" button the ability to make a new note for the "To Do List"
			 * @throws IOException
			 */
			@Override
			public void mousePressed(MouseEvent e)  {
				System.out.println("Press1");
				screen.remove(controlInterface);
				controlInterface = new JScrollPane(studentController, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				screen.add(controlInterface, BorderLayout.CENTER);
				result = new ArrayList<String>();
				UpdateInterface(controlInterface);
				
				revalidate();          // Recalculate layout
		        repaint();
			}
			
		});
	}
	
	public void UpdateInterface(JPanel Interface) {
		for (Component c: Interface.getComponents()) {
			if (c instanceof JLabel) {
				Interface.remove(c);
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			Interface.add(new JLabel(result.get(i)), BorderLayout.SOUTH);
		}
	}
	
	public void UpdateInterface(JScrollPane Interface) {
		for (Component c: ((JPanel) Interface.getViewport().getView()).getComponents()) {
			if (c instanceof JLabel) {
				((JPanel) Interface.getViewport().getView()).remove(c);
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			((JPanel) Interface.getViewport().getView()).add(new JLabel(result.get(i)));
		}
		
		((JPanel) Interface.getViewport().getView()).revalidate();
		((JPanel) Interface.getViewport().getView()).repaint();
		Interface.revalidate();
		Interface.repaint();
	}

}
