# @param {int} m the number of eggs
# @param {int} n the umber of floors
# @return {int} the number of drops in the worst case
def dropEggs2(m, n):
    # Write your code here
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(1, m + 1):
        dp[i][1] = 1
        dp[i][0] = 0
    for i in range(1, n + 1):
        dp[1][i] = i
    import sys
    for i in range(2, m + 1):
        for j in range(2, n + 1):
            # import struct
            # platform_c_maxint = 2 ** (struct.Struct('i').size * 8 - 1) - 1
            # module 'sys' has no attribute 'maxint'
            dp[i][j] = sys.maxsize
            for k in range(1, j + 1):
                dp[i][j] = min(dp[i][j], 1 + max(dp[i - 1][k - 1], dp[i][j - k]))
    return dp[m][n]

print(dropEggs2(6, 100))