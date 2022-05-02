class Solution {
    public double angleClock(int hour, int minutes) {
        double hour_hand = 30 * hour + 0.5 * minutes;
        double minute_hand= 6 * minutes;
        double diff = Math.abs(hour_hand - minute_hand);
        if (diff > 180) {
            diff = 360.0 - diff;
        }
        return diff;
    }
}
