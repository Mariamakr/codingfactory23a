//package gr.aueb.cf.ch10;
//
//import java.util.ArrayList;
//
//public class CryptoApp {
//
//    public static void main(String[] args) {
//        final int KEY = 300;
//        String s = "Coding";
//
//        String encrypted = encrypt(s, KEY).toString(); // το tostring μετατρέπει τα στοιχεία της λίστας σε string
//        System.out.println(encrypted);
//
//        String decrypted = decrypt(encrypt(s, KEY), KEY).toString();
//        System.out.println(decrypted);
//    }
//
//    public static ArrayList<Integer> encrypt(String s, int key){
//        ArrayList<Integer> encrypted = new ArrayList<>();
//        char ch;
//        int i;
//
//        int prev = cipher(s.charAt(0), -1, key);
//        encrypted.add(prev);
//
//
//            //το string εισόδου τελειώνει με ένα #.
//        //θα μπορούσε και με μία αέναη for --> for(;;)
//        i = 1;
//        while((ch = s.charAt(i)) != '#') {
//            // και διαβάζω και συγκρίνω ταυτόχρονα
//            encrypted.add(cipher(ch, prev, key));
//            prev = cipher(ch, prev , key);
//            i++;
//        }
//        encrypted.add(-1);
//        return  encrypted;
//    }
//
//    public static ArrayList<Character> decrypt(ArrayList<Integer> encrypted, int key){
//        ArrayList<Character> decrypted = new ArrayList<>();
//        int token;
//        int i;
//        int prevToken;
//
//        //για να διαβάσω κάνω .get
//        prevToken = decipher(encrypted.get(0), -1, key);
//        decrypted.add((char) prevToken); // autocast σε wrapper κλάση
//
//        i = 1;
//        while((token = encrypted.get(i)) != -1){
//            decrypted.add(decipher(token, prevToken, key));
//            prevToken = token;
//            i++;
//        }
//
//        return decrypted;
//    }
//    // παίρνει έναν χαρακτήρα και τον επιστρέφει κρυπτογραφημένο ώσ int
//    public static int cipher(char ch, int prev, int key){
//        if (prev == -1) return ch;
//        return(ch + prev) % key;
//    }
//
//    public static char decipher(int cipher, int prev, int key){
//        int de;
//        if( prev == -1) return (char) cipher; //return ton cipher metatr;epontas to se char
//
//        de = (cipher - prev + key) % key;
//        return (char) de;
//    }
//}

