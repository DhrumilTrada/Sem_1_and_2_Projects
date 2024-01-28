import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private static final String REDBOLD = "\u001B[31;1m";
    private static final String CYANBOLD = "\u001B[36;1m";

    static String RED = "\u001B[31;1;3m";
    static String RESET = "\u001B[0m";
    static String CYAN = "\u001B[36m";
    static String GREEN = "\u001B[32;1;3m";
    String ll_no;
    String f_name;
    String l_name;
    String m_name;
    String mob_no;
    String date_of_birth;
    int rto;
    String pswd;
    Connection con;
    Scanner sc;

    public Menu(String f_name, String l_name, String m_name, String mob_no, String date_of_birth, int rto, String pswd,
            Connection con, Scanner sc) throws Exception {
        this.f_name = f_name;
        this.l_name = l_name;
        this.m_name = m_name;
        this.mob_no = mob_no;
        this.date_of_birth = date_of_birth;
        this.rto = rto;
        this.pswd = pswd;
        this.con = con;
        this.sc = sc;
        optionMenu();
    }

    private void optionMenu() throws Exception {
        boolean flag = true;
        while (flag) {
            System.out.println("                            +-----------------------------------------+");
            System.out.println("                            |  0 -> Exit.                             |");
            System.out.println("                            |  1 -> Learner's Licennse.               |");
            System.out.println("                            |  2 -> Driving License.                  |");
            System.out.println("                            |  3 -> Vehicle Registration.             |");
            System.out.println("                            |  4 -> Check E-Challan                   |");
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
                    flag = false;
                    break;
                case 1:
                    learningLicense();
                    break;

                case 2:
                    drivingLicense();
                    break;
                case 3:
                    registerVehicle();
                    break;
                case 4:
                    Echallan();
                    break;
                default:
                    System.out.println(
                            "\n                  " + RED + "Enter number corresponding to below option." + RESET
                                    + "\n");
                    break;
            }
        }
    }

    // To print Driving License in the file.
    void printDrivingLicense(String rtocode, String dl_number, String issuedate, String validty, String cov,
            String name, String date_of_birth, String m_name) throws Exception {
                new File(dl_number + ".txt").createNewFile();
        FileWriter fw = new FileWriter(new File(dl_number + ".txt"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(" _________________________________________________ ");
        bw.newLine();
        bw.write("|                                                 |");
        bw.newLine();
        bw.write("| Indian Union Driving Licence");
        String s = String.format("%21s", "|");
        bw.write(s);
        bw.newLine();
        bw.write("| Issued by Government of Gujarat");
        String s2 = String.format("%18s", "|");
        bw.write(s2);
        bw.newLine();
        bw.write("|");
        String s3 = String.format("%50s", "|");
        bw.write(s3);
        bw.newLine();
        bw.write("| GJ" + rtocode + " 2023" + dl_number);
        String s4 = String.format("%33s", "|");
        bw.write(s4);
        bw.newLine();
        bw.write("| Issue Date           Validity");
        String s5 = String.format("%20s", "|");
        bw.write(s5);
        bw.newLine();
        bw.write("| " + issuedate + "          " + validty);
        String s6 = String.format("%19s", "|");
        bw.write(s6);
        bw.newLine();
        bw.write("|");
        String s7 = String.format("%50s", "|");
        bw.write(s7);
        bw.newLine();
        bw.write("| Class Of Vehicle : " + cov);
        int space = 50 - (cov.length() + 20);
        String s8 = String.format("%" + space + "s", "|");
        bw.write(s8);
        bw.newLine();
        bw.write("|");
        String s9 = String.format("%50s", "|");
        bw.write(s9);
        bw.newLine();
        bw.write("|");
        String s10 = String.format("%50s", "|");
        bw.write(s10);
        bw.newLine();
        bw.write("|");
        String s11 = String.format("%50s", "|");
        bw.write(s11);
        bw.newLine();
        bw.write("|");
        String s12 = String.format("%50s", "|");
        bw.write(s12);
        bw.newLine();
        bw.write("| Name : " + name);
        int space2 = 50 - (name.length() + 8);
        String s13 = String.format("%" + space2 + "s", "|");
        bw.write(s13);
        bw.newLine();
        bw.write("| Date of Birth : " + date_of_birth);
        String s14 = String.format("%23s", "|");
        bw.write(s14);
        bw.newLine();
        bw.write("| Son/Daughter/Wife of : " + m_name);
        int space3 = 50 - (name.length() + 24);
        String s15 = String.format("%" + space3 + "s", "|");
        bw.write(s15);
        bw.newLine();
        bw.write("|_________________________________________________|");
        bw.flush();
        bw.close();
    }

    // To print Learning License in the file.
    void printLearningLicense(String rtocode, String ll_number, String cov, String issuedate, String validty,String name, String m_name, String date_of_birth) throws IOException {
        FileWriter fw = new FileWriter("D:\\Projects Sem-2\\Projects_Group\\Java Group\\Java Group\\Java Group (3)\\" +ll_number+ ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(" _________________________________________________ ");
        bw.newLine();
        bw.write("|                                                 |");
        bw.newLine();
        bw.write("|                LEARNER'S LICENCE                |");
        bw.newLine();
        bw.write("|                  GUJARAT STATE                  |");
        bw.newLine();
        bw.write("|");
        String s1 = String.format("%50s", "|");
        bw.write(s1);
        bw.newLine();
        bw.write("| LL No. : GJ" + rtocode + "/" + ll_number + "/2023");
        String s2 = String.format("%23s", "|");
        bw.write(s2);
        bw.newLine();
        bw.write("| COV : " + cov);
        int space = 50 - (cov.length() + 7);
        String s3 = String.format("%" + space + "s", "|");
        bw.write(s3);
        bw.newLine();
        bw.write("| Valid From : " + issuedate + "   Valid To : " + validty + " |");
        bw.newLine();
        bw.write("| Name : " + name);
        int space2 = 50 - (name.length() + 8);
        String s4 = String.format("%" + space2 + "s", "|");
        bw.write(s4);
        bw.newLine();
        bw.write("| S/D/W of : " + m_name);
        int space3 = 50 - (m_name.length() + 12);
        String s5 = String.format("%" + space3 + "s", "|");
        bw.write(s5);
        bw.newLine();
        bw.write("| D.O.B. : " + date_of_birth);
        String s6 = String.format("%30s", "|");
        bw.write(s6);
        bw.newLine();
        bw.write("|_________________________________________________|");
        bw.flush();
        bw.close();
    }

    private void drivingLicense() throws Exception {
        sc.nextLine();
        String cov = "";
        System.out.print(CYANBOLD + "\n                  Enter your LL Number : " + RESET);
        String ll_no = sc.nextLine();
        PreparedStatement pst = con.prepareStatement("select * from user_data where LL_number =?;");
        pst.setString(1, ll_no);
        ResultSet rst = pst.executeQuery();
        ArrayList<Date> dates = new ArrayList<>();
        if (rst.next()) {
            System.out.println(REDBOLD + "                  Valid LL Number" + RESET);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from dl_slots;");
            System.out.print("      ");
            System.out.printf("%-20s %-20s %-20s\n", REDBOLD + "   DATE", "DAY OF WEEK", "SLOTS" + RESET);
            System.out.println("  ---------------------------------------------------------");
            while (rs.next()) {
                Date date = rs.getDate(1);
                String day = rs.getString(2);
                int slots = rs.getInt(3);
                if (slots > 0)
                    dates.add(date);
                System.out.print("      ");
                System.out.printf("%-20s %-20s %-20s\n", REDBOLD + date, " " + day, " " + slots + RESET);
            }
            System.out.println();
            System.out.println();

            Date test_date = null;
            while (test_date == null) {
                System.out.print(CYANBOLD + "                  Select Date For Driving Test : " + RESET);
                String choice = sc.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    test_date = dateFormat.parse(choice);
                } catch (ParseException e) {
                    System.out.println(REDBOLD + "                  Incorrect Date format use (yyyy-mm-dd)." + RESET);
                }
            }
            if (dates.contains(test_date)) {
                String ch = "";
                while (!(ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("no"))) {
                    System.out.println();
                    System.out.print(
                            "                  Confirm Slot Booking? (" + GREEN + "Yes" + RESET + "/" + RED + "No"
                                    + RESET + ") : ");
                    ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("yes")) {
                        PreparedStatement statement = con
                                .prepareStatement("update set Slots_available=Slots_available -1 where Test_Date = ?");
                        statement.setDate(1, new java.sql.Date(test_date.getTime()));
                        int r = statement.executeUpdate();
                        if (r > 0) {
                            System.out.println(CYANBOLD + "                  Slot Booked successfully for date:"
                                    + test_date + RESET);
                            String dl_no = generateRandomDL();
                            PreparedStatement statement2 = con
                                    .prepareStatement("Update user_data set DL_number = ? where phone = ?");
                            statement2.setString(1, dl_no);
                            statement2.setString(2, mob_no);
                            int r1 = statement2.executeUpdate();
                            if (r1 > 0) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                Date currentDate = new Date();
                                String formattedDate = dateFormat.format(currentDate);
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(currentDate);
                                calendar.add(Calendar.YEAR, 15);
                                Date newdate = calendar.getTime();
                                String formattednewdate = dateFormat.format(newdate);
                                printDrivingLicense(Integer.toString(rto), dl_no, formattedDate, formattednewdate, cov,
                                        f_name + " " + l_name, date_of_birth, m_name);
                            }
                        } else {
                            System.out.println(REDBOLD + "                  Slot Booking Failed" + RESET);
                        }
                    } else {
                        System.out.println("\n                  " + RED + "Booking Cancelled!" + RESET + "\n");
                    }
                }
            } else {
                System.out.println(RED + "                  No slots available for the given date." + RESET);
            }

        } else {
            System.out.println(RED + "                  No data found for the given LL number." + RESET);
        }

    }

    // generates randon DL number
    private static String generateRandomDL() {
        // Define DL number format (for example purposes)
        String format = "DL-%04d/%02d";

        // Generate random numbers
        Random random = new Random();
        int serialNumber = random.nextInt(10000); // 4-digit serial number
        int regionCode = random.nextInt(100); // 2-digit region code

        // Format and return the DL number
        return String.format(format, serialNumber, regionCode);
    }

    public void learningLicense() throws IOException, SQLException {
        sc.nextLine();
        String LL = "";
        String class_sel = "";
        System.out.println(CYAN + "                  Enter classes of Vehicle sepreated by spaces: " + RESET);
        System.out.println(RED + "                  1.MCWOG 2.MCWG 3.LMV 4.HMV 5.HGMV" + RESET);
        System.out.print(CYANBOLD + "                  User Input: " + RESET);
        class_sel = sc.nextLine();
        String cl[] = class_sel.split(" ");
        for (String check : cl) {
            if (check.equalsIgnoreCase("MCWOG") || check.equalsIgnoreCase("MCWG") || check.equalsIgnoreCase("LMV")
                    || check.equalsIgnoreCase("HMV") || check.equalsIgnoreCase("HGMV")) {

            } else {
                System.out.println("                  Enter valid Input");
                learningLicense();
                break;
            }
        }
        class_sel = "";
        HashSet<String> classs = new HashSet<>();
        for (int i = 0; i < cl.length; i++) {
            if (classs.add(cl[i]))
                class_sel = class_sel + ", " + cl[i];
        }
        class_sel = class_sel + "\b\b";
        String choice;
        while (true) {
            System.out.println("                  Do you want to give Learning License's test?" + CYANBOLD + " Y"
                    + RESET + " /" + REDBOLD + " N" + RESET);
            System.out.print("                  Your choice: ");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println(CYANBOLD + "                  Valid Output....." + RESET);
                if (Learner_Exam.learnerExam()) {
                    System.out
                            .println(CYANBOLD + "                  You have cleared the learning license exam" + RESET);
                    int number = (int) ((Math.random() * 1000000) + 1);
                    ll_no = "GJ" + rto + "/" + number + "/2023";
                    int amount = (classs.size() * 450) + 50;
                    if (Payment.payment(amount, pswd)) {
                    } else {
                        System.out.println("                  Payment Error!!");
                        return;
                    }
                } else {
                    System.out.println(REDBOLD + "                  Sorry you have failed the Exam!!!" + RESET);
                }
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                System.exit(0);
            } else {
                System.out.println("                  Enter valid Input...");
            }
        }
        String query = "update user_data set ll_number = ? where mobile_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, ll_no);
        pst.setString(2, mob_no);
        pst.executeUpdate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 6);
        Date newdate = calendar.getTime();
        String formattednewdate = dateFormat.format(newdate);
        printLearningLicense(Integer.toString(rto), ll_no, class_sel, formattedDate, formattednewdate,
                f_name + " " + l_name, m_name, date_of_birth);
    }

    public void Echallan() throws SQLException, ClassCastException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rto", "root", "");
        System.out.print(
                CYAN + "                  Enter your number plate to check for challan : (GJ 00 XX 0000)" + RESET);
        String numberplatecheck = sc.nextLine();
        String sql = "select * from echallan where numberPlate = '" + numberplatecheck + "'";
        PreparedStatement pst = con.prepareStatement(sql);
        // pst.setString(1, numberplatecheck);
        ResultSet rs = pst.executeQuery();
        int totalch = 0;
        int i = 1;
        while (rs.next()) {
            System.out.println("Challan " + i);
            i = i + 1;
            System.out.println(REDBOLD + "Reason : " + rs.getString("Reason") + RESET);
            System.out.println(CYANBOLD + "Amount Of Challan : " + RESET + REDBOLD + rs.getInt("Price") + RESET);
            totalch += rs.getInt("Price");
        }
        if (totalch > 0) {
            System.out.println("Total Amount To Be Paid : " + REDBOLD + totalch + RESET);
            if (Payment.payment(totalch, pswd)) {
                PreparedStatement statement = con.prepareStatement("delete from echallan where numberPlate = ?;");
                statement.setString(1, numberplatecheck);
                statement.executeUpdate();
            } else {
                System.out.println(REDBOLD + "                  Payment Error!!" + RESET);
                return;
            }
        }
    }

    public void registerVehicle() throws SQLException, ClassCastException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rto", "root", "");
        String classOfVehicle = "";
        // String vehicleModel;
        // int yearOfManufacturing;
        String dateOfRegistration;
        String NumberPlate;
        NumberPlate = "GJ ";

        System.out.print(CYAN + "                  Register Vehicle!" + RESET);
        System.out.print(CYAN + "                  Enter details below!" + RESET);
        System.out.print(CYAN + "                  Enter Details For Numberplate:" + RESET);
        while (true) {
            System.out.print(CYAN + "                  Choose RTO code your respective District:" + RESET);
            int RTOcode = sc.nextInt();
            if (RTOcode > 0 && RTOcode < 39) {
                System.out.println(CYANBOLD + "                  Valid Code!" + RESET);
                if (RTOcode > 0 && RTOcode < 10) {
                    NumberPlate += "0" + RTOcode + " ";
                } else {
                    NumberPlate += RTOcode + " ";
                }
                break;
            } else {
                System.out.println(
                        REDBOLD + "                  Invalid Rto  code. (Please enter rto code within 1-38)" + RESET);
            }
        }
        int min = 65;
        int max = 90;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        char c1 = (char) random_int;
        char c2 = (char) random_int2;
        NumberPlate += "" + c1 + c2 + " ";
        int use = (int) (Math.random() * 10000);
        NumberPlate += use;
        System.out.println(NumberPlate);
        System.out.println(CYANBOLD + "                  Number plate for your vehicle is : " + NumberPlate + RESET);
        while (true) {
            System.out.println(REDBOLD + "                  Below are the Classes of Vehicle: " + RESET);
            System.out.println(CYAN + "                  1. MCWOG - Vehicle without Gears " + RESET);
            System.out.println(CYAN + "                  2. MCWG - Vehicle with Gears " + RESET);
            System.out.println(CYAN + "                  3. LMV - Light Motor Vehicle" + RESET);
            System.out.println(CYAN + "                  4. HMV - Heavy Motor Vehicle" + RESET);
            System.out.println(CYAN + "                  5. HGMV - Heavy Goods Motor Vehicle" + RESET);
            System.out.println(CYAN + "                  Enter your class of vehicle : " + RESET);
            System.out.println(CYAN + "                  -->" + RESET);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    classOfVehicle = "MCWOG";
                    break;
                case 2:
                    classOfVehicle = "MCWG";
                    break;
                case 3:
                    classOfVehicle = "LMV";
                    break;
                case 4:
                    classOfVehicle = "HMV";
                    break;
                case 5:
                    classOfVehicle = "HGMV";
                    break;

                default:
                    System.out.println(RED + "                  Enter valid choice!" + RESET);
                    break;
            }
            if (choice >= 1 && choice <= 5) {
                break;
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        dateOfRegistration = dtf.format(now);
        System.out.println(NumberPlate);
        System.out.println(classOfVehicle);
        System.out.println(dateOfRegistration);
        String sql = "insert into vehicles values(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, mob_no);
        pst.setString(2, classOfVehicle);
        pst.setString(3, NumberPlate);
        pst.setString(4, dateOfRegistration);
        pst.executeUpdate();
    }
}