
"""
Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
"""


class Solution:
    """
    @param: root: the root of binary tree
    @return: the length of the longest consecutive sequence path
    """

    def longestConsecutive(self, root):
        self.longest = 0
        self.helper(root)
        return self.longest

    def helper(self, root):

        if root == None:
            return 0

        left = self.helper(root.left)
        right = self.helper(root.right)

        subLongest = 1
        if root.left != None and root.val + 1 == root.left.val:
            subLongest = max(subLongest, left + 1)
        if root.right != None and root.val + 1 == root.right.val:
            subLongest = max(subLongest, right + 1)
        if subLongest > self.longest:
            self.longest = subLongest

        return subLongest