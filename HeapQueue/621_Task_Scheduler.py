# -*- coding: utf-8 -*-
"""
Created on Fri Mar 18 15:19:13 2022

@author: Fan Luo
"""
"""
621. Task Scheduler

Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
"""
import collections
import heapq

class Solution:
    def leastInterval(self, tasks, n):
        count = collections.Counter(tasks)
        maxHeap = [-cnt for cnt in count.values()]
        heapq.heapify(maxHeap)
        total_time = 0
        queue = collections.deque()
        
        while queue or maxHeap:
            total_time += 1
            if maxHeap:
                cnt = 1 + heapq.heappop(maxHeap)
                if cnt != 0:
                    queue.append([cnt, total_time + n])
            if queue and queue[0][1] == total_time:
                heapq.heappush(maxHeap, queue.popleft()[0])
        
        return total_time