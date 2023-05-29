package gr.aueb.cf.ch9;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class WriterApp {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream("C:\\Users\\Dell\\whatever\\f1.txt");
             PrintWriter pw = new PrintWriter("C:\\Users\\Dell\\whatever\\f2.txt")) {
             ps.println("Hello CF! from print stream");
             pw.println("Hello CF! from print writer");
             pw.flush(); //Όταν γεμίσει ο buffer στο τέλος του προγράμματος τα γράφει κατευθείαν...
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
    }
}
