class Solution {
    public int getSum(int a, int b) {
        // 1. 用二进制表示两个加数，a=5=0101，b=4=0100；
        // 2. 用and（&）操作得到所有位上的进位carry=0100;
        // 3. 用xor（^）操作找到a和b不同的位，赋值给a，a=0001；
        // 4. 将进位carry左移一位，赋值给b，b=1000；
        // 5. 循环直到进位carry为0，此时得到a=1001，即最后的sum
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}
