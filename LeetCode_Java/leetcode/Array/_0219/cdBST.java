package Array._0219;

import java.util.Set;
import java.util.TreeSet;

public class cdBST {
    public boolean cd_BST(int[] nums, int k){
        // 构建一个BST
        Set<Integer> bstSet = new TreeSet<>();

        for (int i=0; i< nums.length; ++i){
            if(bstSet.contains(nums[i])) return true;
            bstSet.add(nums[i]);
            if(bstSet.size() > k) bstSet.remove(nums[i-k]);
        }
        return false;
    }
}
