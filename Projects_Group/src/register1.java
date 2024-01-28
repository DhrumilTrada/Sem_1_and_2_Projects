import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class register1 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
              
    }

    public static boolean date_validation(String dob) {
        String dat[];
        dat = dob.split("-");
        int year = Integer.parseInt(dat[0]);
        int month = Integer.parseInt(dat[1]);
        int day = Integer.parseInt(dat[2]);
        // January, March, May, July, August, October, and December. having 31 days
        if (dat[0].length() == 4 && (dat[1].length() == 2 || dat[1].length() == 1) && (dat[2].length() == 2 || dat[2].length() == 1)) {
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
        }else{
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
                System.out.println("Enter valid character only (digits)");
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Enter valid number of 10 digits only");
            return false;
        }
    }

    public static void register(Connection con) throws Exception {
        System.out.println("Enter first name:");
        String fname = s.nextLine();
        System.out.println("Enter last name:");
        String lname = s.nextLine();
        String mob_no;
        int flag;
        while (true) {
            flag = 0;
            System.out.print("Enter a valid mobile number: ");
            mob_no = s.nextLine();
            if (mob_no.length() == 10) {
                for (int i = 0; i < 10; i++) {
                    if (mob_no.charAt(0) >= '6') {
                        if (Character.isDigit(mob_no.charAt(i))) {
                            flag++;
                        }
                    }
                }
            } else {
                System.out.println("Enter a mobile number of 10 digits");
            }
            if (flag == 10) {
                System.out.println("Valid mobile number....");
                break;
            }
        }
        String mob = "select Mobile_no from Users";
        PreparedStatement pst1 = con.prepareStatement(mob);
        ResultSet rs = pst1.executeQuery();
        int flag1 = 0;
        while (rs.next()) {
            if (mob_no.equals(rs.getString("Mobile_no"))) {
                System.out.println("This mobile number is already registered with us......");
                flag1 = 1;
            }
        }
        if (flag1 == 0) {
            System.out.println("Enter State:");
            String state = s.nextLine();
            System.out.println("Enter city of RTO:");
            String city = s.nextLine();
            System.out.println("Enter district of RTO:");
            String district = s.nextLine();
            String query = "insert into Users(First_Name, Last_Name, Mobile_no, State_RTO, City_RTO, District_RTO) value(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, mob_no);
            pst.setString(4, state);
            pst.setString(5, city);
            pst.setString(6, district);
            pst.executeUpdate();
            pst.close();
        }
    }
}
