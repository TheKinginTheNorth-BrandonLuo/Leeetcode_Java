# -*- coding: utf-8 -*-
"""
Created on Wed Mar 30 17:25:30 2022

@author: Fan Luo
"""
"""
778. Swim in Rising Water

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
"""
import heapq

class Solution:
    def swimInWater(self, grid):
        N = len(grid)
        visited = set()
        minHeap = [[grid[0][0], 0, 0]]
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        visited.add((0, 0))
        while minHeap:
            t, r, c = heapq.heappop(minHeap)
            # pop minimum t
            if r == N - 1 and c == N - 1:
                return t
            for dr, dc in directions:
                new_r, new_c = r + dr, c + dc
                if new_r < 0 or new_c < 0 or new_r == N or new_c == N or (new_r, new_c) in visited:
                    continue
                visited.add((new_r, new_c))
                heapq.heappush(minHeap, [max(t, grid[new_r][new_c]), new_r, new_c])