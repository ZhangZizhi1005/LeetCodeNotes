package  Array._0643;



/*
public class Solution{
    public static double findMaxAverage(int[] nums, int k){
        if(nums.length >= k ) {
            // 不能写作int max =0； 否则{-1}，1的输入会错误
            double maxSum = Double.NEGATIVE_INFINITY;
            // 将preSum[]的长度定加一个，方便计算，否则相减的时候nums中的第一个永远会被减掉。
            int[] preSum = new int[nums.length+1];
            preSum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = nums[i-1] + preSum[i-1];
            }
            for (int j = 0; j < preSum.length - k; j++) {
                int sum = preSum[j + k] - preSum[j];
                maxSum = Math.max(sum, maxSum);
            }
            return (double) maxSum / k;
        }
        return Double.NaN;
    }
}
*/

/**
 * 更优的写法见下，直接从k开始循环 这样就不用错开presum的下标了
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}



