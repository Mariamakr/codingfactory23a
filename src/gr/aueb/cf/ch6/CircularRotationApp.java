///**
// *
// */
//
// public class CircularRotationApp{
//
//    public static void main(String[] args) {
//        int arr[] = {5,7,20,12,9};
//        int[] rotated = doCircularRightShiftBy(arr, 1); // douleuoun kai ta pollaplasia.. px (arr, 25) tha htan san na mhn exei g;inei rotate
//        print(rotated);
//
//    }
//
//    public static int[] doCircularRightShiftBy(int[] arr, int offset){
//        if(arr == null) return null;
//        int[] rotated = new int[arr.length];
//
//        for(int i = 0; i <arr.length; i++){
//            rotated(i + offset) % arr.length = arr[i];
//        }
//        return rotated;
//
//    }
//
//    public static int[] doCircularLeftShiftBy(int[] arr, int offset){
//        if(arr == null) return null;
//
//        int[] rotated = new int[arr.length];
//
//        for(int i = 0; i < arr.length; i++){
//            rotated[Math.abs(i - offset) % arr.length] = arr[i];
//        }
//
//        return rotated;
//    }
//    public static void print(int[] arr){
//        if(arr == null) return;
//        for(int item : arr)
//        System.out.print(item + " ");
//
//    }
//
// }