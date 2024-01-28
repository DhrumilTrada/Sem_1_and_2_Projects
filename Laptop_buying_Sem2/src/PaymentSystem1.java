import java.util.*;

class PaymentSystem1 {
    double amt1;

    PaymentSystem1(double amount) {
        this.amt1 = amount;
    }

    Scanner sc = new Scanner(System.in);

    void CashPayment() {
        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        if (amount >= amt1) {
            System.out.println("Paid " + amount + " INR by cash.");
        } else {
            System.out.println("Payment Failed..!!");
        }
    }

    void Credit() {
        boolean flag = true;
        while (flag) {
            System.out.print("\nEnter Card Number : ");
            String card_num = sc.next();
            if (card_num.length() == 16) {
                flag = false;
            } else {
                System.out.println("Payment failed!! Try Again");
                flag = true;
            }
        }
        sc.nextLine();
        System.out.print("Enter Card Holder Name : ");
        sc.nextLine();
        System.out.print("Enter Expiry Month and Year (MM/YY) : ");
        sc.next();
        boolean flag1 = true;
        int temp = 0;
        while (flag1) {
            System.out.print("Enter CVV : ");
            String cvv = sc.next();
            if (cvv.length() == 3) {
                flag1 = false;
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                if (amount >= amt1)
                    System.out.println("Paid " + amount + " INR by Credit card.");
                else
                    System.out.println("Payment failed!");
            } else {
                System.out.println("Enter correct CVV!!");
                temp++;
                if (temp == 3) {
                    System.out.println("\nPayment Failed!!");
                    System.out.println("Card Blocked for 24 hours!!");
                    flag1 = false;
                }
            }
        }
    }
    void Debit()
    {
        boolean flag = true;
        while (flag) {
            System.out.print("\nEnter Card Number : ");
            String card_num = sc.next();
            if (card_num.length() == 16) {
                flag = false;
            } else {
                System.out.println("Payment failed!! Try Again");
                flag = true;
            }
        }
        sc.nextLine();
        System.out.print("Enter Card Holder Name : ");
        sc.nextLine();
        System.out.print("Enter Expiry Month and Year (MM/YY) : ");
        sc.next();
        boolean flag1 = true;
        int temp = 0;
        while (flag1) {
            System.out.print("Enter CVV : ");
            String cvv = sc.next();
            if (cvv.length() == 3) {
                flag1 = false;
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                if (amount >= amt1)
                    System.out.println("Paid " + amount + " INR by Debit card.");
                else
                    System.out.println("Payment failed!");
            } else {
                System.out.println("Enter correct CVV!!");
                temp++;
                if (temp == 3) {
                    System.out.println("\nPayment Failed!!");
                    System.out.println("Card Blocked for 24 hours!!");
                    flag1 = false;
                }
            }
        }
    }
}