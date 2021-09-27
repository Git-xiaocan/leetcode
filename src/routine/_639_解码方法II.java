class Solution {
    static final int mod = 1000000007;

  public  static  int numDecodings(String s) {
      int len = s.length();
      long[] dp = new long[len + 1];
      dp[0] = 1;

      for (int i = 1; i < dp.length; i++) {
          char ch = s.charAt(i - 1);

          //如果当前字符串为*   可能有下列几种情况种情况
          if (ch == '*') {
              //只作为单独一个星号使用 可以作为1-9的任意数字
              dp[i] = (dp[i] + dp[i - 1] * 9) % mod;
              //如果当前字符的前一个字符为1  说明为11- 19
              if (i > 1) {
                  char ch2 = s.charAt(i - 2);
                  if (ch2 == '1') {
                      dp[i] = (dp[i] + dp[i - 2] * 9) % mod;
                  } else if (ch2 == '2') {
                      dp[i] = (dp[i] + dp[i - 2] * 6) % mod;
                  } else if (ch2 == '*') {
                      //如果当前字符的前一个字符为*   则 可以表示 11- 26;
                      dp[i] = (dp[i] + dp[i - 2] * 15) % mod;
                  }

              }

          }else {
              //当前字符不为*   可以有两种状态
              if (ch != '0') {
                  //当前字符不为0则可以当做一位数使用
                  dp[i] = (dp[i] + dp[i - 1]) % mod;
              }
            
              if (i >= 2) {  
                  //当做最后两位的第一位使用
                  char ch2 = s.charAt(i - 2);
                  if (ch2 != '*') {
                      int val = (ch2 - '0') * 10 + (ch - '0');
                      if (val >= 10 && val <= 26)
                          dp[i] = (dp[i] + dp[i - 2]) % mod;
                  } else {
                      //当当前字符前一位 为* 时
                      //并且当前字符大于等于7时 说明前面只能为1
                      if (ch >= '7') {
                          dp[i] = (dp[i] + dp[i - 2]) % mod;
                      } else {
                          //当当前字符不大于7则 前面的* 有两种情况 分别为2 和 1
                          dp[i] = (dp[i] + dp[i - 2] * 2) % mod;
                      }
                  }


              }


          }

      }

      return (int)dp[len];

  }
}