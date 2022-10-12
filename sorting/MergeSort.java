package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 6, 3};
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = p + (r -p) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }

    }

    static void merge(int[] arr, int p, int q, int r) {
        //calculate size of two arrays
        int leftLength = q - p + 1;
        int rightLength = r - q;

        //create two array to hold left and right array of elements
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        //add elements to left array
        for (int i = 0; i < leftLength; i++) {
            left[i] = arr[p + i];
        }

        //add elements to right array
        for (int i = 0; i < rightLength; i++) {
            right[i] = arr[q + i + 1];
        }

        int i = 0, j = 0, k = p;
        //compare two arrays and add the smaller element at the p location onwards
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        //add remaining elements in left array
        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        //add remaining elements in right array
        while (j < rightLength) {
            arr[k++] = right[j++];
        }
        //print array after each step
        System.out.println(Arrays.toString(arr));
    }
}
