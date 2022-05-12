# -*- coding: utf-8 -*-
"""
Created on Sun May  8 21:20:06 2022

@author: Fan Luo
"""
"""
692. Top K Frequent Words

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
"""
import collections
import heapq

class Solution:
    def topKFrequent(self, words, k):
        count = collections.Counter(words)
        heap = [(-cnt, char) for char, cnt in count.items()]
        heapq.heapify(heap)
        return [heapq.heappop(heap)[1] for _ in range(k)]
    
class Solution2:
    def topKFrequent(self, words, k):
        count = collections.Counter(words)
        candidates = count.keys()
        res = sorted(candidates, key = lambda x: (-count[x], x))
        return res[:k]