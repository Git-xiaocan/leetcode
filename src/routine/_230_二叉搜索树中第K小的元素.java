/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
示例 1：
输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3
提示：
树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    Stack<TreeNode> stack;
    public int kthSmallest(TreeNode root, int k) {
        stack = new Stack<>();
        Order(root);
        while(k-- > 1) stack.pop(); 
        return stack.pop().val;
    }
    public void Order(TreeNode node ){
        if(node == null) return ;
        Order(node.right);
        stack.push(node);
        Order(node.left);
 
    }
    
}