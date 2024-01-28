package Projects;

import java.util.*;
import java.io.*;
import java.sql.*;

public class Laptop_selection {
    Scanner s = new Scanner(System.in);
    Hashtable<Integer, Lap_data> Asus = new Hashtable<>();
    Hashtable<Integer, Lap_data> Lenovo = new Hashtable<>();
    Hashtable<Integer, Lap_data> Dell = new Hashtable<>();
    Hashtable<Integer, Lap_data> Msi = new Hashtable<>();
    Hashtable<Integer, Lap_data> Hp = new Hashtable<>();
    HashSet<Lap_data> Finalize = new HashSet<>();
    HashSet<String> users;
    ArrayList<Lap_data> al;
    String cyan = "\u001B[36m";
    String cyan_bold = "\u001B[36;1m";
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String red_bold = "\u001B[31;1m";
    String black = "\u001B[30m";
    String white_bg = "\u001B[47m";

    Laptop_selection() {
        Lap_data[] laptop = new Lap_data[30];
        for (int i = 0; i < 30; i++) {
            laptop[i] = new Lap_data();
        }
        for (int i = 0; i < 30; i++) {
            laptop[i].setData(laptop);
        }
        for (int i = 1; i <= 6; i++) {
            Asus.put(i, laptop[i - 1]);
        }
        for (int i = 1; i <= 6; i++) {
            Lenovo.put(i, laptop[i + 5]);
        }
        for (int i = 1; i <= 6; i++) {
            Dell.put(i, laptop[i + 11]);
        }
        for (int i = 1; i <= 6; i++) {
            Msi.put(i, laptop[i + 17]);
        }
        for (int i = 1; i <= 6; i++) {
            Hp.put(i, laptop[i + 23]);
        }
    }

