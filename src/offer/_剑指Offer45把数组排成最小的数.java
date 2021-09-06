
import java.util.Arrays;
import java.util.Comparator;

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
