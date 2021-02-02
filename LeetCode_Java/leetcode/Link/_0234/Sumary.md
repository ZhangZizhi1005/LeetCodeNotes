# Link_0234 #

---

## Initial version ##

> Thought:
>
> ​	Translate the linkedlist into an array
>
> Code:
>
> ```java
> /**
>  * Definition for singly-linked list.
>  * public class ListNode {
>  *     int val;
>  *     ListNode next;
>  *     ListNode() {}
>  *     ListNode(int val) { this.val = val; }
>  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
>  * }
>  */
> import java.util.ArrayList;
> 
> public class Solution{
>     public static boolean isPalindrome(ListNode head){
>         ListNode currentNode = head;
>         ArrayList<ListNode> arr = new ArrayList<>();
> 
>         if(head == null || head.next == null)
>             return true;
> 
>         while (currentNode.next != null){
>             arr.add(currentNode);
>             currentNode  = currentNode.next;
>         }
>         arr.add(currentNode);
> 
>         for(int i = 0; i <= Math.floor(arr.size()/2) -1; i++){
>             if(arr.get(i).val != arr.get(arr.size()-i-1).val)
>                 return false;
>         }
> 
>         return true;
>     }
> }
> ```
>
> Improvement
>
> 1. ```arr``` store value of the node rather than the node itself
> 2. Use double pointer to simplify coding
>
> ```java
> //improvement 1
> 	ArrayLis<Integer> arr = new ArrayList<>();
> 	//...
> 	arr.add(currentNode.val);
> 
> //improvement 2
> 	int front = 0;
> 	int back = arr.size()-1;
> 	while(front < back){
>         if(arr.get(front) != arr.get(back))
>             return false;
>         front++;
>         back --;
>     }
> ```

---

## Better Solution ##

>Thought:
>
>1. Found half of the linkedlist
>2. Reverse the second part
>3. Compare these two parts
>4. Reverse the second part back