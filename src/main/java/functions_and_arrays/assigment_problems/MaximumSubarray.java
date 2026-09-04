package functions_and_arrays.assigment_problems;

import java.util.Arrays;

/**
 * Problem A2: Maximum Subarray
 * 
 * Scenario:
 * A trader has a full year of daily profit-or-loss figures, some positive, some negative, and wants to
 * know the single best contiguous stretch of days to have been actively trading — the run of consecutive
 * days whose combined total is the highest possible.
 * 
 * Task:
 * - Accept an integer array nums, which may contain negative numbers.
 * - Find the contiguous subarray (containing at least one number) with the largest possible sum, and return that sum.
 * - Solve it using Kadane's algorithm: at each element, decide whether to extend the current running subarray
 *   or abandon it and start fresh from the current element, based on whichever gives a larger sum.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - Time: O(n), Space: O(1)
 */
public class MaximumSubarray {

    /**
     * Finds the maximum contiguous subarray sum using Kadane's Algorithm.
     * 
     * @param nums Input array of integers
     * @return Maximum contiguous sum
     */
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decision: extend running subarray or start fresh from nums[i]
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Update global maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A2: Maximum Subarray ===");

        // Sample Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubArray(nums1);
        System.out.println("Input:  nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: 6 (Subarray [4, -1, 2, 1])");
        System.out.println();

        // Sample Test Case 2 (All negative numbers)
        int[] nums2 = {-3, -1, -2};
        int result2 = maxSubArray(nums2);
        System.out.println("Input:  nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: -1");
        System.out.println();
    }
}
