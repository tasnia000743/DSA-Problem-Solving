// Given a binary array nums, you should delete one element from it.
// Return the size of the longest non-empty subarray containing only 1's in the resulting array. 
// Return 0 if there is no such subarray.

// Example 1:

// Input: nums = [1,1,0,1]
// Output: 3
// Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

package slidingwindow;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        boolean arrayHasZero = false;
        for (int value : nums) {
            if (value == 0) {
                arrayHasZero = true;
            }
        }
        if (!arrayHasZero) {
            return nums.length - 1;
        }

        int countOf1 = 0;
        int zeros = 0;
        int max = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 1) {
                countOf1++;
            }
            if (nums[end] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[start] == 0) {
                    zeros--;
                }
                if (nums[start] == 1) {
                    countOf1--;
                }
                start++;
            }
            max = Math.max(max, countOf1);
        }
        return max;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1 };
        LongestSubarray obj = new LongestSubarray();
        System.out.println(obj.longestSubarray(nums));
    }
}
