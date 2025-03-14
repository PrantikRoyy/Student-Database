import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    public static void main(String[] args) {
//    	System.out.println("Inserting Infromation");
//    	System.out.println("-------------------------");
//    	InsertTo.InsertPerson(1, "Prantik Roy", "2024-12-27", "12345678", "Male");
//        InsertTo.InsertContactInfo(1, "1264 Warden Avenue", "prantik@my.yorku.ca", "647-803-6754");
//        InsertTo.InsertSchoolRecord(1, "York University", true, true, "Toronto", "2024-12-27", "2024-12-27");
//        InsertTo.InsertFaculty(1, "York University", 1, 1000.00, "2024-11-03", "assistant", "part time");
//        InsertTo.InsertStudent(1, "York University", "219647353", "Computer Science", "Bachelor", 50000.00, 3, "Winter");
//        
//        System.out.println("Selecting Infromation");
//    	System.out.println("-------------------------");
//        SelectFrom.SelectPerson(1);
//        SelectFrom.SelectContactInfo(1);
//        SelectFrom.SelectSchoolRecord(1, "York University");
//        SelectFrom.SelectFaculty(1, "York University", 1);
//        SelectFrom.SelectStudent(1, "York University", "219647353");
//        
//        System.out.println("Deleting Infromation");
//    	System.out.println("-------------------------");
//        DeleteFrom.DeleteStudent(1, "York University", "219647353");
//        DeleteFrom.DeleteFaculty(1, "York University", 1);
//        DeleteFrom.DeleteSchoolRecord(1, "York University");
//        DeleteFrom.DeleteContactInfo(1);
//        DeleteFrom.DeletePerson(1);
//        
//        System.out.println("Selecting Infromation");
//    	System.out.println("-------------------------");
//        SelectFrom.SelectPerson(1);
//        SelectFrom.SelectContactInfo(1);
//        SelectFrom.SelectSchoolRecord(1, "York University");
//        SelectFrom.SelectFaculty(1, "York University", 1);
//        SelectFrom.SelectStudent(1, "York University", "219647353");
    	
    	//DeleteFrom.DeletePerson(4);
    	//UpdateFrom.UpatePerson(4, "Jacob Jessie", "2024-13-28", "87654321", "Male");
    	
    	InsertTo.InsertPerson("Prantik Roy", "2024-12-27", "12345678", "Male");
    }
}