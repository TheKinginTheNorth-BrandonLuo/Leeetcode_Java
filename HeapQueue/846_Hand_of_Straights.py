# -*- coding: utf-8 -*-
"""
Created on Thu May  5 21:08:52 2022

@author: Fan Luo
"""
"""
846. Hand of Straights

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
"""
import heapq

class Solution:
    def isNStraightHand(self, hand, groupSize):
        if len(hand) % groupSize != 0:
            return False
        
        count = {}
        for i in hand:
            count[i] = count.get(i, 0) + 1
            
        minHeap = list(count.keys())
        heapq.heapify(minHeap)
        
        while minHeap:
            start = minHeap[0]
            for i in range(start, start + groupSize):
                if i not in count:
                    return False
                count[i] -= 1
                if count[i] == 0:
                    if i != minHeap[0]:
                        return False
                    heapq.heappop(minHeap)
                    
        return True