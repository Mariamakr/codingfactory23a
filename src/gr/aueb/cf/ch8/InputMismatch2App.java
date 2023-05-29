package gr.aueb.cf.ch8;

import java.util.Scanner;

public class InputMismatch2App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputNum;
        final int MAGIC_NUM = 12;

        while(true) {
            if (in.hasNextInt()){
                System.out.println("Please insert a num");

                inputNum = in.nextInt();
            } else{
                in.nextLine();
                System.out.println("Error. Please insert a valid int");
                continue;
            }
            if (inputNum == MAGIC_NUM) {
                System.out.println("Great!");
                break;
            }
        }
        System.out.println("thamks for using the app");
    }
}
