package gr.aueb.cf.ch6;

/**
 * Anazita to min kai to max stoixeio 
 * enos pinaka
 */

 public class ArrayMinMaxApp {

    public static void main(String[] args) {
        
        int[] arr = {30, 12, 80, 7, 15};

        int minPosition = 0; //protithesitoupinaka
        int minValue = arr[minPosition];

        int maxPosition = 0;
        int maxValue = arr [maxPosition];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < minValue){
                minPosition = i;
                minValue = arr[i];
            }
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maxValue){
                maxPosition = i;
                maxValue = arr[i];
            }
        }

    System.out.printf("Min Value: %d, Min Position: %d\n", minValue, minPosition + 1);
    System.out.printf("Max value: %d, Max Position: %d", maxValue, maxPosition + 1);
    }
 }
// gia to max apla allazo sto if to sumbolo arr[i] > maxValue