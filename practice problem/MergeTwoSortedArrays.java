package functions_and_arrays.practice_problem;

import java.util.Arrays;

/**
 * L4. Merge Two Sorted Arrays
 */
public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }

        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1_1 = {1, 3, 5};
        int[] arr1_2 = {2, 4, 6};
        System.out.println("Input: arr1 = " + Arrays.toString(arr1_1) + ", arr2 = " + Arrays.toString(arr1_2));
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr1_1, arr1_2)));

        int[] arr2_1 = {1, 2};
        int[] arr2_2 = {1, 2, 3};
        System.out.println("Input: arr1 = " + Arrays.toString(arr2_1) + ", arr2 = " + Arrays.toString(arr2_2));
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr2_1, arr2_2)));
    }
}
