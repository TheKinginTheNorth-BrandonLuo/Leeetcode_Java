# -*- coding: utf-8 -*-
"""
Created on Tue Apr  5 15:14:25 2022

@author: Fan Luo
"""
"""
1584. Min Cost to Connect All Points

You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
"""
import heapq

class Solution:
    def minCostConnectPoints(self, points):
        N = len(points)
        
        adjMap = {i: [] for i in range(N)}
        
        for i in range(N):
            x1, y1 = points[i]
            for j in range(i + 1, N):
                x2, y2 = points[j]
                dist = abs(x1 - x2) + abs(y1 - y2)
                adjMap[i].append([dist, j])
                adjMap[j].append([dist, i])
                
        res = 0
        minHeap = [[0, 0]]
        visited = set()
        
        while len(visited) < N:
            cost, i = heapq.heappop(minHeap)
            if i in visited:
                continue
            res += cost
            visited.add(i)
            for neiCost, nei in adjMap[i]:
                if nei not in visited:
                    heapq.heappush(minHeap, [neiCost, nei])
                    
        return res