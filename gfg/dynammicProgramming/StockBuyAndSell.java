//
import java.io.*;
import java.util.*;

class GFG {
class Solution {
    class Interval {
        int buy, sell;
        Interval(int buy, int sell) {
            this.buy = buy; 
            this.sell = sell;
        }
    } 
    public void stockBuySell(int[] price, int n) {
        int j = 0;
        List<Interval> in = new ArrayList<Interval>();
        for (int i = 1; i < n; i++) {
            if (price[i] < price[i - 1]) {
                j = i;
            } else {
                if ((i + 1 == n && price[i] - price[j] > 0) || price[i] > price[i + 1]) {
                    in.add(new Interval(j, i));
                }
            }
        }
        if (in.isEmpty()) {
            System.out.print("No Profit");
        } else {
            for (Interval each : in) {
                System.out.print("(" + each.buy + " " + each.sell + ") ");
            }
        }
        System.out.println("");
    }
}
