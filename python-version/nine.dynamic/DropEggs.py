
# @param {int} n an integer
# @return {int} an integer
def dropEggs(n):
    # Write your code here
    import math
    x = int(math.sqrt(n * 2))
    while x * (x + 1) / 2 < n:
        x += 1
    return x

n = 100

print(dropEggs(100))
