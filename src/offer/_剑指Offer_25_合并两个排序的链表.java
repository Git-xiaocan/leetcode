/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 100
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _剑指Offer_25_合并两个排序的链表 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode head = new ListNode(0);
    ListNode currl1 = l1;
    ListNode currl2 = l2;
    ListNode currHead = head;
    while (currl1 != null && currl2 != null) {
      if (currl1.val < currl2.val) {
        currHead.next = currl1;
        currHead = currHead.next;

        currl1 = currl1.next;
      } else {
        currHead.next = currl2;
        currHead = currHead.next;
        currl2 = currl2.next;
      }
    }
    if (currl1 != null) {
      currHead.next = currl1;
    }
    if (currl2 != null) {
      currHead.next = currl2;
    }
    return head.next;
  }
}
