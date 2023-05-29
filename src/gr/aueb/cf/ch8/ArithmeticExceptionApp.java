package gr.aueb.cf.ch8;

import java.util.Scanner;

public class ArithmeticExceptionApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        int numerator;
        int denominator;

        try {
            System.out.println("Please insert two ints :");
            numerator = in.nextInt();
            denominator = in.nextInt();


            result = numerator / denominator;

            System.out.printf("%d / %d = %d", numerator, denominator, result);

        } catch (ArithmeticException e) {
            //e.printStackTrace(); h na dosoume ena sout
            System.out.println("Λάθος παρονομαστής");
        }
    }
}
