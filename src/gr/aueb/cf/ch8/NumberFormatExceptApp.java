package gr.aueb.cf.ch8;

import java.util.Scanner;

public class NumberFormatExceptApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = "";
        int inputNum = 0;

        System.out.println("please insert an int:");
        inputStr = in.nextLine();
        inputNum = Integer.parseInt(inputStr);
        System.out.println("input num:" + inputNum);
    }
}
