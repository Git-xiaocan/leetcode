public class _剑指Offer_46_把数字翻译成字符串 {

  public static int translateNum(int num) {
    String numString = num + "";
    int[] dp = new int[numString.length()+1];
    dp[0] =dp[1]= 1;
    for (int i = 2; i < dp.length; i++) {
      int curNum = Integer.parseInt(numString.substring(i - 2, i ));
      if (curNum > 9 && curNum < 26) {
        dp[i] = dp[i - 1] + dp[i-2];
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(translateNum(12258));
  }
}
