package gr.aueb.cf.ch7;

/**
 * Κρυπτογράφηση σε ASCII
 */
public class ConvertToASCIIApp {

    public static void main(String[] args) {
        String chars = "CODING FACTORY";
        int sum = 0;

        for( int i = 0; i < chars.length(); i++){
            int ASCII = chars.charAt(i);
            sum = sum + ASCII;
            //System.out.println(chars.charAt(i) + "=" + ASCII);
        }
        System.out.println("ASCII is:" + sum);
    }
}
