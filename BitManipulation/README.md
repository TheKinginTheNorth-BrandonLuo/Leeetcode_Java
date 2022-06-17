# 29. Divide Two Integers

# 136. Single Number--XOR ^
Bitwise XOR in java

  0 ^ N = N
  N ^ N = 0
 
So..... if N is the single number

N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

= 0 ^ 0 ^ ..........^ 0 ^ N

= N

# 137. Single Number II


# 231. Power of Two
n (in bits) -> 1 0 0 0 0 (16 is a power of 2 and thus has only one high bit)
n-1 (in bits) -> 0 1 1 1 1 ( n-1 i.e. 15 will make all bits high excpet the 5th bit)
n & n-1 -> 0 0 0 0 0 (& operation will make all the bits to 0, thus its power of 2)

# 287. Find the Duplicate Number

# 318. Maximum Product of Word Lengths

# 338. Counting Bits