    public void search_brand(String name, Connection con) throws SQLException, ClassCastException, IOException {
        System.out.println(name);
        System.out.println("The available Brands on our store are as BELOW: ");
        System.out.println(
                "                                " + white_bg + black + "-----------------------------------" + reset);
        System.out.println(
                "\u001B[33m" + "                                |1.ASUS" + "\u001B[34m" + "|2.LENOVO|" + "\u001B[37m"
                        + "\u001B[31m" + "3.DELL" + "\u001B[34m" + "|4.MSI|" + "\u001B[33m" + "5.HP|" + "\u001B[0m");
        System.out.println(
                "                                " + white_bg + black + "-----------------------------------" + reset);
        int choice;
        int flag = 1;
        while (flag == 1) {
            System.out.println(cyan_bold + "Enter your Choice for Laptop Brand: " + reset);
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 1; i <= 6; i++) {
                        System.out.println(Asus.get(i));
                    }
                    System.out.println("Do you want to add laptops for Comparison?" + cyan_bold + " Y " + reset + "/ "
                            + red_bold + "N" + reset);
                    s.nextLine();
                    String choicee = s.nextLine();
                    if (choicee.equalsIgnoreCase("Y")) {
                        System.out.println("Choose how many laptops to compare b/w 2 to 4....");
                        int cas;
                        while (true) {
                            cas = s.nextInt();
                            if (cas >= 2 && cas < 5) {
                                break;
                            }
                        }
                        switch (cas) {
                            case 2:
                                int cho[] = new int[2];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho[1] = s.nextInt();
                                    if ((cho[0] >= 1 && cho[0] <= 6) && (cho[1] >= 1 && cho[1] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Asus.get(cho[0]));
                                System.out.println(Asus.get(cho[1]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                System.out.println(cho[0] + " " + cho[1]);
                                int confirm = 0;
                                while (true) {
                                    confirm = s.nextInt();
                                    if (confirm == cho[0] || confirm == cho[1]) {
                                        System.out.println(cyan_bold + "Selected Laptop exist...." + reset);
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Asus.get(confirm));
                                System.out.println(cyan_bold + "Added succesfully to cart...." + reset);
                                break;
                            case 3:
                                int cho1[] = new int[3];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho1[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho1[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho1[2] = s.nextInt();
                                    if ((cho1[0] >= 1 && cho1[0] <= 6) && (cho1[1] >= 1 && cho1[1] <= 6)
                                            && (cho1[2] >= 1 && cho1[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Asus.get(cho1[0]));
                                System.out.println(Asus.get(cho1[1]));
                                System.out.println(Asus.get(cho1[2]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm1;
                                while (true) {
                                    confirm1 = s.nextInt();
                                    if (confirm1 == cho1[0] || confirm1 == cho1[1] || confirm1 == cho1[2]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Asus.get(confirm1));
                                break;
                            case 4:
                                int cho2[] = new int[4];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho2[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho2[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho2[2] = s.nextInt();
                                    System.out.println("Enter Product key 4: ");
                                    cho2[3] = s.nextInt();
                                    if ((cho2[0] >= 1 && cho2[0] <= 6) && (cho2[1] >= 1 && cho2[1] <= 6)
                                            && (cho2[2] >= 1 && cho2[2] <= 6) && (cho2[3] >= 1 && cho2[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Asus.get(cho2[0]));
                                System.out.println(Asus.get(cho2[1]));
                                System.out.println(Asus.get(cho2[2]));
                                System.out.println(Asus.get(cho2[3]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm2;
                                while (true) {
                                    confirm2 = s.nextInt();
                                    if (confirm2 == cho2[0] || confirm2 == cho2[1] || confirm2 == cho2[2]
                                            || confirm2 == cho2[3]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Asus.get(confirm2));
                                System.out.println("Added succesfully to cart....");
                                break;
                            default:
                                System.out.println("Enter valid input.....");
                                break;
                        }
                    } else {
                        System.out.println("Enter product key to finalize Laptop: ");
                        int final1 = s.nextInt();
                        Finalize.add(Asus.get(final1));
                        System.out.println("Added succesfully to cart....");
                    }
                    System.out.println("Do you want to Add more laptops?" + cyan_bold + " Y " + reset + "/ " + red_bold
                            + "N" + reset);
                    s.nextLine();
                    String c = s.nextLine();
                    if (c.equalsIgnoreCase("N")) {
                        flag = 0;
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 6; i++) {
                        System.out.println(Lenovo.get(i));
                    }
                    System.out.println("Do you want to add laptops for Comparison?" + cyan_bold + " Y " + reset + "/ "
                            + red_bold + "N" + reset);
                    s.nextLine();
                    String choicee1 = s.nextLine();
                    if (choicee1.equalsIgnoreCase("Y")) {
                        System.out.println("Choose how many laptops to compare b/w 2 to 4....");
                        int cas;
                        while (true) {
                            cas = s.nextInt();
                            if (cas >= 2 && cas < 5) {
                                break;
                            }
                        }
                        switch (cas) {
                            case 2:
                                int cho[] = new int[2];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho[1] = s.nextInt();
                                    if ((cho[0] >= 1 && cho[0] <= 6) && (cho[1] >= 1 && cho[1] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Lenovo.get(cho[0]));
                                System.out.println(Lenovo.get(cho[1]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                System.out.println(cho[0] + " " + cho[1]);
                                int confirm = 0;
                                while (true) {
                                    confirm = s.nextInt();
                                    if (confirm == cho[0] || confirm == cho[1]) {
                                        System.out.println(cyan_bold + "Selected Laptop exist...." + reset);
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Lenovo.get(confirm));
                                System.out.println("Added succesfully to cart....");
                                break;
                            case 3:
                                int cho1[] = new int[3];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho1[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho1[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho1[2] = s.nextInt();
                                    if ((cho1[0] >= 1 && cho1[0] <= 6) && (cho1[1] >= 1 && cho1[1] <= 6)
                                            && (cho1[2] >= 1 && cho1[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Lenovo.get(cho1[0]));
                                System.out.println(Lenovo.get(cho1[1]));
                                System.out.println(Lenovo.get(cho1[2]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm1;
                                while (true) {
                                    confirm1 = s.nextInt();
                                    if (confirm1 == cho1[0] || confirm1 == cho1[1] || confirm1 == cho1[2]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Lenovo.get(confirm1));
                                break;
                            case 4:
                                int cho2[] = new int[4];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho2[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho2[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho2[2] = s.nextInt();
                                    System.out.println("Enter Product key 4: ");
                                    cho2[3] = s.nextInt();
                                    if ((cho2[0] >= 1 && cho2[0] <= 6) && (cho2[1] >= 1 && cho2[1] <= 6)
                                            && (cho2[2] >= 1 && cho2[2] <= 6) && (cho2[3] >= 1 && cho2[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Lenovo.get(cho2[0]));
                                System.out.println(Lenovo.get(cho2[1]));
                                System.out.println(Lenovo.get(cho2[2]));
                                System.out.println(Lenovo.get(cho2[3]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm2;
                                while (true) {
                                    confirm2 = s.nextInt();
                                    if (confirm2 == cho2[0] || confirm2 == cho2[1] || confirm2 == cho2[2]
                                            || confirm2 == cho2[3]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Lenovo.get(confirm2));
                                System.out.println("Added succesfully to cart....");
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Enter product key to finalize Laptop: ");
                        int final1 = s.nextInt();
                        Finalize.add(Lenovo.get(final1));
                        System.out.println("Added succesfully to cart....");
                    }
                    System.out.println("Do you want to Add more laptops?" + cyan_bold + " Y " + reset + "/ " + red_bold+ "N" + reset);
                    s.nextLine();
                    String c1 = s.nextLine();
                    if (c1.equalsIgnoreCase("N")) {
                        flag = 0;
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 6; i++) {
                        System.out.println(Dell.get(i));
                    }
                    System.out.println("Do you want to add laptops for Comparison?" + cyan_bold + " Y " + reset + "/ "
                            + red_bold + "N" + reset);
                    s.nextLine();
                    String choicee2 = s.nextLine();
                    if (choicee2.equalsIgnoreCase("Y")) {
                        System.out.println("Choose how many laptops to compare b/w 2 to 4....");
                        int cas;
                        while (true) {
                            cas = s.nextInt();
                            if (cas >= 2 && cas < 5) {
                                break;
                            }
                        }
                        switch (cas) {
                            case 2:
                                int cho[] = new int[2];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho[1] = s.nextInt();
                                    if ((cho[0] >= 1 && cho[0] <= 6) && (cho[1] >= 1 && cho[1] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Dell.get(cho[0]));
                                System.out.println(Dell.get(cho[1]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                System.out.println(cho[0] + " " + cho[1]);
                                int confirm = 0;
                                while (true) {
                                    confirm = s.nextInt();
                                    if (confirm == cho[0] || confirm == cho[1]) {
                                        System.out.println(cyan_bold + "Selected Laptop exist...." + reset);
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Dell.get(confirm));
                                System.out.println("Added succesfully to cart....");

                                break;
                            case 3:
                                int cho1[] = new int[3];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho1[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho1[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho1[2] = s.nextInt();
                                    if ((cho1[0] >= 1 && cho1[0] <= 6) && (cho1[1] >= 1 && cho1[1] <= 6)
                                            && (cho1[2] >= 1 && cho1[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Dell.get(cho1[0]));
                                System.out.println(Dell.get(cho1[1]));
                                System.out.println(Dell.get(cho1[2]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm1;
                                while (true) {
                                    confirm1 = s.nextInt();
                                    if (confirm1 == cho1[0] || confirm1 == cho1[1] || confirm1 == cho1[2]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Dell.get(confirm1));
                                break;
                            case 4:
                                int cho2[] = new int[4];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho2[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho2[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho2[2] = s.nextInt();
                                    System.out.println("Enter Product key 4: ");
                                    cho2[3] = s.nextInt();
                                    if ((cho2[0] >= 1 && cho2[0] <= 6) && (cho2[1] >= 1 && cho2[1] <= 6)
                                            && (cho2[2] >= 1 && cho2[2] <= 6) && (cho2[3] >= 1 && cho2[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Dell.get(cho2[0]));
                                System.out.println(Dell.get(cho2[1]));
                                System.out.println(Dell.get(cho2[2]));
                                System.out.println(Dell.get(cho2[3]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm2;
                                while (true) {
                                    confirm2 = s.nextInt();
                                    if (confirm2 == cho2[0] || confirm2 == cho2[1] || confirm2 == cho2[2]
                                            || confirm2 == cho2[3]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Dell.get(confirm2));
                                System.out.println("Added succesfully to cart....");
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Enter product key to finalize Laptop: ");
                        int final1 = s.nextInt();
                        Finalize.add(Dell.get(final1));
                        System.out.println("Added succesfully to cart....");
                    }
                    System.out.println("Do you want to Add more laptops?" + cyan_bold + " Y " + reset + "/ " + red_bold
                            + "N" + reset);
                    s.nextLine();
                    String c2 = s.nextLine();
                    if (c2.equalsIgnoreCase("N")) {
                        flag = 0;
                    }
                    break;
                case 4:
                    for (int i = 1; i <= 6; i++) {
                        System.out.println(Msi.get(i));
                    }
                    System.out.println("Do you want to add laptops for Comparison?" + cyan_bold + " Y " + reset + "/ "
                            + red_bold + "N" + reset);
                    s.nextLine();
                    String choicee3 = s.nextLine();
                    if (choicee3.equalsIgnoreCase("Y")) {
                        System.out.println("Choose how many laptops to compare b/w 2 to 4....");
                        int cas;
                        while (true) {
                            cas = s.nextInt();
                            if (cas >= 2 && cas < 5) {
                                break;
                            }
                        }
                        switch (cas) {
                            case 2:
                                int cho[] = new int[2];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho[1] = s.nextInt();
                                    if ((cho[0] >= 1 && cho[0] <= 6) && (cho[1] >= 1 && cho[1] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Msi.get(cho[0]));
                                System.out.println(Msi.get(cho[1]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                System.out.println(cho[0] + " " + cho[1]);
                                int confirm = 0;
                                while (true) {
                                    confirm = s.nextInt();
                                    if (confirm == cho[0] || confirm == cho[1]) {
                                        System.out.println(cyan_bold + "Selected Laptop exist...." + reset);
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Msi.get(confirm));
                                System.out.println("Added succesfully to cart....");
                                break;
                            case 3:
                                int cho1[] = new int[3];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho1[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho1[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho1[2] = s.nextInt();
                                    if ((cho1[0] >= 1 && cho1[0] <= 6) && (cho1[1] >= 1 && cho1[1] <= 6)
                                            && (cho1[2] >= 1 && cho1[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Msi.get(cho1[0]));
                                System.out.println(Msi.get(cho1[1]));
                                System.out.println(Msi.get(cho1[2]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm1;
                                while (true) {
                                    confirm1 = s.nextInt();
                                    if (confirm1 == cho1[0] || confirm1 == cho1[1] || confirm1 == cho1[2]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Msi.get(confirm1));
                                break;
                            case 4:
                                int cho2[] = new int[4];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho2[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho2[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho2[2] = s.nextInt();
                                    System.out.println("Enter Product key 4: ");
                                    cho2[3] = s.nextInt();
                                    if ((cho2[0] >= 1 && cho2[0] <= 6) && (cho2[1] >= 1 && cho2[1] <= 6)
                                            && (cho2[2] >= 1 && cho2[2] <= 6) && (cho2[3] >= 1 && cho2[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Msi.get(cho2[0]));
                                System.out.println(Msi.get(cho2[1]));
                                System.out.println(Msi.get(cho2[2]));
                                System.out.println(Msi.get(cho2[3]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm2;
                                while (true) {
                                    confirm2 = s.nextInt();
                                    if (confirm2 == cho2[0] || confirm2 == cho2[1] || confirm2 == cho2[2]
                                            || confirm2 == cho2[3]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Msi.get(confirm2));
                                System.out.println("Added succesfully to cart....");
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Enter product key to finalize Laptop: ");
                        int final1 = s.nextInt();
                        Finalize.add(Msi.get(final1));
                        System.out.println("Added succesfully to cart....");
                    }
                    System.out.println("Do you want to Add more laptops?" + cyan_bold + " Y " + reset + "/ " + red_bold
                            + "N" + reset);
                    s.nextLine();
                    String c3 = s.nextLine();
                    if (c3.equalsIgnoreCase("N")) {
                        flag = 0;
                    }
                    break;
                case 5:
                    for (int i = 1; i <= 6; i++) {
                        System.out.println(Hp.get(i));
                    }
                    System.out.println("Do you want to add laptops for Comparison?" + cyan_bold + " Y " + reset + "/ "
                            + red_bold + "N" + reset);
                    s.nextLine();
                    String choicee4 = s.nextLine();
                    if (choicee4.equalsIgnoreCase("Y")) {
                        System.out.println("Choose how many laptops to compare b/w 2 to 4....");
                        int cas;
                        while (true) {
                            cas = s.nextInt();
                            if (cas >= 2 && cas < 5) {
                                break;
                            }
                        }
                        switch (cas) {
                            case 2:
                                int cho[] = new int[2];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho[1] = s.nextInt();
                                    if ((cho[0] >= 1 && cho[0] <= 6) && (cho[1] >= 1 && cho[1] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Hp.get(cho[0]));
                                System.out.println(Hp.get(cho[1]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                System.out.println(cho[0] + " " + cho[1]);
                                int confirm = 0;
                                while (true) {
                                    confirm = s.nextInt();
                                    if (confirm == cho[0] || confirm == cho[1]) {
                                        System.out.println(cyan_bold + "Selected Laptop exist...." + reset);
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Hp.get(confirm));
                                System.out.println("Added succesfully to cart....");
                                break;
                            case 3:
                                int cho1[] = new int[3];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho1[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho1[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho1[2] = s.nextInt();
                                    if ((cho1[0] >= 1 && cho1[0] <= 6) && (cho1[1] >= 1 && cho1[1] <= 6)
                                            && (cho1[2] >= 1 && cho1[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Hp.get(cho1[0]));
                                System.out.println(Hp.get(cho1[1]));
                                System.out.println(Hp.get(cho1[2]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm1;
                                while (true) {
                                    confirm1 = s.nextInt();
                                    if (confirm1 == cho1[0] || confirm1 == cho1[1] || confirm1 == cho1[2]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Hp.get(confirm1));
                                break;
                            case 4:
                                int cho2[] = new int[4];
                                while (true) {
                                    System.out.println("Enter Product key 1: ");
                                    cho2[0] = s.nextInt();
                                    System.out.println("Enter Product key 2: ");
                                    cho2[1] = s.nextInt();
                                    System.out.println("Enter Product key 3: ");
                                    cho2[2] = s.nextInt();
                                    System.out.println("Enter Product key 4: ");
                                    cho2[3] = s.nextInt();
                                    if ((cho2[0] >= 1 && cho2[0] <= 6) && (cho2[1] >= 1 && cho2[1] <= 6)
                                            && (cho2[2] >= 1 && cho2[2] <= 6) && (cho2[3] >= 1 && cho2[2] <= 6)) {
                                        break;
                                    } else {
                                        System.out.println(red + "Enter values b/w 1 to 6 only...." + reset);
                                    }
                                }
                                System.out.println(Hp.get(cho2[0]));
                                System.out.println(Hp.get(cho2[1]));
                                System.out.println(Hp.get(cho2[2]));
                                System.out.println(Hp.get(cho2[3]));
                                System.out.println(cyan + "Select from above Laptops....." + reset);
                                int confirm2;
                                while (true) {
                                    confirm2 = s.nextInt();
                                    if (confirm2 == cho2[0] || confirm2 == cho2[1] || confirm2 == cho2[2]
                                            || confirm2 == cho2[3]) {
                                        break;
                                    } else {
                                        System.out.println(
                                                red_bold+"Selected Laptop for finalization does not exist in your choice!!!!"+reset);
                                        System.out.println("Enter valid choice.....");
                                    }
                                }
                                Finalize.add(Hp.get(confirm2));
                                System.out.println("Added succesfully to cart....");
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Enter product key to finalize Laptop: ");
                        int final1 = s.nextInt();
                        Finalize.add(Hp.get(final1));
                        System.out.println("Added succesfully to cart....");
                    }
                    System.out.println("Do you want to Add more laptops?" + cyan_bold + " Y " + reset + "/ " + red_bold
                            + "N" + reset);
                    s.nextLine();
                    String c4 = s.nextLine();
                    if (c4.equalsIgnoreCase("N")) {
                        flag = 0;
                    }
                    break;
                default:
                    System.out.println("Enter a valid choice.....");
            }
        }
        if(checkStock(con)){
            intoFile(name, con);
        }
    }

    public void search_budget(String name, Connection con) throws ClassCastException, SQLException, IOException {
        int budget[] = new int[2];
        Hashtable<Integer, Lap_data> budget_search = new Hashtable<>(); // final HashTale which gives Object of Lap_data
                                                                        // in budget
        while (true) {
            while (true) {
                try {
                    System.out.println("Enter lower bound for Budget: ");
                    budget[0] = s.nextInt();
                    System.out.println("Enter upper bound for Budget: ");
                    budget[1] = s.nextInt();
                    if ((budget[0] >= 30000 && budget[0] <= 130000) && (budget[1] >= 30000 && budget[1] <= 130000)) {
                        System.out.println("Entered inputs meet the condition.....");
                        break;
                    } else {
                        System.out.println("Enter b/w range only.... i.e 30000 to 130000");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Enter valid Input....");
                    s.nextLine();
                }
            }
            int var = 0;
            for (int i = 1; i <= Asus.size(); i++) {
                if (Asus.get(i).price <= budget[1] && Asus.get(i).price >= budget[0]) {
                    var++;
                    budget_search.put(var, Asus.get(i));
                }
            }
            for (int i = 1; i <= Lenovo.size(); i++) {
                if (Lenovo.get(i).price <= budget[1] && Lenovo.get(i).price >= budget[0]) {
                    var++;
                    budget_search.put(var, Lenovo.get(i));
                }
            }
            for (int i = 1; i <= Dell.size(); i++) {
                if (Dell.get(i).price <= budget[1] && Dell.get(i).price >= budget[0]) {
                    var++;
                    budget_search.put(var, Dell.get(i));
                }
            }
            for (int i = 1; i <= Msi.size(); i++) {
                if (Msi.get(i).price <= budget[1] && Msi.get(i).price >= budget[0]) {
                    var++;
                    budget_search.put(var, Msi.get(i));
                }
            }
            for (int i = 1; i <= Hp.size(); i++) {
                if (Hp.get(i).price <= budget[1] && Hp.get(i).price >= budget[0]) {
                    var++;
                    budget_search.put(var, Hp.get(i));
                }
            }
            if (budget_search.size() >= 1) {
                for (int i = 1; i <= budget_search.size(); i++) {
                    System.out.println(budget_search.get(i));
                }
                String b_name[] = new String[budget_search.size()];
                int p_key[] = new int[budget_search.size()];
                for (int i = 1; i <= budget_search.size(); i++) {
                    b_name[i - 1] = budget_search.get(i).brand_name;
                    p_key[i - 1] = budget_search.get(i).product_no;
                }
                System.out.println("Select Laptop from above.....");
                String sel_bname; // selection of brand name
                int sel_pkey; // selection of product key
                while (true) {
                    int checker[] = { 1, 1 };
                    System.out.println("Enter brand name: ");
                    s.nextLine();
                    sel_bname = s.nextLine();
                    for (int i = 0; i < budget_search.size(); i++) {
                        if (sel_bname.equalsIgnoreCase(b_name[i])) {
                            checker[0] = 0;
                            System.out.println("Valid Brand Name......");
                            break;
                        }
                    }
                    System.out.println("Enter Product Key: ");
                    sel_pkey = s.nextInt();
                    for (int i = 0; i < p_key.length; i++) {
                        if (sel_pkey == p_key[i]) {
                            checker[1] = 0;
                            System.out.println("Valid Product Key......");
                            break;
                        }
                    }

                    if (checker[0] == 0 && checker[1] == 0) {
                        for (int i = 1; i <= budget_search.size(); i++) {
                            if (budget_search.get(i).brand_name.equalsIgnoreCase(sel_bname)
                                    && budget_search.get(i).product_no == sel_pkey) {
                                Finalize.add(budget_search.remove(i));
                                break;
                            }
                        }
                        break;
                    } else {
                        System.out.println("Enter values from Displayed Laptops only.....");
                    }
                }
                System.out.println(Finalize);
                break;
            } else {
                System.out.println(red + "Sorry no laptops available for this price range currently....." + reset);
            }
        }
        if (checkStock(con)) {
            intoFile(name, con);
        } else {
            System.out.println(cyan + "1. Search By Brand" + reset);
            System.out.println(cyan + "2. Search By Budget" + reset);
            System.out.println(red + "3. Exit" + reset);
        }
    }

    public void intoFile(String name, Connection con) throws SQLException, ClassCastException, IOException {
        System.out.println(white_bg + black + "Your final cart For Username: " + red + name + " is: " + reset);
        al = new ArrayList<>(Finalize);
        System.out.println(al.size());
        System.out.println(al);
        double price[] = new double[al.size()];
        double amount = 0;
        for (int i = 0; i < al.size(); i++) {
            price[i] = new Lap_data().bill(al.get(i));
            System.out.println("PRICE OF " + (i + 1) + " IS " + price[i]);
            amount += price[i];
        }
        System.out.println(cyan + "TOTAL BILL AMOUNT:: " + red + amount + reset);
        users = new HashSet<>();
        String fetch = "select Username from User_orders";
        PreparedStatement pstt = con.prepareStatement(fetch);
        ResultSet rss = pstt.executeQuery();
        while (rss.next()) {
            users.add(rss.getString("Username"));
        }
        System.out.println(name);
        if (users.add(name)) {
            System.out.println(cyan + "Shopping for first time...." + reset);
            FileWriter fw = new FileWriter(
                    new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt"));
            BufferedWriter bw1 = new BufferedWriter(fw);
            bw1.write("                        Cart for User " + name);
            bw1.close();
            for (int i = 0; i < al.size(); i++) {
                FileWriter fw1 = new FileWriter(
                        new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt"), true);
                FileReader fr = new FileReader(new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\Laptop_files\\"
                        + al.get(i).brand_name + "_" + al.get(i).product_no + ".txt"));
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(fw1);
                String line;
                while ((line = br.readLine()) != null) {
                    bw.newLine();
                    bw.write(line);
                }
                bw.close();
            }
            FileWriter fw1 = new FileWriter(
                    new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt"), true);
            BufferedWriter bw2 = new BufferedWriter(fw1);
            bw2.newLine();
            bw2.write("                          Final Amount = " + amount);
            bw2.newLine();
            bw2.close();
            String query = "insert into User_orders(Username,Mobile_no,Order_history,Amount) values(?,?,?,?)";
            String callable = "{call get_saved_pin(?,?,?,?)}";
            CallableStatement cst = con.prepareCall(callable);
            cst.setString(1, name);
            cst.execute();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, cst.getString(2));
            File f = new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt");
            FileReader fr = new FileReader(f);
            pst.setCharacterStream(3, fr, f.length());
            pst.setDouble(4, amount);
            pst.executeLargeUpdate();
        } else {
            System.out.println(cyan + "Shopping For another time...." + reset);
            FileWriter fw = new FileWriter(
                    new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt"), true);
            BufferedWriter bw1 = new BufferedWriter(fw);
            bw1.write("                        Cart for User " + name);
            bw1.close();
            for (int i = 0; i < al.size(); i++) {
                FileWriter fw1 = new FileWriter(
                        new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt"), true);
                FileReader fr = new FileReader(new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\Laptop_files\\"
                        + al.get(i).brand_name + "_" + al.get(i).product_no + ".txt"));
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(fw1);
                String line;
                while ((line = br.readLine()) != null) {
                    bw.newLine();
                    bw.write(line);
                }
                bw.close();
            }
            FileWriter fw1 = new FileWriter(
                    new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt"), true);
            BufferedWriter bw2 = new BufferedWriter(fw1);
            bw2.newLine();
            bw2.write("                          Final Amount = " + amount);
            bw2.newLine();
            bw2.close();
            String query = "update User_orders set Order_history = ?, Amount = Amount+?";
            PreparedStatement pst = con.prepareStatement(query);
            File f = new File("D:\\Projects Sem-2\\Laptop_buying_Sem2\\src\\User_Files\\" + name + ".txt");
            FileReader fr = new FileReader(f);
            pst.setCharacterStream(1, fr, f.length());
            pst.setDouble(2, amount);
            pst.executeUpdate();
            System.out.println(al.get(0).bill(al.get(0)));
        }
    }

    public boolean checkStock(Connection con) throws SQLException {
        al = new ArrayList<>(Finalize);
        boolean flag = true;
        for (int i = 0; i < al.size(); i++) {
            int quant;
            String brand_name = al.get(i).brand_name;
            String lap_idd = brand_name + "_" + al.get(i).product_no;
            String query = "select * from " + brand_name + " where Lap_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, lap_idd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                quant = rs.getInt("Quantity");
                if (quant > 0) {
                    System.out.println("                                " + red + "Stock available = " + quant + reset);
                    String upd = "update " + brand_name + " set Quantity=Quantity-1 where Lap_id=?";
                    PreparedStatement pst1 = con.prepareStatement(upd);
                    pst1.setString(1, lap_idd);
                    System.out.println(
                            "                                    " + red_bold + "Stock left = " + (quant - 1) + reset);
                    pst1.execute();
                    flag = true;
                } else {
                    System.out.println(
                            "                                    " + white_bg + red_bold + "Out of stock..." + reset);
                    flag = false;
                }
            }
        }
        return flag;
    }
}