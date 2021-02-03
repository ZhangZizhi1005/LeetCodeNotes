package Link._0206;

import Link._0234.ListNode;

class Solution {
    public ListNode iterativeReverseList(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode currentNode = head;
        ListNode prev = null;


        while (currentNode != null){
            ListNode tempNext = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = tempNext;
        }
        return prev;
    }

    public ListNode recursiveReserveList(ListNode head){
        if ( head == null || head.next == null ){
            return head;
        }

        ListNode newHead = recursiveReserveList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}