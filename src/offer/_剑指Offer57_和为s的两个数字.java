import java.util.Arrays;

import java.util.HashSet;

public class _剑指Offer57_和为s的两个数字 {

  public static  int[] twoSum(int[] nums, int target) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        if(set.contains(target-nums[i])){
            return new int[]{nums[i],target-nums[i]};
        }
        set.add(nums[i]);
    }

    return null;
  }
  //解法二
  public static  int[] twoSum1(int[] nums, int target) {
    int left = 0,right = nums.length-1;
    while(left<right){
        if(nums[left]+nums[right]==target) return new int[]{nums[left],nums[right]};
        if(nums[left]+nums[right]<target) left++;
        if(nums[left]+nums[right]>target) right--;
    
    }

    return null;
  }
  public static void main(String[] args) {
      int[] arr={2,7,11,15};
        System.out.println(Arrays.toString( twoSum1(arr,9)));
  }
}
