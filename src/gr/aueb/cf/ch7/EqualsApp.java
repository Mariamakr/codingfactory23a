package gr.aueb.cf.ch7;

public class EqualsApp {

    public static void main(String[] args) {
        String s1 = "Athens";
        String s2 = "Athens";
        String s3 = new String("Athens");

//        if(s1 == s2){
//            System.out.println("Strings s1 and s2 are equals");
//
         if (s1.equals(s3)) {
             System.out.println("EQUALS");
        }
    }
}
