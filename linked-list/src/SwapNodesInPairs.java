package src;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null && current.next != null) {
            // Nodes to be swapped
            ListNode first = current;
            ListNode second = current.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move pointers
            prev = first;
            current = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode six = new ListNode(6, null);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode newHead = swapPairs(one);
        System.out.println(" ");
        while(newHead != null){
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
        System.out.print("null");
    }
}
