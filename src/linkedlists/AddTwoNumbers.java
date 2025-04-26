package linkedlists;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (list1 != null || list2 != null) {
            int x = (list1 != null) ? list1.val : 0;
            int y = (list2 != null) ? list2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }

        if(carry != 0)
            current.next = new ListNode(carry);


        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(9);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(1);

        ListNode result = addTwoNumbers(list1, list2);

        // Print the result
        result.print();
    }
}
