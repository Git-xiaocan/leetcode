/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int[] spiralOrder(int[][] matrix) {
      if(matrix.length==0||matrix[0].length==0) return new int[0];
        boolean[][] isVisit = new boolean[matrix.length][matrix[0].length];
        int[] res = new int[matrix.length * matrix[0].length];
          
        int count = 0;
        int col = 0, row = 0;
        int index = 0;
        // res[index++] = matrix[0][0];
        while (count < matrix.length * matrix[0].length) {


            //上
            while (count<matrix.length * matrix[0].length&&col > 0 && !isVisit[col][row]) {
                // System.out.println(matrix[col][row] + " ");
                isVisit[col][row] = true;
                res[index++] = matrix[col][row];
                count++;
                if (col - 1 > 0 && !isVisit[col - 1][row])
                    col--;
                else {
                    row++;
                    break;
                }
            }


            //右
            while (count<matrix.length * matrix[0].length&&row < matrix[0].length && !isVisit[col][row]) {
                // System.out.println(matrix[col][row] + " ");
                isVisit[col][row] = true;
                res[index++] = matrix[col][row];
                count++;
                if (row + 1 < matrix[0].length && !isVisit[col][row+1]) row++;
                else {
                    col++;
                    break;
                }

            }

            //下
            while (count<matrix.length * matrix[0].length&&col < matrix.length && !isVisit[col][row]) {
                // System.out.println(matrix[col][row] + " ");
                isVisit[col][row] = true;
                res[index++] = matrix[col][row];
                count++;
                if (col + 1 < matrix.length&& !isVisit[col+1][row])
                    col++;

                else {
                    row--;
                    break;
                }
            }

            //左
            while (count<matrix.length * matrix[0].length&&row >= 0 && !isVisit[col][row]) {
                // System.out.println(matrix[col][row] + " ");
                isVisit[col][row] = true;
                res[index++] = matrix[col][row];
                count++;
                if (row - 1 >= 0&& !isVisit[col][row-1])
                    row--;
                else {
                    col--;
                    break;
                }
            }


        }
        return res;


    }
}