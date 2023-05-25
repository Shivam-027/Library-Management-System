import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        menu ll = new menu();
        try {
            File fi = new File("lib.txt");
            Scanner content = new Scanner(fi);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                String[] parts = data.split(" ");
                ll.insert(parts[0], parts[1], parts[2], parts[3], parts[4]);
            }
            content.close();
        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
        System.out.println("Book Updated");
        System.out.println("\n");
        System.out.println("\t\t\t     ****************************************");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t     *      WELCOME TO STUDENT LIBRARY      *");
        System.out.println("\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     *                                      *");
        System.out.println("\t\t\t     ****************************************");
        System.out.println();
        System.out.println();
        int a = 10;
        while (a != 5) {
            int choice;
            System.out.println("\n\t\t\t*************************************************");
            System.out.print("\n\t\t\t\t     MAIN MENU: ");
            System.out.print("\n\t\t\t\t     1.ISSUE OF BOOKS ");
            System.out.print("\n\t\t\t\t     2.RETURN OF BOOKS ");
            System.out.print("\n\t\t\t\t     3.ADD BOOKS ");
            System.out.print("\n\t\t\t\t     4.DISPLAY STUDENT DETAILS ");
            System.out.print("\n\t\t\t\t     5.EXIT\n ");
            System.out.println("\n\t\t\t*************************************************");
            System.out.print("\n\t\t\t\t      Enter your choice: ");
            choice = obj.nextInt();
            switch (choice) {
                case 1:
                ll.issue_book();
                    break;
                case 2:
                    ll.return_book();
                    break;
                case 3:
                    ll.in();
                    break;
                case 4:
                    ll.viewLib();
                    break;
                case 5:
                    ll.exit();
                    a = 5;
                    break;
            }
        }
    }
}

