package gr.aueb.cf.ch10;
/*
* Αναπτύξτε ένα πρόγραμμα σε Java που να διαβάζει από ένα αρχείο ακέραιους
αριθμούς μέχρι να βρει την τιμή -1 (το αρχείο πρέπει να περιέχει περισσότερους από
6 αριθμούς και το πολύ 49 αριθμούς) με τιμές από 1 έως 49. Τους αριθμούς αυτούς
τους εισάγει σε ένα πίνακα, τον οποίο ταξινομεί (π.χ. με την Arrays.sort()). Στη
συνέχεια, το πρόγραμμα παράγει όλες τις δυνατές εξάδες (συνδυασμούς 6 αριθμών).
Ταυτόχρονα και αμέσως μετά την παραγωγή κάθε εξάδας ‘φιλτράρει’ κάθε εξάδα
ώστε να πληροί τα παρακάτω κριτήρια: 1) Να περιέχει το πολύ 4 άρτιους, 2) να
περιέχει το πολύ 4 περιττούς, 3) να περιέχει το πολύ 2 συνεχόμενους, 4) να περιέχει
το πολύ 3 ίδιους λήγοντες, 5) να περιέχει το πολύ 3 αριθμούς στην ίδια δεκάδα.
Τέλος, εκτυπώνει τις τελικές εξάδες σε ένα αρχείο με όνομα της επιλογής σας και
κατάληξη.txt.*/

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/*
*Hint. Ακολουθήστε τη διαδικασία που είχαμε δει για την παραγωγή 4άδων. Κάθε
παραγόμενη εξάδα μπορεί να αποθηκεύεται σε ένα πίνακα ο οποίος στη συνέχεια να
ελέγχεται από κάθε μία από τις αναφερόμενες μεθόδους (φίλτρα). Αν για
παράδειγμα μία εξάδα έχει αποθηκευτεί στον πίνακα arr, τότε για να ‘περάσει’ τα
φίλτρα που είναι ταυτόχρονα περιορισμοί, θα πρέπει να ελεγχθεί. Π.χ.
if (!isEven(arr)) && (!isOfdd(arr)) && (!isContiguous(arr)) && (!isSameEnding(arr)) &&
(!isSameTen), γράψε την εξάδα στο αρχείο εξόδου.

* */
public class MiniProject01 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("C:\\Users\\Dell\\whatever\\lotto5in.txt"));
             PrintStream ps = new PrintStream("C:\\Users\\Dell\\whatever\\lotto5out.txt", StandardCharsets.UTF_8)) {

            final int LOTTO_SIZE = 6;
            int[] inputNumbers = new int[49];
            int pivot = 0; //επειδής μπορεί να μην είναι και οι 49 γεμάτες θα δείχνει στην τελευταία θέση των πραγματικών στοιχείων που έχει μέσα (στην πρώτη ελεύθερη)
            int[] result = new int[6];
            int num;
            int window; // οι θέσεις που μετακινούνται

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                inputNumbers[pivot++] = num;
                //pivot++;
            }
            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - LOTTO_SIZE;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window +5; n++){
                                    result[0] = numbers[i];
                                    result[1] = numbers[j];
                                    result[2] = numbers[k];
                                    result[3] = numbers[l];
                                    result[4] = numbers[m];
                                    result[5] = numbers[n];

                                    if (!isEvenGE(result, 4) && !isOddGE(result, 4) && !isContiguous(result, 2) && !isSameEnding(result, 3)) {
    // εδώ δεν είχα το if πριν γράψω τη λούπα και δεν είχα ps.print αλλά souf.
                                            System.out.printf("%d, %d, %d, %d,%d\n",
                                                    result[0], result[1], result[2], result[3], result[4], result[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEvenGE(int[] arr, int threshold) {
        int even = 0;
        for (int num : arr) {
            if (num % 2 == 0)
                even++;
        }

        return even > threshold;
    }

    public static boolean isOddGE(int[] arr, int threshold) {
        int odd = 0;
        for (int num : arr) {
            if (num % 2 != 0)
                odd++;
        }

        return odd > threshold;
    }


    public static boolean isContiguous(int[] arr, int threshold){
    //need to find position
        int contiguous = 0;
        for (int numPosition = 0; numPosition < arr.length -1; numPosition++){

            for (int num : arr) {
                if (arr[numPosition] == num && arr[numPosition + 1] == num)
                    contiguous++;

            }
        }

        return contiguous > threshold;
    }

    public static boolean isSameEnding(int[] arr, int threshold){
        boolean sameNumber = false;
        int same = 0;
        for (int num :arr) {
            if ((arr[num] - 10 == num )) {
                same++;
            }
        }
        return same > threshold;

    }

//    public static boolean isSameTen(int[] arr, int threshold) {
//        int plusTen = 0;
//        for (int num : arr) {
//            if (num += 10)
//                plusTen++;
//        }
//        return plusTen > threshold;
//    }
}
