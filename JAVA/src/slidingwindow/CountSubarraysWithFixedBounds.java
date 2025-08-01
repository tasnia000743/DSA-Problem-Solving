package slidingwindow;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex = -1;
        int maxIndex = -1;
        int indexForInv = -1;
        long subArrayCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                indexForInv = i;
            }

            int temp = Math.min(minIndex, maxIndex) - indexForInv;
            if (temp > 0) {
                subArrayCount += temp;
            }

        }
        return subArrayCount;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1 };
        CountSubarraysWithFixedBounds count = new CountSubarraysWithFixedBounds();
        System.out.println(count.countSubarrays(nums, 1, 1));
    }

}
