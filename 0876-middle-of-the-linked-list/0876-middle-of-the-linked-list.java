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
             public ListNode middleNode(ListNode head) {
                int size=0;
                ListNode temp=head;
                while(temp!=null)
                {
                    temp=temp.next;
                    size++;
                }
                int middleIndex=(size/2)+1;
                int i=1;
                while(i<middleIndex)
                {
                    head=head.next;
                    i++;
                }
                return head;
                         }
                         }