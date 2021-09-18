/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        f(0,s.length(),s.toCharArray(),set);
        String [] strs = new String[set.size()];
        set.toArray(strs);
        return strs;

    }
    public void f(int i,int j,char [] chs,Set<String> set){
        if(j-i==1){
          set.add(String.valueOf(chs));
        }else{
            for(int k = i;k<j;k++){
                swap(chs,i,k);
                f(i+1,j,chs,set);
                swap(chs,i,k);
            }
        }
    }
    public void swap(char[] chs,int i,int j){
        char ch = chs[i];
        chs[i] = chs[j];
        chs[j]=ch;
    }
      

}