class Solution:

    # @param {boolean[][]} grid a chessboard included 0 and 1
    # @return {int} the shortest path
    def shortestPath2(self, grid):
        # Write your code here
        n = len(grid)
        if n == 0:
            return -1

        m = len(grid[0])
        if m == 0:
            return -1
        import sys
        f = [ [sys.maxsize for j in range(m)] for _ in range(n)]

        f[0][0] = 0
        for j in range(m):
            for i in range(n):
                if not grid[i][j]:
                    if i >= 1 and j >= 2 and f[i - 1][j - 2] != sys.maxsize:
                        f[i][j] = min(f[i][j], f[i - 1][j - 2] + 1)
                    if i + 1 < n and j >= 2 and f[i + 1][j - 2] != sys.maxsize:
                        f[i][j] = min(f[i][j], f[i + 1][j - 2] + 1)
                    if i >= 2 and j >= 1 and f[i - 2][j - 1] != sys.maxsize:
                        f[i][j] = min(f[i][j], f[i - 2][j - 1] + 1)
                    if i + 2 < n and j >= 1 and f[i + 2][j - 1] != sys.maxsize:
                        f[i][j] = min(f[i][j], f[i + 2][j - 1] + 1)

        if f[n - 1][m - 1] == sys.maxsize:
            return -1

        return f[n - 1][m - 1]