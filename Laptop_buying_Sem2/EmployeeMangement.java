import java.io.StringReader;
import java.util.Scanner;

class DoublyLinklist {
    DoublyLinklist dll;
    Scanner sc = new Scanner(System.in);

    class Node {
        int e_id;
        int working_days;
        String ename;
        int salary;
        String mobile;
        String address;
        String email;
        String dob;
        String Education;
        Node next;
        Node prev;

        Node(int e_id, String ename, String dob, String address, int salary, String mobile, String email,
                String Education) {
            int max = 300;
            int min = 150;
            this.e_id = e_id;
            this.ename = ename;
            this.dob = dob;
            this.address = address;
            this.salary = salary;
            this.mobile = mobile;
            this.email = email;
            this.Education = Education;
            this.next = null;
            this.prev = null;
            this.working_days = (int) (Math.random() * (max - min + 1) + min);
        }
    }

    Node first = null;

    void raise_leave(int id, String name) {
        Node temp = first;
        while (temp != null) {
            if (temp.e_id == id && temp.ename.equals(name)) {
                break;
            }
            temp=temp.next;
        }
        int w_day = temp.working_days;
        while (true) {
            System.out.println("Leave Duration:");
            System.out.println("1. 1 to 7 days   Minimum 170 Working Days");
            System.out.println("2. 8 to 14 days   Minimum 200 Working Days");
            System.out.println("3. 15 to 21 days   Minimum 240 Working Days");
            System.out.println("4. 22 to 28 days   Minimum 290 Working Days");
            System.out.println("Enter days for application of leave:");
            int leave = sc.nextInt();
            if (leave > 0 && leave < 8) {
                if (w_day >= 170) {
                    System.out.println("You are eligible for taking leave of 1 to 7 days");
                    break;
                }
                System.out.println("You are not eligible for leave of this many days");
            } else if (leave >= 8 && leave < 15) {
                if (w_day >= 200) {
                    System.out.println("You are eligible for taking leave of 8 to 14 days");
                    break;
                }
                System.out.println("You are not eligible for leave of this many days");
            } else if (leave >= 15 && leave < 22) {
                if (w_day >= 240) {
                    System.out.println("You are eligible for taking leave of 15 to 21 days");
                    break;
                }
                System.out.println("You are not eligible for leave of this many days");
            } else if (leave >= 22 && leave < 29) {
                if (w_day >= 290) {
                    System.out.println("You are eligible for taking leave of 22 to 28 days");
                    break;
                }
                System.out.println("You are not eligible for leave of this many days");
            } else if (leave >= 29) {
                System.out.println("Enter days between 1 to 28 only...");
            } else {
                System.out.println("You are no eligible for applying for leave");
                break;
            }
        }
    }

    void addEmployee(int e_id, String ename, String dob, String address, int salary, String mobile, String email,
            String Education) {
        Node n = new Node(e_id, ename, dob, address, salary, mobile, email, Education);
        if (first == null) {
            first = n;
        } else {
            n.next = first;
            first.prev = n;
            first = n;
        }
    }

