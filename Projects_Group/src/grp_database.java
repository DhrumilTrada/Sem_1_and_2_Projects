// Firstname 
// Last name 
// Middle name
// Phone
// Date of birth
//  And rto code
//  Khali gujarat maate karvanu che
//  Toh 1 to 38 maathi koi
//  Badhu validate karine database ma enter thaay avu karine mokal aaj raat sudhi
//  And database ma ek column driving licence print karine text file maate
//  And ek learning ni file maate colum

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class grp_database {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Licence_creation", "root", "");
        if (con != null) {
            System.out.println("Connection to database Succesfull");
        } else {
            System.out.println("Connection to database Failed");
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Enter First name: ");
        String fname = s.nextLine();
        System.out.println("Enter Middle name: ");
        String mname = s.nextLine();
        System.out.println("Enter Last name: ");
        String lname = s.nextLine();
        String mob = "";
        while(true){
            System.out.println("Enter mobile number: ");
            mob = s.nextLine();
            if(validate_mob(mob)){
                break;
            }else{
                System.out.println("Enter valid mobile number....");
            }
        }
        String DOB = "";
        while(true){
            System.out.println("Enter DOB: ");
            DOB = s.nextLine();
            if(date_validation(DOB)){
                break;
            }else{
                System.out.println("Enter valid DOB....");
            }
        }
        int RTO;
        while(true){
            System.out.println("1.Ahmedabad 2.Mehsana 3.Rajkot 4.Bhavnagar 5.Surat 6.Vadodara 7.Nadiad 8.Palanpur 9.Himmatnagar 10.Jamnagar");
            System.out.println("11.Junagadh 12.Kuchh-Bhuj 13.Surendranagar 14.Amreli 15.Valsad 16.Bharuch 17.Godhra 18.Gandhinagar 19.Bardoli 20.Dahod");
            System.out.println("21.Navsari 22.Rajpipla 23.Anand 24.Patan 25.Porbandar 26.Vyara 27.Ahmedabad East 28.Surat West 29.Vadodara Other 30.Dang-Aahwa");
            System.out.println("31.Arvalli 32.Gir Somnath 33.Botad 34.Chhotaudepur 35.Mahisagar 36.Morbi 37.Devbhumi Dwarka 38.Bavla");
            System.out.println("Enter RTO code: ");
            RTO = s.nextInt();
            s.nextLine();
            if(RTO>0 && RTO<=38){
                break;
            }else{
                System.out.println("Enter valid RTO code....");
            }
        }
        System.out.println("Enter LL details: ");
        String ll = s.nextLine();
        System.out.println("Enter DL details: ");
        String dl = s.nextLine();
        String query = "insert into user_licence(First_name,Middle_name,Last_name,Mobile_no,DOB,RTO_code,LL_number,DL_number) values (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, fname);
        pst.setString(2, mname);
        pst.setString(3, lname);
        pst.setString(4, mob);
        pst.setString(5,DOB);
        pst.setInt(6, RTO);
        pst.setString(7, ll);
        pst.setString(8, dl);
        pst.executeUpdate();
    }
    
    public static boolean date_validation(String dob) {
        String dat[];
        dat = dob.split("-");
        int year = Integer.parseInt(dat[0]);
        int month = Integer.parseInt(dat[1]);
        int day = Integer.parseInt(dat[2]);
        // January, March, May, July, August, October, and December. having 31 days
        if (dat[0].length() == 4 && (dat[1].length() == 2 || dat[1].length() == 1)
                && (dat[2].length() == 2 || dat[2].length() == 1)) {
            if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day <= 31 && day > 0) {
                        return true;
                    } else if (day > 31 && day <= 0) {
                        return false;
                    }
                } else if (month == 2) {
                    boolean leap = true;
                    if (year % 400 == 0) {
                        leap = true;
                    } else if (year % 4 == 0 && year % 100 != 0) {
                        leap = true;
                    } else {
                        leap = false;
                    }
                    if (leap) {
                        if (day <= 29 && day > 0) {
                            return true;
                        }
                    } else {
                        if (day > 28 && day <= 0) {
                            return false;
                        }
                    }
                } else {
                    if (day <= 30 && day > 0) {
                        return true;
                    } else if (day > 30 && day <= 0) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public static boolean validate_mob(String mob) {
        int flag = 1;
        if (mob.length() == 10) {
            if (mob.charAt(0) == '6' || mob.charAt(0) == '7' || mob.charAt(0) == '8' || mob.charAt(0) == '9') {
                for (int i = 1; i < mob.length(); i++) {
                    if (Character.isDigit(mob.charAt(i))) {
                        flag++;
                    }
                }
            } else {
                System.out.println("Enter number starting from 6, 7, 8, 9 only");
                return false;
            }
            if (flag == 10) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Enter valid number of 10 digits only");
            return false;
        }
    }
    public static void login(Connection con, Scanner s) throws SQLException{
        System.out.println("Enter uername: ");
        String usname = s.nextLine();
        String query = "select * from User_login where username=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, usname);
        ResultSet rs = pst.executeQuery();
        String pass = "";
        while(rs.next()){
            pass = rs.getString("Password");
        }
        System.out.println(pass);
        String password = "";
        int check = 0;
        while(check != 3){
            System.out.println("Enter password: ");
            password = s.nextLine();
            if(pass.equals(password)){
                System.out.println("Correct password....");
                break;
            }else{
                System.out.println("Incorrect Password...");
                System.out.println("Tries left = "+(3-check-1));
                check++;
            }
        }
    }
}
