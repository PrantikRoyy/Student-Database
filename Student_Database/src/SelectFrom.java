
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SelectFrom {
	public static ArrayList<String> SelectAll(String table) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "select * from " + table;
        ArrayList<String> output = new ArrayList<>();
        output.add("Input is wrong");

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println(table);
            ResultSet resultSet = statement.executeQuery();
            output.remove(0);
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No Users have been found!");
            	output.add("No Users have been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	switch(table) {
            		case "Person":
            			output.add("ID = " + resultSet.getInt("ID") + ", FullName = " + resultSet.getString("FullName") + ", DOB = " + 
            					resultSet.getString("DOB") + ", SIN = " + resultSet.getString("SIN") + ", gender = " + resultSet.getString("gender"));
            			break;
            		case "ContactInfo":
            			output.add("ID = " + resultSet.getInt("ID") + ", HomeAddress = " + resultSet.getString("HomeAddress") + ", EmailAddress = " + 
            					resultSet.getString("EmailAddress") + ", PhoneNumbers = " + resultSet.getString("PhoneNumbers"));
            			break;
            		case "SchoolRecord":
            			output.add("ID = " + resultSet.getInt("ID") + ", SchoolName = " + resultSet.getString("SchoolName") + ", isStudent = " + 
            					resultSet.getString("isStudent") + ", isFaculty = " + resultSet.getString("isFaculty") +  ", location = " + 
            					resultSet.getString("location") +  ", dateOfEntry = " + resultSet.getString("dateOfEntry") + ", lastUpdated = " + 
            					resultSet.getString("lastUpdated"));
            			break;
            		case "Faculty":
            			output.add("ID = " + resultSet.getInt("ID") + ", SchoolName = " + resultSet.getString("SchoolName") + ", JobID = " + 
            					resultSet.getString("JobID") + ", Salary = " + resultSet.getString("Salary") +  ", HireDate = " + 
            					resultSet.getString("HireDate") +  ", JobTittle = " + resultSet.getString("JobTittle") + ", JobStatus = " + 
            					resultSet.getString("JobStatus"));
            			break;
            		case "Student":
            			output.add("ID = " + resultSet.getInt("ID") + ", SchoolName = " + resultSet.getString("SchoolName") + ", JobID = " + 
            					resultSet.getString("JobID") + ", Salary = " + resultSet.getString("Salary") +  ", HireDate = " + 
            					resultSet.getString("HireDate") +  ", JobTittle = " + resultSet.getString("JobTittle") + ", JobStatus = " + 
            					resultSet.getString("JobStatus"));
            			break;
            	}
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectAll(String table, String SchoolName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "select * from " + table + " where SchoolName = ?";
        ArrayList<String> output = new ArrayList<>();
        output.add("Input is wrong");

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, SchoolName);
            System.out.println(table);
            ResultSet resultSet = statement.executeQuery();
            output.remove(0);
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No Users have been found!");
            	output.add("No Users have been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	switch(table) {
            		case "SchoolRecord":
            			output.add("ID = " + resultSet.getInt("ID") + ", SchoolName = " + resultSet.getString("SchoolName") + ", isStudent = " + 
            					resultSet.getString("isStudent") + ", isFaculty = " + resultSet.getString("isFaculty") +  ", location = " + 
            					resultSet.getString("location") +  ", dateOfEntry = " + resultSet.getString("dateOfEntry") + ", lastUpdated = " + 
            					resultSet.getString("lastUpdated"));
            			break;
            		case "Faculty":
            			output.add("ID = " + resultSet.getInt("ID") + ", SchoolName = " + resultSet.getString("SchoolName") + ", JobID = " + 
            					resultSet.getString("JobID") + ", Salary = " + resultSet.getString("Salary") +  ", HireDate = " + 
            					resultSet.getString("HireDate") +  ", JobTittle = " + resultSet.getString("JobTittle") + ", JobStatus = " + 
            					resultSet.getString("JobStatus"));
            			break;
            		case "Student":
            			output.add("ID = " + resultSet.getInt("ID") + ", SchoolName = " + resultSet.getString("SchoolName") + ", StudentID = " + 
            					resultSet.getString("StudentID") + ", Program = " + resultSet.getString("Program") +  ", Progression = " + 
            					resultSet.getString("Progression") +  ", Tuition = " + resultSet.getString("Tuition") + ", AcademicYear = " + 
            					resultSet.getString("AcademicYear")  + ", Semester = " + resultSet.getString("Semester"));
            			break;
            	}
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectPerson(int ID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM Person where id = ?";
        ArrayList<String> output = new ArrayList<>();
        output.add("Input is wrong");

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();
            output.remove(0);
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No User with id = " + ID + " has been found!");
            	output.add("No User with id = " + ID + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID = " + resultSet.getInt("ID") + ", FullName = " + resultSet.getString("FullName") + ", DOB = " + 
            					resultSet.getString("DOB") + ", SIN = " + resultSet.getString("SIN") + ", gender = " + resultSet.getString("gender"));
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectPerson(String FullName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM Person where FullName = ?";
        ArrayList<String> output = new ArrayList<>();
        output.add("Input is wrong");

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, FullName);
            ResultSet resultSet = statement.executeQuery();
            output.remove(0);
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No User with FullName = " + FullName + " has been found!");
            	output.add("No User with FullName = " + FullName + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID = " + resultSet.getInt("ID") + ", FullName = " + resultSet.getString("FullName") + ", DOB = " + 
            					resultSet.getString("DOB") + ", SIN = " + resultSet.getString("SIN") + ", gender = " + resultSet.getString("gender"));
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        }
        
        return output;
	}
	
	public static ArrayList<String> SelectContactInfo(int ID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM ContactInfo where id = ?";
        ArrayList<String> output = new ArrayList<>();
        output.add("Input is wrong");

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();
            output.remove(0);
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No ContactInfo of user with id = " + ID + " has been found!");
            	output.add("No ContactInfo of user with id = " + ID + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID: " + resultSet.getInt("ID") + ", HomeAddress: " + resultSet.getString("HomeAddress") + ", EmailAddress: " + 
            			resultSet.getString("EmailAddress") + ", PhoneNumbers: " + resultSet.getString("PhoneNumbers"));
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectContactInfo(String FullName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM ContactInfo where id in (SELECT id from Person where FullName = ?);";
        ArrayList<String> output = new ArrayList<>();
        output.add("Input is wrong");

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, FullName);
            ResultSet resultSet = statement.executeQuery();
            output.remove(0);
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No ContactInfo of user with FullName = " + FullName + " has been found!");
            	output.add("No ContactInfo of user with FullName = " + FullName + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID: " + resultSet.getInt("ID") + ", HomeAddress: " + resultSet.getString("HomeAddress") + ", EmailAddress: " + 
            			resultSet.getString("EmailAddress") + ", PhoneNumbers: " + resultSet.getString("PhoneNumbers"));
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectSchoolRecord(int ID, String SchoolName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM SchoolRecord where id = ? and SchoolName = ?";
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
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No SchoolRecord of user with id = " + ID + " & School Name = " + SchoolName + " has been found!");
            	output.add("No SchoolRecord of user with id = " + ID + " & School Name = " + SchoolName + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID: " + resultSet.getInt("ID") + ", SchoolName: " + resultSet.getString("SchoolName") + ", isStudent: " + 
            	resultSet.getBoolean("isStudent") + ", isFaculty: " + resultSet.getBoolean("isFaculty") + ", location: " + resultSet.getString("location") + 
            	", dateOfEntry: " + resultSet.getDate("dateOfEntry") + ", lastUpdated: " + resultSet.getDate("lastUpdated"));
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Input is wrong");
        	output.add("Input is wrong");
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectFaculty(int ID, String SchoolName, int JobID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM Faculty where id = ? and SchoolName = ? and JobID = ?";
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
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No Faculty Records of user with id = " + ID + " & SchoolName = " + SchoolName + " & JobID = " + JobID + " has been found!");
            	output.add("No Faculty Records of user with id = " + ID + " & SchoolName = " + SchoolName + " & JobID = " + JobID + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID: " + resultSet.getInt("ID") + ", SchoolName: " + resultSet.getString("SchoolName") + ", JobID: " + resultSet.getInt("JobID") + 
            			", Salary: " + resultSet.getFloat("Salary") + ", HireDate: " + resultSet.getDate("HireDate") + ", JobTittle: " + resultSet.getString("JobTittle")
            			+ ", JobStatus: " + resultSet.getString("JobStatus"));
            	System.out.println(output);
                System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        	output.add("Input is wrong");
        }
        
        return output;
    }
	
	public static ArrayList<String> SelectStudent(int ID, String StudentID, String SchoolName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM Student where id = ? and StudentID = ? and SchoolName = ?";
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
            statement.setString(2, StudentID);
            statement.setString(3, SchoolName);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.isBeforeFirst() == false) {
            	System.out.println("No Student Record of user with id = " + ID + ", StudentID = " + StudentID + ", and SchoolName = " + SchoolName + " has been found!");
            	output.add("No Student Record of user with id = " + ID + ", StudentID = " + StudentID + ", and SchoolName = " + SchoolName + " has been found!");
            }
            
            // Process the results
            while (resultSet.next()) {
            	output.add("ID: " + resultSet.getInt("ID") + ", SchoolName: " + resultSet.getString("SchoolName") + ", StudentID: " + resultSet.getString("StudentID") + 
            			", Program: " + resultSet.getString("Program") + ", Progression: " + resultSet.getString("Progression") + 
            			", Tuition: " + resultSet.getFloat("Tuition") + ", AcademicYear: " + resultSet.getInt("AcademicYear") + ", Semester: " + resultSet.getString("Semester"));
                System.out.println(output);
            	System.out.println("----");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
        	output.add("Input is wrong");
        }
        
        return output;
    }
}

