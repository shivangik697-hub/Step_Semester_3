package functions_and_arrays.practice_problem;

import java.util.Arrays;

/**
 * L5. Rotate Array
 */
public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(rotateArray(nums1, k1)));

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(rotateArray(nums2, k2)));
    }
}
