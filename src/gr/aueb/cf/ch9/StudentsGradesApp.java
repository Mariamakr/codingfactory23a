package gr.aueb.cf.ch9;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Scanner;

/*
* Αναπτύξτε ένα πρόγραμμα που να διαβάζει
* το όνομα, το επίθετο, τους βαθμούς
* των μαθητών, να βρίσκει το μέσο όρο.
* Να εκτυπώνει στο αρχείο primOut.txt
* το όνομα, το επίθετο και τον μέσο όρο
* καθώς και σε ένα αρχείο log.txt λάθη
* που αφορούν βαθμούς μικρότερους του 0
* ή μεγαλύτερους του 10.*/

/*
* Γεια σας,
* Ο τρόπος που έχω λύσει την άσκηση δεν είναι πολύ πρακτικός...
* Θα προσπαθήσω να το λύσω καλύτερα και με δισδιάστατο πίνακα
* όμως και αυτός ο τρόπος λειτούργησε.
* Απλά δεν είναι πολύ δομημένος και ίσως να υπάρχουν μέσα κομμάτια που είναι περιττά
* αυτό είναι απλά επειδή δεν έχω καταλάβει πλήρως πιο είδος αρχείου input-output πρέπει να βάλω στην κάθε περίπτωση   */
public class StudentsGradesApp {

    static int pivot = -1;
    final static Scanner in = new Scanner(System.in);
    final static Path path = Paths.get("C:/Users/Dell/log.txt");

    public static void main(String[] args) {
        String[] s = new String[2];
        double[] grades = new double[2];
        double sum = 0.00;
        double avg = 0.00;
        int start = 0;
        int end = 10;
        printList();
        String line;
        BufferedReader bf;
        PrintWriter pw;
        FileWriter wr;
//        boolean isGradeInvalid = false;


        try {
            bf = new BufferedReader(new FileReader("C:\\Users\\Dell\\grades.txt"));
            pw = new PrintWriter("C:\\Users\\Dell\\primOut.txt");
            pw = new PrintWriter("C:\\Users\\Dell\\log.txt");
            int nufOfStudents = 0;
            while ((line = bf.readLine()) != null) {
                nufOfStudents++;

            }


            String[] students = new String[nufOfStudents];
            bf = new BufferedReader(new FileReader("C:\\Users\\Dell\\grades.txt"));
            int i = 0;
            while ((line = bf.readLine()) != null) {
                students[i] = line;
                i++;
            }


            //writing each row from the string array to the output file
            wr = new FileWriter("C:\\Users\\Dell\\primOut.txt", true);

            for (String row : students) {
                System.out.println("Please insert the grades of the student:" + row);

                grades[0] = in.nextInt();
                grades[1] = in.nextInt();
//

                sum = grades[1] + grades[0];
                avg = sum / 2;
//            ps.println("String s");
//                        pw.printf("Ο μέσος όρος είναι : %.2f", avg);
                wr.write(row + " " + "The average grade is " + avg + "\n");
            }


            BufferedWriter wf = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\log.txt"));


            //we check here if the grade is valid
            while ((line = bf.readLine()) != null) {

                int n = 0;
//                String[] tokens = new String[n];
                //writing the wrong grades into log.txt


                wr = new FileWriter(("C:\\Users\\Dell\\log.txt"));

                String[] tokens = line.split("\\d+");
                for (String token : tokens) {
                    PrintStream ps = new PrintStream("C:\\Users\\Dell\\log.txt");
                    if (token.matches("\\d+")) {
                        // now checks if the token is number
                        if (isInt(token)) {
                            if (n < start || n > end) {
                                wr = new FileWriter(("C:\\Users\\Dell\\log.txt"));
                                wr.write(token + "" + " is not a valid grade");
                            }
                        }
                    }
                }
            }
            System.out.println("Text successfully copied and average grade have been updated!");
            System.out.println("Invalid grades excluded");

            bf.close();
            wr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isInt(String tokens) {
        try {
            Integer.parseInt(tokens);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void printList() {
        System.out.println("1. Γιώργος Γεωργιάδης, 7, 9");
        System.out.println("2. Αναστασία Αναστασιάδη, 9, 10");
        System.out.println("3. Μάρκος Μαρκόπουλος, 5, 11");
        System.out.println("4. Βίκυ Βικοπούλου, 6, 8");

    }


    public static void log(Exception e, String... message) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(path.toFile(), true))) {
            ps.println(LocalDateTime.now() + "\n" + e.toString());
            ps.printf("%s", (message.length == 1) ? message[0] : "");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}