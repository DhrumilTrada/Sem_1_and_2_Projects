import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;
class College{
    String first_name;
    String last_name;
    long enrollment_no;
    double java,dbms,fee,maths_II,dsa;
    final int credit_of_maths_II=5;
    final int credit_of_dbms=6;
    final int credit_of_dsa=6;
    final int credit_of_java=6;
    final int credit_of_fee=4;

    College(String first_name,String last_name,long enrollment_no,double java,double dbms,double fee,double maths_II,double dsa){
        this.first_name=first_name;
        this.last_name=last_name;
        this.enrollment_no=enrollment_no;
        this.java=java;
        this.dbms=dbms;
        this.fee=fee;
        this.maths_II=maths_II;
        this.dsa=dsa;
        calculate_SPI();
        equivalent_class();
    }
    double total_grade_point_fee(){
        if(fee>=95 && fee<=100){
            return 10.0;
        }else if(fee>=90 && fee<=94){
            return 9.5;
        }else if(fee>=85 && fee<=89){
            return 9.0;
        }else if(fee>=80 && fee<=84){
            return 8.5;
        }else if(fee>=75 && fee<=79){
            return 8.0;
        }else if(fee>=70 && fee<=74){
            return 7.5;
        }else if(fee>=65 && fee<=69){
            return 7.0;
        }else if(fee>=60 && fee<=64){
            return 6.5;
        }else if(fee>=55 && fee<=59){
            return 6.0;
        }else if(fee>=50 && fee<=54){
            return 5.5;
        }else if(fee>=45 && fee<=49){
            return 5.0;
        }else if(fee>=40 && fee<=44){
            return 4.5;
        }else if(fee>=35 && fee<=39){
            return 4.0;
        }else{
            return 0;
        }
    }
     double total_grade_point_maths_II(){
        if(maths_II>=95 && maths_II<=100){
            return 10.0;
        }else if(maths_II>=90 && maths_II<=94){
            return 9.5;
        }else if(maths_II>=85 && maths_II<=89){
            return 9.0;
        }else if(maths_II>=80 && maths_II<=84){
            return 8.5;
        }else if(maths_II>=75 && maths_II<=79){
            return 8.0;
        }else if(maths_II>=70 && maths_II<=74){
            return 7.5;
        }else if(maths_II>=65 && maths_II<=69){
            return 7.0;
        }else if(maths_II>=60 && maths_II<=64){
            return 6.5;
        }else if(maths_II>=55 && maths_II<=59){
            return 6.0;
        }else if(maths_II>=50 && maths_II<=54){
            return 5.5;
        }else if(maths_II>=45 && maths_II<=49){
            return 5.0;
        }else if(maths_II>=40 && maths_II<=44){
            return 4.5;
        }else if(maths_II>=35 && maths_II<=39){
            return 4.0;
        }else{
            return 0;
        }
    }
     double total_grade_point_java(){
        if(java>=95 && java<=100){
            return 10.0;
        }else if(java>=90 && java<=94){
            return 9.5;
        }else if(java>=85 && java<=89){
            return 9.0;
        }else if(java>=80 && java<=84){
            return 8.5;
        }else if(java>=75 && java<=79){
            return 8.0;
        }else if(java>=70 && java<=74){
            return 7.5;
        }else if(java>=65 && java<=69){
            return 7.0;
        }else if(java>=60 && java<=64){
            return 6.5;
        }else if(java>=55 && java<=59){
            return 6.0;
        }else if(java>=50 && java<=54){
            return 5.5;
        }else if(java>=45 && java<=49){
            return 5.0;
        }else if(java>=40 && java<=44){
            return 4.5;
        }else if(java>=35 && java<=39){
            return 4.0;
        }else{
            return 0;
        }
    }
     double total_grade_point_dsa(){
        if(dsa>=95 && dsa<=100){
            return 10.0;
        }else if(dsa>=90 && dsa<=94){
            return 9.5;
        }else if(dsa>=85 && dsa<=89){
            return 9.0;
        }else if(dsa>=80 && dsa<=84){
            return 8.5;
        }else if(dsa>=75 && dsa<=79){
            return 8.0;
        }else if(dsa>=70 && dsa<=74){
            return 7.5;
        }else if(dsa>=65 && dsa<=69){
            return 7.0;
        }else if(dsa>=60 && dsa<=64){
            return 6.5;
        }else if(dsa>=55 && dsa<=59){
            return 6.0;
        }else if(dsa>=50 && dsa<=54){
            return 5.5;
        }else if(dsa>=45 && dsa<=49){
            return 5.0;
        }else if(dsa>=40 && dsa<=44){
            return 4.5;
        }else if(dsa>=35 && dsa<=39){
            return 4.0;
        }else{
            return 0;
        }
    }
     double total_grade_point_dbms(){
        if(dbms>=95 && dbms<=100){
            return 10.0;
        }else if(dbms>=90 && dbms<=94){
            return 9.5;
        }else if(dbms>=85 && dbms<=89){
            return 9.0;
        }else if(dbms>=80 && dbms<=84){
            return 8.5;
        }else if(dbms>=75 && dbms<=79){
            return 8.0;
        }else if(dbms>=70 && dbms<=74){
            return 7.5;
        }else if(dbms>=65 && dbms<=69){
            return 7.0;
        }else if(dbms>=60 && dbms<=64){
            return 6.5;
        }else if(dbms>=55 && dbms<=59){
            return 6.0;
        }else if(dbms>=50 && dbms<=54){
            return 5.5;
        }else if(dbms>=45 && dbms<=49){
            return 5.0;
        }else if(dbms>=40 && dbms<=44){
            return 4.5;
        }else if(dbms>=35 && dbms<=39){
            return 4.0;
        }else{
            return 0;
        }
    }
    double calculate_SPI(){
        double spi=(total_grade_point_dbms()*credit_of_dbms+total_grade_point_dsa()*credit_of_dsa+total_grade_point_fee()*credit_of_fee+total_grade_point_java()*credit_of_java+total_grade_point_maths_II()*credit_of_maths_II);
        double total_credit=credit_of_dbms+credit_of_dsa+credit_of_fee+credit_of_java+credit_of_maths_II;
        return spi/total_credit;
    }
    String equivalent_class(){
        if(calculate_SPI()>7.00){
            return "First Class with Distinction";
        }else if(calculate_SPI()>6.00 && calculate_SPI()<=6.99){
            return "First Class";
        }else if(calculate_SPI()>=5.50 && calculate_SPI()<=5.99){
            return "Higher Second Class";
        }else if(calculate_SPI()>=5.00 && calculate_SPI()<=5.49){
            return "Second Class";
        }else if(calculate_SPI()>=3.50 && calculate_SPI()<=4.99){
            return "Pass Class";
        }else{
            return "Fail";
        }
    }
    void display() {
    System.out.print("|_______________________________________________________|\n");
    System.out.print("|Name=" + first_name + " " + last_name + "                                       |\n");
    System.out.print("|Enrollment_no: " + enrollment_no + "                          |\n");
    System.out.print("|Std: 12th" + "                                              |\n");
    System.out.print("|-------------------------------------------------------|\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|FEE: " + fee + "                                              |\n");
    System.out.print("|Maths_II: " + maths_II + "                                         |\n");
    System.out.print("|DSA: " + dsa + "                                              |\n");
    System.out.print("|Java: " + java + "                                             |\n");
    System.out.print("|DBMS: " + dbms + "                                             |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|SPI: " + calculate_SPI() + "                                 |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|-------------------------------------------------------|\n");
    System.out.print("|Equivalent Class : " + equivalent_class() + "        |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|_______________________________________________________|\n");
}
}
class Std_11th{
    ArrayList<Std_11th> details_of_Std_11th;
    String first_name;
    String last_name;
    int roll_no;
    double physics,maths,chemistry,english,computer;
    double percentage;
    Std_11th(String first_name,String last_name,int roll_no,double physics,double maths,double chemistry,double english,double computer){
        this.first_name=first_name;
        this.last_name=last_name;
        this.roll_no=roll_no;
        this.maths=maths;
        this.chemistry=chemistry;
        this.physics=physics;
        this.english=english;
        this.computer=computer;
        this.details_of_Std_11th=new ArrayList<>();
        getPerecentage();
        get_grades();
    }
    double getPerecentage(){
         return percentage=(physics+maths+chemistry+english+computer)/(5);
    }
    void add_details(){
        details_of_Std_11th.add(new Std_11th(first_name, last_name, roll_no, physics, maths, chemistry, english, computer));
    }
    char get_grades(){
        if(getPerecentage()>=90 && getPerecentage()<100){
            return 'A';
        }else if(getPerecentage()>=80 && getPerecentage()<90){
            return 'B';
        }else if(getPerecentage()>=70 && getPerecentage()<80){
            return 'C';
        }else if(getPerecentage()>45 && getPerecentage()<70){
            return 'D';
        }else{
            return 'F';
        }
    }
    void display() {
    System.out.print("|_______________________________________________________|\n");    
    System.out.print("|Name=" + first_name + " " + last_name + "                                       |\n");
    System.out.print("|Roll_No: " + roll_no + "                                             |\n");
    System.out.print("|Std: 11th" + "                                              |\n");
    System.out.print("|-------------------------------------------------------|\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|Physics: " + physics + "                                          |\n");
    System.out.print("|Maths: " + maths + "                                            |\n");
    System.out.print("|Chemsitry: " + chemistry + "                                        |\n");
    System.out.print("|Computer: " + computer + "                                         |\n");
    System.out.print("|English: " + english + "                                          |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|Percentage: " + percentage + "%                                      |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|-------------------------------------------------------|\n");
    System.out.print("|Grades: " + get_grades() + "                                              |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|_______________________________________________________|\n");
}

}
class Std_12th {
    String first_name;
    String last_name;
    int roll_no;
    double physics,maths,chemistry,english,computer;
    double percentage;
    Std_12th(String first_name,String last_name,int roll_no,double physics,double maths,double chemistry,double english,double computer){
        this.first_name=first_name;
        this.last_name=last_name;
        this.roll_no=roll_no;
        this.maths=maths;
        this.chemistry=chemistry;
        this.physics=physics;
        this.english=english;
        this.computer=computer;
        getPerecentage();
        get_grades();
    }
    double getPerecentage(){
         return percentage=(physics+maths+chemistry+english+computer)/(5);
    }
    char get_grades(){
        if(getPerecentage()>=90 && getPerecentage()<100){
            return 'A';
        }else if(getPerecentage()>=80 && getPerecentage()<90){
            return 'B';
        }else if(getPerecentage()>=70 && getPerecentage()<80){
            return 'C';
        }else if(getPerecentage()>45 && getPerecentage()<70){
            return 'D';
        }else{
            return 'F';
        }
    }
    void display() {
    System.out.print("|_______________________________________________________|\n");
    System.out.print("|Name=" + first_name + " " + last_name + "                                       |\n");
    System.out.print("|Roll_No: " + roll_no + "                                             |\n");
    System.out.print("|Std: 12th" + "                                              |\n");
    System.out.print("|-------------------------------------------------------|\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|Physics: " + physics + "                                          |\n");
    System.out.print("|Maths: " + maths + "                                            |\n");
    System.out.print("|Chemsitry: " + chemistry + "                                        |\n");
    System.out.print("|Computer: " + computer + "                                         |\n");
    System.out.print("|English: " + english + "                                          |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|Percentage: " + percentage + "%                                      |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|-------------------------------------------------------|\n");
    System.out.print("|Grades: " + get_grades() + "                                              |\n");
    System.out.print("|                                                       |\n");
    System.out.print("|_______________________________________________________|\n");
}

}

