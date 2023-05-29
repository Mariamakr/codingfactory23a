package gr.aueb.cf.ch7;

/**
 * Replaces String or substring
 */
public class ReplaceApp {

    public static void main(String[] args) {
        String title = "Coding Factory";
        String dashedtitle;

        dashedtitle = title.replace(" ", " - ");
        System.out.println(dashedtitle);
    }
}
