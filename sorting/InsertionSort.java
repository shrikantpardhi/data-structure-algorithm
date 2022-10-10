package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println("Initial array: " + Arrays.toString(arr));
//        insertionSort(arr);
        insertionSortUsingBS(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    // time complexity is O(n^2) for both comparison and swaps
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    //swap the elements using temp variable
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // time complexity for swap => O(n^2) and comparison => O(log n)
    static void insertionSortUsingBS(int[] arr) {
        for (int i = 1; i< arr.length; i++) {
            int pos = binarySearch(arr, 0, i-1, arr[i]);
            swapToN(arr, i, pos);
        }
    }


    // binary search to find the position where we want to insert target
    static int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if(target > arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    //swap the variable unto n swaps,
    static void swapToN(int[] arr, int second, int first) {
        /* it will swap only if there is any difference in the positions given. So its stable sorting.
        * if difference in swap position is greater than 1 it will shift the position till difference. */
        int temp = arr[second];
        if (second > first) {
            for (int k = second; k > first; k--) {
                arr[k] = arr[k-1];
            }
            arr[first] = temp;
        }
    }
}