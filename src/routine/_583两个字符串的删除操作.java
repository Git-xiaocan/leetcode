class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        int [][] dp = new int[m+1][n+1];
        
        for(int i =1;i< dp.length;i++ ){
            char ch = w1[i-1];
            for(int j = 1;j<dp[i].length;j++){
                char ch2 = w2[j-1];
                if(ch2==ch){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }

        }
        // System.out.println(dp[m][n]);
        return m+n - dp[m][n]*2;

    }
}