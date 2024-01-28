import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoginAndRegistration {
    static Scanner sc = new Scanner(System.in);
    static Connection con;
    static String RED = "\u001B[31;1;3m";
    static String RESET = "\u001B[0m";
    static String GREEN = "\u001B[32;1;3m";
    static ArrayList<String> rto = new ArrayList<>(Arrays.asList("Ahmedabad", "Mehsana", "Rajkot", "Bhavnagar", "Surat",
            "Vadodara", "Nadiad", "Palanpur", "Himmatnagar", "Jamnagar", "Junagadh", "Kutch-Bhuj", "Surendranagar",
            "Amreli", "Valsad", "Bharuch", "Godhra", "Gandhinagar", "Bardoli", "Dahod", "Navsari", "Rajpipla", "Anand",
            "Patan", "Porbandar", "Vyara", "Ahmedabad East", "Surat West", "Vadodara Other", "Dang-Aahwa", "Arvalli",
            "Gir Somnath", "Botad", "Chhotaudaipur", "Mahisagar", "Morbi", "Devbhumi Dwarka", "Bavla"));

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RTO", "root", "");
        while (true) {
            System.out.println("                            +-----------------------------------------+");
            System.out.println("                            |  0 -> Exit.                             |");
            System.out.println("                            |  1 -> New here? Register.               |");
            System.out.println("                            |  2 -> Already have an account, Login.   |");
            System.out.println("                            +-----------------------------------------+");
            int choice = -1;
            System.out.println();
            System.out.print("                  Your Choice: ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                choice = -1;
                sc.nextLine();
            }
            switch (choice) {
                case 0:
                    System.out.println("");
                    System.exit(0);
                    break;
                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;
                default:
                    System.out.println(
                            "\n                  " + RED + "Enter number corresponding to below option." + RESET
                                    + "\n");
                    break;
            }
        }
    }

    public static void register() throws SQLException, InterruptedException {
        sc.nextLine();
        String mob = "";
        int flag = 3;
        while (true) {
            System.out.print("                  Enter mobile number: ");
            mob = sc.nextLine();
            if (isValidNumber(mob)) {
                PreparedStatement ps1 = con.prepareStatement("select * from user_data where Mobile_no = ?");
                ps1.setString(1, mob);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    System.out.println("                  The number " + mob+ " is already registered please login using password.");
                    return;
                }
                break;
            } else {
                System.out.println("\n                  " + RED + "Enter valid 10 digit mobile number." + RESET + "\n");
            }
            flag--;
            if (flag == 0) {
                System.out.println("                  " + RED + "Registration Failed.");
                System.out.println("                  Please Try Again." + RESET + "");
                return;
            }
        }
        String f_name = "", l_name = "", m_name = "";

        while (true) {
            System.out.print("                  Enter First name: ");
            f_name = sc.nextLine();
            if (areAllAlphabets(f_name) && !f_name.isEmpty())
                break;

        }
        while (true) {
            System.out.print("                  Enter Middle name: ");
            m_name = sc.nextLine();
            if (areAllAlphabets(m_name) && !m_name.isEmpty())
                break;
        }
        while (true) {
            System.out.print("                  Enter Last name: ");
            l_name = sc.nextLine();
            if (areAllAlphabets(l_name) && !l_name.isEmpty())
                break;
        }
        String DOB = "";
        while (true) {
            System.out.print("                  Enter DOB: ");
            DOB = sc.nextLine();
            if (isValidDate(DOB)) {
                break;
            } else {
                System.out.println("\n                  " + RED + "Enter valid DOB and age > 16." + RESET + "\n");
            }
        }
        int RTO;
        displayRTO();
        while (true) {
            System.out.print("                  Enter RTO code.");
            RTO = sc.nextInt();
            sc.nextLine();
            if (RTO > 0 && RTO <= 38) {
                break;
            } else {
                System.out.println("\n                  " + RED + "Enter valid RTO code." + RESET + "\n");
            }
        }
        String pswd = "";
        flag = 3;
        while (true) {
            System.out.print("                  Set 4 digit password : ");
            pswd = sc.nextLine();
            if (pswd.length() == 4) {
                System.out.println("\n                  " + GREEN + "Registered Successfully" + RESET + "\n");
                break;
            } else {
                System.out.println("                  " + RED + "Enter valid 4 digit password." + RESET + "\n");
            }
            flag--;
            if (flag == 0) {
                System.out.println("                  " + RED + "Registration Failed.");
                System.out.println("                  Please Try Again." + RESET + "");
                return;
            }
        }
        String query = "insert into user_data(First_name,Middle_name,Last_name,Mobile_no,DOB,RTO_code,Pswd) values (?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, f_name);
        pst.setString(2, m_name);
        pst.setString(3, l_name);
        pst.setString(4, mob);
        pst.setString(5, DOB);
        pst.setInt(6, RTO);
        pst.setString(7, pswd);
        pst.executeUpdate();
    }

    public static void login() throws Exception {
        sc.nextLine();
        String phone = "";
        int flag = 3;
        while (true) {
            System.out.print("                  Enter Phone number: ");
            phone = sc.nextLine();
            if (isValidNumber(phone)) {
                PreparedStatement ps = con.prepareStatement("select * from user_data where Mobile_no = ?");
                ps.setString(1, phone);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String f_name = rs.getString(2);
                    String m_name = rs.getString(3);
                    String l_name = rs.getString(4);
                    String Mobile_no = rs.getString(5);
                    String DOB = rs.getString(6);
                    int rto = rs.getInt(7);
                    String pswd = rs.getString(8);
                    System.out.print("                  Enter password : ");
                    String pass = sc.nextLine();
                    if (pswd.equals(pass)) {
                        System.out.println("\n                  " + GREEN + "Logged in successfully." + RESET + "\n");
                        new Menu(f_name, l_name, m_name, Mobile_no, DOB, rto, pswd, con, sc);
                    } else {
                        System.out.println("\n                  " + RED + "Incorrect password." + RESET + "\n");
                    }
                } else {
                    System.out.println(
                            "\n                  " + RED + "The entered phone number has not been registered.");
                    System.out.println("                  Please Register First!" + RESET + "\n");
                    return;
                }
            } else {
                System.out.println("\n                  " + RED + "Enter valid 10 digit mobile number." + RESET + "\n");
            }
            flag--;
            if (flag == 0) {
                System.out.println("\n                  " + RED + "Login Failed.");
                System.out.println("                  Please Try Again." + RESET + "\n");
                return;
            }
        }
    }

    private static boolean isValidDate(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate birthDate = LocalDate.parse(dateStr, dateFormatter);
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthDate, currentDate);
            return age.getYears() > 16;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isValidNumber(String phoneNumber) {
        String regex = "^[6-9]\\d{9}$";

        return phoneNumber.matches(regex);
    }

    private static boolean areAllAlphabets(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("\n                  " + RED + "Name must only contain letters." + RESET + " \n");
                return false;
            }
        }
        return true;
    }

    private static void displayRTO() throws InterruptedException {
        System.out
                .println("            +-----------------------------------------------------------------------------+");
        System.out
                .println("            |                                                                             |");
        System.out.println(
                "            |                                 \u001B[1mSTOPS LIST" + RESET
                        + "                                  |");
        System.out
                .println("            |                                                                             |");
        System.out
                .println("            +-----------------------------------------------------------------------------+");
        for (int i = 0; i < rto.size(); i += 3) {
            Thread.sleep(100);
            String stop1 = String.format("%-30s", "\u001B[33m[" + (i + 1) + "] " + rto.get(i));
            String stop2 = String.format("%-30s", "\u001B[35m[" + (i + 2) + "] " + rto.get(i + 1));
            String stop3 = "                         ";
            if ((i + 3) < 38) {
                stop3 = String.format("%-30s", "\u001B[36m[" + (i + 3) + "] " + rto.get(i + 2));
            }
            System.out.println(
                    "            |                                                                             |");
            System.out.println("            | " + stop1 + stop2 + stop3 + "" + RESET + " |");
        }
        System.out
                .println("            |                                                                             |");
        System.out
                .println("            +-----------------------------------------------------------------------------+");
        System.out.println();
    }

}
