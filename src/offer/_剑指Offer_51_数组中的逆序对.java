/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 

示例 1:

输入: [7,5,6,4]
输出: 5


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        return (int)mergeSort(nums,0,nums.length-1);

    }
    public long mergeSort(int [] arr , int l ,int r){
        if(l >= r ) return 0 ;
        int mid = l + r >> 1 ;
        long res = mergeSort(arr ,l , mid) + mergeSort(arr ,mid + 1,r);
        int i = l ,j  =  mid + 1 , k = 0;
        while (i <=  mid && j <= r ){
            if(arr[i] <= arr[j])  tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                res += mid - i + 1 ;
            }
        }
        while(i <= mid) tmp[k++]  = arr[i++];
        while(j <= r) tmp[k++] = arr[j++]; 
        for( i = l,j = 0;i<=r;i++,j++){
            arr[i] =tmp[j];
        }
        return res;

    }
}