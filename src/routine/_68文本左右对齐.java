/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。
示例:

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
示例 2:

输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
示例 3:

输入:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/text-justification
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _68文本左右对齐 {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> wl = new ArrayList<>();
    Collections.addAll(wl, words);
    List<String> res = new ArrayList<>();
    while (!wl.isEmpty()) {
      // 拿到每一行的最大单词数量
      String[] wordEachLine = getWordEachLine(wl, maxWidth);
      // 获取当前行所有单词的总长度
      int len = getTotalWordsLen(wordEachLine);
      // 得到空格的长度
      int blankLen = maxWidth - len;

      // 如果是最后一行
      // 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
      if (wl.isEmpty() || wordEachLine.length == 1) {
        if (wordEachLine.length > 1) {
          for (int i = 0; i < wordEachLine.length - 1; i++) {
            wordEachLine[i] += " ";
            blankLen--;
          }
        }
        // 将空格全部拼接到最后一个单词后面
        for (int i = 0; i < blankLen; i++) {
          wordEachLine[wordEachLine.length - 1] += " ";
        }
      } else {
        // 不是最后一行的情况
        int pos = 0;
        while (pos < wordEachLine.length - 1 && blankLen > 0) {
          wordEachLine[pos] += " ";
          pos++;
          pos %= wordEachLine.length - 1;
          blankLen--;
        }
      }
      StringBuilder sb = new StringBuilder();
      for (String str : wordEachLine) {
        sb.append(str);
      }
      res.add(sb.toString());
    }
    return res;
  }

  // 获取当前行的单词总长度
  public int getTotalWordsLen(String[] list) {
    int len = 0;
    for (String s : list) {
      len += s.length();
    }
    return len;
  }

  // 获取当前行的最大单词数
  public String[] getWordEachLine(List<String> wl, int maxWidth) {
    List<String> list = new ArrayList<>();
    int len = 0;
    int count = 0;

    while (!wl.isEmpty() && len + wl.get(0).length() + count <= maxWidth) {
      String word = wl.remove(0);

      list.add(word);
      len += word.length();
      count++;
    }
    String[] arr = new String[list.size()];
    list.toArray(arr);
    return arr;
  }
}
