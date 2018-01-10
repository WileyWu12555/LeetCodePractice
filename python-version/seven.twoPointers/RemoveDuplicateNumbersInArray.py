import sys

# O(n) time, O(n) space
# from builtins import *

# from pip._vendor.requests.packages.urllib3.connectionpool import xrange


class Solution:
    # @param {int[]} nums an array of integers
    # @return {int} the number of unique integers
    def deduplication(self, nums):
        # Write your code here
        d, result = {}, 0
        for num in nums:
            if num not in d:
                d[num] = True
                nums[result] = num
                result += 1

        return result

# O(nlogn) time, O(1) extra space
class Solution:
    # @param {int[]} nums an array of integers
    # @return {int} the number of unique integers
    def deduplication(self, nums):
        # Write your code here
        n = len(nums)
        if n == 0:
            return 0

        nums.sort()
        result = 1
        # for i in xrange(1, n):
        for i in range(1, n):
            if nums[i - 1] != nums[i]:
                nums[result] = nums[i]
                result += 1

        return result
