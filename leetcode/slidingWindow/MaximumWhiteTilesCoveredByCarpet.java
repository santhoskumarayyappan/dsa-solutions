//15-05-2022
//https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int len) {
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
        int curLast = tiles[0][0] + len - 1;                                                                     // right Side Boundary (inclusive)
        int currentTilesCovered = Math.min(tiles[0][1], curLast) - tiles[0][0] + 1;
        int maxTilesCovered = currentTilesCovered;
        int j = 0;                                                                                               // index of leftmost interval of window
        for (int i = 1; i < tiles.length; i++) {
                                                                                                                 // move the left boundary till the current interval i is covered in the window
            while (j <= i && curLast < tiles[i][0]) { 
                currentTilesCovered -= tiles[j][1] - tiles[j][0] + 1;                                            // removing leftmost interval covered in the window
                j++; 
                currentTilesCovered -= Math.min(tiles[i - 1][1], curLast) - tiles[i - 1][0] + 1;                 // removing partial (or full) interval covered at right side of window
                int prevLast = curLast;
                curLast = tiles[j][0] + len - 1;                                                                 // calculating new right side boundary as we moved window by 1 interval in left Side
                currentTilesCovered += Math.min(tiles[i - 1][1], curLast) - tiles[i - 1][0] + 1;                 // adding new partial (or full) interval covered at right side of window
                maxTilesCovered = Math.max(maxTilesCovered, currentTilesCovered);
            }
                                                                                                                 // now as interval i is covered in the window calculate the covered interval
            currentTilesCovered += Math.min(tiles[i][1], curLast) - tiles[i][0] + 1;
            maxTilesCovered = Math.max(maxTilesCovered, currentTilesCovered);          
        }
        return maxTilesCovered;
    }
}
