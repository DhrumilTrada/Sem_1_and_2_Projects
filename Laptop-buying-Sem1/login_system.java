import java.util.Scanner;
import java.sql.*;
class login_system{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        register();
    }
    public static void register() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:\\localhost:3306/Users", "root", "");
        if(con != null){
            System.out.println("Connection to server is successfull!!!!");
        }else{
            System.out.println("Server connection failed!!!!");
        }
        System.out.println("Enter First Name: ");
        String fname = s.nextLine();
        System.out.println("Enter Last Name: ");
        String lname = s.nextLine();
        System.out.println("Enter Phone Number: " );
        String mno = s.nextLine();
    }
    public void login(){

    }
}