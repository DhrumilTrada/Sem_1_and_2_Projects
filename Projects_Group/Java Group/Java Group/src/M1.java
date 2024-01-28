// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.text.DateFormat;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.Random;
// import java.util.Scanner;

// public class M1 {
//     static Scanner sc = new Scanner(System.in);
//     static Connection con;
//     static String RED = "\u001B[31;1;3m";
//     static String RESET = "\u001B[0m";
//     static String GREEN = "\u001B[32;1;3m";

//     public static void main(String[] args) throws SQLException, ClassNotFoundException {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RTO", "root", "");
//         drivingLicense();
//     }

//     private static void drivingLicense() throws SQLException {
//         sc.nextLine();
//         String cov = "";
//         System.out.println("\n                  Enter your LL NUmber : ");
//         String ll_no = sc.nextLine();
//         PreparedStatement pst = con.prepareStatement("select * from user_data where LL_number =?;");
//         pst.setString(1, ll_no);
//         ResultSet rst = pst.executeQuery();
//         ArrayList<Date> dates = new ArrayList<>();
//         if (rst.next()) {
//             System.out.println("                  Valid LL Number");
//             Statement st = con.createStatement();
//             ResultSet rs = st.executeQuery("select * from dl_slots;");
//             System.out.print("      ");
//             System.out.printf("%-20s %-20s %-20s\n", "   DATE", "DAY OF WEEK", "SLOTS");
//             System.out.println("  ---------------------------------------------------------");
//             while (rs.next()) {
//                 Date date = rs.getDate(1);
//                 String day = rs.getString(2);
//                 int slots = rs.getInt(3);
//                 if (slots > 0)
//                     dates.add(date);
//                 System.out.print("      ");
//                 System.out.printf("%-20s %-20s %-20s\n", date, " " + day, " " + slots);
//             }
//             System.out.println();
//             System.out.println();

//             Date test_date = null;
//             while (test_date == null) {
//                 System.out.print("                  Select Date For Driving Test : ");
//                 String choice = sc.nextLine();
//                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                 try {
//                     test_date = dateFormat.parse(choice);
//                 } catch (ParseException e) {
//                     System.out.println("                  Incorrect Date format use (yyyy-mm-dd).");
//                 }
//             }
//             if (dates.contains(test_date)) {
//                 String ch="";
//                 while (!(ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("no"))) {
//                     System.out.println();
//                     System.out.print("                  Confirm Slot Booking? (" + GREEN + "Yes" + RESET + "/" + RED + "No"
//                             + RESET + ") : ");
//                     ch = sc.nextLine();
//                     if (ch.equalsIgnoreCase("yes")) {
//                         PreparedStatement statement = con.prepareStatement("update set Slots_available=Slots_available -1 where Test_Date = ?");
//                         statement.setDate(1, new java.sql.Date(test_date.getTime()));
//                         int r = statement.executeUpdate();
//                         if(r>0){
//                             System.out.println("                  Slot Booked successfully for date:"+test_date);
//                             String dl_no = generateRandomDL();
//                             PreparedStatement statement2 = con.prepareStatement("Update user_data set DL_number = ? where phone = ?");
//                             statement2.setString(1, dl_no);
//                             statement2.setString(2, mob);
//                         }else{
//                             System.out.println("                  Slot Booking Failed");
//                         }
//                     } else {
//                         System.out.println("\n                  " + RED + "Booking Cancelled!" + RESET + "\n");
//                     }
//                 }
//             } else {
//                 System.out.println("                  No slots available for the given date.");
//             }

//         } else {
//             System.out.println("                  No data found for the given LL number.");
//         }

//     }

//     private static String generateRandomDL() {
//         // Define DL number format (for example purposes)
//         String format = "DL-%04d/%02d";

//         // Generate random numbers
//         Random random = new Random();
//         int serialNumber = random.nextInt(10000); // 4-digit serial number
//         int regionCode = random.nextInt(100); // 2-digit region code

//         // Format and return the DL number
//         return String.format(format, serialNumber, regionCode);
//     }
// }
