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
