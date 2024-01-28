import java.io.File;
import java.io.FileReader;
import java.sql.*;
public class Set_stock {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Laptop_Inventory", "root", "");
        if (con != null) {
            System.out.println("Connection to database Succesfull");
        } else {
            System.out.println("Connection to database Failed");
        }
        for (int i = 1; i<=6; i++) {
            String query = "insert into MSI values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "MSI_"+i);
            pst.setString(2, "MSI_"+i+".txt");
            File f = new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\Laptop_files\\MSI_"+i+".txt");
            FileReader fr = new FileReader(f);
            pst.setCharacterStream(3, fr, f.length());
            pst.setInt(4, 5);
            pst.executeUpdate();
        }
    }   
}