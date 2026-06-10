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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
        {
            return null;

        }
        ArrayList<ListNode> odd=new ArrayList<>();
        ArrayList<ListNode> even=new ArrayList<>();
        ListNode temp=head;
        int pos=1;
        while(temp!=null)
        {
            if(pos%2==1)
            {
                odd.add(temp);
            }
            else{
                even.add(temp);
            }
            temp=temp.next;
            pos++;
        }
 ArrayList<ListNode> all=new ArrayList<>();
 all.addAll(odd);
 all.addAll(even);
 for(int i=0;i<all.size()-1;i++)
 {
    all.get(i).next=all.get(i+1);
 }
 all.get(all.size()-1).next=null;
 return all.get(0);
    }
}