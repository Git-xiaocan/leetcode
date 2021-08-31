import java.util.Arrays;
/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
提示：s.length <= 40000
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public  class _剑指Offer_48_最长不含重复字符的子字符串 {

  public  int lengthOfLongestSubstring(String s) {
    int[] hashMap = new int[128];
    int res = 0;
    int start = 0;
    Arrays.fill(hashMap, -1);
    int end=0;
    for (; end < s.length(); end++) {
      char ch = s.charAt(end);
      //如果当前字符的下标的值比start大 与当前在字符串重复的字符串在start与end之间
      if (hashMap[ch] >= start) {
        res = Math.max(res, end - start);
        //将头指针start移动到与当前字符重复的下一个字符
        start=hashMap[ch]+1;
      }
      //记录当前字符的下标
      hashMap[ch] = end;
    }
    //从start位置到字符串最后都没有发现重复的字符
    return Math.max(res,end-start); 
  }
}
