/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _剑指Offer_22链表中倒数第k个节点 {

  public ListNode getKthFromEnd(ListNode head, int k) {
    if (head == null) return null;
    ListNode h = reverse(head);
    ListNode curr = h;
    for (int i = 1; i < k; i++) {
      curr = curr.next;
    }
    curr.next = null;
    return reverse(h);
  }

  public ListNode reverse(ListNode node) {
    if (node.next == null) return node;
    ListNode currNode = reverse(node.next);
    node.next.next = node;
    node.next = null;
    return currNode;
  }

  //解法二
  public static ListNode getKthFromEnd1(ListNode head, int k) {
    ListNode p = head;
    ListNode q = head;
    for (int i = 0; i < k; i++) {
      p = p.next;
    }
    while (p != null) {
      p = p.next;
      q = q.next;
    }
    return q;
  }

  //解法三
  class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
      ListNode reversed = reverse(head);
      ListNode res = reversed;
      for (int i = 1; i < k; i++) {
        res = res.next;
      }
      reverse(reversed);
      return res;
    }

    public ListNode reverse(ListNode node) {
      if (node.next == null) return node;
      ListNode last = reverse(node.next);
      node.next.next = node;
      node.next = null;
      return last;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    ListNode curr = getKthFromEnd1(l1, 2);
    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
