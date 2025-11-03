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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null) return true;
        while(  fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf  = head;
        while(secondHalf != null){
            if(secondHalf.val != firstHalf.val) return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
        
    }
    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current; 
            current = nextNode;
        } 
        return prev;
    }
}