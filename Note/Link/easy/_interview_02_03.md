# Link_Interview_02_03 #

---

## Solution ##

>**Thought:**
>
>​	As the link is not given, we can not traverse the link and remove the node given as we usually do.
>
>​	Reconsider the conditions given, one thing we know for sure is the node do belongs to a link, and it is not the last node of the link.
>
>​	To suamry, we can only access the part of link that is after the given node. So we may consider that we can use the next node to substitude the given node and delete the next node.
>
>**Code:**
>
>```java
>/**
> * Definition for singly-linked list.
> * public class ListNode {
> *     int val;
> *     ListNode next;
> *     ListNode(int x) { val = x; }
> * }
> */
>class Solution {
>    public void deleteNode(ListNode node) {
>        if(node == null){
>            return;
>        }
>
>        node.val = node.next.val;
>        node.next = node.next.next;
>        return;
>    }
>}
>```
>
>