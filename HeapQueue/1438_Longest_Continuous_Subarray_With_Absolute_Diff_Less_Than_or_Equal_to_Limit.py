# -*- coding: utf-8 -*-
"""
Created on Wed Apr 13 19:45:23 2022

@author: Fan Luo
"""
"""
1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.
"""
from collections import deque
import unittest

class Solution:
    def longestSubarray(self, nums, limit):
        minQueue, maxQueue = deque(), deque()
        l, r = 0, 0
        res = 0
        
        while r < len(nums):
            while minQueue and nums[r] <= nums[minQueue[-1]]:
                minQueue.pop()
            while maxQueue and nums[r] >= nums[maxQueue[-1]]:
                maxQueue.pop()
            minQueue.append(r)
            maxQueue.append(r)
            #minQueue ->1,2,3
            #maxQueue ->0, 3
            
            while nums[maxQueue[0]] - nums[minQueue[0]] > limit:
                l += 1
                if l > minQueue[0]:
                    minQueue.popleft()
                if l > maxQueue[0]:
                    maxQueue.popleft()
                    
            res = max(res, r - l + 1)
            r += 1
            
        return res
    

class TestSolution(unittest.TestCase):
    def test_none_0(self):
        nums = [8,2,4,7]
        limit = 4
        self.assertTrue(Solution().longestSubarray(nums, limit))
        
if __name__ == "__main__":
    unittest.main()