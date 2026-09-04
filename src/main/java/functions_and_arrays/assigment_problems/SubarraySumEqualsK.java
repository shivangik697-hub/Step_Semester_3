package functions_and_arrays.assigment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem A4: Subarray Sum Equals K
 * 
 * Scenario:
 * A hostel warden reviewing a semester's daily attendance-change log (some days net positive, some negative,
 * as students check in and out) wants to know how many different contiguous stretches of days had a net change
 * of exactly k — across the whole log, not just one answer.
 * 
 * Task:
 * - Accept an integer array nums (which may contain negative numbers) and an integer k.
 * - Return the total number of contiguous subarrays whose sum equals exactly k.
 * - Solve it using running prefix sums combined with a hash map: the sum of any subarray [i+1, j] equals
 *   prefixSum[j] - prefixSum[i], so at each position you need to know how many earlier prefix sums equal
 *   (currentSum - k).
 * - Base Case: Include empty prefix sum (0) initialized with frequency 1.
 * 
 * Constraints:
 * - 1 <= nums.length <= 2 * 10^4
 * - nums[i] and k may both be negative.
 * - Time: O(n), Space: O(n) using a hash map of prefix-sum frequencies.
 */
public class SubarraySumEqualsK {

    /**
     * Finds the total number of contiguous subarrays whose sum equals k.
     * 
     * @param nums Input array of integers
     * @param k Target sum
     * @return Number of subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        // Map to store frequency of running prefix sums
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once (before index 0)
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in map, add its frequency to count
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Update frequency of current running prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A4: Subarray Sum Equals K ===");

        // Sample Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = subarraySum(nums1, k1);
        System.out.println("Input:  nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2 (Subarrays [1,1] at positions 0-1 and 1-2)");
        System.out.println();

        // Sample Test Case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int result2 = subarraySum(nums2, k2);
        System.out.println("Input:  nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 3");
        System.out.println();
    }
}
