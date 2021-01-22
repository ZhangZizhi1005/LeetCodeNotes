package Array._0747;

class Solution{
    public int dominantIndex(int [] nums){
        int maxNum = 0;
        int secMaxNum = 0;

        int maxIndex = 0;
        int secMaxIndex = 0;

        for (int i = 0; i < nums.length ; ++i){
            if (nums[i] > maxNum){
                //if(maxNum > secMaxNum)
                {secMaxNum = maxNum;}//没有这句会导致[0,0,2,3]错误输出

                maxIndex = i;
                maxNum = nums[i];

            }else if(nums[i] > secMaxNum){
                secMaxIndex =i;
                secMaxNum = nums[i];
            }
        }
        if(maxNum >= secMaxNum * 2)
            return maxIndex;

        return -1;
    }
}