    void addEmployeeatlast(int e_id, String ename, String dob, String address, int salary, String mobile, String email,
            String Education) {
        Node n = new Node(e_id, ename, dob, address, salary, mobile, email, Education);
        if (first == null) {
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    void deletelastEmployee() {
        if (first == null) {
            System.out.println("EMPTY");
        } else {
            Node del = first;
            first = first.next;
            first.prev = null;
            del.next = null;
        }
    }

    void updateEmployee(int e_id) {
        Node temp = first;
        while (temp != null) {
            if (temp.e_id == e_id) {
                System.out.println("what you want to update");
                System.out.println("1)Name 2)address 3)Mobile No.");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Enter new Name");
                        sc.nextLine();
                        String name = sc.nextLine();
                        temp.ename = name;
                        break;
                    case 2:
                        System.out.println("Enter new address");
                        String add = sc.nextLine();
                        temp.address = add;
                    case 3:
                        System.out.println("Enter new phone nmber");
                        String mob = sc.nextLine();
                        temp.mobile = mob;
                    default:
                        break;
                }
            }
            temp = temp.next;
        }
        display();
    }

    void searchparticularemployee(int e_id) {
        if (first == null) {
            System.out.println("Empty....");
        } else {
            Node temp = first;
            int flag = 0;
            while (temp != null) {
                if (temp.e_id == e_id) {
                    System.out.println("\t\t\t-----------------Details of Employee:-----------------");
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------");
                    System.out.print(String.format("%-9s", "|Emp_id"));
                    System.out.print(String.format("%-18s", "|Name"));
                    System.out.print(String.format("%-14s", "|DOB"));
                    System.out.print(String.format("%-10s", "|Salary"));
                    System.out.print(String.format("%-12s", "|Mobile_no"));
                    System.out.print(String.format("%-26s", "|E-mail"));
                    System.out.print(String.format("%-14s", "|Address"));
                    System.out.print(String.format("%-10s", "|Education|"));
                    System.out.println();
                    System.out.print(String.format("%-9s", "|" + temp.e_id));
                    System.out.print(String.format("%-18s", "|" + temp.ename));
                    System.out.print(String.format("%-14s", "|" + temp.dob));
                    System.out.print(String.format("%-10s", "|" + temp.salary));
                    System.out.print(String.format("%-12s", "|" + temp.mobile));
                    System.out.print(String.format("%-26s", "|" + temp.email));
                    System.out.print(String.format("%-14s", "|" + temp.address));
                    System.out.print(String.format("%-10s", "|" + temp.Education + "|"));
                    System.out.println();
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------");
                    break;
                }
                temp = temp.next;
            }
        }
    }

    void removeparticularEmployee(int e_id) {
        Node dummy = first;
        int flag = 0;
        if (first == null) {
            System.out.println("Linlist is empty");
        }
        do {
            if (dummy.e_id == e_id) {
                flag = 1;
            }
            dummy = dummy.next;
        } while (dummy != null);
        if (flag == 0) {
            System.out.println("ID NOT FOUND!!!!!!");
        } else {
            if (first.e_id == e_id && first.next == null) {
                first = null;
            } else if (first.e_id == e_id && first.next != null) {
                Node del = first;
                first = first.next;
                first.prev = null;
                del.next = null;
            } else {
                Node temp = first;
                while (temp.e_id != e_id) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    Node q = temp;
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    q.next = null;
                    q.prev = null;
                } else {
                    temp.prev.next = null;
                    temp.prev = null;
                }
            }
        }
    }

    void display() {
        Node temp = first;
        System.out.println("\t\t\t-----------------Details of Employees:-----------------");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-9s", "|Emp_id"));
        System.out.print(String.format("%-18s", "|Name"));
        System.out.print(String.format("%-14s", "|DOB"));
        System.out.print(String.format("%-10s", "|Salary"));
        System.out.print(String.format("%-12s", "|Mobile_no"));
        System.out.print(String.format("%-26s", "|E-mail"));
        System.out.print(String.format("%-14s", "|Address"));
        System.out.print(String.format("%-10s", "|Education|"));
        System.out.println();

        while (temp != null) {
            System.out.print(String.format("%-9s", "|" + temp.e_id));
            System.out.print(String.format("%-18s", "|" + temp.ename));
            System.out.print(String.format("%-14s", "|" + temp.dob));
            System.out.print(String.format("%-10s", "|" + temp.salary));
            System.out.print(String.format("%-12s", "|" + temp.mobile));
            System.out.print(String.format("%-26s", "|" + temp.email));
            System.out.print(String.format("%-14s", "|" + temp.address));
            System.out.print(String.format("%-10s", "|" + temp.Education + "|"));
            System.out.println();
            temp = temp.next;
        }
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");
    }
}

