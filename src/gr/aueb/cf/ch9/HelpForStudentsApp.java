package gr.aueb.cf.ch9;

import java.util.Scanner;
public class HelpForStudentsApp {

    //Αυτό θα το χρησιμοποιήσω για να διαβάζει το όνομα του μαθητή και δίπλα καρδούλα θα βάζει τον μέσο όρο...
    public static void main(String[] args) {
        String s = "Μαρία Μακρυγιάννη";
        double[] grades = new double[2];
        double sum = 0.00;
        double avg = 0.00;

        Scanner numreader = new Scanner(System.in);



        try {
            System.out.println("Παρακαλώ πολύ εισάγεται τους βαθμούς του/της μαθητή/τριας: ");
            for (int i = 0; i < grades.length; i++)
                grades[i] = numreader.nextInt();
                grades[0] = Integer.parseInt(s);
                grades[1] = Integer.parseInt(s);
                for (int i = 0; i < grades.length; i++) {

                }

        } catch (NumberFormatException numfo) {

            System.out.println(numfo.getMessage() + "cannot be converted to integer");
        }
        System.out.print("Ο μέσος όρος του/της μαθητή/τριας ");
        for (int i = 0; i < s.length(); i++) {

            System.out.print(s.charAt(i));
        }
        sum = grades[1] + grades[0];
        avg = sum / 2;
        System.out.printf(" " + "είναι %.2f", avg);
    }
}


//        for(char ch: s.toCharArray()){
//            System.out.print(ch + " ");
//        }
//
//        System.out.println("\u2764");
//
//        int index = s.indexOf("o", 7);
//        int index2 = s.lastIndexOf("o");
//        System.out.println(index);
//        System.out.println(index);
//
//        if (s.startsWith("Coding")) System.out.println("Coding Factory");

