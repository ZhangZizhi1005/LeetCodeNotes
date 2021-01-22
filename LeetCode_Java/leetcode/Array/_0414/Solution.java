package Array._0414;

import java.util.TreeSet;

class Solution{
    public static int thirdMax(int[] nums){
        TreeSet<Integer> rec = new TreeSet<>();

        for(int i = 0; i <= nums.length -1 ; i++){
            if(!rec.contains(nums[i])){
                rec.add(nums[i]);
            }
            if(rec.size() >=4 ){
                rec.remove(rec.first());
            }
        }
        if(rec.size() == 3) return rec.first();
        return rec.last();
    }
}