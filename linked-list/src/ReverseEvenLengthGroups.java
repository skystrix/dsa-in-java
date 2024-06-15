public class ReverseEvenLengthGroups {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode reverseList(ListNode head, int length) {
        ListNode prev = null;
        ListNode current = head;
        while (length > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            length--;
        }
        return prev;
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        ListNode current = head;
        int groupLength = 1;

        while (current != null) {
            ListNode groupStart = current;
            int count = 0;
            // Find the end of the current group
            while (current != null && count < groupLength) {
                current = current.next;
                count++;
            }

            // If the group length is even, reverse the group
            if (count % 2 == 0) {
                ListNode nextGroupStart = current;
                prevGroupEnd.next = reverseList(groupStart, count);
                groupStart.next = nextGroupStart;
                prevGroupEnd = groupStart;
            } else {
                // Move prevGroupEnd to the end of the current group
                prevGroupEnd = groupStart;
                while (count > 1) {
                    prevGroupEnd = prevGroupEnd.next;
                    count--;
                }
            }
            groupLength++;
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        // 1 2 3 4 5

        ListNode six = new ListNode(6, null);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode newHead = reverseEvenLengthGroups(one);
        System.out.println(" ");
        while(newHead != null){
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
    }
}
