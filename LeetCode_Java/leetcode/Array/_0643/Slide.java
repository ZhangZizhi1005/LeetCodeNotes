package Array._0643;

class Slide{
    public static double findMaxAverage(int[] nums, int k){
        if(nums.length >=k ){
            double sum = 0.0;
            for (int i =0; i<k; i++){
                sum += nums[i];
            }
            for (int i =k; i<nums.length; i++){
                sum = Math.max(sum,sum+nums[i]-nums[i-k]);
            }
            return sum/k;
        }
        return Double.NaN;
    }
}