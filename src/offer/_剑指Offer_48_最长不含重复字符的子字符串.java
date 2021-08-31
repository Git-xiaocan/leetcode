import java.util.Arrays;

public class _剑指Offer_48_最长不含重复字符的子字符串 {

  public static int lengthOfLongestSubstring(String s) {
    int[] hashMap = new int[128];
    int res = 0;
    int start = 0;
    Arrays.fill(hashMap, -1);
    int i = 0;
    for (; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (hashMap[ch] >= start) {
        res = Math.max(res, i - start);
        start = hashMap[ch] + 1;
      }
      hashMap[ch] = i;
    }
    return Math.max(res, i - start);
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dvdf"));
  }
}
