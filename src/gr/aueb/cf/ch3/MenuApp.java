package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Εμφανίζει επαναληπτικά ένα μενού
 * επιλογών μέχρι ο χρήστης να επιλέξει
 * έξοδο.
 */
public class MenuApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Επιλέξτε ένα από τα παρακάτω");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Exit");
            System.out.flush();
            choice  = in.nextInt();
        } while (choice !=3);
    }
}