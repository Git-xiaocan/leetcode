/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 

示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    Set<String> set ;
    public List<List<Integer>> permuteUnique(int[] nums) {
         set = new HashSet<>();
         f(nums,0,nums.length);
         List<List<Integer>> res= new ArrayList<>();
         for(String s : set){
             List<Integer> list = new ArrayList<>();
             String[] strs   = s.trim().split(" ");
             for(int i =0 ;i < strs.length;i++){
                 list.add(Integer.parseInt(strs[i]));
             }
             res.add(list);
         }
         return res;

    }
    public void swap(int []arr ,int a ,int b ) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
    }
    public void f(int[] arr ,int l ,int r ){
        if( l == r) {
            String s = "";
            for(int n : arr) s += " "+n;
            set.add(s);
        }else {
            for(int i = l ;i < r ;i++) {
                swap(arr,l,i);
                f(arr,l+1,r);
                swap(arr,l,i);
                

            }
        }
    }
}