

/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
class _528_按权重随机选择 {
    private int[] pro;

    public _528_按权重随机选择(int[] w) {
        pro = new int[w.length];
        pro[0] = w[0];
        for (int i = 1; i < pro.length; i++) {
            pro[i] = pro[i - 1] + w[i];
        }
    }
    public int pickIndex() {
        int left = 0, right = pro.length;
        int t = (int) (Math.random() * pro[pro.length-1]) +1;
        if(t<=pro[0]||pro.length<=1) return 0;
        int mid =-1;
        // System.out.println(Arrays.toString(pro) + " " +t);
        while(left<right){
        mid = left +(right-left)/2;
         if(t <= pro[mid]){
                right=mid;
            }else {
                left=mid+1;
            }
        }

        
        

        return left;
    }
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("hello world");
        
    }

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */
// @lc code=end
