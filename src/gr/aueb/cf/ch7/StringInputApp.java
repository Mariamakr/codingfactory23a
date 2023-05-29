package gr.aueb.cf.ch7;

import java.util.Scanner;

public class StringInputApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "Coding Factory";

//        String substring = s.substring(0, 6);

        System.out.println("Please provide a string");
        s = in.next(); // ends with whitespace (space, \t, \n)
//        s = in.nextLine();

        System.out.println(s);
    }
}
