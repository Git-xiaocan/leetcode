public class _剑指Offer_52_两个链表的第一个公共节点 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode n1 = headA;
    ListNode n2 = headB;
    while (n1 != n2) {
      n1 = n1 == null ? headB : n1.next;
      n2 = n2 == null ? headA : n2.next;
    }
    return n1;
  }
}
