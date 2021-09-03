import java.util.Arrays;

public class _剑指Offer_58_I翻转单词顺序 {

  public static String reverseWords(String s) {
    String[] str = s.trim().split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = str.length - 1; i >= 0; i--) {
      if ("".equals(str[i])) continue;
      if (i == 0) {
        sb.append(str[i]);
      } else {
        sb.append(str[i] + " ");
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "  hello world!  ";
    System.out.print("[");

    System.out.print(reverseWords(s));
    System.out.println("]");
  }
}