class EmployeeMangement {
    public static void main(String[] args) {
        DoublyLinklist dll = new DoublyLinklist();
        Scanner sc = new Scanner(System.in);
        dll.addEmployee(1, "Dhrumil Trada", "2004-09-22", "Jamnagar", 200000, "7405810278", "dhrumiltrada11@gmail.com",
                "Graduate");
        dll.addEmployee(2, "Hitexa Ingle", "2005-08-04", "Vadodara", 400000, "9512557807", "inglehitexa@gmail.com",
                "Doctorate");
        dll.addEmployee(3, "Meet Patil", "2008-09-26", "Ahmedabad", 600000, "9654885364", "patilmeet01@gmail.com",
                "Post Graduate");
        int choice;
        int e_id = 4;
        while (true) {
            System.out.println("1. Admin login           2. User login");
            int choice1 = sc.nextInt();
            sc.nextLine();
            switch (choice1) {
                case 1:
                    String admin_password = "admin@21";
                    String admin_name = "admin";
                    int flagg = 0;
                    while (true) {
                        System.out.println("Enter admin login info:");
                        String name = sc.nextLine();
                        if (name.equals(admin_name)) {
                            System.out.println("Valid admin username.....");
                            System.out.println("Enter password for login:");
                            String pass = sc.nextLine();
                            if (pass.equals(admin_password)) {
                                System.out.println("Valid admin password.....");
                                flagg = 1;
                                break;
                            } else {
                                System.out.println("Enter valid password!!!!");
                            }
                        } else {
                            System.out.println("Enter valid admin username!!!!`");
                        }
                    }
                    if (flagg == 1) {
                        do {
                            System.out.println(
                                    "\t\t\t\t\t╔════════════════════════\u001B[47m\u001B[30m" + "MENU" + "\u001B[0m"
                                            + "════════════════════════╗");
                            System.out.println("\t\t\t\t\t║     [1]  Enter 1 for add an employee               ║");
                            System.out.println("\t\t\t\t\t║     [2]  Enter 2 for remove an employee            ║");
                            System.out.println("\t\t\t\t\t║     [3]  Enter 3 for search an employee            ║");
                            System.out.println("\t\t\t\t\t║     [4]  Enter 4 to update an employee             ║");
                            System.out.println("\t\t\t\t\t║     [5]  Enter 5 for remove particular an employee ║");
                            System.out.println("\t\t\t\t\t║     [6]  Enter 6 to display                        ║");
                            System.out.println("\t\t\t\t\t║     [7]  Enter 7 to apply leave                    ║");
                            System.out.println("\t\t\t\t\t║     [7]  Enter 8 to exit                           ║");
                            System.out.println("\t\t\t\t\t╚════════════════════════════════════════════════════╝");

                            System.out.print("Enter your choice number here: ");
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    sc.nextLine();
                                    System.out.println(
                                            "---------------------Enter NAME of Employee----------------------------------");
                                    String ename = sc.nextLine();
                                    String dob;
                                    while (true) {
                                        System.out.println(
                                                "---------------------Enter DATE OF BIRTH of Employee-------------");
                                        dob = sc.nextLine();
                                        if (date_validation(dob)) {
                                            System.out.println("Valid DOB!!!");
                                            break;
                                        } else {
                                            System.out.println("Enter a valid DOB!!!!");
                                        }
                                    }
                                    System.out.println(
                                            "---------------------Enter SALARY of Employee-------------------------------");
                                    int salary = sc.nextInt();
                                    sc.nextLine();
                                    String mob;
                                    int flag;
                                    while (true) {
                                        flag = 0;
                                        System.out.println(
                                                "---------------------Enter MOBILE of Employee-------------------------------");
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
                                    String email;
                                    while (true) {
                                        System.out.println(
                                                "----------------------Enter EMAIL of Employee-------------------------------");
                                        email = sc.nextLine();
                                        if (isEmailValid(email)) {
                                            System.out.println("Valid email!!!!");
                                            break;
                                        } else {
                                            System.out.println("Enter a valid email!!!!");
                                        }
                                    }
                                    System.out.println(
                                            "----------------------Enter ADDRESS of Employee-----------------------------");
                                    String address = sc.nextLine();
                                    System.out.println(
                                            "----------------------Enter EDUCATION of Employee------------------------");
                                    String Education = sc.nextLine();
                                    dll.addEmployeeatlast(e_id, ename, dob, address, salary, mob, email, Education);
                                    e_id++;
                                    break;
                                case 2:
                                    dll.deletelastEmployee();
                                    break;
                                case 3:
                                    System.out.println("Enter id of employee you want to search");
                                    int eid = sc.nextInt();
                                    dll.searchparticularemployee(eid);
                                    break;
                                case 4:
                                    System.out.println("Enter id");
                                    int id = sc.nextInt();
                                    dll.updateEmployee(id);
                                    break;
                                case 5:
                                    System.out.println("Enter id");
                                    id = sc.nextInt();
                                    dll.removeparticularEmployee(id);
                                    break;
                                case 6:
                                    dll.display();
                                    break;
                                case 7:
                                    System.out.println("Enter name:");
                                    sc.nextLine();
                                    String name = sc.nextLine();
                                    System.out.println("Enter id:");
                                    int id1 = sc.nextInt();

                                    dll.raise_leave(id1, name);
                                default:
                                    System.out.println("Enter valid choice");
                                    break;
                            }
                        } while (choice != 8);
                    } else {
                        System.out.println("ADMIN does not exist!!!!!s");
                    }
                    break;
                case 2:
                    dll.display();
                    break;
                default:
                    break;
            }
            break;
        }

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

    public static boolean isEmailValid(String email) {
        // Check if the email contain an "@" symbol
        if (email.contains("@") && email.contains(".com")) {
            return true;
        } else {
            return false;
        }
    }
}
