# -*- coding: utf-8 -*-
"""
Created on Mon Apr 18 14:59:15 2022

@author: Fan Luo
"""
"""
987. Vertical Order Traversal of a Binary Tree

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
"""
import collections
import heapq

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def verticalTraversal(self, root):
        vMap = collections.defaultdict(list)
        
        def traverse(node, col, row):
            if not node:
                return
            
            vMap[col].append((row, node.val))
            traverse(node.left, col - 1, row + 1)
            traverse(node.right, col + 1, row + 1)
            
        traverse(root, 0, 0)
        
        # vMap: {0: [(0, 3), (2, 15)], -1: [(1, 9)], 1: [(1, 20)], 2: [(2, 7)]})
        heap, res = [], []
        
        for col, lst in vMap.items():
            heapq.heappush(heap, (col, sorted(lst)))
            
        while heap:
            res.append([v for _, v in heapq.heappop(heap)[1]])
            
        return res