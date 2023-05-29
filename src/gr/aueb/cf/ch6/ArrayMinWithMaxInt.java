package gr.aueb.cf.ch6;

/**
 * se authn thn periptosh to vriskei me to min value 
 * kai oxi me to position
 */

public class ArrayMinWithMaxInt {

    public static void main(String[] args) {
        int[] arr = {6, 90, 4, 17};

        int minPosition = 0;
        int minValue = arr[minPosition];

        for( int i = 0; i < arr.length; i++){
            if(arr[i] < minValue){
                minPosition = i;
                minValue = arr[i];
            }
        }
        System.out.printf("Min value: %d, Min Position:%d", minValue, minPosition);
    }
}