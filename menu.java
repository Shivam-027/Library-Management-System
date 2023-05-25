import java.util.*;
import java.io.*;

public class menu {

    Node head = null;
    Node tail = null;
    int size = 0;

    //
    void viewLib() {
        Node t;
        int count = 1;
        if (head == null) {
            System.out.println("book is empty");
        } else {
            System.out.println("\nBOOK: ");
            System.out.print("S.No.\tBook Name\tID\tAuthor\t\tName\tRoll Number");
            System.out.println();
            t = head;
            while (t != null) {
                System.out.print(count + "\t" + t.book_name + "\t\t" + t.id + "\t\t" + t.author + "\t"+ t.student_name + "\t" + t.roll_num);
                System.out.println();
                count++;
                t = t.next;
            }
        }
    }

    // for adding new books or to add existing books in the linked list
    void insert(String book_name, String id, String author, String student_name, String roll_num) {
        int count = 1;
        if (head == null) {
            insertAtPos(book_name, id, author, student_name, roll_num, count);
        } else {      
            insertAtPos(book_name, id, author, student_name, roll_num, size + 1);
        }

    }

    void in(){
        Scanner obj = new Scanner(System.in);
        System.out.println("\nEnter Book_name: ");
        String b = obj.next();
        System.out.println("\nEnter ID: ");
        String i = obj.next();
        System.out.println("\nEnter Author: ");
        String a = obj.next();
        insert(b, i, a, "-", "-");
    }

    // for sorting - optional
    void insertAtPos(String book_name, String id, String author, String student_name, String roll_num, int pos) {
        Node n = new Node(book_name, id, author, student_name, roll_num);
        Node t;
        Node temp;
        t = head;
        if (pos == 1) {
            if (head == null) {
                tail = n;
                head = n;
            } else {
                t.prev = n;
            }
            n.next = t;
            head = n;
            size++;
        } else if (pos == size + 1) {
            if (head == null) {
                head = n;
            } else {
                tail.next = n;
            }
            n.prev = tail;
            tail = n;
            size++;
        } else {
            for (int i = 1; i < pos - 1; i++) {
                t = t.next;
            }
            temp = t.next;
            n.next = t.next;
            t.next = n;
            n.prev = t;
            temp.prev = n;
            size++;
        }
    }

    //
    void issue_book() {
        Scanner sc = new Scanner(System.in);
        Node t;
        t = head;
        int flag = 0;
        if (head == null) {
            System.out.println("no books in the library");
        } else {
            while (t != null) {
                String ch = t.roll_num;
                if (ch.equals("-")) {
                    flag++;
                    if (flag == 1) {
                        System.out.println("S.No.\tBook Name\t\tID\t\tAuthor");
                    }
                    System.out.print(flag + "\t" + t.book_name + "\t\t" + t.id + "\t\t" + t.author);
                    System.out.println();
                }
                t = t.next;
            }

            System.out.println("enter your name :");
            String name = sc.next();
            System.out.println("enter your roll number :");
            String roll = sc.next();
            System.out.println("enter book id:");
            String d = sc.next();
            Node i = head;
            while (i != null) {
                String ch1 = i.id;
                if (ch1.equals(d)) {
                    i.roll_num = roll;
                    i.student_name = name;
                    return;
                }
                i = i.next;
            }
        }
    }

    //
    void return_book() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your name :");
        String name = sc.next();
        System.out.println("enter your roll number :");
        String roll = sc.next();

        Node t;
        t = head;

        int flag = 0;
        if (head == null) {
            System.out.println("no books in the library");
        } else {
            while (t != null) {
                String ch = t.roll_num;
                if (ch.equals(roll)) {
                    flag++;
                    if (flag == 1) {
                        System.out.println("S.No.\tBook Name\tID\tAuthor\t\tName\tRoll Number");
                    }
                    System.out.print(flag + "\t" + t.book_name + "\t\t" + t.id + "\t\t" + t.author + "\t"+ t.student_name + "\t" + t.roll_num);
                    System.out.println();
                }
                t = t.next;
            }
            Node i = head;
            if (flag > 1){
                System.out.println("Enter the ID of book: ");
                String temp = sc.next();
                while (i != null) {
                    String ch = i.id;
                    if (ch.equals(temp)) {
                        i.roll_num = "-";
                        i.student_name = "-";
                        return;
                    }
                    i = i.next;
                }
            }
            if (flag == 0) {
                System.out.println("Not Issued");
            }
        }
    }

    //
    void exit() {
        Node t = head;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("lib.txt"));
            while (t != null) {
                String merge = t.book_name + " " + t.id + " " + t.author + " " + t.student_name + " " + t.roll_num;
                out.write(merge + "\n");
                t = t.next;
            }
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
        System.out.println("File Updated");
    }
}
