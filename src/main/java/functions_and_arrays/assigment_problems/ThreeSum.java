package functions_and_arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem A3: 3Sum
 * 
 * Scenario:
 * A budgeting tool needs to find every distinct combination of exactly three transactions in a student's account
 * history that cancel each other out exactly — summing to zero — without ever reporting the same combination of
 * amounts twice, even if it could be picked out of the list in more than one way.
 * 
 * Task:
 * - Accept an integer array nums.
 * - Return all unique triplets [nums[i], nums[j], nums[k]] (i, j, k all different positions) such that the three
 *   values sum to exactly 0.
 * - Sort the array first, then for each element, use two pointers moving inward from both ends of the remaining
 *   subarray to find pairs that complete the sum to zero — carefully skipping over duplicate values at every level to
 *   avoid reporting the same triplet more than once.
 * 
 * Constraints:
 * - 3 <= nums.length <= 3000
 * - Time: O(n^2), Space: O(1) auxiliary (excluding output storage)
 */
public class ThreeSum {

    /**
     * Finds all unique triplets that sum to zero and returns them as a 2D array.
     * Matches suggested method signature: int[][] threeSum(int[] nums)
     * 
     * @param nums Input array of integers
     * @return 2D array of unique triplets summing to 0
     */
    public static int[][] threeSum(int[] nums) {
        List<List<Integer>> resultList = threeSumList(nums);
        int[][] result = new int[resultList.size()][3];
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> triplet = resultList.get(i);
            result[i][0] = triplet.get(0);
            result[i][1] = triplet.get(1);
            result[i][2] = triplet.get(2);
        }
        return result;
    }

    /**
     * Finds all unique triplets that sum to zero and returns them as a List of Lists.
     * 
     * @param nums Input array of integers
     * @return List of unique triplets
     */
    public static List<List<Integer>> threeSumList(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        // Step 2: Iterate through array fixing the first element nums[i]
        for (int i = 0; i < n - 2; i++) {
            // Avoid duplicate triplets with the same first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two-pointer approach for the remaining subarray
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate right values
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A3: 3Sum ===");

        // Sample Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] result1 = threeSum(nums1);
        System.out.println("Input:  nums = " + Arrays.toString(nums1));
        System.out.print("Output: ");
        print2DArray(result1);
        System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]]");
        System.out.println();

        // Sample Test Case 2
        int[] nums2 = {0, 0, 0};
        int[][] result2 = threeSum(nums2);
        System.out.println("Input:  nums = " + Arrays.toString(nums2));
        System.out.print("Output: ");
        print2DArray(result2);
        System.out.println("Expected: [[0, 0, 0]]");
        System.out.println();
    }

    private static void print2DArray(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
