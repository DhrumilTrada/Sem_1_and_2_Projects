package Projects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Welcome_log {
    Scanner s = new Scanner(System.in);
    String name;
    String mob;
    int age;
    int pin;
    String cyan = "\u001B[36m";
    String cyan_bold = "\u001B[36;1m";
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String red_bold = "\u001B[31;1m";
    String black = "\u001B[30;1m";
    String white_bg = "\u001B[47m";

    public void welcome() {
        System.out.println("                                           |------------|");
        System.out.println("                       --------------------" + white_bg + black
                + "|LAPTOP STORE|" + reset + "--------------------");
        System.out.println("                      |                    |------------|                    |");
        System.out.println("                      |                                                      |");
        System.out.println("                      |                                                      |");
        System.out.println();
    }

    public void welcome_login(Connection con) throws Exception {
        System.out.println("Welcome to the ONLINE portal of LAPTOP STORE!!!");
        System.out.println("Are you on this portal for the first time or have you visited this portal earlier???");
        System.out.println("Enter" + cyan_bold + " Y" + reset + " for Register/Sign Up" + red_bold + " N " + reset
                + "for Login!!!!!");
        String first_ornot = s.nextLine();
        if (first_ornot.equalsIgnoreCase("Y")) {
            register(con);
        } else {
            login(con); // throws
        }
    }

    public void register(Connection con) throws SQLException, ClassCastException, IOException, Exception {
        System.out.print("Enter your full name: ");
        String username = "";
        name = s.nextLine();
        int discount = 0;
        while (true) {
            System.out.print("Enter your mobile number: ");
            mob = s.nextLine();
            if (validate_mob(mob)) {
                System.out.println(cyan_bold + "Valid mobile number....." + reset);
                if (mob.charAt(0) == '6') {
                    System.out.println("As we can see your number starts with 6!!!!");
                    System.out.println(
                            "This site being sponsored by our Share Holders you can get a special discount on all products of OURS!!!!!!");
                    System.out.println(
                            "Congrats the minimum discount is of " + red_bold + "10%" + reset + " and maximum of "
                                    + red_bold + "35%" + reset + " in multiples of 5!!!!");
                    int arr[] = { 5, 10, 15, 20, 25, 30, 35 };
                    discount = arr[new Random().nextInt(arr.length)];
                    System.out.println(
                            "A discount of " + "\u001B[31m" + discount + "\u001B[0m" + "% is availed to you!!!!!!");
                }
                break;
            } else {
                System.out.println(red_bold + "Enter a valid mobile number!!!!" + reset);
            }
        }
        String mob_query = "select Mobile_no from Users_mob";
        PreparedStatement pst1 = con.prepareStatement(mob_query);
        ResultSet mob_rs = pst1.executeQuery();
        int mob_flag = 1;
        while (mob_rs.next()) {
            if (mob.equals(mob_rs.getString("Mobile_no"))) {
                System.out.println(red + "You're already registered!!" + reset);
                mob_flag = 0;
                break;
            }
        }
        if (mob_flag == 1) {
            System.out.println("A 6 digit OTP has been sent to the Number please enter below!!!");
            int flagg = 0;
            while (flagg == 0) {
                int i = new Random().nextInt(900000) + 100000;// otp for number greater than 100000 for 6 digit OTP
                System.out.println("OTP for registeration is: " + red_bold + i + reset);
                System.out.print("Please enter the OTP: ");
                String OTP1 = Integer.toString(i);
                String OTP = s.nextLine();
                if (OTP.equals(OTP1)) {
                    System.out.println(
                            cyan_bold + "Registeration Successful WELCOME to the family!!!!!!!" + reset);
                    flagg = 1;
                } else {
                    System.out.println(
                            red + "OOPS entered OTP does not match the OTP sent!!!!Try again!" + reset);
                    System.out.println(cyan + "Please Re-Enter the new OTP sent!!!!" + reset);
                }
            }

            System.out.print("Enter your age: ");
            age = s.nextInt();
            s.nextLine();
            if (age >= 18) {
            } else {
                System.out.println("\u001B[31m"
                        + "Please ensure to be with one of a person above 18 years for better guidance!!!!!"
                        + "\u001B[0m");
            }
            System.out.println("Welcome To OUR Online Store!!!!!!!!");
            pin = new Random().nextInt(9000) + 1000;
            System.out.println("Do remember this four Digit randomly generated PIN for future reference " + red_bold
                    + pin + reset);
            String name_arr[] = name.split(" ");
            username = name_arr[0].trim() + "_" + mob.substring(5, 7);
            System.out.println("Suggested username is: " + cyan_bold+username+reset);
            String choice;
            System.out.println("Do you want to choose your own username?");
            System.out.println(cyan_bold + "Y" + reset + " / " + red_bold + "N?" + reset);
            choice = s.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                while (true) {
                    System.out.println(cyan+"Enter Your Username:"+reset);
                    username = s.nextLine();
                    Statement st = con.createStatement();
                    String sql = "select username from users_mob where username='" + username + "'";
                    ResultSet rs = st.executeQuery(sql);
                    int fla = 1;
                    while (rs.next()) {
                        if (username.equals(rs.getString("Username"))) {
                            System.out
                                    .println("\u001B[31m" + "Username already exists! Try another one." + "\u001B[0m");
                            fla = 0;
                            break;
                        }
                        System.out.println(rs.toString());
                    }
                    if (fla == 1) {
                        break;
                    }
                }
                System.out.println("Your Username is : " + username);
            }else{
                username = name_arr[0].trim() + "_" + mob.substring(5, 7);
                System.out.println("Your Username is : " + red +username+reset);
            }
        System.out.println("Do you want to save login details?"+cyan_bold+" Y "+ reset+ "/" + red_bold +  " N"+reset);
        String save_pass = s.nextLine();
        boolean pass_save = true;
        if (save_pass.equalsIgnoreCase("Y")) {
            pass_save = true;
        } else {
            pass_save = false;
        }
        String query = "insert into Users_mob(Username,Mobile_no,Save_pass,Pin,Discount) values(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, mob);
        pst.setBoolean(3, pass_save);
        pst.setInt(4, pin);
        pst.setInt(5, discount);
        pst.executeUpdate();
        System.out.println("Do you want to login or exit?"+ cyan_bold+ " Y "+ reset + "/ "+ red_bold + "N"+ reset);
        String choo = s.nextLine();
        if (choo.equalsIgnoreCase("Y")) {
            login(con);
        } else {
            System.exit(0);
        }
    }else{
        login(con, mob);
    }
    File f = new File("Register_Log.txt");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    BufferedWriter bw = new BufferedWriter(new FileWriter(f,
            true));bw.write("User "+username+" Registered Succesfully using mobile number "+mob+"!!!\n");bw.write(dtf.format(now));bw.newLine();bw.close();
}

    public void login(Connection con) throws SQLException, ClassCastException, IOException, Exception {
        String fetch_username = "select username from Users_mob";
        PreparedStatement pst = con.prepareStatement(fetch_username);
        ResultSet rs = pst.executeQuery();
        HashSet<String> hs = new HashSet<>();
        while (rs.next()) {
            hs.add(rs.getString("Username"));
        }
        int flag = 0;
        String username = "";
        while (true) {
            System.out.print(cyan + "Please enter your Username: "+reset);
            username = s.nextLine();
            if (hs.contains(username)) {
                flag = 1;
                break;
            } else {
                System.out.println(red + "The username " + username
                        + " is not Registered with us!! Please try with a correct username....." + reset);
                System.out.println("Do you want to register?"+ cyan_bold+ " Y "+ reset + "/ "+ red_bold + "N"+ reset);
                String cho = s.nextLine();
                if (cho.equalsIgnoreCase("Y")) {
                    register(con);
                    break;
                }
            }
        }
        if (flag == 1) {
            int pinn;
            String callable = "{call get_saved_pin(?,?,?,?)}";
            String mob = "";
            CallableStatement cst = con.prepareCall(callable);
            cst.setString(1, username);
            cst.execute();
            if (cst.getInt(3) == 1) {
                System.out.println(cyan_bold+"Saved Pin Found!!!!"+reset);
                pinn = cst.getInt(4);
                System.out.println("Pin is:" + red_bold + pinn + reset);
                System.out.println(red_bold + "Login Succesfull" + reset);
                mob = cst.getString(4);
            } else {
                String callable1 = "{call fetch_details(?,?,?,?)}";
                CallableStatement cst1 = con.prepareCall(callable1);
                cst1.setString(1, username);
                cst1.execute();
                System.out.println(cyan+"Enter pin provided while registering:"+reset);
                int trial = 0;
                while (trial <= 3) {
                    pinn = s.nextInt();
                    if (pinn == cst1.getInt(4)) {
                        System.out.println(red_bold + "Login Succesfull" + reset);
                        break;
                    } else {
                        System.out.println(red + "Incorrect Pin..Re-Enter Again!!!!" + reset);
                        System.out.println(red + "Tries left = " + (3 - trial - 1) + reset);
                        trial++;
                    }
                    if (trial == 3) {
                        throw new Exception(red_bold+"Too many attempts!!!"+reset);
                    }
                }
                mob = cst1.getString(3);
            }
            File f = new File("Login_Log.txt");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.write("User " + username + " Logged in using mobile number " + mob + "!!!\n");
            bw.write(dtf.format(now));
            bw.newLine();
            bw.close();
            s.nextLine();
            String choice1 = "";
            while(true){
                System.out.println("                         "+white_bg+black+"-----------------------------------------------------------------"+reset);
                System.out.println("                         "+white_bg+black+"|   1.Search By Brand  |   2.Search By Budget   |    3. Exit    |"+reset);
                System.out.println("                         "+white_bg+black+"-----------------------------------------------------------------"+reset);
                choice1 = s.nextLine();
                switch(choice1){
                    case "1":
                        new Laptop_selection().search_brand(username, con);
                        break;
                    case "2":
                        new Laptop_selection().search_budget(username, con);
                        break;
                    case "3":
                        System.exit(0); 
                    default:
                        System.out.println(red+"Enter valid Input..."+reset);
                }
            }
        }
    }

    public boolean validate_mob(String mob) {
        int flag = 1;
        if (mob.length() == 10) {
            if (mob.charAt(0) == '6' || mob.charAt(0) == '7' || mob.charAt(0) == '8' || mob.charAt(0) == '9') {
                for (int i = 1; i < mob.length(); i++) {
                    if (Character.isDigit(mob.charAt(i))) {
                        flag++;
                    }
                }
            } else {
                System.out.println("\u001B[31m" + "Enter number starting from 6, 7, 8, 9 only" + "\u001B[0m");
                return false;
            }
            if (flag == 10) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println(red_bold + "Enter valid number of 10 digits only" + "\u001B[0m");
            return false;
        }
    }

    public void login(Connection con, String mob) throws SQLException, ClassCastException, IOException {
        String user = "";
        int pass;
        int check = 0;
        int chance = 0;
        String query = "select * from users_mob where Mobile_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, mob);
        ResultSet rs = pst.executeQuery();
        String us = "";
        int pinn = 0;
        while (rs.next()) {
            us = rs.getString("Username");
            pinn = rs.getInt("Pin");
        }
        while (chance != 3) {
            System.out.println(cyan+"Enter your Username: "+reset);
            user = s.nextLine();
            if (user.equals(us)) {
                System.out.println("\u001B[31m" + "Correct Username..." + "\u001B[0m");
                while (check != 3) {
                    System.out.println("Enter you password: ");
                    pass = s.nextInt();
                    if (pass == pinn) {
                        System.out.println("\u001B[31m" + "Correct Password Login Successfull...." + "\u001B[0m");
                        break;
                    } else {
                        System.out.println(red + "Incorrect password...." + reset);
                        System.out.println(red + "Tries left = " + (3 - check - 1) + reset);
                    }
                }
                break;
            } else {
                System.out.println("Tries left = " + (3 - chance - 1));
                chance++;
            }
        }
        String choice1 = "";
        while (true) {
            System.out.println("                         " + white_bg + black
                    + "-----------------------------------------------------------------" + reset);
            System.out.println("                         " + white_bg + black
                    + "|   1.Search By Brand  |   2.Search By Budget   |    3. Exit    |" + reset);
            System.out.println("                         " + white_bg + black
                    + "-----------------------------------------------------------------" + reset);
            s.nextLine();
            choice1 = s.nextLine();
            switch (choice1) {
                case "1":
                    new Laptop_selection().search_brand(us, con);
                    break;
                case "2":
                    new Laptop_selection().search_budget(us, con);
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println(red + "Enter valid Input..." + reset);
            }
        }
    }
}