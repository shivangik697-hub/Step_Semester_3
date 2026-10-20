package functions_and_arrays.assigment_problems;

import java.util.Arrays;

/**
 * Problem A5: Find Minimum in Rotated Sorted Array
 * 
 * Scenario:
 * A circular duty roster was originally sorted by join date, then “rotated” at some unknown point when the
 * office started the printed list from a different staff member instead of the very first one. Given only the
 * resulting list, find the original earliest join date — without scanning every entry one by one.
 * 
 * Task:
 * - Accept an integer array nums of unique elements, originally sorted in ascending order and then rotated
 *   at some unknown pivot.
 * - Return the minimum element in the array.
 * - Solve it using a modified binary search rather than a linear scan: at each step, compare the middle element
 *   to the rightmost element to decide which half of the array the minimum must be hiding in.
 * 
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - All elements are distinct.
 * - Time: O(log n), Space: O(1)
 */
public class FindMinInRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array using binary search.
     * 
     * @param nums Input array of distinct integers, sorted and rotated
     * @return Minimum element in nums
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element, minimum must be in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, minimum is at mid or to its left
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A5: Find Minimum in Rotated Sorted Array ===");

        // Sample Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = findMin(nums1);
        System.out.println("Input:  nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1");
        System.out.println();

        // Sample Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = findMin(nums2);
        System.out.println("Input:  nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0");
        System.out.println();

        // Sample Test Case 3 (No rotation)
        int[] nums3 = {11, 13, 15, 17};
        int result3 = findMin(nums3);
        System.out.println("Input:  nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);
        System.out.println("Expected: 11");
        System.out.println();
    }
}
