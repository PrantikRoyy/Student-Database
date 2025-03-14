import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UpdateFrom {
	public static ArrayList<String> UpatePerson(int ID, String FullName, String DOB, String SIN, String gender) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "Update Person set FullName = ?, DOB = ?, SIN = ?, gender = ? where id = ?;";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, FullName);
            statement.setString(2, DOB);
            statement.setString(3, SIN);
            statement.setString(4, gender);
            statement.setInt(5, ID);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("The user was updated successfully!");
                output.add("The user was updated successfully!");
            }
            else {
            	System.out.println("User with id = " + ID + " dosen't exist!");
            	output.add("User with id = " + ID + " dosen't exist!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Other values inputted aren't appropriate");
        	output.add("Other values inputted aren't appropriate");
        }
        
        return output;
    }
	
	public static ArrayList<String> UpdateContactInfo(int ID, String HomeAddress, String EmailAddress, String PhoneNumber) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "update ContactInfo set HomeAddress = ?, EmailAddress = ?, PhoneNumbers = ? where ID = ?;";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, HomeAddress);
            statement.setString(2, EmailAddress);
            statement.setString(3, PhoneNumber);
            statement.setInt(4, ID);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("Contact information was updated successfully!");
                output.add("Contact information was updated successfully!");
            }
            else {
            	System.out.println("User with id = " + ID + " dosen't exist!");
            	output.add("User with id = " + ID + " dosen't exist!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Other values inputted aren't appropriate");
        	output.add("Other values inputted aren't appropriate");
        }
        
        return output;
    }
	
	public static ArrayList<String> UpdateSchoolRecord(int ID, String SchoolName, boolean isStudent, boolean isFaculty, String location, String dateOfEntry, String lastUpdated) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "update SchoolRecord set isStudent = ?, isFaculty = ?, location = ?, dateOfEntry = ?, lastUpdated = ? where ID = ? and SchoolName = ?;";
        ArrayList<String> output = new ArrayList<>();
        
        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1, isStudent);
            statement.setBoolean(2, isFaculty);
            statement.setString(3, location);
            statement.setString(4, dateOfEntry);
            statement.setString(5, lastUpdated);
            statement.setInt(6, ID);
            statement.setString(7, SchoolName);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
            	System.out.println("School Record was updated successfully!");
            	output.add("School Record was updated successfully!");
            }
            else {
            	System.out.println("User with id = " + ID + " dosen't exist!");
            	output.add("User with id = " + ID + " and SchoolName = " + SchoolName + "dosen't exist!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Other values inputted aren't appropriate");
        	output.add("Other values inputted aren't appropriate");
        }
        
        return output;
    }
	
	public static ArrayList<String> UpdateFaculty(int ID, String SchoolName, int JobID, double Salary, String HireDate, String JobTittle, String JobStatus) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "update Faculty set Salary = ?, HireDate = ?, JobTittle = ?, JobStatus = ? where id = ? and SchoolName = ? and JobID = ?;";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, Salary);
            statement.setString(2, HireDate);
            statement.setString(3, JobTittle);
            statement.setString(4, JobStatus);
            statement.setInt(5, ID);
            statement.setString(6, SchoolName);
            statement.setInt(7, JobID);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
            	System.out.println("Faculty Record was updated successfully!");
            	output.add("Faculty Record was updated successfully!");
            }
            else {
            	System.out.println("User with id = " + ID + " dosen't exist!");
            	output.add("User with id = " + ID + ", SchoolName = " + SchoolName + ", and JobID " + JobID + "dosen't exist!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Other values inputted aren't appropriate");
        	output.add("Other values inputted aren't appropriate");
        }
        
        return output;
    }
	
	public static ArrayList<String> UpdateStudent(int ID, String SchoolName, String StudentID, String Program, String Progression, double Tuition, int AcademicYear, String Semester) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "update Student set Program = ?, Progression = ?, Tuition = ?, AcademicYear = ?, Semester = ? where id = ? and SchoolName = ? and StudentID = ?;";
        ArrayList<String> output = new ArrayList<>();
        
        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Program);
            statement.setString(2, Progression);
            statement.setDouble(3, Tuition);
            statement.setInt(4, AcademicYear);
            statement.setString(5, Semester);
            statement.setInt(6, ID);
            statement.setString(7, SchoolName);
            statement.setString(8, StudentID);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("Student record was updated successfully!");
                output.add("Student record was updated successfully!");
            }
            else {
            	System.out.println("User with id = " + ID + " dosen't exist!");
            	output.add("User with id = " + ID + ", SchoolName = " + SchoolName + ", and StudentID " + StudentID + "dosen't exist!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Other values inputted aren't appropriate");
        	output.add("Other values inputted aren't appropriate");
        }
        
        return output;
    }
}
