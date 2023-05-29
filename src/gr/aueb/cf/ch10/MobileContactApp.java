package gr.aueb.cf.ch10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class MobileContactApp {

    final static String [][] contacts = new String[500][3];
    static int pivot = -1;
    final static Scanner in = new Scanner(System.in);
    final static Path path = Paths.get("C:/Users/Dell/whatever/log.txt");

    public static void main(String[] args) {
        boolean quit = false;
        String s;
        int choice;
        String phoneNumber;

        do{
            printMenu();
            s= getChoice();
            if (s.matches("[qQ]")) {
                quit = true;
                System.out.println("Επιστρέψατε στο κυρίως μενού του κινητού");
            }else{
                try{
                    choice = Integer.parseInt(s);
                    if (!isValid(choice)) {
                        throw new IllegalArgumentException("Error - Choice must be between 1-5");
                    }

                    switch (choice){
                        case 1:
                            printContactMenu();
                            insertController(getFirstname(), getLastname(), getPhoneNumber());
                            System.out.println("Επιτυχής εισαγωγή");
                            break;
                        case 2:
                            phoneNumber = getPhoneNumber();
                            deleteController(phoneNumber);
                            System.out.println("Επιτυχής Διαγραφή");
                            break;
                        case 3:
                            phoneNumber = getPhoneNumber();
                            printContactMenu();
                            updateController(phoneNumber, getFirstname(), getLastname(), getPhoneNumber());
                            System.out.println("Επιτυχής ενημέρωση");
                            break;
                        case 4:
                            phoneNumber = getPhoneNumber();
                            String [] contact = getOneController(phoneNumber);
                            //printContact(contact); ---αν θέλουμε να το εκτυπώσουμε
                            break;
                        case 5:
                            String [][] allContacts = getAllContactsController();
                            //printContacts();
                            break;
                        default:
                            throw new IllegalArgumentException("Bad Choice");
                    }
                } catch (IllegalArgumentException e){

                }
            }
        }while  (!quit);
    }

    public static void printContact(String[] contact){
        for(String s:contact){
            System.out.println(s + " ");
        }
    }

    public static void printAllContacts(String[][] contacts){
        for(String[] contact : contacts){
//            System.out.println("%s\t%s\t%s\n", contact[0], contact[1], contact[2]);
                printContact(contact);
        }
    }
    public static boolean isValid(int choice){
        return (choice >= 1 && choice <=5);
    }
    public static void printMenu(){
        System.out.println("Επιλέξτε ένα από τα παρακάτω");
        System.out.println("1. Εισαγωγή Επαφής");
        System.out.println("2. Διαγραφή επαφής");
        System.out.println("3. Ενημέρωση Επαφής");
        System.out.println("4. Αναζήτηση Επαφής");
        System.out.println("Εκτύπωση όλων των επαφών");
        System.out.println("q. Έξοδος");
    }

    public static String getChoice(){
        System.out.println("Eισάγετε επιλογή");
        return in.nextLine().trim();
    }

    public static String getFirstname(){
        System.out.println("Εισάγετε όνομα");
        return in.nextLine().trim();
    }

    public static String getLastname(){
        System.out.println("Εισάγετε επίθετο");
        return in.nextLine().trim();
    }

    public static String getPhoneNumber(){
        System.out.println("Εισάγετε αριθμό τηλεφώνου");
        return in.nextLine().trim();
    }

    public static void printContactMenu(){
        System.out.println("Εισάγετε Επώνυμο, Όνομα και τηλέφωνο");
    }

    /*
 ---    * Controllers
----- ο controller είναι διαμεσολαβητής     */
    public static void updateController(String oldPhoneNumber, String firstname,
                                        String lastname, String newPhoneNumber) {
        try{
            if (oldPhoneNumber == null || firstname == null || lastname == null || newPhoneNumber == null ){
                throw new IllegalArgumentException("nulls are not allowed");
            }

            if (oldPhoneNumber.length() < 2 || oldPhoneNumber.length() > 12  ){
                throw new IllegalArgumentException("Firstname are not allowed");
            }
            if (newPhoneNumber.length() < 2 || newPhoneNumber.length() > 12  ){
                throw new IllegalArgumentException("Firstname are not allowed");
            }
            if (firstname.length() < 2 || firstname.length() >50  ){
                throw new IllegalArgumentException("Firstname are not allowed");
            }
            if (lastname.length() < 2 || lastname.length() >50  ){
                throw new IllegalArgumentException("lastname are not allowed");
            }


            //insert call
            updateContactService(oldPhoneNumber.trim(),
                    firstname.trim(),
                    lastname.trim(),
                    newPhoneNumber.trim());

        }catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;

        }

    }
    public static void insertController(String firstname, String lastname,
                                        String phoneNumber) {
        try{
            if (firstname == null || lastname == null || phoneNumber == null ){
                throw new IllegalArgumentException("nulls are not allowed");
            }
            if (firstname.length() < 2 || firstname.length() >50  ){
                throw new IllegalArgumentException("Firstname are not allowed");
            }
            if (lastname.length() < 2 || lastname.length() >50  ){
                throw new IllegalArgumentException("lastname are not allowed");
            }
            if (phoneNumber.length() < 2 || phoneNumber.length() >12  ){
                throw new IllegalArgumentException("Phone are not allowed");
            }

            //insert call
            insertContactService(
                    firstname.trim(),
                    lastname.trim(),
                    phoneNumber.trim());

        }catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;

        }

    }

    public static String [] deleteController(String phonenumber){
        try{
            if(phonenumber.length() <2 || phonenumber.length() >12){
                throw new IllegalArgumentException("phone number is not valid");
            }
            return deleteContactService(phonenumber);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static String [] getOneController(String phoneNumber){
        try{
            if (phoneNumber.length() <2 || phoneNumber.length()> 12){
                throw new IllegalArgumentException("Phone number is not valid");
            }
            return getOneContactService(phoneNumber);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
    }
    public static  String [][] getAllContactsController(){
        try{
            return getAllContactsService();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
    }
    /*
    Service Layer --- μάλλον σχετίζεται με την logger
     */

    public static String[] getOneContactService(String phoneNumber) {
       try {
           String[] contact = getContactByPhoneNumber(phoneNumber);
           if (contact.length == 0) {
               throw new IllegalArgumentException("Contact not found");
           }

           return contact;
       } catch (IllegalArgumentException e){
           log(e);
           throw e;
       }
    }

    public static  void updateContactService(String oldPhoneNumber, String firstname,
                                             String lastname, String newPhoneNumber){
        try{
            if(!(update(oldPhoneNumber, firstname, lastname, newPhoneNumber))){
                throw new IllegalArgumentException("Error in update");
            }

        } catch (IllegalArgumentException e){
            log(e);
            throw e;
        }
    }

    public static String[] deleteContactService(String phoneNumber){
        String [] contact;
        try{
            contact = delete(phoneNumber);
            if (contact.length == 0){
                throw  new IllegalArgumentException("Error in Delete");
            }
            return contact;
        }catch (IllegalArgumentException e){
            log(e);
            throw(e);
        }
    }
    public static String[][] getAllContactsService(){

        try {
            String[][] contactsList  = getAllContacts();
            if (contacts.length == 0) {
                throw new IllegalArgumentException("list is empty");
            }
            return contactsList;
        }catch (IllegalArgumentException e) {
            log(e);
            System.out.println("Message");
            throw e;

        }
    }

    public static  void insertContactService(String firstname, String lastname, String phoneNumber){
        try{
            if(!(insert(firstname, lastname, phoneNumber))){
                throw new IllegalArgumentException("Error in insert");
            }
        } catch (IllegalArgumentException e){
            log(e);
            throw e;
        }
    }
    /*
    * CRUD Services that are provided
    *
    * to Service Layer
    *
    * Στην insert στο crud επίπεδο, κάνουμε return false σε δύο διαφορετικές περιπτώσεις (αν ο πίνακας είναι γεμάτος και αν η εγγραφή υπάρχει ήδη). Αν θα θέλαμε να διαχεριστούμε διαφορετικά τα μηνύματα που θα δείξουμε στον χρήστη σε κάθε περίπτωση (στο επίπεδο controller υποθέτω?) ώστε να γνωρίζει ποιο από τα 2 errors συνέβη, πώς θα χειριζόμασταν?
    * Στην insertContactService τα διαχειριζόμαστε σαν ένα error in insert*/

    public static int getIndexByPhoneNumber(String phoneNumber){
        for(int i = 0; i<= pivot; i++) { //ο pivot είναι στην τελευταία θέση
            if (contacts[i][2].equals(phoneNumber)){
                return i;
            }
        }

        return -1; // if not found
    }

    //insert method of CRUD
    public static boolean insert(String firstname, String lastname, String phoneNumber){
        boolean inserted = false;

        if(isFull()){
            return false;
        }

        if(getIndexByPhoneNumber(phoneNumber) != -1){
            return false;
        }

        pivot++;
        contacts[pivot][0] = firstname;
        contacts[pivot][1] = lastname;
        contacts[pivot][2] =phoneNumber;

        return true;

    }

    public static boolean update(String oldPhoneNumber, String firstname, String lastname, String newPhoneNumber){
        int positionToUpdate = getIndexByPhoneNumber(oldPhoneNumber);
        String [] contact = new String[3];
        if (positionToUpdate == -1){
            return false;
//            return null;
           // return new String[] {};
            //returns an empty string named empty collection
        }
//        contact[0] = contacts[positionToUpdate][0];
//        contact[1] = contacts[positionToUpdate][1];
//        contact[2] = contacts[positionToUpdate][2];
//παραλλαγή για μέθοδο με στρινγκ

        contacts[positionToUpdate][0] = firstname;
        contacts[positionToUpdate][1] = lastname;
        contacts[positionToUpdate][2] = newPhoneNumber;
        //return contact;
        return true;
    }

    public static String[] delete(String phoneNumber) {
        int positionToDelete = getIndexByPhoneNumber(phoneNumber);
        String[] contact = new String[3];

        if(positionToDelete == -1) {
            return new String[] {};
        }
//        System.arraycopy(contacts,[positionToDelete], 0, contact, 0, contact.length);
        for(int i = 0; i< contact.length; i++){
            contact[i] = contacts[positionToDelete][i];
        }
        //αντικαθιστούμε την for με το παραπάνω arraycopy

        if(!(positionToDelete == contacts.length -1)){
            System.arraycopy(contacts, positionToDelete + 1, contacts, positionToDelete, pivot -positionToDelete);
        }
        pivot--;
        return contact;
    }
    public static String[] getContactByPhoneNumber(String phoneNumber){
        int positionToReturn = getIndexByPhoneNumber(phoneNumber);

        if (positionToReturn == -1) {
            return new String[] {};
        }

        return contacts[positionToReturn];
    }

    public static String[][] getAllContacts() {
        return Arrays.copyOf(contacts, pivot + 1);
    }

    public static boolean isFull(){
        return pivot == contacts.length -1;
    }

    /*
    Costum Logger
    Varargs String[] message
    log(Exception)
    /

     */

    public static void log(Exception e, String... message){
        try (PrintStream ps = new PrintStream(new FileOutputStream(path.toFile(), true))) {
            //στην αρχή μην ξεχάσω να βάλω το final path path = path.get(c:)
            ps.println(LocalDateTime.now() + "\n" + e.toString());
            ps.printf("%s", (message.length == 1) ? message[0] : "");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
