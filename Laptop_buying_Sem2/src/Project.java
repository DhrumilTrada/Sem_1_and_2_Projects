import Projects.Welcome_log;
import java.sql.*;
import java.util.*;

public class Project {
    public static void main(String[] var0) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection var1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Laptop_Inventory", "root", "");
        if (var1 != null) {
            System.out.println("Connection to database Succesfull");
        } else {
            System.out.println("Connection to database Failed");
        }
        Scanner s = new Scanner(System.in);
        new Welcome_log().welcome();
        new Welcome_log().welcome_login(var1);
        s.close();
    }
}
