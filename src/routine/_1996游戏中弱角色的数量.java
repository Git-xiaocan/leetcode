public class _1996游戏中弱角色的数量 {

  public int numberOfWeakCharacters(int[][] p) {
    Arrays.sort(p, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int max = p[p.length - 1][1];
    int count = 0;
    for (int i = p.length - 2; i >= 0; i--) {
      if (p[i][1] < max) count++;
      if (p[i][1] > max) max = p[i][1];
    }
    return count;
  }
}
