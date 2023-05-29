package gr.aueb.cf.ch10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* Αναπτύξτε μία εφαρμογή που διαβάζει έναν-έναν τους χαρακτήρες ενός αρχείου και
τους εισάγει σε ένα πίνακα 256x2. Κάθε θέση του πίνακα είναι επομένως ένας
πίνακας δύο θέσεων, όπου στην 1η θέση αποθηκεύεται ο χαρακτήρας που έχει
διαβαστεί (αν δεν υπάρχει ήδη στον πίνακα) και στην 2η θέση αποθηκεύεται το
πλήθος των φορών που έχει διαβαστεί (βρεθεί) κάθε χαρακτήρας. Χαρακτήρες
θεωρούνται και τα κενά και οι αλλαγές γραμμής και γενικά οποιοσδήποτε UTF-8
χαρακτήρας.
Στο τέλος η main() παρουσιάζει στατιστικά στοιχεία για κάθε χαρακτήρα όπως η
συχνότητα εμφάνισής του στο κείμενο ταξινομημένα ανά χαρακτήρα και ανά
συχνότητα εμφάνισης.
* */
public class MiniProject03 {
    static int pivot = -1;
    final static int[][] text = new int [256][2];
    static int count = 0;
    final static Scanner in = new Scanner(System.in);
    final static Path path = Paths.get("C:/Users/Dell/whatever/log-chars.txt");

    public static void main(String[] args) {
        try{
            readTextAndService();
            printStatisticsService();

        } catch (IOException e) {
            System.out.println("Error in IO");
        }

    }

//    It uses a 1024 bytes long buffer because it doesn't have any way of knowing the length of the input stream.
//    However, there is a theoretical problem doing both; i.e. setting the buffer length to the file length and using a character buffer rather than a byte buffer. The problem is that the file size is measured in bytes, but the size of the buffer needs to be measured in characters. This is normally fine, but it is theoretically possible that you will need more characters than the file size in bytes; e.g. if the input file used a 6 bit character set and packed 4 characters into 3 bytes.

    public static void readTextAndService() throws IOException, IllegalArgumentException {
        int ch;
        byte[] buf = new byte[1024];
        int n = 0;

        try (FileInputStream fs = new FileInputStream("C:\\Users\\Dell\\whatever\\cities.txt");) {
            while ((n = fs.read(buf)) > 0){
                for (int i = 0; i < n; i++){
                    if (!saveChar(buf[i])) throw new IllegalArgumentException("Error in save");
                else {
                        count++;
                    }

                }
            }
        } catch (IOException | IllegalArgumentException e) {
            log(e);
            throw e;
        }
    }

    public static void printStatisticsService() {
        int[] [] copiedText = Arrays.copyOfRange(text, 0, pivot + 1 );

        Arrays.sort(copiedText, Comparator.comparing( text -> text[0]));
        System.out.println("Statistics (Char Ascending)");


        for (int [] arr : copiedText){
            System.out.printf("character: %c\t times used: %d\t percentage of use: %.4f%%\n", arr[0], arr[1] + 1, arr[1]/ (double) count);
        }

        Arrays.sort(copiedText, Comparator.comparing( text -> text[1]));
        System.out.println("Statistics (Percentage Ascending)");

        for(int [] arr : copiedText) {
            System.out.printf("character: %c\t times used: %d\t percentage of use: %.4f%%\n", arr[0], arr[1] + 1, arr[1]/ (double) count);
        }


    }
    public static boolean saveChar(int ch){
        int charPosition = -1;
        boolean inserted = false;

        if(isFull(text)){
            return false;
        }

        charPosition = getCharPosition(ch);

        if(charPosition == -1){
            pivot++;
            text[pivot][0] = ch;
//            text[pivot][1] += 1;
            inserted = true;
        } else {
            text[charPosition][1]++;
            inserted = true;
        }
        return inserted;
    }

    public static int getCharPosition(int ch) {

        for (int i = 0; i <= pivot; i++) {
            if (text[i][0] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isFull(int[][] text){
        return pivot == text.length -1;
    }

    public static void log(Exception e) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(path.toFile(), true))){
            ps.println(LocalDateTime.now() + "\n" + e);
        } catch (IOException ex){
            log(e);
            ex.printStackTrace();
        }

    }
}

