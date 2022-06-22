class Solution {
    public boolean isRobotBounded(String instructions) {
        int dirX = 0, dirY = 1;
        int x = 0, y = 0;
        
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x = x + dirX;
                y = y + dirY;
            }
            else if (c == 'L') {
                // (0, 1) -> (-1, 0)
                int tmp = dirX;
                dirX = -1 * dirY;
                dirY = tmp;
            }
            else {
                int tmp = dirX;
                dirX = dirY;
                dirY = -1 * tmp;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        if (dirX == 0 && dirY == 1) {
            return false;
        }
        return true;
    }
}
