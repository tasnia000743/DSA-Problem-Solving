/*You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

Count the occurrences of all elements in the array.
Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
Calculate the sum of the resulting array.
Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].
Example:
Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
Output: [6,10,12]
Explanation:
For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3 */

package slidingwindow;

import java.util.*;

public class XSumLongSubArray {

    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        for (end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (end - start + 1 == k) {
                list.add(sum(map, x));
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;

            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int sum(Map<Integer, Integer> map, int size) {
        int sumVal = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (Map.Entry<Integer, Integer> mapData : map.entrySet()) {
            pq.offer(new int[] { mapData.getKey(), mapData.getValue() });
        }

        while (pq.size() > size) {
            pq.poll();
        }

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            sumVal += polled[0] * polled[1];

        }
        return sumVal;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 8, 7, 8, 7, 5 };
        XSumLongSubArray subArr = new XSumLongSubArray();
        int result[] = subArr.findXSum(nums, 2, 2);
        System.out.println(Arrays.toString(result)); 
    }

}
