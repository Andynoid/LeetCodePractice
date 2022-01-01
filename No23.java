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
class Solution {
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
        
    }
    
    private ListNode[] arraySlice(ListNode[] input, int start, int end){
        ListNode[] slice = new ListNode[end - start];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = input[start + i];
        }
        return slice;
    }
    
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        else if (lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        else {
            ListNode head1 = mergeKLists(arraySlice(lists, 0, lists.length/2)  );
            ListNode head2 = mergeKLists(arraySlice(lists, lists.length/2, lists.length) );
            return mergeTwoLists(head1,head2);
        }
        
    }
    
}
