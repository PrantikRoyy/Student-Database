import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InsertTo {
	public static ArrayList<String> InsertPerson(int ID, String FullName, String DOB, String SIN, String gender) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "insert into Person values (?, ?, ?, ?, ?);";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, FullName);
            statement.setString(3, DOB);
            statement.setString(4, SIN);
            statement.setString(5, gender);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                output.add("A new user was inserted successfully!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("One of the input values is wrong or this spefic instance already exists");  
        	output.add("One of the input values is wrong or this spefic instance already exists");
        }
        
        return output;
    }
	
	public static ArrayList<String> InsertPerson(String FullName, String DOB, String SIN, String gender) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "insert into Person (FullName, DOB, SIN, gender) values (?, ?, ?, ?);";
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
            
            // Step 4: Execute the statement            
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                output.add("A new user was inserted successfully!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("One of the input values is wrong or this spefic instance already exists");  
        	output.add("One of the input values is wrong or this spefic instance already exists");
        }
        
        return output;
    }
	
	public static ArrayList<String> InsertContactInfo(int ID, String HomeAddress, String EmailAddress, String PhoneNumber) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "insert into ContactInfo values (?, ?, ?, ?);";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, HomeAddress);
            statement.setString(3, EmailAddress);
            statement.setString(4, PhoneNumber);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("Contact information was inserted successfully!");
                output.add("Contact information was inserted successfully!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("One of the input values is wrong or this spefic instance already exists");  
        	output.add("One of the input values is wrong or this spefic instance already exists");
        }
        
        return output;
    }
	
	public static ArrayList<String> InsertSchoolRecord(int ID, String SchoolName, boolean isStudent, boolean isFaculty, String location, String dateOfEntry, String lastUpdated) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "insert into SchoolRecord values (?, ?, ?, ?, ?, ?, ?);";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
            
            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, SchoolName);
            statement.setBoolean(3, isStudent);
            statement.setBoolean(4, isFaculty);
            statement.setString(5, location);
            statement.setString(6, dateOfEntry);
            statement.setString(7, lastUpdated);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("School Record was inserted successfully!");
                output.add("School Record was inserted successfully!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("One of the input values is wrong or this spefic instance already exists");  
        	output.add("One of the input values is wrong or this spefic instance already exists");
        }
        
        return output;
    }
	
	public static ArrayList<String> InsertFaculty(int ID, String SchoolName, int JobID, double Salary, String HireDate, String JobTittle, String JobStatus) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "insert into Faculty values (?, ?, ?, ?, ?, ?, ?);";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, SchoolName);
            statement.setInt(3, JobID);
            statement.setDouble(4, Salary);
            statement.setString(5, HireDate);
            statement.setString(6, JobTittle);
            statement.setString(7, JobStatus);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("Faculty record was inserted successfully!");
                output.add("Faculty record was inserted successfully!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("One of the input values is wrong or this spefic instance already exists");  
        	output.add("One of the input values is wrong or this spefic instance already exists");
        }
        
        return output;
    }
	
	public static ArrayList<String> InsertStudent(int ID, String SchoolName, String StudentID, String Program, String Progression, double Tuition, int AcademicYear, String Semester) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "insert into Student values (?, ?, ?, ?, ?, ?, ?, ?);";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, SchoolName);
            statement.setString(3, StudentID);
            statement.setString(4, Program);
            statement.setString(5, Progression);
            statement.setDouble(6, Tuition);
            statement.setInt(7, AcademicYear);
            statement.setString(8, Semester);
            
            // Step 4: Execute the statement
            int rowsInserted = statement.executeUpdate();
            
            // Step 5: Confirm the insertion
            if (rowsInserted > 0) {
                System.out.println("Student record was inserted successfully!");
                output.add("Student record was inserted successfully!");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("One of the input values is wrong or this spefic instance already exists");  
        	output.add("One of the input values is wrong or this spefic instance already exists");
        }
        
        return output;
    }
}
