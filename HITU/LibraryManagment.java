import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibraryManagment {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "");
        if (con != null) {
            System.out.println("Connection Succesfull!!!");
        } else {
            System.out.println("Connection Failed!!!");
        }
        Scanner sc = new Scanner(System.in);
        int ch;
        int choice;
        String name;
        int valid = 0;
        PreparedStatement pst;
        int r;
        String sql;
        String admin_password = "admin@21";
        String admin_name = "admin";
        do {
            System.out.println("Enter 1 for admin Login to add,view,delete librarian");
            System.out.println("Enter 2 for Librarian Login if you want to issue or return a book");
            System.out.println("Enter 3 to exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    do {
                        System.out.println("Enter admin name");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Enter admin password");
                        String pass = sc.nextLine();
                        if (admin_name.equals(name) && admin_password.equals(pass)) {
                            System.out.println("SuccessFully Login");
                            valid = 1;
                            do {
                                System.out.println("Enter 1 to add Librarian");
                                System.out.println("Enter 2 to view Lbirarian");
                                System.out.println("Enter 3 to delete Librarian");
                                System.out.println("Enter 4 to exit");
                                choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        sc.nextLine();
                                        System.out.println(
                                                "----------------------Enter NAME of LIBRARIAN-------------------------------");
                                        System.out.print("Enter Your Name: ");
                                        name = sc.nextLine();
                                        System.out.println(
                                                "----------------------Enter PASSWORD of LIBRARIAN-------------------------------");
                                        String password = "";

                                        while (true) {
                                            System.out.println("rules for writing password");
                                            System.out.println("1.password must contain atleast 1 small alphabet");
                                            System.out.println("2.password must contain atleast 1 capital alphabet");
                                            System.out.println("3.password must contain atleast 1 digit");
                                            System.out.println("4.password must contain atleast 1 special symbol");
                                            System.out.println("Enter passsword: ");
                                            password = sc.nextLine();
                                            int small = 0, cap = 0, digit = 0, special = 0, spc = 0;
                                            if (password.length() >= 8 && password.length() <= 16) {
                                                for (int i = 0; i < password.length(); i++) {
                                                    if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                                                        cap++;
                                                    } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                                                        small++;
                                                    } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                                                        digit++;
                                                    } else if (password.charAt(i) == ' ') {
                                                        spc++;
                                                    } else
                                                        special++;
                                                }
                                                if (spc == 0 && cap != 0 && small != 0 && special != 0 && digit != 0) {
                                                    System.out.println("Valid Password");
                                                    break;
                                                } else {
                                                    System.out.println("Above requirements of password not fulfilled");
                                                    System.out.println();
                                                }
                                            } else {
                                                System.out.println("Enter password of length 8 to 16 only");
                                            }
                                        }
                                        String email;
                                        while (true) {
                                            System.out.println(
                                                    "----------------------Enter EMAIL of LIBRARIAN-------------------------------");
                                            email = sc.nextLine();
                                            if (isEmailValid(email)) {
                                                System.out.println("Valid email!!!!");
                                                break;
                                            } else {
                                                System.out.println("Enter a valid email!!!!");
                                            }
                                        }
                                        String mob;
                                        int flag;
                                        while (true) {
                                            flag = 0;
                                            System.out.println(
                                                    "---------------------Enter MOBILE of LIBRARIAN-------------------------------");
                                            mob = sc.nextLine();
                                            int flag1 = 1;
                                            if (mob.length() == 10) {
                                                if (mob.charAt(0) == '6' || mob.charAt(0) == '7' || mob.charAt(0) == '8'
                                                        || mob.charAt(0) == '9') {
                                                    for (int i = 1; i < mob.length(); i++) {
                                                        if (Character.isDigit(mob.charAt(i))) {
                                                            flag1++;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Enter number starting from 6, 7, 8, 9 only");

                                                }
                                                if (flag == 10) {
                                                    System.out.println("Enter valid character only (digits)");

                                                } else {

                                                }
                                            } else {
                                                System.out.println("Enter valid number of 10 digits only");

                                            }
                                            if (flag1 == 10) {
                                                System.out.println("Valid mobile number....");
                                                break;
                                            } else {
                                                System.out.println("Enter a valid mobile phone number!!!!!");
                                            }
                                        }
                                        System.out.print("Enter Your City Here: ");
                                        String city = sc.nextLine();
                                        sql = "insert into Librarian_information(Name,password,Email,contact_no,City) values(?,?,?,?,?)";
                                        pst = con.prepareStatement(sql);
                                        pst.setString(1, name);
                                        pst.setString(2, password);
                                        pst.setString(3, email);
                                        pst.setString(4, mob);
                                        pst.setString(5, city);
                                        r = pst.executeUpdate();
                                        if (r > 0) {
                                            System.out.println("Added Successfully ");
                                        } else {
                                            System.out.print("Failed ");
                                        }
                                        break;
                                    case 2:
                                        sql = "select * from Librarian_information";
                                        pst = con.prepareStatement(sql);
                                        ResultSet rs = pst.executeQuery();
                                        while (rs.next()) {
                                            System.out.println("ID: " + rs.getInt(1));
                                            System.out.println("Name: " + rs.getString(2));
                                            System.out.println("Password: " + rs.getString(3));
                                            System.out.println("Email: " + rs.getString(4));
                                            System.out.println("Contact: " + rs.getLong(5));
                                            System.out.println("City: " + rs.getString(6));
                                            System.out.println();
                                        }
                                        break;
                                    case 3:
                                        sql = "delete from Librarian_information where id=?";
                                        pst = con.prepareStatement(sql);
                                        System.out.print("Enter id of Librarian you want to delete: ");
                                        int ID = sc.nextInt();
                                        pst.setInt(1, ID);
                                        r = pst.executeUpdate();
                                        if (r > 0) {
                                            System.out.print("Your Data Deleted Successfully ");
                                        } else {
                                            System.out.print("Failed ");
                                        }
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        System.out.print("Enter valid choice ");
                                        break;
                                }
                            } while (choice != 4);
                        } else {
                            System.out.println("Password and name is wrong.Try again!!");
                        }
                    } while (valid != 1);
                    break;
                case 2:
                    sql = "select * from Librarian_information";
                    pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    int check = 0;
                    System.out.println("Enter name of librarian");
                    sc.nextLine();
                    String lname = sc.nextLine();
                    while (true) {
                        System.out.println("Enter password of librarian");
                        String lpass = sc.nextLine();
                        String pass = "";
                        while (rs.next()) {
                            if (rs.getString("name").equals(lname)) {
                                pass = rs.getString("Password");
                                break;
                            }
                        }
                        if (pass.equals(lpass)) {
                            System.out.println("Login successfull");
                            check = 3;
                            System.out.println("Enter 1 to add book");
                            System.out.println("Enter 2 to view book Information");
                            System.out.println("Enter 3 to view Issue book Information");
                            System.out.println("Enter 4 to return book");
                            System.out.println("Enter 5 to issue book");
                            System.out.println("Enter 6 to retrieve photo");
                            System.out.println("Enter 7 to exit");
                            int cho = sc.nextInt();
                            sc.nextLine();
                            switch (cho) {
                                case 1:
                                    System.out.println("Enter number of books you want to enter");
                                    int n = sc.nextInt();
                                    add_book(con, n);
                                    break;
                                case 2:
                                    view_book(con);
                                    break;
                                case 3:
                                    view_issue_book(con);
                                    break;
                                case 4:
                                    return_book(con);
                                    break;
                                case 5:
                                    issue_book(con);
                                    break;
                                case 6:
                                    System.out.println("Enter id of the book whose image you want");
                                    int bookid = sc.nextInt();
                                    retrieveImage(con, bookid);
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println("Enter valid choice");
                            }
                            break;
                        } else {
                            System.out.println("Wrong password");
                            System.out.println("Tries left = " + (3 - check - 1));
                            check++;
                        }
                        if (check == 3) {
                            System.out.println("You have exhausted all your tries");
                            break;
                        }
                    }
                    break;
            }
        } while (ch != 3);
    }

    public static boolean isEmailValid(String email) {
        // Check if the email contain an "@" symbol
        if (email.contains("@") && email.contains(".com")) {
            return true;
        } else {
            return false;
        }

    }

    public static void add_book(Connection con, int num) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= num; i++) {
            System.out.println("Enter book no");
            String bno = sc.nextLine();
            System.out.println("Enter name of book");
            String bname = sc.nextLine();
            System.out.println("Enter Author of the book");
            String bauthor = sc.nextLine();
            System.out.println("Enter publisher name");
            String bpub = sc.nextLine();
            System.out.println("Enter Quantity of book");
            int quan = sc.nextInt();
            System.out.println("Enter photo path:");
            sc.nextLine();
            String photoPath = sc.nextLine();

            String sql = "insert into books(bookno,bookname,author,publisher,quantity,book_photo) values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            String sql1 = "insert into viewbooks (bookno,bookname,author,publisher,quantity,issuedBy) values (?,?,?,?,?,?)";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            pst.setString(1, bno);
            pst.setString(2, bname);
            pst.setString(3, bauthor);
            pst.setString(4, bpub);
            pst.setInt(5, quan);
            File f = new File(photoPath);
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                pst.setBinaryStream(6, fis);
                System.out.println("Photo added");
                pst.executeUpdate();
            } else {
                System.out.println("File not found. Photo not added.");
            }
            pst1.setString(1, bno);
            pst1.setString(2, bname);
            pst1.setString(3, bauthor);
            pst1.setString(4, bpub);
            pst1.setInt(5, quan);
            pst1.setInt(6, 0);
            pst1.executeUpdate();
            int r = pst.executeUpdate();
            if (r > 0) {
                System.out.println("Added Successfully ");
            } else {
                System.out.print("Failed ");
            }
        }
    }

    public static void view_book(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        // String sql = "select * from books";
        // PreparedStatement pst = con.prepareStatement(sql);
        // ResultSet rs = pst.executeQuery();
        // while (rs.next()) {
        // String sql1 = "insert into viewbooks
        // (bookno,bookname,author,publisher,quantity,issuedBy) values (?,?,?,?,?,?)";
        // PreparedStatement pst1 = con.prepareStatement(sql1);
        // pst1.setString(1, rs.getString("bookno"));
        // pst1.setString(2, rs.getString("bookname"));
        // pst1.setString(3, rs.getString("author"));
        // pst1.setString(4, rs.getString("publisher"));
        // pst1.setInt(5, rs.getInt("quantity"));
        // pst1.setInt(6, 0);
        // int r1 = pst1.executeUpdate();
        // }
        String sql2 = "select * from viewbooks";
        PreparedStatement pst2 = con.prepareStatement(sql2);
        ResultSet rs1 = pst2.executeQuery();
        while (rs1.next()) {
            System.out.println("Book id: " + rs1.getInt(1));
            System.out.println("Book no: " + rs1.getString(2));
            System.out.println("Book Name: " + rs1.getString(3));
            System.out.println("Author: " + rs1.getString(4));
            System.out.println("publisher: " + rs1.getString(5));
            System.out.println("Quantity " + rs1.getInt(6));
            System.out.println("Issued by: " + rs1.getInt(7));
            System.out
                    .println(
                            "-----------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void view_issue_book(Connection con) throws SQLException {
        String sql = "select * from issueBook";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println("Book ID: " + rs.getInt(1));
            System.out.println("Book No: " + rs.getString(2));
            System.out.println("Book Name: " + rs.getString(3));
            System.out.println("Author: " + rs.getString(4));
            System.out.println("Publisher: " + rs.getString(5));
            System.out.println("Student ID: " + rs.getInt(6));
            System.out.println("Student Name: " + rs.getString(7));
            System.out.println("Student contact no.: " + rs.getString(8));
        }
    }

    public static void return_book(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of student who return the book");
        int id = sc.nextInt();
        System.out.println("Book id:");
        int bid = sc.nextInt();
        String sql = "Update books set quantity=quantity+1 where Bookid=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, bid);
        pst.executeUpdate();

        String sql2 = "update viewBooks set issuedBy=issuedBy-1 where Bookid=?";
        PreparedStatement pst3 = con.prepareStatement(sql2);
        pst3.setInt(1, bid);
        pst3.executeUpdate();

        String sql4 = "Update viewbooks set quantity=quantity+1 where Bookid=?";
        PreparedStatement pst4 = con.prepareStatement(sql4);
        pst4.setInt(1, bid);
        pst4.executeUpdate();

        String sql1 = "delete from issuebook where sid=? and Bookid=?";
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setInt(1, id);
        pst1.setInt(2, bid);
        pst1.executeUpdate();
    }

    public static void issue_book(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String no = "";
        String name = "";
        String author = "";
        String pub = "";
        int qaun = 0;
        String ssname = "";
        String contact = "";
        System.out.println("Enter ID of the book you want to issue");
        int id = sc.nextInt();
        System.out.println("Enter Student ID of the book you want to issue");
        int s_id = sc.nextInt();
        String sql = "select * from books where Bookid=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            no = rs.getString("bookno");
            name = rs.getString("bookname");
            author = rs.getString("author");
            pub = rs.getString("publisher");
        }

        String sql1 = "select * from student where sid=?";
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setInt(1, s_id);
        ResultSet rs1 = pst1.executeQuery();
        while (rs1.next()) {
            ssname = rs1.getString("sname");
            contact = rs1.getString("Contactno");
        }
        String sql3 = "Insert into issueBook(Bookid,bookno,bookname,author,publisher,sid,sname,contactno) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pst2 = con.prepareStatement(sql3);
        pst2.setInt(1, id);
        pst2.setString(2, no);
        pst2.setString(3, name);
        pst2.setString(4, author);
        pst2.setString(5, pub);
        pst2.setInt(6, s_id);
        pst2.setString(7, ssname);
        pst2.setString(8, contact);
        int r = pst2.executeUpdate();
        if (r > 0) {
            System.out.println("Added Successfully ");
        } else {
            System.out.print("Failed ");
        }

        String sql2 = "update viewBooks set issuedBy=issuedBy+1 where Bookid=?";
        PreparedStatement pst3 = con.prepareStatement(sql2);
        pst3.setInt(1, id);
        pst3.executeUpdate();

        String sql4 = "Update books set quantity=quantity-1 where Bookid=?";
        PreparedStatement pst4 = con.prepareStatement(sql4);
        pst4.setInt(1, id);
        pst4.executeUpdate();

        String sql5 = "Update viewbooks set quantity=quantity-1 where Bookid=?";
        PreparedStatement pst5 = con.prepareStatement(sql5);
        pst5.setInt(1, id);
        pst5.executeUpdate();
    }

    public static void retrieveImage(Connection con, int bookid) throws Exception {
        String sql = "select * from books where Bookid=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, bookid);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Blob b = rs.getBlob("book_photo");
            byte[] arr = b.getBytes(1, (int) b.length());
            FileOutputStream fos = new FileOutputStream(
                    "C:\\Users\\DELL\\Desktop\\Books_photo" + rs.getString("bookname") + ".jpg");
            fos.write(arr);
            fos.close();
            System.out.println("IMAGE FILE STORED IN DESKTOP WITH NAME : new " + rs.getString("bookname"));
        }
    }

}
