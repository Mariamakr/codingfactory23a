package gr.aueb.cf.ch10;
/**
 * Assume an array: {1, 2, 4, 4, 6, 7, 8, 8, 9, 9, 9}
 * The app returns the low and high index for a key (integer key)
 * that is included in the array. IF the key was 8
 * the algorithm should return {7,9} or {8, 10} if we make a tiny user-friendly optimization}
 */

public class Ch6LowAndHighIndexApp {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 4, 4, 6, 7, 8, 8, 9, 9, 9};
        int [] returned;

        returned = getLowAndHighIndexOf(arr, 9);

        System.out.printf("(%d, %d)", returned[0] + 1, returned[1] + 1);
        // δικές μου προσπάθειες να το δοκιμάσω...
    }
    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int low = 0;
        int high = 0;
        int pivot;

        if(arr == null) return new int[] {};

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                low = i;
                break;
            }
        }
        high = low;
        pivot = low + 1;
        while (pivot < arr.length && arr[pivot++] == key) {
            high++;
        }
        return new int[] {low, high};

    }
}
