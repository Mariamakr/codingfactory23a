package gr.aueb.cf.ch8;

import java.util.Scanner;
/*Άσκηση κεφαλαίου:
* Εκτυπώνει ένα μενού -
* εμφανίζει κατάλληλο μήνυμα μετά την επιλογή από τον χρήστη -
* πιάνει 2 exceptions
* πρώτο - αν δε δοθεί ακέραιος
* δεύτερο - αν δοθεί ακέραιος έξω από το εύρος του μενού
* */

public class MenuApp {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        printMenu();
        choice = getChoice("Παρακαλώ επιλέξτε ένα από τα παραπάνω: ");
        printChoice(choice);
        // έλεγχος του IllegalArgumentException
                try {
                  boolean isChoiceInvalid =  isChoiceInvalid(choice); {
                    }
                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();

                    System.out.println("Μη έγκυρη επιλογή!");
//                    throw e;
                }


    }

    // Η εκτύπωση του μενού
    public static void printMenu() {
        System.out.println("Διαβάστε το μενού:");
        System.out.println("1. Εισαγωγή");
        System.out.println("2. Ενημέρωση");
        System.out.println("3. Διαγραφή");
        System.out.println("4. Αναζήτηση");
        System.out.println("5. Έξοδος");
    }

    // Ο έλεγχος για μη ακέραιο
    public static int getChoice(String message) {
        System.out.println(message);
        do {
            if (in.hasNextInt()) {
                System.out.println();

            } else {
                System.out.println("Παρακαλώ πληκτρολογήστε έναν αριθμό από το 1 ως το 5");
                in.nextLine();

                continue;
            }
            return in.nextInt();
        } while (true);

    }

    //Η εμφάνιση του μηνύματος κατά την επιλογή από τον χρήστη
    public static void printChoice(int choice)  {
        do {
            if (choice < 1 || choice > 5) {
                System.out.println("Μη έγκυρη επιλογή!");
                break;
            }

            if (choice == 5) {
                System.out.println("Επιλέξατε Έξοδο");
                break;
            }

            if (choice == 1) {
                System.out.println("Επιλέξατε Εισαγωγή");
                break;
            } else if (choice == 2) {
                System.out.println("Επιλέξατε Ενημέρωση");
                break;
            } else if (choice == 3) {
                System.out.println("Επιλέξατε Διαγραφή");
                break;
            } else {
                System.out.println("Επιλέξατε Αναζήτηση");
                break;
            }

        }while (true) ;
    }

    //χρησιμοποιείται για να εκφραστεί η περίπτωση του ακεραίου εκτός του εύρους 1-5
    public static boolean isChoiceInvalid(int choice) throws IllegalArgumentException{
        return choice < 1 || choice > 5;
    }
}
