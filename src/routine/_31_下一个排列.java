/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

 

示例 1：

输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：

输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：

输入：nums = [1,1,5]
输出：[1,5,1]
示例 4：

输入：nums = [1]
输出：[1]
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public void nextPermutation(int[] nums) {
        //如果序列完全降序排列  
        boolean flag = true;
        for(int i =1 ;i < nums.length;i++){
            if(nums[i]>nums[i-1]){
                flag = false;
                break;
            }
        }
        if(flag) {
            Arrays.sort(nums);
        }else{
            int k =-1;
            for(int i =nums.length-1;i>0;i--){
                if(nums[i-1]<nums[i]) {
                    k = i-1;break;
                }
            }
            int  j =nums.length-1;
            while(nums[j]<=nums[k]){
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
            Arrays.sort(nums,k+1,nums.length);
            return ;
        }


        
    }
}