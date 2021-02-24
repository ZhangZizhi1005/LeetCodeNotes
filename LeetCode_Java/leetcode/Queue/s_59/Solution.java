package Queue.s_59;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k  == 0) {
            int[] res = {};
            return res;
        }

        if(nums.length <= k) {
            int[] res = new int[1];
            res[0] = Integer.MIN_VALUE;
            for(int i = 0; i <= nums.length-1; i++){
                res[0] = res[0] > nums[i] ? res[0] : nums[i];
            }
            return res;
        }

        Deque<Integer> q = new ArrayDeque<>(k);
        int[] res = new int[nums.length - k + 1];

        q.add(nums[0]);
        for(int i = 1; i <= k - 1; i++){
            while(q.peekLast() < nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        res[0] = q.peekFirst();

        for(int i = k; i <= nums.length-1; i++){
            if(q.peekFirst() == nums[i - k]){
                q.removeFirst();
            }
            while(q.peekLast() < nums[i]){
                q.removeLast();
            }
            q.addLast(nums[i]);
            res[i-k+1] = q.peekFirst();
        }
        return res;
    }
}
