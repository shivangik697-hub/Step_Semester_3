package functions_and_arrays.assigment_problems;

import java.util.Arrays;

/**
 * Problem A1: Product of Array Except Self
 * 
 * Scenario:
 * A pricing engine needs, for every product in a bundle, the combined price of every OTHER product
 * in that same bundle — computed for all products at once, without ever dividing by the current product's
 * own price.
 * 
 * Task:
 * - Accept an integer array nums.
 * - Return an array answer where answer[i] is the product of every element in nums except nums[i]
 *   without using division anywhere in your solution.
 * - Solve it in O(n) time using two passes: a forward pass accumulating running product of everything to the
 *   left of each index, and a backward pass multiplying in the running product of everything to the right.
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - The product of any prefix or suffix fits within a 32-bit integer.
 * - Division is NOT allowed anywhere.
 * - Time: O(n), Extra Space: O(1) beyond output array.
 */
public class ProductExceptSelf {

    /**
     * Computes the product of all elements in nums except nums[i] without division.
     * 
     * @param nums Input array of integers
     * @return Array containing product of array except self at each index
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Accumulate prefix products (running product of elements to the left of index i)
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Accumulate suffix products (running product of elements to the right of index i)
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem A1: Product of Array Except Self ===");

        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Input:  nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [24, 12, 8, 6]");
        System.out.println();

        // Sample Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("Input:  nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [0, 0, 9, 0, 0]");
        System.out.println();
    }
}
