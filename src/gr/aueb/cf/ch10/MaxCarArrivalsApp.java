package gr.aueb.cf.ch10;

import java.util.Arrays;
import java.util.Comparator;

public class MaxCarArrivalsApp {
    public static void main(String[] args) {

    int[][] arr = {{1012, 1056}, {1022, 1150}, {1317, 1405}, {1027, 1409}, {1100, 1200}};
    //είναι ο δισδιάστατος πίνακας με τις ώρες άφηξης και τις ώρες αποχώρησης από το garage

    int[][] transformed;
    //o νέος πίνακας  με 0 1 αν ήρθε η έφυγε

    transformed =transform(arr);

    sortByTime(transformed);
    System.out.println("max arrivals:" + getMaxConcurrentCars(transformed));


}


    public static int [][] transform(int[][] arr) {
        int [] [] transformed = new int [arr.length*2][2];

        for(int i = 0; i <arr.length; i++) {
            transformed[i * 2][0] = arr[i][0];
            transformed[i * 2][1] = 1;
            transformed[i * 2 + 1][0] = arr[i][1];
            transformed[i * 2 + 1][1] = 0;
        }
        return  transformed;
    }
    public static void sortByTime(int[][] arr) {
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        //για κάθε στοιχείο (row) α με ποιο από τα δυο να ταξινομήσει;;
        // με το α[0] ή με το α[1];;
    }

    public static int getMaxConcurrentCars(int[][] arr) {
        int count = 0;
        int maxCount = 0;

        for (int[] a : arr) {
            if(a[1] == 1) {
                count++;
                if (count > maxCount) maxCount = count;
            }else { //if a[1] = 0
                count--;
            }
        }
        return maxCount;
    }
}
