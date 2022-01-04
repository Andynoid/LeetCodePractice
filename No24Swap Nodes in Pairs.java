/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 100 speed, 8% space 2022.1.4
class Solution {
    private ListNode rSwap(ListNode curr){
        if(curr.next == null){
            return curr;
        }
        else if (curr.next.next == null){
            ListNode newNode = curr.next;
            curr.next = null;
            newNode.next = curr;
            return newNode;
                
        }
        else{
            ListNode newNode = curr.next;
            curr.next = rSwap(curr.next.next);
            newNode.next = curr;
            return newNode;
        }
        
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head  == null){
            return null;
        }
        else {
            head = rSwap(head);
            return head;
        }
    }
}
