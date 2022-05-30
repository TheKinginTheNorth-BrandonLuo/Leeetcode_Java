## 39. Combination Sum is similar to 113
Notice two things: when adding list to list of lists, we need to reference its datatype
Also each time finish backtracking we need to remove current container for next search

## Difference between 40. Combination Sum II && 39. Combination Sum
In 40 we need avoid duplicate cases. That's the biggest difference which need to start new backtrack from i + 1 rather i itself. Beside, take example 2 as example, we have [1,1,2,5,6,7,10] and target is 8. When we did first 1 when have [1,1,6], [1,2,5],[1,7]. We need to skip the second 1 since it was same with first and with result in duplicate [1,2,5]...again.

## 47. Permutations II and 46
The biggest difference is also removing duplicates. We need to use same way as above, ie, after sorting array(most important), we need to check if i > 0 and nums[i] == nums[i - 1], also boolean[i] == false

## 282. Expression Add Operators
Trick of reset--StringBuilder.setLength(previous recorded length) to clear string so far and do next operation
