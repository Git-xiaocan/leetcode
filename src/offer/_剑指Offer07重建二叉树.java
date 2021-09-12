import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _剑指Offer07重建二叉树 {

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
      Map<Integer,Integer > map = new HashMap<>();
      for(int i= 0;i < inorder.length;i++){
          map.put(inorder[i], i);
      }
      return build(preorder, inorder, map);
    
  }
  public TreeNode build (int[] preorder, int[] inorder,Map<Integer,Integer> map){
      // 前序遍历的跟节点在前面
    // 中序遍历的根节点左边的全部在全部在左子树
    int n = preorder.length;
    if (n == 0) return null;
    int rootVal = preorder[0];
    int rootIndex = map.get(rootVal);
    TreeNode root = new TreeNode(rootVal);
    root.left =buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex),Arrays.copyOfRange(inorder, 0, rootIndex));
    root.right =
      buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length),Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
    return root;

  }

}
