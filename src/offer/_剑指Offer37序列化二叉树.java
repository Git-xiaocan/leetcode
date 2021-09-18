

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

 

示例：


输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
        
            TreeNode node = q.poll();
            
            if(node!=root) sb.append(",");
            if(node!=null){
            sb.append(node.val);
            q.offer(node.left);
            q.offer(node.right);
            }else{
                sb.append("null");
            }
        }
       String [] str =  sb.toString().split(",");
       int len =0;
       for(int i =str.length-1;i>=0;i--){
           if(!"null".equals(str[i])) break;
           len+=str[i].length()+1;

       }

      String res =  sb.substring(0,sb.length()-len);

        return res+']';
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<=2) return null;
        String [] nodes  =  data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1,j=2;i<nodes.length;i+=2,j+=2){
            TreeNode p = q.poll();
            if(i<nodes.length&&!"null".equals(nodes[i])){
                p.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(p.left);

            }
            if(j<nodes.length&&!"null".equals(nodes[j])){
                p.right = new TreeNode(Integer.parseInt(nodes[j]));
               q.offer(p.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));