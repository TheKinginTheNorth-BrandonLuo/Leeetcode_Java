class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        int highEnough = max - extraCandies;
        
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy >= highEnough);
        }
        
        return res;
    }
}
