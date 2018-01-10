package code.lint.nine.dynamic;

public class KnightShortestPathII {

    /*

    在一个 n * m 的棋盘中(二维矩阵中 0 表示空 1 表示有障碍物)，骑士的初始位置是 (0, 0) ，
    他想要达到 (n - 1, m - 1) 这个位置，骑士只能从左边走到右边。找出骑士到目标位置所需要走的最短路径并返回其长度，
    如果骑士无法达到则返回 -1.

    * Given a knight in a chessboard n * m (a binary matrix with 0 as empty and 1 as barrier).
    * the knight initialze position is (0, 0) and he wants to reach position (n - 1, m - 1),
    * Knight can only be from left to right. Find the shortest path to the destination position,
    * return the length of the route. Return -1 if knight can not reached.

Have you met this question in a real interview? Yes
Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x - 1, y + 2)
(x + 2, y + 1)
(x - 2, y + 1)
Example
[[0,0,0,0],
 [0,0,0,0],
 [0,0,0,0]]

Return 3

[[0,0,0,0],
 [0,0,0,0],
 [0,1,0,0]]

Return -1
    *
    * */

    /*
    * @param grid: a chessboard included 0 and 1
    * @return: the shortest path
    */
    public int shortestPath2(boolean[][] grid) {
        // write your code here

        int n = grid.length;
        if(n == 0){
            return -1;
        }

        int m = grid[0].length;
        if(m == 0){
            return -1;
        }

        int[][] f = new int[n][m];
        for (int i = 0; i < n; ++i ){
            for(int j = 0; j < m; ++j){
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        f[0][0] = 0;

        /**
        *
        * (x + 1, y + 2)
         (x - 1, y + 2)
         (x + 2, y + 1)
         (x - 2, y + 1)
        * */
        for(int j = 1; j < m; ++j){
            for(int i = 0; i < n; ++i){
                if(!grid[i][j]){
                    if(i >= 1 && j >= 2 && f[i-1][j-2] != Integer.MAX_VALUE){
                        f[i][j] = Math.min(f[i][j], f[i-1][j-2] + 1);
                    }
                    if(i + 1 < n && j >= 2 && f[i+1][j-2] != Integer.MAX_VALUE){
                        f[i][j] = Math.min(f[i][j], f[i+1][j-2] + 1);
                    }

                    if(i >= 2 && j >= 1 && f[i-2][j-1] != Integer.MAX_VALUE){
                        f[i][j] = Math.min(f[i][j], f[i-2][j-1] + 1);
                    }

                    if(i + 2 < n && j >= 1 && f[i + 2][j-1] != Integer.MAX_VALUE){
                        f[i][j] = Math.min(f[i][j], f[i+2][j-1] + 1);
                    }
                }
            }
        }

        if(f[n-1][m-1] == Integer.MAX_VALUE){
            return -1;
        }

        return f[n-1][m-1];
    }

    // Jiu Zhang's Answer

    /*
    *
    *  public int shortestPath2(boolean[][] grid) {
        // Write your code here
        int n = grid.length;
        if (n == 0)
            return -1;
        int m = grid[0].length;
        if (m == 0)
            return -1;

        int[][] f = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                f[i][j] = Integer.MAX_VALUE;

        f[0][0] = 0;
        for (int j = 1; j < m; ++j)
          for (int i = 0; i < n; ++i)
            if (!grid[i][j]) {
                if (i >= 1 && j >= 2 && f[i - 1][j - 2] != Integer.MAX_VALUE)
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 2] + 1);
                if (i + 1 < n && j >= 2 && f[i + 1][j - 2] != Integer.MAX_VALUE)
                    f[i][j] = Math.min(f[i][j], f[i + 1][j - 2] + 1);
                if (i >= 2 && j >= 1 && f[i - 2][j - 1] != Integer.MAX_VALUE)
                    f[i][j] = Math.min(f[i][j], f[i - 2][j - 1] + 1);
                if (i + 2 < n && j >= 1 && f[i + 2][j - 1] != Integer.MAX_VALUE)
                    f[i][j] = Math.min(f[i][j], f[i + 2][j - 1] + 1);
            }

        if (f[n - 1][m - 1] == Integer.MAX_VALUE)
            return -1;

        return f[n - 1][m - 1];
    }
    *
    * */

}
