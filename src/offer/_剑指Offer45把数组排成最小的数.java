
import java.util.Arrays;
import java.util.Comparator;
/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数
 * 打印能拼接出的所有数字中最小的一个。


示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _剑指Offer45把数组排成最小的数 {
    public static String minNumber(int [] nums) {

        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = nums[i] + "";
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String item : str) sb.append(item);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(minNumber(arr));
    }
}
