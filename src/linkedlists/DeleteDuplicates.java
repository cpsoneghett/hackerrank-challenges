package linkedlists;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(3);

        list1 = deleteDuplicates(list1);

        list1.print();
    }
}
