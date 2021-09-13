class Solution {
    public int[] constructArr(int[] a) {
        int [] b= new int[a.length];

      for(int i =0,cur =1 ;i < a.length;i++){
        b[i] =cur;
        cur=cur*a[i];
      }
      for(int i = a.length-1,cur=1;i>=0;i--){
          b[i] = b[i]*cur;
          cur=a[i]*cur;
      }
      return b;

    }
}