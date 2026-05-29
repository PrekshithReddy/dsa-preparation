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
    public ListNode deleteMiddle(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            size++;
        }
        int i=1;
        int middleIndex=size/2;
        if(middleIndex==0)
        {
            head=head.next;
            return head;
        }
        ListNode prev=head;
        while(i<middleIndex)
        {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;

    return head;
    }
}