import java.util.Scanner;

class Payment {
    static Scanner sc = new Scanner(System.in);
    static String RED = "\u001B[31;1m";
    static String RESET = "\u001B[0m";
    static String GREEN = "\u001B[32;1;3m";
    static final String CYAN = "\u001B[36m";

    static boolean payment(int value, String pswd) {
        while (true) {
            System.out.println(CYAN
                    + "                  ENTER \n                    1 FOR UPI PAYMENT \n                    2 FOR NET BANKING"
                    + RESET);
            System.out.print(RED + "                  ENTER CHOICE " + RESET);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    return (payByUpi(value, pswd));

                case "2":
                    sc.nextLine();
                    return (netBanking(value, pswd));

                default:
                    System.out.println("\n"+RED + "                  INVALID CHOICE" + RESET+"\n");
                    break;
            }
        }
    }

    static boolean payByUpi(int value, String pswd) {
        System.out.print(CYAN + "                  ENTER UPI ID : " + RESET);
        sc.nextLine();
        System.out.print(CYAN+"                  ENTER UPI PIN : "+RESET);
        sc.nextLine();
        int tries = 5;
        while (true) {
            if (tries == 0) {
                System.out.println("\n"+RED + "                  PAYMENT DECLINED!" + RESET);
                return false;
            }
            System.out.print(CYAN + "                  Enter used registration password : " + RESET);
            String passcheck = sc.nextLine();
            if (passcheck.equalsIgnoreCase(pswd)) {
                while (true) {
                    System.out.print("                  ENTER 1 FOR CONFIRM PAYMENT OF : " +RED+ value+RESET);
                    int n = sc.nextInt();
                    if (n == 1) {
                        System.out.println(GREEN + "                  PAYMENT SUCCESSFUL" + RESET);
                        return true;
                    } else {
                        System.out.println("\n" + RED + "                  INVALID NUMBER\n" + RESET);
                        System.out.println("\n" + RED + "                  ENTER VALID NUMBER!\n" + RESET);
                     }
                }
            } else {
                System.out.println("\n" + RED + "                  INVALID DETAILS" + RESET);
                System.out.println(RED + "                  Attempts left : " + (--tries) + RESET + "\n");
            }
        }
    }

    static boolean netBanking(int value, String pswd) {
        String card, pin, cvv;
        int temp1 = 0, temp2 = 0, temp3 = 0;
        int tries = 5;
        while (true) {
            if (tries == 0) {
                System.out.println("\n" + RED + "                  Payment Declined" + RESET + "\n");
                return false;
            }
            System.out.print(CYAN + "                  ENTER CARD NUMBER (Must be of 12 digits) :" + RESET);
            card = sc.nextLine();
            System.out.print(CYAN + "                  ENTER PIN (Must be of 4 digits) : " + RESET);
            pin = sc.nextLine();
            System.out.print(CYAN + "                  ENTER CVV NUMBER (Must be of 3 digits) : " + RESET);
            cvv = sc.nextLine();
            System.out.print(CYAN + "                  Enter used registration password : " + RESET);
            String passcheck = sc.nextLine();
            char ch[] = card.toCharArray();
            char ch2[] = pin.toCharArray();
            char ch3[] = cvv.toCharArray();
            if (card.length() == 12 && pin.length() == 4 && cvv.length() == 3) {
                for (int i = 0; i < 12; i++) {
                    if (ch[i] >= '0' && ch[i] <= '9') {
                        temp1 = 1;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if (ch2[i] >= '0' && ch2[i] <= '9') {
                        temp2 = 1;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (ch3[i] >= '0' && ch3[i] <= '9') {
                        temp3 = 1;
                    }
                }
            } 
            if (temp1 == 1 && temp2 == 1 && temp3 == 1 && passcheck.equalsIgnoreCase(pswd)) {
                while (true) {
                    System.out
                            .print("                  ENTER 1 FOR CONFIRM PAYMENT OF : " + RED + value + RESET + "   ");
                    int n = sc.nextInt();
                    if (n == 1) {
                        System.out.println(GREEN + "                  PAYMENT SUCCESSFUL" + RESET);
                        return true;
                    } else {
                        System.out.println("\n" + RED + "                  INVALID NUMBER\n" + RESET);
                        System.out.println("\n" + RED + "                  Enter valid number!\n" + RESET);
                    }
                }
            } else {
                System.out.println("\n" + RED + "                  INVALID DETAILS" + RESET);
                System.out.println(RED + "                  Attempts left : " + (--tries) + RESET + "\n");
            }
        }
    }
}