package gr.aueb.cf.ch8;

import java.io.IOException;

/**
 * Demonstrates the usage of exceptions
 */
public class ExceptApp {
    public static void main(String[] args) {
        int ch;
        int[] arr = new int[10]; // Έστω ότι έχουμε έναν πίνακα με 10 στοιχεία

        try {
            ch = getNextChar();
            System.out.println(ch);
        } catch (IOException e) {
            System.out.println("Error in IO");
        }

        for (int i = 0; i <=arr.length; i++){
            System.out.println(arr[i] + " ");
            //Έστω για τον πίνακα μου κάνω το λάθος και βάζω στο length και =
            // και δημιουργεί IndexOutOfBounds
        }
//        try {
//            int ch = System.in.read();
//
//        } catch (IOException ex) {
//            e.printStackTrace();
//        }
    }

    /**
     * το μόνο που αλλάζει σε αθτήν την περίπτωση ειναί ότι δηλώνουμε
     * int ch και μετά στο try κάνουμε κατευθείαν το System.in.read
     * @return  printStackTrace
     */
    public static int getNextChar() throws IOException{
        int ch = ' ';
        try {
            ch = System.in.read();
            //1. Rollback
            //2. Logging

        } catch (IOException e) {
            e.printStackTrace();
            //3. Rethrow
            throw e;
        }
        return ch;
    }
}


