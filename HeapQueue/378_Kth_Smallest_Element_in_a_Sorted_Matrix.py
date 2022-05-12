# -*- coding: utf-8 -*-
"""
Created on Thu Apr  7 15:32:43 2022

@author: Fan Luo
"""
"""
378. Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).
"""
import heapq

class Solution:
    def kthSmallest(self, matrix, k):
        ROWS, COLS = len(matrix), len(matrix[0])
        maxHeap = []
        
        for r in range(ROWS):
            for c in range(COLS):
                heapq.heappush(maxHeap, -matrix[r][c])
                if len(maxHeap) > k:
                    heapq.heappop(maxHeap)
                    
        return -heapq.heappop(maxHeap)
                