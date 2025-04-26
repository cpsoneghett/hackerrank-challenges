package linkedlists;

public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode res = new ListNode(0, head);
        ListNode cur = res;

        for (int i = 0; i < n; i++)
            head = head.next;

        while (head != null) {
            head = head.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return res.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        list1.print();
        removeNthFromEnd(list1, 2).print();
    }

}
