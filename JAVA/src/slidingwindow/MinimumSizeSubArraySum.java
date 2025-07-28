package slidingwindow;

public class MinimumSizeSubArraySum {
	
	public int minSubArrayLen(int target, int[] nums) {  //[2,3,1,2,4,3], 7
      int minLength=Integer.MAX_VALUE; //max possible value
      int start=0;
      int end;
      int sum=0;  
      
      for(end=0; end<nums.length; end++) {
    	  sum+=nums[end];
    	  while(sum>=target) {
    		  minLength=Math.min(minLength, end-start+1);
    		 sum-=nums[start];
    		 start++;
    	  }
      }
      if(minLength==Integer.MAX_VALUE) {
    	  return 0;
      }
      return minLength;
	}
	
	public static void main(String args[]) {
		MinimumSizeSubArraySum  minSum = new MinimumSizeSubArraySum ();
		int[] nums = {1, 4, 4};
		System.out.print(minSum.minSubArrayLen(4, nums));
	}

	

}