public class MarksheetGeneration {
    public static void main(String[] args) throws Exception{
        //Load the Driver First
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Build the connection
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheetgenerator", "root", "");
        Scanner sc = new Scanner(System.in);
        //Created an arrayList that stores the all the details of the Student of class 12th
        ArrayList<Std_12th> students_12th = new ArrayList<>();
         //Created an arrayList that stores the all the details of the Student of class 11th
        ArrayList<Std_11th> students_11th = new ArrayList<>();
        ArrayList<College> students_college=new ArrayList<>();
        do {
            System.out.println("1) To generate marksheet for Std_12th");
            System.out.println("2) To generate marksheet for Std_11th");
            System.out.println("3) To generate marksheet for College");
            System.out.println("4) Exit\n");
            System.out.println("Enter the choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //Written an Insert query to store data in database
                    String sql_1="Insert into Std_12th values(?,?,?,?,?,?,?,?,?,?)";
                    //Created a prepared Statement
                    PreparedStatement pst_1=connection.prepareStatement(sql_1);
                    System.out.println("Enter the first_name of Student");
                    String first_name = sc.next();
                    sc.nextLine();
                    System.out.println("Enter the last_name of Student");
                    String last_name = sc.next();
                    System.out.println("Enter the roll_no of Student");
                    int roll_no = sc.nextInt();
                    System.out.println("Enter the marks of physics");
                    double marks_of_phy = sc.nextDouble();
                    System.out.println("Enter the marks of maths");
                    double marks_of_maths = sc.nextDouble();
                    System.out.println("Enter the marks of chemistry");
                    double marks_of_chemistry = sc.nextDouble();
                    System.out.println("Enter the marks of english");
                    double marks_of_english = sc.nextDouble();
                    System.out.println("Enter the marks of computer");
                    double marks_of_computer = sc.nextDouble();
                    // Create and add the student to the ArrayList
                    students_12th.add(new Std_12th(first_name, last_name, roll_no, marks_of_phy, marks_of_maths, marks_of_chemistry, marks_of_english, marks_of_computer));
                    System.out.println("If you want to print details press y/n");
                    char to_print = sc.next().charAt(0);
                    if (to_print == 'y') {
                        // Print details for all students
                        for (Std_12th student : students_12th) {
                            student.display();
                            pst_1.setString(1, student.first_name);
                            pst_1.setString(2,student.last_name);
                            pst_1.setInt(3,student.roll_no);
                            pst_1.setDouble(4, student.physics);
                            pst_1.setDouble(5,student.maths);
                            pst_1.setDouble(6,student.chemistry);
                            pst_1.setDouble(7,student.english);
                            pst_1.setDouble(8,student.computer);
                            pst_1.setDouble(9,student.getPerecentage());
                            //This method is used to convert char to String 
                            pst_1.setString(10,String.valueOf(student.get_grades()));
                            pst_1.executeUpdate();
                        }
                    }
                    break;
                    case 2:
                     //Written an Insert query to store data in database
                    String sql_2="Insert into Std_11th values(?,?,?,?,?,?,?,?,?,?)";
                    //Created a prepared Statement
                    PreparedStatement pst_2=connection.prepareStatement(sql_2);
                    System.out.println("Enter the first_name of Student");
                    String first_name_11 = sc.next();
                    sc.nextLine();
                    System.out.println("Enter the last_name of Student");
                    String last_name_11 = sc.next();
                    System.out.println("Enter the roll_no of Student");
                    int roll_no_11 = sc.nextInt();
                    System.out.println("Enter the marks of physics");
                    double marks_of_phy_11 = sc.nextDouble();
                    System.out.println("Enter the marks of maths");
                    double marks_of_maths_11 = sc.nextDouble();
                    System.out.println("Enter the marks of chemistry");
                    double marks_of_chemistry_11 = sc.nextDouble();
                    System.out.println("Enter the marks of english");
                    double marks_of_english_11 = sc.nextDouble();
                    System.out.println("Enter the marks of computer");
                    double marks_of_computer_11 = sc.nextDouble();

                    // Create and add the student to the ArrayList
                    students_11th.add(new Std_11th(first_name_11, last_name_11, roll_no_11, marks_of_phy_11, marks_of_maths_11, marks_of_chemistry_11, marks_of_english_11, marks_of_computer_11));

                    System.out.println("If you want to print details press y/n");
                    char too_print = sc.next().charAt(0);
                    if (too_print == 'y') {
                        // Print details for all students
                        for (Std_11th student : students_11th) {
                            student.display();
                            pst_2.setString(1, student.first_name);
                            pst_2.setString(2,student.last_name);
                            pst_2.setInt(3,student.roll_no);
                            pst_2.setDouble(4, student.physics);
                            pst_2.setDouble(5,student.maths);
                            pst_2.setDouble(6,student.chemistry);
                            pst_2.setDouble(7,student.english);
                            pst_2.setDouble(8,student.computer);
                            pst_2.setDouble(9,student.getPerecentage());
                            //This method is used to convert char to String 
                            pst_2.setString(10,String.valueOf(student.get_grades()));
                            pst_2.executeUpdate();
                        }
                    }
                    break;
                    case 3:
                    System.out.println("Enter the first_name of Student");
                    String first_name_c = sc.next();
                    sc.nextLine();
                    System.out.println("Enter the last_name of Student");
                    String last_name_c = sc.next();
                    System.out.println("Enter the enroll_no of Student");
                    long enroll_no = sc.nextLong();
                    System.out.println("Enter the marks of FEE");
                    double fee = sc.nextDouble();
                    System.out.println("Enter the marks of MATHS_II");
                    double maths_II = sc.nextDouble();
                    System.out.println("Enter the marks of DSA");
                    double dsa = sc.nextDouble();
                    System.out.println("Enter the marks of DBMS");
                    double dbms = sc.nextDouble();
                    System.out.println("Enter the marks of JAVA");
                    double java = sc.nextDouble(); 
                    students_college.add(new College(first_name_c, last_name_c, enroll_no, java, dbms, fee, maths_II, dsa));
                    System.out.println("If you want to print details then press y/n");
                    char tooo_print=sc.next().charAt(0);
                    if(tooo_print=='y'){
                    for(College student:students_college){
                        String sql_c="Insert into College values(?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pst_c=connection.prepareStatement(sql_c);
                        pst_c.setString(1,student.first_name);
                        pst_c.setString(2,student.last_name);
                        pst_c.setString(3,Long.toString(student.enrollment_no));
                        pst_c.setDouble(4, student.java);
                        pst_c.setDouble(5,student.dbms);
                        pst_c.setDouble(6,student.fee);
                        pst_c.setDouble(7,student.maths_II);
                        pst_c.setDouble(8,student.dsa);
                        pst_c.setString(9,String.format("%.2f", student.calculate_SPI()));
                        pst_c.setString(10,student.equivalent_class());
                        pst_c.executeUpdate();
                        student.display();
                    }
                }else{
                    break;
                }
                break;
                case 4:
                System.out.println("Exiting.....");
                System.exit(0);
                break;
                default:
                System.out.println("Enter a valid choice");
                break;
            }
        } while (true);
    }
}