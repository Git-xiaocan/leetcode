/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 

提示：

节点总数 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _剑指Offer34二叉树中和为某一值的路径 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        find(root,new ArrayList<Integer>(),list,target,0);
        return list;
       

    }
    public void  find(TreeNode node ,List<Integer> list ,List<List<Integer>> allRes,int target,int currNum){
        if(node==null) return;
        List<Integer> currList = new ArrayList<Integer>(list);
    currList.add(node.val);
       
        if(currNum+node.val==target&&(node.left==null&&node.right==null)){
           allRes.add(currList);
           return ;
       }else if(currNum+node.val==target&&!(node.left==null&&node.right==null)){
           return;
       }
         
 
            find(node.left,currList,allRes,target,currNum+node.val);

            find(node.right,currList,allRes,target,currNum+node.val);

        

    
    }
    
}

    
}
