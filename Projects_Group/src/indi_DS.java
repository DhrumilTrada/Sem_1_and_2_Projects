import java.io.*;
import java.util.*;

public class indi_DS {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // ArrayList<String> al = new ArrayList<>();
        File f = new File("D:\\Projects Sem-2\\Projects_Group\\src\\Demo.txt");
        File dictionary = new File("D:\\Projects Sem-2\\words_alpha.txt");
        FileReader fr = new FileReader(f);
        FileReader fr1 = new FileReader(dictionary);
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br = new BufferedReader(fr);
        DLL dl = new DLL();
        DLL dl1 = new DLL();
        Set<String> Dict = new HashSet<>();
        String line, line1;
        String words[];
        while ((line = br.readLine()) != null) {
            words = line.trim().split(" ");
            for (String ss : words) {
                dl.add(ss);
                dl1.add(ss);
            }
        }
        while ((line1 = br1.readLine()) != null) {
            line1 = line1.trim();
            Dict.add(line1); // adding dictionary words to ll Dict
        }
        dl.display();
        // dl1.add_sym(); removes . and , from ending
        // System.out.println("Enter word to display: ");
        // String word = s.nextLine();
        // dl.search(word); search for word
        // dl1.containn(Dict); check for mispelled word
        br.close();
        br1.close();
    }
}

class DLL {
    class Node {
        String data;
        Node next = null;
        Node prev = null;

        Node(String data) {
            this.data = data;
        }
    }

    Node head = null;

    void containn(Set<String> Dict) { // for checking if word is present in dictionary or not
        Node temp = head;
        while (temp != null) {
            if (!(Dict.contains(temp.data))) {
                String ANSI_RED = "\u001B[31m";
                String ANSI_RESET = "\u001B[0m";
                temp.data = ANSI_RED + temp.data + ANSI_RESET;
            }
            temp = temp.next;
        }
        display();
    }

    void add(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    void add_sym() {
        Node temp = head;
        while (temp != null) {
            for (int i = 0; i < temp.data.length(); i++) {
                if (temp.data.charAt(i) == '.' || temp.data.charAt(i) == ',') {
                    String ch = "";
                    if ((temp.data != null) && (temp.data.length() > 0)) {
                        ch = temp.data.substring(0, temp.data.length() - 1);
                    }
                    temp.data = ch;
                }
            }
            temp = temp.next;
        }
    }

    void delete() {
        if (head == null) {
            System.out.println("Empty");
        } else if (head == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void search(String data1) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data1)) {
                temp.data = ANSI_RED + data1 + ANSI_RESET;
            }
            temp = temp.next;
        }
        display();
    }

    void find_and_replace(String target, String replacement) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(target)) {
                temp.data = replacement;
            }
            temp = temp.next;
        }
        display();
    }

    void display() {
        if (head == null) {
            System.out.println("Empty File");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}