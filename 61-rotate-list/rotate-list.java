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
    public ListNode rotateRight(ListNode head, int k) {
        if(k== 0 || head == null || head.next == null){
            return head;
        }
        ListNode ptr = head;
        int size = 1;
        while(ptr.next != null){
            ptr = ptr.next;
            size++; 
        }
        int position = k%size;
        if(position == 0) return head;
        ListNode slow = head;
        for(int i = 0; i<size-position-1; i++){
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ptr.next = head;
        return newHead;
    }
}