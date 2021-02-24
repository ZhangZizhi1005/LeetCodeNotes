## Failure 1 ##

> **Input:**
>
> > [] 0
>
> **Reason:**
>
> ​	Ignored case that the array is empty

```java
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

class Solution{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            int res = Integer.MIN_VALUE;
            for (int i = 0; i <= nums.length - 1; i++) {
                res = res < nums[i] ? nums[i] : res;
            }
            int[] max = {res};
        }

        int[] max = new int[nums.length - k];
        int count, resCount;
        Deque<Integer> q = new ArrayDeque<>(k );
        for (count = 0; count <= k - 1; count++) {
            q.add(nums[count]);
        }
        resCount = 0;
        max[resCount] = Collections.max(q);
        resCount ++;

        for (; count <= nums.length - 1; count++) {
           q.removeFirst();
           q.add(nums[count+1]);
           max[resCount] = Collections.max(q);
           resCount ++;
        }
        return max;
    }
}
```



---

## Solution ##

> **Key**
>
> reduce time cost from O(k) to O(1)
>
> **Thought**
>
> If we maintain a window as above code, every time we get the max value of current queue, we must traverse the queue. The traversal cost O(k) time.
>
> We may come out with a method to simplify the proccess to search Max value. If we remove all elements before the Max value, the head of queue is the Max value.
>
> But, if the element removed is the Max Value, we have to find the Max value one more time. To avoid this, we make a little improvement.
>
> We can maintain a **monotone decreasing** queue, so that no matter the Max value is removed or not, the new Max value is still the peek of queue.
>
> **Associated**
>
> This question is similar to the question _0155. When we need to find the Max or Min value of a changing queue or stack, like min_stack or sliding window. We can maintain a increasing or decreasing deque, and dicide wether it should be monotone or not according to specific requirements.

```java
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
```

