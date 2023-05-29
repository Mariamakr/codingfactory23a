package gr.aueb.cf.ch7;

/**
 * Αποκρυπτογραφεί από ASCII
 */
public class ConvertFromASCIIApp {


    public static void main(String[] args) {
        int [] Arr = {67, 79, 68, 73, 78, 71, 32, 70, 65, 67, 84, 79, 82 ,89};
        char [] AsciiToChar = {67, 79, 68, 73, 78, 71, 32, 70, 65, 67, 84, 79, 82 ,89};

        for(int i = 0; i > Arr.length; i--){
            AsciiToChar = Character.toChars(Arr[i]);
        }
        System.out.println(Arr);
        System.out.println(AsciiToChar);
    }
}
