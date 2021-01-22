package Array._0219;

import java.util.HashSet;
import java.util.Set;

public class cdHash {
    public boolean cd_Hash(int[] nums, int k){
        Set<Integer> hSet =  new HashSet<>();

        for (int i=0; i< nums.length; ++i){
            if(hSet.contains(nums[i])) return true;
            hSet.add(nums[i]);
            if(hSet.size() > k) hSet.remove(nums[i-k]);
        }
        return false;
    }
}
