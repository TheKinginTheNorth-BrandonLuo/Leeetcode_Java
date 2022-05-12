# -*- coding: utf-8 -*-
"""
Created on Thu Feb 17 20:43:06 2022

@author: Fan Luo
"""
"""
767. Reorganize String

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Input: s = "aab"
Output: "aba"
"""
from collections import Counter
import heapq

class Solution:
    def reorganizeString(self, s):
        count = Counter(s)
        maxHeap = [[-cnt, char] for char, cnt in count.items()]
        heapq.heapify(maxHeap)
        
        res = ""
        prev = None
        while maxHeap or prev:
            if not maxHeap and prev:
                return ""
            
            cnt, char = heapq.heappop(maxHeap)
            cnt += 1
            res += char
            
            if prev:
                heapq.heappush(maxHeap, prev)
                prev = None
                
            if cnt != 0:
                prev = [cnt, char]
        return res
    
if __name__ == '__main__':
    s = "baaba"
    print(Solution().reorganizeString(s))