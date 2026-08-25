class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = length(l1);
        int len2 = length(l2);

        ListNode head;

        if (len1 >= len2) {
            head = add(l1, l2, len1 - len2);
        } else {
            head = add(l2, l1, len2 - len1);
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }

        return head;
    }

    int carry = 0;

    public ListNode add(ListNode l1, ListNode l2, int diff) {

        if (l1 == null)
            return null;

        ListNode next;

        if (diff > 0) {
            next = add(l1.next, l2, diff - 1);

            int sum = l1.val + carry;

            ListNode node = new ListNode(sum % 10);
            node.next = next;

            carry = sum / 10;

            return node;
        } else {
            next = add(l1.next, l2.next, 0);

            int sum = l1.val + l2.val + carry;

            ListNode node = new ListNode(sum % 10);
            node.next = next;

            carry = sum / 10;

            return node;
        }
    }

    public int length(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}