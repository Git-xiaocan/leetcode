public class _5最长回文子串 {

  public String longestPalindrome(String s) {
    if (s.length() <= 1) return s;
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      int left = i;
      int right = i;
      while (
        left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
      ) {
        if (right - left + 1 > res.length()) {
          res = s.substring(left, right + 1);
        }
        left--;
        right++;
      }
      left = i;
      right = i + 1;
      while (
        left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
      ) {
        if (right - left + 1 > res.length()) {
          res = s.substring(left, right + 1);
        }
        left--;
        right++;
      }
    }
    return res;
  }
}
