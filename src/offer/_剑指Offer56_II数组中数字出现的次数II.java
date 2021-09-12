public class _剑指Offer56_II数组中数字出现的次数II {

  public int singleNumber(int[] nums) {
    int[] n1 = new int[32];
    for (int i = 0; i < nums.length; i++) {
      int mask = 1;
      for (int j = 31; j >= 0; j--) {
        int tmp = nums[i] & mask;
        if (tmp != 0) {
          n1[j] += 1;
        }
        mask <<= 1;
      }
    }
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res <<= 1;
      res += n1[i] % 3;
    }
    return res;
  }
}
