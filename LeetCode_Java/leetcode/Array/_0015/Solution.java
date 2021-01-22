package Array._0015;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum (int[] nums){
        int count = 0;
        ArrayList<Integer> rec = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        /*List res = new ArrayList();
        List rec = new ArrayList();*/
        if(nums.length < 3)
            return null;

        for (int i  = 0; i <= nums.length - 3 ; i++){
            for (int j = i+1; j <= nums.length -2; j++){
                for (int k = j+1; k <= nums.length -1; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        rec.add(nums[i]);
                        rec.add(nums[j]);
                        rec.add(nums[k]);

                        res.add(rec);
                        rec.clear();

                        count++;
                    }
                }
            }
        }
        if(count == 0) return null;
        return res;
    }
}