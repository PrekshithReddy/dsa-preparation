class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;
        int first = -1;
        int last = -1;

        int min = Integer.MAX_VALUE;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (first != -1) {
                    min = Math.min(min, index - last);
                }

                if (first == -1) {
                    first = index;
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (first != -1 && first != last) {
            ans[0] = min;
            ans[1] = last - first;
        }

        return ans;
    }
}