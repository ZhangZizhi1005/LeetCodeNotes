package Array._0724;

class Solution{
    public static int pivotIndex(int[] nums){
        if(nums.length != 0) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum - nums[0] == 0) return 0;
            int lsum = 0;
            int rsum = sum - nums[0];
            for (int index = 1; index < nums.length - 1; index++) {
                lsum += nums[index - 1];
                rsum -= nums[index];
                if (lsum == rsum) return index;
            }
            if (sum -nums[nums.length-1] ==0) return nums.length-1;
        }
        return -1;
    }
}