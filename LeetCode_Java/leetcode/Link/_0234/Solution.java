package Link._0234;

import java.util.ArrayList;

public class Solution{
    public static boolean isPalindrome(ListNode head){
        ListNode currentNode = head;
        ArrayList<ListNode> arr = new ArrayList<>();

        if(head == null || head.next == null)
            return true;

        while (currentNode.next != null){
            arr.add(currentNode);
            currentNode  = currentNode.next;
        }
        arr.add(currentNode);

        for(int i = 0; i <= Math.floor(arr.size()/2) -1; i++){
            if(arr.get(i).val != arr.get(arr.size()-i-1).val)
                return false;
        }

        return true;
    }
}