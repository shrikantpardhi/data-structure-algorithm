package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 6, 3};
        System.out.println("Initial array: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
//                System.out.println("i: "+ i +" j: "+ j +" "+ Arrays.toString(arr));
            }
        }
    }
}
