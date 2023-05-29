package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AutoFlushApp {

    public static void main(String[] args) {
        try(PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\Dell\\whatever\\fos.txt", true), true)) {
            //αν δεν θέλω να μου δημιουργεί νεο φάκελο κάθε φορά που το τρέχω στο τέλος του fileoutputstream κανω append δηλαδή να γράφει στο ίδιο αρχείο στο τέλος του
            ps.println("Hellooooo!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
