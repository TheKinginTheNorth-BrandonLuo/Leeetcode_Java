class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] newArr = new int[flowerbed.length + 2];
        newArr[0] = 0;
        newArr[newArr.length - 1] = 0;
        
        for (int i = 0; i < flowerbed.length; i ++) {
            newArr[i + 1] = flowerbed[i];
        }
        
        for (int i = 1; i < newArr.length - 1; i ++) {
            if (newArr[i - 1] == 0 && newArr[i] == 0 && newArr[i + 1] == 0) {
                newArr[i] = 1;
                n -= 1;
            }
        }
        return n <= 0;
    }
}
